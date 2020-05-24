package com.propertydekho.strainerservice.filters;

import com.propertydekho.strainerservice.models.PropFilterableSortableData;

public class ConstructionStatusFilter extends PropFilter
{
    public ConstructionStatusFilter() {
    }

    public ConstructionStatusFilter(String filterType, String filterValue) {
        super(filterType, filterValue);
    }

    @Override
    public boolean apply(PropFilterableSortableData prop) {
        return prop.getConstructionStatus().equalsIgnoreCase(getFilterValue());
    }
}
