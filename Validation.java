import java.awt.image.PackedColorModel;
import java.time.LocalDate;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.zip.CheckedOutputStream;

public class Validation {

    public Validation(){

    }

    public int acceptNumericInput() {
        int temp = 0;
        boolean isValidate = false;

        do {
            Scanner jacky = new Scanner(System.in);
            if (jacky.hasNextInt()) {
                temp = jacky.nextInt();
                isValidate = true;
            } else {
                System.out.println("Error Pleas enter a number, Please enter again:");
            }
        }while(isValidate == false);

        return temp;
    }

    /*
    public int acceptValidateLoginChoice(){

        int temp = 0;
        boolean isValidate = false;

        do {
            Scanner jacky = new Scanner(System.in);
            if (jacky.hasNextInt()) {
                temp = jacky.nextInt();
                if(temp == 1 || temp == 2){
                    isValidate = true;
                }
                else {
                    System.out.println("Please enter the right choice");
                }

            } else {
                System.out.println("Error Pleas enter a number, Please enter again:");
            }
        }while(isValidate == false);

        return temp;
    }*/

    public int acceptValidateChoiceInRange(int min, int max){
        int temp = 0;
        boolean isValidate = false;

        do {
            Scanner jacky = new Scanner(System.in);
            if (jacky.hasNextInt()) {
                temp = jacky.nextInt();
                if(min <=temp && temp <= max){
                    isValidate = true;
                }
                else {
                    System.out.println("Please enter the with in the range");
                }

            } else {
                System.out.println("Error Pleas enter a number, Please enter again:");
            }
        }while(isValidate == false);

        return temp;
    }

    public int acceptPositiveInt(){
        int temp = 0;
        boolean isValidate = false;

        do {
            Scanner jacky = new Scanner(System.in);
            if (jacky.hasNextInt()) {
                temp = jacky.nextInt();
                if(temp >= 0){
                    isValidate = true;
                }
                else {
                    System.out.println("Please enter the positive number");
                }

            } else {
                System.out.println("Error Pleas enter a number, Please enter again:");
            }
        }while(isValidate == false);
        return temp;
    }


    public String acceptNoBlankStringInput(){
        String temp = "";
        boolean isValidate = false;

        do{
            Scanner jacky = new Scanner(System.in);
            if(jacky.hasNextLine()){
                temp = jacky.nextLine().trim();
                if(temp.length() > 0){
                    isValidate = true;
                }
                else {
                    System.out.println("Please do not enter empty content, Please enter again: ");
                }
            }
            else {
                System.out.println("Please enter required format, Please enter again: ");
            }
        }while(isValidate == false);
        return temp;
    }

    public String acceptRequiredLengthString(int min, int max){
        String temp = "";
        boolean isValidate = false;

        do{
            Scanner jacky = new Scanner(System.in);
            if(jacky.hasNextLine()){
                temp = jacky.nextLine().trim();
                if(temp.length() > 0 && temp.length()>= min && temp.length() <= max){
                    isValidate = true;
                }
                else {
                    System.out.println("Please do not enter empty content or less than " + min + " number character,Please enter again: ");
                }
            }
            else {
                System.out.println("Please enter required format, Please enter again: ");
            }
        }while(isValidate == false);
        return temp;
    }

    public String acceptValidateLocalDate(){
        String temp = "";
        boolean isValidate = false;

        do{
            Scanner jacky = new Scanner(System.in);
            if(jacky.hasNextLine()){
                temp = jacky.nextLine().trim();
                if(temp.length() > 0){
                    Pattern pattern = Pattern.compile("\\d{4}-\\d{2}-\\d{2}");
                    if(pattern.matcher(temp).matches()) {
                        LocalDate enter = LocalDate.parse(temp);
                        if(enter.compareTo(LocalDate.now()) >0 )
                        {
                            isValidate = true;
                        }
                        else {
                            System.out.println("Please enter the future data time");
                        }
                    } else {
                        System.out.println("Please enter required format (yyyy-MM-dd), Please enter again: ");
                    }
                }
                else {
                    System.out.println("Please do not enter empty content, Please enter again: ");
                }
            }
            else {
                System.out.println("Please enter required format, Please enter again: ");
            }
        }while(isValidate == false);
        return temp;
    }

}
