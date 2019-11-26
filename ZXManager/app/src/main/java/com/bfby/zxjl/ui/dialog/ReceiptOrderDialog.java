package com.bfby.zxjl.ui.dialog;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.fastjson.JSONObject;
import com.bfby.zxjl.Bean.CarOrderFeeBean;
import com.bfby.zxjl.Bean.OrderFeeBean;
import com.bfby.zxjl.R;
import com.bfby.zxjl.common.rx.RxHttpResponseCompatTest;
import com.bfby.zxjl.common.rx.subscriber.ErrorHandlerSubscriber;
import com.bfby.zxjl.common.widget.ClearEditText;
import com.bfby.zxjl.common.widget.RxToast;
import com.bfby.zxjl.ui.base.BaseActivity;
import com.bfby.zxjl.ui.event.MessageEvent;

import org.greenrobot.eventbus.EventBus;

import butterknife.BindView;
import okhttp3.MediaType;
import okhttp3.RequestBody;

public class ReceiptOrderDialog extends BaseActivity {
    @BindView(R.id.receipt_title)
    TextView mReceiptTitle;
    @BindView(R.id.receipt_order_volume)
    ClearEditText mReceiptOrderVolume;
    @BindView(R.id.receipt_order_weight)
    ClearEditText mReceiptOrderWeight;
    @BindView(R.id.receipt_order_money_text)
    TextView mReceiptOrderMoneyText;
    @BindView(R.id.receipt_order_money)
    TextView mReceiptOrderMoney;
    @BindView(R.id.receipt_order_money_btn)
    Button mReceiptOrderMoneyBtn;
    @BindView(R.id.image_line)
    ImageView mImageLine;
    @BindView(R.id.btn_cancle)
    Button mBtnCancle;
    @BindView(R.id.btn_sure)
    Button mBtnSure;
    @BindView(R.id.dialog_delete)
    ImageView mDialogDelete;

    private String mOrderId;
    @Override
    protected int setLayoutId() {
        return R.layout.receipt_order_dialog;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState, persistentState);

    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mOrderId = getIntent().getStringExtra("orderId");
    }

    @Override
    protected void init() {
        mReceiptOrderMoneyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TextUtils.isEmpty(mReceiptOrderVolume.getText().toString().trim())) {
                    RxToast.warning("请输入货物实际体积");
                } else if (TextUtils.isEmpty(mReceiptOrderWeight.getText().toString().trim())) {
                    RxToast.warning("请输入货物实际重量");
                } else {
                    //计算费用
                    getFee();
                }
            }
        });

        mBtnSure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TextUtils.isEmpty(mReceiptOrderMoney.getText().toString().trim())) {
                    RxToast.warning("请先计算实际价格");
                } else {
                    comfixedOrder();
                    finish();
                }
            }
        });

        mBtnCancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        mDialogDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void comfixedOrder() {
//        mOrderId = getIntent().getStringExtra("orderId");

        JSONObject obj = new JSONObject();
        obj.put("orderid", mOrderId);
        obj.put("weight", mReceiptOrderWeight.getText().toString().trim());
        obj.put("volume", mReceiptOrderVolume.getText().toString().trim());

        String messages = obj.toString();
        RequestBody body = RequestBody.create(MediaType.parse("text/json; charset=utf-8"),
                messages);
        mApi.ChangeOrderGoods(body)
                .compose(RxHttpResponseCompatTest.<OrderFeeBean>compatResult())
                .subscribe(new ErrorHandlerSubscriber<OrderFeeBean>() {
                    @Override
                    public void onNext(OrderFeeBean orderFeeBean) {
                        EventBus.getDefault().post(new MessageEvent("refreshOrder"));
                        RxToast.warning("确认接单成功");
                    }
                });
    }

    private void getFee() {
        JSONObject obj = new JSONObject();
        obj.put("orderid", mOrderId);
        obj.put("weight", mReceiptOrderWeight.getText().toString().trim());
        obj.put("volume", mReceiptOrderVolume.getText().toString().trim());

        String messages = obj.toString();
        RequestBody body = RequestBody.create(MediaType.parse("text/json; charset=utf-8"),
                messages);
        mApi.CalcOrderFee(body)
                .compose(RxHttpResponseCompatTest.<CarOrderFeeBean>compatResult())
                .subscribe(new ErrorHandlerSubscriber<CarOrderFeeBean>() {
                    @Override
                    public void onNext(CarOrderFeeBean carOrderFeeBean) {
                        mReceiptOrderMoney.setText(carOrderFeeBean.getTotalFee()+"元");
                    }
                });
    }
}
