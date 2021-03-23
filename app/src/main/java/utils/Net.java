package utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.HttpException;

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
                                String message = e.getMessage();

                                if (e instanceof HttpException) {
                                    ResponseBody body = ((HttpException) e).response().errorBody();
                                    try {
                                        message = body.string();
                                    } catch (IOException ioException) {
                                        ioException.printStackTrace();
                                    }
                                }
                                apiTaskDelegate.onErrorOccured(message);
                            }

                            @Override
                            public void onComplete() {
                                disposable.dispose();
                                apiTaskDelegate.onTaskCompleted(singleResponse);
                            }
                        }));
                break;

            case DELETE:
                disposable.add(caller.getAPI().performDeleteMethodRAW(caller.getURL(), headers, body)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeWith(new DisposableObserver<String>() {
                            @Override
                            public void onNext(String s) {
                                singleResponse = s;
                            }

                            @Override
                            public void onError(Throwable e) {
                                String message = e.getMessage();

                                if (e instanceof HttpException) {
                                    ResponseBody body = ((HttpException) e).response().errorBody();
                                    try {
                                        message = body.string();
                                    } catch (IOException ioException) {
                                        ioException.printStackTrace();
                                    }
                                }
                                apiTaskDelegate.onErrorOccured(message);
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
                                String message = e.getMessage();

                                if (e instanceof HttpException) {
                                    ResponseBody body = ((HttpException) e).response().errorBody();
                                    try {
                                        message = body.string();
                                    } catch (IOException ioException) {
                                        ioException.printStackTrace();
                                    }
                                }
                                apiTaskDelegate.onErrorOccured(message);
                            }

                            @Override
                            public void onComplete() {
                                disposable.dispose();
                                apiTaskDelegate.onTaskCompleted(singleResponse);
                            }
                        }));
                break;


            case PATCH:

                disposable.add(caller.getAPI().performPatchMethodRAW(caller.getURL(), headers, body)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeWith(new DisposableObserver<String>() {
                            @Override
                            public void onNext(String s) {
                                singleResponse = s;
                            }

                            @Override
                            public void onError(Throwable e) {
                                String message = e.getMessage();

                                if (e instanceof HttpException) {
                                    ResponseBody body = ((HttpException) e).response().errorBody();
                                    try {
                                        message = body.string();
                                    } catch (IOException ioException) {
                                        ioException.printStackTrace();
                                    }
                                }
                                apiTaskDelegate.onErrorOccured(message);
                            }

                            @Override
                            public void onComplete() {
                                disposable.dispose();
                                apiTaskDelegate.onTaskCompleted(singleResponse);
                            }
                        }));
                break;


            case POST_IMAGE:
                JSONArray array = (JSONArray) caller.getParams().get("files");

                ArrayList<String> filesList = new ArrayList<>();
                for (int i = 0; i < array.length(); i++) {
                    filesList.add(array.optString(i));
                }

                MultipartBody.Part[] imageBody = new MultipartBody.Part[filesList.size()];
                for (int x = 0; x < filesList.size(); x++) {
                    String fileListItem = filesList.get(x);
                    File imgFile = FileUtils.getFile(context, Uri.fromFile(new File(fileListItem)));
                    RequestBody fileBody = RequestBody.create(MediaType.parse("multipart/form-data"), imgFile);
                    MultipartBody.Part multiPartBody = MultipartBody.Part.createFormData("file", imgFile.getName(), fileBody);
                    imageBody[x] = multiPartBody;
                }

                disposable.add(caller.getAPI().uploadFiles(caller.getURL(), headers, imageBody)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeWith(new DisposableObserver<String>() {

                            @Override
                            public void onNext(@NonNull String s) {
                                singleResponse = s;
                            }

                            @Override
                            public void onError(@NonNull Throwable e) {
                                String message = e.getMessage();

                                if (e instanceof HttpException) {
                                    ResponseBody body = ((HttpException) e).response().errorBody();
                                    try {
                                        message = body.string();
                                    } catch (IOException ioException) {
                                        ioException.printStackTrace();
                                    }
                                }
                                apiTaskDelegate.onErrorOccured(message);
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
                                String message = e.getMessage();

                                if (e instanceof HttpException) {
                                    ResponseBody body = ((HttpException) e).response().errorBody();
                                    try {
                                        message = body.string();
                                    } catch (IOException ioException) {
                                        ioException.printStackTrace();
                                    }
                                }
                                apiTaskDelegate.onErrorOccured(message);
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

    @NonNull
    private RequestBody createPartFromString(String descriptionString) {
        return RequestBody.create(
                okhttp3.MultipartBody.FORM, descriptionString);
    }

    @NonNull
    private MultipartBody.Part prepareFilePart(String partName, Uri fileUri) {
        // https://github.com/iPaulPro/aFileChooser/blob/master/aFileChooser/src/com/ipaulpro/afilechooser/utils/FileUtils.java
        // use the FileUtils to get the actual file by uri
        File file = FileUtils.getFile(context, fileUri);

        // create RequestBody instance from file
        RequestBody requestFile =
                RequestBody.create(
                        MediaType.parse(context.getContentResolver().getType(fileUri)),
                        file
                );

        // MultipartBody.Part is used to send also the actual file name
        return MultipartBody.Part.createFormData(partName, file.getName(), requestFile);
    }
}
