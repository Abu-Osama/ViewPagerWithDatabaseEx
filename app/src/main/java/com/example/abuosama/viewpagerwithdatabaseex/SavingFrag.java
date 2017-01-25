package com.example.abuosama.viewpagerwithdatabaseex;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class SavingFrag extends Fragment {

    EditText et1,et2,et3;
    Button b1;
    MyDataBase myDataBase;


    public SavingFrag() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_saving, container, false);

        et1 = (EditText) v.findViewById(R.id.edittext1);
        et2 = (EditText) v.findViewById(R.id.edittext2);
        et3 = (EditText) v.findViewById(R.id.edittext3);
        b1  = (Button) v.findViewById(R.id.button1);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String sname=et1.getText().toString();
                String ssub=et2.getText().toString();
                String semail=et3.getText().toString();
                //myDataBase.insertStudent(sname,ssub,semail);
                MainActivity mainActivity= (MainActivity) getActivity();
                mainActivity.myDataBase.insertStudent(sname,ssub,semail);
                Toast.makeText(getActivity(), "Inserted A row", Toast.LENGTH_SHORT).show();
                mainActivity.notifyData();
                et1.setText("");
                et2.setText("");
                et3.setText("");
                et1.requestFocus();
            }
        });


        return  v;
    }

}
