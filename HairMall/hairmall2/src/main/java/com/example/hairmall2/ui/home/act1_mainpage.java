package com.example.hairmall2.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.hairmall2.R;
import com.example.hairmall2.number2;
import com.example.hairmall2.user1;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class act1_mainpage extends Fragment {

    private act6_mainpageviewmodel homeViewModel;

    private EditText edit_test;
    private Button btn_test;
    private TextView text_test;
    private String text;

    //private number2 number2 = new number2();
    //private String id = number2.getId();
    private String id;

    DatabaseReference mRootRef = FirebaseDatabase.getInstance().getReferenceFromUrl("https://fir-test-7d2fa.firebaseio.com");
    DatabaseReference childRef = mRootRef;



    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(act6_mainpageviewmodel.class);
        View root = inflater.inflate(R.layout.act1_mainpage, container, false);
        final TextView textView = root.findViewById(R.id.text_home);
        homeViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });



        edit_test = root.findViewById(R.id.edit_test);
        btn_test = root.findViewById(R.id.btn_test);
        text_test = root.findViewById(R.id.text_test);

        id=getActivity().getIntent().getExtras().getString("id"); // 로그인부터 시작 안하면 터짐
        Log.d("DEBUG2",id);

        return root;
    }

    public void getFirebaseDatabase(){
        childRef = mRootRef.child("test");
        childRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()){
                        String string = dataSnapshot.getValue(String.class);
                        text_test.setText(string);
                        Log.d("getFirebaseDatabaes","key : " + text);

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.w("Tag", "Failed to read value.", databaseError.toException());
            }
        });

    }

    @Override
    public void onStart() {
        super.onStart();

        childRef = mRootRef.child("test");
        childRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()){
                    String string = dataSnapshot.getValue(String.class);
                    text_test.setText(string);

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.w("Tag", "Failed to read value.", databaseError.toException());
            }
        });

        btn_test.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.btn_test:

                        text = edit_test.getText().toString();
                        childRef = mRootRef.child("test");
                        childRef.setValue(text);
                        getFirebaseDatabase();

                        btn_test.setText(id);
                }
            }

        });
    }
}