package com.example.administrator.testlistview;

import android.app.ListActivity;
import android.net.Uri;
import android.os.Bundle;
import android.widget.SimpleAdapter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

public class MainActivity extends ListActivity {
   private List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
    ListIterator e;
    Map<String, Object> map ;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SimpleAdapter adapter = new SimpleAdapter(this,getData(),R.layout.content_main,
                new String[]{"title","info","img"},
                new int[]{R.id.title,R.id.info,R.id.img});
        setListAdapter(adapter);
    }

    private List<Map<String, Object>> getData() {
        student []stu={new student(12354855,"张三"),new student(14557747,"jack"),new student(84585958,"zhangzhen"),new student(4854445,"yangxiao")};
        for(int i=0;i<stu.length;i++){
            map=new HashMap<String, Object>();
            map.put("title",stu[i].getName());
            map.put("info",stu[i].getNumber());
            map.put("img",R.drawable.common_ic_googleplayservices);
            list.add(map);
        }
        return list;
    }
}

class student{
    private int number;
    private String name;

    public student(int number) {
        this.number=number;
    }

    public student(int number,String name) {
        this.name = name;
        this.number=number;
    }

    public String getName() {
        return name;
    }


    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
