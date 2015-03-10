package utils;

import android.support.v4.app.FragmentTransaction;

import laser.com.church.R;

/**
 * Simple class that creates simple animation on fragmentManager
 *
 * Created by maziere on 28/08/2014.
 */
public class FragmentAnimation {

    /**
     * There is no animation when adding this fragment but has an animation
     * to translate the fragment from top to bottom when closing
     *
     * @param fragmentTransaction
     * @return
     */
    public static FragmentTransaction preparePopDownAnimation(FragmentTransaction fragmentTransaction) {
        return fragmentTransaction.setCustomAnimations(0,
                0,
                R.anim.slide_up,
                R.anim.slide_down);
    }

    /**
     * Opens a fragment by translating from bottom to top. When poping up the
     * fragment, the fragment will translate back down
     * @param fragmentTransaction
     * @return
     */
    public static FragmentTransaction preparePopUpAndDownAnimation(FragmentTransaction fragmentTransaction) {
        return fragmentTransaction.setCustomAnimations(R.anim.slide_up,
                R.anim.slide_down,
                R.anim.slide_up,
                R.anim.slide_down);
    }

    public static FragmentTransaction prepareRightToLeftAnimation(FragmentTransaction fragmentTransaction) {
        return fragmentTransaction.setCustomAnimations(R.anim.slide_in_right,
                R.anim.slide_out_left,
                R.anim.slide_in_right,
                R.anim.slide_out_left);
    }
}
