package com.bfby.zxjl.ui.activity;

import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.alibaba.fastjson.JSONObject;
import com.bfby.zxjl.R;
import com.bfby.zxjl.common.constan.GlobalParams;
import com.bfby.zxjl.common.rx.RxHttpResponseCompat;
import com.bfby.zxjl.common.rx.subscriber.ErrorHandlerSubscriber;
import com.bfby.zxjl.common.widget.ClearEditText;
import com.bfby.zxjl.common.widget.ProjectUtil;
import com.bfby.zxjl.common.widget.RxToast;
import com.bfby.zxjl.ui.base.BaseActivity;
import com.gyf.barlibrary.ImmersionBar;
import butterknife.BindView;
import butterknife.OnClick;
import okhttp3.MediaType;
import okhttp3.RequestBody;

/**
 * Created by Administrator on 2018/10/29.
 */

public class HelpFeedbackActivity extends BaseActivity {

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
    @BindView(R.id.help_feeback_text)
    EditText mHelpFeebackText;
    @BindView(R.id.help_feeback_text_sum)
    TextView mHelpFeebackTextSum;
    @BindView(R.id.rl_comment_content)
    RelativeLayout mRlCommentContent;
    @BindView(R.id.update_feedback_phone_text)
    TextView mUpdateFeedbackPhoneText;
    @BindView(R.id.update_feedback_phone)
    ClearEditText mUpdateFeedbackPhone;
    @BindView(R.id.btn_Submission)
    Button mBtnSubmission;

    @Override
    protected int setLayoutId() {
        return R.layout.activity_help_feedback;
    }

    @Override
    protected void init() {
        ImmersionBar.with(this)
                .titleBar(R.id.base_bar_title)
                .navigationBarColor(R.color.toolbarBG)
                .init();

        mTextDetailContent.setText("帮助与反馈");
        mTextDetailRight.setText("联系客服");

        final int maxNum = 140;
        mHelpFeebackText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                mHelpFeebackTextSum.setText((maxNum - editable.length()) + "");
            }
        });
    }

    @OnClick({R.id.btn_Submission, R.id.text_detail_right})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_Submission: //提交

                if (TextUtils.isEmpty( mHelpFeebackText.getText().toString().trim())) {
                    RxToast.warning("填写您的评价和建议");
                } else if (TextUtils.isEmpty(mUpdateFeedbackPhone.getText().toString().trim())) {
                    RxToast.warning("请留下您的联系方式，方便我们联系您");
                } else {
                    if (!isFastClick()) {
                        JSONObject obj = new JSONObject();
                        obj.put("Content", mHelpFeebackText.getText().toString().trim());
                        obj.put("phone", mUpdateFeedbackPhone.getText().toString().trim());
                        obj.put("UserId", GlobalParams.sUserId);

                        String messages = obj.toString();
                        RequestBody body = RequestBody.create(MediaType.parse("text/json; charset=utf-8"),
                                messages);

                        mApi.Feedback(body)
                                .compose(RxHttpResponseCompat.<String>compatResult())
                                .subscribe(new ErrorHandlerSubscriber<String>() {
                                    @Override
                                    public void onNext(String s) {
                                        RxToast.success("提交成功");
                                        finish();

                                    }
                                });
                    }
                }

                break;

            case R.id.text_detail_right: //联系客服
                ProjectUtil.checkCallPhone(this, "0731-88395758");
                break;
            default:
                break;
        }
    }
}
