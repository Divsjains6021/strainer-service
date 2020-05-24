package com.propertydekho.strainerservice.filters;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.propertydekho.strainerservice.models.PropFilterableSortableData;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PropFilter {
    @JsonProperty("filter_type")
    private String filterType;

    @JsonProperty("filter_value")
    private String filterValue;

    public PropFilter() {
    }

    public PropFilter(String filterType, String filterValue) {
        this.filterType = filterType;
        this.filterValue = filterValue;
    }

    public String getName() {
        return filterType;
    }

    public boolean apply(PropFilterableSortableData prop) {
        return true;
    }
}
