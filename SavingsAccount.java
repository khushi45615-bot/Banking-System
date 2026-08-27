public class SavingsAccount  extends Account {
    private double interestRate;

    public SavingsAccount(int accountNo, Customer customer,
         double balance, String accountType, double interestRate){
            super(accountNo, customer, balance, accountType);
            this.interestRate=interestRate;

    }

    public double calculateInterest(){
        double interestAmount= (getBalance()*interestRate)/100;
        return interestAmount;
    
    }
    
}
