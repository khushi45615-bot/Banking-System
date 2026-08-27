public class Account{
    private int accountNo;
    private Customer customer;
    private double balance;
    private String accountType;

    public Account(int accountNo,Customer customer, double balance,String accountType){
        this.accountNo=accountNo;
        this.customer=customer;
        this.balance=balance;
        this.accountType=accountType;
    }

    public int getAccountNo(){
        return accountNo;
    }

    public Customer getCustomer(){
        return customer;
    }

    public double getBalance(){
        return balance;
    }

    public String getAccountType(){
        return accountType;
    }

    public void deposit(double amount){
        if(amount>0){
            balance+=amount;
            System.out.println("Amount deposited successfully.");
        }else{
            System.out.println("Invalid amount.");
        }      
    }

    public boolean withdraw(double amount){
        if(amount>0 && amount<=balance){
            balance=balance-amount;
            System.out.println("Amount withdrawn successfully.");
            return true;

        }else{
            System.out.println("Invalid amount.");
            return false;
        }
    }

    public void displayAccountDetails(){
        System.out.println("Account_No:"+" "+accountNo);
        System.out.println(customer);
        System.out.println("Balance:"+" "+balance);
        System.out.println("Account_Type:"+" "+accountType);
    }


     
    
}