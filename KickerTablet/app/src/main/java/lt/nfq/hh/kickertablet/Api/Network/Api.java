package lt.nfq.hh.kickertablet.Api.Network;

import retrofit.http.GET;

public interface Api {

    @GET("/status")
    lt.nfq.hh.kickertablet.Api.Model.Status status();
}
