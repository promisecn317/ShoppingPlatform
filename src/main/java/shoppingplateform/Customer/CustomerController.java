package shoppingplateform.Customer;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/Customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    void login(@RequestBody Customer customer) {
        String usernameEmail = customer.getUsername();
        String password = customer.getPassword();
        customerService.login(usernameEmail, password);
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    void register(@RequestBody Customer customer) {
         customerService.register(customer);
    }


    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public List<Customer> getAll() {
        return customerService.getAll();
    }
}



