import java.util.*;

public class TaxReturn {
    
    private String ssn;
    private String lastName;
    private String firstName;
    private String address;
    private String city;
    private String state;
    private String zipCode;
    private double income;
    private char status;
    private double tax;
    private final double LOWINCOME = 20000;
    private final double HIGHINCOME = 50000;
    private final double SINGLELOW = 0.15;
    private final double SINGLEMED = 0.22;
    private final double SINGLEHIGH = 0.30;
    private final double MARRIEDLOW = 0.14;
    private final double MARRIEDMED = 0.20;
    private final double MARRIEDHIGH = 0.28;
    
    public TaxReturn(String ssn, String lastName, String firstName, String address, String city, String state, String zipCode, double income, char status){
        this.ssn = ssn;
        this.lastName = lastName;
        this.firstName = firstName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.income = income;
        this.status = status;
        
        if(income < LOWINCOME){
            if(status == 'S'){
                tax = income * SINGLELOW;
            }
            else{
                tax = income * MARRIEDLOW;
            }
        }
        else if(income < HIGHINCOME){
            if(status == 'S'){
                tax = income * SINGLEMED;
            }
            else{
                tax = income * MARRIEDMED;
            }
        }
        else{
            if(status == 'S'){
                tax = income * SINGLEHIGH;
            }
            else{
                tax = income * MARRIEDHIGH;
            }
        }
    }
    
    public void display(){
        System.out.println("Taxpayer ssn:" + ssn + "" + firstName + "" + lastName + "\n" + address + "\n" + city + ", " + state + "" + zipCode + "\nMarital Status:" + status + "\n" + "Income: $" + income + "Tax: $" + tax);
    }
    
}
