/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculatorapp;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

class Test
{
    public int cal(int num1, int num2, String operator){
        switch(operator)
        {
            case "+":
               return num1 + num2; 
            case "-":
               return num1 - num2; 
            case "*":
               return num1 * num2; 
            case "/":
                if (num2 == 0)
                    return 0;
               return num1 / num2; 
               
            default:
                break;
        }
        return 0;
    }
}
public class FXMLController implements Initializable {

    @FXML
    private Label label;
    private int num1 = 0;
    private String operator = "";
    private boolean flag = true;
    Test t1  = new Test();
    
   
    @FXML
    public void numbers(ActionEvent e){
        if (flag){
           label.setText("");
           flag = false;
        }
        
        String val = ((Button)e.getSource()).getText();
        label.setText(label.getText() + val);
    }
    
    @FXML
    public void operators(ActionEvent e){
       String val = ((Button)e.getSource()).getText();
       
       if(!val.equals("=")){
           
           if(!operator.isEmpty())
               return;
           operator = val;
           num1 = Integer.parseInt(label.getText());
           label.setText("");
       }
       else{
           if(operator.isEmpty()){
               return;
               
           }
           int num2 = Integer.parseInt(label.getText());
           int output = t1.cal(num1, num2, operator);
           label.setText(String.valueOf(output));
           operator = "";
           flag = true;
           
       }
    }
   
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
