package com.lj;


import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.StringField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;


import java.io.File;
import java.io.IOException;

public class CreateIndex {
    public static void main(String[] args) throws IOException {
        //声明一个文件夹为索引库
        Directory dir = FSDirectory.open(new File("C:/第三阶段/lucene/index"));
        //创建标准分词器对象
       Analyzer analyzer = new StandardAnalyzer(Version.LUCENE_44);
       //索引写入器的相关配置
        IndexWriterConfig conf = new IndexWriterConfig(Version.LUCENE_44,analyzer);
        //参数1：索引库的目录  参数2：索引写入器的相关配置
        IndexWriter indexWriter = new IndexWriter(dir,conf);
        for(int i = 10;i<11;i++){
            Document document = new Document();
            document.add(new StringField("id",i+"", Field.Store.YES));
            document.add(new StringField("title","背影",Field.Store.YES));
            document.add(new StringField("author","朱自清",Field.Store.YES));
            document.add(new TextField("content","奋斗到自己哭泣，努力到无能为力",Field.Store.YES));
            document.add(new StringField("date","2019-04-11",Field.Store.YES));

            indexWriter.addDocument(document);
        }

        indexWriter.commit();
        indexWriter.close();
		  

    }
}
