package com.example.coderspot;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
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

public class Ongoing extends AppCompatActivity {

    RecyclerView ongoingRecycler;
    RecyclerView.Adapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.ongoing);

        ongoingRecycler = findViewById(R.id.ongoingrecycle);
        ongoingRecycler();

    }

    private void ongoingRecycler() {

        ongoingRecycler.setHasFixedSize(true);
        ongoingRecycler.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));

        ArrayList<PostHelperClass> post = new ArrayList<>();
        post.add(new PostHelperClass("CoderSpot","CoderSpot","you have to do bla bla bla ","20/10/12","Aman"));
        post.add(new PostHelperClass("Amazon","Amazon","you have to do bla bla bla ","25/02/28","Abhi"));
        adapter = new PostAdaptar(post);
        ongoingRecycler.setAdapter(adapter);
    }
}

//    private List<PostHelperClass> postHelperClassLists;
//
//    private List<String> followingList;
//
//    public Ongoing(List<String> followingList) {
//        this.followingList = followingList;
//    }
//
//
//    @Override
//    public View onCreateView( LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        View view = inflater.inflate(R.layout.ongoing, container, false);
//
//        RecyclerView recyclerView = view.findViewById(R.id.ongoingrecycle);
//        recyclerView.setHasFixedSize(true);
//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
//        linearLayoutManager.setReverseLayout(true);
//        linearLayoutManager.setStackFromEnd(true);
//        recyclerView.setLayoutManager(linearLayoutManager);
//        postHelperClassLists = new ArrayList<>();
//        PostAdaptar postAdaptar = new PostAdaptar(getContext(), postHelperClassLists);
//        recyclerView.setAdapter(postAdaptar);
//        return view;
//
//    }
//
//    private void checkDetails(){
//        readDetailProject();
//    }
//
//
//
//    private void readDetailProject() {
//
//        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("taskuser");
//
//        reference.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//
//                for (DataSnapshot dataSnapshot : snapshot.getChildren()){
//
//                    PostHelperClass PostHelperClass =dataSnapshot.getValue(PostHelperClass.class);
//                    for (String id :followingList){
//                        if (PostHelperClass.getProjectname().equals(id)){
//                            postHelperClassLists.add(PostHelperClass);
//                        }
//                    }
//                }
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//
//            }
//        });
//
//    }
//}