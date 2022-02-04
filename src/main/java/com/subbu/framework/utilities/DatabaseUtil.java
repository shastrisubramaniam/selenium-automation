package com.subbu.framework.utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DatabaseUtil {
    private static Connection connection;
    public static Connection Open(String connectstring)
    {
    try {
        Class.forName("org.mariadb.jdbc.Driver");
        connection = DriverManager.getConnection(connectstring);
    }
    catch (Exception e)
    {
        System.out.println(e.toString());
    }
    return connection;
    }
public static void ExecuteQuery(String query,Connection connection)
{
    Statement statement = null;
    try {
        statement = connection.createStatement();
        ResultSet resultset = statement.executeQuery(query);
    }
    catch (Exception e)
    {
        System.out.println(e.toString());
    }

}
}
