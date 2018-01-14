package epam.com.justjava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {
    private int quantity = 0;
    private int price = 5;

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
        CheckBox checkBox = findViewById(R.id.whipped_cream_checkbox);
        displayOrderSummary("Quantity " + quantity + "\n" + "Total: $" + totalPrice + "\n" + "Thank you! " + "\n" + "Add Whipped cream? " + checkBox.isChecked());
    }

    /**
     * This method calculate a total price for coffee
     *
     * @return Total price
     */

    private int calculatePrice() {
        return quantity * price;
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
        quantity = quantity + 1;
        display(quantity);

    }

    /**
     * This method is called when the minus button is clicked
     *
     * @param view
     */

    public void decrement(View view) {
        quantity = (quantity > 0) ? quantity = quantity - 1 : 0;

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
