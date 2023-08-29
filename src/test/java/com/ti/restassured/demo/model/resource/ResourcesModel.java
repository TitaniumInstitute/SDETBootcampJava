package com.ti.restassured.demo.model.resource;

import com.ti.restassured.demo.model.PageModel;
import lombok.Data;

import java.util.List;

@Data
public class ResourcesModel extends PageModel {
    private List<DataModel> data;
}
