package com.example.darsb.samajseva;

public class users {
    public String id;
    public String pin;
    public String name;
    public String address;
    public String contact;
    public String state;
    public String email;
    public String password;



    public users(){

    }


    public users(String id, String pin, String name, String address, String contact, String state, String email, String password) {
        this.id = id;
        this.pin = pin;
        this.name = name;
        this.address = address;
        this.contact = contact;
        this.state = state;
        this.email = email;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public String getPin() {
        return pin;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getContact() {
        return contact;
    }

    public String getstate() {
        return state;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}

