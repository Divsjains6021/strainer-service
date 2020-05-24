package com.propertydekho.strainerservice.filters;

import com.propertydekho.strainerservice.models.PropFilterableSortableData;

public class MaxBudgetFilter extends PropFilter
{
    public MaxBudgetFilter() {
    }

    public MaxBudgetFilter(String filterType, String filterValue) {
        super(filterType, filterValue);
    }

    @Override
    public boolean apply(PropFilterableSortableData prop) {
        return prop.getPropPrice() < Double.parseDouble(getFilterValue());
    }
}
