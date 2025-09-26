package org.example;


interface DatabaseConnectionManager {
    void connect();

    void executeQuery(String query);
}

class MySqlConnectionManager implements DatabaseConnectionManager {
    @Override
    public void connect() {
        // логика Mysql
    }

    @Override
    public void executeQuery(String query) {
        System.out.println(query + " Mysql");
    }
}

class PostgresConnectionManager implements DatabaseConnectionManager {
    @Override
    public void connect() {
        // другая локина
    }

    @Override
    public void executeQuery(String query) {
        System.out.println(query + "Postgres");
    }
}

class TestConnectionManager implements DatabaseConnectionManager {
    @Override
    public void connect() {

    }

    @Override
    public void executeQuery(String query) {

    }
}

class Database {
    private String databaseUrl;
    private String username;
    private String password;

    private DatabaseConnectionManager manager;

    public Database(String databaseUrl, String username, String password, DatabaseConnectionManager manager) {
        this.databaseUrl = databaseUrl;
        this.username = username;
        this.password = password;
        this.manager = manager;
    }

    public void connect() {
        manager.connect();
    }

    public void executeQuery(String query) {
        manager.executeQuery(query);
    }
}

public class DependencyInversion {
    public static void main(String[] args) {
        Database database = new Database(
                "jdbc:mysql://localhost:3306/mydatabase",
                "user",
                "password",
                new PostgresConnectionManager()
        );
        database.connect();
        database.executeQuery("SELECT * FROM users");
    }
}
