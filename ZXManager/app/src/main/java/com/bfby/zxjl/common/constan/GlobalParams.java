package com.bfby.zxjl.common.constan;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class GlobalParams {
    public static String sToken;
    public static String sUserPhone;
    public static String sUserId;
    public static String sUserName;
    public static String sUserType;
    public static boolean isPayPwd; //验证是否有支付密码

    public static String district; //区县
    public static double latitude; //纬度
    public static double longitude; //经度

    public static void setIsPayPwd(boolean isPayPwd) {
        GlobalParams.isPayPwd = isPayPwd;
    }

    public static void setLatitude(double latitude) {
        GlobalParams.latitude = latitude;
    }

    public static void setLongitude(double longitude) {
        GlobalParams.longitude = longitude;
    }

    public static void setDistrict(String district) {
        GlobalParams.district = district;
    }

    public static void setToken(String token) {
        sToken = token;
    }

    public static void setuserPhone(String userPhone) {
        sUserPhone = userPhone;
    }

    public static void setuserName(String userName) {
        sUserName = userName;
    }

    public static void setuserId(String userId) {
        sUserId = userId;
    }

    public static void setuserType(String userType) {
        sUserType = userType;
    }

    public static String getUserHeader() {
        JSONObject user = new JSONObject();
        try {
            user.put("userid", sUserId);
            user.put("name", sUserName);
            user.put("usertype", sUserType);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return user.toString();
    }

    /**
     * 是否登录
     */
    public static boolean isLogin() {
        return !TextUtils.isEmpty(sToken);
    }

}
