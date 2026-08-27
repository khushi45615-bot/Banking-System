import java.util.ArrayList;
import java.util.Scanner;

public class Bank {
    private int nextTransactionId=101;

    private ArrayList<Customer>customers=new ArrayList<>();
    private ArrayList<Account>accounts=new ArrayList<>();
    private ArrayList<Transaction>transactions=new ArrayList<>();
    Scanner sc= new Scanner(System.in);

    public void addCustomer(Customer customer){
        customers.add(customer);

    }

    public void addAccount(Account account){
        accounts.add(account);
    }

    public void addTransaction(Transaction transaction){
        transactions.add(transaction);
    }

    public Account findAccount(){
        System.out.println("Enter the account_No:");
        int account_No=sc.nextInt();

        for(Account account: accounts){
            if(account_No==account.getAccountNo()){
                System.out.println("Account is found.");
                return account;
            }
        }
        System.out.println("Account is not found.");
        return null;
    }

    public Customer findCustomer(int customerId){


        for(Customer customer:customers){
            if(customerId==customer.getCustomerId()){
                return customer;
            }
        }
        return null;
    }

    public void depositMoney(){
        Account account= findAccount();
        if(account!=null){
            System.out.println("Enter amount to deposit:");
            double amount= sc.nextDouble();

            account.deposit(amount);
            Transaction transaction=new Transaction(nextTransactionId++
                , account, amount, "Deposit");
                addTransaction(transaction);
            
        }
    }

    public void withdrawMoney(){
        Account account=findAccount();
        if(account!=null){
            System.out.println("Enter amount to withdraw: ");
            double amount=sc.nextDouble();

            if(account.withdraw(amount)){
                Transaction transaction=new Transaction(nextTransactionId++, 
                    account, amount, "Withdraw");
                    addTransaction(transaction);
               

            };
           
        }
    }

    public void checkBalance(){
        Account account= findAccount();
        if(account!=null){
            account.displayAccountDetails();
        }

    }

    public void displayAllTransactions(){
        if(transactions.isEmpty()){
            System.out.println("No transaction found.");
            return;
        }
        for(Transaction transaction:transactions){
            transaction.displayTransaction();
            System.out.println("-------------");
        }
    }

    public void displayAccountTransactions(int accountNo){
        boolean found= false;
        for(Transaction transaction:transactions){
            if(transaction.getAccount().getAccountNo()==accountNo){
                transaction.displayTransaction();
                System.out.println("-------------");
                found=true;
            }
        }
        if(!found){
            System.out.println("No Transactions Found For This Account.");
        }

    }

    public void transferMoney(){
        System.out.println("Enter Sender Account_No:");
        int senderNo=sc.nextInt();

        Account sender=null;

        for(Account account:accounts){
            if(account.getAccountNo()==senderNo){
                sender=account;
                break;
            }
        }

        if(sender==null){
            System.out.println("Sender Account is not found.");
            return;
        }

        System.out.println("Enter Receiver Account_No:");
        int receiverNo=sc.nextInt();

        Account receiver=null;
        for(Account account:accounts){
            if(account.getAccountNo()==receiverNo){
                receiver=account;
                break;
            }
        }
        if(receiver==null){
            System.out.println("Reciever Account is not found.");
            return;
        }

        System.out.println("Enter amount to tranfer:");
        double tranferAmount=sc.nextDouble();

        if(sender.withdraw(tranferAmount)){
            receiver.deposit(tranferAmount);
        }

        Transaction senderTransaction= new Transaction(nextTransactionId++, sender,
             tranferAmount, "Transfer");

        Transaction recieveTransaction= new Transaction(nextTransactionId++, receiver,  
            tranferAmount, "Transfer");
            
        addTransaction(senderTransaction);
        addTransaction(recieveTransaction);
        
        System.out.println("Money Transferred Successfully.");

    }

}
