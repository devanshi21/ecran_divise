package com.example.feni.callotherappfinal;

/**
 * Created by Feni on 01-03-2018.
 */

//package com.example.devanshi.callotherappexample;

        import android.app.Activity;
        import android.app.ListActivity;
        import android.app.ProgressDialog;
        import android.content.ActivityNotFoundException;
        import android.content.Intent;
        import android.content.pm.ApplicationInfo;
        import android.content.pm.PackageManager;
        import android.os.AsyncTask;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.ListView;
        import android.widget.Toast;

        import java.util.ArrayList;
        import java.util.List;

/**
 * Created by devanshi on 12/2/2017.
 */
//package com.example.devanshi.listofapps;


        import android.app.ProgressDialog;
        import android.content.ActivityNotFoundException;
        import android.content.AsyncTaskLoader;
        import android.content.pm.ApplicationInfo;
        import android.content.pm.PackageManager;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.app.ListActivity;
        import android.view.Menu;
        import android.view.MenuItem;
        import android.os.AsyncTask;
        import android.view.View;
        import android.widget.ListView;
        import android.widget.Toast;
        import android.content.Intent;

        import java.util.ArrayList;
        import java.util.List;

public class Display extends ListActivity {

    private PackageManager packageManager=null;
    private List<ApplicationInfo> applist=null;
    private AppAdapter listadapter=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);

        packageManager=getPackageManager();
        new LoadApplications().execute();
    }
    protected void onListItemClick(ListView l, View v, int position, long id){
        super.onListItemClick(l,v,position,id);
        ApplicationInfo app=applist.get(position);
        try{
            Intent intent =packageManager.getLaunchIntentForPackage(app.packageName);
            if(intent!=null){
                startActivity(intent);
            }
        }catch(ActivityNotFoundException e){
            Toast.makeText(Display.this,e.getMessage(),Toast.LENGTH_LONG).show();
        }catch(Exception e){
            Toast.makeText(Display.this,e.getMessage(),Toast.LENGTH_LONG).show();
        }
    }
    private List<ApplicationInfo> checkForLaunchIntent(List<ApplicationInfo> list){
        ArrayList<ApplicationInfo> appList=new ArrayList<ApplicationInfo>(){};
        for(ApplicationInfo info : list){
            try{
                if(packageManager.getLaunchIntentForPackage(info.packageName)!=null){
                    appList.add(info);
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        return appList;
    }

    private class LoadApplications extends AsyncTask<Void,Void,Void> {
        private ProgressDialog progress=null;
        protected Void doInBackground(Void... params){
            applist=checkForLaunchIntent(packageManager.getInstalledApplications(PackageManager.GET_META_DATA));
            listadapter=new AppAdapter(Display.this,R.layout.list_item,applist);
            return null;
        }
        protected void onPostExecute(Void result){
            setListAdapter(listadapter);
            progress.dismiss();
            super.onPostExecute(result);
        }
        protected void onPreExecute(){
            progress=ProgressDialog.show(Display.this,null,"Loading application");
            super.onPreExecute();
        }
    }
}

