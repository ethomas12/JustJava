/**
 * IMPORTANT: Make sure you are using the correct package name.
 * This example uses the package name:
 * package com.example.android.justjava
 * If you get an error when copying this code into Android studio, update it to match teh package name found
 * in the project's AndroidManifest.xml file.
 **/

package com.example.android.justjava;


import android.content.Intent;
import android.net.Uri;
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
    String orderName = "";
    String priceMessage = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    /**
     * This method increments the quantity by 1 when the plus button is clicked.
     */
    public void increment(View view) {
        if (quantity == 100) {
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

        int price = calculatePrice(hasWhippedCream, hasChocolate);

        // Display the order summary on the screen
        String priceMessage = createOrderSummary(price, hasWhippedCream, hasChocolate, orderName);


        Intent javaMail = new Intent(Intent.ACTION_SENDTO);
        javaMail.setData(Uri.parse("mailto:")); // only email apps should handle this
        javaMail.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.order_summary_email_subject, orderName));
        javaMail.putExtra(Intent.EXTRA_TEXT, priceMessage);
        if (javaMail.resolveActivity(getPackageManager()) != null) {
            startActivity(javaMail);
        }

    }

    /**
     * Calculates the price of the order.
     *
     * @return total price for the number of cups of coffee ordered
     */
    private int calculatePrice(boolean addWhippedCream, boolean addChocolate) {

        int basePrice = 5;

//        Add to base price if user wants toppings
        if (addWhippedCream) {

            basePrice += 1;
        }

        if (addChocolate) {

            basePrice += 2;
        }

        return quantity * basePrice;
    }

    /**
     * This method creates the Order Summary
     *
     * @param price           cost of order
     * @param addWhippedCream add whipped cream true or false
     * @param addChocolate    add chocolate true or false
     * @return text summary
     */
    private String createOrderSummary(int price, boolean addWhippedCream, boolean addChocolate, String name) {

        priceMessage = getString(R.string.order_summary_email_subject, orderName);
        priceMessage += "\nAdd whipped cream?  " + addWhippedCream;
        priceMessage += "\nAdd chocolate?  " + addChocolate;
        priceMessage += "\nQuantity: " + quantity;
        priceMessage += "\nTotal = $" + price;
        priceMessage += "\n" + getString(R.string.thank_you);

        return priceMessage;
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int showNumber) {
        TextView quantityTextView = findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + showNumber);
    }

}