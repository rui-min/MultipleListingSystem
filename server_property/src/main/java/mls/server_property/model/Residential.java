package mls.server_property.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.time.LocalDate;
import static java.time.temporal.ChronoUnit.YEARS;

@MappedSuperclass
public abstract class Residential extends Property{

    public static final int REFER_PRICE = 750000;

    @Column(name="noParkingSpace")
    private   int         nOfParkingSpace;
    @Column(name="storageType")
    private   String      storageType;
    @Column(name="noStorage")
    private   int         nOfStorages;
    @Column(name="buildDate")
    private   LocalDate   builtDate = LocalDate.MIN;
    @Column(name="entryDate")
    private   LocalDate   entryDate; // the day on which the object is entered in the system

    protected Residential(){super();}

    @JsonCreator
    public Residential(@JsonProperty("id") Long id, @JsonProperty("address") String address, @JsonProperty("price") int price) {
        super(id, address, price);
        this.entryDate = LocalDate.now();
    }

    public boolean isHighValue() {
        return this.getPrice() >= REFER_PRICE;
    }

    public boolean isNew(){
        return YEARS.between(this.builtDate, LocalDate.now()) < 5;
    }

    public void setBuiltDate(LocalDate d) throws IllegalArgumentException{
        if (d.isAfter(entryDate))
            throw new IllegalArgumentException("Built date after today");
        else
            this.builtDate = d;
    }

    public LocalDate getBuiltDate() {
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
                this.builtDate != LocalDate.MIN? this.builtDate : "Unknown",
                this.storageType,
                this.nOfStorages,
                this.nOfParkingSpace,
                this.isNew(),
                this.isHighValue()
            );
    }


}
