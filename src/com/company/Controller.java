package com.company;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Controller extends DatabaseUtil implements ControllerI {

    @Override
    public void registerUser(UserProfile user) {
        String sql;

        sql = "insert into jdbc.new_users(id,name,password,email) values(";
        sql += new Random( ).nextInt(1000) + ",";
        sql += "'" + user.getName( ) + "',";
        sql += "'" + user.getPassword( ) + "',";
        sql += "'" + user.getEmail( ) + "');";

        System.out.println("Executing sql: " + sql);

        execUpdate(sql);
    }

    @Override
    public boolean loginUser(UserProfile user) throws SQLException {
        String sql;
        boolean match = false;

        sql = "select name,password from jdbc.new_users where (name=";
        sql += "'" + user.getName( ) + "'";
        sql += " and password=";
        sql += "'" + user.getPassword( ) + "');";

        ResultSet resultSet = execQuery(sql);
        if (resultSet == null) {
            return match;
        }
        while (resultSet.next()) {
            match = (resultSet.getString(1).equals(user.getName( ))) &&
                    (resultSet.getString(2).equals(user.getPassword( )));
        }
        return match;
    }

    @Override
    public void addToCart(Cart items) {
        String sql;

        sql = "insert into jdbc.new_cart(id,price,name) values(";
        sql += new Random( ).nextInt(1000) + ",";
        sql += "'" + items.getProductPrice( ) + "',";
        sql += "'" + items.getProductName( ) + "');";

        System.out.println("Executing sql: " + sql);
        execUpdate(sql);

    }

    @Override
    public List<Cart> showCart() throws SQLException {
        String sql;

        sql = "select * from jdbc.new_cart;";

        ResultSet resultSet = execQuery(sql);
        List<Cart> cartList = new ArrayList<>( );
        while (resultSet.next( )) {
            Cart cart = new Cart( );
            cart.setProductId(resultSet.getInt(1));
            cart.setProductPrice(resultSet.getFloat(2));
            cart.setProductName(resultSet.getString(3));
            cartList.add(cart);
        }
        return cartList;
    }
}