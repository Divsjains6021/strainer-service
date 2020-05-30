package com.propertydekho.strainerservice.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class PropFilterableSortableData
{
    @JsonProperty("prop_id")
    private String propID;

    @JsonProperty("prop_name")
    private String propName;

    @JsonProperty("prop_price")
    private Double propPrice;

    @JsonProperty("sqft")
    private Integer sqft;

    @JsonProperty("bedroom")
    private String bedroom;

    @JsonProperty("sale_type")
    private String saleType;

    @JsonProperty("constructn_status")
    private String constructionStatus;

    @JsonProperty("area")
    private String area;

    public String getAttr(String filterType) {
        if ("constructn_status".equalsIgnoreCase(filterType)) {
            return getConstructionStatus();
        }
        if ("sale_type".equalsIgnoreCase(filterType)) {
            return getSaleType();
        }
        if ("bedroom".equalsIgnoreCase(filterType)) {
            return getBedroom();
        }
        return "";
    }
}
