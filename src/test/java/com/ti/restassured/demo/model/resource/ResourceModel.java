package com.ti.restassured.demo.model.resource;

import com.ti.baseapi.BaseModel;
import com.ti.restassured.demo.model.SupportModel;
import lombok.Data;

@Data
public class ResourceModel extends BaseModel {
    private DataModel data;
    private SupportModel support;
}
