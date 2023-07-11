package inheriandpoly;
import java.util.ArrayList;
import java.util.Date;

public class Account {
    private int id;
    private double balance;
    private Date datecreated;
    private Client client;
//    changed from private to protected
    protected ArrayList<Transaction> transactions;

    //    public Account(){}
    public Account(int id,double balance,Client client){
        this.id=id;
        this.balance=balance;

        this.client=client;

        datecreated =new Date();
        this.transactions = new ArrayList<>();
    }

    public boolean withdraw(double amount){
        if(balance>=amount){
            balance-=amount;
            this.transactions.add(new Transaction('w',amount,this.balance,"Withdrawnn"+amount));
            return true;
        }
        return false;
    }
    public void deposit(double amount){
        balance+=amount;
        this.transactions.add(new Transaction('D',amount,this.balance,"Deposited"+amount));

    }

    public int countTransaction(char type){
        int count=0;
        for (Transaction transaction:transactions) {
            if (transaction.getType()==type)
                count++;
        }
        return count;
    }
    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String toString(){
        return this.id+" "+this.balance+" "+" "+this.datecreated+"\n"+transactions;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Date getDatecreated() {
        return datecreated;
    }
}

class CurrentAccount extends Account{
   private double limitBelowZero;

    public CurrentAccount(int id, double balance, Client client,double limitBelowZero) {
        super(id, balance, client);
        this.limitBelowZero=limitBelowZero;
    }

    @Override
    public boolean withdraw(double amount) {
        if(super.getBalance()-amount<limitBelowZero) return false;

        super.setBalance(super.getBalance()-amount);
        super.transactions.add(new Transaction('w',amount,super.getBalance(),"Withdrwan"+amount));
        return true;
    }

    @Override
    public String toString() {
        return super.toString()+"CurrentAccount{" +
                "limitBelowZero=" + limitBelowZero +
                '}';
    }
}

class SavingAccount extends Account {
    private double annualInterestRate;

    public SavingAccount(int id, double balance, Client client,double annualInterestRate) {
        super(id, balance, client);
        this.annualInterestRate=annualInterestRate;
    }

    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }

    @Override
    public String toString() {
        return super.toString()+"SavingAccount{" +
                "annualInterestRate=" + annualInterestRate +
                '}';
    }
}