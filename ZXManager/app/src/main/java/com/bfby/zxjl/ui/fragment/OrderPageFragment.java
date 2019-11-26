package com.bfby.zxjl.ui.fragment;

import android.annotation.SuppressLint;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.bfby.zxjl.Bean.OrderBean;
import com.bfby.zxjl.R;
import com.bfby.zxjl.common.constan.GlobalParams;
import com.bfby.zxjl.common.rx.RxHttpResponseCompatTest;
import com.bfby.zxjl.common.rx.subscriber.ErrorHandlerSubscriber;
import com.bfby.zxjl.ui.adapter.OrderRecepitListAdapter;
import com.bfby.zxjl.ui.base.BaseLazyFragment;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadmoreListener;

import java.util.ArrayList;
import butterknife.BindView;
import okhttp3.MediaType;
import okhttp3.RequestBody;

@SuppressLint("ValidFragment")
public class OrderPageFragment extends BaseLazyFragment {
    @BindView(R.id.Order_RecyclerView)
    RecyclerView mOrderRecyclerView;
    @BindView(R.id.smartRefresh_Layout)
    SmartRefreshLayout mSmartRefreshLayout;
    private boolean isRefresh; //刷新

    private int pageSize = 10;
    private int page = 1;

    private OrderRecepitListAdapter mOrderRecepitListAdapter;

    private ArrayList<OrderBean.RowsBean> mOrderListBean = new ArrayList<>();
    private String Status;

    public OrderPageFragment(String status) {
        Status = status;
    }

    @Override
    public void getData() {
        RequestBody body = RequestBody.create(MediaType.parse("text/json; charset=utf-8"),
                "{}");

        mApi.GetMyOrderList(GlobalParams.sUserId,body, page, pageSize)
                .compose(RxHttpResponseCompatTest.<OrderBean>compatResult())
                .subscribe(new ErrorHandlerSubscriber<OrderBean>() {
                    @Override
                    public void onNext(OrderBean orderBean) {
                        if (isRefresh) {
                            mOrderListBean.clear();
                        }

                        mOrderListBean.addAll(orderBean.getRows());

                        if (mOrderRecepitListAdapter != null) {
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

    @Override
    protected int setLayoutId() {
        return R.layout.fragment_orderpage;
    }

    @Override
    protected void init() {
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
        mOrderRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mOrderRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        mOrderRecepitListAdapter = new OrderRecepitListAdapter(getContext(), mOrderListBean, mApi);
        mOrderRecyclerView.setAdapter(mOrderRecepitListAdapter);

    }

}
