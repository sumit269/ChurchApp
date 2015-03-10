package fragments;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import laser.com.church.R;
import utils.AppUtils;

/**
 * Created by SumitBhatia on 9/03/15.
 */
public class ContactUsFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_contactus, container, false);
        ((TextView) view.findViewById(R.id.txt_churchName)).setText(R.string.church_name);
        ((TextView) view.findViewById(R.id.txt_churchSlogan)).setText(R.string.church_slogan);
        ((TextView) view.findViewById(R.id.txt_churchAddress)).setText(R.string.church_address);
        ((TextView) view.findViewById(R.id.txt_churchAddress)).setText(R.string.church_address);
        ((TextView) view.findViewById(R.id.txt_churchPostalAddress)).setText(R.string.postal_address);

        ((TextView) view.findViewById(R.id.txt_LocateOnMap)).setText(Html.fromHtml(getResources().getString(R.string.locate_on_map)));
        (view.findViewById(R.id.txt_LocateOnMap)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppUtils.showMap(getActivity(), Uri.parse("geo:-27.473739,153.0156?z=11"));
            }
        });

        ((TextView) view.findViewById(R.id.txt_churchTelephone)).setText(R.string.church_telephone);
        (view.findViewById(R.id.txt_churchTelephone)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppUtils.dialPhoneNumber(getActivity(), ((TextView) view.findViewById(R.id.txt_churchTelephone)).getText().toString());
            }
        });

        ((TextView) view.findViewById(R.id.txt_churchEmail)).setText(R.string.church_email);
        ( view.findViewById(R.id.txt_churchEmail)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppUtils.sendEmail(getActivity(), ((TextView) view.findViewById(R.id.txt_churchEmail)).getText().toString());
            }
        });

        return view;
    }


}
