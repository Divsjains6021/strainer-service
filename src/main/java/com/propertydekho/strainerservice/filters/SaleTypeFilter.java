package com.propertydekho.strainerservice.filters;

import com.propertydekho.strainerservice.models.PropFilterableSortableData;

public class SaleTypeFilter extends PropFilter
{
    public SaleTypeFilter() {
    }

    public SaleTypeFilter(String filterType, String filterValue) {
        super(filterType, filterValue);
    }

    @Override
    public boolean apply(PropFilterableSortableData prop) {
        return prop.getSaleType().equalsIgnoreCase(getFilterValue());
    }
}
