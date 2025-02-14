package com.example.myfirstapp;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private Integer Coll = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    public void one_click_button (View view){
        Coll++;
        TextView TXT = (TextView) findViewById(R.id.textView2);
        TXT.setText(Coll.toString());
    }
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (savedInstanceState != null &&
                savedInstanceState.containsKey("клик")) {
            Coll = savedInstanceState.getInt("клик", 0);
        }
        TextView TXT = (TextView) findViewById(R.id.textView2);
        TXT.setText(Coll.toString());
        Log.d("forDebugging1", "onRestoreInstanceState");
    }
    @Override
    protected void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        outState.putInt("клик", Coll);
        Log.d("forDebugging2","Save");
        Toast.makeText(this, "Save",Toast.LENGTH_LONG).show();
    }

    @Override
    protected  void onStart(){
        super.onStart();
        Log.d("forDebugging3", "Go");
        Toast.makeText(this, "Go", Toast.LENGTH_LONG).show();
    }//вызывается, когда активность становится видимой для пользователя.

    @Override
    protected  void onResume(){
        super.onResume();
        Log.d("forDebugging4", "Resume");
        Toast.makeText(this, "Resume", Toast.LENGTH_LONG).show();
    }
    //вызывается, когда активность начинает взаимодействовать с пользователем, после того как она стала видимой.

    @Override
    protected  void onPause(){
        super.onPause();
        Log.d("forDebugging5", "Wait");
        Toast.makeText(this, "Wait", Toast.LENGTH_LONG).show();
    }
    //вызывается, если другая активность получает фокус, то есть она не будет видна пользователю.
}