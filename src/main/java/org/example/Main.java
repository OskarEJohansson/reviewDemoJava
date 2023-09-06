package org.example;

import org.example.controll.Bookshelf.Retrieve;
import org.example.controll.User.Delete;
import org.example.controll.User.Login;
import org.example.controll.User.Register;


public class Main {
    public static void main(String[] args) {

        //Register user = new Register();
        //user.registerUser();
        //Retrieve book = new Retrieve();
        //book.getBookshelf();
        //Update book1 = new Update();
        //book1.updateBook();
        //Login loginUser = new Login();
        //loginUser.login();
        Delete deleteUser1 = new Delete();
        deleteUser1.deleteUser();
    }
}
