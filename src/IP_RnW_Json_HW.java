import org.json.JSONObject;
import java.io.*;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Scanner;

public class IP_RnW_Json_HW {

    private static final String ADDRESS = "http://ip-api.com/json";

    public static void main(String[] args) throws IOException {

        BufferedWriter bw = new BufferedWriter(new FileWriter("COUNTRY.txt"));
        BufferedReader br = new BufferedReader(new FileReader("IP.txt"));
        //Initialize the "ipList" ArrayList
        ArrayList<String> ipList = new ArrayList<>();
        //Initialize the "countryList" ArrayList
        ArrayList<String> countryList = new ArrayList<>();

        // Read from IP.txt file.
        try {
            //Add content to the "ipList" ArrayList
            String line;
            while ((line = br.readLine()) != null) {
                ipList.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Parse the JSON response and add "country" to countryList ArrayList.
        try {
            for (int i = 0; i < ipList.size(); i++) {
                // store the IP s from the IP.txt file to a variable
                String ip = ipList.get(i);

                //Extract the response from the URL
                String readUrlResponse = new Scanner(new URL(ADDRESS + "/" + ip).openStream(), StandardCharsets.UTF_8).nextLine();

                //Initialize the JSON object
                JSONObject jsonObject = new JSONObject(readUrlResponse);
                Object countryName = jsonObject.get("country");

                //Add country names tot the "countryName" ArrayList
                countryList.add("IP: " + ip + " is from " + countryName + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Extract county names from the countryList ArrayList
        for (String countryNameFromArray : countryList){
        //Write to COUNTRY.txt
          bw.write(countryNameFromArray);
        }
        bw.close();

    }

}