package com.bizhawkz.addarrayproduct;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Uppercase extends AppCompatActivity {
EditText ed_string;
    Button ed_submit;
    String edst;
    TextView sbc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uppercase);
        ed_string=(EditText)findViewById(R.id.ed_strng);
        ed_submit=(Button)findViewById(R.id.btn_submit);
        sbc=(TextView)findViewById(R.id.tv_stng);

        ed_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edst=ed_string.getText().toString();
                sbc.setText(edst.toUpperCase());
            }
        });
    }
}
