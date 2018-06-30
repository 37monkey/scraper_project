package com.mycompany.mavenproject1;

import java.io.*;
import java.util.Scanner;
import org.jsoup.*;
import org.jsoup.nodes.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class HTMLParserExample1 {


        public static void main (String[] args){
        // initialize primitive objects
        int choice;
        String finalHOutput;
        String finalSOutput;
        String finalDOutput;
        String output;
        String selection = "https://www.bbc.co.uk/news/uk/"; // given default value
       
        // initialize complex objects
        HeadlineRegex headlineRegex = new HeadlineRegex();
        SummaryRegex summaryRegex = new SummaryRegex();
        DateRegex dateRegex = new DateRegex();
        RegexVisitor visitor = new RegexVisitor();
       
        // take user input
//        System.out.println("What kind of news story would you like to scrape?\n"
//                            + "Press: 1 for UK, 2 for Business,\n 3 for Politics, "
//                            + "4 for Tech,\n 5 for Science, or 6 for Health... ");
//        Scanner reader = new Scanner(System.in);
//        choice = reader.nextInt();
//       
//        // alter selection to fit user choice
//        switch (choice){
//            case (1):
//                selection = "http://www.bbc.co.uk/news/uk/";
//                break;
//            case (2):
//                selection = "http://bbc.co.uk/news/business/";
//                break;
//            case (3):
//                selection = "http://bbc.co.uk/news/politics/";
//                break;
//            case (4):
//                selection = "http://bbc.co.uk/news/technology/";   
//                break;
//            case (5):
//                selection = "http://bbc.co.uk/news/science_and_environment/";
//                break;
//            case (6):
//                selection = "http://bbc.co.uk/news/health/";
//                break;
//        }
       
        // create new object of Document class and scrape HTML to populate it
        Document doc = null;
        try {
            doc = Jsoup.connect(selection).get();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
       
        // send the HTML input to the visitor
        String input = doc.toString();
        visitor.setInput(input);
       
        // visit the regular expression
        visitor.visit(headlineRegex);
        finalHOutput = visitor.getFinalHOutput();
        visitor.visit(summaryRegex);
        finalSOutput = visitor.getFinalSOutput();
        visitor.visit(dateRegex);
        finalDOutput = visitor.getFinalDOutput();
        visitor.createOutput(finalHOutput, finalSOutput, finalDOutput);
       
        // get the output from the visitor
        output = visitor.getOutput();
       
        System.out.println(output + "\n");
        //reader.close();
    }
}
 

 

 



 
