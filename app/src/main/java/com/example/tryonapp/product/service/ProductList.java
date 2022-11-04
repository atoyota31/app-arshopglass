package com.example.tryonapp.product.service;

import android.content.Context;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.example.tryonapp.R;
import com.example.tryonapp.product.Product;
import com.example.tryonapp.form.FormOrder;
import com.example.tryonapp.products.ProductCatalog;
import com.example.tryonapp.cart.CartActivity;
import com.example.tryonapp.product_details.ProductDetails;
import com.example.tryonapp.product_view.ProductView;

public class ProductList {

    public static ArrayList<Product> list = new ArrayList<>();

    //Count items for Notification Badge
    public static int counter = 0;

    private Context context;

    private static final DecimalFormat df = new DecimalFormat(",###.00");

    public void addCartItem(String name, String price, int quantity, double total){
        if (list.isEmpty()){
            //Get the Array if Empty because the loop won't work if empty.
            list.add(new Product(
                    name,
                    price,
                    quantity,
                    total)
            );

        }else{
            int previous_quantity = 0;
            double previous_total = 0.0;
            int getIndex = 0;

            for (Product myList : list) {
                if (myList.name.equals(name)) {

                    previous_quantity = myList.quantity;
                    previous_total = myList.total;

                    list.remove(myList);
                    break;
                }
                getIndex++;
            }

            list.add(getIndex, new Product(
                    name,
                    price,
                    quantity + previous_quantity,
                    total + previous_total)
            );

        }
        countList();
        getSubTotal();
    }

    public void removeCartItem(String name){
        for (Product myList : list) {
            if (myList.name.equals(name)){
                list.remove(myList);
                break;
            }
        }
        countList();
    }

    public void updateCartItem(String name, int quantity, double total){
        for (Product myList : list) {
            if (myList.name.equals(name)){
                myList.quantity = quantity;
                myList.total = total;
                break;
            }
        }
    }

    public void checkOut(){
        String item_purchase = "";
        int total_items = 0;
        double total = 0.0;

        for (Product myList : list) {
            item_purchase += "   " + myList.name + " ("+ myList.quantity +")" + "\n";
            total_items += myList.quantity;
            total += myList.total;
        }

        FormOrder.txt_items = item_purchase;
        FormOrder.txt_quantity = total_items + "";
        FormOrder.txt_total = df.format(total);
    }

    //create cart list
    public void createList() {
        for (Product myList : list) {

            if (myList.name.equals("MAGIC PINK LIP GLOSS")){
                Map<String, Object> listView = new HashMap<>();
                listView.put("photo", R.drawable.magic_pink_lip_gloss);
                listView.put("name", "Name: " + myList.name);
                listView.put("price", "Price: ₱" +myList.price);
                if (myList.quantity>1){
                    listView.put("quantity", "Quantity: " +myList.quantity+"pcs");
                }else{
                    listView.put("quantity", "Quantity: " +myList.quantity+"pc");
                }
                listView.put("total", "Total: ₱" + df.format(myList.total));
                CartActivity.mySimpleList.add(listView);

            }else if (myList.name.equals("BLENDABLE LIP AND CHEEK COLOR")){
                Map <String, Object> listView = new HashMap<>();
                listView.put("photo", R.drawable.magic_pink_lip_gloss);
                listView.put("name", "Name: " +myList.name);
                listView.put("price","Price: ₱" + myList.price);
                if (myList.quantity>1){
                    listView.put("quantity", "Quantity: " +myList.quantity+"pcs");
                }else{
                    listView.put("quantity", "Quantity: " +myList.quantity+"pc");
                }
                listView.put("total", "Total: ₱" + df.format(myList.total));
                CartActivity.mySimpleList.add(listView);

            }else if (myList.name.equals("BLENDABLE LIP AND CHEEK COLOR ANGEL")){
                Map <String, Object> listView = new HashMap<>();
                listView.put("photo", R.drawable.magic_pink_lip_gloss);
                listView.put("name", "Name: " +myList.name);
                listView.put("price", "Price: ₱" +myList.price);
                if (myList.quantity>1){
                    listView.put("quantity", "Quantity: " +myList.quantity+"pcs");
                }else{
                    listView.put("quantity", "Quantity: " +myList.quantity+"pc");
                }
                listView.put("total","Total: ₱" + df.format(myList.total));
                CartActivity.mySimpleList.add(listView);

            }else if (myList.name.equals("METALLIC PRO LIPSTICK")){
                Map <String, Object> listView = new HashMap<>();
                listView.put("photo", R.drawable.magic_pink_lip_gloss);
                listView.put("name", "Name: " +myList.name);
                listView.put("price","Price: ₱" + myList.price);
                if (myList.quantity>1){
                    listView.put("quantity", "Quantity: " +myList.quantity+"pcs");
                }else{
                    listView.put("quantity", "Quantity: " +myList.quantity+"pc");
                }
                listView.put("total", "Total: ₱" + df.format(myList.total));
                CartActivity.mySimpleList.add(listView);

            }else if (myList.name.equals("MATTE PRO LIPSTICK")){
                Map <String, Object> listView = new HashMap<>();
                listView.put("photo", R.drawable.magic_pink_lip_gloss);
                listView.put("name", "Name: " +myList.name);
                listView.put("price", "Price: ₱" +myList.price);
                if (myList.quantity>1){
                    listView.put("quantity", "Quantity: " +myList.quantity+"pcs");
                }else{
                    listView.put("quantity", "Quantity: " +myList.quantity+"pc");
                }
                listView.put("total", "Total: ₱" + df.format(myList.total));
                CartActivity.mySimpleList.add(listView);

            }else if (myList.name.equals("MATTE PRO LIPSTICK BLITZ")){
                Map <String, Object> listView = new HashMap<>();
                listView.put("photo", R.drawable.magic_pink_lip_gloss);
                listView.put("name", "Name: " +myList.name);
                listView.put("price", "Price: ₱" +myList.price);
                if (myList.quantity>1){
                    listView.put("quantity", "Quantity: " +myList.quantity+"pcs");
                }else{
                    listView.put("quantity", "Quantity: " +myList.quantity+"pc");
                }
                listView.put("total","Total: ₱" + df.format(myList.total));
                CartActivity.mySimpleList.add(listView);

            }else if (myList.name.equals("LIP GLOSS")){
                Map <String, Object> listView = new HashMap<>();
                listView.put("photo", R.drawable.magic_pink_lip_gloss);
                listView.put("name", "Name: " +myList.name);
                listView.put("price", "Price: ₱" +myList.price);
                if (myList.quantity>1){
                    listView.put("quantity", "Quantity: " +myList.quantity+"pcs");
                }else{
                    listView.put("quantity", "Quantity: " +myList.quantity+"pc");
                }
                listView.put("total","Total: ₱" + df.format(myList.total));
                CartActivity.mySimpleList.add(listView);

            }else if (myList.name.equals("LIP CHEEK EYE COLOR")){
                Map <String, Object> listView = new HashMap<>();
                listView.put("photo", R.drawable.magic_pink_lip_gloss);
                listView.put("name", "Name: " +myList.name);
                listView.put("price", "Price: ₱" +myList.price);
                if (myList.quantity>1){
                    listView.put("quantity", "Quantity: " +myList.quantity+"pcs");
                }else{
                    listView.put("quantity", "Quantity: " +myList.quantity+"pc");
                }
                listView.put("total","Total: ₱" + df.format(myList.total));
                CartActivity.mySimpleList.add(listView);

            }else if (myList.name.equals("LONG LASTING METALLIC LIP COLOR")){
                Map <String, Object> listView = new HashMap<>();
                listView.put("photo", R.drawable.magic_pink_lip_gloss);
                listView.put("name", "Name: " +myList.name);
                listView.put("price", "Price: ₱" +myList.price);
                if (myList.quantity>1){
                    listView.put("quantity", "Quantity: " +myList.quantity+"pcs");
                }else{
                    listView.put("quantity", "Quantity: " +myList.quantity+"pc");
                }
                listView.put("total","Total: ₱" + df.format(myList.total));
                CartActivity.mySimpleList.add(listView);

            }else if (myList.name.equals("LONG LASTING LIP COLOR")){
                Map <String, Object> listView = new HashMap<>();
                listView.put("photo", R.drawable.magic_pink_lip_gloss);
                listView.put("name", "Name: " +myList.name);
                listView.put("price", "Price: ₱" +myList.price);
                if (myList.quantity>1){
                    listView.put("quantity", "Quantity: " +myList.quantity+"pcs");
                }else{
                    listView.put("quantity", "Quantity: " +myList.quantity+"pc");
                }
                listView.put("total","Total: ₱" + df.format(myList.total));
                CartActivity.mySimpleList.add(listView);

            }else if (myList.name.equals("CLASSIQUE LIPSTICK")){
                Map <String, Object> listView = new HashMap<>();
                listView.put("photo", R.drawable.magic_pink_lip_gloss);
                listView.put("name", "Name: " +myList.name);
                listView.put("price", "Price: ₱" +myList.price);
                if (myList.quantity>1){
                    listView.put("quantity", "Quantity: " +myList.quantity+"pcs");
                }else{
                    listView.put("quantity", "Quantity: " +myList.quantity+"pc");
                }
                listView.put("total","Total: ₱" + df.format(myList.total));
                CartActivity.mySimpleList.add(listView);

            }else if (myList.name.equals("METALLIC PRO LIPSTICK HOLLYWOOD")){
                Map <String, Object> listView = new HashMap<>();
                listView.put("photo", R.drawable.magic_pink_lip_gloss);
                listView.put("name", "Name: " +myList.name);
                listView.put("price", "Price: ₱" +myList.price);
                if (myList.quantity>1){
                    listView.put("quantity", "Quantity: " +myList.quantity+"pcs");
                }else{
                    listView.put("quantity", "Quantity: " +myList.quantity+"pc");
                }
                listView.put("total","Total: ₱" + df.format(myList.total));
                CartActivity.mySimpleList.add(listView);

            }else if (myList.name.equals("MAGIC PINK LIP GLOSS - 5 PCS BUNDLE")){
                Map <String, Object> listView = new HashMap<>();
                listView.put("photo", R.drawable.magic_pink_lip_gloss);
                listView.put("name", "Name: " +myList.name);
                listView.put("price", "Price: ₱" +myList.price);
                if (myList.quantity>1){
                    listView.put("quantity", "Quantity: " +myList.quantity+"pcs");
                }else{
                    listView.put("quantity", "Quantity: " +myList.quantity+"pc");
                }
                listView.put("total","Total: ₱" + df.format(myList.total));
                CartActivity.mySimpleList.add(listView);

            }

        }
    }

    public void countList() {
        counter = 0;
        for (Product myList : list) {
            counter++;
        }
        setBadge(counter);
    }

    public void setBadge(int count_item){
        ProductCatalog.catalog_badge.setNumber(count_item);
        ProductView.prod_view_badge.setNumber(count_item);
        ProductDetails.prod_details_badge.setNumber(count_item);
    }

    public ArrayList getItem(){
        ArrayList items = new ArrayList();
        for (Product myList : list) {
            items.add(
                    "Name: "+ myList.name +"\n"
                            + "Price: "+ myList.price +"\n"
                            +"Quantity: "+myList.quantity +"\n"
                            +"Total: "+myList.total);
        }
        return items;
    }

    public Double getSubTotal(){
        double sub_total = 0.0;
        for (Product myList : list) {
            sub_total += myList.total;
        }
        return sub_total;
    }
}
