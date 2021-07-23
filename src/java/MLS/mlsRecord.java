package MLS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.UUID;

/**
 * Facilitate creation of mlsRecord ready to put in txt files.
 * Record generated from property objects uses fromClass(String) method
 * Record generated from txt file reader uses fromReader(String) method
 */
public class mlsRecord {

    private UUID id;
    private String address;
    private int price;
    private String info;

    private mlsRecord(){}

    /**
     * Use builder pattern to create mlsRecord obj from .toString raw output from properties.
     * @param raw String representation of a property containing all of its info.
     * @return mlsRecord obj with field tuple (UUID, address, price, info).
     */
    public static mlsRecord fromClass(String raw){
        String[] subs = raw.split("[{]", 2);
        String name = subs[0];
        subs[1] = subs[1].replaceAll("[{]}", "");

        // Split info in {} section into UUID, address, price and other info, 4 parts.
        ArrayList<String> msg = new ArrayList<>();
        for(String field: subs[1].split(", ", 4))
            msg.add(field.split("=")[1]);

        mlsRecord mls;
        msg.set(3, String.format("%s, %s", name, msg.get(3)));

        // Use builder for new mlsRecord creation.
        mls = new mlsRecord.mlsBuilder(UUID.fromString(msg.get(0)))
                .location(msg.get(1))
                .price(Integer.parseInt(msg.get(2)))
                .otherInfo(msg.get(3))
                .build();
        return mls;
    }

    /**
     * Use builder pattern to create mlsRecord from record txt strings.
     * @param text String read from record txt.
     * @return mlsRecord obj with field tuple (UUID, address, price, info).
     */
    public static mlsRecord fromReader(String text){

        ArrayList<String> msg = new ArrayList<>(Arrays.asList(text.split(" @@ ", 4)));

        mlsRecord mls = new mlsRecord.mlsBuilder(UUID.fromString(msg.get(0)))
                            .location(msg.get(1))
                            .price(Integer.parseInt(msg.get(2)))
                            .otherInfo(msg.get(3))
                            .build();
        return mls;
    }

    /**
     * Builder pattern for mlsRecord obj construction.
     * Used only by fromClass(String) and fromReader(String) to facilitate the creation of mlsRecord obj
     */
    private static class mlsBuilder{
        private UUID id;
        private String address;
        private int price;
        private String info;

        /**
         * Builder initial input UUID
         * @param id UUID obj
         */
        public mlsBuilder(UUID id){this.id = id;}

        /**
         * Set location of the property in builder obj
         * @param address String address
         * @return builder obj
         */
        public mlsBuilder location(String address){
            this.address = address;
            return this;
        }

        /**
         * Set price of the property in builder obj
         * @param price int price
         * @return builder obj
         */
        public mlsBuilder price(int price){
            this.price = price;
            return this;
        }

        /**
         * Set other information of the property in builder obj
         * @param info String information
         * @return builder obj
         */
        public mlsBuilder otherInfo(String info){
            this.info = info;
            return this;
        }

        /**
         * Construct mlsRecord obj from builder obj
         * @return mlsRecord with fields (UUID, address, price, info)
         */
        public mlsRecord build(){
            mlsRecord mls = new mlsRecord();
            mls.id = this.id;
            mls.address = this.address;
            mls.price = this.price;
            mls.info = this.info;
            return mls;
        }
    }

    /**
     * Override default toString to generate formatted String of mlsRecord
     * @return String representation of complete mlsRecord info
     */
    @Override
    public String toString(){
        return String.format("%s @@ %s @@ %s @@ %s",
                this.id, this.address, this.price, this.info);
    }

    /**
     * Getter for UUID in mlsRecord
     * @return UUID of a mlsRecord
     */
    public UUID getId() {
        return UUID.fromString(id.toString());
    }

    /**
     * Setter for UUID in mlsRecord
     * @param id new UUID of a mlsRecord
     */
    public void setId(UUID id) {
        this.id = UUID.fromString(id.toString());
    }

    /**
     * Getter for address in mlsRecord
     * @return String address of a mlsRecord
     */
    public String getAddress() {
        return address;
    }

    /**
     * Setter for address in mlsRecord
     * @param address new String address of a mlsRecord
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Getter for price in mlsRecord
     * @return int price of a mlsRecord
     */
    public int getPrice() {
        return price;
    }

    /**
     * Setter for price in mlsRecord
     * @param price new int price of a mlsRecord
     */
    public void setPrice(int price) {
        this.price = price;
    }
}
