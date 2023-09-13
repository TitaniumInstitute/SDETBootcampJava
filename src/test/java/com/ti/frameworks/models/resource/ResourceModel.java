package com.ti.frameworks.models.resource;

import com.ti.baseapi.BaseModel;
import com.ti.frameworks.models.SupportModel;
import lombok.Data;

@Data
public class ResourceModel extends BaseModel {
    private DataModel data;
    private SupportModel support;
}
