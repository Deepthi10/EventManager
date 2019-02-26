package edu.ecu.cs.eventapp;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.ActivityCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

public class EventActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    ImageView  headerimg;
    TextView headername,headerid;
    ListView listView;
    public static final String MyPREFERENCES = "MyPrefs" ;
    public static String[] pgmNameList = {"Halloween", "Christmas", "Football", "International day"};
    public static int[] pgmImages = {R.drawable.halloweenimage, R.drawable.christmas,R.drawable.football,R.drawable.international };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);
        listView = (ListView) findViewById(R.id.cardlistView);
        listView.setAdapter(new Adapter(EventActivity.this,pgmNameList,pgmImages));

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            }
        });
         //Code for navigation bar

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        TextView title=new TextView(getApplicationContext());
        title.setText("");
        title.setBackgroundColor(Color.parseColor("#003258"));
        title.setPadding(0,20,0,0);
        title.setGravity(Gravity.CENTER_VERTICAL);
        title.setTextColor(Color.WHITE);

        LinearLayout linearLayout=new LinearLayout(getApplicationContext());
        linearLayout.setOrientation(LinearLayout.HORIZONTAL);
        linearLayout.setGravity(Gravity.RIGHT);
        linearLayout.setPadding(200,0,0,0);
        linearLayout.addView(title);
        toolbar.addView(linearLayout);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();


        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);

        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setItemIconTintList(null);
        View headerView=navigationView.getHeaderView(0);
        headerimg=(ImageView)headerView.findViewById(R.id.heaerimageView);
        headername=(TextView)headerView.findViewById(R.id.headername);
        headerid=(TextView)headerView.findViewById(R.id.headerid);
        /*headername.setText(apnsApplication.getFirstname());
        headerid.setText(apnsApplication.getUser_id());*/
        /*System.out.println("Circular image view from mapper: " + headername.getText().toString());
        System.out.println("Circular image view from apns: " + apnsApplication.getUser_id());*/

    }
    @Override
    public void onBackPressed() {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Confirm");
        builder.setMessage("Do you want to exit the app? ");
        builder.setPositiveButton("Stay", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
            }
        });
        builder.setNegativeButton("Exit", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                ActivityCompat.finishAffinity(EventActivity.this);
                android.os.Process.killProcess(android.os.Process.myPid());
            }
        });
        builder.show();

    }
    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        SharedPreferences sharedPreferences;
        if (id == R.id.nav_camera) {
            /*Intent intent4=new Intent(EventActivity.this,UploadProfile.class);
            startActivity(intent4);*/
        }
        else if(id==R.id.nav_profile){

        }
        else if(id==R.id.CreateEvent){


        }
        else if (id==R.id.logout){
            sharedPreferences=getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.clear();
            editor.commit();
            Intent intent=new Intent(EventActivity.this,LoginActivity.class);
            startActivity(intent);

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
