package lt.nfq.hh.kickertablet.Api.Framework;

import com.octo.android.robospice.retrofit.RetrofitGsonSpiceService;

import lt.nfq.hh.kickertablet.Api.Network.Api;

public class Service extends RetrofitGsonSpiceService {

    private final static String BASE_URL = "http://private-9608e-kickertablet.apiary-mock.com";

    @Override
    public void onCreate() {
        super.onCreate();
        addRetrofitInterface(Api.class);
    }

    @Override
    protected String getServerUrl() {
        return BASE_URL;
    }
}
