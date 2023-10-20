package com.practice.TpApps;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.practice.R;

public class Rough_Calc extends AppCompatActivity {

    TextView label;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rough);

        label = findViewById(R.id.rough2_lbl);
    }

    String num1 = "";
    String num2 = "";


    boolean sumstate = false;
    boolean mulstate = false;
    boolean divstate = false;
    boolean substate = false;
    boolean modstate = false;


    public void calc_sum(View view) {
        label.setText(num1 + " + " + num2);
        sumstate = true;
    }
    public void calc_sub(View view) {
        label.setText(num1 + " - " + num2);
        substate = true;
    }

    public void calc_mul(View view) {
        label.setText(num1 + " * " + num2);
        mulstate = true;
    }

    public void calc_div(View view) {
        label.setText(num1 + " / " + num2);
        divstate = true;
    }

    public void calc_moduler(View view) {
        label.setText(num1 + " % " + num2);
        modstate = true;
    }

    public void calc_clear(View view) {
        num1 = "";
        num2 = "";

        sumstate = false;
        mulstate = false;
        divstate = false;
        substate = false;
        modstate = false;

        label.setText("");
    }

    public void calc_equal(View view) {
        if (sumstate == true) {
            float ans = 0;
            ans = Float.parseFloat(num1) + Float.parseFloat(num2);
            label.setText(String.valueOf(ans));
        }
        if (mulstate == true) {
            float ans = 0;
            ans = Float.parseFloat(num1) * Float.parseFloat(num2);
            label.setText(String.valueOf(ans));
        }
        if (divstate == true) {
            float ans = 0;
            ans = Float.parseFloat(num1) / Float.parseFloat(num2);
            label.setText(String.valueOf(ans));
        }
        if (substate == true) {
            float ans = 0;
            ans = Float.parseFloat(num1) - Float.parseFloat(num2);
            label.setText(String.valueOf(ans));
        }
        if (modstate == true) {
            float ans = 0;
            ans = Float.parseFloat(num1) % Float.parseFloat(num2);
            label.setText(String.valueOf(ans));
        }
    }

    public void calc_dot(View view) {
        if (sumstate == false && mulstate == false && divstate==false && substate==false && modstate==false) {
            num1 += ".";
            label.setText(num1);
        }
        if (sumstate == true || mulstate == true || divstate==true || substate==true || modstate==true) {
            num2 += ".";
            String Opperation ="";
            if(sumstate==true){Opperation="+";}
            if(mulstate == true){Opperation="*";}
            if(divstate==true){Opperation="/";}
            if(substate==true){Opperation="-";}
            if(modstate==true){Opperation="%";}
            label.setText(num1 + " " + Opperation + " " + num2);
        }
    }


    public void calc_1(View view) {
        if (sumstate == false && mulstate == false && divstate==false && substate==false && modstate==false) {
            num1 += "1";
            label.setText(num1);
        }
        if (sumstate == true || mulstate == true || divstate==true || substate==true || modstate==true) {
            num2 += "1";
            String Opperation ="";
            if(sumstate==true){Opperation="+";}
            if(mulstate == true){Opperation="*";}
            if(divstate==true){Opperation="/";}
            if(substate==true){Opperation="-";}
            if(modstate==true){Opperation="%";}
            label.setText(num1 + " " + Opperation + " " + num2);
        }

    }

    public void calc_2(View view) {
        if (sumstate == false && mulstate == false && divstate==false && substate==false && modstate==false) {
            num1 += "2";
            label.setText(num1);
        }
        if (sumstate == true || mulstate == true || divstate==true || substate==true || modstate==true) {
            num2 += "2";
            String Opperation ="";
            if(sumstate==true){Opperation="+";}
            if(mulstate == true){Opperation="*";}
            if(divstate==true){Opperation="/";}
            if(substate==true){Opperation="-";}
            if(modstate==true){Opperation="%";}
            label.setText(num1 + " " + Opperation + " " + num2);
        }
    }

    public void calc_3(View view) {
        if (sumstate == false && mulstate == false && divstate==false && substate==false && modstate==false) {
            num1 += "3";
            label.setText(num1);
        }
        if (sumstate == true || mulstate == true || divstate==true || substate==true || modstate==true) {
            num2 += "3";
            String Opperation ="";
            if(sumstate==true){Opperation="+";}
            if(mulstate == true){Opperation="*";}
            if(divstate==true){Opperation="/";}
            if(substate==true){Opperation="-";}
            if(modstate==true){Opperation="%";}
            label.setText(num1 + " " + Opperation + " " + num2);
        }
    }

    public void calc_4(View view) {
        if (sumstate == false && mulstate == false && divstate==false && substate==false && modstate==false) {
            num1 += "4";
            label.setText(num1);
        }
        if (sumstate == true || mulstate == true || divstate==true || substate==true || modstate==true) {
            num2 += "4";
            String Opperation ="";
            if(sumstate==true){Opperation="+";}
            if(mulstate == true){Opperation="*";}
            if(divstate==true){Opperation="/";}
            if(substate==true){Opperation="-";}
            if(modstate==true){Opperation="%";}
            label.setText(num1 + " " + Opperation + " " + num2);
        }
    }

    public void calc_5(View view) {
        if (sumstate == false && mulstate == false && divstate==false && substate==false && modstate==false) {
            num1 += "5";
            label.setText(num1);
        }
        if (sumstate == true || mulstate == true || divstate==true || substate==true || modstate==true) {
            num2 += "5";
            String Opperation ="";
            if(sumstate==true){Opperation="+";}
            if(mulstate == true){Opperation="*";}
            if(divstate==true){Opperation="/";}
            if(substate==true){Opperation="-";}
            if(modstate==true){Opperation="%";}
            label.setText(num1 + " " + Opperation + " " + num2);
        }
    }

    public void calc_6(View view) {
        if (sumstate == false && mulstate == false && divstate==false && substate==false && modstate==false) {
            num1 += "6";
            label.setText(num1);
        }
        if (sumstate == true || mulstate == true || divstate==true || substate==true || modstate==true) {
            num2 += "6";
            String Opperation ="";
            if(sumstate==true){Opperation="+";}
            if(mulstate == true){Opperation="*";}
            if(divstate==true){Opperation="/";}
            if(substate==true){Opperation="-";}
            if(modstate==true){Opperation="%";}
            label.setText(num1 + " " + Opperation + " " + num2);
        }
    }

    public void calc_7(View view) {
        if (sumstate == false && mulstate == false && divstate==false && substate==false && modstate==false) {
            num1 += "7";
            label.setText(num1);
        }
        if (sumstate == true || mulstate == true || divstate==true || substate==true || modstate==true) {
            num2 += "7";
            String Opperation ="";
            if(sumstate==true){Opperation="+";}
            if(mulstate == true){Opperation="*";}
            if(divstate==true){Opperation="/";}
            if(substate==true){Opperation="-";}
            if(modstate==true){Opperation="%";}
            label.setText(num1 + " " + Opperation + " " + num2);
        }
    }

    public void calc_8(View view) {
        if (sumstate == false && mulstate == false && divstate==false && substate==false && modstate==false) {
            num1 += "8";
            label.setText(num1);
        }
        if (sumstate == true || mulstate == true || divstate==true || substate==true || modstate==true) {
            num2 += "8";
            String Opperation ="";
            if(sumstate==true){Opperation="+";}
            if(mulstate == true){Opperation="*";}
            if(divstate==true){Opperation="/";}
            if(substate==true){Opperation="-";}
            if(modstate==true){Opperation="%";}
            label.setText(num1 + " " + Opperation + " " + num2);
        }
    }

    public void calc_9(View view) {
        if (sumstate == false && mulstate == false && divstate==false && substate==false && modstate==false) {
            num1 += "9";
            label.setText(num1);
        }
        if (sumstate == true || mulstate == true || divstate==true || substate==true || modstate==true) {
            num2 += "9";
            String Opperation ="";
            if(sumstate==true){Opperation="+";}
            if(mulstate == true){Opperation="*";}
            if(divstate==true){Opperation="/";}
            if(substate==true){Opperation="-";}
            if(modstate==true){Opperation="%";}
            label.setText(num1 + " " + Opperation + " " + num2);
        }
    }

    public void calc_00(View view) {
        if (sumstate == false && mulstate == false && divstate==false && substate==false && modstate==false) {
            num1 += "00";
            label.setText(num1);
        }
        if (sumstate == true || mulstate == true || divstate==true || substate==true || modstate==true) {
            num2 += "00";
            String Opperation ="";
            if(sumstate==true){Opperation="+";}
            if(mulstate == true){Opperation="*";}
            if(divstate==true){Opperation="/";}
            if(substate==true){Opperation="-";}
            if(modstate==true){Opperation="%";}
            label.setText(num1 + " " + Opperation + " " + num2);
        }
    }

    public void calc_0(View view) {
        if (sumstate == false && mulstate == false && divstate==false && substate==false && modstate==false) {
            num1 += "0";
            label.setText(num1);
        }
        if (sumstate == true || mulstate == true || divstate==true || substate==true || modstate==true) {
            num2 += "0";
            String Opperation ="";
            if(sumstate==true){Opperation="+";}
            if(mulstate == true){Opperation="*";}
            if(divstate==true){Opperation="/";}
            if(substate==true){Opperation="-";}
            if(modstate==true){Opperation="%";}
            label.setText(num1 + " " + Opperation + " " + num2);
        }
    }



    public void calc_backspace(View view) {
    }

}