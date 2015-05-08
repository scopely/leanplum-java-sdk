package com.scopely.integration.leanplum;


import com.scopely.integration.leanplum.model.Advance;
import com.scopely.integration.leanplum.model.DownloadFile;
import com.scopely.integration.leanplum.model.Track;
import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Query;
import retrofit.http.QueryMap;
import rx.Observable;

/**
 * Leanplum's API is primarily comprised of GET requests
 */
public interface LeanplumApi {
    /**
     * <a href="https://www.leanplum.com/dashboard#/5064964386062336/help/setup/api/advance">Advance Docs</a>
     */
    @GET("/api?action=advance")
    Observable<LeanplumResponse> advance(@QueryMap Advance advance);

    /**
     * <a href="https://www.leanplum.com/dashboard#/5064964386062336/help/setup/api/track">Track Docs</a>
     */
    @GET("/api?action=track")
    Observable<LeanplumResponse> track(@QueryMap Track track);

    @GET("/api?action=downloadFile")
    Observable<LeanplumResponse> downloadFile(@QueryMap DownloadFile downloadFile);

    @POST("/api?action=multi")
    Observable<LeanplumResponse> multi(@Query("time") long epochSeconds, @Body LeanplumRequestBatch batch);

}
