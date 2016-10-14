package com.dingdong.basenewdemo.db.model;

import com.dingdong.basenewdemo.db.AppDatabase;
import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

/**
 * Created by Viker on 2016/10/14.
 */
@Table(database = AppDatabase.class)
public class PersonBean extends BaseModel {

    //自增ID
    @PrimaryKey(autoincrement = true)
    public Long id;
    @Column
    public String name;
    @Column
    public int age;
    @Column
    public String email;


}
