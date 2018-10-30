import java.io.IOException;
//import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

//import static java.lang.System.*;

// All the string inside "" are objects that have own methods.

public class AppStream1 {

    public static void main(String[] args) {
// HW 1) display the result : COUNTRY "United States".
        final String ADDRESS = "http://ip-api.com/scv"; //// Data source. Java will se this as a file.
        String ip;
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter IP: ");
        ip = keyboard.next();

        URL u;

        try {

            u = new URL(ADDRESS + "/" + ip);
            Scanner in  = new Scanner(u.openStream());
            String data = in.nextLine();

            int commas = 0;

            for(int index = 0; index < data.length(); index++){
                if (data.charAt(index) == ','){
                    commas++;
                }
                if(commas==1) {
                    System.out.println(data.charAt(index));
                }
            }

        } catch (IOException e) {

            e.printStackTrace();
        }


    }

}

//HW JSON/XML
//github.com/toddmotto/public-apis
    /* 2 example
       String message = "Hello String Data Type! String is a Class in Java";

       if(message.toLowerCase().contains("String".toLowerCase())){//here we transfer all messages to lower case and compare them. in order to let the use input any case.

           System.out.println("The message contains \" String \" !");

       }
       */

 /* 1 Example
 Scanner in = new Scanner(System.in);
        String food = ""; // compilator print int the back ground - new String("");

        System.out.println( "Enter food: ");
        food = in.next();

        if ( food.equals( "Pizza")){
            System.out.println( "COST: 75 lei");
        }
        */