import java.util.*;

public class PrepareTax {
    
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
