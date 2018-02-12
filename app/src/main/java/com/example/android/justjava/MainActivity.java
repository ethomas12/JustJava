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
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;


/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    int quantity = 0;
    String priceMessage = "";
    String orderName = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        CheckBox whippedCreamCheckbox = findViewById(R.id.whipped_cream_checkbox);
        boolean hasWhippedCream = whippedCreamCheckbox.isChecked();

        CheckBox chocolateCheckbox = findViewById(R.id.chocolate_checkbox);
        boolean hasChocolate = chocolateCheckbox.isChecked();

        CheckBox catShitCheckbox = findViewById(R.id.cat_shit_checkbox);
        boolean hasCatShit = catShitCheckbox.isChecked();

        CheckBox butmegCheckbox = findViewById(R.id.butmeg_checkbox);
        boolean hasButmeg = butmegCheckbox.isChecked();

        EditText nameInputView = findViewById(R.id.name_input);
        String orderName = nameInputView.getText().toString();


        int price = calculatePrice();
        String priceMessage = createOrderSummary(price, hasWhippedCream, hasChocolate, hasCatShit, hasButmeg, orderName);

        displayMessage(priceMessage);
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
     * @param price           cost of order
     * @param addWhippedCream add whipped cream true or false
     * @param addChocolate    add chocolate true or false
     * @param addCatShit      add cat shit true or false
     * @param addButmeg       add butmeg tru or false
     * @return text summary
     */
    private String createOrderSummary(int price, boolean addWhippedCream, boolean addChocolate, boolean addCatShit, boolean addButmeg, String name) {
        String priceMessage = "Name: " + name;
        priceMessage += "\nAdd whipped cream?  " + addWhippedCream;
        priceMessage += "\nAdd chocolate?  " + addChocolate;
        priceMessage += "\nAdd cat shit?  " + addCatShit;
        priceMessage += "\nAdd butmeg?  " + addButmeg;
        priceMessage += "\nQuantity: " + quantity;
        priceMessage += "\nTotal = $" + price;
        priceMessage += "\nThank you!";
        String message2 = "Motha Fuckin Coffee";
        displayMotha(message2);
        return priceMessage;

    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int showNumber) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + showNumber);
    }

    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }

    /**
     * This method increments the quantity by 1 when the plus button is clicked.
     */
    public void increment(View view) {
        quantity = quantity + 1;
        displayQuantity(quantity);
    }

    /**
     * This method decrements the quantity by 1 when the minus button is clicked.
     */
    public void decrement(View view) {
        quantity = quantity - 1;
        displayQuantity(quantity);
    }

    /**
     * This method displays the given text on the screen.
     */
    private void displayMotha(String message2) {
        TextView yissView = (TextView) findViewById(R.id.motha_text_view);
        yissView.setText(message2);
    }

    /**
     * This method decrements the quantity by 1 when the minus button is clicked.
     */
    public void reset(View view) {
        quantity = 0;
        priceMessage = "$" + quantity;
        displayMessage(priceMessage);
        displayQuantity(quantity);
        displayMotha("");
    }

}