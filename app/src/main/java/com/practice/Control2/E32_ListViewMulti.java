package com.practice.Control2;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.practice.R;

public class E32_ListViewMulti extends AppCompatActivity {
    ListView list;
    String[] Name = {"a", "ab", "abc", "abcd", "abcde", "abcde", "a", "ab", "abc", "abcd", "abcde", "abcde", "a", "ab", "abc", "abcd", "abcde", "abcde", "a", "ab", "abc", "abcd", "abcde", "abcde", "a", "ab", "abc", "abcd", "abcde", "abcde", "a", "ab", "abc", "abcd", "abcde", "abcde", "a", "ab", "abc", "abcd", "abcde", "abcde", "a", "ab", "abc", "abcd", "abcde", "abcde", "a", "ab", "abc", "abcd", "abcde", "abcde", "a", "ab", "abc", "abcd", "abcde", "abcde"};
    String[] Mobile = {"3123", "123123ab", "434abc", "34abcd", "34abcde", "abcde", "3123", "123123ab", "434abc", "34abcd", "34abcde", "abcde", "3123", "123123ab", "434abc", "34abcd", "34abcde", "abcde", "3123", "123123ab", "434abc", "34abcd", "34abcde", "abcde", "3123", "123123ab", "434abc", "34abcd", "34abcde", "abcde", "3123", "123123ab", "434abc", "34abcd", "34abcde", "abcde", "3123", "123123ab", "434abc", "34abcd", "34abcde", "abcde", "3123", "123123ab", "434abc", "34abcd", "34abcde", "abcde", "3123", "123123ab", "434abc", "34abcd", "34abcde", "abcde", "3123", "123123ab", "434abc", "34abcd", "34abcde", "abcde"};

    int apof4=3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_e32_list_view_multi);

        list = findViewById(R.id.E32_list);

        mudit adpt = new mudit(this, Name, Mobile);
        list.setAdapter(adpt);
    }

    public class mudit extends ArrayAdapter<String> {
        String[] mName;
        String[] mMobile;
        Context mContext;

        public mudit(Context context, String[] arName, String[] arMobile) {
            super(context, R.layout.activity_e32_list_view_multi_row, R.id.E32_txt_Name, arName);

            mName = arName;
            mMobile = arMobile;
            mContext = context;

        }


        @SuppressLint("ResourceAsColor")
        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            View row = convertView;
            VHolder vholder;

            if (row == null) {
                LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(mContext.LAYOUT_INFLATER_SERVICE);
                row = inflater.inflate(R.layout.activity_e32_list_view_multi_row, parent, false);

                vholder = new VHolder(row);
                row.setTag(vholder);
            } else {
                 vholder = (VHolder) row.getTag();
            }


            if (position%2==0) {
                vholder.ll.setBackgroundColor(getColor(R.color.red));

            } else {
                vholder.ll.setBackgroundColor(getColor(R.color.blue));
            }

            vholder.txtName.setText(mName[position]+position);
            vholder.txtMobile.setText(mMobile[position]);


            return row;
        }
    }

    public class VHolder {
        TextView txtName, txtMobile;
        LinearLayout ll;
        public VHolder(View r) {

            ll = r.findViewById(R.id.E32_ll);
            txtName = r.findViewById(R.id.E32_txt_Name);
            txtMobile = r.findViewById(R.id.E32_txt_Mobile);
        }

    }
}