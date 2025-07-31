package util.stream;

public class InsufficentFundsException extends Exception {
    public double balance;
    public double requestAmount;
    
    public InsufficentFundsException(String message){
        super(message);
    }
    public InsufficentFundsException(String message,double balance, double requestAmount){
        super(message);
        this.balance=balance;
        this.requestAmount=requestAmount;
    }
    public InsufficentFundsException(String message , Throwable cause){
        super(message,cause);
    }

    public double getBalance(){
        return balance;
    }
    public double requestAmount(){
        return requestAmount;
    }
    public double getShortfall(){
        return requestAmount-balance;
    }
}