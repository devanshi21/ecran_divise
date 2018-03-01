package com.example.feni.callotherappfinal;

//package com.example.devanshi.callotherappexample;

        import android.content.ComponentName;
        import android.content.Intent;
        import android.content.pm.PackageManager;
        import android.support.v7.app.AppCompatActivity;
        import android.content.pm.ApplicationInfo;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.view.View.OnClickListener;

public class MainActivity extends AppCompatActivity {

    //   private String package_name="com.example.devanshi.listofapps";
    // private String class_name="com.example.devanshi.listofapps.MainActivity";
    private Button bt;
    private Button bt1;
    public PackageManager packageManager=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt =(Button) findViewById(R.id.button1);
        bt.setOnClickListener(new OnClickListener(){
            public void onClick(View arg0){
                Intent i=new Intent(MainActivity.this,Display.class);
                startActivity(i);
            }
        });
        bt1 =(Button) findViewById(R.id.button2);
        bt1.setOnClickListener(new OnClickListener(){
            public void onClick(View arg0){
                Intent i=new Intent(MainActivity.this,Display.class);
                startActivity(i);
            }
        });
    }
   /* protected void launchCall(){
        Intent intent=new Intent();
        intent.setAction(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_LAUNCHER);
        intent.setComponent(new ComponentName(package_name,class_name));
        try{
            startActivity(intent);
        }catch(Exception e){}
    }*/
}