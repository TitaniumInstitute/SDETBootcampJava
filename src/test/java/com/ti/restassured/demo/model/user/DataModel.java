package com.ti.restassured.demo.model.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ti.baseapi.BaseModel;
import lombok.Data;

@Data
public class DataModel extends BaseModel {
    private int id;
    private String email;
    @JsonProperty("first_name")
    private String firstName;
    @JsonProperty("last_name")
    private String lastName;
    private String avatar;
}
