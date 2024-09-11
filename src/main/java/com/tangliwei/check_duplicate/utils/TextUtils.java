package com.tangliwei.check_duplicate.utils;

import com.huaban.analysis.jieba.JiebaSegmenter;
import com.huaban.analysis.jieba.SegToken;

import java.util.ArrayList;
import java.util.List;

public class TextUtils {
    public static String[] preprocessText(String text) {
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
}
