import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Scanner;

public class IP_RnW_Json_HW {

    public static void main(String[] args) throws MalformedURLException {
        String ip;
        InputStream url;
        String dataFromUrl;
        final String ADDRESS = "http://ip-api.com/json";


        //Initialize the "ipList" ArrayList
        ArrayList<String> ipList = new ArrayList<String>();
        //Initialize the "countryList" ArrayList
        ArrayList<String> countryList = new ArrayList<String>();

        // Read from IP.txt file.
        try {
            BufferedReader br = null;
            br = new BufferedReader(new FileReader("IP.txt"));

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
                ip = ipList.get(i);

                //Extract the response from the URL
                String readUrlResponse = new Scanner(new URL(ADDRESS + "/" + ip).openStream(), StandardCharsets.UTF_8).next();

                //Initialize the JSON object
                JSONObject jsonObject = new JSONObject(readUrlResponse);
/* !!!!!!!!!!*/ JSONArray jsonCountryArray = jsonObject.getJSONArray("????"); //??? THERE IS NO KEY IN THE RESPONSE Ex: http://ip-api.com/json/184.168.221.104

                for(int j = 0 ; j < jsonCountryArray.length() ; j++){
                    countryList.add(jsonCountryArray.getJSONObject(j).getString("country"));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        //See the content of the countryList ArrayList
        String countryline;
        for (int n = 0; n < countryList.size(); n++) {
            countryline = countryList.get(n);

            System.out.println(countryline);
        }

    }

}