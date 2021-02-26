package utils;

import android.annotation.SuppressLint;
import android.content.Context;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import okhttp3.MediaType;
import okhttp3.RequestBody;

public class Net {

    @SuppressLint("StaticFieldLeak")
    private static Net mInstance;
    @SuppressWarnings({"unused", "FieldCanBeLocal"})
    private Context context;
    private HashMap<String, String> responseValues = new HashMap<>();
    private String singleResponse = "";
    private Observable<HashMap<String, String>> requests;

    @SuppressLint("CommitPrefEdits")
    private Net(Context context) {
        this.context = context;
    }

    public static synchronized Net getInstance(Context context) {
        if (mInstance == null)
            mInstance = new Net(context);
        return mInstance;
    }


    public Net setRequestZip(HashMap<String, ObservableSource<String>> requestObservables) {


        final List<ObservableSource<String>> lists = new ArrayList<>();
        final List<String> apiNames = new ArrayList<>();


        for (Map.Entry<String, ObservableSource<String>> currentObservable : requestObservables.entrySet()) {
            lists.add(currentObservable.getValue());
            apiNames.add(currentObservable.getKey());
        }


        requests = Observable.zip(lists, objects -> {
            HashMap<String, String> requestList = new HashMap<>();
            for (int i = 0; i < objects.length; i++) {
                requestList.put(apiNames.get(i), (String) objects[i]);
            }
            return requestList;
        });


        return this;
    }


    public void doMakeApiCall(final ApiTaskDelegate apiTaskDelegate) {


        CompositeDisposable disposables = new CompositeDisposable();

        disposables.add(requests.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableObserver<HashMap<String, String>>() {
                    @Override
                    public void onNext(HashMap<String, String> responses) {
                        responseValues = responses;
                    }

                    @Override
                    public void onError(Throwable e) {
                        apiTaskDelegate.onErrorOccured(e.toString());
                    }

                    @Override
                    public void onComplete() {
                        apiTaskDelegate.onTaskCompleted(responseValues);
                    }
                }));
    }

    public void doMakeSingleApiCall(ApiCaller caller, HashMap<String, String> headers, SingleApiTaskDelegate apiTaskDelegate) {
//        Api api = new ApiHandler().getApi();

        CompositeDisposable disposable = new CompositeDisposable();

        disposable.add(caller.getAPI().getReponse(caller.getURL(), headers, caller.getParams())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableObserver<String>() {
                    @Override
                    public void onNext(String s) {
                        singleResponse = s;
                    }

                    @Override
                    public void onError(Throwable e) {
                        apiTaskDelegate.onErrorOccured(e.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        disposable.dispose();
                        apiTaskDelegate.onTaskCompleted(singleResponse);
                    }
                }));
    }


    public void doMakeSingleApiCallRAW(Api.APIMETHODS method, ApiCaller caller, HashMap<String, String> headers, SingleApiTaskDelegate apiTaskDelegate) {
        CompositeDisposable disposable = new CompositeDisposable();

        JSONObject bodyObj = new JSONObject(caller.getParams());

        RequestBody body = RequestBody.create(MediaType.parse("application/json"), bodyObj.toString());

        switch (method) {
            case PUT:
                disposable.add(caller.getAPI().performPutMethodRAW(caller.getURL(), headers, caller.getParams())
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeWith(new DisposableObserver<String>() {
                            @Override
                            public void onNext(String s) {
                                singleResponse = s;
                            }

                            @Override
                            public void onError(Throwable e) {
                                apiTaskDelegate.onErrorOccured(e.getMessage());
                            }

                            @Override
                            public void onComplete() {
                                disposable.dispose();
                                apiTaskDelegate.onTaskCompleted(singleResponse);
                            }
                        }));
                break;

            case DELETE:
                disposable.add(caller.getAPI().performDeleteMethodRAW(caller.getURL(), headers, caller.getParams())
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeWith(new DisposableObserver<String>() {
                            @Override
                            public void onNext(String s) {
                                singleResponse = s;
                            }

                            @Override
                            public void onError(Throwable e) {
                                apiTaskDelegate.onErrorOccured(e.getMessage());
                            }

                            @Override
                            public void onComplete() {
                                disposable.dispose();
                                apiTaskDelegate.onTaskCompleted(singleResponse);
                            }
                        }));
                break;

            case POST:

                disposable.add(caller.getAPI().performPostMethodRAW(caller.getURL(), headers, body)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeWith(new DisposableObserver<String>() {
                            @Override
                            public void onNext(String s) {
                                singleResponse = s;
                            }

                            @Override
                            public void onError(Throwable e) {
                                apiTaskDelegate.onErrorOccured(e.getMessage());
                            }

                            @Override
                            public void onComplete() {
                                disposable.dispose();
                                apiTaskDelegate.onTaskCompleted(singleResponse);
                            }
                        }));
                break;

            default:
                disposable.add(caller.getAPI().performGetMethodRAW(caller.getURL(), headers, caller.getParams())
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeWith(new DisposableObserver<String>() {
                            @Override
                            public void onNext(String s) {
                                singleResponse = s;
                            }

                            @Override
                            public void onError(Throwable e) {
                                apiTaskDelegate.onErrorOccured(e.getMessage());
                            }

                            @Override
                            public void onComplete() {
                                disposable.dispose();
                                apiTaskDelegate.onTaskCompleted(singleResponse);
                            }
                        }));
                break;
        }
    }
}
