package com.propertydekho.strainerservice.filters;

import com.propertydekho.strainerservice.models.PropFilterableSortableData;

public class MinBudgetFilter extends PropFilter
{
    public MinBudgetFilter() {
    }

    public MinBudgetFilter(String filterType, String filterValue) {
        super(filterType, filterValue);
    }

    @Override
    public boolean apply(PropFilterableSortableData prop) {
        return Double.parseDouble(getFilterValue()) < prop.getPropPrice();
    }
}
