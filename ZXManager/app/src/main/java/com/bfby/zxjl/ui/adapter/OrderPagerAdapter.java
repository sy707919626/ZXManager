package com.bfby.zxjl.ui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;


import com.bfby.zxjl.ui.base.FragmentInfo;
import com.bfby.zxjl.ui.fragment.OrderPageFragment;

import java.util.ArrayList;
import java.util.List;

public class OrderPagerAdapter extends FragmentPagerAdapter {
    private List<FragmentInfo> mFragment = new ArrayList<>(2);

    public OrderPagerAdapter(FragmentManager fm) {
        super(fm);
        initFragment();
    }

    //未接单 = 0, 已接单 = 1,订单确认待支付 = 2,
    private void initFragment() {
        mFragment.add(new FragmentInfo("订单大厅", new OrderPageFragment("0")));
        mFragment.add(new FragmentInfo("待接单", new OrderPageFragment("1")));
    }

    @Override
    public Fragment getItem(int position) {
        return mFragment.get(position).getFragment();
    }

    @Override
    public int getCount() {
        return mFragment.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mFragment.get(position).getTitle();
    }
}
