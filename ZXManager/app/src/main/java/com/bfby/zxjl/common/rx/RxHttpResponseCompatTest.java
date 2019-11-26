package com.bfby.zxjl.common.rx;

import com.bfby.zxjl.Bean.BaseBean;
import com.bfby.zxjl.common.exception.ApiException;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/**
 * @description:统一封装结果预处理
 */
public class RxHttpResponseCompatTest {

    public static <T> ObservableTransformer<BaseBean<T>, T> compatResult() {
        return new ObservableTransformer<BaseBean<T>, T>() {
            @Override
            public ObservableSource<T> apply(Observable<BaseBean<T>> upstream) {
                return upstream.flatMap(new Function<BaseBean<T>, ObservableSource<T>>() {
                    @Override
                    public ObservableSource<T> apply(final BaseBean<T> baseBean) throws Exception {

                        if (baseBean.getStatus()== 1 ) {
//                            return Observable.create(new ObservableOnSubscribe<T>() {
//                                @Override
//                                public void subscribe(ObservableEmitter<T> subscriber) throws Exception {
//                                    try {
//                                        subscriber.onNext(baseBean.getData());
//                                        subscriber.onComplete();
//
//                                    } catch (Exception e) {
//                                        subscriber.onError(e);
//                                    }
//                                }
//                            });

                            return Observable.just(baseBean.getData());
                        } else {
                            String msg = baseBean.getMsg();
                            return Observable.error(new ApiException(Integer.valueOf(baseBean.getStatus()), msg));
                        }
                    }
                }).observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io());
            }
        };
    }
}








