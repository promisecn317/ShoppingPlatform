package shoppingplateform.Customer;

import org.springframework.data.repository.CrudRepository;
import java.util.Optional;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {

    public Optional<Customer> findByUsername(String username);
    public Optional<Customer> findByEmail(String email);

}
