package shoppingplateform.Customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public boolean login(String usernameEmail,String password) {
        Optional<Customer> customer=customerRepository.findByUsername(usernameEmail);
        if(customer.isPresent()){
            if(customer.get().getPassword().equals(password))
                return true;
        }else{
            customer=customerRepository.findByEmail(usernameEmail);
            if(customer.isPresent()){
                if(customer.get().getPassword().equals(password))
                    return true;
            }
        }
        return false;
    }

    public boolean register(Customer customer) {
        if(!customerRepository.findByUsername(customer.getUsername()).isPresent()){
            customerRepository.save(customer);
            return true;
        }
        return false;
    }

    public List<Customer> getAll(){
        List<Customer> customers=new ArrayList<>();
        customerRepository.findAll().forEach(customers::add);
        return customers;
    }

}
