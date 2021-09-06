package com.company;

import java.sql.SQLException;
import java.util.List;

public interface ControllerI {

    public void registerUser(UserProfile user);

    public boolean loginUser(UserProfile user) throws SQLException;

    public void addToCart(Cart items);

    public List<Cart> showCart() throws SQLException;
}

