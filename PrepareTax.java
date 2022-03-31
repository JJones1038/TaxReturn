/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author jjone
 */
import java.util.Scanner;

public class PrepareTax {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String ssn = getValidSSN(scanner);

        System.out.print("Enter your last name: ");

        String last = scanner.nextLine();

        System.out.print("Enter your first name: ");

        String first = scanner.nextLine();

        System.out.print("Enter your address: ");

        String address = scanner.nextLine();

        System.out.print("Enter your city: ");

        String city = scanner.nextLine();

        System.out.print("Enter your state: ");

        String state = scanner.nextLine();

        String zip = getValidZip(scanner);

        double income = getValidAnnualIncome(scanner);

        char status = getValidMaritalStatus(scanner);

        // creating a TaxReturn object, displaying report

        TaxReturn taxReturn = new TaxReturn(ssn, last, first, address, city, state, zip, income, status);

        taxReturn.display();
    }
    
    static String getValidSSN(Scanner scanner){
        System.out.println("Enter your social security number: ");
        String ssn = scanner.nextLine();
        boolean valid = true;
        
        if(ssn.length() == 11){
            for(int i = 0; i < ssn.length(); i++){
                if(i == 3 || i == 6){
                    if(ssn.charAt(i) != '-'){
                        valid = false;
                        
                        break;
                    }
                }
                else if(!Character.isDigit(ssn.charAt(i))){
                    valid = false;
                    
                    break;
                }
            }
        }
        else{
            valid = false;
        }
        
        if(valid){
            return ssn;
        }
        else{
            System.out.println("Invalid SSN, try again!");
            return getValidSSN(scanner);
        }
    }
    
    static String getValidZip(Scanner scanner){
        System.out.println("Enter your zip code: ");
        String zipCode = scanner.nextLine();
        boolean valid = true;
        
        if(zipCode.length() == 5){
            for(int i = 0; i < zipCode.length(); i++){
                if(!Character.isDigit(zipCode.charAt(i))){
                    valid = false;
                    
                    break;
                }
            }
        }
        else{
            valid = false;
        }
        if(valid){
            return zipCode;
        }
        else{
            System.out.println("Invalid Zip Code, try again!");
            return getValidZip(scanner);
        }
    }
    
    static char getValidMaritalStatus(Scanner scanner){
        System.out.println("Enter your marital status: ");
        String status = scanner.nextLine().toUpperCase();
        
        if(status.length() > 0 && (status.charAt(0) == 'S' || status.charAt(0) == 'M')){
            return status.charAt(0);
        }
        else{
            System.out.println("Invalid marital status, try again!");
            return getValidMaritalStatus(scanner);
        }
    }
    
    static double getValidAnnualIncome(Scanner scanner){
        System.out.println("Enter your annual income: ");
        double income = Double.parseDouble(scanner.nextLine());
        
        if(income >= 0){
            return income;
        }
        else{
            System.out.println("Invalid income, try again!");
            return getValidAnnualIncome(scanner);
        }
    }
    
}
