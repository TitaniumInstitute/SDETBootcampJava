package com.ti.frameworks.datadriven.models.resource;

import com.ti.baseapi.BaseModel;
import com.ti.frameworks.datadriven.models.SupportModel;
import lombok.Data;

@Data
public class ResourceModel extends BaseModel {
    private DataModel data;
    private SupportModel support;
}
