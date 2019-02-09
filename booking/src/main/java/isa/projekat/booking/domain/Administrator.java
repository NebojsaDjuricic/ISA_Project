package isa.projekat.booking.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("Administrators")
public class Administrator {

    @Id
    private String username;
    private String password;
    private String email;
    private AdministatorType type;
    private String editingObjectID;

    public Administrator() {

    }

    public Administrator(String username, String password, String email, AdministatorType type) {
        this.setEmail(email);
        this.setPassword(password);
        this.setUsername(username);
        this.setType(type);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public AdministatorType getType() {
        return type;
    }

    public void setType(AdministatorType type) {
        this.type = type;
    }

    public String getEditingObjectID() {
        return editingObjectID;
    }

    public void setEditingObjectID(String editingObjectID) {
        this.editingObjectID = editingObjectID;
    }
}
