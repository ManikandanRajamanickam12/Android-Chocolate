/**
 * IMPORTANT: Make sure you are using the correct package name.
 * This example uses the package name:
 * package com.example.android.justjava
 * If you get an error when copying this code into Android studio, update it to match teh package name found
 * in the project's AndroidManifest.xml file.
 **/

package com.example.android.chocolate;



import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;


import com.example.android.chocolate.R;

import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {
    int quantity=2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        CheckBox whippedcreamCheckbox=(CheckBox)findViewById(R.id.whipped_cream_checkbox);
        boolean haswhippedcream=whippedcreamCheckbox.isChecked();
        CheckBox chocolateCheckBox = (CheckBox) findViewById(R.id.chocolate_checkbox);
        boolean hasChocolate = chocolateCheckBox.isChecked();

        int price =calculateprice();
        String priceMessage= ordersummary(price,haswhippedcream,hasChocolate);
        displayMessage(priceMessage);

    }
    public String ordersummary(int price,boolean addwhippedcream,boolean addchocolate){
        String pricemessage="Name:Manikandan";
        pricemessage+="\nadd whippedCream:"+ addwhippedcream;
       pricemessage+="\nadd chocolate:"+addchocolate;
        pricemessage+="\nQuantity:"+quantity;
        pricemessage+="\nPrice:"+price;
        pricemessage+="\nThank You";
        return pricemessage;
    }

    public int calculateprice()
    {
        int price=quantity*5;
        return price;

    }
    public void increment(View view){

        quantity=1+quantity;
        display(quantity);
    }
    public void decrement(View view){

        quantity=quantity-1;
        display(quantity);
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }


    private void displayMessage(String message) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }
}