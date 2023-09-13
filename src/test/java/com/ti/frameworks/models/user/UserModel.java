package com.ti.frameworks.models.user;

import com.ti.baseapi.BaseModel;
import com.ti.frameworks.models.SupportModel;
import lombok.Data;

@Data
public class UserModel extends BaseModel {
    private DataModel data;
    private SupportModel support;
}
