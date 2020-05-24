package com.propertydekho.strainerservice.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.propertydekho.strainerservice.filters.PropFilter;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PropsFilterInput {
    @JsonProperty("prop_meta_data_list")
    private PropMetaDataList propMetaDataList;
    @JsonProperty("prop_filter")
    private PropFilter propFilter;

    public PropsFilterInput() {
    }

    public PropsFilterInput(PropMetaDataList propMetaDataList, PropFilter propFilter) {
        this.propMetaDataList = propMetaDataList;
        this.propFilter = propFilter;
    }
}
