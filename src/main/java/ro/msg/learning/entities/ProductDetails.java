package ro.msg.learning.entities;


import com.fasterxml.jackson.annotation.JsonProperty;
import ro.msg.learning.entities.types.DistanceUnit;
import ro.msg.learning.entities.types.WeightUnit;

import javax.persistence.Embeddable;
import java.util.Currency;

@Embeddable
public class ProductDetails {

    @JsonProperty("WeightUnit")
    private WeightUnit weightUnit;

    @JsonProperty("Weight")
    private Double weight;

    @JsonProperty("CurrencyCode")
    private Currency currencyCode;

    @JsonProperty("Unit")
    private DistanceUnit unit;

    @JsonProperty("DimensionWidth")
    private Double dimensionWidth;

    @JsonProperty("DimensionHeight")
    private Double dimensionHeight;

    @JsonProperty("DimensionDepth")
    private Double dimensionDepth;

    @JsonProperty("ShortDescription")
    private String shortDescription;

    @JsonProperty("Price")
    private Double price;

    @JsonProperty("PictureUrl")
    private String pictureUrl;


}
