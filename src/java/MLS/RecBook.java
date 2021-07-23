package MLS;

import model.*;

import java.io.*;
import java.nio.file.*;
import java.util.Hashtable;
import java.util.Random;
import java.util.UUID;

/**
 * Use singleton design and simple file read/write system to manage text record and runtime record cache system.
 * getSampleIns()
 */
public class RecBook {

    private Random rand;
    private boolean sample = false;
    private int size;
    private String path;
    private File text;
    private Hashtable<UUID, mlsRecord> cache;
    private Hashtable<UUID, Integer> weight;

    private static RecBook SAMPLE = null;
    private static RecBook INS = null;
    private static Integer MAX_WEIGHT;
    private static Integer NEW_WEIGHT;
    private static Integer UP_WEIGHT;


    /**
     * RecBook constructor only for singleton instantiations. Actual instance call will determine whether to
     * initialize a sample singleton or a formal singleton.
     * Weight cache for each entry is for cache capacity management, with initial MAX_WEIGHT at 32, new entry NEW_WEIGHT 16
     * and entry access UP_WEIGHT 8. They can be changed by setters by additional rules.
     * @param sample boolean value, true to switch to sample singleton mode. False to switch formal singleton.
     * @param size int size of singleton cache capacity.
     */
    private RecBook(boolean sample, int size){
        if(sample) {
            this.sample = true;
            this.path = "src/resources/mlsSample.txt";
        }
        else
            this.path = "src/resources/mls.txt";
        this.cache = new Hashtable<>();
        this.weight = new Hashtable<>();
        this.size = size;
        this.text = new File(this.path);
        RecBook.MAX_WEIGHT = 32;
        RecBook.NEW_WEIGHT = 16;
        RecBook.UP_WEIGHT = 8;
    }

    /**
     * Return a unique instance of RecBook only for an example. mlsSample.txt is its database and a record cache is implemented.
     * An initial size of the singleton cache can be set. Contents of database will be randomized.
     * @param initialSize int initial size of workable cache.
     * @return Singleton instance of RecBook only for an example.
     */
    public static RecBook getSampleIns(int initialSize){
        if(RecBook.SAMPLE == null)
            synchronized (RecBook.class) {
                if (RecBook.SAMPLE == null) {
                    RecBook.SAMPLE = new RecBook(true, initialSize);
                    SAMPLE.rand = new Random();
                }
            }
        return SAMPLE;
    }

    /**
     * Return a unique instance of RecBook for working environment. mls.txt is its database for user to create and input.
     * An initial size of the singleton cache can be set.
     * @param initialSize int initial size of workable cache.
     * @return Singleton Instance of working RecBook.
     */
    public static RecBook getInstance(int initialSize){
        if(RecBook.INS == null)
            synchronized (RecBook.class){
                if(RecBook.INS == null)
                    RecBook.INS = new RecBook(false, initialSize);
            }
        return INS;
    }

    /**
     * If used 1st time when creating sample singleton, cache size is by default 50;
     * if used after singleton creation, the singleton itself will be returned.
     * @return Sample singleton instance of either default 50 or previously specified cache capacity.
     */
    public static RecBook getSampleIns(){ return RecBook.getSampleIns(64); }

    /**
     * If used 1st time when creating formal singleton, cache size is by default 100;
     * if used after singleton creation, the singleton itself will be returned.
     * @return Formal singleton instance of either default 100 or previously specified cache capacity.
     */
    public static RecBook getInstance(){ return RecBook.getInstance(128); }

    /**
     * Use random to generate given number of entries in mlsSample.txt file.
     * Generates 20 properties. 5 of each: TripleDeckers, DetachedHome, Land, VacationHome.
     */
    public void sampleRecGen(){
        String[] address = {" Yonge Str", " Leslie Str", " Bayview Ave", " Steele Ave E", " Finch Ave E"};
        int[] price = {200000, 300000, 400000, 500000, 600000};

        TripleDeckers[] a = new TripleDeckers[5];
        for(int i=0; i<5; i++){
            a[i] = new TripleDeckers(UUID.randomUUID(), rand.nextInt(50)+address[i], price[i]);
            RecBook.SAMPLE.write(mlsRecord.fromClass(a[i].toString()));
        }

        DetachedHome[] b = new DetachedHome[5];
        for(int i=0; i<5; i++){
            b[i] = new DetachedHome(UUID.randomUUID(), rand.nextInt(50)+address[i], price[i]);
            RecBook.SAMPLE.write(mlsRecord.fromClass(b[i].toString()));
        }

        Land[] c = new Land[5];
        for(int i=0; i<5; i++){
            c[i] = new Land(UUID.randomUUID(), rand.nextInt(50)+address[i], price[i]);
            RecBook.SAMPLE.write(mlsRecord.fromClass(c[i].toString()));
        }

        VacationHome[] d = new VacationHome[5];
        for(int i=0; i<5; i++){
            d[i] = new VacationHome(UUID.randomUUID(), rand.nextInt(50)+address[i], price[i]);
            RecBook.SAMPLE.write(mlsRecord.fromClass(d[i].toString()));
        }
    }


    /**
     * Write an entry of mlsRecord at the end of RecBook instance's database. Throw IOException.
     * @param mls mlsRecord input to be written into database.
     */
    public void write(mlsRecord mls) {
        try {
            FileWriter writer = new FileWriter(path, true);
            BufferedWriter bufWrite = new BufferedWriter(writer);
            if(text.canWrite()){
                    bufWrite.write(mls.toString());
                    bufWrite.newLine();
            }
            bufWrite.close();
        }catch(IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Get a mlsRecord from database using UUID.
     * If it is already in runtime cache, return it directly. Otherwise search through database to find matching record,
     * then change it into mlsRecord obj and cache inside RecBook instance's database.
     * @param id UUID input of desired entry.
     * @return mlsRecord obj or null if no record found.
     */
    public mlsRecord get(UUID id) {
        // If id is already in cache, return immediately.
        if(cache.containsKey(id)) {
            weightUpdate(id);
            return cache.get(id);
        }
        mlsRecord mls = null;

        try {
            FileReader reader = new FileReader(path);
            BufferedReader bufRead = new BufferedReader(reader);
            // Read database to find matching record.
            String line = bufRead.readLine();
            String uuid = id.toString();
            while(line != null){
                if(line.startsWith(uuid)){
                    mls = mlsRecord.fromReader(line);

                    // Accessing new record will have it put into cache and update cache weight.
                    if(cache.size() < size) {
                        cache.put(mls.getId(), mls);
                        weight.put(mls.getId(), NEW_WEIGHT+1);
                        weightUpdate();
                    }
                    break;
                }
                line = bufRead.readLine();
            }
            reader.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return mls;
    }

    /**
     * Remove an entry from database using UUID. If it is in cache, remove it as well.
     * @param id UUID of the entry to be removed.
     */
    public void remove(UUID id){
        this.cache.remove(id);
        this.weight.remove(id);
        try {
            FileReader reader = new FileReader(path);
            BufferedReader srcRead = new BufferedReader(reader);

            Path temp = Files.createTempFile(Path.of("src/resources"),"temp", ".tmp");
            File tmpF = new File(temp.toString());
            FileWriter writer = new FileWriter(temp.toString(), true);
            BufferedWriter tmpWrite = new BufferedWriter(writer);

            String uuid = id.toString();
            // Read database to find matching record to skip.
            String line = srcRead.readLine();
            while(line != null){
                if(!line.startsWith(uuid)) {
                    tmpWrite.write(line);
                    tmpWrite.newLine();
                }
                line = srcRead.readLine();
            }
            reader.close();
            tmpWrite.close();
            text.delete();
            // Files.move(temp, Path.of(path), StandardCopyOption.REPLACE_EXISTING);
            tmpF.renameTo(text);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * Decrease weight of all entries in cache by 1. Remove entries with weight point of 1 or less.
     */
    private void weightUpdate(){
        for(UUID id: cache.keySet())
            if(weight.get(id) <= 1) {
                weight.remove(id);
                cache.remove(id);
            }
            else
                weight.put(id,weight.get(id)-1);
    }

    /**
     * If cache contains given UUID, eventually increase weight of this entry by UP_WEIGHT or up to MAX_WEIGHT.
     * Then invoke weightUpdate() method to reduce all weight by 1.
     * @param id Specific entry to increase its weight.
     */
    private void weightUpdate(UUID id){
        if (weight.containsKey(id) && weight.get(id) <= MAX_WEIGHT-UP_WEIGHT)
            weight.replace(id, weight.get(id) + UP_WEIGHT + 1);
        else
            weight.replace(id, MAX_WEIGHT + 1);
        weightUpdate();
    }

    /**
     * Return the file path of current instance's record txt.
     * @return String of record txt path.
     */
    public String getFilePath() {
        return path;
    }

    /**
     * Relocate instance's record txt to a new directory.
     * If the new directory contains "mls.txt" or "mlsSample.txt", replace it.
     * @param directory String of new directory for relocation.
     */
    public void setNewFilePath(String directory) throws IOException {
        Path source = Paths.get(path);
        Path target = Paths.get(directory);
        Files.move(source, target.resolve(source.getFileName()), StandardCopyOption.REPLACE_EXISTING);
        path = sample ? directory +"\\mlsSample.txt" : directory +"\\mls.txt";
    }

    /**
     * Getter of instance's info cache.
     * @return Hashtable cache.
     */
    public Hashtable<UUID, mlsRecord> getRecCache(){
        return this.cache;
    }

    /**
     * Getter of instance's weight cache.
     * @return Hashtable weight cache.
     */
    public Hashtable<UUID, Integer> getWeightCache() {
        return this.weight;
    }

    /**
     * Getter of instance's cache size in int.
     * @return int cache size.
     */
    public int getCacheMaxSize() {
        return size;
    }

    /**
     * Change size of instance's cache. Only greater size is accepted.
     * @param size int new size.
     */
    public void setCacheMaxSize(int size) {
        if(size>this.size)
            this.size = size;
    }


    /**
     * Getter for class MAX_WEIGHT value.
     * @return int max weight.
     */
    public static int getMaxWeight() {
        return MAX_WEIGHT;
    }

    /**
     * Setter for class MAX_WEIGHT value. MAX_WEIGHT changes only when argument maxWeight is bigger than it.
     * @param maxWeight int value of new max weight.
     */
    public static void setMaxWeight(int maxWeight) {
        if(maxWeight > MAX_WEIGHT)
            MAX_WEIGHT = maxWeight;
    }

    /**
     * Getter for class NEW_WEIGHT value.
     * @return int new entry weight.
     */
    public static int getNewWeight() {
        return NEW_WEIGHT;
    }

    /**
     * Setter for class NEW_WEIGHT value. Only accepts argument no bigger than MAX_WEIGHT.
     * @param newWeight int new entry weight.
     */
    public static void setNewWeight(int newWeight) {
        if(newWeight <= MAX_WEIGHT)
            NEW_WEIGHT = newWeight;
        else
            throw new IllegalArgumentException("Assigning new entry weight greater than allowed max weight!");
    }

    /**
     * Getter for class UP_WEIGHT value.
     * @return int update weight.
     */
    public static int getUpWeight() {
        return UP_WEIGHT;
    }

    /**
     * Setter for class UP_WEIGHT value. Only accepts argument bigger than 0.
     * @param upWeight int new update weight.
     */
    public static void setUpWeight(int upWeight) {
        if(upWeight > 0)
            UP_WEIGHT = upWeight;
    }

}
