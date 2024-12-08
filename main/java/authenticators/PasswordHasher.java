package authenticators;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordHasher {

    // Method to hash a password
    public static String getHashedPassword(String password) {
        try {
            // Create a MessageDigest instance for SHA-256
            MessageDigest md = MessageDigest.getInstance("SHA-256");

            // Convert the password string to bytes and compute the hash
            byte[] hashedBytes = md.digest(password.getBytes());

            // Convert the byte array into a readable hexadecimal format
            StringBuilder hexString = new StringBuilder();
            for (byte b : hashedBytes) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) {
                    hexString.append('0'); // Ensure two-digit format for each byte
                }
                hexString.append(hex);
            }

            // Return the hashed password as a string
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            // Handle exceptions for unsupported algorithms
            throw new RuntimeException("Error hashing password: " + e.getMessage());
        }
    }

    // Method to compare a plain password to a hashed password
    public static boolean comparePasswords(String plainPassword, String hashedPassword) {
        // Hash the plain password
        String computedHash = getHashedPassword(plainPassword);

        // Compare the computed hash with the given hashed password
        return computedHash.equals(hashedPassword);
    }
}
