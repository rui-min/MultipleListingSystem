import java.util.UUID;
/**
 * Abstract class representing Condominium Type (level 3)
 */
public abstract class Freehold extends Residential implements Generations {

    private String type = "single family";
    private int numberOfStoreys = 0;

    private final String TITLE = "Freehold";

    public Freehold(UUID uuid, String address, int price) {
        super(uuid, address, price);
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTITLE() {
        return TITLE;
    }

    public int getNumberOfStoreys() {
        return numberOfStoreys;
    }

    public void setNumberOfStoreys(int numberOfStoreys) {
        this.numberOfStoreys = numberOfStoreys;
    }

    public abstract int getHowManyGenerations();
    public abstract void setHowManyGenerations(int howManyGenerations);

}
