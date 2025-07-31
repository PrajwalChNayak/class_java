import myclass.InsufficentFundsException;

public class BankAccount {
    public double balance;
    public String accountNumber;
    
    public BankAccount(String accountNumber,double initBalance){
        this.balance=initBalance;
        this.accountNumber=accountNumber;

    }

    public void withdraw(double amount) throws InsufficentFundsException{
        if(amount>balance){
            throw new InsufficentFundsException("Can't withdraw->"+amount+"From Account"+accountNumber);   
        
        }
        balance-=amount;
        System.out.println("Withdraw Successful");
    }
    public double getBalance(){
        return balance;
    }

    public static void main(String[] agrs){
         BankAccount account = new BankAccount("1234",100.0);
        try{
           account.withdraw(50.0);
           account.withdraw(70.0);
            
        }catch(InsufficentFundsException e){
            System.out.println("Failed"+e.getMessage());
            System.out.println("Current Balance"+e.getBalance());
            System.out.println("You need->"+e.getShortfall()+" More");
        }
    }

}