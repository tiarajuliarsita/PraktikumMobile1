package com.F55121053_tiara.barvolume;

import  android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText edtWidth;
    private EditText edtHeight;
    private EditText edtLength;
    private Button btnCalculate;
    private TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtWidth=findViewById(R.id.edt_width);
        edtHeight=findViewById(R.id.edt_height);
        edtLength=findViewById(R.id.edt_length);
        btnCalculate=findViewById(R.id.btn_calculate);
        tvResult=findViewById(R.id.tv_result);
        btnCalculate.setOnClickListener(this);

        if (savedInstanceState != null){
            String result = savedInstanceState.getString(STATE_RESULT);
            tvResult.setText(result);
        }


    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.btn_calculate){
            String InputLength = edtLength.getText().toString().trim();
            String InputWidth = edtWidth.getText().toString().trim();
            String InputHeight = edtHeight.getText().toString().trim();

            Boolean isEmptyFields = false;
            if (TextUtils.isEmpty(InputLength)) {
                isEmptyFields = true;
                edtLength.setError("Field ini Tidak Boleh Kosong");
            }
            if (TextUtils.isEmpty(InputWidth)) {
                isEmptyFields = true;
                edtHeight.setError("Field ini Tidak Boleh Kosong");
            }
            if (TextUtils.isEmpty(InputHeight)) {
                isEmptyFields = true;
                edtHeight.setError("Field ini Tidak Boleh Kosong");
            }
            if(!isEmptyFields) {
                Double volume = Double.parseDouble(InputLength) * Double.parseDouble(InputWidth) *
                        Double.parseDouble(InputHeight);
                tvResult.setText(String.valueOf(volume));
            }
        }

    }
    private static final String STATE_RESULT="state result";

    @Override
    protected void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        outState.putString(STATE_RESULT, tvResult.getText().toString());
    }
}