package com.propertydekho.strainerservice;

import com.propertydekho.strainerservice.models.PropFilter;
import com.propertydekho.strainerservice.models.PropFilterableSortableData;
import com.propertydekho.strainerservice.models.PropsFilterInput;
import com.propertydekho.strainerservice.models.PropMetaDataList;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
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
}