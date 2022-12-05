//Alysson

package com.example.demo;

public class SqlConstantes {

    public static final String INSERT = "INSERT INTO products(Description, Value, Amount, Unit) VALUES(?,?,?,?)";

    public static final String UPDATE = "UPDATE products SET Description=?, Value=?, Amount=?, Unit=? WHERE id=?";

    public static final String REMOVE = "DELETE FROM products WHERE id=?";

    public static final String SEARCH = "SELECT * FROM products";
}
