package com.bfby.zxjl.ui.fragment;

import android.app.Dialog;
import android.content.Intent;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bfby.zxjl.R;
import com.bfby.zxjl.common.constan.GlobalParams;
import com.bfby.zxjl.common.widget.ProjectUtil;
import com.bfby.zxjl.common.widget.item_view;
import com.bfby.zxjl.ui.activity.AboutActivity;
import com.bfby.zxjl.ui.activity.HelpFeedbackActivity;
import com.bfby.zxjl.ui.activity.MyDataActivity;
import com.bfby.zxjl.ui.activity.SettingActivity;
import com.bfby.zxjl.ui.base.BaseLazyFragment;
import com.gyf.barlibrary.ImmersionBar;

import butterknife.BindView;
import butterknife.OnClick;
import butterknife.Unbinder;
import de.hdodenhof.circleimageview.CircleImageView;

public class MeFragment extends BaseLazyFragment {
    @BindView(R.id.top_view)
    View mTopView;
    @BindView(R.id.image_back_title_bar)
    ImageView mImageBackTitleBar;
    @BindView(R.id.item_view_msg)
    ImageView mItemViewMsg;
    @BindView(R.id.title_address_toolbar)
    Toolbar mTitleAddressToolbar;
    @BindView(R.id.my_cropimage_view)
    CircleImageView mMyCropimageView;
    @BindView(R.id.user_name)
    TextView mUserName;
    @BindView(R.id.user_phone)
    TextView mUserPhone;
    @BindView(R.id.mydata_relative)
    RelativeLayout mMydataRelative;
    @BindView(R.id.item_view_mydata)
    item_view mItemViewMydata;
    @BindView(R.id.item_view_aboutme)
    item_view mItemViewAboutme;
    @BindView(R.id.item_view_feedback)
    item_view mItemViewFeedback;
    @BindView(R.id.item_view_install)
    item_view mItemViewInstall;
    Unbinder unbinder;

    @Override
    protected int setLayoutId() {
        return R.layout.fragment_me;
    }

    @Override
    protected void init() {
        ImmersionBar.with(getActivity())
                .titleBar(R.id.base_bar_title)
                .navigationBarColor(R.color.toolbarBG)
                .init();
        mUserName.setText(GlobalParams.sUserName);
        mUserPhone.setText(GlobalParams.sUserPhone);
    }

    @OnClick({R.id.mydata_relative,R.id.item_view_aboutme, R.id.item_view_feedback, R.id.item_view_install})

    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.mydata_relative:
                getContext().startActivity(new Intent(getContext(), MyDataActivity.class));
                break;


            case R.id.item_view_aboutme:
                getContext().startActivity(new Intent(getContext(), AboutActivity.class));
                break;

            case R.id.item_view_feedback:
                //反馈与帮助
                startActivity(new Intent(getContext(), HelpFeedbackActivity.class));
//                showFx();
                break;

            case R.id.item_view_install:
                //设置
                Intent intent2 = new Intent(getContext(), SettingActivity.class);
                getActivity().startActivity(intent2);
                break;
        }
    }

    @Override
    public void getData() {

    }


    //分享至微信和QQ
    private void showFx() {
        //1、使用Dialog、设置style
        final Dialog dialog = new Dialog(getActivity(), R.style.DialogTheme);
        //2、设置布局
        View view = View.inflate(getActivity(), R.layout.pop_fenxiang_item, null);
        dialog.setContentView(view);
        Window window = dialog.getWindow();
        //设置弹出位置
        window.setGravity(Gravity.BOTTOM);
        //设置弹出动画
        window.setWindowAnimations(R.style.AnimBottom);
        //设置对话框大小
        window.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.show();
        LinearLayout layout_fx_wx = dialog.findViewById(R.id.layout_fx_wx);
        layout_fx_wx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                ProjectUtil.shareMsg(getActivity(), false);
            }
        });
        LinearLayout layout_fx_qq = dialog.findViewById(R.id.layout_fx_qq);
        layout_fx_qq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                ProjectUtil.shareMsg(getActivity(), true);
            }
        });
    }
}
