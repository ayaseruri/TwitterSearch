package ayaseruri.x.twittersearch.network;

import com.squareup.okhttp.Authenticator;
import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;
import java.net.Proxy;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import retrofit.RxJavaCallAdapterFactory;

/**
 * Created by ayaseruri on 15/12/22.
 */
public class RetrofitClient {
        private static final String AUTHORIZATION = "Authorization";
        private static ApiService apiService;
        public static String authorStr = "";

        public static ApiService getApiServiceInstance(){
            if(null == apiService){
                    OkHttpClient okHttpClient = new OkHttpClient();
                    okHttpClient.networkInterceptors().add(new Interceptor() {
                            @Override
                            public Response intercept(Chain chain) throws IOException {
                                    Request originalRequest = chain.request();
                                    Request authorisedRequest = originalRequest.newBuilder()
                                            .header(AUTHORIZATION, authorStr)
                                            .build();
                                    return chain.proceed(authorisedRequest);
                            }
                    });


                    okHttpClient.setAuthenticator(new Authenticator() {
                            @Override
                            public Request authenticate(Proxy proxy, Response response) throws IOException {
                                    return response.request().newBuilder()
                                            .addHeader(AUTHORIZATION, authorStr)
                                            .build();
                            }

                            @Override
                            public Request authenticateProxy(Proxy proxy, Response response) throws IOException {
                                    return null;
                            }
                    });
                    apiService = new Retrofit.Builder()
                            .baseUrl("https://api.twitter.com/")
                            .addConverterFactory(GsonConverterFactory.create())
                            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                            .client(okHttpClient)
                            .build()
                            .create(ApiService.class);
            }
            return apiService;
    }
}
