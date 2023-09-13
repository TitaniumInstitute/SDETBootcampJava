package com.ti.frameworks.datadriven.models.user;

import com.ti.frameworks.datadriven.models.PageModel;
import lombok.Data;

import java.util.List;

@Data
public class UsersModel extends PageModel {
    private List<DataModel> data;
}
