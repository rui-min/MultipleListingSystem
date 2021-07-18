package model;
import java.util.UUID;

/**
 * Concrete class representing Triple Deckers (level 4)
 */
public class TripleDeckers extends Condominium {
    private final String TITLE = this.getClass().getSimpleName();

    public TripleDeckers(Builder builder) {
        super(builder);
    }

    public String getTitle() {
        return this.TITLE;
    }

    public static class Builder<Builder>
            extends Condominium.Builder {

        private int unitNumber;
        private int howManyLockerStorage;

        public Builder(UUID uuid) {
            super(uuid);
        }

        @Override
        public Builder getThis(){
            return this;
        }

        public TripleDeckers build() {
            return new TripleDeckers(this);
        }

    }

    public static void main(String[] args) {
        TripleDeckers tri = new TripleDeckers(UUID.randomUUID(),"Yonge",90000);
        System.out.println(tri);
    }
}
