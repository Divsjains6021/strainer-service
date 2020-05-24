package com.propertydekho.strainerservice.filters;

import com.propertydekho.strainerservice.models.PropFilterableSortableData;

import java.util.Arrays;

public class BedroomFilter extends PropFilter
{
    public BedroomFilter() {
    }

    public BedroomFilter(String filterType, String filterValue) {
        super(filterType, filterValue);
    }

    @Override
    public boolean apply(PropFilterableSortableData prop) {
        String propBedroom = prop.getBedroom();
        String[] bedrooms = getFilterValue().split("&");
        return Arrays.stream(bedrooms)
                .map(String::trim)
                .filter(bedroom -> !bedroom.isEmpty())
                .anyMatch(propBedroom::equalsIgnoreCase);
    }
}
