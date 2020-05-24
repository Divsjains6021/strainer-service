package com.propertydekho.strainerservice.filters;

import com.propertydekho.strainerservice.models.PropFilterableSortableData;

import java.util.Arrays;

public class AreaFilter extends PropFilter
{
    public AreaFilter() {
    }

    public AreaFilter(String filterType, String filterValue) {
        super(filterType, filterValue);
    }

    @Override
    public boolean apply(PropFilterableSortableData prop) {

        String propArea = prop.getArea();
        String[] areas = getFilterValue().split("&");
        return Arrays.stream(areas)
                .map(String::trim)
                .filter(area -> !area.isEmpty())
                .anyMatch(propArea::equalsIgnoreCase);

    }
}
