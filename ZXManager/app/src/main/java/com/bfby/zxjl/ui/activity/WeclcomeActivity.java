package com.bfby.zxjl.ui.activity;

import android.content.Intent;
import android.widget.ImageView;

import com.bfby.zxjl.R;
import com.bfby.zxjl.ui.base.BaseActivity;
import com.gyf.barlibrary.BarHide;
import com.gyf.barlibrary.ImmersionBar;

import java.util.Timer;
import java.util.TimerTask;

import butterknife.BindView;

import static com.alibaba.fastjson.JSON.parseArray;

/**
 * Created by Administrator on 2018/9/18.
 */

public class WeclcomeActivity extends BaseActivity {
    @BindView(R.id.weclcome_img)
    ImageView weclcomeImg;
    private boolean isSuccessToken = false;

    @Override
    protected int setLayoutId() {
        return R.layout.activity_weclcome;
    }

    @Override
    protected void init() {
        ImmersionBar.with(this)
                .hideBar(BarHide.FLAG_HIDE_BAR)
                .init();

//        //	注意：这里就是创建了Animation对象，关联了刚才写的anim文件里的东西
//        Animation anim= AnimationUtils.loadAnimation(this, R.anim.activity_rotate);
//        //	将ImageView对象执行动画就可以了
//        weclcomeImg.startAnimation(anim);


//        getDicItem();//获取字典
//        getEquipmentType();
        skipLogin();
    }


    private void skipLogin() {
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                startActivity(new Intent(WeclcomeActivity.this, LoginActivity.class));
                WeclcomeActivity.this.finish();
            }
        }, 3000);
    }
//
//    private void getEquipmentType() {
//        final List<String> SBTypeList = new ArrayList<>(); //设备类型
//
//        mApi.equipmentTypeList(GlobalParams.sToken)
//                .compose(RxHttpResponseCompat.<String>compatResult())
//                .compose(this.<String>bindUntilEvent(ActivityEvent.DESTROY))
//                .subscribe(new ErrorHandlerSubscriber<String>() {
//                    @Override
//                    public void onNext(String s) {
//
//                    }
//                });
//    }
//
//    private void getDicItem() {
//        final List<String> userTypeList = new ArrayList<>(); //用户类型
//        final List<String> FHTypeList = new ArrayList<>(); //发货类型
//        final List<String> JSTypeList = new ArrayList<>(); //结算类型
//        final List<String> ZLTypeList = new ArrayList<>();  //租赁模式
//        final List<String> ZFTypeList = new ArrayList<>();  //支付模式（购买）
//
//
//        mApi.GetDicItem(GlobalParams.sToken)
//                .compose(RxHttpResponseCompat.<String>compatResult())
//                .compose(this.<String>bindUntilEvent(ActivityEvent.DESTROY))
//                .subscribe(new ErrorHandlerSubscriber<String>() {
//                    @Override
//                    public void onNext(String s) {
//                        Log.e("asada", s);
//                    }
//                });
//    }
//

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

}
