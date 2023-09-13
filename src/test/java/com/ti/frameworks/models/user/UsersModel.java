package com.ti.frameworks.models.user;

import com.ti.frameworks.models.PageModel;
import lombok.Data;

import java.util.List;

@Data
public class UsersModel extends PageModel {
    private List<DataModel> data;
}
