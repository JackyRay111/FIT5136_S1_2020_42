import java.util.Scanner;
import java.util.zip.CheckedOutputStream;

public class Validation {

    public Validation(){

    }
/*
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
    }*/

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
                    System.out.println("Please enter the right choice");
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


}
