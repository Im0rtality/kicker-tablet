package lt.nfq.hh.kickertablet.Api.Framework;

import com.octo.android.robospice.request.retrofit.RetrofitSpiceRequest;

import lt.nfq.hh.kickertablet.Api.Network.Api;

public class StatusRequest extends RetrofitSpiceRequest<lt.nfq.hh.kickertablet.Api.Model.Status, Api> {

    public StatusRequest() {
        super(lt.nfq.hh.kickertablet.Api.Model.Status.class, Api.class);
    }

    public lt.nfq.hh.kickertablet.Api.Model.Status loadDataFromNetwork() {
        return getService().status();
    }
}
