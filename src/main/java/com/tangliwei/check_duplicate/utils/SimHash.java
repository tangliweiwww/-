package com.tangliwei.check_duplicate.utils;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SimHash {

    private String tokens;
    private BigInteger simHash;
    private int hashbits = 64; // 默认使用64位哈希

    // 构造函数，传入需要比较的文本
    public SimHash(String tokens) {
        this.tokens = Arrays.toString(tokens.replaceAll("[\\pP\\p{Punct}]", "").split(""));
        this.simHash = this.simHash();
    }

    public SimHash(){}

    // 生成SimHash值
    public BigInteger simHash() {
        int[] v = new int[hashbits];
        StringTokenizer stringTokenizer = new StringTokenizer(tokens);

        // 统计每个词的hash值，并进行加权
        while (stringTokenizer.hasMoreTokens()) {
            String temp = stringTokenizer.nextToken();
            BigInteger hashValue = this.hash(temp);
            for (int i = 0; i < hashbits; i++) {
                BigInteger bitmask = new BigInteger("1").shiftLeft(i);
                if (hashValue.and(bitmask).signum() != 0) {
                    v[i] += 1; // 如果该位是1，加1
                } else {
                    v[i] -= 1; // 如果该位是0，减1
                }
            }
        }

        BigInteger fingerprint = new BigInteger("0");
        for (int i = 0; i < hashbits; i++) {
            if (v[i] >= 0) {
                fingerprint = fingerprint.add(new BigInteger("1").shiftLeft(i));
            }
        }

        return fingerprint;
    }

    // 对单个词生成哈希值
    private BigInteger hash(String source) {
        if (source == null || source.length() == 0) {
            return new BigInteger("0");
        } else {
            char[] sourceArray = source.toCharArray();
            BigInteger x = BigInteger.valueOf(((long) sourceArray[0]) << 7);
            BigInteger m = new BigInteger("1000003");
            BigInteger mask = new BigInteger("2").pow(hashbits).subtract(new BigInteger("1"));

            for (char item : sourceArray) {
                x = x.multiply(m).xor(BigInteger.valueOf((long) item)).and(mask);
            }
            x = x.xor(new BigInteger(String.valueOf(source.length())));
            if (x.equals(new BigInteger("-1"))) {
                x = new BigInteger("-2");
            }
            return x;
        }
    }

    // 计算两个SimHash的汉明距离
    public int hammingDistance(SimHash other) {
        BigInteger x = this.simHash.xor(other.simHash);
        return x.bitCount();
    }

    // 估算相似度，根据汉明距离计算相似率
    public double getSimilarity(SimHash other) {
        int distance = this.hammingDistance(other);
        return 1 - (double) distance / hashbits;
    }

    // 直接比较两个文本，输出抄袭率
    public double calculatePlagiarismRate(String text1, String text2) {
        SimHash hash1 = new SimHash(text1);
        SimHash hash2 = new SimHash(text2);
        return hash1.getSimilarity(hash2);
    }

//    public static void main(String[] args) {
//        // 你可以在此处直接输入两个文本进行比较
//        String originalText = "今天是星期天，天气晴，今天晚上我要去看电影。";
//        String plagiarizedText = "今天是周天，天气晴朗，我晚上要去看电影。";
//
//        // 调用函数计算抄袭率
//        double plagiarismRate = calculatePlagiarismRate(originalText, plagiarizedText);
//
//        // 输出抄袭率
//        System.out.println(String.format("抄袭率: %.2f", plagiarismRate * 100) + "%");
//    }
}