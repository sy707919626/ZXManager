package com.bfby.zxjl.ui.activity;

import android.support.constraint.Guideline;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bfby.zxjl.Bean.WaybillDetailBean;
import com.bfby.zxjl.R;
import com.bfby.zxjl.common.rx.RxHttpResponseCompatTest;
import com.bfby.zxjl.common.rx.subscriber.ErrorHandlerSubscriber;
import com.bfby.zxjl.ui.base.BaseActivity;
import com.gyf.barlibrary.ImmersionBar;
import butterknife.BindView;

public class WaybillDetailsActivity extends BaseActivity {

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
    @BindView(R.id.waybill_no_text)
    TextView mWaybillNoText;
    @BindView(R.id.waybill_no)
    TextView mWaybillNo;
    @BindView(R.id.waybill_state_text)
    TextView mWaybillStateText;
    @BindView(R.id.waybill_state)
    TextView mWaybillState;
    @BindView(R.id.image_line)
    ImageView mImageLine;
    @BindView(R.id.image_start_area)
    ImageView mImageStartArea;
    @BindView(R.id.start_area_text)
    TextView mStartAreaText;
    @BindView(R.id.start_area_quxian)
    TextView mStartAreaQuxian;
    @BindView(R.id.start_area_details)
    TextView mStartAreaDetails;
    @BindView(R.id.image_end_area)
    ImageView mImageEndArea;
    @BindView(R.id.end_area_text)
    TextView mEndAreaText;
    @BindView(R.id.end_area_quxian)
    TextView mEndAreaQuxian;
    @BindView(R.id.end_area_details)
    TextView mEndAreaDetails;
    @BindView(R.id.image_line2)
    ImageView mImageLine2;
    @BindView(R.id.guide)
    Guideline mGuide;
    @BindView(R.id.waybill_goods_text)
    TextView mWaybillGoodsText;
    @BindView(R.id.waybill_goods)
    TextView mWaybillGoods;
    @BindView(R.id.waybill_weight_text)
    TextView mWaybillWeightText;
    @BindView(R.id.waybill_weight)
    TextView mWaybillWeight;
    @BindView(R.id.waybill_volume_text)
    TextView mWaybillVolumeText;
    @BindView(R.id.waybill_volume)
    TextView mWaybillVolume;
    @BindView(R.id.waybill_carask_text)
    TextView mWaybillCaraskText;
    @BindView(R.id.waybill_carask)
    TextView mWaybillCarask;
    @BindView(R.id.waybill_startTime_text)
    TextView mWaybillStartTimeText;
    @BindView(R.id.waybill_startTime)
    TextView mWaybillStartTime;
    @BindView(R.id.waybill_kaipiao_text)
    TextView mWaybillKaipiaoText;
    @BindView(R.id.waybill_kaipiao)
    TextView mWaybillKaipiao;
    @BindView(R.id.kaipiao_btn)
    Button mKaipiaoBtn;
    @BindView(R.id.waybill_jiesuan_text)
    TextView mWaybillJiesuanText;
    @BindView(R.id.waybill_jiesuan)
    TextView mWaybillJiesuan;
    @BindView(R.id.waybill_remark_text)
    TextView mWaybillRemarkText;
    @BindView(R.id.waybill_remark)
    TextView mWaybillRemark;
    @BindView(R.id.waybill_yunfei_text)
    TextView mWaybillYunfeiText;
    @BindView(R.id.waybill_yunfei)
    TextView mWaybillYunfei;
    @BindView(R.id.waybill_shuifei_text)
    TextView mWaybillShuifeiText;
    @BindView(R.id.waybill_shuifei)
    TextView mWaybillShuifei;
    @BindView(R.id.waybill_yufu_text)
    TextView mWaybillYufuText;
    @BindView(R.id.waybill_yufu)
    TextView mWaybillYufu;
    @BindView(R.id.waybill_yingfu_text)
    TextView mWaybillYingfuText;
    @BindView(R.id.waybill_yingfu)
    TextView mWaybillYingfu;
    @BindView(R.id.waybill_carNo_text)
    TextView mWaybillCarNoText;
    @BindView(R.id.waybill_carNo)
    TextView mWaybillCarNo;
    @BindView(R.id.waybill_diaodu_text)
    TextView mWaybillDiaoduText;
    @BindView(R.id.waybill_diaodu)
    TextView mWaybillDiaodu;
    @BindView(R.id.waybill_diaodu_phone_text)
    TextView mWaybillDiaoduPhoneText;
    @BindView(R.id.waybill_diaodu_phone)
    TextView mWaybillDiaoduPhone;
    private String mWaybilId;

    @Override
    protected int setLayoutId() {
        return R.layout.waybill_details_activity;
    }

    @Override
    protected void init() {
        ImmersionBar.with(this)
                .titleBar(R.id.base_bar_title)
                .navigationBarColor(R.color.toolbarBG)
                .init();
        mTextDetailContent.setText("运单详情");
        mTextDetailRight.setVisibility(View.GONE);
        mWaybilId = getIntent().getStringExtra("waybillId");
        getData();
    }

    private void getData() {
        mApi.GetWaybillItem(mWaybilId)
                .compose(RxHttpResponseCompatTest.<WaybillDetailBean>compatResult())
                .subscribe(new ErrorHandlerSubscriber<WaybillDetailBean>() {
                    @Override
                    public void onNext(WaybillDetailBean waybillDetailBean) {
                        initView(waybillDetailBean);
                    }
                });
    }

    private void initView(WaybillDetailBean waybillDetailBean) {
        mWaybillNo.setText(waybillDetailBean.getWayBillNo());

        switch (waybillDetailBean.getWaybillSatus()) {
            case 1:
                mWaybillState.setText("待处理");
                break;
            case 2:
                mWaybillState.setText("待确认");
                break;
            case 3:
                mWaybillState.setText("已撤销");
                break;
            case 4:
                mWaybillState.setText("进行中");
                break;
            case 5:
                mWaybillState.setText("待完成");
                break;
            case 6:
                mWaybillState.setText("已完成");
                break;
            case 8:
                mWaybillState.setText("异常");
                break;
        }

        mStartAreaQuxian.setText(waybillDetailBean.getLoadName());
        mStartAreaDetails.setText(waybillDetailBean.getLoadAddress());
        mEndAreaQuxian.setText(waybillDetailBean.getUnLoadName());
        mEndAreaDetails.setText(waybillDetailBean.getUnLoadAddress());

        mWaybillGoods.setText(waybillDetailBean.getGoodsName());
        mWaybillWeight.setText(waybillDetailBean.getGoodsWeight() + "公斤");
        mWaybillVolume.setText(waybillDetailBean.getGoodsVolume() + "方");

        mWaybillKaipiao.setText(waybillDetailBean.getIsTicket());
        mWaybillRemark.setText(waybillDetailBean.getRemark());//备注

        mWaybillYunfei.setText(waybillDetailBean.getOrderTotalFee() + "元");
        mWaybillShuifei.setText(waybillDetailBean.getTaxFee() + "元");
        mWaybillYufu.setText(waybillDetailBean.getWaybillPreFee() + "元");
        mWaybillYingfu.setText(waybillDetailBean.getWaybillPayFee()+"元");
        mWaybillCarNo.setText(waybillDetailBean.getDriverNo());
        mWaybillCarask.setText(waybillDetailBean.getVechileTypeName()+"/"+ waybillDetailBean.getVechileLength() + "米/载重"+waybillDetailBean.getVechileWeight()+"吨");
        mWaybillDiaodu.setText(waybillDetailBean.getDriverName());
        mWaybillDiaoduPhone.setText(waybillDetailBean.getDriverPhone());
        mWaybillStartTime.setText(waybillDetailBean.getSendTime());
    }

}
