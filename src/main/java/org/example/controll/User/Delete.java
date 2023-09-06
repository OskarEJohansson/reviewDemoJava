package org.example.controll.User;


import org.example.controll.ConnectToDatabase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import static org.example.controll.User.PasswordHashing.checkPassword;

public class Delete extends Login {

    public void deleteUser() {

        Login delete = new Login();
        Scanner sc = new Scanner(System.in);
        System.out.println("Eneter username to delete user: ");
        String userName = sc.next();

        if (delete.checkIfUserExist(userName)) {
            if (unhashPassword(userName)) {
                System.out.println("Enter username again to confirm delete: ");
                String userNameConfirm = sc.next();
                String SQL = "DELETE FROM users WHERE username = ? ";

                if (userName.equals(userNameConfirm)) {
                    try (Connection conn = connectToDb()) {
                        PreparedStatement stmt = conn.prepareStatement(SQL);
                        stmt.setString(1, userName);
                        int rowsDeleted = stmt.executeUpdate();

                        if (rowsDeleted > 0) {
                            System.out.println("User deleted successfully");
                        } else System.out.println("User not found or not deleted");

                    } catch (SQLException ex) {
                        System.out.println(ex.getMessage());
                    }
                }
            }

        }
    }
}
