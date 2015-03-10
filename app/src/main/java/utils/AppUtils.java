package utils;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.view.View;

import java.util.Locale;

import laser.com.church.R;
import laser.com.church.activities.BaseActivity;

/**
 * Created by SumitBhatia on 9/03/15.
 */
public final class AppUtils {


    public static void callNumber(String number){


    }

    public static void showMap(Context context, Uri geoLocation) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(geoLocation);
        if (intent.resolveActivity(context.getPackageManager()) != null) {
            context.startActivity(intent);
        }
    }

    public static void sendEmail(Context context, String email){
        Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto",email, null));
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Trying to email church");
        context.startActivity(Intent.createChooser(emailIntent, "Send email..."));
    }

    public static void dialPhoneNumber(Context context, String phoneNumber) {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:" + phoneNumber));
        if (intent.resolveActivity(context.getPackageManager()) != null) {
            context.startActivity(intent);
        }
    }

    public static void showAlertDialog(Context context, String titleResId, String message, String button1, DialogInterface.OnClickListener listener1,
                                       String button2, DialogInterface.OnClickListener listener2){

        AlertDialogFragment fragment = new AlertDialogFragment(listener1, listener2);
        Bundle bundle = new Bundle();
        bundle.putString("title", titleResId);
        bundle.putString("message", message);
        bundle.putString("button1", button1);
        bundle.putString("button2", button2);
        fragment.setArguments(bundle);
        fragment.show(((ActionBarActivity)context).getSupportFragmentManager(), "testTag");

    }

}
