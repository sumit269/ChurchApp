package fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.TextView;

import laser.com.church.R;

/**
 * Created by SumitBhatia on 9/03/15.
 */
public class MassTimesFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_masstimings, container, false);
        ((WebView) view.findViewById(R.id.web_masstiming)).loadDataWithBaseURL(null, getResources().getString(R.string.mass_timings), "text/html", "UTF-8", null);
        ((WebView) view.findViewById(R.id.web_masstiming)).setBackgroundColor(0x00000000);
        return view;
    }
}
