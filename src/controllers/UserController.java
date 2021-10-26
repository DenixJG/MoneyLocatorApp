package controllers;

import models.User;
import org.bson.types.ObjectId;
import views.login.LoginView;
import views.register.RegisterView;

import java.util.UUID;

public class UserController {
    private LoginView loginView;
    private RegisterView registerView;
    private MongoController mongoController; // Controlador de la base de datos
    private User userModel;

    /**
     * Constructor para la vista de login.
     *
     * @param loginView {@linkplain LoginView}
     * @param userModel {@linkplain User}
     */
    public UserController(LoginView loginView, User userModel) {
        this.loginView = loginView;
        this.userModel = userModel;
        this.mongoController = new MongoController();
    }

    /**
     * Constructor para la vista de registro.
     *
     * @param registerView {@linkplain RegisterView}
     * @param userModel    {@linkplain User}
     */
    public UserController(RegisterView registerView, User userModel) {
        this.registerView = registerView;
        this.userModel = userModel;
    }

    /**
     * Inicia sesión con el usuario que se ha pasado como modelo en el constructor
     *
     * @return {@code true/false} Si el usuario existe o no.
     */
    public boolean loginUser() {
        User dbUser = this.mongoController.getUser(getUsername());
        if (dbUser != null) {
            return dbUser.equals(this.userModel);
        }
        return false;
    }

    public ObjectId getID() {
        return this.userModel.getID();
    }

    public String getUsername() {
        return this.userModel.getUsername();
    }

    public void setUsername(String username) {
        this.userModel.setUsername(username);
    }

    public String getEmail() {
        return this.userModel.getEmail();
    }

    public void setEmail(String email) {
        this.userModel.setEmail(email);
    }

    public String getPassword() {
        return this.userModel.getPassword();
    }

    public void setPassword(String password) {
        this.userModel.setPassword(password);
    }

}
