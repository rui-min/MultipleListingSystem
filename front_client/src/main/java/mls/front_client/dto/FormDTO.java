package mls.front_client.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.stereotype.Component;

@Component
@ToString
@NoArgsConstructor
@Setter
@Getter
public class FormDTO {
    private String address;
    private double minPrice;
    private double maxPrice;
    private AllTypes propertyType;

    @JsonCreator
    public FormDTO(@JsonProperty("address") String address, @JsonProperty("min_price") double minPrice,
                   @JsonProperty("min_price") double maxPrice,
                   @JsonProperty("min_price") AllTypes propertyType) {
        this.address = address;
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
        this.propertyType=propertyType;
    }
}
