package shoppingplateform.Admin;

import shoppingplateform.User.User;

import javax.persistence.Entity;

@Entity
public class Admin extends User {

    public Admin() {
    }

    public Admin(String username, String password, String firstname, String lastname, String email) {
        super(username, password, firstname, lastname, email);
    }
}
