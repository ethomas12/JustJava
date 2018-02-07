/**
 * IMPORTANT: Make sure you are using the correct package name.
 * This example uses the package name:
 * package com.example.android.justjava
 * If you get an error when copying this code into Android studio, update it to match teh package name found
 * in the project's AndroidManifest.xml file.
 **/

package com.example.android.justjava;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;


/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    int quantity = 0;
    String priceMessage = "";
    String name = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        int price = calculatePrice();
        calculatePrice();
        createOrderSummary(name, price);

        displayMessage(createOrderSummary("Bob Dobbs", price));
    }

    /**
     * Calculates the price of the order.
     *
     * @return total price for the number of cups of coffee ordered
     */
    private int calculatePrice() {
        return quantity * 5;
    }

    /**
     * This method creates the Order Summary
     *
     * @param name name of the user
     * @param  price price of order
     * @return text summary
     */
    private String createOrderSummary (String name, int price) {
        String message = "Name: " + name + "\nQuantity: " + quantity + "\nTotal = $" + price + "\nThank you!";
        return message;
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int showNumber) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + showNumber);
    }

    /**
     * This method increments the quantity by 1 when the plus button is clicked.
     */
    public void increment (View view) {
        quantity = quantity + 1;
        displayQuantity(quantity);
    }

    /**
     * This method decrements the quantity by 1 when the minus button is clicked.
     */
    public void decrement (View view) {
        quantity = quantity - 1;
        displayQuantity(quantity);
    }

    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }

    /**
     * This method decrements the quantity by 1 when the minus button is clicked.
     */
    public void reset (View view) {
        quantity = 0;
        priceMessage = "Total = $" + quantity;
        displayMessage(priceMessage);
        displayQuantity(quantity);
    }
}