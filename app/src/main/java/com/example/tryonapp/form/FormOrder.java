package com.example.tryonapp.form;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tryonapp.R;
import com.google.android.material.textfield.TextInputLayout;
import com.example.tryonapp.form.dialog.OrderSuccess;
import com.example.tryonapp.products.ProductCatalog;

public class FormOrder extends AppCompatActivity {

    //Bundle
    public static String txt_items, txt_price, txt_quantity, txt_total;

    private TextInputLayout txt_firstname, txt_middlename, txt_lastname, txt_address, txt_email, txt_phone;
    private TextView prod_name, order_items, order_total, prod_quantity, form_total;
    private Button place_order;
    private ImageButton cart, buttonBack;
    private ImageView title_bar;

    private String msg_quantity = "";
    private String getFirstname, getMiddlename, getLastname, getAddress, getEmail, getPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_order);

        //hide on-screen bottom navigation
//        getWindow().getDecorView().setSystemUiVisibility(
//                View.SYSTEM_UI_FLAG_HIDE_NAVIGATION|
//                        View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);

        prod_name = (TextView) findViewById(R.id.order_productName);
        order_items = (TextView) findViewById(R.id.order_items);
        prod_quantity = (TextView) findViewById(R.id.order_total_items);
        order_total = (TextView) findViewById(R.id.order_total_payment);
        form_total = (TextView) findViewById(R.id.form_Total);
        prod_quantity = (TextView) findViewById(R.id.order_total_items);

        order_items.setText(txt_items);

        if (Double.parseDouble(txt_quantity)>1){
            prod_quantity.setText("Total Items: " + txt_quantity +"pcs");
            msg_quantity = txt_quantity.toString()+"pcs";
        }else{
            prod_quantity.setText("Total Items: " + txt_quantity +"pc");
            msg_quantity = txt_quantity.toString()+"pc";
        }

        order_total.setText("Total Payment: ₱" + txt_total);
        form_total.setText("₱" + txt_total);

        cart = (ImageButton) findViewById(R.id.catalog_cart_icon);
        cart.setVisibility(View.INVISIBLE);

        buttonBack = (ImageButton) findViewById(R.id.button_back);
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        place_order = findViewById(R.id.form_PlaceOrder);

        txt_firstname = findViewById(R.id.firstname);
        txt_middlename = findViewById(R.id.middlename);
        txt_lastname = findViewById(R.id.lastname);
        txt_address = findViewById(R.id.address);
        txt_email = findViewById(R.id.email);
        txt_phone = findViewById(R.id.phone);


        place_order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                getFirstname = txt_firstname.getEditText().getText().toString().trim();
                getMiddlename = txt_middlename.getEditText().getText().toString().trim();
                getLastname = txt_lastname.getEditText().getText().toString().trim();
                getAddress = txt_address.getEditText().getText().toString().trim();
                getEmail = txt_email.getEditText().getText().toString().trim();
                getPhone = txt_phone.getEditText().getText().toString().trim();

                //Start Action
                if (validateFields() == true){
                    OrderSuccess dialogBox = new OrderSuccess();
                    dialogBox.show(getSupportFragmentManager(), "my dialog");
                }else{
                    Toast.makeText(FormOrder.this, "Invalid", Toast.LENGTH_SHORT).show();
                }
            }

            private boolean validateFields(){
                boolean check_firstname = validateFirstname(getFirstname);
                boolean check_middlename = validateMiddlename(getMiddlename);
                boolean check_lastname = validateLastname(getLastname);
                boolean check_address = validateAddress(getAddress);
                boolean check_email = validateEmail(getEmail);
                boolean check_phone = validatePhone(getPhone);

                if(
                        check_firstname && check_middlename &&
                                check_lastname && check_address &&
                                check_email && check_phone
                ){
                    return true;

                }else{
                    return false;
                }
            }

            private boolean validateFirstname(String firstnameInput){
                if(!firstnameInput.isEmpty()){
                    txt_firstname.setError(null);
                    return true;
                }else{
                    txt_firstname.setError(" ");
                    return false;
                }
            }

            private boolean validateMiddlename(String middlenameInput){
                if(!middlenameInput.isEmpty()){
                    txt_middlename.setError(null);
                    return true;
                }else{
                    txt_middlename.setError(" ");
                    return false;
                }
            }

            private boolean validateLastname(String lastnameInput){
                if(!lastnameInput.isEmpty()){
                    txt_lastname.setError(null);
                    return true;
                }else{
                    txt_lastname.setError(" ");
                    return false;
                }
            }

            private boolean validateAddress(String addressInput){
                if(!addressInput.isEmpty()){
                    txt_address.setError(null);
                    return true;
                }else{
                    txt_address.setError(" ");
                    return false;
                }
            }

            private boolean validateEmail(String emailInput) {
                if(!emailInput.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(emailInput).matches()){
                    txt_email.setError(null);
                    return true;
                }else{
                    txt_email.setError(" ");
                    return false;
                }
            }

            private boolean validatePhone(String phoneInput){
                if(phoneInput.length()==10){
                    txt_phone.setError(null);
                    return true;
                }else{
                    txt_phone.setError(" ");
                    return false;
                }
            }
        });

        title_bar = (ImageView) findViewById(R.id.app_bar_title);
        title_bar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FormOrder.this, ProductCatalog.class);
                startActivity(intent);
            }
        });
    }

}