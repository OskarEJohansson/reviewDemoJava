package org.example.controll.User;

import org.mindrot.jbcrypt.BCrypt;

public class PasswordHashing {
    static String hashPassword(String password){
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }
    static boolean checkPassword(String candidatePassword, String hashedPassword){
        return BCrypt.checkpw(candidatePassword, hashedPassword);
    }
}
