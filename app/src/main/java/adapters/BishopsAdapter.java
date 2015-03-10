package adapters;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import laser.com.church.R;
import model.Bishop;

/**
 * Created by SumitBhatia on 28/02/15.
 */
public class BishopsAdapter extends ArrayAdapter<Bishop> {

    private Activity mContext;
    private List<Bishop> mBishopsArray;
    private int mResId;

    public BishopsAdapter(Activity context, int resource, List<Bishop> bishopsArray) {
        super(context, resource, bishopsArray);
        mBishopsArray = bishopsArray;
        mContext = context;
        mResId = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        ViewHolder holder;
        if (view == null) {
            view = mContext.getLayoutInflater().inflate(R.layout.bishops_list_item, null);
            holder = new ViewHolder();
            holder.txtThumbNail = (ImageView) view.findViewById(R.id.imgThumbnail);
            holder.txtName = ((TextView) view.findViewById(R.id.txtName));
            holder.txtDesignation = ((TextView) view.findViewById(R.id.txtDesignation));
            holder.txtChurchName = ((TextView) view.findViewById(R.id.txtChurchName));
            view.setTag(holder);
        }
        holder = (ViewHolder) view.getTag();
        Bishop bishop = mBishopsArray.get(position);
        holder.txtThumbNail.setImageResource(R.drawable.priest);
        holder.txtName.setText(bishop.name.first + " " + bishop.name.last);
        holder.txtDesignation.setText(bishop.designation);
        holder.txtChurchName.setText(bishop.churchName);
        return view;
    }

    @Override
    public Bishop getItem(int position) {
        return mBishopsArray.get(position);
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    private class ViewHolder {
        private ImageView txtThumbNail;
        private TextView txtName;
        private TextView txtDesignation;
        private TextView txtChurchName;
    }
}
