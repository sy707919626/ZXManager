package com.bfby.zxjl.common.widget;

import android.content.Intent;

import com.bfby.zxjl.MyApplication;
import com.bfby.zxjl.ui.activity.LoginActivity;


public class LoginUtil {
    public static void loginOut() {
//        GlobalParams.clear();

        Intent intent = new Intent(MyApplication.get(), LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK
                | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        MyApplication.get().startActivity(intent);
    }

}
