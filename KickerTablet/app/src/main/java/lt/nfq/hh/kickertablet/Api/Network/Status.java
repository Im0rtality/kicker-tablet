package lt.nfq.hh.kickertablet.Api.Network;

import com.octo.android.robospice.request.retrofit.RetrofitSpiceRequest;

public class Status {

    public class Model {
        public String status;
        public String table;
    }

    public static class Request extends RetrofitSpiceRequest<Model, Api> {

        public Request() {
            super(Model.class, Api.class);
        }

        public Model loadDataFromNetwork() {
            return getService().status();
        }
    }
}
