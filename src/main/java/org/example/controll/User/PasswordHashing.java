package org.example.controll.User;

import org.mindrot.jbcrypt.BCrypt;

public class PasswordHashing {
    public static String hashPassword(String password){
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }
    public static boolean checkPassword(String candidatePassword, String hashedPassword){
        return BCrypt.checkpw(candidatePassword, hashedPassword);
    }
}
