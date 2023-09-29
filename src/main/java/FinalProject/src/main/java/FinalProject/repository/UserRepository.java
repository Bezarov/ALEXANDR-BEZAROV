package FinalProject.repository;

import FinalProject.Models.UserModel;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.security.NoSuchAlgorithmException;
import java.security.MessageDigest;

@Repository
public interface UserRepository extends CrudRepository<UserModel, UUID> {
    @Query(value = "SELECT PASSWORD FROM USERS WHERE PASSWORD = :password", nativeQuery = true)
    String passwordCheck(@Param("password") String password);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "UPDATE USERS SET PASSWORD = :newPassword WHERE PASSWORD = :oldPassword", nativeQuery = true)
    void updatePassword(@Param("newPassword") String newPassword, @Param("oldPassword") String oldPassword);

    @Query(value = "SELECT SURNAME FROM USERS WHERE SURNAME = :surName", nativeQuery = true)
    String userDuplicateCheck(@Param("surName") String surName);

    @Query(value = "SELECT * FROM USERS WHERE SURNAME = :surName", nativeQuery = true)
    List<UserModel> findUserBySurname(@Param("surName") String surName);

    default String passwordEncryption(String password) {
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
