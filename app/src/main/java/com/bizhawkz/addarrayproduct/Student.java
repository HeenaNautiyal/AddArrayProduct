package com.bizhawkz.addarrayproduct;

import java.io.Serializable;

/**
 * Created by Heena on 3/21/2017.
 */
public class Student implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;

    private String emailId;

    public Student() {

    }
    public Student(String name, String emailId) {
        this.name = name;
        this.emailId = emailId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }
}
