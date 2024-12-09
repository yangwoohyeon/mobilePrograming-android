package com.example.myapplication;

import android.content.DialogInterface;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Callback;



public class MainActivity extends AppCompatActivity {


    ApiInterface api;
    Button btn;
    TextView txt;
    EditText editText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);//activity_main을 이 액티비티의 화면으로 설정


        api = RetrofitClient.getRetrofit().create(ApiInterface.class); //중요

        editText = (EditText) findViewById(R.id.editTextText); // activity_main의 editTextText를 editText로 설정
        btn = (Button) findViewById(R.id.button); // activity_main의 button을 btn으로 설정
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Data data = new Data();
                data.setText(editText.getText().toString());
                api.postData(data).enqueue(new Callback<Data>() {
                    @Override
                    public void onResponse(Call<Data> call, Response<Data> response){
                        if(response.isSuccessful()){
                            txt.setText(response.body().getResult());
                        }
                    }

                    @Override
                    public void onFailure(Call<Data> call, Throwable t) {

                    }
                });
            }
        });





        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}