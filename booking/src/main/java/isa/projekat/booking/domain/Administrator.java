package isa.projekat.booking.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("Administrators")
public class Administrator {

    @Id
    private String username;
    private String email;
    private String password;
    private String newPassword;
    private AdministatorType type;
    private boolean activated;
    private boolean changedPass;
//    mozda lista objekata
    private String editingObjectID; 

    public Administrator() {

    }

    public Administrator(String username, String email, String password, AdministatorType type) {
        this.setEmail(email);
        this.setPassword(password);
        this.setUsername(username);
        this.setType(type);
    }

    public Administrator(String username, String email, String password, String newPassword, AdministatorType type,
			boolean activated, boolean changedPass, String editingObjectID) {
		super();
		this.username = username;
		this.email = email;
		this.password = password;
		this.newPassword = newPassword;
		this.type = type;
		this.activated = activated;
		this.changedPass = changedPass;
		this.editingObjectID = editingObjectID;
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

    public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
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
    
	public boolean isActivated() {
		return activated;
	}

	public void setActivated(boolean activated) {
		this.activated = activated;
	}

	public boolean isChangedPass() {
		return changedPass;
	}

	public void setChangedPass(boolean changedPass) {
		this.changedPass = changedPass;
	}
}
