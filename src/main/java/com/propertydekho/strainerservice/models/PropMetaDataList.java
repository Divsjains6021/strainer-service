package com.propertydekho.strainerservice.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class PropMetaDataList {


    @JsonProperty("list_prop_filter_data")
    private List<PropFilterableSortableData> propFilterableSortableData;

    public PropMetaDataList() {
    }

    public PropMetaDataList(List<PropFilterableSortableData> propFilterableSortableData) {
        this.propFilterableSortableData = propFilterableSortableData;
    }
}
