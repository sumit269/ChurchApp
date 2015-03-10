package laser.com.church.activities;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import fragments.AboutFragment;
import fragments.BishopsFragment;
import fragments.ContactUsFragment;
import fragments.HomeFragment;
import fragments.ImpInfoFragment;
import fragments.MassTimesFragment;
import laser.com.church.R;
import utils.AppUtils;

/**
 * Created by SumitBhatia on 27/02/15.
 */
public class HomeActivity extends ActionBarActivity {

    private static final String FRAGMENT_TAG_HOME = "HomeFragment";
    private Fragment fragment;
    private String[] mNavItems;
    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;
    private ActionBarDrawerToggle mDrawerToggle;

    private int selectedPosition = -1;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_layout);

        mNavItems = getResources().getStringArray(R.array.nav_menu_array);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerList = (ListView) findViewById(R.id.left_drawer);

        mDrawerToggle = new ActionBarDrawerToggle(
                this,                  /* host Activity */
                mDrawerLayout,         /* DrawerLayout object */
                R.string.sampletext,  /* "open drawer" description */
                R.string.sampletext/* "close drawer" description */  /* nav drawer icon to replace 'Up' caret */
        ) {

            /** Called when a drawer has settled in a completely closed state. */
            public void onDrawerClosed(View view) {
                super.onDrawerClosed(view);

            }

            /** Called when a drawer has settled in a completely open state. */
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);

            }
        };

        mDrawerLayout.setDrawerListener(mDrawerToggle);
        // Set the adapter for the list view
        mDrawerList.setAdapter(new ArrayAdapter<String>(this,
                R.layout.drawer_list_item, mNavItems));
        // Set the list's click listener
        mDrawerList.setOnItemClickListener(new DrawerItemClickListener());

        fragment = getSupportFragmentManager().findFragmentByTag(FRAGMENT_TAG_HOME);
        if (savedInstanceState == null || fragment == null) {
            selectItem(0);
        }
    }


    private class DrawerItemClickListener implements ListView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView parent, View view, int position, long id) {
            selectItem(position);
        }

    }

    /**
     * Swaps fragments in the main content view
     */
    private void selectItem(int position) {
        if (selectedPosition != position) {
            if (position == 0) {
                fragment = new HomeFragment();
                getSupportActionBar().setTitle("History");
            } else if (position == 1) {
                fragment = new BishopsFragment();
                getSupportActionBar().setTitle("Bishops");
            } else if (position == 2) {
                fragment = new MassTimesFragment();
                getSupportActionBar().setTitle("Mass times");
            } else if (position == 3) {
                fragment = new ImpInfoFragment();
                getSupportActionBar().setTitle("Important information");
            } else if (position == 4) {
                fragment = new ContactUsFragment();
                getSupportActionBar().setTitle("Contact us");
            } else if (position == 5) {
                fragment = new AboutFragment();
                getSupportActionBar().setTitle("About");
            }
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.content_frame, fragment, FRAGMENT_TAG_HOME)
                    .setTransition(FragmentTransaction.TRANSIT_NONE)
                    .commit();
            mDrawerLayout.closeDrawer(mDrawerList);
            selectedPosition = position;
        }
    }

    @Override
    public void onBackPressed() {
        if (getSupportFragmentManager().getBackStackEntryCount() > 0) {
            getSupportFragmentManager().popBackStack();
            return;
        } else {
            AppUtils.showAlertDialog(this, "Exit application", "Are you sure?", "Yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    HomeActivity.this.finish();
                }
            }, "No", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            });
            return;
        }
    }
}