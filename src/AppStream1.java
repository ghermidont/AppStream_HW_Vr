import org.json.JSONArray;
import org.json.JSONObject;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;


public class AppStream1 {
    static String dataFromUrl;
    public static void main(String[] args) {
        String ip;
        URL url;


        //Connect the files.
        File IPsfile = new File("IP.txt");
        File COUNTRYfile = new File("COUNTRY.txt");

        //request API
        final String ADDRESS = "http://ip-api.com/json";

        try {
            url = new URL(ADDRESS + "/" + ip); // INITIALIZE IP

            Scanner readFromURL = new Scanner(url.openStream());

            dataFromUrl = readFromURL.nextLine();
            int commas = 0;
            for (int index = 0; index < dataFromUrl.length(); index++) {
                if (dataFromUrl.charAt(index) == ',') {
                    commas++;
                }
                if (commas == 1 && dataFromUrl.charAt(index) != ',') {
                    writeToFile("COUNTRY.txt");
                }
            }

            JSONObject jsonObject = new JSONObject(jsonString);
            JSONObject myResponse = jsonObject.getJSONObject("MyResponse");
            JSONArray tsmresponse = (JSONArray) myResponse.get("listTsm");

            ArrayList<String> list = new ArrayList<String>();

            for(int i=0; i<tsmresponse.length(); i++){
                list.add(tsmresponse.getJSONObject(i).getString("name"));
            }

            System.out.println(list);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void readFromFile(String file_name) {

        String line;

        try {
            BufferedReader in = new BufferedReader(new FileReader(file_name));

            if (in.readLine() == null) {
                System.out.println("\n!!! There are NO products in the DB... !!!\n");

            } else {
                while ((line = in.readLine()) != null) {
                    System.out.println(line);
                }
            }

            in.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    private static void writeToFile(String file_name) {

        try {

            FileWriter fileWriter = new FileWriter(file_name, true);
            fileWriter.write(dataFromUrl);
            fileWriter.close();

        } catch (IOException e) {

            System.err.println("CANNOT SAVE TO COUNTRY.TXT");

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

}