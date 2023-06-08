package homework_nr_16;

import java.sql.*;
import java.util.Random;

public class Main {
    private final String url = "jdbc:postgresql://localhost:5432/postgres";
    private final String user = "postgres";
    private final String password = "sqlpass";

    private static final String createTable = "CREATE TABLE customer_information " +
            "(customer_id INT PRIMARY KEY ," +
            " NAME VARCHAR(20) NOT NULL, " +
            " SURNAME VARCHAR(20) NOT NULL , " +
            " PHONE_NUMBER VARCHAR(20), " +
            " IS_ACTIVE BOOLEAN NOT NULL)";

    private static final String insertUsers = "INSERT INTO customer_information" +
            "  (customer_id, NAME, SURNAME, PHONE_NUMBER, IS_ACTIVE) VALUES " +
            " (?, ?, ?, ?, ?);";
    private final String[] names = {"Alex", "Dima", "German", "Vladimir", "Sergei"};
    private final String[] surnames = {"Ghertz", "Bezarov", "Ciobanu", "Semionov", "Boring"};
    private static final Random random = new Random();
    private static final String findFirstLatter = "select name from customer_information\n" +
            "WHERE name ~ '^[A]';";

    public static void main(String[] args) throws SQLException {
        Main sqlcomm = new Main();
        sqlcomm.createTableMethod();
        sqlcomm.insertUsersMethod();
        sqlcomm.getFirstFiveRaws();
        sqlcomm.findFirstLatterMethod();
        sqlcomm.findLatterVandAandV();
        sqlcomm.findTrue();
        sqlcomm.namesAndPhoneNumbers();
    }

    public void createTableMethod() throws SQLException {
        Connection connection = DriverManager.getConnection(url, user, password);
        Statement state = connection.createStatement();
        state.execute(createTable);
        state.close();
        connection.close();
    }

    public void insertUsersMethod() throws SQLException {
        Connection connection = DriverManager.getConnection(url, user, password);
        PreparedStatement state = connection.prepareStatement(insertUsers);
        for (int i = 0; i < 10; i++) {
            String phone = "+37369" + String.valueOf(random.ints(100000, 999999)
                    .findFirst()
                    .getAsInt());
            state.setInt(1, i);
            state.setString(2, names[random.nextInt(names.length)]);
            state.setString(3, surnames[random.nextInt(surnames.length)]);
            state.setString(4, phone);
            state.setBoolean(5, random.nextBoolean());
            state.addBatch();
        }
        state.executeBatch();
        connection.close();
        state.close();
    }

    public void getFirstFiveRaws() throws SQLException {
        Connection connection = DriverManager.getConnection(url, user, password);
        Statement state = connection.createStatement();
        ResultSet result = state.executeQuery("SELECT * FROM customer_information \n" +
                "limit 5;");
        System.out.print(result.getMetaData().getColumnName(1) + " |\t");
        System.out.print(result.getMetaData().getColumnName(2) + " |\t\t");
        System.out.print(result.getMetaData().getColumnName(3) + " |\t");
        System.out.print(result.getMetaData().getColumnName(4) + " |\t");
        System.out.println(result.getMetaData().getColumnName(5));
        while (result.next()) {
            System.out.print(result.getInt(1));
            System.out.print(":\t\t\t");
            System.out.print(result.getString(2));
            System.out.print("\t\t");
            System.out.print(result.getString(3));
            System.out.print("\t\t");
            System.out.print(result.getString(4));
            System.out.print("\t\t");
            System.out.println(result.getBoolean(5));
        }
        result.close();
        state.close();
        connection.close();
    }

    public void findFirstLatterMethod() throws SQLException {
        Connection connection = DriverManager.getConnection(url, user, password);
        Statement state = connection.createStatement();
        ResultSet result = state.executeQuery("SELECT * FROM customer_information\n" +
                "WHERE name ~ '^[A]';");
        System.out.print(result.getMetaData().getColumnName(1) + " |\t");
        System.out.print(result.getMetaData().getColumnName(2) + " |\t\t");
        System.out.print(result.getMetaData().getColumnName(3) + " |\t");
        System.out.print(result.getMetaData().getColumnName(4) + " |\t");
        System.out.println(result.getMetaData().getColumnName(5));
        while (result.next()) {
            System.out.print(result.getInt(1));
            System.out.print(":\t\t\t");
            System.out.print(result.getString(2));
            System.out.print("\t\t");
            System.out.print(result.getString(3));
            System.out.print("\t\t");
            System.out.print(result.getString(4));
            System.out.print("\t\t");
            System.out.println(result.getBoolean(5));
        }
        result.close();
        state.close();
        connection.close();
    }

    public void findLatterVandAandV() throws SQLException {
        Connection connection = DriverManager.getConnection(url, user, password);
        Statement state = connection.createStatement();
        ResultSet result = state.executeQuery("SELECT * FROM customer_information\n" +
                "WHERE name ~ '(^[Vv])(.*[Aa])(.*[Rr])';");
        System.out.print(result.getMetaData().getColumnName(1) + " |\t");
        System.out.print(result.getMetaData().getColumnName(2) + " |\t\t");
        System.out.print(result.getMetaData().getColumnName(3) + " |\t");
        System.out.print(result.getMetaData().getColumnName(4) + " |\t");
        System.out.println(result.getMetaData().getColumnName(5));
        while (result.next()) {
            System.out.print(result.getInt(1));
            System.out.print(":\t\t\t");
            System.out.print(result.getString(2));
            System.out.print("\t\t");
            System.out.print(result.getString(3));
            System.out.print("\t\t");
            System.out.print(result.getString(4));
            System.out.print("\t\t");
            System.out.println(result.getBoolean(5));
        }
        result.close();
        state.close();
        connection.close();
    }

    public void findTrue() throws SQLException {
        Connection connection = DriverManager.getConnection(url, user, password);
        Statement state = connection.createStatement();
        ResultSet result = state.executeQuery("SELECT * FROM customer_information\n" +
                "WHERE is_active = true;");
        System.out.print(result.getMetaData().getColumnName(1) + " |\t");
        System.out.print(result.getMetaData().getColumnName(2) + " |\t\t");
        System.out.print(result.getMetaData().getColumnName(3) + " |\t");
        System.out.print(result.getMetaData().getColumnName(4) + " |\t");
        System.out.println(result.getMetaData().getColumnName(5));
        while (result.next()) {
            System.out.print(result.getInt(1));
            System.out.print(":\t\t\t");
            System.out.print(result.getString(2));
            System.out.print("\t\t");
            System.out.print(result.getString(3));
            System.out.print("\t\t");
            System.out.print(result.getString(4));
            System.out.print("\t\t");
            System.out.println(result.getBoolean(5));
        }
        result.close();
        state.close();
        connection.close();
    }

    public void namesAndPhoneNumbers() throws SQLException {
        Connection connection = DriverManager.getConnection(url, user, password);
        Statement state = connection.createStatement();
        ResultSet result = state.executeQuery("SELECT name, phone_number FROM customer_information;");
        System.out.print(result.getMetaData().getColumnName(1) + " |\t");
        System.out.println(result.getMetaData().getColumnName(2) + " |\t\t");
        while (result.next()) {
            System.out.print(result.getString(1));
            System.out.print("\t\t");
            System.out.println(result.getString(2));
        }
        result.close();
        state.close();
        connection.close();
    }
}


