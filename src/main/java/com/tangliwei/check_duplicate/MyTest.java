package com.tangliwei.check_duplicate;


import com.huaban.analysis.jieba.JiebaSegmenter;
import com.huaban.analysis.jieba.SegToken;
import com.tangliwei.check_duplicate.utils.CosineSimilarity;
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

    @Test
    public void test1(){
        String s1  = "今天是周天，天气晴朗，今天晚上我要去看电影。";
        String s2 = "今天是周天，天气晴朗，今天晚上我要去看电影。";
        System.out.println(CosineSimilarity.cosineSimilarity(s1,s2));
    }
    @Test
    public void testDemo() {
        List<String> list = new ArrayList<>();
        JiebaSegmenter segmenter = new JiebaSegmenter();
        String sentences = "这是一个伸手不见五指的黑夜。我叫孙悟空，我爱北京，我爱Python和C++。";
        List<SegToken> process = segmenter.process(sentences, JiebaSegmenter.SegMode.SEARCH);
        for (SegToken segToken : process) {
            list.add(segToken.word);
        }
        System.out.println(list.toArray(new String[0]));
    }
}
