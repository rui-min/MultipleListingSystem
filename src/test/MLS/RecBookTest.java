package MLS;

import MLS.*;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Hashtable;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class RecBookTest {


    // Sample singleton and regular singleton have the same function, except sample has random generator func to autofill mlsSample.txt
    // So here only sample instance is tested.
    @Test
    public void sampleTextTest() throws IOException {
        RecBook sample = RecBook.getSampleIns(100);
        sample.sampleRecGen();
        Hashtable<UUID, mlsRecord> cache = sample.getRecCache();
        Hashtable<UUID, Integer> weight = sample.getWeightCache();

        assertEquals(sample.getCacheMaxSize(), 100);
        assertEquals(RecBook.getMaxWeight(), 32);
        assertEquals(RecBook.getNewWeight(), 16);
        assertEquals(RecBook.getUpWeight(), 8);
        assertTrue(cache.size() == 0 && weight.size() == 0);
        System.out.println("Sample instance initialization successful!");

        mlsRecord mls1, mls2;

        FileReader reader = new FileReader(sample.getFilePath());
        BufferedReader bufRead = new BufferedReader(reader);

        String line = bufRead.readLine();
        mls1 = mlsRecord.fromReader(line);
        line = bufRead.readLine();
        mls2 = mlsRecord.fromReader(line);
        reader.close();

        // Get mls1 first time from record, initial weight 16.
        sample.get(mls1.getId());
        assertTrue(cache.size() == 1 && weight.size() == 1);
        assertTrue(cache.get(mls1.getId()).equals(mls1)
                && weight.get(mls1.getId()) == 16);
        System.out.println("1st mls should be in cache & weight initialized.");

        // Get mls2 first time from record, initial weight 16, and others decrease.
        sample.get(mls2.getId());
        assertTrue(cache.size() == 2 && weight.size() == 2);
        assertTrue(cache.get(mls2.getId()).equals(mls2)
                && weight.get(mls1.getId()) == 15
                && weight.get(mls2.getId()) == 16);
        System.out.println("2nd mls should be in cache & all weight updated.");

        // Get mls1 again to increase its weight by 8, others decrease.
        sample.get(mls1.getId());
        assertTrue(cache.size() == 2 && weight.size() == 2);
        assertTrue(weight.get(mls1.getId()) == 23
                && weight.get(mls2.getId()) == 15);
        System.out.println("Get entry of 1st mls & all weight updated.");

        // Get mls1 multiple times till max weight, others decrease.
        sample.get(mls1.getId());
        sample.get(mls1.getId());
        assertTrue(weight.get(mls1.getId()) == 32
                && weight.get(mls2.getId()) == 13);
        System.out.println("1st mls should reach max weight & all weight updated.");

        // Remove mls1 from record and cache, other weights decrease.
        sample.remove(mls1.getId());

        reader = new FileReader(sample.getFilePath());
        bufRead = new BufferedReader(reader);

        int i = 0;
        line = bufRead.readLine();
        while(line != null){
            i++;
            line = bufRead.readLine();
        }
        reader.close();

        assertTrue(cache.size() == 1 && weight.size() == 1);
        assertTrue(cache.get(mls2.getId()).equals(mls2)
                && weight.get(mls2.getId()) == 13);
        assertEquals(i, 19);
        System.out.println("1st mls record should be removed & others' weight remain the same.");
    }
}
