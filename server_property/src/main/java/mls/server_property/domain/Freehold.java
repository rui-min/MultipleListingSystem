package mls.server_property.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
@SuperBuilder
@Getter
@Setter
@ToString
public abstract class Freehold extends Residential {
    @Column
    private String type;

    @Column
    private int numberOfFloors;

    @Column
    private boolean isMultigeneration;

    protected Freehold(){super();}

//    @JsonCreator
//    public Freehold( @JsonProperty("id")Long id,
//                     @JsonProperty("address") String address,
//                     @JsonProperty("price") int price) {
//        super(id, address, price);
//        this.type = null;
//        this.numberOfFloors = 0;
//        this.isMultigeneration = false;
//    }

    @Override
    public String getOwnership() {
        return "Freehold";
    }

    public boolean isMultigeneration() {
        return this.isMultigeneration;
    }

}
