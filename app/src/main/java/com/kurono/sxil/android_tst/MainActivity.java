package com.kurono.sxil.android_tst;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.Menu;
import android.support.v4.view.ViewPager;
import android.view.MenuItem;

import com.astuetz.PagerSlidingTabStrip;

public class MainActivity extends FragmentActivity{
    ViewPager viewPager;
    PagerSlidingTabStrip tabs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = (ViewPager)findViewById(R.id.pager);
        viewPager.setAdapter(new SampleAdapter(getSupportFragmentManager()));

        tabs = (PagerSlidingTabStrip)findViewById(R.id.tabs);
        tabs.setViewPager(viewPager);
        //pagerで動かした時の現在表示されてるタブに下線をつける
        tabs.setIndicatorColor(0xFFFF0000);
        //pagerでうごかした時の現在選択されているタブの色を変える
        tabs.setDividerColor(0xFF666666);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private class SampleAdapter extends FragmentPagerAdapter {

        private  final  String[] Title = {"test1","test2"};
        public SampleAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
                switch (position){
                    case 0:
                        return new FragmentFirst();
                    case 1:
                        return new FragmentSecond();
                }
            return null;
        }

        @Override
        public int getCount() {
            return Title.length;
        }
        @Override
        public CharSequence getPageTitle(int position) {
            return Title[position];
        }
    }
}
