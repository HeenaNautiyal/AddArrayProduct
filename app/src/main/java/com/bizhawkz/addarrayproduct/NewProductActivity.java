package com.bizhawkz.addarrayproduct;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.Arrays;

public class NewProductActivity extends AppCompatActivity {
    private ProgressDialog pDialog;

    //JSONParser jsonParser = new JSONParser();
    EditText inputName;
    EditText inputPrice;
    EditText inputDesc;
    String name, price, description;

    // url to create new product
    private static String url_create_product = "http://172.16.10.241/create_product.php";

    // JSONode names
    private static final String TAG_SUCCESS = "success";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_product);
        inputName = (EditText) findViewById(R.id.inputName);
        inputPrice = (EditText) findViewById(R.id.inputPrice);
        inputDesc = (EditText) findViewById(R.id.inputDesc);

        // Create button
        Button btnCreateProduct = (Button) findViewById(R.id.btnCreateProduct);

        // button click event
        btnCreateProduct.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                name = inputName.getText().toString();
                price = inputPrice.getText().toString();
                description = inputDesc.getText().toString();
                // creating new product in background thread
                new Regist().execute();
            }
        });
    }

    private class Regist extends AsyncTask<String, String, String> {
        protected void onPreExecute() {
            super.onPreExecute();
            name = inputName.getText().toString();
            price = inputPrice.getText().toString();
            description = inputDesc.getText().toString();
        }

        @Override
        protected String doInBackground(String... strings) {
            String[] myarray = new String[3];
            myarray[0] = "rishab1@mailinator.com";
            myarray[1]="ORS";
            myarray[2]="1";

            String abc= Arrays.toString(myarray);
            HttpClient httpClient = new DefaultHttpClient();
            String url = "http://172.16.10.241/create_product.php?name="+abc+"&price=1&description=1";
            String SetServerString = "";
            HttpGet httpget = new HttpGet(url);
            ResponseHandler<String> responseHandler = new BasicResponseHandler();
            try {
                SetServerString = httpClient.execute(httpget, responseHandler);
            } catch (IOException e) {
                e.printStackTrace();
            }

            Log.d("Response: ", "> " + SetServerString);
            return SetServerString;
        }

        protected void onPostExecute(String result) {
            try {

                JSONObject jsonResult = new JSONObject(result);
                String message = jsonResult.getString("udata");
                Log.d("Response: ", "> " + message);

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
