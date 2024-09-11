package com.tangliwei.check_duplicate.utils;

import com.huaban.analysis.jieba.JiebaSegmenter;
import com.huaban.analysis.jieba.SegToken;

import java.util.*;


public class CosineSimilarity {

    // 预处理文本，去掉标点符号并按每个汉字分词（中文简单分词）
    private static String[] preprocessText(String text) {
        // 去除标点符号
        String processedText = text.replaceAll("[\\pP\\p{Punct}]", "");
        List<String> list = new ArrayList<>();
        JiebaSegmenter Seg = new JiebaSegmenter();
        List<SegToken> process = Seg.process(processedText, JiebaSegmenter.SegMode.SEARCH);
        for (SegToken segToken : process) {
            list.add(segToken.word);
        }
        return list.toArray(new String[0]);
    }

    // 计算词频向量
    private static Map<String, Integer> getWordFrequency(String[] words) {
        Map<String, Integer> frequencyMap = new HashMap<>();
        for (String word : words) {
            frequencyMap.put(word, frequencyMap.getOrDefault(word, 0) + 1);
        }
        return frequencyMap;
    }

    // 计算两个文本的余弦相似度
    public static double cosineSimilarity(String text1, String text2) {
        // 预处理文本，得到词数组
        String[] words1 = preprocessText(text1);
        String[] words2 = preprocessText(text2);

        // 获取两个文本的词频向量
        Map<String, Integer> freq1 = getWordFrequency(words1);
        Map<String, Integer> freq2 = getWordFrequency(words2);

        // 获取词汇表（词频向量中的所有唯一词）
        Set<String> wordSet = new HashSet<>();
        wordSet.addAll(freq1.keySet());
        wordSet.addAll(freq2.keySet());

        // 计算余弦相似度
        double dotProduct = 0.0;
        double normA = 0.0;
        double normB = 0.0;

        for (String word : wordSet) {
            int freqA = freq1.getOrDefault(word, 0);
            int freqB = freq2.getOrDefault(word, 0);

            // 点积
            dotProduct += freqA * freqB;

            // 计算向量模长
            normA += Math.pow(freqA, 2);
            normB += Math.pow(freqB, 2);
        }

        // 防止除以零的情况
        if (normA == 0 || normB == 0) {
            return 0.0;
        }

        // 余弦相似度计算公式
        return dotProduct / (Math.sqrt(normA) * Math.sqrt(normB));
    }

    public static void main(String[] args) {
        // 你可以在此处直接输入两个文本进行比较
        String originalText = "今天是星期天，天气晴，今天晚上我要去看电影。";
        String plagiarizedText = "今天是周天，天气晴朗，我晚上要去看电影。";

        // 计算两个文本的余弦相似度
        double similarity = cosineSimilarity(originalText, plagiarizedText);

        // 输出重复率（相似度百分比）
        System.out.println(String.format("文本相似度: %.2f%%", similarity * 100));
    }
}