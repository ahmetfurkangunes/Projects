package Emailapp;

import java.util.Scanner;

public class Email {
    private String firstName;
    private String lastName;
    private String password;
    private String department;
    private String email;
    private int mailboxCapacity = 500;
    private int defaultPasswordLength = 10;
    private String alternateEmail;
    private String companySuffix = "sss.com";

    public Email(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
        System.out.println("Email Created:" + this.firstName + " " + this.lastName);
        this.department = setDepartment();
        System.out.println("Department:" + this.department);

        this.password = randomPassword(defaultPasswordLength);
        System.out.println("Your password is:" + this.password);

        email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + companySuffix;

    }
    private String setDepartment() {
        System.out.println("New Person: " + firstName + "\nDepartment Codes \n1 for Sales \n2 for Development \n3 for Accounting \n0 for none\n  " + "Enter Department Code:");
        Scanner in = new Scanner(System.in);
        int depChoice = in.nextInt();
        if (depChoice == 1) {
            return "sales";
        } else if (depChoice == 2) {
            return "dev";
        } else if (depChoice == 3) {
            return "acc";
        } else {
            return "";
        }
    }
    private String randomPassword(int length) {
        String passwordSet = "ABCÇDEFGĞHIİJKLMNOÖPQRSTUÜVWXYZ1234567890@_*^#";
        char[] password = new char[length];
        for (int i=0; i<length; i++){
           int rand = (int) (Math.random() * passwordSet.length());
           password[i] = passwordSet.charAt(rand);

        }
        return new String(password);
    }
    public void setMailboxCapacity (int capacity){
        this.mailboxCapacity = capacity;
    }
    public void setAlternateEmail (String alteremail){
        this.alternateEmail = alteremail;
    }
    public void changePassword (String password){
        this.password = password;
    }

    public int getMailboxCapacity() {return mailboxCapacity;
    }
    public String getAlternateEmail() {
        return alternateEmail;
    }
    public String getPassword() { return password;}

    public String showInfo() {
        return "Display Name: " + firstName + " " + lastName +
                "\nCompany Email: " + email +
                "\nMailbox Capacity:" + mailboxCapacity + " mailbox";
    }
}