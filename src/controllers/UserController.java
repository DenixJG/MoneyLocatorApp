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

    public UserController(LoginView loginView, User userModel) {
        this.loginView = loginView;
        this.userModel = userModel;
        this.mongoController = new MongoController();
    }

    public UserController(RegisterView registerView, User userModel) {
        this.registerView = registerView;
        this.userModel = userModel;
    }

    public boolean validateUser(User user) {
        User dbUser = this.mongoController.getUser(this.userModel.getUsername());
        return dbUser.equals(user);
    }

    public boolean validateUser() {
        User dbUser = this.mongoController.getUser(this.userModel.getUsername());
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
