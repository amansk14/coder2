package com.example.coderspot;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.List;

public class postAdaptar extends RecyclerView.Adapter<postAdaptar.ViewHolder> {
    //todo getting the details and implementing on the recycle view
    public Context mContext;
    public List<post> mpost;

    private FirebaseUser taskuser;
//    FirebaseUser taskuser = FirebaseAuth.getInstance().getCurrentUser();
//    DatabaseReference tref = FirebaseDatabase.getInstance().getReference("taskuser").child("1");

    public postAdaptar(Context mContext, List<post> mpost) {
        this.mContext = mContext;
        this.mpost = mpost;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.ongoingpost, viewGroup, false);
        return new postAdaptar.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        taskuser  = FirebaseAuth.getInstance().getCurrentUser();
        post p =mpost.get(position);

//        if (p.getProjectname().equals("")){
//            holder.projectname.setVisibility(View.GONE);
//        } else {
//            holder.projectname.setVisibility(View.VISIBLE);
//            holder.projectname.setText(p.getProjectname());
//        }
//
        projectinfo(holder.projectname, holder.tvproject, holder.tvdis, holder.tvdate, holder.tvassign);

    }

    @Override
    public int getItemCount() {
        return mpost.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public ImageView imname,imdate,imdisc,imassign,imicon;
        public TextView t1,tvproject,projectname,t2,tvdis,t3,tvdate,t4,tvassign;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imname = itemView.findViewById(R.id.imname);
            imdate = itemView.findViewById(R.id.imdate);
            imdisc = itemView.findViewById(R.id.imdisc);
            imassign = itemView.findViewById(R.id.imassign);
            imicon = itemView.findViewById(R.id.imicon);
            t1 = itemView.findViewById(R.id.t1);
            tvproject = itemView.findViewById(R.id.tvproject);
            projectname = itemView.findViewById(R.id.projectname);
            t2 = itemView.findViewById(R.id.t2);
            tvdis = itemView.findViewById(R.id.tvdis);
            t3 = itemView.findViewById(R.id.t3);
            tvdate = itemView.findViewById(R.id.tvdate);
            t4 = itemView.findViewById(R.id.t4);
            tvassign = itemView.findViewById(R.id.tvassign);


        }
    }

    private void projectinfo (TextView projectname, TextView tvproject, TextView tvdis, TextView tvdate, TextView tvassign){
//        mAuth = FirebaseAuth.getInstance();

        DatabaseReference tref = FirebaseDatabase.getInstance().getReference("taskuser").child("1");
        tref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String value0 = snapshot.child("project_name").getValue().toString();

                String value = snapshot.child("project_disp").getValue().toString();
                String value1 = snapshot.child("task_date").getValue().toString();
                String value2 = snapshot.child("task_by").getValue().toString();
                projectname.setText(value0);
                tvproject.setText(value0);
                tvdis.setText(value);
                tvdate.setText(value1);
                tvassign.setText(value2);


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

}
