package gera.alencar.workshopmongodb.dto;

import gera.alencar.workshopmongodb.domain.User;

import java.io.Serializable;

public class UserDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String id;
    private String Name;
    private String Email;

    public UserDTO() {}

    public UserDTO(User obj) {
        id = obj.getId();
        Name = obj.getName();
        Email = obj.getEmail();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }
}
