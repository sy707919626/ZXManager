package com.bfby.zxjl.ui.activity;

import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bfby.zxjl.Bean.userInfoBean;
import com.bfby.zxjl.R;
import com.bfby.zxjl.common.constan.GlobalParams;
import com.bfby.zxjl.common.rx.RxHttpResponseCompatTest;
import com.bfby.zxjl.common.rx.subscriber.ErrorHandlerSubscriber;
import com.bfby.zxjl.di.component.Constants;
import com.bfby.zxjl.ui.base.BaseActivity;
import com.bumptech.glide.Glide;
import com.gyf.barlibrary.ImmersionBar;

import butterknife.BindView;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by Administrator on 2018/10/22.
 */
public class MyDataActivity extends BaseActivity {


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
    @BindView(R.id.mydata_name_text)
    TextView mMydataNameText;
    @BindView(R.id.mydata_name)
    TextView mMydataName;
    @BindView(R.id.mydata_IDCard_text)
    TextView mMydataIDCardText;
    @BindView(R.id.IDCard_numble)
    TextView mIDCardNumble;
    @BindView(R.id.mydata_phone_text)
    TextView mMydataPhoneText;
    @BindView(R.id.phone_numble)
    TextView mPhoneNumble;
    @BindView(R.id.user_company_text)
    TextView mUserCompanyText;
    @BindView(R.id.user_company)
    TextView mUserCompany;
    @BindView(R.id.my_cropimage_view)
    CircleImageView mMyCropimageView;
    @BindView(R.id.image_line)
    ImageView mImageLine;
    @BindView(R.id.car_sfzzm_text)
    TextView mCarSfzzmText;
    @BindView(R.id.image_sfzzm)
    ImageView mImageSfzzm;
    @BindView(R.id.image_line2)
    ImageView mImageLine2;
    @BindView(R.id.car_sfzfm_text)
    TextView mCarSfzfmText;
    @BindView(R.id.image_sfzfm)
    ImageView mImageSfzfm;

    @Override
    protected int setLayoutId() {
        return R.layout.activity_mydata;
    }

    @Override
    protected void init() {
        ImmersionBar.with(this)
                .titleBar(R.id.base_bar_title)
                .navigationBarColor(R.color.toolbarBG)
                .init();

        mTextDetailContent.setText("用户信息");
        mTextDetailRight.setVisibility(View.GONE);

        getData();
    }

    private void initView(userInfoBean userinfo) {
        mMydataName.setText(userinfo.getUser_Name());
        mPhoneNumble.setText(userinfo.getUser_Phone());
        mUserCompany.setText(userinfo.getCompanyName());
        mIDCardNumble.setText(userinfo.getUser_IDCard());

        Glide.with(this).load(Constants.BASE_URL  + userinfo.getUser_Head())
                .placeholder(R.drawable.icon_head).into(mMyCropimageView);
        Glide.with(this).load(Constants.BASE_URL  + userinfo.getUser_Card_A())
                .placeholder(R.drawable.zhanwei).into(mImageSfzzm);
        Glide.with(this).load(Constants.BASE_URL  + userinfo.getUser_Card_B())
                .placeholder(R.drawable.zhanwei).into(mImageSfzfm);
    }


    private void getData(){
        mApi.GetUserInfo(GlobalParams.sUserId)
                .compose(RxHttpResponseCompatTest.<userInfoBean>compatResult())
                .subscribe(new ErrorHandlerSubscriber<userInfoBean>() {
                    @Override
                    public void onNext(userInfoBean userInfoBean) {
                        initView(userInfoBean);
                    }
                });
    }
}
