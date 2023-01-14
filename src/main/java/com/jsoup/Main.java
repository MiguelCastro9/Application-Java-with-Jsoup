package com.jsoup;

import com.jsoup.model.Informacao;
import java.io.IOException;
import java.io.PrintStream;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/**
 *
 * @author Miguel Castro
 */
public class Main {

    public static void main(String[] args) throws IOException {

        String html = "<html><head><title>JSOUP</title></head>"
                + "<body><p>Convertendo string em HTML.</p>"
                + "<p>Criando um arquivo index.html através da string convertida.</p>"
                + "</body></html>";

        Document document1 = Jsoup.parse(html);
        
        System.out.println("***************************");
        System.out.println(document1);
        System.out.println("***************************");
        System.out.print("Recuperando tag <title>: ");
        System.out.println(document1.getElementsByTag("title"));
        System.out.print("Recuperando tag <p>: ");
        System.out.println(document1.getElementsByTag("p").get(0).text());
        System.out.println("***************************");
        PrintStream printStream = new PrintStream("index.html");
        printStream.print(document1);

        Document document2 = Jsoup.connect("https://www.oracle.com/").get();
        
        Informacao info1 = new Informacao(document2.getElementsByTag("h4").get(0).text(), document2.getElementsByTag("p").get(5).text());
        
        System.out.println(info1.getNome());
        System.out.println(info1.getDescricao());
        System.out.println("***************************");
        Informacao info2 = new Informacao(document2.getElementsByTag("h4").get(1).text(), document2.getElementsByTag("p").get(6).text());
        
        System.out.println(info2.getNome());
        System.out.println(info2.getDescricao());
        System.out.println("***************************");
        Informacao info3 = new Informacao(document2.getElementsByTag("h4").get(2).text(), document2.getElementsByTag("p").get(7).text());
        
        System.out.println(info3.getNome());
        System.out.println(info3.getDescricao());
        System.out.println("***************************");
        
        
    }
}