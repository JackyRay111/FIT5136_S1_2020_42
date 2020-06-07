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
        ArrayList<String[]> content = new ArrayList<>();
        try{
            FileReader reader = new FileReader(LOGIN);
            Scanner file = new Scanner(reader);
            String tem;
            do{
                tem = file.nextLine().trim();
                content.add(tem.split(","));
            }while (file.hasNextLine());

            reader.close();
        }

        catch (FileNotFoundException var6){
            System.out.println("Unable to find the file: multiples.txt");
        } catch (IOException var7) {
            System.out.println("Error encountered reading the file: multiples.txt");
        }
        return content;
    }

    public ArrayList<String[]> readMission(){
        ArrayList<String []> content = new ArrayList<>();
        try{
            FileReader reader = new FileReader(MISSION);
            Scanner file = new Scanner(reader);
            String tem;
            do{
                tem = file.nextLine().trim();
                content.add(tem.split(","));
            }while (file.hasNextLine());

            reader.close();
        }

        catch (FileNotFoundException var6){
            System.out.println("Unable to find the file: multiples.txt");
        } catch (IOException var7) {
            System.out.println("Error encountered reading the file: multiples.txt");
        }
        return content;
    }

    public ArrayList<String> readFile() throws IOException
    {
        ArrayList<String> cri= new ArrayList<String>();
        FileReader inputFile = new FileReader("criteria.txt");
        try
        {
            Scanner parser = new Scanner(inputFile);
            String option1 = parser.nextLine(); // criminal records
            String option2 = parser.nextLine(); // health records
            String option3 = parser.nextLine(); // qualifications
            cri.add(option1);
            cri.add(option2);
            cri.add(option3);
        }
        finally
        {
            inputFile.close();
        }
        return cri;
    }
    
    public void writeFile(String adminName) throws IOException 
    {
        PrintWriter outputFile = new PrintWriter(fileName);
        try 
        {
            outputFile.println(adminName + "");
        }
        finally 
        {
            outputFile.close();
        }
    }

    public void appendFile(String contents) {
        try {
            FileReader reader = new FileReader("outcome.txt");
            Scanner file = new Scanner(reader);
            StringBuffer stringBuffer = new StringBuffer();

            while(file.hasNextLine() && stringBuffer != null) {
                stringBuffer.append(file.nextLine().trim());
                stringBuffer.append("\r\n");
            }

            reader.close();
            PrintWriter write = new PrintWriter("outcome.txt");
            String var10001 = stringBuffer.toString();
            write.write(var10001 + contents);
            write.close();
        } catch (FileNotFoundException var6) {
            System.out.println("Unable to find the file: outcome.txt");
        } catch (IOException var7) {
            System.out.println("Error encountered writing or reading to the file: outcome.txt");
        }

    }

    public void writeMissions(StringBuffer contents) {
        try {
            PrintWriter write = new PrintWriter(MISSION);

            write.write(contents.toString());
            write.close();
        } catch (FileNotFoundException var6) {
            System.out.println("Unable to find the file: outcome.txt");
        } catch (IOException var7) {
            System.out.println("Error encountered writing or reading to the file: outcome.txt");
        }

    }

    public ArrayList<String[]> readShuttleFile()
    {
        String inputFile = "./shuttle.txt";
        ArrayList<String []> content = new ArrayList<>();
        try{
            FileReader reader = new FileReader(inputFile);
            Scanner file = new Scanner(reader);
            String tem;
            do{
                tem = file.nextLine().trim();
                content.add(tem.split(","));
            }while (file.hasNextLine());

            reader.close();
        }

        catch (FileNotFoundException var6){
            System.out.println("Unable to find the file: shuttle.txt");
        } catch (IOException var7) {
            System.out.println("Error encountered reading the file: shuttle.txt");
        }
        return content;
    }
}
