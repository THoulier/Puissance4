package userInterface;

import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;

public class FileWritter {

    public static void fillInLog(String text ){
        try {
            File logFile = new File("log.txt");
            BufferedWriter logWriter = new BufferedWriter(new FileWriter("log.txt",true));
            logWriter.write(text);
            logWriter.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}