package com.example.onetoone;

import android.app.Application;

import org.greenrobot.greendao.database.Database;

public class MyApplication  extends Application {
    private DaoSession daoSession;


    @Override
    public void onCreate(){
        super.onCreate();

        //regular SQLite Database
        DaoMaster.DevOpenHelper helper= new DaoMaster.DevOpenHelper(this,"Tooneactivity",null);
        Database db=helper.getWritableDb();

        daoSession = new DaoMaster(db).newSession();

    }



    public DaoSession getDaoSession(){
        return daoSession;
    }

}

