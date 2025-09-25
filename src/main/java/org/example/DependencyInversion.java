package org.example;

class Database {
    private String databaseUrl;
    private String username;
    private String password;

    public Database(String databaseUrl, String username, String password) {
        this.databaseUrl = databaseUrl;
        this.username = username;
        this.password = password;
    }

    public void connect() {
        // ... логика подключения к MySQL ...
    }

    public void executeQuery(String query) {
        // ... логика выполнения запроса к MySQL ...
    }
}

public class DependencyInversion {
    public static void main(String[] args) {
        Database database = new Database(
                "jdbc:mysql://localhost:3306/mydatabase",
                "user",
                "password"
        );
        database.connect();
        database.executeQuery("SELECT * FROM users");
    }
}
