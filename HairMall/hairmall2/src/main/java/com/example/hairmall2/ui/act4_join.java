package com.example.hairmall2.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.hairmall2.R;
import com.example.hairmall2.number2;
import com.example.hairmall2.user1;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class act4_join extends AppCompatActivity {

    private EditText edit_join_email;
    private EditText edit_join_name;
    private EditText edit_join_phone;
    private EditText edit_join_id;
    private EditText edit_join_pw;

    private Button btn_join_join;
    private Button btn_join_cancel;

    private String email;
    private String name;
    private String phone;
    private String id;
    private String pw;
    private String memo;
    private ArrayList<String>ArrayStar = new ArrayList<>();

    static ArrayList<String> arrayIndex = new ArrayList<>();
    static ArrayList<String> arrayData = new ArrayList<>();

    DatabaseReference mRootRef = FirebaseDatabase.getInstance().getReferenceFromUrl("https://fir-test-7d2fa.firebaseio.com");
    DatabaseReference childRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act4_join);

        edit_join_email = findViewById(R.id.edit_join_email);
        edit_join_name = findViewById(R.id.edit_join_name);
        edit_join_phone = findViewById(R.id.edit_join_phone);
        edit_join_id = findViewById(R.id.edit_join_id);
        edit_join_pw = findViewById(R.id.edit_join_pw);

        btn_join_join = findViewById(R.id.btn_join_join);
        btn_join_cancel = findViewById(R.id.btn_join_cancel);

    }

    public final void adduser(boolean add){
        Map<String, Object> childUpdates = new HashMap<>();
        Map<String, Object> values = null;
        if(add){
            user1 user = new user1(email, name, phone, id, pw, memo, ArrayStar);
            values = user.toMap();
        }
        childUpdates.put("/hairmall/users/"+id, values);
        mRootRef.updateChildren(childUpdates);
    }

    public boolean IsExistId(){
        boolean IsExist = arrayIndex.contains(id);
        return IsExist;
    }

    public void setEditBlank(){
        edit_join_email.setText("");
        edit_join_name.setText("");
        edit_join_phone.setText("");
        edit_join_id.setText("");
        edit_join_pw.setText("");
    }

    public void setEditIdBlank(){
        edit_join_id.setText("");
    }

    public void getFirebaseDatabase(){
        childRef = mRootRef.child("hairmall").child("users");
        childRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()){
                    arrayData.clear();
                    arrayIndex.clear();
                    for(DataSnapshot ds : dataSnapshot.getChildren()){
                        String key = ds.getKey();
                        user1 user = ds.getValue(user1.class);
                        String[] info = {user.getEmail(), user.getName(), user.getName(), user.getId(), user.getPw(),user.getMemo()};//ArrayStar 제외
                        String Result = info[0] + " " + info[1] + " " + info[2] + " " + info[3] + " " + info[4] + " " + info[5];
                        arrayIndex.add(key);
                        Log.d("getFirebaseDatabaes","key : " + key);
                        arrayData.add(Result);
                        Log.d("getFirebaseDatabase", "info : " + info[0] + info[1] + info[2] + info[3]+ info[4] + info[5]);
                    }

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.w("Tag", "Failed to read value.", databaseError.toException());
            }
        });

    }

    public void setIdAllActivity(){
        Intent intent = new Intent(act4_join.this, com.example.hairmall2.ui.home.act1_mainpage.class);
        intent.putExtra("id", id);

        intent = new Intent(act4_join.this, com.example.hairmall2.ui.act5_mypage.class);
        intent.putExtra("id", id);
    }

    @Override
    protected void onStart(){
        super.onStart();

        btn_join_join.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){
                switch (v.getId()){
                    case R.id.btn_join_join:

                    email = edit_join_email.getText().toString();
                    name = edit_join_name.getText().toString();
                    phone = edit_join_phone.getText().toString();
                    id = edit_join_id.getText().toString();
                    pw = edit_join_pw.getText().toString();

                    //id공백으로 넣으면 db지워지고 오류남


                    if(!IsExistId()){
                        adduser(true);
                        getFirebaseDatabase();
                        setEditBlank();

                        //Intent intent = new Intent(act4_join.this, com.example.hairmall2.ui.home.act1_mainpage.class);
                        //intent.putExtra("id", id);

                        setIdAllActivity();

                        Intent intent = new Intent(act4_join.this, number2.class);
                        intent.putExtra("id", id);
                        startActivity(intent);
/*

                        ComponentName componentName = new ComponentName(
                                "com.exemple.hairmall2.ui.home",
                                "com.exemple.hairmall2.ui.home.act1_mainpage"
                        );

                        intent.setComponent(componentName);
                        startActivity(intent);
*/
                    }else{
                        Toast.makeText(act4_join.this, "이미 존재하는 아이디 입니다.",Toast.LENGTH_LONG).show();
                        setEditIdBlank();
                    }
                    break;

                }

            }

        });

    }



}