public class Transaction {
    int transactionId;
    Account account;
    double amount;
    String type;

    Transaction(int transactionId, Account account,double amount,String type){
        this.transactionId=transactionId;
        this.account=account;
        this.amount=amount;
        this.type=type;

    }

    public Account getAccount(){
        return account;
    }

    public void displayTransaction(){
        System.out.println("Transaction_Id:"+" "+transactionId);
        System.out.println("Account_No:"+" "+account.getAccountNo());
        System.out.println("Amount:"+" "+amount);
        System.out.println("Type:"+" "+type);
    }

    
    
}
