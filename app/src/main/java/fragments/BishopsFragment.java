package fragments;


import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import org.json.JSONException;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import adapters.BishopsAdapter;
import laser.com.church.R;
import model.Bishop;
import utils.FragmentAnimation;

/**
 * Created by SumitBhatia on 28/02/15.
 */
public class BishopsFragment extends Fragment {

    private final String FRAGMENT_TAG = "bishopDetails";
    ListView listBishops;
    List<Bishop> bishopsCollection = new ArrayList<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_bishops_layout, container, false);
        listBishops = (ListView) view.findViewById(R.id.list_bishops);

        try {
            bishopsCollection = readFile();
        } catch (JSONException ex) {
            return null;
        }

        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        BishopsAdapter adapter = new BishopsAdapter(getActivity(), R.layout.bishops_list_item, bishopsCollection);
        listBishops.setAdapter(adapter);

        listBishops.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Intent intent = new Intent(getActivity(), BishopsDetails.class);
                Fragment detailsFragment = new BishopDetailsFragment();
                Bundle bundle = new Bundle();
                bundle.putSerializable("bishopDetails", bishopsCollection.get(position));
                detailsFragment.setArguments(bundle);
                FragmentAnimation.preparePopUpAndDownAnimation(getActivity().getSupportFragmentManager().beginTransaction())
                        .add(R.id.content_frame,detailsFragment,FRAGMENT_TAG )
                        .addToBackStack(null)
                        .commit();
            }
        });
    }

    private List<Bishop> readFile() throws JSONException {
        String result = null;
        // To load text file
        InputStream input;
        try {
            input = getActivity().getAssets().open("church_bishops.json");
            int size = input.available();
            byte[] buffer = new byte[size];
            input.read(buffer);
            input.close();
            result = new String(buffer);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return createBishopJsonArray(result);
    }

    private List<Bishop> createBishopJsonArray(String result) throws JSONException {

        if (result == null) {
            return null;
        }
        JsonParser parser = new JsonParser();
        JsonArray jArray = parser.parse(result).getAsJsonArray();

        Gson gson = new Gson();
        for (JsonElement obj : jArray) {
            Bishop bishop = gson.fromJson(obj, Bishop.class);
            bishopsCollection.add(bishop);
        }
        return bishopsCollection;
    }

}
