package FIT5136_Implementation;

public class Main {

  private ArrayList<String> readFile()
    {
        ArrayList<String> option = new ArrayList<String>();
        try
        {
            FileIO readFile = new FileIO("criteria.txt");
            option = readFile.readFile();
        }
        catch (Exception e) 
        {
            System.out.println("It can not find the criteria.txt");
            System.exit(0);
        }
        return option;
    }

}

