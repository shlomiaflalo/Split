
import java.util.Arrays;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.io.PrintWriter;

public class SplitAnySigns {

    public static void main(String[] args) throws Throwable {

        File file=new File("C:\\Users\\TEXT.txt");

        if (!file.exists()) {
        try{
            file.createNewFile();
            System.out.println("File created " + file.getName());
        }catch(IOException e){
            System.out.println(file.getName()+"Error, Cannot create this file "+e);
        }}

        FileWriter fileWriter=new FileWriter(file,true);
        PrintWriter printWriter=new PrintWriter(fileWriter);
        
        String Alpha_bet = "A a B b C c D d E e" +
                " F f G g H h I i J j" +
                " K k L l M m " +
                "N n O o P p Q q R r S s T" +
                " t U u V v W w X" +
                " x Y y Z z";

        String[] splitAlpha_bet = Alpha_bet.split(" ");
        String splitAlphabet = Arrays.toString(splitAlpha_bet);

        //Clean user signs in text while user typing
        Scanner sc = new Scanner(System.in);
        String keepit = "";

        List<String> keep_in_List = new ArrayList<>();//Adding text to *List*

        while (true) {

            System.out.println("What's on your mind: ");
            String F_line = sc.nextLine();

            String[] separate_Words_to_Characters =
                    new String[F_line.length()];

            if (F_line.isEmpty()) {
                keepit=keepit.trim();
                break;

            } else {

                for (int u = 0; u < F_line.length(); u++) {
                    separate_Words_to_Characters[u] =
                            String.valueOf(F_line.charAt(u));

                    if (separate_Words_to_Characters[u].equals(" ")) {
                        keep_in_List.add(separate_Words_to_Characters[u]);//Add to list
                        keepit += separate_Words_to_Characters[u];//Add to string
                    }

                    for (int x = 0; x < splitAlpha_bet.length; x++) {

                        if (separate_Words_to_Characters[u].equals
                                (splitAlpha_bet[x])) {

                            keep_in_List.add(separate_Words_to_Characters[u]);//Add to list
                            keepit += separate_Words_to_Characters[u];//Add to string

                        }
                    }

                }
                keepit += "\n";
            }

        }

        System.out.println("Number of letters after cleaning your text: "+keepit.length());
        System.out.println(keepit);
        System.out.println(keep_in_List);

        printWriter.print(keepit);
        printWriter.flush();
        printWriter.close();

                /*
                Here it's another part - while typing the code split your text
                 */

                //Split text while typing
                System.out.println("\n \n");
                System.out.println("Please write your text,We will clean it from any \"!\" \n" +
                                  "for you while you typing: ");

                List inputs = new ArrayList();
                String Input[] = sc.nextLine().split("!");
                System.out.println(Arrays.toString(Input));
                inputs.add(Arrays.toString(Input));
                inputs.forEach(System.out::println);

    }
}