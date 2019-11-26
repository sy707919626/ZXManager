package com.bfby.zxjl.common.rx.subscriber;



import com.bfby.zxjl.common.exception.BaseException;
import com.bfby.zxjl.common.exception.RxErrorHandler;

import io.reactivex.disposables.Disposable;


/**
 * 网络错误预处理
 */
public abstract class ErrorHandlerSubscriber<T> extends DefaultSubscriber<T> {

    private static final String TAG = "ErrorHandlerSubscriber";
    private RxErrorHandler mRxErrorHandler;

    protected ErrorHandlerSubscriber() {
        mRxErrorHandler = new RxErrorHandler();
    }

    @Override
    public void onSubscribe(Disposable d) {

    }

    @Override
    public void onError(Throwable t) {
        t.printStackTrace();
        BaseException exception = mRxErrorHandler.handlerError(t);
        showErrorMsg(exception);
        onFail(exception);
        onAfter();
    }

    protected void showErrorMsg(BaseException exception) {
        mRxErrorHandler.showErrorMessage(exception);
    }

    protected void onFail(BaseException e) {

    }

    @Override
    public void onComplete() {
        onAfter();
    }

    protected void onAfter() {

    }


}
