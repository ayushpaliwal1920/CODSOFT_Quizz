package com.fristandroidproject.qizzz.adapterclass;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.fristandroidproject.qizzz.QuizFragment;
import com.fristandroidproject.qizzz.R;
import com.fristandroidproject.qizzz.SubFragment;
import com.fristandroidproject.qizzz.modelclass.QuizzzModel;
import com.fristandroidproject.qizzz.modelclass.subScreenModel;

import java.util.ArrayList;

public class SubAdapter extends RecyclerView.Adapter<SubAdapter.viewHolder> {

    Context context;
    ArrayList<subScreenModel> list;

    public SubAdapter(Context context, ArrayList<subScreenModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public SubAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.subcategory_item,parent,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SubAdapter.viewHolder holder, int position) {
        subScreenModel subscreenModel = list.get(position);
        holder.titleSub.setText(subscreenModel.getTitle());
        holder.descriptionSub.setText(subscreenModel.getDescription());
        holder.itemView.setOnClickListener(v->{
            AppCompatActivity activity = (AppCompatActivity) v.getContext();
            activity.getSupportFragmentManager().beginTransaction().replace(R.id.wrapContainer,new QuizFragment(subscreenModel.getCategory(),subscreenModel.getTitle())).addToBackStack(null).commit();
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class viewHolder extends RecyclerView.ViewHolder {
        TextView titleSub ,descriptionSub;

        public viewHolder(@NonNull View itemView) {
            super(itemView);

            titleSub = itemView.findViewById(R.id.titleSub);
            descriptionSub = itemView.findViewById(R.id.descriptionSub);
        }
    }
}
