package com.example.calculator10;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


   Button button0, button1, button2, button3, button4, button5, button6,
           button7, button8, button9, buttonAdd, buttonSub,
           buttonMul, buttonC, buttonEqual;

   // will be all the numbers (buttons)

   EditText EditText; // the only txt field

    float mValueOne, mValueTwo; // the values for the number

    boolean Addition, mSubtract, Multiplication;

    final String[] message = {""}; //result message

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button0 = (Button) findViewById(R.id.button0);
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        button5 = (Button) findViewById(R.id.button5);
        button6 = (Button) findViewById(R.id.button6);
        button7 = (Button) findViewById(R.id.button7);
        button8 = (Button) findViewById(R.id.button8);
        button9 = (Button) findViewById(R.id.button9);
        buttonAdd = (Button) findViewById(R.id.buttonadd);
        buttonSub = (Button) findViewById(R.id.buttonsub);
        buttonMul = (Button) findViewById(R.id.buttonmul);
        buttonC = (Button) findViewById(R.id.buttonC);
        buttonEqual = (Button) findViewById(R.id.buttoneql);
        EditText = (EditText) findViewById(R.id.edt1);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText.setText(EditText.getText() + "1");
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText.setText(EditText.getText() + "2");
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText.setText(EditText.getText() + "3");
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText.setText(EditText.getText() + "4");
            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText.setText(EditText.getText() + "5");

            }
        });
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText.setText(EditText.getText() + "6");

            }
        });
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText.setText(EditText.getText() + "7");

            }
        });
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText.setText(EditText.getText() + "8");

            }
        });
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText.setText(EditText.getText() + "9");
            }
        });

        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText.setText(EditText.getText() + "0");
            }
        });

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try{

                    if (EditText == null) {
                    EditText.setText("");
                } else {
                    mValueOne = Float.parseFloat(EditText.getText() + "");
                    Addition = true;
                    EditText.setText(null);
                }

                }catch (Exception e){
                    Toast.makeText(getApplicationContext(),"Validar la data ingresada",Toast.LENGTH_SHORT).show();
//tracking null errors
                }
            }
        });

        buttonSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try{
                mValueOne = Float.parseFloat(EditText.getText() + "");
                mSubtract = true;
                EditText.setText(null);
            }catch (Exception e){
                Toast.makeText(getApplicationContext(),"Validar la data ingresada",Toast.LENGTH_SHORT).show();
//tracking null errors
            }
            }
        });


        buttonMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                mValueOne = Float.parseFloat(EditText.getText() + "");
                Multiplication = true;
                EditText.setText(null);
            }catch (Exception e){
                Toast.makeText(getApplicationContext(),"Validar la data ingresada",Toast.LENGTH_SHORT).show();
                //tracking null errors
            }
            }
        });

        buttonEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    mValueTwo = Float.parseFloat(EditText.getText() + "");

                    if (Addition == true) {

                        EditText.setText(mValueOne + mValueTwo + "");
                        Addition = false;

                        Toast.makeText(getApplicationContext(), "exito de suma", Toast.LENGTH_SHORT).show();

                        message[0] = String.format(EditText.getText().toString()); // sending data result
                        goSecondActivity();//method open the other activity

                    }


                    if (mSubtract == true) {

                        EditText.setText(mValueOne - mValueTwo + "");
                        mSubtract = false;

                        Toast.makeText(getApplicationContext(), "exito de resta", Toast.LENGTH_SHORT).show();
                        message[0] = String.format(EditText.getText().toString()); // sending data result
                        goSecondActivity();//method open the other activity

                    }

                    if (Multiplication == true) {


                        EditText.setText(mValueOne * mValueTwo + "");
                        Multiplication = false;
                        Toast.makeText(getApplicationContext(), "exito de multi", Toast.LENGTH_SHORT).show();
                        message[0] = String.format(EditText.getText().toString()); // sending data result
                        goSecondActivity();//method open the other activity

                    }
                    //tracking null errors
                }catch (Exception e){
                    Toast.makeText(getApplicationContext(),"Validar la data ingresada",Toast.LENGTH_SHORT).show();
                }

            }
        });

        buttonC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText.setText(""); //set as empty the txtEdit
            }
        });

    }

    private void goSecondActivity() { //open a new activity method

        Intent intent = new Intent(this,Main2Activity.class);
        intent.putExtra("message", message[0]);
        startActivity(intent);
    }
}
