import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        Bank bank=new Bank();

        while(true){
            System.out.println("====BANK MANAGEMENt SYSTEM====");
            System.out.println("1.Add Customer");
            System.out.println("2.Add Account");
            System.out.println("3.Deposit Money");
            System.out.println("4.withdraw Money");
            System.out.println("5.Check Balance");
            System.out.println("6.Search Accounts");
            System.out.println("7.Display All Transaction");
            System.out.println("8.Transfer Money");
            
            System.out.println("9.Exit");

            System.out.println("Enter the choice:");
            int choice=sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter Customer_Id:");
                    int customerId= sc.nextInt();

                    System.out.println("Enter Name:");
                    sc.nextLine();
                    String name=sc.nextLine();

                    System.out.println("Enter Phone_No:");
                    int phone=sc.nextInt();

                    System.out.println("Enter Address:");
                    sc.nextLine();
                    String address=sc.nextLine();

                    Customer customer= new Customer(customerId, name, phone, address);
                    bank.addCustomer(customer);
     
                    break;
                case 2:
                    System.out.println("Enter Account_No:");
                    int accountNo=sc.nextInt();

                    System.out.println("Enter Customer_Id:");
                    int customer_Id=sc.nextInt();

                    Customer selectCustomer=bank.findCustomer(customer_Id);

                    if(selectCustomer==null){
                        System.out.println("Customer not found.");
                        break;
                    }

                    System.out.println("Enter Initial Balance:");
                    double balance=sc.nextDouble();

                    System.out.println("Enter Account_Type(Savings / Current):");
                    sc.nextLine();
                    String accountType=sc.nextLine();

                    Account newAccount;
                    if(accountType.equalsIgnoreCase("Savings")){
                        System.out.println("Enter the interest rate:");
                        double interestRate=sc.nextDouble();

                        newAccount= new SavingsAccount(accountNo, selectCustomer, 
                            balance, accountType, interestRate);
                        
                    }else if(accountType.equalsIgnoreCase("Current")){
                        newAccount=new CurrentAccount(accountNo, selectCustomer, balance, accountType);
                    }else{
                        System.out.println("Invalid account type.");
                        break;
                    }

                    bank.addAccount(newAccount);
                    System.out.println("Account created successfully.");
                    break;
                case 3:
                    bank.depositMoney();
                    break;
                case 4:
                    bank.withdrawMoney();
                    break;
                case 5:
                    bank.checkBalance();
                    break;
                case 6:
                    Account account=bank.findAccount();
                    if(account!=null){
                        account.displayAccountDetails();
                    }
                    break;
                case 7:
                    boolean back=false;
                    while(!back){
                        System.out.println("A.View All Transactions");
                        System.out.println("B.View Account Transactions");
                        System.out.println("C.Back");
                        System.out.println("Enter the option:");
                        char option=sc.next().charAt(0);

                        switch (option) {
                            case 'A':
                                bank.displayAllTransactions();
                                break;
                            case 'B':
                                System.out.println("Enter Account_no:");
                                int accountno= sc.nextInt();

                                bank.displayAccountTransactions(accountno);
                                break;    
                            case 'C':
                                back=true;
                                break;
                            default:
                                System.out.println("Invalid option.");
                                
                        }
                    }

                    break;

                case 8:
                    bank.transferMoney();
                    break;

                case 9:
                    System.out.println("Thank you for using Bank Managment System.");
                    sc.close();
                    return;
          
                default:
                    System.out.println("Invalid choice.");
                    break;
            }
        }
    }
    
}
