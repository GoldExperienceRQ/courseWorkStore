package org.example.courseworkstore.utils;

import org.mindrot.jbcrypt.BCrypt;

public class PasswordUtil {
    public static String hashPassword(String password){
        String salt = BCrypt.gensalt();
        return BCrypt.hashpw(password, salt);
    }
    public static boolean veifyPassword(String candidate, String hashed){
        return BCrypt.checkpw(candidate, hashed);
    }
}
