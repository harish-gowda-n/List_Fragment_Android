package com.example.savedinstancestatedemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    Context context;
    private ArrayList<String> superHeroes=new ArrayList<>();
    public RecyclerViewAdapter(Context context, ArrayList<String> superHeroes) {
        super();
        this.context = context;
        this.superHeroes = superHeroes;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycle_layout, parent, false);
        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        holder.rvtv.setText(superHeroes.get(position));
        holder.rvtv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "You clicked on : "+superHeroes.get(position), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return superHeroes.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView rvtv;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            rvtv = itemView.findViewById(R.id.rvtv);
        }
    }
}
