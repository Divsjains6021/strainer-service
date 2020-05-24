package com.propertydekho.strainerservice;

import com.propertydekho.strainerservice.filters.*;
import com.propertydekho.strainerservice.filters.PropFilter;

public class FilterFactory
{
    public static PropFilter createFilter(PropFilter filter) {
        String filterName = filter.getName();
        String filterValue = filter.getFilterValue();
        if ("area".equalsIgnoreCase(filterName)) {
            return new AreaFilter(filterName, filterValue);
        }
        if ("budget_min".equalsIgnoreCase(filterName)) {
            new MinBudgetFilter(filterName, filterValue);
        }
        if ("budget_max".equalsIgnoreCase(filterName)) {
            return new MaxBudgetFilter(filterName, filterValue);
        }
        if ("bedroom".equalsIgnoreCase(filterName)) {
            return new BedroomFilter(filterName, filterValue);
        }
        if ("sale_type".equalsIgnoreCase(filterName)) {
            return new SaleTypeFilter(filterName, filterValue);
        }

        if ("constructn_status".equalsIgnoreCase(filterName)) {
            return new ConstructionStatusFilter(filterName, filterValue);
        }
        return filter;
    }
}
