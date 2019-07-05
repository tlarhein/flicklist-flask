package org.launchcode.researchease.models;

import org.hibernate.validator.constraints.Email;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Tracey Cannon Liftoff 0519
 */

@Entity
public class User extends org.apache.tomcat.jni.User {//} extends org.apache.tomcat.jni.User {


    @Id //serves as the primary key
    @GeneratedValue  //tells hibernate to generate the value
    private int id;

    @NotNull
    @Size(min = 5, max = 15, message = "Username must be between 5 and 15 characters")
    private String name;

    @OneToMany
    @JoinColumn(name = "user_id")
    private Collection<User> users = new ArrayList<>();
    private org.apache.tomcat.jni.User user; //removed the org.apache.tomcat.jni.User, by replacing it with User user;

    @GeneratedValue
    private int user_id;

    public User(String name, int user_id, String email){
        this.name = name;
        this.user_id = user_id;
        this.email = email;
    }

    public User(){}

    @Email
    private String email;

    private Project project;


    public int getId(){
    return id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    private int getUser_id(){
        return  user_id;

    }


    //public static int getNextId() {
       // return nextId;

   // public static void setNextId(int nextId) {
       // User.nextId = nextId;


    //public String getUsers() {
     //   return users;





    public org.apache.tomcat.jni.User getUser() {
        return user;
    }

    public void setUser(org.apache.tomcat.jni.User user) {
        this.user = user;
    }

    public Project getProject(){
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }
}
