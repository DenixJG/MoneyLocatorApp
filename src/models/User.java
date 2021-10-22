package models;

import org.bson.types.ObjectId;

import java.io.Serializable;
import java.util.UUID;

/**
 * Modelo de Usuario
 *
 * @author Rafael
 */
public class User implements Serializable {
    private ObjectId _id;
    private String username;
    private String email;
    private String password; // TODO: 21/10/2021 Hacer la contraseña más segura usando char[]

    /**
     * Constructor para registrar un nuevo usuario.
     *
     * @param username Nombre de usuario.
     * @param email    Email del usuario
     * @param password Contraseña del usuario.
     */
    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    /**
     * Constructor para comprobar el inicio de sesión de un usuario.
     *
     * @param username Nombre de usuario
     * @param password Contraseña del usuario
     */
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User() {
        // Empty
    }

    public ObjectId getID() {
        return _id;
    }

    /**
     * Devuelve el nombre del usuario.
     *
     * @return {@linkplain String} Username del usuario.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Establece el username de del usuario.
     *
     * @param username {@linkplain String} nombre de usuario.
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return Email del usuario
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email Email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Devuelve un array de caracteres con la contraseña del usuario.
     *
     * @return Contraseña del usuario.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Establece la contraseña del usuario.
     *
     * @param password Contraseña
     */
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (!username.equals(user.username)) return false;
        return password.equals(user.password);
    }

    @Override
    public int hashCode() {
        int result = username.hashCode();
        result = 31 * result + password.hashCode();
        return result;
    }
}
