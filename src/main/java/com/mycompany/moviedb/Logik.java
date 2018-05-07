package com.mycompany.moviedb;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.net.ssl.HttpsURLConnection;
import javax.swing.JOptionPane;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 *
 * @author andersjorgensen
 */
public class Logik {
    
    MainGui mg;
    ResultGui rg;
    InfoGui ig;
    
    ArrayList<String> title = new ArrayList<>();
    ArrayList<String> id = new ArrayList<>();
    ArrayList<String> release = new ArrayList<>();
    ArrayList<String> poster = new ArrayList<>();
    ArrayList<String> plot = new ArrayList<>();
    ArrayList<String> latest = new ArrayList<>();
    String apiKey = "";
    String token = "";
    Boolean loginStatus;
    int parameter = 0;
    double page = 0;
    double defineNum = 5;
    double pageNum = 0;
    int choice = 0;
    int type = 0;
    
    public void movie_search(String search) {
        //inline will store the JSON data streamed in string format
        title.clear();
        id.clear();
        release.clear();
        poster.clear();
        plot.clear();
        String inline = "";
        String line;
        StringBuilder result = new StringBuilder("");
        BufferedReader rd;
        try {
            URL url = new URL("http://peterpan.dk/api/movie/search/?search=" + search + "&apikey=" + apiKey);
            //Parse URL into HttpURLConnection in order to open the connection in order to get the JSON data
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            //Set the request to GET or POST as per the requirements
            conn.setRequestMethod("GET");
            //Use the connect method to create the connection bridge
            conn.connect();
            //Get the response status of the Rest API
            int responsecode = conn.getResponseCode();
            System.out.println("Response code is: " + responsecode);
            //Iterating condition to if response code is not 200 then throw a runtime exception
            //else continue the actual process of getting the JSON data
            
            if (responsecode != 200) {
                throw new RuntimeException("HttpResponseCode: " + responsecode);
            } else {
                //Scanner functionality will read the JSON data from the stream
                rd = new BufferedReader(new InputStreamReader(url.openStream()));
                while ((line = rd.readLine()) != null) {
                    result.append(line).append("\n");
                }
                rd.close();
            }
            inline = result.toString();
            //JSONParser reads the data from string object and break each data into key value pairs
            JSONParser jsonparse = new JSONParser();
            //Type caste the parsed json data in json object
            JSONObject jobj = (JSONObject) jsonparse.parse(inline);
            //Store the JSON object in JSON array as objects (For level 1 array element i.e Results)
            JSONArray jsonarr_1 = (JSONArray) jobj.get("resultlist");
            //Get data for Results array
            for (int i = 0; i < jsonarr_1.size(); i++) {
                JSONObject jsonobj_1 = (JSONObject) jsonarr_1.get(i);
                title.add("" + jsonobj_1.get("title"));
                release.add("" + jsonobj_1.get("release_date"));
                id.add("" + jsonobj_1.get("id"));
                poster.add("" + jsonobj_1.get("poster"));
                plot.add("" + jsonobj_1.get("plot"));
            } 
            //Disconnect the HttpURLConnection stream
            //conn.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
        
    public void setLatest(){
        String line = "";
        mg.LatestArea.setText("");
        for(String a : latest){
            line = a.replaceAll("%20", " ");
            mg.LatestArea.append(line + "\n");
        }
    }
    
    public Boolean setMovie(){
        if(title.isEmpty()){
            JOptionPane.showMessageDialog(null, "Seach attempt failed, try again");
            return false;
        }else{
        rg.movieOneTitle.setText("Title: " + title.get(0 + parameter));
        rg.movieOneID.setText("ID: " + id.get(0 + parameter));
        if(title.size() > 1 + parameter){
           rg.movieTwoTitle.setText("Title: " + title.get(1 + parameter));
           rg.movieTwoID.setText("ID: " + id.get(1 + parameter));
          if(title.size() > 2 + parameter){
            rg.movieThreeTitle.setText("Title: " + title.get(2 + parameter));
            rg.movieThreeID.setText("ID: " + id.get(2 + parameter));
            if(title.size() > 3 + parameter) {
              rg.movieFourTitle.setText("Title: " + title.get(3 + parameter));
              rg.movieFourID.setText("ID: " + id.get(3 + parameter));
              if(title.size() > 4 + parameter){
                rg.movieFiveTitle.setText("Title: " + title.get(4 + parameter));
                rg.movieFiveID.setText("ID: " + id.get(4 + parameter));
              }else{
                rg.movieFiveTitle.setText("Title: No Result");
                rg.movieFiveID.setText("ID: No Result");   
              }
            }else{
             rg.movieFourTitle.setText("Title: No Result");
             rg.movieFourID.setText("ID: No Result");
             rg.movieFiveTitle.setText("Title: No Result");
             rg.movieFiveID.setText("ID: No Result");  
            }
          }else{
            rg.movieThreeTitle.setText("Title: No Result");
            rg.movieThreeID.setText("ID: No Result");
            rg.movieFourTitle.setText("Title: No Result");
            rg.movieFourID.setText("ID: No Result");
            rg.movieFiveTitle.setText("Title: No Result");
            rg.movieFiveID.setText("ID: No Result"); 
          }
        }else{
            rg.movieTwoTitle.setText("Title: No Result");
            rg.movieTwoID.setText("ID: No Result");
            rg.movieThreeTitle.setText("Title: No Result");
            rg.movieThreeID.setText("ID: No Result");
            rg.movieFourTitle.setText("Title: No Result");
            rg.movieFourID.setText("ID: No Result");
            rg.movieFiveTitle.setText("Title: No Result");
            rg.movieFiveID.setText("ID: No Result");
        }  
        }
        return true;
    }
    
    public void splitPlot(int num){
        ig.moviePlot.setText("");
        String[] plottext;
        plottext = plot.get(num).split(", ");
        for(String str : plottext){
            ig.moviePlot.append(str + ",\n");
        }
    }
    
    public String splitRelease(int num){
        String[] releaseSplit;
        releaseSplit = release.get(num).split(" ");
        return releaseSplit[0];
    }
    
    public void setPoster(int num){
       ig.poster.removeAll();
       String posterUrl = poster.get(num + parameter);
       if(!"".equals(posterUrl)){
         try{
           BufferedImage img = ImageIO.read(new URL(posterUrl));
           ig.poster.setIcon(new javax.swing.ImageIcon(img)); 
        }catch(IOException e){
            e.printStackTrace();
        }  
       }
    }
    
    public void setPosterResult(int num){
       rg.poster.removeAll();
       String posterUrl = poster.get(num + parameter);
       if(!"".equals(posterUrl)){
         try{
           BufferedImage img = ImageIO.read(new URL(posterUrl));
           rg.poster.setIcon(new javax.swing.ImageIcon(img)); 
        }catch(IOException e){
            e.printStackTrace();
        }  
       }
    }
    
    public void getMovielist(){
        title.clear();
        id.clear();
        release.clear();
        poster.clear();
        plot.clear();
        String inline = "";
        String line;
        StringBuilder result = new StringBuilder("");
        BufferedReader rd;
        try {
            URL url = new URL("http://peterpan.dk/api/movie/ListMovies?apikey=" + apiKey);
            //Parse URL into HttpURLConnection in order to open the connection in order to get the JSON data
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            //Set the request to GET or POST as per the requirements
            conn.setRequestMethod("GET");
            //Use the connect method to create the connection bridge
            conn.connect();
            //Get the response status of the Rest API
            int responsecode = conn.getResponseCode();
            System.out.println("Response code is: " + responsecode);
            //Iterating condition to if response code is not 200 then throw a runtime exception
            //else continue the actual process of getting the JSON data
            
            if (responsecode != 200) {
                throw new RuntimeException("HttpResponseCode: " + responsecode);
            } else {
                //Scanner functionality will read the JSON data from the stream
                rd = new BufferedReader(new InputStreamReader(url.openStream()));
                while ((line = rd.readLine()) != null) {
                    result.append(line).append("\n");
                }
                rd.close();
            }
            inline = result.toString();
            //JSONParser reads the data from string object and break each data into key value pairs
            JSONParser jsonparse = new JSONParser();
            //Type caste the parsed json data in json object
            JSONObject jobj = (JSONObject) jsonparse.parse(inline);
            //Store the JSON object in JSON array as objects (For level 1 array element i.e Results)
            JSONArray jsonarr_1 = (JSONArray) jobj.get("resultlist");
            //Get data for Results array
            for (int i = 0; i < jsonarr_1.size(); i++) {
                JSONObject jsonobj_1 = (JSONObject) jsonarr_1.get(i);
                title.add("" + jsonobj_1.get("title"));
                release.add("" + jsonobj_1.get("release_date"));
                id.add("" + jsonobj_1.get("id"));
                poster.add("http://image.tmdb.org/t/p/w185" + jsonobj_1.get("poster"));
                plot.add("" + jsonobj_1.get("plot"));
            }
            //Disconnect the HttpURLConnection stream
            //conn.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void addMovie(String id){
        String result = "";
            try {
            // Construct manually a JSON object in Java, for testing purposes an object with an object
            JSONObject data = new JSONObject();
            data.put("ID", id);

            // URL and parameters for the connection, This particulary returns the information passed
            URL url = new URL("http://peterpan.dk/api/movie/add?ID=" + id + "&apikey=" + apiKey);
            HttpURLConnection httpConnection  = (HttpURLConnection) url.openConnection();
            httpConnection.setDoOutput(true);
            httpConnection.setRequestMethod("POST");
            httpConnection.setRequestProperty("Content-Type", "application/json");
            httpConnection.setRequestProperty("Accept", "application/json");

            // Writes the JSON parsed as string to the connection
            DataOutputStream wr = new DataOutputStream(httpConnection.getOutputStream());
            wr.write(data.toString().getBytes());
            Integer responseCode = httpConnection.getResponseCode();

            BufferedReader bufferedReader;

            // Creates a reader buffer
            if (responseCode > 199 && responseCode < 300) {
                bufferedReader = new BufferedReader(new InputStreamReader(httpConnection.getInputStream()));
            } else {
                bufferedReader = new BufferedReader(new InputStreamReader(httpConnection.getErrorStream()));
            }

            // To receive the response
            StringBuilder content = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                content.append(line).append("\n");
            }
            bufferedReader.close();
            if(content.toString().contains("Duplicate")){
                result = "Already in database";
            }else{
               result = "Added to database";
            }
            
            // Prints the response
            JOptionPane.showMessageDialog(null, result);

        } catch (Exception e) {
            System.out.println("Error Message");
            System.out.println(e.getClass().getSimpleName());
            System.out.println(e.getMessage());
        }
    }
    
    void getToken(String username, String password){
        try {
            // Construct manually a JSON object in Java, for testing purposes an object with an object
            JSONObject data = new JSONObject();
            data.put("username", username);
            data.put("password", password);

            // URL and parameters for the connection, This particulary returns the information passed
            URL url = new URL("https://komsaananna.dk/api/user/requesttoken");
            HttpsURLConnection httpConnection  = (HttpsURLConnection) url.openConnection();
            httpConnection.setDoOutput(true);
            httpConnection.setRequestMethod("POST");
            httpConnection.setRequestProperty("Content-Type", "application/json");
            httpConnection.setRequestProperty("Accept", "application/json");

            // Writes the JSON parsed as string to the connection
            DataOutputStream wr = new DataOutputStream(httpConnection.getOutputStream());
            wr.write(data.toString().getBytes());
            Integer responseCode = httpConnection.getResponseCode();
            
            System.out.println("Response code is: " + responseCode);
            BufferedReader bufferedReader;
            
            // Creates a reader buffer
            if (responseCode > 199 && responseCode < 300) {
                bufferedReader = new BufferedReader(new InputStreamReader(httpConnection.getInputStream()));
            } else {
                bufferedReader = new BufferedReader(new InputStreamReader(httpConnection.getErrorStream()));
            }

            // To receive the response
            StringBuilder content = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                content.append(line).append("\n");
            }
            bufferedReader.close();;
            
            token = content.toString();
            if(token.contains("token")){
               token = token.replace("{\"token\":\"", "");
               token = token.replace("\"}","");
               token = token.replace("\n", "");
               writeTokenToFile(token); 
               verifyToken();
            }else{
               JOptionPane.showMessageDialog(null, "Wrong username or password"); 
            }

        } catch (Exception e) {
            System.out.println("Error Message");
            System.out.println(e.getClass().getSimpleName());
            System.out.println(e.getMessage());
        }
        
    }
    
    void verifyToken(){
        String Auth = "Bearer " + token;
        try { 
            URL url = new URL("https://komsaananna.dk/api/user/varifytoken");
            //Parse URL into HttpURLConnection in order to open the connection in order to get the JSON data
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            //Set the request to GET or POST as per the requirements
            conn.setRequestMethod("GET");
            conn.setRequestProperty ("Authorization", Auth);
            
            //Get the response status of the Rest API
            int responsecode = conn.getResponseCode();
            System.out.println("Response code is: " + responsecode + " token verified");
            //Iterating condition to if response code is not 200 then throw a runtime exception
            //else continue the actual process of getting the JSON data
            if (responsecode != 200) {
                throw new RuntimeException("HttpResponseCode: " + responsecode);
            } else {
                loginStatus = true; 
            }
            //Disconnect the HttpURLConnection stream
            //conn.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void writeTokenToFile(String tokenString){
        
        BufferedWriter bw = null;
        FileWriter fw = null;

        try {
            fw = new FileWriter("/Users/andersjorgensen/Documents/DTU/Programmering/Java/MovieDB/token.txt");
            bw = new BufferedWriter(fw);
            bw.write(tokenString);

        } catch (IOException e) {

            e.printStackTrace();

        } finally {
            try {
                if (bw != null) {
                    bw.close();
                }
                if (fw != null) {
                    fw.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
    
    public void deleteMovie(String id){
        String result = "";
        try {
            // Construct manually a JSON object in Java, for testing purposes an object with an object
            JSONObject data = new JSONObject();
            data.put("ID", id);

            // URL and parameters for the connection, This particulary returns the information passed
            URL url = new URL("http://peterpan.dk/api/movie/del?ID=" + id + "&apikey=" + apiKey);
            HttpURLConnection httpConnection  = (HttpURLConnection) url.openConnection();
            httpConnection.setDoOutput(true);
            httpConnection.setRequestMethod("DELETE");
            httpConnection.setRequestProperty("Content-Type", "application/json");
            httpConnection.setRequestProperty("Accept", "application/json");

            // Writes the JSON parsed as string to the connection
            DataOutputStream wr = new DataOutputStream(httpConnection.getOutputStream());
            wr.write(data.toString().getBytes());
            Integer responseCode = httpConnection.getResponseCode();

            BufferedReader bufferedReader;

            // Creates a reader buffer
            if (responseCode > 199 && responseCode < 300) {
                bufferedReader = new BufferedReader(new InputStreamReader(httpConnection.getInputStream()));
            } else {
                bufferedReader = new BufferedReader(new InputStreamReader(httpConnection.getErrorStream()));
            }

            // To receive the response
            StringBuilder content = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                content.append(line).append("\n");
            }
            bufferedReader.close();

            if(content.toString().contains("Deleted")){
                result = "Deleted from database";
            }
            // Prints the response
            JOptionPane.showMessageDialog(null, result);

        } catch (Exception e) {
            System.out.println("Error Message");
            System.out.println(e.getClass().getSimpleName());
            System.out.println(e.getMessage());
        }
    }
    
    public void definePagenumber(){
        double size = title.size();
        page = size / defineNum;
        if(page > 8){
           page = 8; 
        }else if(page > 7){
            page = 7;
        }else if(page > 6){
            page = 6;
        }else if(page > 5){
            page = 5;
        }else if(page > 4){
            page = 4;
        }else if(page > 3){
            page = 3;
        }else if(page > 2){
            page = 2;
        }else if(page > 1){
            page = 1;
        }else if(page > 0){
            page = 0;
        }
    }
    
    public String getTrailerUrl(String id){
        String urlString = "";
        String inline = "";
        String line;
        StringBuilder result = new StringBuilder("");
        BufferedReader rd;
        try {
            URL url = new URL("http://peterpan.dk/api/movie/trailer?id=" + id + "&apikey=" + apiKey);
            //Parse URL into HttpURLConnection in order to open the connection in order to get the JSON data
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            //Set the request to GET or POST as per the requirements
            conn.setRequestMethod("GET");
            //Use the connect method to create the connection bridge
            conn.connect();
            //Get the response status of the Rest API
            int responsecode = conn.getResponseCode();
            System.out.println("Response code is: " + responsecode);
            //Iterating condition to if response code is not 200 then throw a runtime exception
            //else continue the actual process of getting the JSON data
            
            if (responsecode != 200) {
                throw new RuntimeException("HttpResponseCode: " + responsecode);
            } else {
                //Scanner functionality will read the JSON data from the stream
                rd = new BufferedReader(new InputStreamReader(url.openStream()));
                while ((line = rd.readLine()) != null) {
                    result.append(line).append("\n");
                }
                rd.close();
            }
            inline = result.toString();
            urlString = inline.replace("{\"trailerlink\":\"", "");
            urlString = urlString.replace("\"}", ""); 
            
            //Disconnect the HttpURLConnection stream
            //conn.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return urlString;
    }
    
}
