package uni.iust.Service;

import org.apache.http.HttpEntity;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.HttpClientBuilder;
import uni.iust.controller.FileController;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by Kiarash23 on 12/30/2018.
 */
public class ApiService {
    final static String url = "http://localhost:5000/";
    public static void send(int mode) {
        String sendUrl = url + mode;
        File file;
        if (mode == 1)
            file = new File("txtOutput/persian.txt");
        else
            file = new File("txtOutput/english.txt");
        HttpEntity entity = MultipartEntityBuilder.create().addPart("file", new FileBody(file)).build();
        HttpPost postRequest = new HttpPost(sendUrl);
        postRequest.setEntity(entity);
        HttpClient client = HttpClientBuilder.create().build();
        try {
            client.execute(postRequest);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public static String receive(){
        String content="";
        try{
            URL receiveUrl = new URL(url + "dst.txt");
//            URL receiveUrl = new URL("http://linuxstory.ir/chapters/nerd_bd_1.html");
//            URLConnection urlConnection = receiveUrl.openConnection();
//            InputStream inputStream = urlConnection.getInputStream(receiveUrl.openStream(),"UTF-8");
            BufferedReader reader = new BufferedReader(new InputStreamReader(receiveUrl.openStream(),"UTF-8"));
            int ascii = reader.read();
            while (ascii!=-1)
            {
                content+=(char) ascii;
                ascii= reader.read();
            }
            reader.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return content;
    }
}
