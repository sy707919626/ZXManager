package com.bfby.zxjl.di.component;

public class Constants {
    public static final String BASE_URL = "http://192.168.1.242:8033"; //测试环境
//    public static final String BASE_URL = "http://demo.api.bfby56.cn"; //正式环境

    /**
     * 微信sdk的appId
     */
    public static final String WX_APPID = "wxa18f5e18919cccc7";
    /**
     * 微信支付商户Id
     */
    public static final String WX_PAY_PARTNERID = "";

    public static boolean isAutoRefresh = false;

    public static float meBalance;

    public static float meDeposit;

    public static void setMeBalance(float meBalance) {
        Constants.meBalance = meBalance;
    }

    public static void setMeDeposit(float meDeposit) {
        Constants.meDeposit = meDeposit;
    }

    public static void setIsAutoRefresh(boolean isAutoRefresh) {
        Constants.isAutoRefresh = isAutoRefresh;
    }
}
