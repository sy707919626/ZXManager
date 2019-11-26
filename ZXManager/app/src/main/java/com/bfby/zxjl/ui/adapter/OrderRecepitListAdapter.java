package com.bfby.zxjl.ui.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.bfby.zxjl.Bean.OrderBean;
import com.bfby.zxjl.R;
import com.bfby.zxjl.common.constan.GlobalParams;
import com.bfby.zxjl.common.rx.RxHttpResponseCompat;
import com.bfby.zxjl.common.rx.subscriber.ErrorHandlerSubscriber;
import com.bfby.zxjl.common.widget.RxToast;
import com.bfby.zxjl.data.http.ApiService;
import com.bfby.zxjl.ui.activity.DispatchCarActivity;
import com.bfby.zxjl.ui.activity.OrderDetailsActivity;
import com.bfby.zxjl.ui.dialog.ReceiptOrderDialog;
import com.bfby.zxjl.ui.event.MessageEvent;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2018/10/26.
 */

public class OrderRecepitListAdapter extends RecyclerView.Adapter<OrderRecepitListAdapter.EquipmentViewHolder> {

    private Context mContext;
    private ArrayList<OrderBean.RowsBean> mOrderListBean;
    private OrderBean.RowsBean orderInfo;
    private ApiService mApi;

    public OrderRecepitListAdapter(Context context, ArrayList<OrderBean.RowsBean> orderListBean, ApiService api) {
        this.mContext = context;
        this.mOrderListBean = orderListBean;
        this.mApi = api;
    }

    @Override
    public EquipmentViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_receipt_order, parent, false);
        EquipmentViewHolder viewHolder = new EquipmentViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(EquipmentViewHolder holder, final int position) {
        orderInfo = mOrderListBean.get(position);

        holder.mAllOrderNumber.setText(orderInfo.getOrderNo());
        holder.mFabuTime.setText(orderInfo.getCreateTime());
        holder.mStartArea.setText(orderInfo.getConsignerProvince());
        holder.mEndArea.setText(orderInfo.getReceiverProvince());
        holder.mOrderGoods.setText(orderInfo.getGoodsName() + "/" + orderInfo.getGoodsWeight() + "公斤/" +
                orderInfo.getGoodsvolume() + "方");
        holder.mFahuoTime.setText(orderInfo.getSendTime());
        holder.mOrderOffer.setText(orderInfo.getOrderTotalFee() + "元");

        switch (orderInfo.getOrderStatus()){
            case 1:
                holder.mOrderStatu.setText("待处理");
                break;
            case 2:
                holder.mOrderStatu.setText("待确认");
                break;
            case 3:
                holder.mOrderStatu.setText("已撤销");
                break;
            case 4:
                holder.mOrderStatu.setText("进行中");
                break;
            case 5:
                holder.mOrderStatu.setText("待完成");
                break;
            case 6:
                holder.mOrderStatu.setText("已完成");
                break;
            case 7:
                holder.mOrderStatu.setText("异常");
                break;
            case 8:
                holder.mOrderStatu.setText(" 派单中");
                break;
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, OrderDetailsActivity.class);
                intent.putExtra("orderId", mOrderListBean.get(position).get_ukid());
                mContext.startActivity(intent);
            }
        });

        if (orderInfo.getOrderStatus()== 1) {
            holder.mOrderBtnWancheng.setVisibility(View.GONE);
            holder.mOrderBtn.setVisibility(View.VISIBLE);
            holder.mOrderBtn.setText("确认接单");

            holder.mOrderBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(mContext, ReceiptOrderDialog.class);
                    intent.putExtra("orderId", mOrderListBean.get(position).get_ukid());
                    intent.putExtra("fee", mOrderListBean.get(position).getOrderFee());
                    mContext.startActivity(intent);
                }
            });

        } else if (orderInfo.getOrderStatus()== 4) {
            holder.mOrderBtnWancheng.setVisibility(View.VISIBLE);
            holder.mOrderBtn.setVisibility(View.VISIBLE);
            holder.mOrderBtn.setText("确认派车");
            holder.mOrderBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(mContext, DispatchCarActivity.class);
                    intent.putExtra("orderId", mOrderListBean.get(position).get_ukid());
                    intent.putExtra("orderNo", mOrderListBean.get(position).getOrderNo());
                    intent.putExtra("startArea", mOrderListBean.get(position).getConsignerProvince());
                    intent.putExtra("endArea", mOrderListBean.get(position).getReceiverProvince());
                    intent.putExtra("goodsName", mOrderListBean.get(position).getGoodsName());
                    intent.putExtra("goodsWeight", mOrderListBean.get(position).getGoodsWeight());
                    intent.putExtra("goodsvolume", mOrderListBean.get(position).getGoodsvolume());
                    intent.putExtra("sendTime", mOrderListBean.get(position).getSendTime());
                    intent.putExtra("fee", mOrderListBean.get(position).getOrderFee());
                    intent.putExtra("totalFee", mOrderListBean.get(position).getOrderTotalFee());
                    mContext.startActivity(intent);
                }
            });

            holder.mOrderBtnWancheng.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mApi.ComplateOrder(mOrderListBean.get(position).get_ukid(), GlobalParams.sUserId)
                            .compose(RxHttpResponseCompat.<String>compatResult())
                            .subscribe(new ErrorHandlerSubscriber<String>() {

                                @Override
                                public void onNext(String s) {
                                    RxToast.success("立即完成成功");
                                    EventBus.getDefault().post(new MessageEvent("refreshOrder"));
                                }
                            });
                }
            });

        } else {
            holder.mOrderBtnWancheng.setVisibility(View.GONE);
            holder.mOrderBtn.setVisibility(View.GONE);
        }
    }

    @Override
    public int getItemCount() {
        return mOrderListBean == null ? 0 : mOrderListBean.size();
    }

    class EquipmentViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.all_order_text)
        TextView mAllOrderText;
        @BindView(R.id.all_order_number)
        TextView mAllOrderNumber;
        @BindView(R.id.fabu_time_text)
        TextView mFabuTimeText;
        @BindView(R.id.fabu_time)
        TextView mFabuTime;
        @BindView(R.id.start_area)
        TextView mStartArea;
        @BindView(R.id.end_area)
        TextView mEndArea;
        @BindView(R.id.order_goods)
        TextView mOrderGoods;
        @BindView(R.id.fahuo_time_text)
        TextView mFahuoTimeText;
        @BindView(R.id.fahuo_time)
        TextView mFahuoTime;
        @BindView(R.id.order_statu)
        TextView mOrderStatu;
        @BindView(R.id.order_offer_text)
        TextView mOrderOfferText;
        @BindView(R.id.order_offer)
        TextView mOrderOffer;
        @BindView(R.id.order_btn_wancheng)
        Button mOrderBtnWancheng;
        @BindView(R.id.order_btn)
        Button mOrderBtn;

        public EquipmentViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }

    }

}
