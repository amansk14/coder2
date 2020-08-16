package com.example.coderspot;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ongoing extends Fragment {
//todo recycle view implementing the funtionality to the output xml file
    private List<post> postLists;

    private List<String> followingList;

    public ongoing(List<String> followingList) {
        this.followingList = followingList;
    }


    @Override
    public View onCreateView( LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.ongoing, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.ongoingrecycle);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setReverseLayout(true);
        linearLayoutManager.setStackFromEnd(true);
        recyclerView.setLayoutManager(linearLayoutManager);
        postLists = new ArrayList<>();
        com.example.coderspot.postAdaptar postAdaptar = new postAdaptar(getContext(), postLists);
        recyclerView.setAdapter(postAdaptar);
        return view;

    }

    private void checkDetails(){
        readDetailProject();
    }



    private void readDetailProject() {

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("taskuser");

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for (DataSnapshot dataSnapshot : snapshot.getChildren()){

                    post post =dataSnapshot.getValue(post.class);
                    for (String id :followingList){
                        if (post.getProjectname().equals(id)){
                            postLists.add(post);
                        }
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
}