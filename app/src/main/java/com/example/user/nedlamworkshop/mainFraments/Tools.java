package com.example.user.nedlamworkshop.mainFraments;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.TabHost;

import com.example.user.nedlamworkshop.helperclass.MyFragmentAdaptor;
import com.example.user.nedlamworkshop.R;
import com.example.user.nedlamworkshop.fragments.background_page;
import com.example.user.nedlamworkshop.fragments.bandsaw;
import com.example.user.nedlamworkshop.fragments.clamp;
import com.example.user.nedlamworkshop.fragments.drill;
import com.example.user.nedlamworkshop.fragments.drillpress;
import com.example.user.nedlamworkshop.fragments.hammer;
import com.example.user.nedlamworkshop.fragments.locking_plier;
import com.example.user.nedlamworkshop.fragments.mallet;
import com.example.user.nedlamworkshop.fragments.measuringtape;
import com.example.user.nedlamworkshop.fragments.metresaw;
import com.example.user.nedlamworkshop.fragments.plier;
import com.example.user.nedlamworkshop.fragments.rotating_tool;
import com.example.user.nedlamworkshop.fragments.sbs;
import com.example.user.nedlamworkshop.fragments.screwdriver;
import com.example.user.nedlamworkshop.fragments.scrollsaw;
import com.example.user.nedlamworkshop.fragments.square;
import com.example.user.nedlamworkshop.fragments.staple_gun;
import com.example.user.nedlamworkshop.fragments.tablesaw;
import com.example.user.nedlamworkshop.fragments.wirecutter;
import com.example.user.nedlamworkshop.fragments.wrench;
import com.example.user.nedlamworkshop.fragments.xblade;

import java.util.List;
import java.util.Vector;

public class Tools extends Fragment implements
        ViewPager.OnPageChangeListener, TabHost.OnTabChangeListener  {

    ViewPager viewPager;
    TabHost tabHost;
    MyFragmentAdaptor myFragmentAdaptor;
    HorizontalScrollView horizontalScrollView;
    View v;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        // Inflate the activated for this fragment
        //TabHostView goes here
        /******************* TabHostView**************************************************/
        v = inflater.inflate(R.layout.webview, container, false);
        this.intViewPage();
        this.intTabHost(savedInstanceState);

      /********************************************************************************/
        return v;
    }
    public class FakeContent implements TabHost.TabContentFactory {
        Context context;

        public FakeContent(Context context) {
            this.context = context;
        }

        @Override
        public View createTabContent(String tag) {
            View fakeView = new View(context);
            fakeView.setMinimumHeight(0);
            fakeView.setMinimumWidth(0);
            return fakeView;
        }
    }

    private void intTabHost(Bundle savedInstanceState){
        tabHost = (TabHost) v.findViewById(R.id.tabHost);
        tabHost.setup();
        //modify according to the number of tools
        String[] tabName = {"Welcome!","Clamp","Hammer","Mallet","Drill","Measuring Tape",
                "Wrench","Staple Gun","Square","Rotating Tool","Screwdriver","Locking Pliers",
                "Stationary Belt Sander","Mitre Saw","Drill Press","Scroll Saw","Band Saw","Table Saw"
        ,"X-Acto Blade","Wire Cutter","Plier"};

        for(int  i = 0;i<tabName.length;i++){
            TabHost.TabSpec tabSpec;
            tabSpec = tabHost.newTabSpec(tabName[i]);
            tabSpec.setIndicator(tabName[i]);
            tabSpec.setContent(new FakeContent(getActivity()));
            tabHost.addTab(tabSpec);
        }
        tabHost.setOnTabChangedListener(this);
    }

    private void intViewPage(){
        List<Fragment> ListFragment = new Vector<Fragment>();
        //add fragments for each tool
        ListFragment.add(new background_page());
        ListFragment.add(new clamp());
        ListFragment.add(new hammer());
        ListFragment.add(new mallet());
        ListFragment.add(new drill());
        ListFragment.add(new measuringtape());
        ListFragment.add(new wrench());
        ListFragment.add(new staple_gun());
        ListFragment.add(new square());
        ListFragment.add(new rotating_tool());
        ListFragment.add(new screwdriver());
        ListFragment.add(new locking_plier());
        ListFragment.add(new sbs());
        ListFragment.add(new metresaw());
        ListFragment.add(new drillpress());
        ListFragment.add(new scrollsaw());
        ListFragment.add(new bandsaw());
        ListFragment.add(new tablesaw());
        ListFragment.add(new xblade());
        ListFragment.add(new wirecutter());
        ListFragment.add(new plier());

        
        this.myFragmentAdaptor = new MyFragmentAdaptor(
                getChildFragmentManager(),ListFragment);
        this.viewPager = (ViewPager) v.findViewById(R.id.view_Pager);
        this.viewPager.setAdapter(this.myFragmentAdaptor);
        this.viewPager.setOnPageChangeListener(this);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        tabHost.setCurrentTab(position);

    }
    //Viewpage Listener
    @Override
    public void onPageScrollStateChanged(int state) {


    }
    //tabhost Listener
    @Override
    public void onTabChanged(String tabId) {
        int tabselected = tabHost.getCurrentTab();
        viewPager.setCurrentItem(tabselected);

        horizontalScrollView = (HorizontalScrollView) v.findViewById(R.id.horizontalScroll);
        View tabview = tabHost.getCurrentTabView();
        int scrollposition = tabview.getLeft() -
                (horizontalScrollView.getWidth()-tabview.getWidth())/2;
        horizontalScrollView.smoothScrollTo(scrollposition, 0);

    }

}