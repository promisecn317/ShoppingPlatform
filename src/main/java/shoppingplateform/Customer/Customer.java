package shoppingplateform.Customer;

import shoppingplateform.User.User;

import javax.persistence.Entity;

@Entity
public class Customer extends User {

    public Customer() {
    }

    public Customer(String username, String password, String firstname, String lastname, String email) {
        super(username, password, firstname, lastname, email);
    }
}
