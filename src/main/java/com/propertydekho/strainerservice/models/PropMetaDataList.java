package com.propertydekho.strainerservice.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class PropMetaDataList
{
    @JsonProperty("prop_list")
    private List<PropFilterableSortableData> propFilterableSortableData;
}
