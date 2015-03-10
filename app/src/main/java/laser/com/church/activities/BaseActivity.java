package laser.com.church.activities;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

import application.ChurchApp;
import fragments.BaseFragment;
import laser.com.church.R;

/**
 * Created by SumitBhatia on 27/02/15.
 */
public class BaseActivity extends ActionBarActivity {
    public static final Float APP_VERSION = Float.valueOf(0.01f);
    private ChurchApp application;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        application = (ChurchApp)getApplication();

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setHomeButtonEnabled(true);
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setIcon(R.drawable.ic_drawer);
        }
    }

    protected ChurchApp getApplicationInstance(){
        return application;
    }

//    protected BaseActivity getContext(){
//        return mContext;
//    }

    public void showShortMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    public void showLongMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    public ProgressDialog getProgressDialog() {
        return progressDialog;
    }

    public void setProgressDialog(ProgressDialog progressDialog) {
        this.progressDialog = progressDialog;
    }

    public void showProgressDialog() {
        if (progressDialog == null) {
            progressDialog = ProgressDialog.show(this, null, null, false, false);
//            progressDialog.setContentView(R.layout.progress_layout);
        }
    }

    public void hideProgressDialog() {
        if (progressDialog != null && progressDialog.isShowing()) {
            progressDialog.dismiss();
        }
        progressDialog = null;
    }

    public void hideKeyboard() {
        try {
            InputMethodManager mgr = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            mgr.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void showKeyboard() {
        try {
            InputMethodManager mgr = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            mgr.toggleSoftInput(InputMethodManager.SHOW_FORCED,0);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
