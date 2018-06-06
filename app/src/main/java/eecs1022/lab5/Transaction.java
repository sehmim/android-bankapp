package eecs1022.lab5;

/**
 * Created by user on 2018-02-26.
 */

public class Transaction {
    String type;
    double amount;

    Transaction(){

    }

    Transaction(String t, double a){
        this.type = t;
        this.amount = a;
    }
}
