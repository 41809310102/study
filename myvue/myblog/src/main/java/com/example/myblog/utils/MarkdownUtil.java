package com.example.myblog.utils;

import org.commonmark.Extension;
import org.commonmark.ext.gfm.tables.TableBlock;
import org.commonmark.ext.gfm.tables.TablesExtension;
import org.commonmark.ext.heading.anchor.HeadingAnchorExtension;
import org.commonmark.node.*;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.html.AttributeProvider;
import org.commonmark.renderer.html.AttributeProviderContext;
import org.commonmark.renderer.html.AttributeProviderFactory;
import org.commonmark.renderer.html.HtmlRenderer;

import java.util.*;

public class MarkdownUtil {
  public  static  String markdownToHtml(String markdown){
      Parser parser = Parser.builder().build();
      Node document = parser.parse("This is *Sparta*");
      HtmlRenderer renderer = HtmlRenderer.builder().build();
      return   renderer.render(document);  // "<p>This is <em>Sparta</em></p>\n"
  }

  /*
  * 增加扩展/标题抛出/表格生成
  * markdown转化为HTML
  * */
    public  static  String markdownToHtmlExtensions(String markdown){
        Set<Extension> headingAnchorExtensions = Collections.singleton(HeadingAnchorExtension.create());
        List<Extension> tableExtension = Arrays.asList(TablesExtension.create());
        Parser parser = Parser.builder()
                .extensions(tableExtension)
                .build();
        Node document = parser.parse(markdown);
        HtmlRenderer renderer = HtmlRenderer.builder()
                .extensions(headingAnchorExtensions)
                .extensions(tableExtension)
                .attributeProviderFactory(new AttributeProviderFactory() {
                    public AttributeProvider create(AttributeProviderContext attributeProviderContext) {
                        return new CustomAttributeProvider();
                    }
                })
                .build();

        return   renderer.render(document);  // "<p>This is <em>Sparta</em></p>\n"

    }


    static class CustomAttributeProvider implements  AttributeProvider{
        @Override
        public void  setAttributes(Node node,String tagName,Map<String,String> attributes){
            if(node instanceof Link){
                attributes.put("target","_blank");
            }
            if(node instanceof TableBlock){
                attributes.put("class","ui celled table");
            }
        }
    }
    //测试

    public static void main(String[] args) {
        String table = "";
        String a = "";
        System.out.println();
    }


}
