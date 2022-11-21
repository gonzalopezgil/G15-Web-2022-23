package java.com.uah.gestion_de_practicas.model;

import org.springframework.annotation.Entity;
import org.springframework.annotation.Table;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.GeneratedValue;

/**
* User class, represents a user in the database.
* @attribute id, the id of the user.
* @attribute username, the username of the user.
* @attribute password, the password of the user.
* @attribute first_name, the first name of the user.
* @attribute last_name, the last name of the user.
* @attribute email, the email of the user.
*/
@Entity
@Table(name = "usuarios")
public class User {
    
    private Long id;
    private String username;
    private String password;
    private String first_name;
    private String last_name;
    private String nif;
    private String email;
    
    /**
    Empty constructor needed for Hibernate.
    */
    public User() {
    }

    // ----------------- GETTERS -----------------
    /**
    * Get the id of the user, this is the primary key of the user. Whose id is auto-generated in the database by the Identity strategy.
    * @return the id of the user.
    */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getNif() {
        return nif;
    }

    public String getEmail() {
        return email;
    }

    // ----------------- SETTERS -----------------
    public void setId(Long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // ----------------- TO STRING -----------------
    @Override
    public String toString() {
        return "User{" + "id=" + id + ", username=" + username + ", password=" + password + ", first_name=" + first_name + ", last_name=" + last_name + ", nif=" + nif + ", email=" + email + '}';
    }
}