package com.example.bigbom.Model;

public class SQLConstantes {

    public static final String INSERT = "INSERT INTO products(description, value, amount) VALUES(?,?,?)";

    public static final String UPDATE = "UPDATE products SET description=?, value=?, amount=? WHERE id=?";

    public static final String REMOVE = "DELETE FROM products WHERE id=?";

    public static final String SEARCH = "SELECT * FROM products";

}
