package com.scopely.integration.leanplum;


import com.scopely.integration.leanplum.model.Advance;
import com.scopely.integration.leanplum.model.Track;
import retrofit.http.GET;
import retrofit.http.QueryMap;
import rx.Observable;

import java.util.HashMap;

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


}
