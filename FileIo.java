import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class FileIo {
    private static final String LOGIN = "login.txt";
    private static final String MISSION = "mission.txt";

    public FileIo(){

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

    
}
