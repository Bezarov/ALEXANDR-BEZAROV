package FinalProject.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

@Entity
@Table(name = "USERS")
public class UserModel {
    @Id
    @Column
    @GeneratedValue
    private UUID userId;
    @Column
    @NotEmpty
    private String name;
    @Column
    @NotEmpty
    private String surname;
    @Column
    @NotEmpty
    private String password;

    public UserModel() {
    }

    public UserModel(UUID userId, String name, String surname, String password) {
        this.userId = userId;
        this.name = name;
        this.surname = surname;
        this.password = passwordEncryption(password);
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = passwordEncryption(password);
    }

    public String passwordEncryption(String password) {
        String encryptedpassword = null;
        try {
            MessageDigest m = MessageDigest.getInstance("MD5");
            m.update(password.getBytes());
            byte[] bytes = m.digest();
            StringBuilder s = new StringBuilder();
            for (byte aByte : bytes) {
                s.append(Integer.toString((aByte & 0xff) + 0x100, 16).substring(1));
            }
            encryptedpassword = s.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return encryptedpassword;
    }

}
