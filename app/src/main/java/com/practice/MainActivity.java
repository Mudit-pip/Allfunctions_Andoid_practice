package com.practice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.practice.Advance.H1_PagerAdapter;
import com.practice.Advance.H1_TabLayout;
import com.practice.Control2.E32_ListViewMulti;
import com.practice.Control2.E35_OptionMenu;
import com.practice.Control2.E36_PopupMenu;
import com.practice.Control2.E38_contextMenu;
import com.practice.Control2.E39_SharedPrefrences;
import com.practice.Control2.E40_InternalStorageFileCreate;
import com.practice.DesignLay.RL1_Layout;
import com.practice.Hardware.G0_Home;
import com.practice.Hardware.G11_ReadContacts;
import com.practice.Hardware.G12_CallLogRead;
import com.practice.Hardware.G13_CallLogWrite;
import com.practice.Hardware.G16_Camera;
import com.practice.Hardware.G1_BatteryLevel;
import com.practice.Hardware.G8_TelephonyManager;
import com.practice.Hardware.G9_SendSMS;
import com.practice.PHPApi.Php1_InsertData;
import com.practice.PHPApi.Php2_ListView;
import com.practice.PHPApi.Php2a_ListView;
import com.practice.PHPApi.PhpM12_Album;
import com.practice.PHPApi.PhpM1_Register;
import com.practice.PHPApi.PhpM2_Login;
import com.practice.PHPApi.PhpM3_Home;
import com.practice.SQLite.sq10_Search;
import com.practice.SQLite.sq11_AdvanceSearch;
import com.practice.SQLite.sq12_Register;
import com.practice.SQLite.sq13_Login;
import com.practice.SQLite.sq14_Home;
import com.practice.SQLite.sq1_InsertSingle;
import com.practice.SQLite.sq5_AutoCompleteText;
import com.practice.SQLite.sq8_MultipleInsert;
import com.practice.SQLite.sq9_ReadMultiple;
import com.practice.ToDO.m1_main_todo;
import com.practice.ToDo2.Rough;
import com.practice.ToDo2.v1_todo_main;
import com.practice.ToDo2.v2_Home_todo;
import com.practice.TpApps.Automatic_sms_sender;
import com.practice.TpApps.Rewrite_Php1;
import com.practice.TpApps.tp3_OpeningOtherApps;

public class MainActivity extends AppCompatActivity
{


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent kk=new Intent(this, H1_TabLayout.class);
        startActivity(kk);
    }
}