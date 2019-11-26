package com.bfby.zxjl.ui.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bfby.zxjl.Bean.WaybillListBean;
import com.bfby.zxjl.R;
import com.bfby.zxjl.ui.activity.WaybillDetailsActivity;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2018/10/26.
 */

public class WaybillListAdapter extends RecyclerView.Adapter<WaybillListAdapter.WaybillViewHolder> {
    private Context mContext;
    private ArrayList<WaybillListBean.RowsBean> mWaybillListBean;
    private WaybillListBean.RowsBean mWaybillBean;

    public WaybillListAdapter(Context context, ArrayList<WaybillListBean.RowsBean> waybillListBean) {
        this.mContext = context;
        this.mWaybillListBean = waybillListBean;
    }


    @Override
    public WaybillViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_waybill, parent, false);
        WaybillViewHolder viewHolder = new WaybillViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(WaybillViewHolder holder, final int position) {
        mWaybillBean = mWaybillListBean.get(position);

        holder.mWaybillNumber.setText(mWaybillBean.getWaybillNo());
        holder.mStartArea.setText(mWaybillBean.getConsignerProvince() + mWaybillBean.getConsignerCity()+mWaybillBean.getConsignerArea());
        holder.mEndArea.setText(mWaybillBean.getReceiverProvince()+mWaybillBean.getReceiverCity()+mWaybillBean.getReceiverArea());
        holder.mWaybillGoods.setText(mWaybillBean.getGoodsName() + "/" + mWaybillBean.getGoodsWeight()+"公斤/" + mWaybillBean.getGoodsvolume()+"方");

        //待处理 = 1,待确认 = 2,已撤销 = 3,进行中 = 4,待完成 = 5,已完成 = 6,异常 = 8
        switch (mWaybillBean.getWaybillStatus()){
            case 1:
                holder.mWaybillStatusText.setText("待处理");
                break;
            case 2:
                holder.mWaybillStatusText.setText("待确认");
                break;
            case 3:
                holder.mWaybillStatusText.setText("已撤销");
                break;
            case 4:
                holder.mWaybillStatusText.setText("进行中");
                break;
            case 5:
                holder.mWaybillStatusText.setText("待完成");
                break;
            case 6:
                holder.mWaybillStatusText.setText("已完成");
                break;
            case 8:
                holder.mWaybillStatusText.setText("异常");
                break;
        }

        holder.mWaybillFahuoTime.setText(mWaybillBean.getPCarTime());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, WaybillDetailsActivity.class);
                intent.putExtra("waybillId", mWaybillListBean.get(position).get_ukid());
                mContext.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mWaybillListBean == null ? 0 : mWaybillListBean.size();
    }

    class WaybillViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.waybill_number_text)
        TextView mWaybillNumberText;
        @BindView(R.id.waybill_number)
        TextView mWaybillNumber;
        @BindView(R.id.start_area)
        TextView mStartArea;
        @BindView(R.id.end_area)
        TextView mEndArea;
        @BindView(R.id.waybill_goods)
        TextView mWaybillGoods;
        @BindView(R.id.waybill_fahuo_time)
        TextView mWaybillFahuoTime;
        @BindView(R.id.status_text)
        TextView mStatusText;
        @BindView(R.id.waybill_status_text)
        TextView mWaybillStatusText;

        public WaybillViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }

    }

}
