package com.propertydekho.strainerservice.views;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.propertydekho.strainerservice.filters.PropFilter;
import com.propertydekho.strainerservice.models.AreaPropertiesList;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class FilterableAreaPropsViewInput
{
    @JsonProperty("prop_list")
    private AreaPropertiesList propertiesList;

    @JsonProperty("prop_filters")
    private List<PropFilter> propFilters;
}
