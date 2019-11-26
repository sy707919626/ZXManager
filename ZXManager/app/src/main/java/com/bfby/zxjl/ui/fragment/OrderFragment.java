package com.bfby.zxjl.ui.fragment;

import android.content.Context;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bfby.zxjl.Bean.OrderBean;
import com.bfby.zxjl.R;
import com.bfby.zxjl.common.constan.GlobalParams;
import com.bfby.zxjl.common.rx.RxHttpResponseCompatTest;
import com.bfby.zxjl.common.rx.subscriber.ErrorHandlerSubscriber;
import com.bfby.zxjl.ui.adapter.OrderRecepitListAdapter;
import com.bfby.zxjl.ui.base.BaseLazyFragment;
import com.bfby.zxjl.ui.event.MessageEvent;
import com.gyf.barlibrary.ImmersionBar;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadmoreListener;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;

import butterknife.BindView;
import okhttp3.MediaType;
import okhttp3.RequestBody;

public class OrderFragment extends BaseLazyFragment {

    @BindView(R.id.text_base_content)
    TextView mTextBaseContent;
    @BindView(R.id.iv_base_code)
    ImageView mIvBaseCode;
    @BindView(R.id.title_base_toolbar)
    Toolbar mTitleBaseToolbar;
    @BindView(R.id.base_order_title)
    LinearLayout mBaseOrderTitle;
    @BindView(R.id.Order_RecyclerView)
    RecyclerView mOrderRecyclerView;
    @BindView(R.id.smartRefresh_Layout)
    SmartRefreshLayout mSmartRefreshLayout;

    private boolean isRefresh; //刷新

    private int pageSize = 10;
    private int page = 1;

    private OrderRecepitListAdapter mOrderRecepitListAdapter;

    private ArrayList<OrderBean.RowsBean> mOrderListBean = new ArrayList<>();

    @Override
    protected int setLayoutId() {
        return R.layout.fragment_order;
    }

    @Override
    protected void init() {
        ImmersionBar.with(getActivity())
                .titleBar(R.id.base_order_title)
                .navigationBarColor(R.color.toolbarBG)
                .init();

        mTextBaseContent.setText("订单大厅");
        mIvBaseCode.setVisibility(View.GONE);

        runLayoutAnimation(mOrderRecyclerView);

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


    private void runLayoutAnimation(final RecyclerView recyclerView) {
        final Context context = recyclerView.getContext();

        final LayoutAnimationController controller =
                AnimationUtils.loadLayoutAnimation(context, R.anim.layout_animation_fall_down);

        recyclerView.setLayoutAnimation(controller);
        recyclerView.scheduleLayoutAnimation();

    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(MessageEvent e){
        String msg = e.getMessage();
        if(msg.equals("refreshOrder")){
            isRefresh = true;
            page = 1;
            getData();
        }
    }

    @Override
    public void getData() {
        RequestBody body = RequestBody.create(MediaType.parse("text/json; charset=utf-8"),
                "{}");

        mApi.GetMyOrderList(GlobalParams.sUserId, body, page, pageSize)
                .compose(RxHttpResponseCompatTest.<OrderBean>compatResult())
                .subscribe(new ErrorHandlerSubscriber<OrderBean>() {
                    @Override
                    public void onNext(OrderBean orderBean) {
                        if (isRefresh) {
                            mOrderListBean.clear();
                        }

                        mOrderListBean.addAll(orderBean.getRows());

                        if (mOrderRecepitListAdapter != null) {
                            runLayoutAnimation(mOrderRecyclerView);
                            mOrderRecepitListAdapter.notifyDataSetChanged();
                        }

                        if (mOrderListBean.size() == orderBean.getTotal()) {

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

    private void initView() {
        mOrderRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mOrderRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        mOrderRecepitListAdapter = new OrderRecepitListAdapter(getContext(), mOrderListBean, mApi);
        mOrderRecyclerView.setAdapter(mOrderRecepitListAdapter);

    }
}
