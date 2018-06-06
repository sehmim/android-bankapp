package eecs1022.lab5;

import java.util.Arrays;

/**
 * Created by user on 2018-02-26.
 */

public class Bank {
    Client[] clients;
    int numOfClients;
    final int MAX_NUM_CLIENTS = 6;

    Bank(){
        clients =new Client[6];
    }


    void addClient(String name, double money){
        clients[numOfClients] = new Client(name, money);
        numOfClients++;
    }

    void depositMoney(Client x, double amount){
        x.amountOfMoney += amount;
        x.addTrans("Deposit", amount);
    }
    void withdrawMoney(Client x, double amount){
        x.amountOfMoney -= amount;
        x.addTrans("Withdraw", amount);
    }
    void transferMoney(Client from,Client to, double amount){
        withdrawMoney(from, amount);
        depositMoney(to,amount);
    }

    public String checkErrorsCreateAccount(String name, double balance){
        String resuult ="";
        for(int i =0; i<numOfClients; i++){
            if (numOfClients >= (MAX_NUM_CLIENTS)){
                resuult ="";
                resuult += "Error: Maximum Number of Clients Reached";
            }
            else if (clients[i].name.equals(name)){
                resuult = "";
                resuult += "Error: Client " +name+ " already exists";
            }
        }

        if (!(resuult.equals("Error: Client " +name+ " already exists")) && balance <= 0){
            resuult = "";
            resuult += "Error: Non-Positive Initial Balance";
        }
        else if(resuult.equals((""))) {
            addClient(name, balance);
        }
        return resuult;
    }

    public String bankClients(String errors){
        String result ="";
        if (errors.equals("")) {
            result = "Updated Balance of Clients \n";

            for (int i = 0; i < numOfClients; i++) {
                result += clients[i].name + " : " + (clients[i].amountOfMoney) + "\n";
            }
        }

        return result;
    }

//    public void addingAccountAfterErrorCheck(String name, double balance, Client from, Client to){
//        if (checkErrorsCreateAccount(name, balance).equals("")){
//            addClient(name, balance);
//        }
//        else if (checkErrorsDeposit(name, balance).equals("")){
//            depositMoney(to, balance);
//        }
//        else if (checkErrorWithdraw(name, balance).equals("")){
//            withdrawMoney(from, balance);
//        }
//    }




    public String checkErrorsDeposit(String name, double depositAmount){
        String resuult ="";
        for(int i =0; i<numOfClients; i++){
            if ((clients[i].name.equals(name))){
                if (depositAmount > 0){
                    depositMoney(clients[i], depositAmount);
                    return bankClients("");
                }else {
                    return "Error: Non-Positive Initial Balance";
                }
            }
            else if (!(clients[i].name.equals(name))){
                resuult = "Error: Client " +name+ " does not exists";
            }

            }
        return resuult;
    }





    public String checkErrorWithdraw(String name, double withdrawAmount){
        String resuult ="";
        for(int i =0; i<numOfClients; i++){
            if ((clients[i].name.equals(name))){
                if (withdrawAmount > 0){
                    for (int j =0; i<numOfClients; j++){
                        if ((clients[j].name.equals(name)) && (clients[j].amountOfMoney < withdrawAmount)){
                            resuult = "";
                            return "Error: Amount too large to withdraw.";
                        }
                        else {
                            withdrawMoney(clients[i], withdrawAmount);
                            return bankClients("");
                        }
                    }
                }
                else {
                    return "Error: Non-Positive Initial Balance";
                }
            }

            else if (!(clients[i].name.equals(name))){
                resuult = "Error: Client " +name+ " does not exists";
            }

        }


        return resuult;

    }

    public String checkErrorTransfer(String from, String to, double amount){
        String resuult ="";
        for(int x=0; x < numOfClients; x++){
            if ((clients[x].name.equals(from))){
                for (int q=0; q<numOfClients; q++){
                    if (clients[q].name.equals((to))){
                        if (amount <= 0){
                            return  "Error: Non-Positive Initial Balance";
                        }
                        else if(clients[x].amountOfMoney < amount){
                            return "Error: Amount too large to transfer";
                        }
                        else {
                            transferMoney(clients[x], clients[q], amount);
                            return bankClients("");
                        }
                    }
                    else {
                        resuult = "Error: To-Client " + to  + " does not exist";
                    }
                }
            }
            else if(!(clients[x].name.equals(from))) {
                resuult =  "Error: From-Client " + from + " does not exist";
            }
        }
        return resuult;
}


public String CheckforService(String service, String from, String to, double amount){
        String result = "";
        if (service.equals(("Deposit"))){
            return checkErrorsDeposit(to, amount);
        }
        else if(service.equals(("Withdraw"))){
            return checkErrorWithdraw(from, amount);
        }
        else if(service.equals("Transfer")){
            return checkErrorTransfer(from, to, amount);
        }
    return result;
}

public String outputStatement(String name){
    String result = "";
    boolean condition = true;
    for (int i =0; i < numOfClients; i++){
        if (clients[i].name.equals(name)){
            result = "Statement of Client " + name + " Current Balance " + clients[i].amountOfMoney + "\n";
            for (int j =0; j < clients[i].numOfTrans; j++){
                result += clients[i].transHistory[j].type + " : " + clients[i].transHistory[j].amount + "\n";
                condition = false;
            }
        }
        else if(!(clients[i].name.equals(name)) && condition) {
            result =   "Error: From-Client " + name + " does not exist";
        }

    }


    return result;
}






}
