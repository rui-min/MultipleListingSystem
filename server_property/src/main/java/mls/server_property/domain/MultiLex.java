package mls.server_property.domain;
/**
 * Concrete class representing MultiLex (level 4)
 */
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "multilex")
public class MultiLex extends Freehold {

    private int nOfUnits;

 //todo constructor

    public void setUnits(int n) {
        this.nOfUnits = n;
    }

    @Override
    public String getBuildingType() {

        switch (this.nOfUnits) {
            case 2:
                return "Duplex";
            case 3:
                return "Triplex";
            case 4:
                return "Quadriplex";
            default:
                return "Multiplex (>4)";
        }
    }

    @Override
    public String toString() {
        return super.toString() +
                ", howManyUnits=" + nOfUnits;
    }

}
