package com.example.abuosama.viewpagerwithdatabaseex;


import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SimpleCursorAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;


/**
 * A simple {@link Fragment} subclass.
 */
public class ShowFrag extends Fragment {
    ListView listView;

    Cursor cursor;
    SimpleCursorAdapter simpleCursorAdapter;
  //  MyDataBase myDatabase;


    public ShowFrag() {
        // Required empty public constructor
    }

//    public void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        myDatabase=new MyDataBase(getActivity());
//        myDatabase.open();
//    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_show, container, false);
        listView = (ListView) v.findViewById(R.id.listview1);
        MainActivity mainActivity= (MainActivity) getActivity();
         cursor=mainActivity.myDataBase.queryStudent();

        simpleCursorAdapter =new SimpleCursorAdapter(getActivity(),
                R.layout.row,cursor,new String[]{"_id","sname","ssub","semail"},
                new int[]{R.id.textview1,R.id.textview2,R.id.textview3,R.id.textview4});
        listView.setAdapter(simpleCursorAdapter);


//        if(cursor!=null){
//
//            StringBuilder stringBuilder=new StringBuilder();
//            while (cursor.moveToNext()){
//
//                int sno=cursor.getInt(0);
//                String sanme=cursor.getString(1);
//            }
//        }



        return v;
    }

}
