package isa.projekat.booking.domain.dto;

import isa.projekat.booking.domain.Administrator;

public class AdministratorFullDTO {

    private String username;
    private String password;
    private String email;
    private String role;
    private String editingObjectID;

    public AdministratorFullDTO() {

    }

    public AdministratorFullDTO(
            String username,
            String password,
            String email,
            String role,
            String editingObjectID
    ) {
        this.setEditingObjectID(editingObjectID);
        this.setEmail(email);
        this.setPassword(password);
        this.setUsername(username);
        this.setRole(role);
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getEditingObjectID() {
        return editingObjectID;
    }

    public void setEditingObjectID(String editingObjectID) {
        this.editingObjectID = editingObjectID;
    }
}
