package com.bfby.zxjl.ui.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bfby.zxjl.R;
import com.bfby.zxjl.common.widget.ProjectUtil;
import com.bfby.zxjl.ui.base.BaseActivity;
import com.gyf.barlibrary.ImmersionBar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2019/1/17.
 */

public class HelpDetailActivity extends BaseActivity {

    @BindView(R.id.image_back_detail_bar)
    ImageView mImageBackDetailBar;
    @BindView(R.id.text_detail_content)
    TextView mTextDetailContent;
    @BindView(R.id.text_detail_right)
    TextView mTextDetailRight;
    @BindView(R.id.detail_bar_title)
    RelativeLayout mDetailBarTitle;
    @BindView(R.id.problem_title)
    TextView mProblemTitle;
    @BindView(R.id.problem_content)
    TextView mProblemContent;
    @BindView(R.id.contact_service)
    Button mContactService;
    @BindView(R.id.know_sure)
    Button mKnowSure;
    private int type;

    @Override
    protected int setLayoutId() {
        return R.layout.activity_help_detail;
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

        mProblemTitle.setText(getIntent().getStringExtra("problemTitle"));
        type = getIntent().getIntExtra("type", 0);


        if (type == 1) {
            mProblemContent.setText(R.string.forger_pwd);
        } else if (type == 2) {
            mProblemContent.setText(R.string.cannot_code);
        } else if (type == 3) {
            mProblemContent.setText(R.string.untying_phone);
        } else if (type == 4) {
            mProblemContent.setText(R.string.update_phone);
        } else if (type == 5) {
            mProblemContent.setText(R.string.other_problem);
        }
    }

    @OnClick({R.id.contact_service, R.id.know_sure})

    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.contact_service:
                //联系客服
                ProjectUtil.checkCallPhone(this, "0731-88395758");
                break;

            case R.id.know_sure:
                //知道了
                finish();
                break;

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
