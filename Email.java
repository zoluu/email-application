package EmailApp;

import java.util.Scanner;

public class Email {
    private String firstName;
    private String lastName;
    private String department;
    private String password;
    private String email;
    private int defaultPasswordLength = 10;
    private int emailCapacity = 500;
    private String alternateEmail;
    private String companySuffix = "zlcompany.co.uk";

    // Constructor to receive the first name and last name
    public Email(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;

        // Call a method asking for the department and return the department
        this.department = setDepartment();

        // Call a method that returns a random password
        this.password = generatePassword(defaultPasswordLength);
        System.out.println("PASSWORD: " +  this.password);

        // Combine elements to generate email
        email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + "." + companySuffix;
    }

    // Ask for the department
    private String setDepartment(){
        System.out.println("New employee: " + firstName + "\nDEPARTMENT CODES\n1 for Sales\n2 for Development\n3 for Accounting\n0 for None\nEnter department code: ");
        Scanner in = new Scanner(System.in);
        int departmentChoice = in.nextInt();
        if(departmentChoice == 1 ) {return  "sales";}
        else if(departmentChoice == 2) {return  "dev";}
        else if(departmentChoice == 3) {return  "acct";}
        else {return "";}
    }

    // Generate a random password
    private String generatePassword(int length){
        String passwordSet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!$%&*()@#";
        char[] password = new char[length];
        for(int i=0; i<length; i++){
            int rand = (int) (Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(rand);
        }
        return new String(password);
    }

    // Set the mailbox capacity
    public void setEmailCapacity(int emailCapacity) {
        this.emailCapacity = emailCapacity;
    }

    public int getEmailCapacity() {
        return emailCapacity;
    }

    // Set the alternative email
    public void setAlternateEmail(String alternateEmail) {
        this.alternateEmail = alternateEmail;
    }

    public String getAlternateEmail() {
        return alternateEmail;
    }

    // Change the password
    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public String showInfo(){
        return "DISPLAY NAME: " + firstName + " " + lastName +
                "\nCOMPANY EMAIL: " + email +
                "\nMAILBOX CAPACITY: " + emailCapacity + "mb";
    }
}
