package com.bfby.zxjl.ui.activity;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.FileProvider;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.bfby.zxjl.Bean.AppVersionBean;
import com.bfby.zxjl.Bean.TaskInfo;
import com.bfby.zxjl.R;
import com.bfby.zxjl.ui.DownloadRunnable;
import com.bfby.zxjl.ui.base.BaseActivity;
import com.bfby.zxjl.ui.dialog.LevelDialog;
import com.bfby.zxjl.ui.fragment.MeFragment;
import com.bfby.zxjl.ui.fragment.OrderFragment;
import com.bfby.zxjl.ui.fragment.WaybillFragment;
import com.gyf.barlibrary.ImmersionBar;

import java.io.File;

import butterknife.BindView;

public class MainActivity extends BaseActivity implements RadioGroup.OnCheckedChangeListener {
    @BindView(R.id.main_content)
    FrameLayout mMainContent;
    @BindView(R.id.tab_separate_imgv)
    ImageView mTabSeparateImgv;
    @BindView(R.id.rbtn_home)
    RadioButton mRbtnHome;
    @BindView(R.id.rbtn_order)
    RadioButton mRbtnOrder;
    @BindView(R.id.rbtn_mine)
    RadioButton mRbtnMine;
    @BindView(R.id.radioGroup)
    RadioGroup mRadioGroup;

    LevelDialog dialog;
    private TaskInfo info;//任务信息
    private DownloadRunnable runnable;//下载任务
    public static final int INDEX_DIS = 0;
    public static final int INDEX_ORDER = 1;
    public static final int INDEX_MINE = 2;

    FragmentManager mFragmentManager;
    OrderFragment mOrderFragment;
    WaybillFragment mWaybillFragment;
    MeFragment mMineFragment;
    private Fragment currentFragment = new Fragment();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int setLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void init() {
        ImmersionBar.with(this).init();
        initView();

        verifyStoragePermissions(this);
//        checkUpdate(); //版本升级
    }

    private void initView() {
        mFragmentManager = getSupportFragmentManager();
        mOrderFragment = new OrderFragment();
        mWaybillFragment  = new WaybillFragment();
        mMineFragment  = new MeFragment();


        mRadioGroup.setOnCheckedChangeListener(this);
        setSelectIndex(INDEX_DIS);
    }


    @Override
    protected void onDestroy() {
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            handler = null;
        }
        super.onDestroy();
    }


    public static void verifyStoragePermissions(Activity activity) {
        //6.0系统以上动态申请读写权限
        if (ContextCompat.checkSelfPermission(activity,
                Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(activity,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
            } else {
                ActivityCompat.requestPermissions(activity,
                        new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE,
                                Manifest.permission.READ_EXTERNAL_STORAGE}, 1);
            }
        }
    }

    /**
     * 上传app资料和  检测app更新
     */
    private AppVersionBean mAppVersionBean;

    private void checkUpdate() {
//        mApi.GetAppVersion(GlobalParams.sToken)
//                .compose(RxHttpResponseCompat.<String>compatResult())
//                .subscribe(new ErrorHandlerSubscriber<String>() {
//                    @Override
//                    public void onNext(String s) {
//
//                        mAppVersionBean = MyApplication.get().getGson().fromJson(s, AppVersionBean.class);
//
//                        if (Integer.valueOf(mAppVersionBean.getMinVersionCode()) >
//                                ProjectUtil.getVersionCode(mContext)) {
//
//                            dialog = new LevelDialog(MainActivity.this, new LevelDialog.OnLevelListener() {
//                                @Override
//                                public void onClick(Dialog dialog, boolean confirm) {
//                                    downapk("http://" + mAppVersionBean.getDownLoadUrl());
//                                }
//                            });
//                            dialog.setCanceledOnTouchOutside(true);
//                            dialog.show();
//                            dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
//                            dialog.downBtn.setCurrentText("立即升级");
//                        }
//
//                    }
//                });

    }

    /**
     * apk下载安装
     *
     * @param url
     */
    private void downapk(String url) {
        verifyStoragePermissions(MainActivity.this);

//        long id = downloadManager.enqueue(request);
        info = new TaskInfo("zyb.apk", Environment.getExternalStorageDirectory().getAbsolutePath() + "/", url);
        dialog.downBtn.setClickable(false);
        start(dialog.downBtn);

    }

    public void start(View view) {
        //创建下载任务
        runnable = new DownloadRunnable(info);
        //开始下载任务
        new Thread(runnable).start();
        //开始Handler循环
        handler.sendEmptyMessageDelayed(1, 200);
    }

    /**
     * 停止下载按钮监听
     *
     * @param view
     */
    public void stop(View view) {
        //调用DownloadRunnable中的stop方法，停止下载
        runnable.stop();
        runnable = null;//强迫症，不用的对象手动置空
    }


    private Handler handler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {
            //使用Handler制造一个200毫秒为周期的循环
            handler.sendEmptyMessageDelayed(1, 200);
            //计算下载进度
            int l = (int) ((float) info.getCompleteLen() / (float) info.getContentLen() * 100);
            //设置进度条进度
//            bar.setProgress(l);
            dialog.downBtn.setState(dialog.downBtn.STATE_DOWNLOADING);
            dialog.downBtn.setProgressText("", l);
            if (l >= 100) {//当进度>=100时，取消Handler循环
                handler.removeCallbacksAndMessages(null);
                dialog.downBtn.setCurrentText("安装中...");
                installApk();
            }
            return true;
        }
    });

    private void installApk() {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        String filePath = Environment.getExternalStorageDirectory().getAbsolutePath() + "/" + "zyb.apk";
        File file = new File(filePath);
        Uri data;

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            // "net.csdn.blog.ruancoder.fileprovider"即是在清单文件中配置的authorities
            data = FileProvider.getUriForFile(mContext, "com.lulian.Zaiyunbao.fileProvider", file);
            // 给目标应用一个临时授权
            intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        } else {
            data = Uri.fromFile(file);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        }
        intent.setDataAndType(data, "application/vnd.android.package-archive");
        startActivity(intent);
    }

    public void showFragment(Fragment fragment){
        if (currentFragment != fragment){
            FragmentTransaction transaction = mFragmentManager.beginTransaction();

            transaction.hide(currentFragment);
            currentFragment = fragment;

            if (!fragment.isAdded()) {
                transaction.add(R.id.main_content, fragment).show(fragment).commit();
            } else {
                transaction.show(fragment).commit();
            }
        }
    }

    public void setSelectIndex(int index) {
        switch (index) {
            case INDEX_DIS:
                showFragment(mOrderFragment);
                mRbtnHome.setTextColor(getResources().getColor(R.color.radio_color_select));
                mRbtnOrder.setTextColor(getResources().getColor(R.color.radio_color));
                mRbtnMine.setTextColor(getResources().getColor(R.color.radio_color));


                break;
            case INDEX_ORDER:
                showFragment(mWaybillFragment);
                mRbtnHome.setTextColor(getResources().getColor(R.color.radio_color));
                mRbtnOrder.setTextColor(getResources().getColor(R.color.radio_color_select));
                mRbtnMine.setTextColor(getResources().getColor(R.color.radio_color));
                break;

            case INDEX_MINE:
                showFragment(mMineFragment);
                mRbtnHome.setTextColor(getResources().getColor(R.color.radio_color));
                mRbtnOrder.setTextColor(getResources().getColor(R.color.radio_color));
                mRbtnMine.setTextColor(getResources().getColor(R.color.radio_color_select));
                break;
        }
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
        switch (checkedId) {
            case R.id.rbtn_home:
                setSelectIndex(INDEX_DIS);
                break;

            case R.id.rbtn_order:
                setSelectIndex(INDEX_ORDER);
                break;

            case R.id.rbtn_mine:
                setSelectIndex(INDEX_MINE);
                break;
        }
    }

}
