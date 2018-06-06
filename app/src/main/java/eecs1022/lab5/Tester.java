package eecs1022.lab5;

/**
 * Created by user on 2018-02-27.
 */

public class Tester {

    public static void main(String arg[]){
        Bank bank = new Bank();

        String k = bank.checkErrorsCreateAccount("bob", 20);
        String s = bank.checkErrorsCreateAccount("tom", 200);
        String l = bank.checkErrorsCreateAccount("jim", 300);
        String p = bank.checkErrorsCreateAccount("yo", 20);
        String o = bank.checkErrorsCreateAccount("mam", 200);
        String i = bank.checkErrorsCreateAccount("te", 300);
        String j = bank.checkErrorsCreateAccount("jio", 300);


        System.out.println("==========================================");



        String a = bank.bankClients("");
//
//        String q = bank.checkErrorTransfer("tom", "bob", 29);
//        String z = bank.checkErrorTransfer("bob","umom",40000);
//        String b = bank.bankClients("");
        String b = bank.CheckforService("Transfer", "jim", "bob", 9);
        bank.CheckforService("Deposit", "", "jim", 90);
        bank.CheckforService("Withdraw", "jim", "", 20);

        System.out.println("==========================================");
//        System.out.println(k);
//        System.out.println(x);
//        System.out.println(y);

//        System.out.println(q);
        System.out.println(a);
        System.out.println(b);
        String jim = bank.outputStatement("te");

        System.out.println(jim);
    }
}
