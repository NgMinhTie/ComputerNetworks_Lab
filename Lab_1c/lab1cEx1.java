import java.io.*;
import java.net.*;

/* 
public class lab1c{
    public static void main(){
        //* STEP 1: Specify the URL 
        try {
            String url = "www.google.com";
            
            //* STEP 2: Create the URL Object 
            URL obj = new URL(url);

            //* STEP 3: Open the connection 
            HttpURLConnection connection_in_HTTP = (HttpURLConnection) obj.openConnection(); 
            // Explain: obj.openConnection() return to "HttpURLConnection" type, and it will be assigned to connection_in_HTTP

            //* STEP 4: Set the request method 
            connection_in_HTTP.setRequestMethod("GET");

            //* STEP 5: Check the response code 
            int response_code = connection_in_HTTP.getResponseCode();
            System.out.println("Code status: " + response_code);

            //* STEP 6: Read and display Response Content *
            BufferedReader reading = new BufferedReader(new InputStreamReader(connection_in_HTTP.getInputStream()));
            // Explain: connection_in_HTTP.getInputStream() is to get the data from the opened connection created before
            // InputStreamReader to change the binary code to the characters
            // BufferedReader: To store the data to buffer and read it

            StringBuilder string_of_Text = new StringBuilder();
            String line;
            while(((line = reading.readLine()) != null)){
                string_of_Text.append(line);
            }

            reading.close();

            Path fileName = Path.of("C:/Users/Admin/ComputerNetwork_Lab/Lab_1c/temp.html");
            Files.writeString(fileName, string_of_Text.toString());
            System.out.println("The saved content: " + string_of_Text.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
*/

public class lab1cEx1{
    public static void downloaded(String url){
        try {
            URI uri_create = new URI(url);
            URL url_create = uri_create.toURL();

            //* use to create the reading into to read the stream
            BufferedReader reading = new BufferedReader(new InputStreamReader(url_create.openStream()));
            //* use writer in order to write into the "temp.html"
            BufferedWriter writer = new BufferedWriter(new FileWriter("temp.html"));

            //* write into the file
            String line;
            while ((line = reading.readLine()) != null) {
                writer.write(line);
            }
            reading.close();
            writer.close();
            System.out.println("Successfully downloaded");

        }
        
        //* This block of catch is used to throw the error of wrong URL
        catch (MalformedURLException mue) {
            System.out.println("Malformed URL Exception raised");
        }
        //* This block of catch is used to throw the error of wrong Output/ Input
        catch (IOException ie) {
            System.out.println("IOException raised");
        }
        //* This block of catch is used to throw the error that is not solved by the above two "catch" blocks
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        String url = "http://www.google.com/";
        downloaded(url);
    }
}