package lt.nfq.hh.kickertablet;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.octo.android.robospice.SpiceManager;
import com.octo.android.robospice.persistence.DurationInMillis;
import com.octo.android.robospice.persistence.exception.SpiceException;
import com.octo.android.robospice.request.listener.RequestListener;

import lt.nfq.hh.kickertablet.Api.Framework.Service;
import lt.nfq.hh.kickertablet.Api.Framework.StatusRequest;
import lt.nfq.hh.kickertablet.Api.Model.Status;

public class MyActivity extends Activity {
    private SpiceManager spiceManager = new SpiceManager(Service.class);
    private TextView mTextView;
    private StatusRequest statusRequest;

    @Override
    protected void onStart() {
        spiceManager.start(this);
        super.onStart();
        getSpiceManager().execute(statusRequest, "table/status", DurationInMillis.ONE_SECOND, new StatusRequestListener());
    }

    @Override
    protected void onStop() {
        spiceManager.shouldStop();
        super.onStop();
    }

    protected SpiceManager getSpiceManager() {
        return spiceManager;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        mTextView = (TextView) findViewById(R.id.text);


        statusRequest = new StatusRequest();
    }

    private void updateStatus(final Status result) {
        String originalText = getString(R.string.default_text);

        mTextView.setText(
                String.format(
                        "%s \n\nstatus: %s\ntable: %s\n", originalText, result.status, result.table
                )
        );
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    public final class StatusRequestListener implements RequestListener<Status> {
        @Override
        public void onRequestFailure(SpiceException spiceException) {
            Toast.makeText(MyActivity.this, "failure", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onRequestSuccess(final Status result) {
            Toast.makeText(MyActivity.this, "success", Toast.LENGTH_SHORT).show();
            updateStatus(result);
        }
    }
}
