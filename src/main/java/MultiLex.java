/**
 * Concrete class representing MultiLex (level 4)
 */
import java.util.UUID;

public class MultiLex extends Freehold {

    private int nOfUnits;

    public MultiLex(UUID uuid, String address, int price) {
        super(uuid, address, price);
        this.setType("Multi-family");
    }

    public void setUnits(int n){
        this.nOfUnits = n;
    }

    @Override
    public String getBuildingType() {

       switch (this.nOfUnits){
           case 2:  return "Duplex";
           case 3:  return "Triplex";
           case 4:  return "Quadriplex";
           default: return "Multiplex (>4)";
       }
    }

}
