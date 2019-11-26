package com.bfby.zxjl.ui.activity;

import android.content.Intent;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.alibaba.fastjson.JSONObject;
import com.bfby.zxjl.Bean.DriverListBean;
import com.bfby.zxjl.R;
import com.bfby.zxjl.common.constan.GlobalParams;
import com.bfby.zxjl.common.rx.RxHttpResponseCompat;
import com.bfby.zxjl.common.rx.subscriber.ErrorHandlerSubscriber;
import com.bfby.zxjl.common.widget.RxToast;
import com.bfby.zxjl.ui.adapter.SelectCarAdapter;
import com.bfby.zxjl.ui.base.BaseActivity;
import com.gyf.barlibrary.ImmersionBar;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadmoreListener;
import java.util.ArrayList;

import butterknife.BindView;
import okhttp3.MediaType;
import okhttp3.RequestBody;

public class SelectCarListActivity extends BaseActivity {

    @BindView(R.id.image_back_detail_bar)
    ImageView mImageBackDetailBar;
    @BindView(R.id.text_detail_content)
    TextView mTextDetailContent;
    @BindView(R.id.text_detail_right)
    TextView mTextDetailRight;
    @BindView(R.id.title_base_toolbar)
    Toolbar mTitleBaseToolbar;
    @BindView(R.id.detail_bar_title)
    LinearLayout mDetailBarTitle;
    @BindView(R.id.car_RecyclerView)
    RecyclerView mCarRecyclerView;
    @BindView(R.id.smartRefresh_Layout)
    SmartRefreshLayout mSmartRefreshLayout;
    @BindView(R.id.waybill_sure_btn)
    Button mWaybillSureBtn;

    private ArrayList<DriverListBean.RowsBean> mDriverListBean = new ArrayList<>();

    private DriverListBean.RowsBean mDriver = null;

    private SelectCarAdapter mSelectCarAdapter;
    private boolean isCheckCar = false;
    private boolean isRefresh; //刷新
    private int pageSize = 10;
    private int page = 1;

    private String mVehicleid;
    @Override
    protected int setLayoutId() {
        return R.layout.select_carlist_activity;
    }

    @Override
    protected void init() {
        ImmersionBar.with(this)
                .titleBar(R.id.base_bar_title)
                .navigationBarColor(R.color.toolbarBG)
                .init();

        mTextDetailContent.setText("选择司机");
        mTextDetailRight.setVisibility(View.GONE);
        getData();

        isRefresh = true;
        mSmartRefreshLayout.setOnRefreshLoadmoreListener(new OnRefreshLoadmoreListener() {
            @Override
            public void onLoadmore(RefreshLayout refreshlayout) {
                isRefresh = false;
                page++;
                getData();
            }

            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                isRefresh = true;
                page = 1;
                mSmartRefreshLayout.setLoadmoreFinished(false); //再次触发加载更多事件
                getData();
            }
        });

        initView();
    }

    private void initView() {
        mCarRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mCarRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        mSelectCarAdapter = new SelectCarAdapter(this, mDriverListBean);
        mCarRecyclerView.setAdapter(mSelectCarAdapter);

        mSelectCarAdapter.setOnItemClickListener(new SelectCarAdapter.OnItemClickListener() {
            @Override
            public void onItemClickListener(DriverListBean.RowsBean driver) {
                mDriver = driver;

            }
        });

        mWaybillSureBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mDriver == null){
                    RxToast.warning("请选择司机");
                } else {
                    Intent intent = new Intent();
                    intent.putExtra("driverInfo", mDriver);

//                intent.putExtra("userName", mDriver.getUser_Name());
//                intent.putExtra("VNo", mDriver.getVNo());
//                intent.putExtra("userPhone", mDriver.getUser_Phone());
//                intent.putExtra("userStar", mDriver.getUser_Star());
//                intent.putExtra("VehicleTypeName", mDriver.getVehicleTypeName());
//                intent.putExtra("VLength", mDriver.getVLength());
//                intent.putExtra("VWeight", mDriver.getVWeight());
                    setResult(RESULT_OK, intent);
                    finish();
                }
            }
        });
    }

    private void getData() {
        RequestBody body = RequestBody.create(MediaType.parse("text/json; charset=utf-8"),
                "{}");

        mApi.GetMyDriverList(GlobalParams.sUserId, body, page, pageSize)
                .compose(RxHttpResponseCompat.<String>compatResult())
                .subscribe(new ErrorHandlerSubscriber<String>() {
                    @Override
                    public void onNext(String data) {
                        DriverListBean driverList = JSONObject.parseObject(data, DriverListBean.class);

                        if (isRefresh) {
                            mDriverListBean.clear();
                        }

                        mDriverListBean.addAll(driverList.getRows());

                        if (mSelectCarAdapter != null) {
                            mSelectCarAdapter.notifyDataSetChanged();
                        }

                        if (mDriverListBean.size() == driverList.getTotal()) {
                            mSmartRefreshLayout.finishLoadmoreWithNoMoreData(); //将不会再次触发加载更多事件
                        }
                    }

                    @Override
                    protected void onAfter() {
                        super.onAfter();
                        mSmartRefreshLayout.finishRefresh();
                        mSmartRefreshLayout.finishLoadmore();
                    }
                });
    }

}
