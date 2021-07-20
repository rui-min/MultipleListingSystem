package MLS;

import model.*;

import java.io.*;
import java.util.Hashtable;
import java.util.Random;
import java.util.UUID;

public class RecBook {

    private UUID uuid ;
    private Random rand;
    private boolean test = false;
    private int size;
    private String path;
    private File text;
    private Hashtable<UUID, mlsRecord> cache;

    private static RecBook SAMPLE = null;
    private static RecBook INS = null;



    private RecBook(boolean sample, int size){
        if(sample) {
            this.test = true;
            this.path = "src/resources/mlsSample.txt";
        }
        else
            this.path = "src/resources/mls.txt";
        this.cache = new Hashtable<>();
        this.size = size;
        this.text = new File(this.path);
    }

    public static RecBook getSample(int initialSize){
        if(RecBook.SAMPLE == null)
            synchronized (RecBook.class) {
                if (RecBook.SAMPLE == null) {
                    RecBook.SAMPLE = new RecBook(true, initialSize);
                    SAMPLE.rand = new Random();
                    SAMPLE.uuid = new UUID(16, 8);
                }
            }
        return SAMPLE;
    }

    public static RecBook getInstance(int initialSize){
        if(RecBook.INS == null)
            synchronized (RecBook.class){
                if(RecBook.INS == null) {
                    RecBook.INS = new RecBook(false, initialSize);
                    INS.uuid = new UUID(16, 8);
                }
            }
        return INS;
    }

    public static RecBook getSample(){ return RecBook.getSample(50); }

    public static RecBook getInstance(){ return RecBook.getInstance(50); }

    public void sampleGen(int num){
        String[] address = {"Yonge Str", "Leslie Str", "Bayview Ave", "Steele Ave E", "Finch Ave E", "Lawrence Ave E"};

    }

    public void write(mlsRecord mls) {
        try {
            FileWriter writer = new FileWriter(this.path, true);
            BufferedWriter bufWrite = new BufferedWriter(writer);
            if(text.canWrite()){
                    bufWrite.write(mls.toString());
                    bufWrite.newLine();
                    bufWrite.close();
            }
        }catch(IOException e) {
            e.printStackTrace();
        }
    }

    public mlsRecord get(UUID id) {
        if(this.cache.containsKey(id))
            return this.cache.get(id);
        mlsRecord mls = null;
        try {
            FileReader reader = new FileReader(this.path);
            BufferedReader bufRead = new BufferedReader(reader);
            String line = bufRead.readLine();
            while(line != null){
                if(line.startsWith(id.toString())){
                    mls = mlsRecord.fromReader(line);
                    this.write(mls);
                    if(this.cache.size() < this.size)
                        this.cache.put(mls.getId(), mls);
                    break;
                }
                line = bufRead.readLine();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return mls;
    }

}
