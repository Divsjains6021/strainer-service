package com.propertydekho.strainerservice;

import com.propertydekho.strainerservice.models.AreaPropertiesList;
import com.propertydekho.strainerservice.filters.PropFilter;
import com.propertydekho.strainerservice.models.PropFilterableSortableData;
import com.propertydekho.strainerservice.models.PropsFilterInput;
import com.propertydekho.strainerservice.models.PropMetaDataList;
import com.propertydekho.strainerservice.views.FilterableAreaPropsViewInput;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/")
public class PropStrainerServiceResource {

    @RequestMapping("/filter-prop-metadata")
    public PropMetaDataList filterPropMetadata(@RequestBody PropsFilterInput propsFilterInput) {

        PropFilter propFilter = propsFilterInput.getPropFilter();
        List<PropFilterableSortableData> propFilterableSortableData =
                propsFilterInput.getPropMetaDataList().getPropFilterableSortableData().stream()
                        .filter(property ->

                                propFilter.getFilterValue().equalsIgnoreCase(property.getAttr(propFilter.getFilterType()))
                        )
                        .collect(Collectors.toList());

        return PropMetaDataList.builder().propFilterableSortableData(propFilterableSortableData).build();
    }

    @RequestMapping("/filter-all-props")
    public AreaPropertiesList filterAllProps(@RequestBody FilterableAreaPropsViewInput viewInput) {

        List<PropFilter> propFilters =  viewInput.getPropFilters().stream()
                .map(FilterFactory::createFilter)
                .collect(Collectors.toList());
        AreaPropertiesList propertiesList = viewInput.getPropertiesList();
        Map<String, PropMetaDataList> indexedProperties = propertiesList.getIndexedProperties();

        Map<String, PropMetaDataList> filteredIndexedProperties = new HashMap<>();
        indexedProperties.keySet()
                .parallelStream()
                .forEach(area -> {
                    PropMetaDataList propMetaDataList = indexedProperties.get(area);
                    filteredIndexedProperties.put(area, filterProperties(propMetaDataList, propFilters));
                });

        PropMetaDataList nonIndexedProperties = propertiesList.getNonIndexedProperties();
        nonIndexedProperties = filterProperties(nonIndexedProperties, propFilters);

        return AreaPropertiesList.builder()
                .indexedProperties(filteredIndexedProperties)
                .nonIndexedProperties(nonIndexedProperties)
                .build();
    }

    private PropMetaDataList filterProperties(PropMetaDataList propList, List<PropFilter> filters) {
        List<PropFilterableSortableData> props = propList.getPropFilterableSortableData();
        props = props.stream()
                .parallel()
                .filter(getPropFilterableSortableDataPredicate(filters))
                .collect(Collectors.toList());

        return PropMetaDataList.builder()
                .propFilterableSortableData(props)
                .build();
    }

    private Predicate<PropFilterableSortableData> getPropFilterableSortableDataPredicate(List<PropFilter> filters) {
        return prop -> filters.stream().allMatch(getPropFilterPredicate(prop));
    }

    private Predicate<PropFilter> getPropFilterPredicate(PropFilterableSortableData prop) {
        return filter -> applyFilter(prop, filter);
    }

    private boolean applyFilter(PropFilterableSortableData prop, PropFilter filter) {
        return filter.apply(prop);
    }
}