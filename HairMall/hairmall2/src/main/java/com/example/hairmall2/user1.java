package com.example.hairmall2;

import com.google.firebase.database.Exclude;
import com.google.firebase.database.IgnoreExtraProperties;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@IgnoreExtraProperties
public class user1 {
    public String email;
    public String name;
    public String phone;
    public String id;
    public String pw;
    public String memo;
    public ArrayList<String> arrayStar = new ArrayList<>();

    public user1 (){

    }

    public user1 (String email, String name, String phone, String id, String pw, String memo, ArrayList<String> arrayStar){
        this.email = email;
        this.name = name;
        this.phone = phone;
        this.id = id;
        this.pw = pw;
        this.memo = memo;
        this.arrayStar = arrayStar;
    }

    @Exclude
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Exclude
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Exclude
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Exclude
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Exclude
    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    @Exclude
    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    @Exclude
    public ArrayList<String> getArrayStar() {
        return arrayStar;
    }

    public void setArrayStar(ArrayList<String> arrayStar) {
        this.arrayStar = arrayStar;
    }

    @Exclude
    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("email", email);
        result.put("name", name);
        result.put("phone", phone);
        result.put("id", id);
        result.put("pw", pw);
        return result;
    }

    @Exclude
    public Map<String, Object> toMemo() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("memo", memo);
        return result;
    }

    @Exclude
    public Map<String, Object> toStar() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("arrayStar", arrayStar);
        return result;
    }
}
