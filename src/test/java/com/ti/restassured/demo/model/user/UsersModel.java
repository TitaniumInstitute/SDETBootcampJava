package com.ti.restassured.demo.model.user;

import com.ti.restassured.demo.model.PageModel;
import lombok.Data;

import java.util.List;

@Data
public class UsersModel extends PageModel {
    private List<DataModel> data;
}
