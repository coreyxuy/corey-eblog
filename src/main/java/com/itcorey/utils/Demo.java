package com.itcorey.utils;

import cn.hutool.bloomfilter.BitMapBloomFilter;

/**
 * @Auther: corey
 * @Date: 2020/11/11 16:14
 * @Description:
 */
public class Demo {
    public static void main(String[] args) {
        BitMapBloomFilter bloomFilter = new BitMapBloomFilter(10);
        bloomFilter.add("123");
        bloomFilter.add("abc");
        bloomFilter.add("jml");

        System.out.println( bloomFilter.contains("467"));
    }
}
