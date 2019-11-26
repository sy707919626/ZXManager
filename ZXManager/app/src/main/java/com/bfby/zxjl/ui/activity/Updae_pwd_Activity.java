package com.bfby.zxjl.ui.activity;

import android.content.Intent;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.alibaba.fastjson.JSONObject;
import com.bfby.zxjl.R;
import com.bfby.zxjl.common.rx.RxHttpResponseCompat;
import com.bfby.zxjl.common.rx.subscriber.ErrorHandlerSubscriber;
import com.bfby.zxjl.common.widget.ClearEditText;
import com.bfby.zxjl.common.widget.MyCountDownTimer;
import com.bfby.zxjl.common.widget.ProjectUtil;
import com.bfby.zxjl.common.widget.RxToast;
import com.bfby.zxjl.ui.base.BaseActivity;
import com.gyf.barlibrary.ImmersionBar;

import butterknife.BindView;

public class Updae_pwd_Activity extends BaseActivity {

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
    @BindView(R.id.forgetpwd_edit_name_text)
    TextView mForgetpwdEditNameText;
    @BindView(R.id.forgetpwd_edit_name_text2)
    TextView mForgetpwdEditNameText2;
    @BindView(R.id.forgetpwd_edit_name)
    ClearEditText mForgetpwdEditName;
    @BindView(R.id.forgetpwd_hint_text)
    TextView mForgetpwdHintText;
    @BindView(R.id.forgetpwd_hint_phone_text)
    TextView mForgetpwdHintPhoneText;
    @BindView(R.id.forgetpwd_edit_code)
    EditText mForgetpwdEditCode;
    @BindView(R.id.forgetpwd_btn_getcode)
    Button mForgetpwdBtnGetcode;
    @BindView(R.id.forgetpwd_btn_submit)
    Button mForgetpwdBtnSubmit;
    @BindView(R.id.forgetpwd_login_type)
    TextView mForgetpwdLoginType;
    private String tempMobile;
    private String Code = "";
    private boolean isForget;

    @Override
    protected int setLayoutId() {
        return R.layout.activity_forgetpwd;
    }

    @Override
    protected void init() {
        ImmersionBar.with(this)
                .titleBar(R.id.base_bar_title)
                .navigationBarColor(R.color.toolbarBG)
                .init();
        stepActivities.add(this);

        mTextDetailContent.setText("验证账户");
        mTextDetailRight.setVisibility(View.GONE);
        isForget = getIntent().getBooleanExtra("isForget", false);

        if (isForget) {
            mForgetpwdLoginType.setVisibility(View.GONE);
        } else {
            mForgetpwdLoginType.setVisibility(View.VISIBLE);
        }

        mForgetpwdBtnSubmit.setEnabled(false);

        mForgetpwdEditName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (!TextUtils.isEmpty(mForgetpwdEditName.getText().toString().trim())) {
                    mForgetpwdBtnSubmit.setEnabled(true);
                    mForgetpwdEditName.setTextSize(18);

                } else {
                    mForgetpwdBtnSubmit.setEnabled(false);
                    mForgetpwdEditName.setTextSize(18);
                }
            }
        });

        mForgetpwdBtnGetcode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final MyCountDownTimer myCountDownTimer = new MyCountDownTimer(60000, 1000, mForgetpwdBtnGetcode);
                tempMobile = mForgetpwdEditName.getText().toString().trim();

                mForgetpwdHintPhoneText.setText(tempMobile);

                if (TextUtils.isEmpty(tempMobile)) {
                    RxToast.warning("请输入手机号码");

                } else if (ProjectUtil.isMobileNO(tempMobile)) {
                    //处理手机验证码获取
                    mApi.GetPhoneCode(tempMobile)
                            .compose(RxHttpResponseCompat.<String>compatResult())
                            .subscribe(new ErrorHandlerSubscriber<String>() {
                                @Override
                                public void onNext(String s) {
                                    JSONObject jsonObject = JSONObject.parseObject(s);
                                    Code = jsonObject.getString("code");
                                    myCountDownTimer.start();
                                }
                            });


                } else {
                    RxToast.warning("请输入正确的手机号码");
                }
            }
        });

        mForgetpwdBtnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TextUtils.isEmpty(mForgetpwdEditName.getText().toString().trim())) {
                    RxToast.warning("请输入手机号");
                } else if (TextUtils.isEmpty(mForgetpwdEditCode.getText().toString().trim())) {
                    RxToast.warning("请输入验证码");
                } else if (mForgetpwdEditCode.getText().toString().trim().equals(Code)) {
                    Intent intent = new Intent(Updae_pwd_Activity.this, Setting_Password_Activity.class);
                    intent.putExtra("forget_phone", mForgetpwdEditName.getText().toString().trim());
                    startActivity(intent);
                } else {
                    RxToast.error("验证码有误，请重新输入");
                }
            }
        });

    }
}
