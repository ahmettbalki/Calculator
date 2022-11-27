 package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

 public class MainActivity extends AppCompatActivity {

     TextView result;
     EditText newNumber;
     TextView operandDisplay;
     String pandingOperation = "+";
     Double operand1 = null;
     Double operand2 = null;

     @Override
     protected void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_main);

         result = (TextView) findViewById(R.id.text_result);
         newNumber = (EditText) findViewById(R.id.tex_number);
         operandDisplay = (TextView) findViewById((R.id.text_s));

         Button button_0 = (Button) findViewById(R.id.button_0);
         Button button_1 = (Button) findViewById(R.id.button_1);
         Button button_2 = (Button) findViewById(R.id.button_2);
         Button button_3 = (Button) findViewById(R.id.button_3);
         Button button_4 = (Button) findViewById(R.id.button_4);
         Button button_5 = (Button) findViewById(R.id.button_5);
         Button button_6 = (Button) findViewById(R.id.button_6);
         Button button_7 = (Button) findViewById(R.id.button_7);
         Button button_8 = (Button) findViewById(R.id.button_8);
         Button button_9 = (Button) findViewById(R.id.button_9);
         Button button_dot = (Button) findViewById(R.id.button_dot);
         Button button_equal = (Button) findViewById(R.id.button_equal);
         Button button_minus = (Button) findViewById(R.id.button_minus);
         Button button_multi = (Button) findViewById(R.id.button_multi);
         Button button_div = (Button) findViewById(R.id.button_div);
         Button button_plus = (Button) findViewById(R.id.button_plus);

         View.OnClickListener listener = new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 Button button = (Button) view;
                 newNumber.append((button.getText().toString()));
             }
         };
         button_0.setOnClickListener(listener);
         button_1.setOnClickListener(listener);
         button_2.setOnClickListener(listener);
         button_3.setOnClickListener(listener);
         button_4.setOnClickListener(listener);
         button_5.setOnClickListener(listener);
         button_6.setOnClickListener(listener);
         button_7.setOnClickListener(listener);
         button_8.setOnClickListener(listener);
         button_9.setOnClickListener(listener);
         button_dot.setOnClickListener(listener);


         View.OnClickListener operationlistener = new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 Button button = (Button) view;
                 String op = button.getText().toString();
                 String value = newNumber.getText().toString();
                 try{
                     Double dValue = Double.valueOf(value);
                     Operation(dValue, op);
                 }catch(NumberFormatException e){
                     Log.d("--------","number error");
                     newNumber.setText("");
                 }
                 pandingOperation = op;
                 operandDisplay.setText(pandingOperation);

             }
         };
         button_equal.setOnClickListener(operationlistener);
         button_minus.setOnClickListener(operationlistener);
         button_multi.setOnClickListener(operationlistener);
         button_div.setOnClickListener(operationlistener);
         button_plus.setOnClickListener(operationlistener);
     }
     private void Operation(Double value, String op){
         if(null == operand1){
             operand1 = value;
             result.setText(operand1.toString());
             newNumber.setText("");
             operandDisplay.setText(op);
         }else{
             operand2 = value;
             if(pandingOperation.equals("=")){
                 pandingOperation = op;
             }
             switch(pandingOperation){
                 case "=":
                     operand1 = operand2;
                     break;
                 case "/":
                     if(operand2 == 0){
                         operand1 = 0.0;
                     }else{
                         operand1 /= operand2;
                     }
                     break;
                 case "+":
                     operand1 += operand2;
                     break;
                 case "-":
                     operand1 -= operand2;
                     break;
                 case "*":
                     operand1 *= operand2;
             }
         }
         result.setText(operand1.toString());
         newNumber.setText("");
         operandDisplay.setText(op);
     }
 }





