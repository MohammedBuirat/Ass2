package com.aboalfarag.assignmnet2;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Eq_Adapter extends RecyclerView.Adapter<Eq_Adapter.MyViewHolder>{
    Context context;
    ArrayList<String>equations;
    public Eq_Adapter(Context context,ArrayList<String>equations){
        this.context = context;
        this.equations = equations;
    }

    @NonNull
    @Override
    public Eq_Adapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(context);
        View view=inflater.inflate(R.layout.recyclerraw,parent,false);

        return new Eq_Adapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Eq_Adapter.MyViewHolder holder, int position) {
        holder.textView.setText(equations.get(position));
    }

    @Override
    public int getItemCount() {
        return equations.size();
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView textView;
        EditText ans;
        public MyViewHolder(@NonNull View itemView){
            super(itemView);
            textView=itemView.findViewById(R.id.equationText);
            ans=itemView.findViewById(R.id.numberEdit);
        }

        public TextView getTextView() {
            return textView;
        }

        public void setTextView(TextView textView) {
            this.textView = textView;
        }

        public EditText getAns() {
            return ans;
        }

        public void setAns(EditText ans) {
            this.ans = ans;
        }
    }
}