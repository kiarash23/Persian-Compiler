package uni.iust.controller;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.lang.reflect.Executable;

/**
 * Created by Kiarash23 on 1/8/2019.
 */
public class FileController {
    public static void writePersian(String txt){
        try {
            File file = new File("txtOutput/persian.txt");
            FileWriter writer = new FileWriter(file);
            writer.write(txt);
            writer.write(" ");
            writer.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static String readPersian() throws Exception{
        File file = new File("txtOutput/persian.txt");
        FileReader reader = new FileReader(file);
        int i;
        String content = "";
        while ((i = reader.read()) != -1){
            content += (char)i;
        }
        return content;
    }

    public static void writeEnglish(String txt){
        try {
            File file = new File("txtOutput/english.txt");
            FileWriter writer = new FileWriter(file);
            writer.write(txt);
            writer.write(" ");
            writer.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static String readEnglish() throws Exception{
        File file = new File("txtOutput/english.txt");
        FileReader reader = new FileReader(file);
        int i;
        String content = "";
        while ((i = reader.read()) != -1){
            content += (char)i;
        }
        return content;
    }
}
