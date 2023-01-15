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
        
        PrintStream printStream = new PrintStream("index.html");
        
        Document document1 = Jsoup.connect("https://www.oracle.com/").get();
        
        Element img1 = document1.select("img").get(0);
        Informacao info1 = new Informacao(document1.getElementsByTag("h4").get(0).text(), document1.getElementsByTag("p").get(5).text(), img1.attr("data-src"));
        
        Element img2 = document1.select("img").get(1);
        Informacao info2 = new Informacao(document1.getElementsByTag("h4").get(1).text(), document1.getElementsByTag("p").get(6).text(), img2.attr("data-src"));
        
        Element img3 = document1.select("img").get(2);
        Informacao info3 = new Informacao(document1.getElementsByTag("h4").get(2).text(), document1.getElementsByTag("p").get(7).text(), img3.attr("data-src"));
        
        String html = "<html>"
                + "<head>"
                + "<title>JSOUP</title>"
                + "</head>"
                + "<body>"
                + "<h1 style='text-align: center;'>Recuperando dados do site da Oracle e convertendo uma string em HTML5 via JSOUP.</h1>"
                + "<br>"
                + "<hr>"
                + "<img src='" + info1.getImagem() + "'>"
                + "<h3>" + info1.getNome() + "</h3>"
                + "<p>" + info1.getDescricao() + "</p>"
                + "<hr>"
                + "<img src='" + info2.getImagem() + "'>"
                + "<h3>" + info2.getNome() + "</h3>"
                + "<p>" + info2.getDescricao() + "</p>"
                + "<hr>"
                + "<img src='" + info3.getImagem() + "'>"
                + "<h3>" + info3.getNome() + "</h3>"
                + "<p>" + info3.getDescricao() + "</p>"
                + "<hr>"
                + "</body>"
                + "</html>";
        
        Document document2 = Jsoup.parse(html);
        
        printStream.print(document2);
    }
}