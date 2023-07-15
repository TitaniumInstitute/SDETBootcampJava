package com.ti.jdbc;

import lombok.Data;

@Data
public class Student {
    private int id;
    private String name;
    private String lastName;
    private String fatherName;
    private String gender;
    private String address;
    private long contact;
    private int courseID;
    private byte semester;
    private String dob;
}
