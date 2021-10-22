package controllers;

import com.mongodb.MongoClientSettings;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import models.User;
import org.bson.Document;
import org.bson.codecs.configuration.CodecRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

import java.util.List;

public class MongoController {
    private String hostname;
    private int port;
    private String dbName = null;
    private MongoClient client;

    /**
     * Conexión personalizada a la base de datos
     *
     * @param hostname Nombre de host de la base de datos
     * @param port     Puerto de la base de datos
     */
    public MongoController(String hostname, int port) {
        this.hostname = hostname;
        this.port = port;
        connect();
    }

    /**
     * Conexión por defecto con la base de datos, "mongodb://localhost".
     */
    public MongoController() {
        this.client = MongoClients.create();
    }

    /**
     * Cierra la conexión con la base de datos de MongoDB
     */
    public void closeConnection() {
        this.client.close();
    }

    /**
     * Inserta un nuevo usuario en la base de datos.
     *
     * @param user {@linkplain User} a ingresar.
     */
    public void addNewUser(User user) {
        if (user.getUsername() != null || user.getPassword() != null || user.getEmail() != null) {
            MongoDatabase db = this.getMongoDatabase("money-locator-app");
            db = db.withCodecRegistry(this.getCodecPojo());
            MongoCollection<User> users = db.getCollection("users", User.class);
            users.insertOne(user);
        } else {
            System.err.println("[ERR]: El usuario no puede ser null");
            System.exit(-1);
        }

    }

    /**
     * Obtener un usuario de la base de datos por medio de su username.
     *
     * @param username Nombre de usuario
     * @return {@linkplain User}
     */
    public User getUser(String username) {
        MongoDatabase db = this.getMongoDatabase("money-locator-app");
        db = db.withCodecRegistry(this.getCodecPojo());
        MongoCollection<User> users = db.getCollection("users", User.class);

        return users.find(Filters.eq("username", username)).first();
    }

    public boolean isUserOnDatabase(User user) {
        User dbUser = this.getUser(user.getUsername());
        return dbUser != null;
    }

    /**
     * Establece la conexión con la base de datos.
     */
    private void connect() {
        this.client = MongoClients.create(MongoClientSettings.builder().applyToClusterSettings(builder ->
                builder.hosts(List.of(new ServerAddress(this.getHostname(), this.getPort())))).build());
    }

    private CodecRegistry getCodecPojo() {
        return CodecRegistries.fromRegistries(MongoClientSettings.getDefaultCodecRegistry(),
                CodecRegistries.fromProviders(PojoCodecProvider.builder().automatic(true).build()));
    }

    /**
     * Obtener una base de datos de MongoDB.
     *
     * @param dbName Nombre de la base de datos
     * @return {@linkplain MongoDatabase}
     */
    public MongoDatabase getMongoDatabase(String dbName) {
        if (getDbName() != null) {
            return this.getClient().getDatabase(this.dbName);
        } else {
            this.dbName = dbName;
            return this.getClient().getDatabase(this.dbName);
        }
    }

    /**
     * Obtener colección de una base de datos de MongoDB.
     *
     * @param dbName         Nombre de la base de datos.
     * @param collectionName Nombre de la colección.
     * @return {@linkplain MongoCollection}
     */
    public MongoCollection<Document> getMongoCollection(String dbName, String collectionName) {
        return getMongoDatabase(dbName).getCollection(collectionName);
    }

    /**
     * Obtener colección de una base de datos sin ingresar el nombre de la base de datos, si no
     * se sabe el nombre devuelve null.
     *
     * @param collectionName
     * @return {@code null} si no hay nombre para la base de datos y {@linkplain MongoCollection} si
     * se encuentra el nombre la base de datos.
     */
    public MongoCollection<Document> getMongoCollection(String collectionName) {
        if (getDbName() != null) {
            return getMongoDatabase(getDbName()).getCollection(collectionName);
        }
        return null;
    }

    // Getter y Setter
    public MongoClient getClient() {
        return client;
    }

    public void setClient(MongoClient client) {
        this.client = client;
    }

    public String getDbName() {
        return dbName;
    }

    public void setDbName(String dbName) {
        this.dbName = dbName;
    }

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }
}
