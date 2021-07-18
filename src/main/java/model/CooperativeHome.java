/**
 * Concrete class representing Cooperative home (level 3)
 */
import java.util.UUID;

public class CooperativeHome extends Residential {
    private String buildingType;

    public CooperativeHome(UUID uuid, String address, int price) {
        super(uuid, address, price);
    }


    @Override
    public String getOwnership() {
        return "Cooperative Home";
    }

    public void setBuildingType(String type){
        this.buildingType = type;
    }

    public String getBuildingType() {
        return this.buildingType;
    }


}
