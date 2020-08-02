package com.example.coderspot;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import  androidx.fragment.app.Fragment;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Fragment_contact extends  Fragment{
    TextView tvemail ,tvnum,tvname,tvdob;
    private FirebaseAuth mAuth;
    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
    DatabaseReference fref = FirebaseDatabase.getInstance().getReference("user").child(user.getUid());
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.contact_layout, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        mAuth = FirebaseAuth.getInstance();
        TextView tvemail = view.findViewById(R.id.tvemail);
        TextView tvnum = view.findViewById(R.id.tvnumber);
        TextView tvname = view.findViewById(R.id.tvname);
        TextView tvndob = view.findViewById(R.id.tvdob);
        tvemail.setText("E-mail="+user.getEmail().toString());
        fref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String value = snapshot.child("phno").getValue(String.class);
                String value1 = snapshot.child("fname").getValue(String.class);
                String value2 = snapshot.child("dob").getValue(String.class);
                tvnum.setText("Phone="+value);
                tvname.setText("Name="+value1);
                tvndob.setText("D.O.B="+value2);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


    }
}
