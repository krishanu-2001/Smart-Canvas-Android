package com.example.smart_school2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import javax.xml.namespace.QName;

public class SecondFragment extends Fragment {
    private Button zero;
    private Button one;
    private Button two;
    private Button three;
    private Button four;
    private Button five;
    private Button six;
    private Button seven;
    private Button eight;
    private Button nine;
    private Button add;
    private Button sub;
    private Button mul;
    private Button div;
    private Button equal;
    private Button clear;
    private TextView result;
    private TextView info;
    private final char ADDITION = '+';
    private final char SUBTRACT = '-';
    private final char MULTIPLY = '*';
    private final char DIVIDE = '/';
    private final char EQ = '0';
    private double val1 = Double.NaN;
    private double val2 = Double.NaN;
    private char cur;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        view.findViewById(R.id.button_second).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(SecondFragment.this)
                        .navigate(R.id.action_SecondFragment_to_FirstFragment);
            }
        });
        setupUI(view, savedInstanceState);
        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText().toString() + '0');
            }
        });
        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText().toString() + '1');
            }
        });
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText().toString() + '2');
            }
        });
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText().toString() + '3');
            }
        });
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText().toString() + '4');
            }
        });
        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText().toString() + '5');
            }
        });
        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText().toString() + '6');
            }
        });
        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText().toString() + '7');
            }
        });
        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText().toString() + '8');
            }
        });
        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText().toString() + '9');
            }
        });
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                solve();
                cur = ADDITION;
                result.setText(info.getText().toString() + '+');
                info.setText(null);

            }
        });
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                solve();
                cur = SUBTRACT;
                result.setText(info.getText().toString() + '-');
                info.setText(null);

            }
        });
        mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                solve();
                cur = MULTIPLY;
                result.setText(info.getText().toString() + '*');
                info.setText(null);

            }
        });
        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                solve();
                cur = DIVIDE;
                result.setText(info.getText().toString() + '/');
                info.setText(null);

            }
        });

        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                solve();
                cur = EQ;
                result.setText(result.getText().toString() + String.valueOf(val2) + '=' + String.valueOf(val1));
                info.setText(null);
            }

        });
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (info.getText().length() > 0) {
                    CharSequence temp = info.getText().toString();
                    info.setText(temp.subSequence(0,temp.length()-1));
                } else {
                    val1 = Double.NaN;
                    val2 = Double.NaN;
                    info.setText(null);
                    result.setText(null);
                }
            }
        });
    }
    public void setupUI(@NonNull View view,Bundle savedInstanceState)
    {
        zero = (Button)view.findViewById(R.id.btn0);
        one = (Button)view.findViewById(R.id.btn1);
        two = (Button)view.findViewById(R.id.btn2);
        three = (Button)view.findViewById(R.id.btn3);
        four = (Button)view.findViewById(R.id.btn4);
        five = (Button)view.findViewById(R.id.btn5);
        six = (Button)view.findViewById(R.id.btn6);
        seven = (Button)view.findViewById(R.id.btn7);
        eight = (Button)view.findViewById(R.id.btn8);
        nine = (Button)view.findViewById(R.id.btn9);
        add = (Button)view.findViewById(R.id.btnadd);
        sub = (Button)view.findViewById(R.id.btnsub);
        mul = (Button)view.findViewById(R.id.btnmult);
        div = (Button)view.findViewById(R.id.btndiv);
        equal = (Button)view.findViewById(R.id.btncalc);
        clear = (Button)view.findViewById(R.id.clear);
        result = (TextView)view.findViewById(R.id.result);
        info = (TextView)view.findViewById(R.id.info);

    }

    private void solve(){
        if(Double.isNaN(val1) == false)
        {
            val2 = Double.parseDouble(info.getText().toString());

            switch (cur)
            {
                case ADDITION:
                    val1 = val1 + val2;
                    break;
                case SUBTRACT:
                    val1 = val1 - val2;
                    break;
                case MULTIPLY:
                    val1 = val1 * val2;
                    break;
                case DIVIDE:
                    val1 = val1 / val2;
                    break;
                case EQ:
                    break;
            }
        }
        else
        {
            val1 = Double.parseDouble(info.getText().toString());
        }
    }


}
