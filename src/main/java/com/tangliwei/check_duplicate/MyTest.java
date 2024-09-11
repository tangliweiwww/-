package com.tangliwei.check_duplicate;



import com.tangliwei.check_duplicate.utils.CosineSimilarity;
import com.tangliwei.check_duplicate.utils.FileUtils;
import org.junit.Test;



public class MyTest {
//    public static void main(String[] args) {
//        SimHash simHash = new SimHash();
//        String s1  = "今天是周天，天气晴朗，今天晚上我要去看电影。";
//        String s2 = "今天是星期天，天气晴，晚上我要去看电影。";
//
//        FileUtils.WriteToFile(s1,"data/test1.txt");
//        FileUtils.WriteToFile(s2,"data/test2.txt");


    @Test
    public void testDemo() {
        String s1 = FileUtils.ReadFile("data/test1.txt");
        String s2 = FileUtils.ReadFile("data/test2.txt");
        String CosineSimilarities = CosineSimilarity.cosineSimilarity(s1, s2);
        System.out.println("原文："+s1+"\n"+"测试文件："+s2+"\n"+"重复率："+CosineSimilarities);
        FileUtils.WriteToFile("test2.txt: "+CosineSimilarities,"data/result.txt");
    }

    @Test
    public void testDemo2() {
        String s1 = FileUtils.ReadFile("data/test1.txt");
        String s2 = FileUtils.ReadFile("data/test2.txt");
        String CosineSimilarities = CosineSimilarity.cosineSimilarity(s1, s2);
        System.out.println("原文："+s1+"\n"+"测试文件："+s2+"\n"+"重复率："+CosineSimilarities);
        FileUtils.WriteToFile("test2.txt: "+CosineSimilarities,"data/result.txt");
    }
}
