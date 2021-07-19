package MLS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.UUID;

public class mlsRecord {

    private UUID id;
    private String address;
    private int price;
    private String info;

    private mlsRecord(){}

    /**
     * Use builder pattern to create mlsRecord obj from .toString raw output from properties.
     * @param raw String representation of a property containing all of its info.
     * @return mlsRecord obj with field tuple (UUID, address, price, info) by splitting info string.
     */
    public static mlsRecord fromClass(String raw){
        String[] subs = raw.split("[{]", 2);
        subs[1] = subs[1].replaceAll("[{]}", "");
        String name = subs[0];
        ArrayList<String> msg = new ArrayList<>();

        // Split info in {} section into UUID, address, price and other info, 4 parts.
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

    public static mlsRecord fromReader(String text){

        ArrayList<String> msg = new ArrayList<>(Arrays.asList(text.split(" @@ ", 4)));

        mlsRecord mls = new mlsBuilder(UUID.fromString(msg.get(0)))
                            .location(msg.get(1))
                            .price(Integer.parseInt(msg.get(2)))
                            .otherInfo(msg.get(3))
                            .build();
        return mls;
    }

    /**
     * Builder pattern for mlsRecord obj construction.
     */
    private static class mlsBuilder{
        private UUID id;
        private String address;
        private int price;
        private String info;

        public mlsBuilder(UUID id){this.id = id;}

        public mlsBuilder location(String address){
            this.address = address;
            return this;
        }

        public mlsBuilder price(int price){
            this.price = price;
            return this;
        }

        public mlsBuilder otherInfo(String info){
            this.info = info;
            return this;
        }

        public mlsRecord build(){
            mlsRecord mls = new mlsRecord();
            mls.id = this.id;
            mls.address = this.address;
            mls.price = this.price;
            mls.info = this.info;
            return mls;
        }
    }

    @Override
    public String toString(){
        return String.format("%s @@ %s @@ %s @@ %s",
                this.id, this.address, this.price, this.info);
    }

    public static String mlsRegulate(String text){
        return null;
    }

    public UUID getId() {
        return UUID.fromString(id.toString());
    }

    public void setId(UUID id) {
        this.id = UUID.fromString(id.toString());
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
