package com.example.user.nedlamworkshop;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.user.nedlamworkshop.IdeaBoard.add_idea;
import com.example.user.nedlamworkshop.helperclass.NavigateAdaptor;
import com.example.user.nedlamworkshop.helperclass.NavigateTools;
import com.example.user.nedlamworkshop.mainFraments.Floor_Plan;
import com.example.user.nedlamworkshop.mainFraments.Project;
import com.example.user.nedlamworkshop.mainFraments.Tools;
import com.example.user.nedlamworkshop.mainFraments.IdealBoard;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Michael on 7/26/2016.
 */
public class MainActivity extends ActionBarActivity {
        DrawerLayout drawerLayout;
    RelativeLayout drawerpane;
    ListView lvNav;
    List<NavigateTools> listNavTools;
    List<Fragment> listFragment;

    ActionBarDrawerToggle actionBarDrawerToggle;

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(actionBarDrawerToggle.onOptionsItemSelected(item)){
            return true;}
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
                super.onPostCreate(savedInstanceState);
                actionBarDrawerToggle.syncState();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sliding);
        String name = getIntent().getStringExtra("name");
        TextView txt = (TextView) findViewById(R.id.tool_nameX);
        txt.setText(name);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawerpane = (RelativeLayout) findViewById(R.id.drawer_pane);
        lvNav = (ListView) findViewById(R.id.nav_list);


       listNavTools = new ArrayList<NavigateTools>();
       listNavTools.add(new NavigateTools("Tools", "Looking For a Tool?",R.drawable.toolsbu));
       listNavTools.add(new NavigateTools("Idea Board", "What's on your mind?",R.drawable.ideaboard));
       listNavTools.add(new NavigateTools("Projects", "Gallery",R.drawable.projectbu1));
       listNavTools.add(new NavigateTools("Floor Plan", "Check Me Out!",R.drawable.floorplanb));

        NavigateAdaptor navigateAdaptor = new NavigateAdaptor(getApplicationContext(), R.layout.tool_navlist, listNavTools);
        lvNav.setAdapter(navigateAdaptor);

        listFragment = new ArrayList<Fragment>();
        listFragment.add(new Tools());
        listFragment.add(new IdealBoard());
        listFragment.add(new Project());
        listFragment.add(new Floor_Plan());


        //load first fragment as default
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.main_content, listFragment.get(0)).commit();

        setTitle(listNavTools.get(0).getToolName());
        lvNav.setItemChecked(0, true);
        drawerLayout.closeDrawer(drawerpane);
        lvNav.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //replace fragment with the selected fragment
                FragmentManager fragmentManager = getSupportFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.main_content, listFragment.get(position)).commit();

                setTitle(listNavTools.get(position).getToolName());
                lvNav.setItemChecked(position, true);
                drawerLayout.closeDrawer(drawerpane);
            }
        });
        //create listener for drawer activated
        actionBarDrawerToggle = new ActionBarDrawerToggle(this,drawerLayout,
                R.string.drawer_opened, R.string.drawer_closed){
            @Override
            public void onDrawerOpened(View drawerView) {
                invalidateOptionsMenu();
                super.onDrawerOpened(drawerView);
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                invalidateOptionsMenu();
                super.onDrawerClosed(drawerView);
            }
        };
        drawerLayout.setDrawerListener(actionBarDrawerToggle);

    }
}
