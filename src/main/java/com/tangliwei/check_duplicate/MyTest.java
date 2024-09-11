package com.tangliwei.check_duplicate;


import com.huaban.analysis.jieba.JiebaSegmenter;
import com.huaban.analysis.jieba.SegToken;
import com.tangliwei.check_duplicate.utils.CosineSimilarity;
import com.tangliwei.check_duplicate.utils.FileUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class MyTest {
//    public static void main(String[] args) {
//        SimHash simHash = new SimHash();
//        String s1  = "今天是周天，天气晴朗，今天晚上我要去看电影。";
//        String s2 = "今天是星期天，天气晴，晚上我要去看电影。";
//
//        FileUtils.WriteToFile(s1,"data/test1.txt");
//        FileUtils.WriteToFile(s2,"data/test2.txt");

//    @Test
//    public void test1(){
//        String s1  = "今天是周天，天气晴朗，今天晚上我要去看电影。";
//        String s2 = "今天是周天，天气，今天晚上我要去看电影。";
//        FileUtils.WriteToFile(s1,"data/test1.txt");
//        System.out.println(CosineSimilarity.cosineSimilarity(s1,s2));
//    }
    @Test
    public void testDemo() {
        String s1 = FileUtils.ReadFile("data/test1.txt");
        String s2 = FileUtils.ReadFile("data/test2.txt");
        String cosinedSimilarity = CosineSimilarity.cosineSimilarity(s1, s2);
        FileUtils.WriteToFile("test2.txt: "+cosinedSimilarity,"data/result.txt");
    }
}
