import java.util.Scanner;
import java.util.*;

interface Bank {
	void Deposit(double amount);
	void Withdraw(double amount) throws InsuffiecientBalanceException;
	double GetBalance();
	double GetAnnualInterest();
}

class SBI implements Bank {
    private int Bankid;
    private String Branch;
    private String Location;
    private double interestRate;

    private double totalAmount;

    public SBI() {
        interestRate = 4.5;
    }

    public void setBankid(int id) {
        Bankid = id;
    }

    public int getBankId() {
        return Bankid;
    }

    public String getBankName() {
        return "SBI";
    }


    public void Deposit(double amount) {
        totalAmount += amount;
    }

    public void Withdraw(double amount) throws InsuffiecientBalanceException {
        if (amount > totalAmount) {
            throw new InsuffiecientBalanceException("Insufficient Balance!!");
        } else {
            totalAmount -= amount;
        }
    } 
    
    public double GetBalance() {
        return totalAmount;
    }

    public double GetAnnualInterest() {
        return interestRate;
    }
}

class HDFC implements Bank {
    private int Bankid;
    private String branch;
    private String location;
    private double interestRate;

    private double totalAmount;

    public HDFC() {
        interestRate = 5.5;
    }

    public void setBankid(int id) {
        Bankid = id;
    }

    public int getBankId() {
        return Bankid;
    }

    public String getBankName() {
        return "HDFC";
    }


    public void Deposit(double amount) {
        totalAmount += amount;
    }

    public void Withdraw(double amount) throws InsuffiecientBalanceException {
        if (amount > totalAmount) {
            throw new InsuffiecientBalanceException("Insufficient Balance!!");
        } else {
            totalAmount -= amount;
        }
    } 
    
    public double GetBalance() {
        return totalAmount;
    }

    public double GetAnnualInterest() {
        return interestRate;
    }
}

class ICICI implements Bank {
    private int Bankid;
    private String branch;
    private String location;
    private double interestRate;

    private double totalAmount;

    public ICICI() {
        interestRate = 6.5;
    }

    public void setBankid(int id) {
        Bankid = id;
    }

    public int getBankId() {
        return Bankid;
    }

    public String getBankName() {
        return "ICICI";
    }


    public void Deposit(double amount) {
        totalAmount += amount;
    }

    public void Withdraw(double amount) throws InsuffiecientBalanceException {
        if (amount > totalAmount) {
            throw new InsuffiecientBalanceException("Insufficient Balance!!");
        } else {
            totalAmount -= amount;
        }
    } 
    
    public double GetBalance() {
        return totalAmount;
    }

    public double GetAnnualInterest() {
        return interestRate;
    }
}


class InsuffiecientBalanceException extends Exception {
    
    String message;
    
    public InsuffiecientBalanceException(String message) {
        super(message);
        this.message = message;
        
    }
    
    public String getMessage() {
        return message;
    }
}


class Person extends SBI {
    private int personID;
    private String name;
    private int accountNumber;
    private String typeOfAccount;
    private String email;
    private String bankName;

    Person(int pId, String pName, int accountNo, String accountType, String pEmail, String pBankName) {
        personID = pId;
        name = pName;
        name = name.toUpperCase();
        accountNumber = accountNo;
        typeOfAccount = accountType;
        email = pEmail;
        bankName = pBankName;
        if (bankName == "SBI") {
            setBankid(1);
        } else if(bankName == "HDFC") {
            setBankid(2);
        }else {
            setBankid(3);
        }
    }

    public int getPersonId() {
        return personID;
    }

    public String getName() {
        return name;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void accountDetails() {
        System.out.println("Person id : " + getPersonId());
        System.out.println("Person name : " + getName());
        System.out.println("Bank id : " + getBankId());
        System.out.println("Bank name : " + getBankName());
        System.out.println("Balance : " + GetBalance());
        System.out.println("Annual Interest : " + GetAnnualInterest());
    }
}

public class Main
{ 
	public static void main(String[] args)
	{

        Scanner scn = new Scanner(System.in);

        Person personWithMaxAmount = null;
        double maxAmount = 0;

        System.out.print("Enter number of records you want to enter : ");
        int n = scn.nextInt();
        

        for (int i=1; i<=n; i++) {
            System.out.println("Enter Person id : ");
            int pId = scn.nextInt();
            System.out.println("Enter Person name : ");
            scn.nextLine();
            String pName = scn.nextLine();
            System.out.println("Enter Person email : ");
            String email = scn.nextLine();
            System.out.println("Enter your type of account : ");
            String typeOfAccount = scn.nextLine();
            System.out.println("Enter Person account number : ");
            int accountNumber = scn.nextInt();
            System.out.println("Enter your bank name : ");
            String bankName = scn.nextLine();   

	 

            Person p = new Person(pId, pName, accountNumber, typeOfAccount, email, bankName);

            int ch;
            do {

                System.out.println("Main Menu\n1.Deposit\n2.Withdraw\n3.Check Balance\n4.Print Account Details\n5.Exit");
                System.out.println("Your choice : "); 
                ch = scn.nextInt();

                switch(ch) {
                    case 1:
                        System.out.println("Enter amount to deposit : ");
                        double amount = scn.nextDouble();
                        p.Deposit(amount);
                        break;

                    case 2:
                        System.out.println("Enter amount to withdraw : ");
                        double money = scn.nextDouble();  
                        try {
                           p.Withdraw(money); 
                        } catch(InsuffiecientBalanceException e) {
                            System.out.println(e.getMessage());
                        }
                        
                        break;

                    case 3:
                        System.out.println("Balance : " + p.GetBalance());
                        break;

                    case 4:
                        p.accountDetails();
                        break;

                    case 5:
                        System.out.println("Good bye...");
                        break;

                }
                
                if (p.GetBalance() > maxAmount) {
                    maxAmount = p.GetBalance();
                    personWithMaxAmount = p;
                }

            } while (ch != 5);            
        }
        
        System.out.println("Person with maximum amount : " + personWithMaxAmount.getName());
    }
}