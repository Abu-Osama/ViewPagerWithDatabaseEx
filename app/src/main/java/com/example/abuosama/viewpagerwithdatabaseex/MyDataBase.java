package com.example.abuosama.viewpagerwithdatabaseex;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Abu osama on 28-12-2016.
 */

//step 2: create a seprate data base file controller
public class MyDataBase {

    //step 5 declared required variables
    MyHelper myHelper;
    SQLiteDatabase sqLiteDatabase;//for doing dml operations


    //step 6: create onj for helper variable
    public MyDataBase(Context context){

        myHelper=new MyHelper(context,"techpalle.db",null,1);


    }

    //step 7: create sqlitedatabase object using open method

    public  void open(){

        sqLiteDatabase=myHelper.getWritableDatabase();
    }

    //step 8 : perform dml operations

    public void insertStudent(String sname,String ssub,String semail){

        ContentValues contentValues=new ContentValues();
        contentValues.put("sname",sname);
        contentValues.put("ssub",ssub);
        contentValues.put("semail",semail);
        sqLiteDatabase.insert("student",null,contentValues);

    }

//    //keep update and delete() on hold
//    public void updateEmployee(){
//
//        //update lakshmi manager no with 8
//        ContentValues c=new ContentValues();
//        c.put("mgrno",8);
//        sqLiteDatabase.update("employee",c,"ename= 'Lakshmi'",null);
//        sqLiteDatabase.update("employee",c,"ename= ?",new String[]{"Lakshmi"});
//        //update lokesh name to lokesh gowd
//        c.put("ename","Loskesh gowd");
//        sqLiteDatabase.update("employee",c,"ename = ?",new String[]{"Lokesh"});
//    }
//
//    public  void  deleteEmployee(){
//
//        // delte all employee who salary is less than <2000
//        sqLiteDatabase.delete("employee","esal < ?",new String[]{"2000"});
//        //q2: delete all emp
//        sqLiteDatabase.delete("employee",null,null);
//    }


    public Cursor queryStudent(){

        Cursor cursor=null;
        //read all student deatils
        cursor=sqLiteDatabase.query("student",null,null,null,null,null,null);
        //read student with sno

       // cursor =sqLiteDatabase.query("student",null,"_id=",null,null,null,null);

        //q3: read only deatils og andy
       // cursor =sqLiteDatabase.query("student",null,"sname='andy' ",null,null,null,null);

        //
        return cursor;
    }

    //step 9: close data base
    public  void close(){

        sqLiteDatabase.close();
    }
    //step 3 create inner helper class for ddl operation
    private class MyHelper extends SQLiteOpenHelper{

        public MyHelper(Context context, String name,
                        SQLiteDatabase.CursorFactory factory, int version) {
            super(context, name, factory, version);
        }

        @Override
        public void onCreate(SQLiteDatabase sqLiteDatabase) {
            //step 4 create all required  tables in this method

            sqLiteDatabase.execSQL("create table student(_id integer primary key,sname text,ssub text,semail text);");


        }

        @Override
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        }
    }

}
