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
import android.widget.Toast;


/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    int quantity = 2;
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
        //        Find the user's name
        EditText nameInputView = findViewById(R.id.name_input);
        orderName = nameInputView.getText().toString();

        //        Whipped Cream true  / false
        CheckBox whippedCreamCheckbox = findViewById(R.id.whipped_cream_checkbox);
        boolean hasWhippedCream = whippedCreamCheckbox.isChecked();

        //        Chocolate true  / false
        CheckBox chocolateCheckbox = findViewById(R.id.chocolate_checkbox);
        boolean hasChocolate = chocolateCheckbox.isChecked();

        //        Cat shit true / false
        CheckBox catShitCheckbox = findViewById(R.id.cat_shit_checkbox);
        boolean hasCatShit = catShitCheckbox.isChecked();

        //        Butmeg true  / false
        CheckBox butmegCheckbox = findViewById(R.id.butmeg_checkbox);
        boolean hasButmeg = butmegCheckbox.isChecked();


        int price = calculatePrice(hasWhippedCream, hasChocolate, hasCatShit, hasButmeg);

        String priceMessage = createOrderSummary(price, hasWhippedCream, hasChocolate, hasCatShit, hasButmeg, orderName);

        displayMessage(priceMessage);
    }

    /**
     * Calculates the price of the order.
     *
     * @return total price for the number of cups of coffee ordered
     */
    private int calculatePrice(boolean addWhippedCream, boolean addChocolate, boolean addCatShit, boolean addButmeg) {
        int basePrice = 5;

//        Add $$ if user wants topping
        if (addWhippedCream) {

            basePrice += 1;
        }

        if (addChocolate) {

            basePrice += 2;
        }

        if (addCatShit) {

            basePrice += 3;
        }

        if (addButmeg) {

            basePrice += 4;
        }

        return quantity * basePrice;
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

        if (quantity >= 1) {

            String priceMessage = "Name: " + name;
            priceMessage += "\nAdd whipped cream?  " + addWhippedCream;
            priceMessage += "\nAdd chocolate?  " + addChocolate;
            priceMessage += "\nAdd cat shit?  " + addCatShit;
            priceMessage += "\nAdd butmeg?  " + addButmeg;
            priceMessage += "\nQuantity: " + quantity;
            priceMessage += "\nTotal = $" + price;
            priceMessage += "\nThank you!";


            Toast.makeText(getApplicationContext(), "Motha Fuckin Coffee",
                    Toast.LENGTH_LONG).show();

            return priceMessage;
        }

        return priceMessage = "Whoa, " + orderName + "! \nWhatcha gonna do with all that coffee?";
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int showNumber) {
        TextView quantityTextView = findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + showNumber);
    }

    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView orderSummaryTextView = findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }

    /**
     * This method increments the quantity by 1 when the plus button is clicked.
     */
    public void increment(View view) {
        if (quantity == 10) {
            Toast.makeText(getApplicationContext(), "too much coffee, man",
                    Toast.LENGTH_SHORT).show();
            return;
        }
        quantity = quantity + 1;
        displayQuantity(quantity);
    }

    /**
     * This method decrements the quantity by 1 when the minus button is clicked.
     */
    public void decrement(View view) {
        if (quantity == 1) {
            Toast.makeText(getApplicationContext(), "that's negative coffee, man",
                    Toast.LENGTH_SHORT).show();
            return;
        }
        quantity = quantity - 1;
        displayQuantity(quantity);
    }

    /**
     * This method decrements the quantity by 1 when the minus button is clicked.
     */
    public void reset(View view) {
        quantity = 0;
        priceMessage = "$" + quantity;
        displayMessage(priceMessage);
        displayQuantity(quantity);
    }

}