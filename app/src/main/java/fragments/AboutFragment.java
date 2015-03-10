package fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import laser.com.church.R;

/**
 * Created by SumitBhatia on 9/03/15.
 */
public class AboutFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_impinfo, container, false);
        ((TextView)view.findViewById(R.id.txtInfo)).setText("About section here");
        return view;
    }
}
