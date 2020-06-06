import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.lang.System;
public class FileIo {
    private static final String LOGIN = "login.txt";
    private static final String MISSION = "mission.txt";

    public FileIo(){

    }

    public ArrayList<String[]> readLogin(){
        ArrayList<String[]> content = new ArrayList();
        try{
            FileReader reader = new FileReader(LOGIN);
            Scanner file = new Scanner(reader);
            String tem;
            do{
                tem = file.nextLine().trim();
                content.add(tem.split(","));
            }while (file.hasNextLine());
        }
        catch (FileNotFoundException var6){
            System.out.println("Unable to find the file: multiples.txt");
        } catch (IOException var7) {
            System.out.println("Error encountered reading the file: multiples.txt");
        }
        return content;
    }
}
