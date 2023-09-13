package com.ti.frameworks.datadriven.models.resource;

import com.ti.frameworks.datadriven.models.PageModel;
import lombok.Data;

import java.util.List;

@Data
public class ResourcesModel extends PageModel {
    private List<DataModel> data;
}
