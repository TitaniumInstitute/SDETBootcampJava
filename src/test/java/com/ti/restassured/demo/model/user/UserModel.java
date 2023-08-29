package com.ti.restassured.demo.model.user;

import com.ti.baseapi.BaseModel;
import com.ti.restassured.demo.model.SupportModel;
import lombok.Data;

@Data
public class UserModel extends BaseModel {
    private DataModel data;
    private SupportModel support;
}
