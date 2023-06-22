package com.aboalfarag.assignmnet2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.Placeholder;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> equations;

    HashMap<String, String> map;

    void fillEquations() {
        equations = new ArrayList<>();
        map = new HashMap<>();
        equations.add("2 + 3 =");
        map.put("2 + 3 =", "5");
        equations.add("4 + 7 =");
        map.put("4 + 7 =", "11");
        equations.add("8 + 2 =");
        map.put("8 + 2 =", "10");
        equations.add("10 + 6 =");
        map.put("10 + 6 =", "16");
        equations.add("5 + 9 =");
        map.put("5 + 9 =", "14");
        equations.add("12 - 5 =");
        map.put("12 - 5 =", "7");
        equations.add("16 - 9 =");
        map.put("16 - 9 =", "7");
        equations.add("20 - 3 =");
        map.put("20 - 3 =", "17");
        equations.add("8 - 4 =");
        map.put("8 - 4 =", "4");
        equations.add("11 + 5 =");
        map.put("11 + 5 =", "16");
        equations.add("13 - 6 =");
        map.put("13 - 6 =", "7");
        equations.add("18 - 8 =");
        map.put("18 - 8 =", "10");
        equations.add("4 + 6 =");
        map.put("4 + 6 =", "10");
        equations.add("15 - 7 =");
        map.put("15 - 7 =", "8");
        equations.add("9 + 8 =");
        map.put("9 + 8 =", "17");
        equations.add("14 - 9 =");
        map.put("14 - 9 =", "5");
        equations.add("6 + 7 =");
        map.put("6 + 7 =", "13");
        equations.add("12 - 3 =");
        map.put("12 - 3 =", "9");
        equations.add("10 + 2 =");
        map.put("10 + 2 =", "12");
        equations.add("11 - 5 =");
        map.put("11 - 5 =", "6");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fillEquations();
        RecyclerView recyclerView = findViewById(R.id.myRecyclerView);
        Eq_Adapter adapter = new Eq_Adapter(this, equations);
        recyclerView.setAdapter(adapter);
        Button submit=findViewById(R.id.submit);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int correct=0;
                for(int i=0;i<6;i++){
                    Eq_Adapter.MyViewHolder viewHolder=(Eq_Adapter.MyViewHolder)recyclerView.findViewHolderForAdapterPosition(i);
                    String text=viewHolder.getTextView().getText().toString();
                    String ans=viewHolder.getAns().getText().toString();
                    if(!ans.isEmpty()){
                        if(map.get(text).equals(ans)){
                            correct++;

                        }
                    }



                }
                Intent intent = new Intent(MainActivity.this, ScoresActivity.class);
                intent.putExtra("score", correct);
                startActivity(intent);

                finish();
            }
        });








    }
}