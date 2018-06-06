package eecs1022.lab5;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class Lab5Activity extends AppCompatActivity {
    Bank bank;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bank = new Bank();
        setContentView(R.layout.activity_lab5);

    }

    private void displayThis(int id, String newContent){
        View view = findViewById(id);
        TextView textview = (TextView) view;
        textview.setText(newContent);
    }
    private String getInput(int id){
        View view = findViewById(id);
        EditText editText = (EditText) view;
        String input = editText.getText().toString();
        return input;
    }
    private String getSelectedInput(int id){
        View view = findViewById(id);
        Spinner spinner = (Spinner) view;
        String mySpinner = spinner.getSelectedItem().toString();
        return mySpinner;
    }

    public void createAccount(View view){
        // CHECK FOR ANY ERROR AND PUT THE ERROR MEESSAGE IN STRING A, IF NO ERROR RETURN ""
        String a = bank.checkErrorsCreateAccount(getInput(R.id.enterNameClient),
                Double.parseDouble(getInput(R.id.enterBalanceClient)));
        // DISPLAY ERROR IF ANY
        displayThis(R.id.displayOne, a);
        // BANK CLIENT ONLY RUNS IF a SENDS "" MEANING IF IT HAS NO ERRORS
        displayThis(R.id.displayTwo, bank.bankClients(a));
    }

    public void completeTransaction(View view){
        String service = getSelectedInput(R.id.selectService);
        String from = getInput(R.id.fromClient);
        String to = getInput(R.id.toClient);
        double amount = Double.parseDouble(getInput(R.id.amountEnter));
        String a = bank.CheckforService(service, from, to, amount);

        // DISPLAY ON SCREEN

        displayThis(R.id.displayTwo, bank.bankClients(a));
    }

    public void showTransaction(View view){
        String name = bank.outputStatement(getInput(R.id.clientNameforStatement));
        displayThis(R.id.displayTwo, name);
    }


}