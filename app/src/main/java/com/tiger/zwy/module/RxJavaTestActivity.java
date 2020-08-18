package com.tiger.zwy.module;

import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.tiger.zwy.R;
import com.tiger.zwy.module.test.bean.Data;
import com.tiger.zwy.utils.DeviceUtils;
import com.tiger.zwy.utils.TestUtils;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public class RxJavaTestActivity extends AppCompatActivity {
    private final String TAG = "RxJavaTestActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rxjava_test);
//        String deviceId= TestUtils.getDeviceId(this);
//        String mac=TestUtils.getMacAddress();
//        String model= Build.MODEL;
//        String carrier=Build.MANUFACTURER;
//
//
//        Log.i("i====","deviceId:"+deviceId);
//        Log.i("i====","mac:"+mac);
//        Log.i("i====","model:"+model);
//        Log.i("i====","carrier:"+carrier);
        initCreate02();
        initCreate01();
        initCreate();
        map();
        subscribeOn();
        flowable();
    }



    public void initCreate() {
        Observable.create((ObservableOnSubscribe<String>) e -> {
            e.onNext("next");
            e.onComplete();
        }).subscribe(new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.d(TAG, "onSubscribe: " + d);
            }

            @Override
            public void onNext(String value) {
                Log.d(TAG, "onNext: " + value);
            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, "onError: " + e);
            }

            @Override
            public void onComplete() {
                Log.d(TAG, "onComplete: ");
            }
        });

    }

    public void initCreate01() {
        Observable.create(new ObservableOnSubscribe<Integer>() {
            //1.创建被观察者()&定义需发送的事件
            @Override
            public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
                emitter.onNext(1);
                emitter.onNext(2);
                emitter.onNext(3);
                emitter.onComplete();
            }
        }).subscribe(new Observer<Integer>() {
            //2.创建观察者(Observer)&定义响应事件的行为
            //3.通过订阅(subscribe)连接观察者和被观察者
            @Override
            public void onSubscribe(Disposable d) {
                Log.d(TAG, "开始采用subscribe连接");
            }
            //默认最先调用复写的onSubscribe()

            @Override
            public void onNext(Integer integer) {
                Log.d(TAG, "对Next事件" + integer + "作出响应");
            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, "对Error事件作出响应");
            }

            @Override
            public void onComplete() {
                Log.d(TAG, "对Complete事件作出响应");
            }
        });
    }

    /**
     * 存在涉及多个被观察者(Observable)的情况
     */
    public void initCreate02() {
        //过程讲解:
        //调用顺序:先回调Observable2的subscribe(Observer)、subscribeActual(Observer)
        // 、再回调Observable1的subscribe(Observer) 、subscribeActual(Observer)
        //Observable的发送顺序=先发送Observable1、在发送Observable2
        //创建第1个被观察者(Observable1)
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
                emitter.onNext(1);
                emitter.onNext(2);
                emitter.onNext(3);
            }
        })
                //使用flatMap操作符(内部会创建第2个被观察者(Observable2))
                .flatMap(new Function<Integer, ObservableSource<String>>() {
                    @Override
                    public ObservableSource<String> apply(Integer integer) throws Exception {
                        final List<String> list = new ArrayList<>();
                        for (int i = 0; i < 3; i++) {
                            list.add("我是事件" + integer + "拆分后的子事件" + i);
                            //通过flatMap中将被观察者生产的事件序列先进行拆分，在将每个事件转换为一个新的发送三个String事件
                            //最终合并，再发送给被观察者
                        }
                        return Observable.fromIterable(list);
                    }
                })
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.d(TAG, "开始采用subscribe连接");
                    }

                    //默认最先调用复写的onSubscribe()
                    @Override
                    public void onNext(String s) {
                        Log.d(TAG, "响应事件:" + s);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG, "对Error事件作出响应");
                    }

                    @Override
                    public void onComplete() {
                        Log.d(TAG, "对Complete事件作出响应");
                    }
                })
        ;
    }

    public void map() {
        Observable.create((ObservableOnSubscribe<String>) e -> {
            e.onNext("5");
            e.onComplete();
        }).map(new Function<String, Integer>() {
            @Override
            public Integer apply(String s) throws Exception {
                return Integer.parseInt(s);
            }
        }).subscribe(new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.d(TAG, "onSubscribe: " + d);
            }

            @Override
            public void onNext(Integer integer) {
                Log.d(TAG, "onNext: " + integer);
            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, "onError: " + e);
            }

            @Override
            public void onComplete() {
                Log.d(TAG, "onComplete: ");
            }
        });
    }

    public void subscribeOn() {
        Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> e) throws Exception {
                e.onNext("next");
                e.onComplete();
            }
        }).subscribeOn(Schedulers.io())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.d(TAG, "onSubscribe:" + d);
                    }

                    @Override
                    public void onNext(String s) {
                        Log.d(TAG, "onNext:" + s);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG, "onError:" + e);
                    }

                    @Override
                    public void onComplete() {
                        Log.d(TAG, "onComplete");
                    }
                });
    }

    public void observerOn() {
        Observable.create((ObservableOnSubscribe<String>) e -> {
            e.onNext("next");
            e.onComplete();
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.d(TAG, "onSubscribe: " + d);
                    }

                    @Override
                    public void onNext(String s) {
                        Log.d(TAG, "onNext: " + s);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG, "onError: " + e);
                    }

                    @Override
                    public void onComplete() {
                        Log.d(TAG, "onComplete: ");
                    }
                });
    }

    public void flowable() {
        Flowable.create(new FlowableOnSubscribe<Integer>() {
            @Override
            public void subscribe(FlowableEmitter<Integer> emitter) throws Exception {
                Log.d(TAG, "next 1");
                emitter.onNext(1);
                Log.d(TAG, "next 2");
                emitter.onNext(2);
                Log.d(TAG, "next 3");
                emitter.onNext(3);
                Log.d(TAG, "发送完成");
                emitter.onComplete();
            }
        }, BackpressureStrategy.ERROR).subscribe(new Subscriber<Integer>() {
            @Override
            public void onSubscribe(Subscription s) {
                Log.d(TAG, "onSubscribe");
                s.request(3);

            }

            @Override
            public void onNext(Integer integer) {
                Log.d(TAG, "onNext" + integer);
            }

            @Override
            public void onError(Throwable t) {
                Log.d(TAG, "onError");
            }

            @Override
            public void onComplete() {
                Log.d(TAG, "onComplete");
            }
        });
    }


    @RequiresApi(api = Build.VERSION_CODES.N)
    public void initJust() {
        Observable<Data> data = Observable.just(new Data("aaa")
                , new Data("bbbb"));


    }
}
