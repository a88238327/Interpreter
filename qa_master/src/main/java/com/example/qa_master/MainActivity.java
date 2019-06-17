package com.example.qa_master;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public boolean checkflag;
    public boolean quickflag;
    public boolean nextflag;
    public boolean micflag;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        //getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        hideBottomUIMenu();
        final ImageView checkbuttom=findViewById(R.id.checkbutton);
        final ImageView quickbuttom=findViewById(R.id.quickbuttom);
        final ImageView restart=findViewById(R.id.restart);
        final ImageView next=findViewById(R.id.next);
        final ImageView mic=findViewById(R.id.mic);
//        final ImageView mic=findViewById(R.id.mic);
        checkflag=false;
        quickflag=false;
        nextflag=false;
        micflag=false;
        checkbuttom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!checkflag)
                {
                    checkbuttom.setBackgroundResource(R.mipmap.check_true);
                    checkflag=true;
                }
                else {
                    checkbuttom.setBackgroundResource(R.mipmap.check_false);
                    checkflag=false;
                }

            }
        });
        quickbuttom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!quickflag)
                {
                    quickbuttom.setBackgroundResource(R.mipmap.quick_true);
                    quickflag=true;
                }
                else {
                    quickbuttom.setBackgroundResource(R.mipmap.quick_false);
                    quickflag=false;
                }
            }
        });
        restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!nextflag)
                {
                    next.setBackgroundResource(R.mipmap.next_true);
                    nextflag=true;
                }
                else {
                    next.setBackgroundResource(R.mipmap.next_false);
                    nextflag=false;
                }
            }
        });
        mic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!micflag)
                {
                    mic.setBackgroundResource(R.mipmap.mic_true);
                    micflag=true;
                }
                else {
                    mic.setBackgroundResource(R.mipmap.mic_false);
                    micflag=false;
                }
            }
        });
       // ArrayList<HashMap<String,String>> list=new ArrayList<>();
//        for (int i=0;i<10;i++){
//            HashMap<String,String> map=new HashMap<>();
//            map.put("key1","第"+i+"值");
//            list.add(map);
//        }
        //JSONArray jsonArray=JSONArray.fromObject(list);
        //create_check_list(jsonArray);

    }
    protected void hideBottomUIMenu() {
        //隐藏虚拟按键，并且全屏
        if (Build.VERSION.SDK_INT > 11 && Build.VERSION.SDK_INT < 19) { // lower api
            View v = this.getWindow().getDecorView();
            v.setSystemUiVisibility(View.GONE);
        } else if (Build.VERSION.SDK_INT >= 19) {
            //for new api versions.
            View decorView = getWindow().getDecorView();
            int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY  | View.SYSTEM_UI_FLAG_FULLSCREEN;
            decorView.setSystemUiVisibility(uiOptions);
        }
    }
//    protected void create_check_list(JSONArray jsonArray){
//        for (int i=0;i<jsonArray.size();i++)
//        {
//            JSONObject jsonObject=jsonArray.getJSONObject(i);
//            Iterator keys=jsonObject.keys();
//            System.out.println(keys.next());
//            System.out.println(jsonObject.getString(keys.next().toString()));
//        }
//    }
}

