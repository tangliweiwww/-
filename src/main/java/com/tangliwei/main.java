package com.tangliwei;

import com.tangliwei.check_duplicate.utils.CosineSimilarity;
import com.tangliwei.check_duplicate.utils.FileUtils;

public class main {
    public static void main(String[] args) {
        String file1 = args[0];
        String file2  =args[1];
        String result = args[2];
        String s1 = FileUtils.ReadFile(file1);
        String s2 = FileUtils.ReadFile(file2);
        String CosineSimilarities = CosineSimilarity.cosineSimilarity(s1, s2);
        System.out.println("原文："+s1+"\n"+"测试文件："+s2+"\n"+"重复率："+CosineSimilarities);
        FileUtils.WriteToFile("test2.txt: "+CosineSimilarities,result);
    }
}