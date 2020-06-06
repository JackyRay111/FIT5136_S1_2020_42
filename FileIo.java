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
    private String fileName;

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

            reader.close();
        }

        catch (FileNotFoundException var6){
            System.out.println("Unable to find the file: multiples.txt");
        } catch (IOException var7) {
            System.out.println("Error encountered reading the file: multiples.txt");
        }
        return content;
    }

 
    
    /**
     * Default constructor to initialize the object of the FileIO class
     * 
     */
    public FileIo()
    {
        fileName = "";
    }
    
    /**
     * Non default constructor to initialize the object of the FileIO class
     * 
     * @param fileName Name of the file to be read or written to
     */
    public FileIo(String fileName) 
    {
        this.fileName = fileName;
    }

    /**
     * Method to read the contents from the file
     *
     * @return A entire contents of the file represented as a single string. New lines are delimited with a \n
     */
    public ArrayList<String> readFile() throws IOException  
    {
        ArrayList<String> option = new ArrayList<String>();
        FileReader inputFile = new FileReader(fileName);
        try 
        {
            Scanner parser = new Scanner(inputFile);
            String option1 = parser.nextLine(); // 1
            String option2 = parser.nextLine(); // 2
            String option3 = parser.nextLine(); // 3
            String option4 = parser.nextLine(); // 4
            option.add(option1);
            option.add(option2);
            option.add(option3);
            option.add(option4);
        }
        finally 
        {
            inputFile.close();
        }
        return option;
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

}
