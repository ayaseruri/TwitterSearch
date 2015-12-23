package ayaseruri.x.twittersearch.network;

import com.squareup.okhttp.OkHttpClient;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import retrofit.RxJavaCallAdapterFactory;

/**
 * Created by ayaseruri on 15/12/22.
 */
public class RetrofitClient {
    public static ApiService apiService = new Retrofit.Builder()
            .baseUrl("https://api.twitter.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
            .client(new OkHttpClient())
            .build()
            .create(ApiService.class);
}
