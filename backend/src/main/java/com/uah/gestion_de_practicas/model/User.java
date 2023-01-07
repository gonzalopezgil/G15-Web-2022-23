package com.uah.gestion_de_practicas.model;

import java.util.Objects;

import javax.persistence.*;

/**
* User class, represents a user in the database.
*/
@Entity
@Table(name = "usuario")
@Inheritance(strategy = InheritanceType.JOINED)
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

    /**
     * Constructor for the User class.
     * @param username, the username of the user.
     * @param password, the password of the user.
     * @param first_name, the first name of the user.
     * @param last_name, the last name of the user.
     * @param nif, the nif of the user.
     * @param email, the email of the user.
     */
    public User(String username, String password, String first_name, String last_name, String nif, String email) {
        this.username = username;
        this.password = password;
        this.first_name = first_name;
        this.last_name = last_name;
        this.nif = nif;
        this.email = email;
    }

    // ----------------- GETTERS -----------------
    /**
    * Get the id of the user, this is the primary key of the user. Whose id is auto-generated in the database by the Identity strategy.
    * @return the id of the user.
    */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    public Long getId() {
        return id;
    }

    /**
    * Get the username of the user.
    */
    @Column(name = "nombre_usuario")
    public String getUsername() {
        return username;
    }

    /**
    * Get the password of the user, as it is saved in the database, not unencrypted.
    */
    @Column(name = "contrasena")
    public String getPassword() {
        return password;
    }

    /**
    * Get the first name of the user.
    */
    @Column(name = "nombre")
    public String getFirstName() {
        return first_name;
    }

    /**
    * Get the last name of the user.
    */
    @Column(name = "apellidos")
    public String getLastName() {
        return last_name;
    }

    /**
    * Get the nif of the user.
    */
    @Column(name = "DNI")
    public String getNif() {
        return nif;
    }

    /**
    * Get the email of the user.
    */
    @Column(name = "correo")
    public String getEmail() {
        return email;
    }

    // ----------------- SETTERS -----------------
    /**
    * Set the id of the user, with the restriction that it cannot be repeated.
    */
    public void setId(Long id) {
        this.id = id;
    }

    /**
    * Set the username of the user.
    */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
    * Set the password of the user.
    */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
    * Set the first name of the user.
    */
    public void setFirstName(String first_name) {
        this.first_name = first_name;
    }

    /**
    * Set the last name of the user.
    */
    public void setLastName(String last_name) {
        this.last_name = last_name;
    }

    /**
    * Set the nif of the user.
    */
    public void setNif(String nif) {
        this.nif = nif;
    }

    /**
    * Set the email of the user.
    */
    public void setEmail(String email) {
        this.email = email;
    }

    // ------------------ EQUALS ------------------
    /**
     * Compares this user to the specified object. The result is true if and only if the argument is not null and is a User object that represents the same user as this object.
     * 
     * @param obj the object to compare this User against.
     * @return true if the given object represents a User equivalent to this user, false otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof User)) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(id, user.id) && Objects.equals(username, user.username) && Objects.equals(password, user.password) && Objects.equals(first_name, user.first_name) && Objects.equals(last_name, user.last_name) && Objects.equals(nif, user.nif) && Objects.equals(email, user.email);
    }

    /**
     * Returns a hash code for this user.
     */
    @Override
    public int hashCode() {
        return Objects.hash(id, username, password, first_name, last_name, nif, email);
    }
   

    // ----------------- TO STRING -----------------
    /**
    * Returns a string representation of the user.
    * @return user to string.
    */
    @Override
    public String toString() {
        return "User{" + "id=" + id + ", username=" + username + ", password=" + password + ", first_name=" + first_name + ", last_name=" + last_name + ", nif=" + nif + ", email=" + email + '}';
    }
}