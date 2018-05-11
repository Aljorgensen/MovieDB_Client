package com.mycompany.moviedb;

import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.net.ssl.HttpsURLConnection;
import javax.swing.JButton;
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
    Startgui st;
    
    ArrayList<String> title = new ArrayList<>();
    ArrayList<String> id = new ArrayList<>();
    ArrayList<String> release = new ArrayList<>();
    ArrayList<String> poster = new ArrayList<>();
    ArrayList<String> plot = new ArrayList<>();
    ArrayList<String> latest = new ArrayList<>();
    public String clientNavn = "";
    public String token = "";
    private final String filepathToken = "/Users/andersjorgensen/Documents/DTU/Programmering/Java/MovieDB/token.txt";
    private final String filepathLogin = "/Users/andersjorgensen/Documents/DTU/Programmering/Java/MovieDB/login.txt";
    private String username = "";
    Boolean loginStatus = false;
    public int type = 0;
    public GuiController ejer;
    JButton b1 = new JButton();
    
    //API-Methods
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
        try {
            URL u = new URL("https://komsaananna.dk/api/movie/search/?search=" + search);
            HttpsURLConnection conn = (HttpsURLConnection) u.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Authorization", "Bearer " + token);
            conn.setRequestProperty("Content-Type", "application/json");
            InputStream is = conn.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);

            int responsecode = conn.getResponseCode();
            System.out.println("Response code is: " + responsecode + " Moviesearch");
            //Iterating condition to if response code is not 200 then throw a runtime exception
            //else continue the actual process of getting the JSON data
            if (responsecode != 200) {
                throw new RuntimeException("HttpResponseCode: " + responsecode);
            } else {
                //Scanner functionality will read the JSON data from the stream
                while ((line = br.readLine()) != null) {
                    result.append(line).append("\n");
                }
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
            br.close();
            isr.close();
            is.close();
            conn.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
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
            URL url = new URL("http://" + clientNavn + "/api/movie/ListMovies?");
            //Parse URL into HttpURLConnection in order to open the connection in order to get the JSON data
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            //Set the request to GET or POST as per the requirements
            conn.setRequestMethod("GET");
            conn.setRequestProperty ("Authorization", "Bearer " + token);
            //Use the connect method to create the connection bridge
            conn.connect();
            //Get the response status of the Rest API
            int responsecode = conn.getResponseCode();
            System.out.println("Response code is: " + responsecode + " Movielist");
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
            URL url = new URL("http://" + clientNavn + "/api/movie/add?ID=" + id);
            HttpURLConnection httpConnection  = (HttpURLConnection) url.openConnection();
            httpConnection.setDoOutput(true);
            httpConnection.setRequestMethod("POST");
            httpConnection.setRequestProperty("Content-Type", "application/json");
            httpConnection.setRequestProperty("Accept", "application/json");
            httpConnection.setRequestProperty("Authorization", "Bearer " + token);

            // Writes the JSON parsed as string to the connection
            DataOutputStream wr = new DataOutputStream(httpConnection.getOutputStream());
            wr.write(data.toString().getBytes());
            Integer responseCode = httpConnection.getResponseCode();
            System.out.println("Response code is: " + responseCode + " Add movie");
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
    
    public void deleteMovie(String id) {
        String result = "";
        try {
            // Construct manually a JSON object in Java, for testing purposes an object with an object
            JSONObject data = new JSONObject();
            data.put("ID", id);

            // URL and parameters for the connection, This particulary returns the information passed
            URL url = new URL("http://" + clientNavn + "/api/movie/del?ID=" + id);
            HttpURLConnection httpConnection = (HttpURLConnection) url.openConnection();
            httpConnection.setDoOutput(true);
            httpConnection.setRequestMethod("DELETE");
            httpConnection.setRequestProperty("Content-Type", "application/json");
            httpConnection.setRequestProperty("Accept", "application/json");
            httpConnection.setRequestProperty("Authorization", "Bearer " + token);

            // Writes the JSON parsed as string to the connection
            DataOutputStream wr = new DataOutputStream(httpConnection.getOutputStream());
            wr.write(data.toString().getBytes());
            Integer responseCode = httpConnection.getResponseCode();
            System.out.println("Response code is: " + responseCode + " Delete movie");
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

            if (content.toString().contains("Deleted")) {
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
    
    public String getTrailerUrl(String id){
        String urlString = "";
        String inline = "";
        String line;
        StringBuilder result = new StringBuilder("");
        try {
            URL u = new URL("https://komsaananna.dk/api/movie/trailer?id=" + id);
            HttpsURLConnection conn = (HttpsURLConnection) u.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Authorization", "Bearer " + token);
            conn.setRequestProperty("Content-Type", "application/json");
            InputStream is = conn.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);

            int responsecode = conn.getResponseCode();
            System.out.println("Response code is: " + responsecode + " Trailer");
            //Iterating condition to if response code is not 200 then throw a runtime exception
            //else continue the actual process of getting the JSON data
            if (responsecode != 200) {
                throw new RuntimeException("HttpResponseCode: " + responsecode);
            } else {
                //Scanner functionality will read the JSON data from the stream
                while ((line = br.readLine()) != null) {
                    result.append(line).append("\n");
                }
            }
            inline = result.toString();
            if(inline.contains("no trailer")){
               JOptionPane.showMessageDialog(null, "No trailer aviable"); 
            }else{
              urlString = inline.replace("{\"trailerlink\":\"", "");
            urlString = urlString.replace("\"}", "");   
            }
            
            br.close();
            isr.close();
            is.close();
            conn.disconnect();
            //Disconnect the HttpURLConnection stream
        } catch (Exception e) {
            e.printStackTrace();
        }
        return urlString;
    }
    
    //JWT-Methods
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
            
            System.out.println("Response code is: " + responseCode + " Got token");
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
               token = token.replace("\"}\n","");
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
        try { 
            URL url = new URL("https://komsaananna.dk/api/user/verifytoken");
            //Parse URL into HttpURLConnection in order to open the connection in order to get the JSON data
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            //Set the request to GET or POST as per the requirements
            conn.setRequestMethod("GET");
            conn.setRequestProperty ("Authorization", "Bearer " + token);
            
            //Get the response status of the Rest API
            int responsecode = conn.getResponseCode();
            System.out.println("Response code is: " + responsecode + " Token verification");
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
    
    void renewToken(){
        readTokenFromFile();
        verifyToken();
        loadLogin();
        if(loginStatus == true){
            JOptionPane.showMessageDialog(null, "Succesful login");
            ejer.skift(ejer.maingui);
        }else{
            JOptionPane.showMessageDialog(null, "Couldn't validate old token, please login again");
        }
    }
    
    //Logic-Methoeds
    public void setLatest(){
        String line = "";
        mg.LatestArea.setText("");
        for(String a : latest){
            line = a.replaceAll("%20", " ");
            mg.LatestArea.append(line + "\n");
        }
    }
    
    public Boolean setMovie(){
        rg.listTest.removeAll();
        if(title.isEmpty()){
            JOptionPane.showMessageDialog(null, "Seach attempt failed, try again");
            return false;
        }else{
            for(int i = 0; i < title.size(); i++){
                rg.listTest.add(title.get(i)); 
            }
            if(type == 0){
                b1.setVisible(true);
                b1.setBounds(5, 475, 111, 29);
                b1.setText("Add movie");
                b1.addActionListener((ActionEvent e) -> {
                    addMovie(id.get(rg.listTest.getSelectedIndex()));
                });
                rg.add(b1); 
            }else{
                rg.remove(b1);
                rg.revalidate();
                rg.repaint();
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
       String posterUrl = poster.get(num);
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
       String posterUrl = poster.get(num);
       if(!"".equals(posterUrl)){
         try{
           BufferedImage img = ImageIO.read(new URL(posterUrl));
           rg.poster.setIcon(new javax.swing.ImageIcon(img)); 
        }catch(IOException e){
            e.printStackTrace();
        }  
       }
    }
    
    public void readTokenFromFile(){
        BufferedReader br = null;
        FileReader fr = null;
        try {
            fr = new FileReader(filepathToken);
            br = new BufferedReader(fr);
            String sCurrentLine;
            while ((sCurrentLine = br.readLine()) != null) {
                token = sCurrentLine;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
                if (fr != null) {
                    fr.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
    
    public void writeTokenToFile(String tokenString){
        BufferedWriter bw = null;
        FileWriter fw = null;
        try {
            fw = new FileWriter(filepathToken);
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
    
    public void loadLogin(){
        BufferedReader br = null;
        FileReader fr = null;
        try {
            fr = new FileReader(filepathLogin);
            br = new BufferedReader(fr);;
            StringBuilder content = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                content.append(line).append("\n");
            }
            String buffer = content.toString();
            String[] bufferarray = buffer.split("\n");
            username = bufferarray[0];
            clientNavn = bufferarray[1];
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
                if (fr != null) {
                    fr.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
    
    public void saveLogin(String user, String address){
        BufferedWriter bw = null;
        FileWriter fw = null;
        String credentials = user + "\n" + address;
        try {
            fw = new FileWriter(filepathLogin);
            bw = new BufferedWriter(fw);
            bw.write(credentials);
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
    
}
