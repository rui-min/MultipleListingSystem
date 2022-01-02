package mls.server_property.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.*;
import java.time.LocalDate;
import java.sql.Date;
import static java.time.temporal.ChronoUnit.YEARS;

@MappedSuperclass
public abstract class Residential extends Property{

    public static final int REFER_PRICE = 750000;

    @Column(name="no_parking_space")
    private   int         nOfParkingSpace;
    @Column(name="storage_type")
    private   String      storageType;
    @Column(name="no_storage")
    private   int         nOfStorages;
    @Column(name=" build_date")
    private   Date   builtDate = Date.valueOf("1900-1-1");
    @Column(name=" entry_date")
    private   Date   entryDate; // the day on which the object is entered in the system

    protected Residential(){super();}

    @JsonCreator
    public Residential( @JsonProperty("address") String address, @JsonProperty("price") int price) {
        super( address, price);
        this.entryDate = Date.valueOf(LocalDate.now());
    }

    public boolean isHighValue() {
        return this.getPrice() >= REFER_PRICE;
    }

    public boolean isNew(){
        return YEARS.between(this.builtDate.toLocalDate(), LocalDate.now()) < 5;
    }

    public void setBuiltDate(LocalDate d) throws IllegalArgumentException{
        if (d.isAfter(entryDate.toLocalDate()))
            throw new IllegalArgumentException("Built date after today");
        else
            this.builtDate = Date.valueOf(d);
    }

    public Date getBuiltDate() {
        return this.builtDate;
    }

    public int howManyParkingSpace(){
        return this.nOfParkingSpace;
    }

    public void setParkingSpace(int howMany) {
        this.nOfParkingSpace = howMany;
    }

    public int howManyStorage(){
        return this.nOfStorages;
    }

    public void setStorage(String type, int howMany){
        this.nOfStorages = howMany;
        this.storageType = type;
    }

    public String getStorageType(){
        return this.storageType;
    }

    public abstract String getOwnership();

    @Override
    public String toString(){
        return String.format("%s, " +
                        "ownership=%s, " +
                        "builtDate=%s, " +
                        "storageType=%s, " +
                        "numberOfStorage=%d, " +
                        "numberOfParkingSpace=%d, " +
                        "isNewConstruction=%s, " +
                        "isHighValue=%s",
                super.toString(),
                this.getOwnership(),
                this.builtDate != Date.valueOf("1900-1-1")? this.builtDate : "Unknown",
                this.storageType,
                this.nOfStorages,
                this.nOfParkingSpace,
                this.isNew(),
                this.isHighValue()
            );
    }


}
