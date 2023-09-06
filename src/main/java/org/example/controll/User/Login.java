package org.example.controll.User;

import org.example.controll.ConnectToDatabase;
import org.example.models.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import static org.example.controll.User.PasswordHashing.checkPassword;

public class Login extends ConnectToDatabase {

    public boolean login() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter 'User Name': ");
        String userName = sc.next();
        checkIfUserExist(userName);

        return unhashPassword(userName);
    }

    protected boolean checkIfUserExist(String userName) {
        Boolean userExist = false;
        String SQL = "SELECT username FROM users";
        try (Connection conn = connectToDb();
             PreparedStatement stmt = conn.prepareStatement(SQL)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                if (rs.getString("username").equals(userName)) {
                    userExist = true;
                } else System.out.println("");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return userExist;
    }
    protected boolean unhashPassword(String userName){
        boolean checkedPassword = false;
        String SQL = "SELECT password FROM users WHERE username = ? ";
        System.out.println("Please enter 'password': ");
        Scanner sc = new Scanner(System.in);
        String password = sc.next();
        try (Connection conn = connectToDb()) {
            PreparedStatement stmt = conn.prepareStatement(SQL);
            stmt.setString(1, userName);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                String hashedPassword = rs.getString("password");
                checkedPassword = checkPassword(password, hashedPassword);

                if (checkedPassword) {
                    System.out.println("Login successful!");
                } else System.out.println("Wrong password");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return checkedPassword;
    }
}








