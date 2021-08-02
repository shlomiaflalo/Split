package com.AmigosCode;

import java.util.Arrays;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

public class Split_Any_Sign_From_File {

    public static void main(String[] args) throws Throwable {

        //Read from a file
        File file=new File("C:\\Users\\pc2\\desktop\\SAVE_TEXT.txt");
        FileReader fileReader=new FileReader(file);
        BufferedReader bufferedReader=new BufferedReader(fileReader);

        String Alpha_bet = "A a B b C c D d E e" +
                " F f G g H h I i J j" +
                " K k L l M m " +
                "N n O o P p Q q R r S s T" +
                " t U u V v W w X" +
                " x Y y Z z";

        String[] splitAlpha_bet = Alpha_bet.split(" ");
        String splitAlphabet = Arrays.toString(splitAlpha_bet);

        String Line ="",Keep_EveryThing="",Keep__EveryThing="";
        List<String> keep_in_List = new ArrayList<>();//Adding text to *List

        System.out.println("Your file before: ");
        try{
            while ((Line=bufferedReader.readLine())!=null) {
                System.out.println(Line);
                Keep__EveryThing+=Line;
                Keep__EveryThing+="\n";
            }
            Keep__EveryThing=Keep__EveryThing.trim();

            System.out.println();
            System.out.println("Number of letters in your file before editing the file: "+Keep__EveryThing.length());
            System.out.println("---");

        }catch(IOException e){
            System.out.println(e);
            e.printStackTrace();
        }

        FileReader fileReader_2=new FileReader(file);
        BufferedReader bufferedReader_2=new BufferedReader(fileReader_2);

        try{

        while ((Line=bufferedReader_2.readLine())!=null) {

            String[] separate_Words_to_Characters =
                    new String[Line.length()];

                for (int u = 0; u < Line.length(); u++) {
                    separate_Words_to_Characters[u] =
                            String.valueOf(Line.charAt(u));

                    if (separate_Words_to_Characters[u].equals(" ")) {
                        keep_in_List.add(separate_Words_to_Characters[u]);//Add to list
                        Keep_EveryThing += separate_Words_to_Characters[u];//Add to string
                    }

                    for (int x = 0; x < splitAlpha_bet.length; x++) {

                        if (separate_Words_to_Characters[u].equals
                                (splitAlpha_bet[x])) {

                            keep_in_List.add(separate_Words_to_Characters[u]);//Add to list
                            Keep_EveryThing += separate_Words_to_Characters[u];//Add to string

                        }
                    }

                }
               Keep_EveryThing += "\n";
                }

               Keep_EveryThing=Keep_EveryThing.trim();

               }catch(IOException e){
                System.out.println(e);
                e.printStackTrace();
                }

        System.out.println();

        try{
            //Re-write to a file the cleaner text
            FileWriter fileWriter=new FileWriter(file);
            PrintWriter printWriter=new PrintWriter(fileWriter);
            printWriter.print(Keep_EveryThing);
            printWriter.flush();
            printWriter.close();

        }catch(IOException e){
            System.out.println(e);
            e.printStackTrace();
        }

        FileReader fileReader_3=new FileReader(file);
        BufferedReader bufferedReader_3=new BufferedReader(fileReader_3);

        System.out.println("---");
        System.out.println("Number of letters in your file after editing your file: "+Keep_EveryThing.length());
        System.out.println("---");
        System.out.println("Your file after: ");
        try{
            while ((Line=bufferedReader_3.readLine())!=null) {
                System.out.println(Line);
            }
        }catch(IOException e){
            System.out.println(e);
            e.printStackTrace();
        }

        System.out.println("---");
        System.out.println("We've cleaned "+(Keep__EveryThing.length()-Keep_EveryThing.length())+" signs from your text which are not english letters");

        bufferedReader_2.close();


    }
}