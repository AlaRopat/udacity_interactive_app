package epam.com.justjava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {
    private int quantity = 0;
    private static int price = 5;
    private static final int CHOCOLATE_PRICE = 2;
    private static final int WHIPPED_CREAM_PRICE = 1;
    private static final int MIN_NUMBER_OF_COFFEE = 0;
    private static final int MAX_NUMBER_OF_COFFEE = 100;
    private static final String ORDER_SUMMARY_MESSAGE = "Name: %s\nQuantity %s\nTotal: $ %s\nAdd Whipped cream? %s\nAdd Chocolate? %s\nThank you! ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked
     */
    public void submitOrder(View view) {
        display(quantity);
        int totalPrice = calculatePrice();
        CheckBox whippedCream = findViewById(R.id.whipped_cream_checkbox);
        CheckBox chocolate = findViewById(R.id.chocolate_checkbox);
        EditText nameInput = findViewById(R.id.name_description_view);
        displayOrderSummary(String.format(ORDER_SUMMARY_MESSAGE, nameInput.getText(), quantity, totalPrice, whippedCream.isChecked(), chocolate.isChecked()));
    }

    /**
     * This method calculate a total price for coffee
     *
     * @return Total price
     */

    private int calculatePrice() {
        CheckBox whippedCream = findViewById(R.id.whipped_cream_checkbox);
        CheckBox chocolate = findViewById(R.id.chocolate_checkbox);
        int totalPrice = quantity * price;
        if (whippedCream.isChecked()) {
            totalPrice = totalPrice + WHIPPED_CREAM_PRICE;
        }
        if (chocolate.isChecked()) {
            totalPrice = totalPrice + CHOCOLATE_PRICE;
        }
        return totalPrice;
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }


    /**
     * This method is called when the plus button is clicked
     *
     * @param view
     */
    public void increment(View view) {
        quantity = (quantity < MAX_NUMBER_OF_COFFEE) ? quantity + 1 : MAX_NUMBER_OF_COFFEE;
        display(quantity);

    }

    /**
     * This method is called when the minus button is clicked
     *
     * @param view
     */

    public void decrement(View view) {
        quantity = (quantity > MIN_NUMBER_OF_COFFEE) ? quantity - 1 : MIN_NUMBER_OF_COFFEE;

        display(quantity);
    }

    /**
     * This method displays the given text on the screen.
     */
    private void displayOrderSummary(String message) {
        TextView orderSummaryTextView = findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }


}
