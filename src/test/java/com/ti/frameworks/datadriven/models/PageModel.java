package com.ti.frameworks.datadriven.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ti.baseapi.BaseModel;
import lombok.Data;

@Data
public class PageModel extends BaseModel {
    private int page;
    @JsonProperty("per_page")
    private int perPage;
    private int total;
    @JsonProperty("total_pages")
    private int totalPages;
    private SupportModel support;
}
