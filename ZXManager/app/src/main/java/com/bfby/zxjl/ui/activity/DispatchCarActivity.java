package com.bfby.zxjl.ui.activity;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.alibaba.fastjson.JSONObject;
import com.bfby.zxjl.Bean.DriverListBean;
import com.bfby.zxjl.R;
import com.bfby.zxjl.common.constan.GlobalParams;
import com.bfby.zxjl.common.rx.RxHttpResponseCompat;
import com.bfby.zxjl.common.rx.subscriber.ErrorHandlerSubscriber;
import com.bfby.zxjl.common.widget.ClearEditText;
import com.bfby.zxjl.common.widget.RxToast;
import com.bfby.zxjl.ui.base.BaseActivity;
import com.bfby.zxjl.ui.event.MessageEvent;
import com.gyf.barlibrary.ImmersionBar;

import org.greenrobot.eventbus.EventBus;

import butterknife.BindView;
import me.zhanghai.android.materialratingbar.MaterialRatingBar;
import okhttp3.MediaType;
import okhttp3.RequestBody;

public class DispatchCarActivity extends BaseActivity {

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
    @BindView(R.id.waybill_info)
    TextView mWaybillInfo;
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
    @BindView(R.id.waybill_totalfee_text)
    TextView mWaybillTotalfeeText;
    @BindView(R.id.waybill_totalfee)
    TextView mWaybillTotalfee;
    @BindView(R.id.image_line)
    ImageView mImageLine;
    @BindView(R.id.receipt_order_fee_text)
    TextView mReceiptOrderFeeText;
    @BindView(R.id.receipt_order_fee)
    ClearEditText mReceiptOrderFee;
    @BindView(R.id.receipt_order_fee_dw)
    TextView mReceiptOrderFeeDw;
    @BindView(R.id.fee_layout)
    RelativeLayout mFeeLayout;
    @BindView(R.id.image_line4)
    ImageView mImageLine4;
    @BindView(R.id.waybill_select_car)
    Button mWaybillSelectCar;
    @BindView(R.id.image_line3)
    ImageView mImageLine3;
    @BindView(R.id.waybill_car_info)
    TextView mWaybillCarInfo;
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
    @BindView(R.id.waybill_cy_phone_text)
    TextView mWaybillCyPhoneText;
    @BindView(R.id.waybill_cy_phone)
    TextView mWaybillCyPhone;
    @BindView(R.id.image_line2)
    ImageView mImageLine2;
    @BindView(R.id.waybill_selet_car_btn)
    Button mWaybillSeletCarBtn;

    private String orderId;
    private String orderNo;
    private String startArea;
    private String endArea;
    private String goodsName;
    private float goodsWeight;
    private float goodsvolume;
    private float goodsFee;
    private float goodsTotalFee;
    private String sendTime;
    private DriverListBean.RowsBean driver;

    @Override
    protected int setLayoutId() {
        return R.layout.dispath_car_activity;
    }

    @Override
    protected void init() {
        ImmersionBar.with(this)
                .titleBar(R.id.base_bar_title)
                .navigationBarColor(R.color.toolbarBG)
                .init();
        mTextDetailContent.setText("立即派车");
        mTextDetailRight.setVisibility(View.GONE);

        orderId = getIntent().getStringExtra("orderId");
        orderNo = getIntent().getStringExtra("orderNo");
        startArea = getIntent().getStringExtra("startArea");
        endArea = getIntent().getStringExtra("endArea");
        goodsName = getIntent().getStringExtra("goodsName");
        sendTime = getIntent().getStringExtra("sendTime");
        goodsWeight = getIntent().getFloatExtra("goodsWeight", 0);
        goodsvolume = getIntent().getFloatExtra("goodsvolume", 0);
        goodsFee = getIntent().getFloatExtra("fee", 0);
        goodsTotalFee = getIntent().getFloatExtra("totalFee", 0);
//        getFeeTotal();
        ininView();
    }

    private void ininView() {
        mWaybillNumber.setText(orderNo);
        mStartArea.setText(startArea);
        mEndArea.setText(endArea);
        mWaybillGoods.setText(goodsName + "/" + goodsWeight + "公斤/" + goodsvolume + "方");
        mWaybillFahuoTime.setText(sendTime);
        mWaybillTotalfee.setText(goodsTotalFee + "元");



        mWaybillSelectCar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DispatchCarActivity.this, SelectCarListActivity.class);
                startActivityForResult(intent, 1);
            }
        });


        mWaybillSeletCarBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TextUtils.isEmpty(mReceiptOrderFee.getText().toString().trim())) {
                    RxToast.warning("请输入司机运费");
                } else if (TextUtils.isEmpty(mWaybillCyName.getText().toString().trim())) {
                    RxToast.warning("请选择司机");
                } else {
                    mWaybillCyName.setFocusable(true);
                    uploadData();
                }
            }
        });
    }

    private void uploadData() {
        JSONObject obj = new JSONObject();
        obj.put("UserId", GlobalParams.sUserId);
        obj.put("Orderid", orderId);
        obj.put("Weight", goodsWeight);
        obj.put("Volume", goodsvolume);
        obj.put("DriverId", driver.getDriverId());
        obj.put("DriverName", driver.getUser_Name());
        obj.put("DriverPhone", driver.getUser_Phone());
        obj.put("Vehicleid", driver.getVehicleId());
        obj.put("VType", driver.getVType());
        obj.put("VLength", driver.getVLength());
        obj.put("VWeight", driver.getVWeight());
        obj.put("CarVolume", driver.getVolume());
        obj.put("VNo", driver.getVNo());
        obj.put("Fee", mReceiptOrderFee.getText().toString().trim());

        String messages = obj.toString();
        RequestBody body = RequestBody.create(MediaType.parse("text/json; charset=utf-8"),
                messages);

        mApi.SaveWaybillInfo(body)
                .compose(RxHttpResponseCompat.<String>compatResult())
                .subscribe(new ErrorHandlerSubscriber<String>() {

                    @Override
                    public void onNext(String s) {
                        RxToast.success("派车成功");
                        EventBus.getDefault().post(new MessageEvent("refreshOrder"));
                        finish();
                    }
                });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case 1:
                if (resultCode == RESULT_OK) {
                    driver = (DriverListBean.RowsBean) data.getSerializableExtra("driverInfo");
                    mWaybillCyName.setText(driver.getUser_Name());
                    mRatingbar.setRating(driver.getUser_Star());
                    mWaybillCarNo.setText(driver.getVNo());
                    mWaybillCyCar.setText(driver.getVehicleTypeName() + "/" + driver.getVLength() + "米/载重" + driver.getVWeight() + "公斤");
                    mWaybillCyPhone.setText(driver.getUser_Phone());
                }
                break;
        }
    }

}
