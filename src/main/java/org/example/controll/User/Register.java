package org.example.controll.User;

import org.example.controll.App;
import org.example.models.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import static org.example.controll.User.PasswordHashing.checkPassword;

public class Register extends App {

    public void registerUser() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter user name: ");
        String userName = sc.next();

        System.out.println("Please enter user email address: ");
        String email = sc.next();

        System.out.println("Please enter user password: ");
        String password = sc.next();

        String hashedPassword = PasswordHashing.hashPassword(password);
        System.out.println("Confirm password: ");

        String candidatePassword = sc.next();
        boolean passwordMatches = checkPassword(candidatePassword, hashedPassword);
        if (!passwordMatches) System.out.println("Password does not match");
        else {
            User insertUser = new User(userName, email, hashedPassword);
            String insertUserSQLStmt = "INSERT INTO users" +
                    "(userName, email, password)" +
                    "VALUES (?, ?, ?)";
            try (Connection conn = connection();
                 PreparedStatement statement = conn.prepareStatement(insertUserSQLStmt)) {

                statement.setString(1, insertUser.getUserName());
                statement.setString(2, insertUser.getEmail());
                statement.setString(3, insertUser.getPassword());
                statement.executeUpdate();
                System.out.println("User added!");

            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
