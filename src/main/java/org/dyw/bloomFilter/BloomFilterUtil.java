package org.dyw.bloomFilter;

/**
 * @author Devil
 * @date 2022-05-21-20:39
 */
public class BloomFilterUtil {
    /**
     * 创建指定容量的BloomFilter
     * @param size bitset容量
     * @return BloomFilter
     */
    public static BloomFilter create(int size){
        return new BloomFilter(size);
    }

    /**
     * 创建默认容量的BloomFilter
     * @return BloomFilter
     */
    public static BloomFilter create(){
        return new BloomFilter();
    }

}
