package com.example.jsonparsing;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {
    static List<ModelClass> mdata;
    static Context context;

    public CustomAdapter(Context context, List<ModelClass> mdata) {
        this.context = context;
        this.mdata = mdata;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.sample_layout, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        mdata.get(position);
        holder.id.setText(mdata.get(position).getId());
        holder.firstname.setText(mdata.get(position).getFirstName());
        holder.lastname.setText(mdata.get(position).getLastName());
        holder.gender.setText(mdata.get(position).getGender());
        holder.eyecolor.setText(mdata.get(position).getEyecolor());
        holder.haircolor.setText(mdata.get(position).getHaircolor());
        holder.typee.setText(mdata.get(position).getTypee());


    }

    @Override
    public int getItemCount() {
        return mdata.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView firstname, lastname, gender, id, eyecolor, haircolor, typee;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            id = itemView.findViewById(R.id.idd);
            firstname = itemView.findViewById(R.id.firstnameee);
            lastname = itemView.findViewById(R.id.lastnameee);
            gender = itemView.findViewById(R.id.gender);
            eyecolor = itemView.findViewById(R.id.eyeClr);
            haircolor = itemView.findViewById(R.id.hairClr);
            typee = itemView.findViewById(R.id.type);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    int position = getAdapterPosition();
                    Intent intent = new Intent(context, DataDetails.class);
                    intent.putExtra("position", getAdapterPosition());
                    intent.putExtra("firstName", mdata.get(position).getFirstName());
                    intent.putExtra("lastName", mdata.get(position).getLastName());
                    intent.putExtra("gender", mdata.get(position).getGender());
                    view.getContext().startActivity(intent);

                }
            });


        }
    }
}
