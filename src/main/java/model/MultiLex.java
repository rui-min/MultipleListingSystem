package model; /**
 * Concrete class representing model.MultiLex (level 4)
 */
import java.util.UUID;

public class MultiLex extends Freehold {

    public MultiLex(UUID uuid, String address, int price) {
        super(uuid, address, price);
    }

    @Override
    public int getHowManyGenerations() {
        return 0;
    }

    @Override
    public void setHowManyGenerations(int howManyGenerations) {

    }

    @Override
    public int getHowManyParks() {
        return 0;
    }

    @Override
    public void setHowManyParks(int howManyParks) {

    }

    //toString() TODO
}
