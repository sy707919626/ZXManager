package com.bfby.zxjl.ui.activity;

import android.annotation.SuppressLint;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bfby.zxjl.R;
import com.bfby.zxjl.ui.base.BaseActivity;
import com.gyf.barlibrary.ImmersionBar;

import butterknife.BindView;

/**
 * Created by Administrator on 2018/10/22.
 */
@SuppressLint("Registered")
public class AboutActivity extends BaseActivity {

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
    @BindView(R.id.policy_bt)
    TextView mPolicyBt;
    @BindView(R.id.buy_policy_text)
    TextView mBuyPolicyText;
    @Override
    protected int setLayoutId() {
        return R.layout.activity_buy_policy;
    }

    @Override
    protected void init() {
        ImmersionBar.with(this)
                .titleBar(R.id.base_bar_title)
                .navigationBarColor(R.color.toolbarBG)
                .init();

        mPolicyBt.setText("");
        mTextDetailContent.setText("关于我们");
        mTextDetailRight.setVisibility(View.GONE);
        String AA = "关于我们关于我们关于我们";

        mBuyPolicyText.setText(AA);
    }

}
