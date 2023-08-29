package com.ti.restassured.dao;

import lombok.Data;

@Data
public class AnotherUser {

    private String login;
    private int id;
    private int publicRepos;
    private String twitterUsername;

}
