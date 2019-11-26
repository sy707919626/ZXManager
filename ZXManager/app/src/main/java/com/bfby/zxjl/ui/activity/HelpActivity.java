package com.bfby.zxjl.ui.activity;

import android.content.Intent;
import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bfby.zxjl.R;
import com.bfby.zxjl.ui.base.BaseActivity;
import com.gyf.barlibrary.ImmersionBar;

import butterknife.BindView;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by Administrator on 2019/1/17.
 */

public class HelpActivity extends BaseActivity {
    @BindView(R.id.image_back_detail_bar)
    ImageView mImageBackDetailBar;
    @BindView(R.id.text_detail_content)
    TextView mTextDetailContent;
    @BindView(R.id.text_detail_right)
    TextView mTextDetailRight;
    @BindView(R.id.detail_bar_title)
    RelativeLayout mDetailBarTitle;
    @BindView(R.id.my_cropimage_view)
    CircleImageView mMyCropimageView;
    @BindView(R.id.user_name)
    TextView mUserName;
    @BindView(R.id.user_phone)
    TextView mUserPhone;
    @BindView(R.id.mydata_relative)
    RelativeLayout mMydataRelative;
    @BindView(R.id.forget_pwd_text)
    TextView mForgetPwdText;
    @BindView(R.id.cannot_code)
    TextView mCannotCode;
    @BindView(R.id.untying_phone)
    TextView mUntyingPhone;
    @BindView(R.id.update_phone)
    TextView mUpdatePhone;
    @BindView(R.id.other_problem)
    TextView mOtherProblem;

    @Override
    protected int setLayoutId() {
        return R.layout.activity_help;
    }

    @Override
    protected void init() {
        ImmersionBar.with(this)
                .titleBar(R.id.detail_bar_title)
                .titleBarMarginTop(R.id.detail_bar_title)
                .navigationBarColorInt(Color.WHITE)
                .statusBarDarkFont(true, 0.5f)
                .navigationBarDarkIcon(true, 0.5f)
                .init();

        mTextDetailContent.setText("在线客服");
        mTextDetailRight.setVisibility(View.GONE);

    }

    @OnClick({R.id.forget_pwd_text, R.id.cannot_code, R.id.untying_phone,
            R.id.update_phone, R.id.other_problem})

    public void onViewClicked(View view) {
        Intent intent = new Intent(this, HelpDetailActivity.class);

        switch (view.getId()) {
            case R.id.forget_pwd_text:
                //忘记密码
                intent.putExtra("problemTitle", mForgetPwdText.getText().toString().trim());
                intent.putExtra("type", 1);
                startActivity(intent);
                break;

            case R.id.cannot_code:
                //收不到短信
                intent.putExtra("problemTitle", mCannotCode.getText().toString().trim());
                intent.putExtra("type", 2);
                startActivity(intent);
                break;

            case R.id.untying_phone:
                //解绑手机
                intent.putExtra("problemTitle", mUntyingPhone.getText().toString().trim());
                intent.putExtra("type", 3);
                startActivity(intent);
                break;

            case R.id.update_phone:
                //修改手机号码
                intent.putExtra("problemTitle", mUpdatePhone.getText().toString().trim());
                intent.putExtra("type", 4);
                startActivity(intent);
                break;

            case R.id.other_problem:
                //其他问题
                intent.putExtra("problemTitle", mOtherProblem.getText().toString().trim());
                intent.putExtra("type", 5);
                startActivity(intent);
                break;

        }
    }
}
