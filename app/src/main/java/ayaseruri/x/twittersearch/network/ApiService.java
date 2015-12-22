package ayaseruri.x.twittersearch.network;

import ayaseruri.x.twittersearch.objectholder.SearchResultInfo;
import ayaseruri.x.twittersearch.objectholder.TokenInfo;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.GET;
import retrofit.http.Header;
import retrofit.http.Headers;
import retrofit.http.POST;
import retrofit.http.Query;
import rx.Observable;

/**
 * Created by ayaseruri on 15/12/22.
 */
public interface ApiService {
    @FormUrlEncoded
    @Headers("Content-Type: application/x-www-form-urlencoded;charset=UTF-8")
    @POST("oauth2/token")
    Observable<TokenInfo> getTokenInfo(@Header("Authorization") String authorHeader, @Field("grant_type") String grantType);

    @GET("/1.1/search/tweets.json")
    Observable<SearchResultInfo> getSearchResult(@Header("Authorization") String authorHeader, @Query("q")String key);
}
