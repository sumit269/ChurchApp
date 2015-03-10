package fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import laser.com.church.R;
import model.Bishop;

/**
 * Created by SumitBhatia on 3/03/15.
 */
public class BishopDetailsFragment extends Fragment {

    Bishop mBishop;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle bundle = getArguments();
        mBishop = (Bishop) bundle.getSerializable("bishopDetails");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_bishop_details, container, false);
        if(mBishop!=null){
            ((TextView) view.findViewById(R.id.bishopName)).setText(mBishop.name.first +" "+ mBishop.name.last);
            ((TextView) view.findViewById(R.id.bishopAbout)).setText(mBishop.about);
            ((TextView) view.findViewById(R.id.bishopName)).setText(mBishop.name.first +" "+ mBishop.name.last);
            ((TextView) view.findViewById(R.id.bishopName)).setText(mBishop.name.first +" "+ mBishop.name.last);
            ((TextView) view.findViewById(R.id.bishopName)).setText(mBishop.name.first +" "+ mBishop.name.last);
            ((TextView) view.findViewById(R.id.bishopName)).setText(mBishop.name.first +" "+ mBishop.name.last);
        }
        return view;
    }
}
