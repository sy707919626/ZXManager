package com.bfby.zxjl.ui.activity;

import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.InputType;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.alibaba.fastjson.JSONObject;
import com.bfby.zxjl.R;
import com.bfby.zxjl.common.constan.GlobalParams;
import com.bfby.zxjl.common.rx.RxHttpResponseCompat;
import com.bfby.zxjl.common.rx.subscriber.ErrorHandlerSubscriber;
import com.bfby.zxjl.common.widget.IDCard;
import com.bfby.zxjl.common.widget.LoginUtil;
import com.bfby.zxjl.common.widget.RxToast;
import com.bfby.zxjl.ui.base.BaseActivity;
import com.gyf.barlibrary.ImmersionBar;

import butterknife.BindView;
import butterknife.OnClick;
import okhttp3.MediaType;
import okhttp3.RequestBody;

/**
 * Created by Administrator on 2018/10/22.
 */

public class Setting_Password_Activity extends BaseActivity {
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
    @BindView(R.id.text_forget_code)
    TextView mTextForgetCode;
    @BindView(R.id.setting_parssword_new_text)
    TextView mSettingParsswordNewText;
    @BindView(R.id.setting_parssword_new)
    EditText mSettingParsswordNew;
    @BindView(R.id.setting_parssword_new_Password)
    CheckBox mSettingParsswordNewPassword;
    @BindView(R.id.setting_parssword_confirm_text)
    TextView mSettingParsswordConfirmText;
    @BindView(R.id.setting_parssword_confirm)
    EditText mSettingParsswordConfirm;
    @BindView(R.id.setting_parssword_confirm_Password)
    CheckBox mSettingParsswordConfirmPassword;
    @BindView(R.id.setting_pwd_complete)
    Button mSettingPwdComplete;
    private String forgetPhone = "";

    @Override
    protected int setLayoutId() {
        return R.layout.activity_setting_password;
    }

    @Override
    protected void init() {
        ImmersionBar.with(this)
                .titleBar(R.id.base_bar_title)
                .navigationBarColor(R.color.toolbarBG)
                .init();
        stepActivities.add(this);

        forgetPhone = getIntent().getStringExtra("forget_phone");

        mTextDetailContent.setText("设置密码");
        mTextDetailRight.setVisibility(View.GONE);


        mSettingPwdComplete.setEnabled(false);

        mSettingParsswordNew.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (!TextUtils.isEmpty( mSettingParsswordNew.getText().toString().trim()) &&
                        !TextUtils.isEmpty( mSettingParsswordConfirm.getText().toString().trim())) {
                    mSettingPwdComplete.setEnabled(true);

                } else {
                    mSettingPwdComplete.setEnabled(false);
                }
            }
        });

        mSettingParsswordConfirm.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (!TextUtils.isEmpty( mSettingParsswordNew.getText().toString().trim()) &&
                        !TextUtils.isEmpty( mSettingParsswordConfirm.getText().toString().trim())) {
                    mSettingPwdComplete.setEnabled(true);

                } else {
                    mSettingPwdComplete.setEnabled(false);
                }
            }
        });

        mSettingParsswordNewPassword.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked) {
                    //选择状态 显示明文--设置为可见的密码
                    mSettingParsswordNew.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                } else {
                    //默认状态显示密码--设置文本 要一起写才能起作用 InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD
                    mSettingParsswordNew.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                }
            }
        });

        mSettingParsswordConfirmPassword.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked) {
                    //选择状态 显示明文--设置为可见的密码
                    mSettingParsswordConfirm.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                } else {
                    //默认状态显示密码--设置文本 要一起写才能起作用 InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD
                    mSettingParsswordConfirm.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                }
            }
        });

    }

    @OnClick({R.id.setting_pwd_complete})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.setting_pwd_complete:
                //处理密码修改逻辑
                String pwd =  mSettingParsswordNew.getText().toString().trim();
                String pwdAgain =  mSettingParsswordConfirm.getText().toString().trim();
                if (TextUtils.isEmpty(pwd) || TextUtils.isEmpty(pwdAgain)) {
                    RxToast.warning("密码不能为空!");
                } else if (pwd.length() < 8 || pwd.length() > 16) {
                    RxToast.warning("请输入8到16位的密码!");
                } else if (IDCard.isNumeric(pwd) || IDCard.isLetter(pwd)) {
                    RxToast.warning("密码不能为纯数字或纯字母!");
                } else if (pwd.equals(pwdAgain)) {
                    JSONObject obj = new JSONObject();
                    obj.put("phone", forgetPhone);
                    obj.put("newpwd", mSettingParsswordNew.getText().toString().trim());
                    obj.put("newlypwd", mSettingParsswordConfirm.getText().toString().trim());
                    obj.put("UserId", GlobalParams.sUserId);

                    String messages = obj.toString();
                    RequestBody body = RequestBody.create(MediaType.parse("text/json; charset=utf-8"),
                            messages);

                    mApi.ForgotPwd(body)
                            .compose(RxHttpResponseCompat.<String>compatResult())
                            .subscribe(new ErrorHandlerSubscriber<String>() {
                                @Override
                                public void onNext(String s) {
                                    RxToast.success("密码修改成功，请重新登录");

                                    stepfinishAll();
                                    LoginUtil.loginOut();
                                }
                            });
                } else {
                    RxToast.warning("密码输入不一致!");
                }

                break;
            default:
                break;
        }
    }

}
