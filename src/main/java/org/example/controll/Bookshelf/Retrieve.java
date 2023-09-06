package org.example.controll.Bookshelf;

import org.example.controll.ConnectToDatabase;

import java.sql.*;
import java.util.Scanner;

public class Retrieve extends ConnectToDatabase {
    public void findBookByAuthor() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter author name: ");
        String author = sc.next();
        String SQL = "SELECT id, author, title, lang, score, review " +
                "FROM bookshelf " +
                "WHERE author = ?";

        try (Connection conn = connectToDb();
             PreparedStatement stmt = conn.prepareStatement(SQL)) {

            stmt.setString(1, author);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()){
                if (rs.getString("author").equals(author)){
                    display(rs);
                }
                else System.out.println("No match found");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void getBookshelf() {

        String SQL = "SELECT id, author, title, lang, score, review " +
                "FROM bookshelf";

        try (Connection conn = connectToDb();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(SQL)) {
            while(rs.next()){
                display(rs);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    private void display(ResultSet rs) throws SQLException {
            System.out.printf(
                    "id: %s " +
                    "author: %s " +
                    "title: %s " +
                    "lang: %s " +
                    "score: %s " +
                    "review: %s"  ,
                    rs.getString("id"),
                    rs.getString("author"),
                    rs.getString("title"),
                    rs.getString("lang"),
                    rs.getInt("score"),
                    rs.getString("review")
                            + "\n");
    }
}
