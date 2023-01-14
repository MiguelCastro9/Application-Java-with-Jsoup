package com.jsoup;

import java.io.IOException;
import java.io.PrintStream;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

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

        Document doc = Jsoup.parse(html);
        
        System.out.println("***************************");
        System.out.println(doc);
        System.out.println("***************************");
        System.out.print("Recuperando tag <title>: ");
        System.out.println(doc.getElementsByTag("title"));
        System.out.print("Recuperando tag <p>: ");
        System.out.println(doc.getElementsByTag("p").get(0).text());
        System.out.println("***************************");
        PrintStream printStream = new PrintStream("index.html");
        printStream.print(doc);

        
    }
}