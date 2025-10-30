import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.Scanner;
import java.util.Arrays;


//punya naufal
public class AutoHashScanner {

    private static final int SALT_LENGTH = 16; // 16 bytes = 128 bit

    // Generate salt aman
    public static byte[] generateSalt() {
        SecureRandom sr = new SecureRandom();
        byte[] salt = new byte[SALT_LENGTH];
        sr.nextBytes(salt);
        return salt;
    }

    // Hash (SHA-256) : hash(salt || inputBytes)
    public static byte[] sha256Hash(byte[] salt, byte[] input) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(salt);    // update with salt first
            md.update(input);   // then input bytes
            return md.digest();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("SHA-256 algorithm not available", e);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Masukkan teks untuk di-hash: ");
        String teks = sc.nextLine();

        // Konversi ke bytes (UTF-8)
        byte[] inputBytes = teks.getBytes(java.nio.charset.StandardCharsets.UTF_8);

        // Generate salt dan hash
        byte[] salt = generateSalt();
        byte[] hash = sha256Hash(salt, inputBytes);

        // Konversi ke Base64 untuk ditampilkan / disimpan
        String saltBase64 = Base64.getEncoder().encodeToString(salt);
        String hashBase64 = Base64.getEncoder().encodeToString(hash);

        System.out.println("\n=== Hasil Hash ===");
        System.out.println("Teks input (TERSEMBUNYI dalam praktik): " + teks);
        System.out.println("Salt (Base64): " + saltBase64);
        System.out.println("Hash (SHA-256, Base64): " + hashBase64);

        // membersihkan data sensitif di memory (sebisa mungkin)
        Arrays.fill(inputBytes, (byte) 0);
        Arrays.fill(salt, (byte) 0);
        Arrays.fill(hash, (byte) 0);

        sc.close();
    }
}
