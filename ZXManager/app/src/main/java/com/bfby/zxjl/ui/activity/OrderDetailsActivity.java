package com.bfby.zxjl.ui.activity;

import android.content.Intent;
import android.support.constraint.Guideline;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bfby.zxjl.Bean.OrderDetailsBean;
import com.bfby.zxjl.R;
import com.bfby.zxjl.common.constan.GlobalParams;
import com.bfby.zxjl.common.rx.RxHttpResponseCompat;
import com.bfby.zxjl.common.rx.RxHttpResponseCompatTest;
import com.bfby.zxjl.common.rx.subscriber.ErrorHandlerSubscriber;
import com.bfby.zxjl.common.widget.RxToast;
import com.bfby.zxjl.ui.base.BaseActivity;
import com.bfby.zxjl.ui.dialog.ReceiptOrderDialog;
import com.bfby.zxjl.ui.event.MessageEvent;
import com.gyf.barlibrary.ImmersionBar;

import org.greenrobot.eventbus.EventBus;

import butterknife.BindView;

public class OrderDetailsActivity extends BaseActivity {

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
    @BindView(R.id.order_no_text)
    TextView mOrderNoText;
    @BindView(R.id.order_no)
    TextView mOrderNo;
    @BindView(R.id.order_time)
    TextView mOrderTime;
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
    @BindView(R.id.order_goods_text)
    TextView mOrderGoodsText;
    @BindView(R.id.order_goods)
    TextView mOrderGoods;
    @BindView(R.id.order_weight_text)
    TextView mOrderWeightText;
    @BindView(R.id.order_weight)
    TextView mOrderWeight;
    @BindView(R.id.order_volume_text)
    TextView mOrderVolumeText;
    @BindView(R.id.order_volume)
    TextView mOrderVolume;
    @BindView(R.id.order_carask_text)
    TextView mOrderCaraskText;
    @BindView(R.id.order_carask)
    TextView mOrderCarask;
    @BindView(R.id.order_startTime_text)
    TextView mOrderStartTimeText;
    @BindView(R.id.order_startTime)
    TextView mOrderStartTime;
    @BindView(R.id.order_kaipiao_text)
    TextView mOrderKaipiaoText;
    @BindView(R.id.order_kaipiao)
    TextView mOrderKaipiao;
    @BindView(R.id.kaipiao_btn)
    Button mKaipiaoBtn;
    @BindView(R.id.order_jiesuan_text)
    TextView mOrderJiesuanText;
    @BindView(R.id.order_jiesuan)
    TextView mOrderJiesuan;
    @BindView(R.id.order_yunfei_text)
    TextView mOrderYunfeiText;
    @BindView(R.id.order_yunfei)
    TextView mOrderYunfei;
    @BindView(R.id.order_shuifei_text)
    TextView mOrderShuifeiText;
    @BindView(R.id.order_shuifei)
    TextView mOrderShuifei;
    @BindView(R.id.order_remark_text)
    TextView mOrderRemarkText;
    @BindView(R.id.order_remark)
    TextView mOrderRemark;
    @BindView(R.id.order_diaodu_text)
    TextView mOrderDiaoduText;
    @BindView(R.id.order_diaodu)
    TextView mOrderDiaodu;
    @BindView(R.id.order_diaodu_phone_text)
    TextView mOrderDiaoduPhoneText;
    @BindView(R.id.order_diaodu_phone)
    TextView mOrderDiaoduPhone;
    @BindView(R.id.order_wancheng_btn)
    Button mOrderWanchengBtn;
    @BindView(R.id.order_paiche_btn)
    Button mOrderPaicheBtn;
    @BindView(R.id.order_orderStuta_text)
    TextView mOrderOrderStutaText;
    @BindView(R.id.order_Stuta)
    TextView mOrderStuta;
    private String mStatus;

    private String mOrderId = "";
    private OrderDetailsBean mOrderDetailsBean;

    @Override
    protected int setLayoutId() {
        return R.layout.order_receipt_activity;
    }

    @Override
    protected void init() {
        ImmersionBar.with(this)
                .titleBar(R.id.base_bar_title)
                .navigationBarColor(R.color.toolbarBG)
                .init();

        mTextDetailContent.setText("订单详情");
        mTextDetailRight.setVisibility(View.GONE);

        mOrderId = getIntent().getStringExtra("orderId");

        getData();
    }

    private void getData() {
        mApi.GetOrderItem(mOrderId)
                .compose(RxHttpResponseCompatTest.<OrderDetailsBean>compatResult())
                .subscribe(new ErrorHandlerSubscriber<OrderDetailsBean>() {
                    @Override
                    public void onNext(OrderDetailsBean orderDetailsBean) {
                        mOrderDetailsBean = orderDetailsBean;
                        initView();
                    }
                });

    }

    private void initView() {
        mOrderNo.setText(mOrderDetailsBean.getOrderNo());
        mOrderTime.setText(mOrderDetailsBean.getSendTime());
        mStartAreaQuxian.setText(mOrderDetailsBean.getConsignerProvince() + mOrderDetailsBean.getConsignerCity() + mOrderDetailsBean.getConsignerArea());
        mStartAreaDetails.setText(mOrderDetailsBean.getConsignerAdress());

        mEndAreaQuxian.setText(mOrderDetailsBean.getReceiverProvince() + mOrderDetailsBean.getReceiverCity() + mOrderDetailsBean.getReceiverArea());
        mEndAreaDetails.setText(mOrderDetailsBean.getReceiverAdress());
        mOrderGoods.setText(mOrderDetailsBean.getGoodsName());
        mOrderWeight.setText(mOrderDetailsBean.getGoodsWeight() + "公斤");
        mOrderVolume.setText(mOrderDetailsBean.getGoodsvolume() + "方");
        mOrderCarask.setText(mOrderDetailsBean.getVechileTypeName() + "/" + mOrderDetailsBean.getVehicleLength() + "米/" + mOrderDetailsBean.getNeedVehicle() + "辆");

        mOrderStartTime.setText(mOrderDetailsBean.getSendTime());
        switch (mOrderDetailsBean.getOrderStatus()){
            case 1:
                mOrderStuta.setText("待处理");
                break;
            case 2:
                mOrderStuta.setText("待确认");
                break;
            case 3:
                mOrderStuta.setText("已撤销");
                break;
            case 4:
                mOrderStuta.setText("进行中");
                break;
            case 5:
                mOrderStuta.setText("待完成");
                break;
            case 6:
                mOrderStuta.setText("已完成");
                break;
            case 7:
                mOrderStuta.setText("异常");
                break;
            case 8:
                mOrderStuta.setText(" 派单中");
                break;
        }

        if (mOrderDetailsBean.getIsTicket() == 1) {
            mOrderKaipiao.setText("开票");
        } else {
            mOrderKaipiao.setText("不开票");
        }

        //1现结2月结3合同结
        if (mOrderDetailsBean.getSettlementStatus() == 1) {
            mOrderJiesuan.setText("现结");
        } else if (mOrderDetailsBean.getSettlementStatus() == 2) {
            mOrderJiesuan.setText("月结");
        } else if (mOrderDetailsBean.getSettlementStatus() == 3) {
            mOrderJiesuan.setText("合同结");
        }

        mOrderRemark.setText(mOrderDetailsBean.getRemark());
        mOrderYunfei.setText(mOrderDetailsBean.getOrderTotalFee() + "元");
        mOrderShuifei.setText(mOrderDetailsBean.getOrderTaxFee() + "元");


        if (mOrderDetailsBean.getOrderStatus() == 1) {
            mOrderPaicheBtn.setVisibility(View.VISIBLE);
            mOrderPaicheBtn.setText("确认接单");
            mOrderWanchengBtn.setVisibility(View.GONE);

            mOrderPaicheBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(OrderDetailsActivity.this, ReceiptOrderDialog.class);
                    intent.putExtra("orderId", mOrderDetailsBean.getOrderID());
                    intent.putExtra("fee", mOrderDetailsBean.getOrderFee());
                    mContext.startActivity(intent);
                }
            });

        } else if (mOrderDetailsBean.getOrderStatus() == 4) {
            mOrderPaicheBtn.setVisibility(View.VISIBLE);
            mOrderPaicheBtn.setText("确认派车");
            mOrderWanchengBtn.setVisibility(View.VISIBLE);

            mOrderPaicheBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(OrderDetailsActivity.this, DispatchCarActivity.class);
                    intent.putExtra("orderId", mOrderDetailsBean.getOrderID());
                    intent.putExtra("orderNo", mOrderDetailsBean.getOrderNo());
                    intent.putExtra("startArea", mOrderDetailsBean.getConsignerProvince() + mOrderDetailsBean.getConsignerCity() + mOrderDetailsBean.getConsignerArea());
                    intent.putExtra("endArea", mOrderDetailsBean.getReceiverProvince() + mOrderDetailsBean.getReceiverCity() + mOrderDetailsBean.getReceiverArea());
                    intent.putExtra("goodsName", mOrderDetailsBean.getGoodsName());
                    intent.putExtra("goodsWeight", mOrderDetailsBean.getGoodsWeight());
                    intent.putExtra("goodsvolume", mOrderDetailsBean.getGoodsvolume());
                    intent.putExtra("sendTime", mOrderDetailsBean.getSendTime());
                    intent.putExtra("fee", mOrderDetailsBean.getOrderFee());
                    intent.putExtra("totalFee", mOrderDetailsBean.getOrderTotalFee());
                    mContext.startActivity(intent);
                }
            });

            mOrderWanchengBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mApi.ComplateOrder(mOrderDetailsBean.getOrderID(), GlobalParams.sUserId)
                            .compose(RxHttpResponseCompat.<String>compatResult())
                            .subscribe(new ErrorHandlerSubscriber<String>() {

                                @Override
                                public void onNext(String s) {
                                    EventBus.getDefault().post(new MessageEvent("refreshOrder"));
                                    RxToast.success("立即完成成功");
                                    mOrderPaicheBtn.setVisibility(View.GONE);
                                    mOrderWanchengBtn.setVisibility(View.GONE);
                                    mOrderStuta.setText("已完成");
                                }
                            });
                }
            });


        } else {
            mOrderPaicheBtn.setVisibility(View.GONE);
            mOrderWanchengBtn.setVisibility(View.GONE);
        }
    }

}
