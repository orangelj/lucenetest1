package com.lj;


import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.wltea.analyzer.lucene.IKAnalyzer;

import java.io.IOException;
import java.io.StringReader;

public class TestLucene {

    public static void main(String[] args) throws IOException {

        test(new IKAnalyzer(),"奋斗到自己哭泣，努力到无能为力");
    }

    private static void test(Analyzer analyzer, String text)throws IOException {
        System.out.println("当前分词器：----->"+analyzer.getClass().getName());
        TokenStream tokenStream = analyzer.tokenStream("content",new StringReader(text));
        tokenStream.addAttribute(CharTermAttribute.class);

        tokenStream.reset();
        while (tokenStream.incrementToken()){
            CharTermAttribute attribute = tokenStream.getAttribute(CharTermAttribute.class);
            System.out.println(attribute.toString());
        }
        tokenStream.end();
    }
}
