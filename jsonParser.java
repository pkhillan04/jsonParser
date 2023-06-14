package jsonParser;

import java.io.*;
import java.net.URL;
import org.json.JSONArray;
import org.json.JSONObject;

public class jsonParser {
    public static void main(String[] args) {
        try {
            String url = "https://jsonplaceholder.typicode.com/users";
            InputStream inputStream = new URL(url).openStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder jsonContent = new StringBuilder();
            String line;
            
            while ((line = bufferedReader.readLine()) != null) {
                jsonContent.append(line);
            }
            
            bufferedReader.close();
            inputStream.close();
            
            JSONArray jsonArray = new JSONArray(jsonContent.toString());
            
            // Iterate over the JSON objects in the array
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                int id = jsonObject.getInt("id");
                String name = jsonObject.getString("name");
                String username = jsonObject.getString("username");
                String email = jsonObject.getString("email");
                JSONObject address = jsonObject.getJSONObject("address");
                String street = address.getString("street");
                String suite = address.getString("suite");
                String city = address.getString("city");
                String zipcode = address.getString("zipcode");
                JSONObject geo = address.getJSONObject("geo");
                String lat = geo.getString("lat");
                String lng = geo.getString("lng");
                String phone = jsonObject.getString("phone");
                String website = jsonObject.getString("website");
                JSONObject company = jsonObject.getJSONObject("company");
                String companyName = company.getString("name");
                String catchPhrase = company.getString("catchPhrase");
                String bs = company.getString("bs");
                
                // Print the retrieved data
                System.out.println("ID: " + id);
                System.out.println("Name: " + name);
                System.out.println("Username: " + username);
                System.out.println("Email: " + email);
                System.out.println("Street: " + street);
                System.out.println("Suite: " + suite);
                System.out.println("City: " + city);
                System.out.println("Zipcode: " + zipcode);
                System.out.println("Latitude: " + lat);
                System.out.println("Longitude: " + lng);
                System.out.println("Phone: " + phone);
                System.out.println("Website: " + website);
                System.out.println("Company Name: " + companyName);
                System.out.println("Catch Phrase: " + catchPhrase);
                System.out.println("BS: " + bs);
                System.out.println("---------------------------");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}