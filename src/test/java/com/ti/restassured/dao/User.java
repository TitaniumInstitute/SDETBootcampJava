package com.ti.restassured.dao;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class User {

    private String login;
    private int id;

    @JsonProperty("public_repos")
    private int publicRepos;

    @JsonProperty("twitter_username")
    private String twitterUsername;

}
