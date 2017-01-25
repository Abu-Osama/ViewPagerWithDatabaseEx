package com.example.abuosama.viewpagerwithdatabaseex;


import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
/**
 * A simple {@link Fragment} subclass.
 */

//display student on recyclerview
public class FragmentThree extends Fragment {
    //declare all varible
    RecyclerView recyclerView;
    ArrayList<Student>al;
    MyAdapter myAdapter;
    Cursor c;


    //implemnet custom adapter for recyclerview
    public  class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder>{


        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View v=getActivity().getLayoutInflater().inflate(R.layout.row,parent,false);
            ViewHolder viewHolder=new ViewHolder(v);

            return viewHolder;
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {

            Student student=al.get(position);
            holder.tv1.setText(student.getSno());
            holder.tv2.setText(student.getSname());
            holder.tv3.setText(student.getSsub());
            holder.tv4.setText(student.getSemail());

        }

        @Override
        public int getItemCount() {
            return al.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {

            public TextView tv1,tv2,tv3,tv4;
            public ViewHolder(View itemView) {
                super(itemView);
                tv1= (TextView) itemView.findViewById(R.id.textview1);
                tv2= (TextView) itemView.findViewById(R.id.textview2);
                tv3= (TextView) itemView.findViewById(R.id.textview3);
                tv4= (TextView) itemView.findViewById(R.id.textview4);


//                tv2= (TextView) tv2.findViewById(R.id.textview2);
//                tv3= (TextView) tv3.findViewById(R.id.textview3);
//                tv4= (TextView) tv4.findViewById(R.id.textview4);

            }
        }
    }


    public FragmentThree() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_fragment_three, container, false);
        recyclerView= (RecyclerView) v.findViewById(R.id.recyclerview1);
        //prepare array list data
        al=new ArrayList<Student>();

        MainActivity mainActivity= (MainActivity) getActivity();
         c=mainActivity.myDataBase.queryStudent();
        if(c !=null){

            while(c.moveToNext()){

                int sno=c.getInt(0); //read id
                String name=c.getString(1);//read name
                String subject=c.getString(2);
                String email=c.getString(3);
                //insert each row into array list
                Student s=new Student();//create emapty student obj
                s.setSno(""+sno);
                s.setSname(name);
                s.setSsub(subject);
                s.setSemail(email);
                al.add(s);


            }
        }
        myAdapter=new MyAdapter();
        recyclerView.setAdapter(myAdapter);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);
        return v;
    }

}
