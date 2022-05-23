package org.dyw.bloomFilter;

import java.util.BitSet;

/**
 * @author Devil
 * @date 2022-05-21-20:01
 */
public class BloomFilter {
    /**
     * bit数组的默认大小
     */
    private  int size = 2 << 24;

    /**
     * 通过这个数组可以创建6个不同的hash函数
     */
    private static final int[] SEEDS = new int[]{3,13,46,91,134};

    /**
     * bit数组。数组中的元素只能是 0 或者 1
     */
    private final BitSet bits;

    /**
     * 存放包含 hash 函数的类的数组
     */
    private final SimpleHash[] func = new SimpleHash[SEEDS.length];

    /**
     * 有参构造 指定bit数组大小
     */
    public BloomFilter(int size){
        this.size = size;
        bits = new BitSet(size);
    }

    /**
     * 无参构造
     */
    public BloomFilter(){
        bits = new BitSet(size);
    }

    /*
     * 静态代码块
     */
    {
        //初始化多个不同的Hash函数
        for (int i = 0; i < SEEDS.length; i++) {
            func[i] = new SimpleHash(size, SEEDS[i]);
        }
    }

    /**
     * 添加元素到位数组
     */
    public void add(Object value) {
        for (SimpleHash f : func) {
            bits.set(f.hash(value), true);
        }
    }

    /**
     * 判断指定元素是否存在于位数组
     */
    public boolean contains(Object value) {
        boolean ret = true;
        for (SimpleHash f : func) {
            ret = ret && bits.get(f.hash(value));
        }
        return ret;
    }




    /**
     * 静态内部类。用于 hash 操作！
     */
    public static class SimpleHash {

        private final int cap;
        private final int seed;

        public SimpleHash(int cap, int seed) {
            this.cap = cap;
            this.seed = seed;
        }

        /**
         * 计算 hash 值
         */
        public int hash(Object value) {
            int h;
            return (value == null) ? 0 : Math.abs(seed * (cap - 1) & ((h = value.hashCode()) ^ (h >>> 16)));
        }

    }
}
