package org.dyw;

import static org.junit.Assert.assertTrue;

import org.dyw.bloomFilter.BloomFilter;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        BloomFilter bloomFilter = new BloomFilter();
        bloomFilter.add(1);
        System.out.println(bloomFilter.contains(1));
    }
}
