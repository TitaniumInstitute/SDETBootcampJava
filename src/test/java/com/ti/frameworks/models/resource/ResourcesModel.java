package com.ti.frameworks.models.resource;

import com.ti.frameworks.models.PageModel;
import lombok.Data;

import java.util.List;

@Data
public class ResourcesModel extends PageModel {
    private List<DataModel> data;
}
