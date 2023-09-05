package org.example.controll.Bookshelf;

import org.example.controll.App;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Update extends App {
    public void updateBook() {
        try (Connection connSelect = connection()) {
            Retrieve book = new Retrieve();
            book.getBookshelf();
            String SQLSelect = "SELECT * FROM bookshelf WHERE id = ?";
            PreparedStatement stmtSelect = connSelect.prepareStatement(SQLSelect);

            System.out.println("Insert book ID to update record: ");
            Scanner sc = new Scanner(System.in);
            int id = sc.nextInt();
            stmtSelect.setInt(1, id);

            ResultSet rs = stmtSelect.executeQuery();

            System.out.println("1 - Update all" + '\n' +
                    "2 - Update author" + '\n' +
                    "3 - Update title" + '\n' +
                    "4 - Update lang" + '\n' +
                    "5 - Update score" + '\n' +
                    "6 - Update review" + '\n');
            System.out.println("Insert number of record parameter to update: ");
            int updateChoice = sc.nextInt();

            switch (updateChoice) {

                case 1:
                    updateAll(sc, id);
                    break;

                case 2:
                    updateAuthor(sc, id);
                    break;

                case 3:
                    updateTitle(sc, id);

                case 4:
                    updateLang(sc, id);
                    break;

                case 5:
                    updateScore(sc, id);
                    break;

                case 6:
                    updateReview(sc, id);
                    break;
            }


        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }

    }

    private void updateAll(Scanner sc, int id) {

            String SQLUpdate = "UPDATE bookshelf " +
                    "SET author = ?, title = ?, lang = ?, score = ?, review = ? " +
                    "WHERE id = ?";

            try (Connection connDelete = connection();
                 PreparedStatement stmtUpdate = connDelete.prepareStatement(SQLUpdate)) {

                System.out.println("Please confirm by entering book ID again: ");
                id = sc.nextInt();
                stmtUpdate.setInt(6, id);

                System.out.println("Please enter Author: ");
                String author = sc.next();
                stmtUpdate.setString(1, author);

                System.out.println("Please enter Title: ");
                String title = sc.next();
                stmtUpdate.setString(2, title);

                System.out.println("Please enter language: ");
                String lang = sc.next();
                stmtUpdate.setString(3, lang);

                System.out.println("Please enter Score(1 - 5): ");
                int score = sc.nextInt();
                stmtUpdate.setInt(4, score);

                System.out.println("Please enter Review: ");
                String review = sc.next();
                stmtUpdate.setString(5, review);

                stmtUpdate.executeUpdate();
                System.out.println("Record updated successfully");
            } catch (Exception ex) {
                System.out.println("Error Updating record: " + ex.getMessage());
            }
        }

    private void updateAuthor(Scanner sc, int id) {
            String SQLUpdate = "UPDATE bookshelf " +
                "SET author = ? " +
                "WHERE id = ?";

            try (Connection connDelete = connection();
                 PreparedStatement stmtUpdate = connDelete.prepareStatement(SQLUpdate)) {

                System.out.println("Please enter new author: ");
                String author = sc.next();
                stmtUpdate.setString(1, author);
                stmtUpdate.setInt(2, id);


                stmtUpdate.executeUpdate();
                System.out.println("Author updated successfully");

            } catch (Exception ex) {
                System.out.println("Error Updating record: " + ex.getMessage());
            }
        }

    private void updateTitle (Scanner sc, int id) {

            String SQLUpdate = "UPDATE bookshelf " +
                    "SET title = ? " +
                    "WHERE id = ?";

            try (Connection connDelete = connection();
                 PreparedStatement stmtUpdate = connDelete.prepareStatement(SQLUpdate)) {

                System.out.println("Please enter new title: ");
                String title = sc.next();
                stmtUpdate.setString(1, title);
                stmtUpdate.setInt(2, id);

                stmtUpdate.executeUpdate();
                System.out.println("Title updated successfully");

            } catch (Exception ex) {
                System.out.println("Error Updating record: " + ex.getMessage());
            }
        }

    private void updateLang (Scanner sc,int id) {

            String SQLUpdate = "UPDATE bookshelf " +
                    "SET lang = ? " +
                    "WHERE id = ?";

            try (Connection connDelete = connection();
                 PreparedStatement stmtUpdate = connDelete.prepareStatement(SQLUpdate)) {

                System.out.println("Please enter new ang: ");
                String lang = sc.next();
                stmtUpdate.setString(1, lang);
                stmtUpdate.setInt(2, id);

                stmtUpdate.executeUpdate();
                System.out.println("Lang updated successfully");

            } catch (Exception ex) {
                System.out.println("Error Updating record: " + ex.getMessage());
            }
    }

    private void updateScore(Scanner sc,int id) {
            String SQLUpdate = "UPDATE bookshelf " +
                    "SET score = ? " +
                    "WHERE id = ?";

            try (Connection connDelete = connection();
                 PreparedStatement stmtUpdate = connDelete.prepareStatement(SQLUpdate)) {

                System.out.println("Please enter new score: ");
                String score = sc.next();
                stmtUpdate.setString(1, score);
                stmtUpdate.setInt(2, id);

                stmtUpdate.executeUpdate();
                System.out.println("Score updated successfully");

            } catch (Exception ex) {
                System.out.println("Error Updating record: " + ex.getMessage());
            }
    }

    private void updateReview (Scanner sc,int id){

            String SQLUpdate = "UPDATE bookshelf " +
                    "SET review = ? " +
                    "WHERE id = ?";
            try (Connection connDelete = connection();
                 PreparedStatement stmtUpdate = connDelete.prepareStatement(SQLUpdate)) {

                System.out.println("Please enter new score: ");
                String review = sc.next();
                stmtUpdate.setString(1, review);
                stmtUpdate.setInt(2, id);

                stmtUpdate.executeUpdate();
                System.out.println("Score updated successfully");

            } catch (Exception ex) {
                System.out.println("Error Updating record: " + ex.getMessage());
            }
    }
}