package isa.projekat.booking.domain.dto;

public class UserDTO {

    private String email;
    private String password;

    public UserDTO() {

    }

    public UserDTO(String username, String password) {
        this.setPassword(password);
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
}
