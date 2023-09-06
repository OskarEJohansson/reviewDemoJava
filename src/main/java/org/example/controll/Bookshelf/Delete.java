package org.example.controll.Bookshelf;
import org.example.controll.ConnectToDatabase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Delete extends ConnectToDatabase {

    public void deleteBook() {
        try (Connection connSelect = connectToDb()) {
            Retrieve book = new Retrieve();
            book.getBookshelf();
            String SQLSelect = "SELECT * FROM bookshelf WHERE id = ?";
            PreparedStatement stmtSelect = connSelect.prepareStatement(SQLSelect);

            System.out.println("Insert book ID to delete record: ");
            Scanner sc = new Scanner(System.in);
            int id = sc.nextInt();
            stmtSelect.setInt(1, id);

            ResultSet rs = stmtSelect.executeQuery();

            if (rs.next()) {
                String SQLDelete = "DELETE FROM bookshelf WHERE id = ?";
                try (Connection connDelete = connectToDb();
                     PreparedStatement stmtDelete = connDelete.prepareStatement(SQLDelete)) {
                    System.out.println("Please confirm by entering ID again: ");
                    id = sc.nextInt();
                    stmtDelete.setInt(1, id);
                    stmtDelete.executeUpdate();
                    System.out.println("Record deleted successfully");
                } catch (Exception ex) {
                    System.out.println("Error deleting record: " + ex.getMessage());
                }
            } else {
                System.out.println("No matching record found.");
            }
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }
}