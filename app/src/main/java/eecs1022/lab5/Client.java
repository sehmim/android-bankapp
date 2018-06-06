package eecs1022.lab5;

/**
 * Created by user on 2018-02-26.
 */

public class Client {
    String name;
    double amountOfMoney;
    Transaction[] transHistory;
    int numOfTrans;

    Client(){

    }

    Client(String n, double m){
        transHistory = new Transaction[10];
        this.name = n;
        this.amountOfMoney =m;
    }
    public void addTrans(String t, double a){
        transHistory[numOfTrans]= new Transaction(t, a);
        numOfTrans++;
    }
    public Transaction getAllTrans(){
        Transaction result = new Transaction();
        for(int i=0; i< transHistory.length -1; i++){
            result = transHistory[i];
        }
        return result;
    }

    public String displayInfo(){
        String c =String.format("%.2f", this.amountOfMoney);
        String ret = "Client " + this.name + " Has Balance " + c;
        return ret;
    }

}
