/**
 * IMPORTANT: Add your package below. Package name can be found in the project's AndroidManifest.xml file.
 * This is the package name our example uses:
 *
 * package com.example.android.justjava;
 *
 */

package com.example.android.justjava;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {
    int quantity = 2 ;
    int pricePerCup = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    /**
     * This method is called when the plus button is clicked.
     */
    public void increment(View view) {

        quantity = quantity + 1;

        displayQuantity(quantity);
    }
    /**
     * This method is called when the minus button is clicked.
     */
    public void decrement(View view) {

        quantity = quantity - 1;
        displayQuantity(quantity);

    }
    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
       int price = calculatePrice();
        String priceMessage = createOrderSummary(price);
        displayMessage(priceMessage);
        Button button =  findViewById(R.id.order_button);
        button.setVisibility(view.GONE);
    }
/*    creating order summury order method
*  @param price of order
*  return text summary
*  */

    public String createOrderSummary(int price){
        int priceOfOrder = 5 ;
        String priceMessage = "Name: Naveen Kamakoti";
        priceMessage = priceMessage + "\n Quantity" + quantity;
        priceMessage= priceMessage +"\n Total:  £"+(price);
        priceMessage=priceMessage+ "\n Thank you!";
        return priceMessage;
    }


    /*  Calculates the price of the order.

      @param quantity is the number of cups of coffee ordered
      retun price*/

    private int calculatePrice() {
        int price = quantity * pricePerCup;
        return price;
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int numberOfCoffees) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + numberOfCoffees);
    }
      /*  *//**
     * This method displays the given price on the screen.
     *//*
    private void displayPrice(int number) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));

    }*/

    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);

    }
}