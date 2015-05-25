/*
 * Copyright 2012 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package martin.prevencion;

import android.app.ActionBar;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.app.NavUtils;
import android.support.v4.app.TaskStackBuilder;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.zip.Inflater;

public class SwipeTab extends BaseMenu{

    static String value1,value2,value3;

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide fragments representing
     * each object in a collection. We use a {@link android.support.v4.app.FragmentStatePagerAdapter}
     * derivative, which will destroy and re-create fragments as needed, saving and restoring their
     * state in the process. This is important to conserve memory and is a best practice when
     * allowing navigation between objects in a potentially large collection.
     */
    DemoCollectionPagerAdapter mDemoCollectionPagerAdapter;

    /**
     * The {@link android.support.v4.view.ViewPager} that will display the object collection.
     */
    ViewPager mViewPager;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        LayoutInflater inflater = (LayoutInflater)this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View encuesta = inflater.inflate(R.layout.activity_collection_demo,null);
        pri.addView(encuesta);

        value1 = getResources().getString(R.string.vih_info);
        value2 = getResources().getString(R.string.vih_prevencion);
        value3 = getResources().getString(R.string.vih_etapas);


        // Create an adapter that when requested, will return a fragment representing an object in
        // the collection.
        // 
        // ViewPager and its adapters use support library fragments, so we must use
        // getSupportFragmentManager.
       mDemoCollectionPagerAdapter = new DemoCollectionPagerAdapter(getSupportFragmentManager());



        // Set up the ViewPager, attaching the adapter.
        mViewPager = (ViewPager) findViewById(R.id.pager);
        mViewPager.setAdapter(mDemoCollectionPagerAdapter);


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent k = new Intent(SwipeTab.this, MainActivity.class);
        k.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        startActivityForResult(k, 0);
        SwipeTab.this.finish();

        return super.onOptionsItemSelected(item);


    }

    /**
     * A {@link android.support.v4.app.FragmentStatePagerAdapter} that returns a fragment
     * representing an object in the collection.
     */
    public static class DemoCollectionPagerAdapter extends FragmentStatePagerAdapter {

        public DemoCollectionPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int i) {
            Fragment fragment = new DemoObjectFragment();
            Bundle args = new Bundle();
            switch(i)
            {
                case(0): { args.putString(DemoObjectFragment.ARG_OBJECT, value1);break;}
                case(1):  { args.putString(DemoObjectFragment.ARG_OBJECT, value3);break;}
                case(2):  { args.putString(DemoObjectFragment.ARG_OBJECT, value2);break;}
            }
            fragment.setArguments(args);

            return fragment;
        }

        @Override
        public int getCount() {
            // For this contrived example, we have a 100-object collection.
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
          String name="";
            switch(position)
          {
              case(0): {name="VIH Y EL SIDA";break;}
              case(1): {name="ETAPAS";break;}
              case(2): {name="PREVENCION";break;}
          }
        return name;

        }
    }

    /**
     * A dummy fragment representing a section of the app, but that simply displays dummy text.
     *
     *
     *
     */

    @Override
    public void onBackPressed() {
        Intent k = new Intent(SwipeTab.this, MainActivity.class);
        k.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        startActivityForResult(k, 0);
        SwipeTab.this.finish();
        return;
    }

    public static class DemoObjectFragment extends Fragment {

        public static final String ARG_OBJECT = "object";

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_collection_object, container, false);
            Bundle args = getArguments();
            ((TextView) rootView.findViewById(android.R.id.text1)).setText(
                   args.getString(ARG_OBJECT));
            return rootView;
        }
    }


}
