package com.bfby.zxjl.ui.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bfby.zxjl.Bean.DriverListBean;
import com.bfby.zxjl.R;
import com.bfby.zxjl.common.widget.ProjectUtil;
import com.bfby.zxjl.ui.activity.CarInfoActivity;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.zhanghai.android.materialratingbar.MaterialRatingBar;

/**
 * Created by Administrator on 2018/10/26.
 */

public class SelectCarAdapter extends RecyclerView.Adapter<SelectCarAdapter.SelectCarHolder> {

    private OnItemClickListener mOnItemClickListener;

    private Context mContext;
    private String mStatus;
    private int selectPostion = -1; //记录选中的勾选框的position
    private ArrayList<DriverListBean.RowsBean> mDriverListBean;
    private DriverListBean.RowsBean mDriver;

    public SelectCarAdapter(Context context, ArrayList<DriverListBean.RowsBean> driverListBean) {
        mContext = context;
        this.mDriverListBean = driverListBean;
    }

    @Override
    public SelectCarHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_select_car, parent, false);
        SelectCarHolder viewHolder = new SelectCarHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(SelectCarHolder holder, final int position) {
        mDriver = mDriverListBean.get(position);
        boolean isChecked = selectPostion == position;
        holder.mCheckBoxCar.setChecked(isChecked);

        holder.mWaybillCyName.setText(mDriver.getUser_Name());
        holder.mWaybillCarNo.setText(mDriver.getVNo());
        holder.mWaybillCarPhone.setText(mDriver.getUser_Phone());
        holder.mRatingbar.setRating(mDriver.getUser_Star());
        holder.mWaybillCyCar.setText(mDriver.getVehicleTypeName() + "/" + mDriver.getVLength() + "米/载重" + mDriver.getVWeight());


        Log.e("tosttrrrr:  ", mDriver.getVehicleId()+"");
        holder.mCarPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ProjectUtil.checkCallPhone((Activity) mContext, mDriver.getUser_Phone());
            }
        });

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, CarInfoActivity.class);
                intent.putExtra("driverId", mDriver.getDriverId());
                mContext.startActivity(intent);
            }
        });


        holder.mCheckBoxCar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectPostion = position;
                notifyDataSetChanged();

                mOnItemClickListener.onItemClickListener(mDriverListBean.get(selectPostion));
            }
        });
    }

    @Override
    public int getItemCount() {
        return mDriverListBean == null ? 0 : mDriverListBean.size();
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.mOnItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener {
        void onItemClickListener(DriverListBean.RowsBean mDriver);
    }

    class SelectCarHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.waybill_cy_name_text)
        TextView mWaybillCyNameText;
        @BindView(R.id.waybill_cy_name)
        TextView mWaybillCyName;
        @BindView(R.id.ratingbar_text)
        TextView mRatingbarText;
        @BindView(R.id.ratingbar)
        MaterialRatingBar mRatingbar;
        @BindView(R.id.waybill_car_no_text)
        TextView mWaybillCarNoText;
        @BindView(R.id.waybill_car_no)
        TextView mWaybillCarNo;
        @BindView(R.id.waybill_cy_car_text)
        TextView mWaybillCyCarText;
        @BindView(R.id.waybill_cy_car)
        TextView mWaybillCyCar;
        @BindView(R.id.waybill_car_phone_text)
        TextView mWaybillCarPhoneText;
        @BindView(R.id.waybill_car_phone)
        TextView mWaybillCarPhone;
        @BindView(R.id.car_phone)
        ImageView mCarPhone;
        @BindView(R.id.checkBox_car)
        CheckBox mCheckBoxCar;
        @BindView(R.id.layout_person_rz)
        LinearLayout mLayoutPersonRz;
        @BindView(R.id.layout_company_rz)
        LinearLayout mLayoutCompanyRz;
        @BindView(R.id.car_info_linearLayout)
        LinearLayout mCarInfoLinearLayout;

        public SelectCarHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }

    }

}
