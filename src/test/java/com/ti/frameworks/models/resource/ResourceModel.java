package com.ti.frameworks.models.resource;

import com.ti.baseapi.BaseModel;
import com.ti.frameworks.models.SupportModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class ResourceModel extends BaseModel {
    private DataModel data;
    private SupportModel support;
}
