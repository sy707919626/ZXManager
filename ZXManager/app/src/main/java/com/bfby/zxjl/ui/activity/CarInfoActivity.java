package com.bfby.zxjl.ui.activity;

import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bfby.zxjl.Bean.DriverInfoBean;
import com.bfby.zxjl.R;
import com.bfby.zxjl.common.rx.RxHttpResponseCompatTest;
import com.bfby.zxjl.common.rx.subscriber.ErrorHandlerSubscriber;
import com.bfby.zxjl.di.component.Constants;
import com.bfby.zxjl.ui.base.BaseActivity;
import com.bumptech.glide.Glide;
import com.gyf.barlibrary.ImmersionBar;

import butterknife.BindView;
import me.zhanghai.android.materialratingbar.MaterialRatingBar;

public class CarInfoActivity extends BaseActivity {


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
    @BindView(R.id.car_cy_name_text)
    TextView mCarCyNameText;
    @BindView(R.id.car_cy_name)
    TextView mCarCyName;
    @BindView(R.id.ratingbar_text)
    TextView mRatingbarText;
    @BindView(R.id.ratingbar)
    MaterialRatingBar mRatingbar;
    @BindView(R.id.car_no_text)
    TextView mCarNoText;
    @BindView(R.id.car_no)
    TextView mCarNo;
    @BindView(R.id.car_info_text)
    TextView mCarInfoText;
    @BindView(R.id.car_info)
    TextView mCarInfo;
    @BindView(R.id.car_phone_text)
    TextView mCarPhoneText;
    @BindView(R.id.car_phone)
    TextView mCarPhone;
    @BindView(R.id.car_cyzgz_no_text)
    TextView mCarCyzgzNoText;
    @BindView(R.id.car_cyzgz_no)
    TextView mCarCyzgzNo;
    @BindView(R.id.image_line)
    ImageView mImageLine;
    @BindView(R.id.car_jszzm_text)
    TextView mCarJszzmText;
    @BindView(R.id.image_jszzm)
    ImageView mImageJszzm;
    @BindView(R.id.image_line2)
    ImageView mImageLine2;
    @BindView(R.id.car_jszfm_text)
    TextView mCarJszfmText;
    @BindView(R.id.image_jszfm)
    ImageView mImageJszfm;
    @BindView(R.id.image_line3)
    ImageView mImageLine3;
    @BindView(R.id.car_yyxkz_text)
    TextView mCarYyxkzText;
    @BindView(R.id.image_yyxkz)
    ImageView mImageYyxkz;
    @BindView(R.id.image_line4)
    ImageView mImageLine4;
    @BindView(R.id.car_sfzzm_text)
    TextView mCarSfzzmText;
    @BindView(R.id.image_sfzzm)
    ImageView mImageSfzzm;
    @BindView(R.id.image_line5)
    ImageView mImageLine5;
    @BindView(R.id.car_sfzfm_text)
    TextView mCarSfzfmText;
    @BindView(R.id.image_sfzfm)
    ImageView mImageSfzfm;
    private String mDriverId;
    private DriverInfoBean mDriverInfoBean;

    @Override
    protected int setLayoutId() {
        return R.layout.car_info_activity;
    }

    @Override
    protected void init() {
        ImmersionBar.with(this)
                .titleBar(R.id.base_bar_title)
                .navigationBarColor(R.color.toolbarBG)
                .init();
        mTextDetailContent.setText("司机详细信息");
        mTextDetailRight.setVisibility(View.GONE);
        mDriverId = getIntent().getStringExtra("driverId");

        getData();
    }

    private void getData() {
        mApi.GetDriverInfo(mDriverId)
                .compose(RxHttpResponseCompatTest.<DriverInfoBean>compatResult())
                .subscribe(new ErrorHandlerSubscriber<DriverInfoBean>() {
                    @Override
                    public void onNext(DriverInfoBean driverInfoBean) {
                        mDriverInfoBean = driverInfoBean;
                        initView();
                    }
                });
    }

    private void initView() {
        mCarCyName.setText(mDriverInfoBean.getUser_Name());
        mRatingbar.setRating(mDriverInfoBean.getUser_Star());
        mCarNo.setText(mDriverInfoBean.getVNo());
        mCarInfo.setText(mDriverInfoBean.getVLength() + "米/载重" + mDriverInfoBean.getVWeight());
        mCarPhone.setText(mDriverInfoBean.getUser_Phone());
        mCarCyzgzNo.setText(mDriverInfoBean.getQualificationcertificatenumber());

        Glide.with(this).load(Constants.BASE_URL  + mDriverInfoBean.getDriversImage())
                .placeholder(R.drawable.zhanwei).into(mImageJszzm);

        Glide.with(this).load(Constants.BASE_URL + mDriverInfoBean.getDriversImage2())
                .placeholder(R.drawable.zhanwei).into(mImageJszfm);

        Glide.with(this).load(Constants.BASE_URL  + mDriverInfoBean.getBusinessLicence())
                .placeholder(R.drawable.zhanwei).into(mImageYyxkz);

        Glide.with(this).load(Constants.BASE_URL  + mDriverInfoBean.getUser_Card_A())
                .placeholder(R.drawable.zhanwei).into(mImageSfzzm);

        Glide.with(this).load(Constants.BASE_URL  + mDriverInfoBean.getUser_Card_B())
                .placeholder(R.drawable.zhanwei).into(mImageSfzfm);
    }
}
