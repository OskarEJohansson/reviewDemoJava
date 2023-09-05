package org.example.controll.Bookshelf;

import org.example.controll.App;
import org.example.models.Book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class Insert extends App {
    public void insertBook(Book book) {
        String SQL = "INSERT INTO bookshelf(author,title,lang,score,review) "
                + "VALUES(?,?,?,?,?)";
        ;
        try (Connection conn = connection();
             PreparedStatement statement = conn.prepareStatement(SQL)){
            {
                statement.setString(1, book.getAuthor());
                statement.setString(2, book.getTitle());
                statement.setString(3, book.getLang());
                statement.setInt(4, book.getScore());
                statement.setString(5, book.getReview());

                statement.addBatch();
                statement.executeBatch();
                System.out.println("Book added!");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
