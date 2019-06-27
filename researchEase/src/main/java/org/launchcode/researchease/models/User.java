package org.launchcode.researchease.models;

import org.apache.tomcat.jni.User;
import org.hibernate.validator.constraints.Email;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by Tracey Cannon Liftoff 0519
 */

@Entity
class user extends org.apache.tomcat.jni.User {

    @Id //serves as the primary key
    @GeneratedValue  //tells hibernate to generate the value
    private int id;

    @NotNull
    @Size(min = 5, max = 15, message = "Username must be between 5 and 15 characters")
    private String name;

    @OneToMany(mappedBy = "user")
    @JoinColumn(name = "user_id", nullable = false)
    //private Collection<user> users = new ArrayList<user>();
    private User user;

    private Integer user_id;
    private static Integer nextId = 100;

    @Email
    private String email;



    public user() {
    }


    public user(String name, User user, Integer user_id, String email) {
        this.name = name;
        this.user = user;
        this.user_id = user_id;
        this.email = email;
    }

    //public User() {


    //private Integer user_id;
    //private static Integer nextId = 1;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public List<User> getUsers() {
  //      return Users;
//    }


    public void setProject(Project project) {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getUserId() {
        return user_id;
    }

    public void setUserId(Integer user_id) {
        this.user_id = user_id;
    }
}
