package utils;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;

/**
 * Created by SumitBhatia on 9/03/15.
 */
public class AlertDialogFragment extends DialogFragment {

    private String title;
    private String message;
    private String button1;
    private String button2;
    private DialogInterface.OnClickListener listener1;
    private DialogInterface.OnClickListener listener2;

    public AlertDialogFragment(){ }

    @SuppressLint("ValidFragment")
    public AlertDialogFragment(DialogInterface.OnClickListener listener1, DialogInterface.OnClickListener listener2){

        this.listener1 = listener1;
        this.listener2 = listener2;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        Bundle bundle = getArguments();
        this.title = bundle.getString("title");
        this.message = bundle.getString("message");
        this.button1 = bundle.getString("button1");
        this.button2 = bundle.getString("button2");

        // Use the Builder class for convenient dialog construction
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        builder.setTitle(title)
                .setMessage(message)
                .setPositiveButton(button1, listener1)
                .setNegativeButton(button2, listener2);
        // Create the AlertDialog object and return it
        return builder.create();
    }
}
