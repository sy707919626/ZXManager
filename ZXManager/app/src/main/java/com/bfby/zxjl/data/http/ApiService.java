package com.bfby.zxjl.data.http;

import com.bfby.zxjl.Bean.BaseBean;
import com.bfby.zxjl.Bean.CarOrderFeeBean;
import com.bfby.zxjl.Bean.DriverInfoBean;
import com.bfby.zxjl.Bean.LoginBean;
import com.bfby.zxjl.Bean.OrderBean;
import com.bfby.zxjl.Bean.OrderDetailsBean;
import com.bfby.zxjl.Bean.OrderFeeBean;
import com.bfby.zxjl.Bean.WaybillDetailBean;
import com.bfby.zxjl.Bean.WaybillListBean;
import com.bfby.zxjl.Bean.userInfoBean;
import io.reactivex.Observable;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiService {
    //登录用户
    @POST("/api/ZeroLoad/ToLogin")
    Observable<BaseBean<LoginBean>> login(@Query("uName") String Phone, @Query("uPwd") String Password);

    //订单列表
    @POST("/api/ZeroLoad/GetMyOrderList")
    Observable<BaseBean<OrderBean>> GetMyOrderList(@Query("userId") String userId, @Body RequestBody Body, @Query("page") int page,
                                                   @Query("rows") int rows);

    //订单详情
    @GET("api/ZeroLoad/GetOrderItem")
    Observable<BaseBean<OrderDetailsBean>> GetOrderItem(@Query("orderId") String orderId);

    //我的司机列表
    @POST("/api/ZeroLoad/GetMyDriverList")
    Observable<String> GetMyDriverList(@Query("userId") String userId, @Body RequestBody Body, @Query("page") int page,
                                                         @Query("rows") int rows);
    //派车
    @POST("/api/ZeroLoad/SaveWaybillInfo")
    Observable<String> SaveWaybillInfo(@Body RequestBody Body);

    //司机详细信息
    @GET("/api/ZeroLoad/GetDriverInfo")
    Observable<BaseBean<DriverInfoBean>> GetDriverInfo(@Query("driverId") String driverId);

    //运单列表
    @POST("/api/ZeroLoad/GetMyWaybillList")
    Observable<BaseBean<WaybillListBean>> GetMyWaybillList(@Query("userId") String userId, @Body RequestBody Body, @Query("page") int page,
                                                           @Query("rows") int rows);

    //确认重量体积
    @POST("/api/ZeroLoad/ChangeOrderGoods")
    Observable<BaseBean<OrderFeeBean>> ChangeOrderGoods(@Body RequestBody Body);

    //计算价格
    @POST("/api/ZeroLoad/CalcOrderFee")
    Observable<BaseBean<CarOrderFeeBean>> CalcOrderFee(@Body RequestBody Body);

    //运单详细信息
    @POST("/api/ZeroLoad/GetWaybillItem")
    Observable<BaseBean<WaybillDetailBean>> GetWaybillItem(@Query("waybillId") String waybillId);

    //立即完成订单
    @POST("/api/ZeroLoad/ComplateOrder")
    Observable<String> ComplateOrder(@Query("orderId") String orderId, @Query("userId") String userId);

    //获取个人信息
    @POST("/api/ZeroLoad/GetUserInfo")
    Observable<BaseBean<userInfoBean>> GetUserInfo(@Query("UserId") String UserId);

    //获取手机验证码
    @POST("/api/ZeroLoad/GetPhoneCode")
    Observable<String> GetPhoneCode(@Query("phone") String phone);

    //修改密码
    @POST("/api/ZeroLoad/ForgotPwd")
    Observable<String> ForgotPwd(@Body RequestBody Body);

    //反馈
    @POST("/api/ZeroLoad/Feedback")
    Observable<String> Feedback(@Body RequestBody Body);
}


