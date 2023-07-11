package inheriandpoly;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

//        Account testAccount = new Account(1122,20000,4.5);
//        if (testAccount.withdraw(2500)){
//            System.out.println("Withdraw Successful");
//        }
//        else{
//            System.out.println("Withdraw not Successful");
//        }
//        testAccount.deposit(3000);
//        System.out.println(testAccount.getId()+" "
//                        +testAccount.getBalance()+" "+
//                        testAccount.getAnnualInterestRate()+" "+
//                testAccount.getDatecreated()
//                );
//        Client[] clients=new Client[2];
//        clients[0]=new Client(100,"Joe","7843222053");
//        clients[1]=new Client(110,"Allen","8943225687");
//
//        clients[0].addAccount(new Account(1132,30000,4.5));
//        clients[0].addAccount(new Account(1142,34000,4.5));
//
//        clients[1].addAccount(new Account(1152,50000,4.5));
//        clients[1].addAccount(new Account(1162,40000,4.5));
//        clients[1].addAccount(new Account(1172,55000,4.5));
//
//        System.out.println(clients[0].toString());
//        System.out.println(clients[1].toString());

//        ArrayList<Account> accounts=new ArrayList<>();
        Account[]  accounts=new Account[2];
        Client client=new Client(1,"Sarah","76548883346");
//
//        accounts.add(new Account(1,12000,2,client));
//        accounts.add(new Account(2,20000,2.4,client));
//
//        accounts.get(0).withdraw(2000);
//        accounts.get(0).withdraw(4500);
//        accounts.get(1).deposit(6000);
//        accounts.get(1).deposit(7000);
//
//        System.out.println(accounts.get(0));
//
//        for (Account account:accounts){
//            System.out.println("Account " +account.getId()+':');
//            System.out.println("w:"+account.countTransaction('w'));
//            System.out.println("D:"+account.countTransaction('D'));
//        }

        accounts[0]=new SavingAccount(1,20000,client,1.5);
        accounts[0].withdraw(4000);
        accounts[0].deposit(3000);

        accounts[1]=new CurrentAccount(1,10000,client,-1000);
        accounts[1].withdraw(10000);
        accounts[1].withdraw(1000);
        accounts[1].withdraw(100);
//        100 withdraw wont take place as limit already reached
        accounts[1].deposit(900);
        accounts[1].deposit(100);
        System.out.println(Arrays.toString(accounts));

    }
}
