package com.fitness.healthapp.model;

public class User {

    private int id;
    private String name;
    private String email;
    private String password;

    public User(){

    }

    public User(int _id, String _name, String _password, String _email){
        this.id = _id;
        this.name = _name;
        this.email = _email;
        this.password = _password;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int _id) {
        this.id = _id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String _name) {
        this.name = _name;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String _email) {
        this.email = _email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String _password) {
        this.password = _password;
    }
}
