package com.tangliwei.check_duplicate;

import com.tangliwei.check_duplicate.utils.CosineSimilarity;
import com.tangliwei.check_duplicate.utils.SimHash;

public class Main {
    public static void main(String[] args) {
        SimHash simHash = new SimHash();
        System.out.println(simHash.calculatePlagiarismRate("今天是周天，天气晴朗，今天晚上我要去看电影。","今天是周天，天气晴朗，今天我晚上要去看电影。"));
        System.out.println(CosineSimilarity.cosineSimilarity("今天是周，天气晴朗，今天晚我要去看电影。","今天是周天，天气晴朗，今天我晚上要去看电影。"));
    }
}
