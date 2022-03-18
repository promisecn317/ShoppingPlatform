package shoppingplateform.Admin;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface AdminRepository extends CrudRepository<Admin, Integer> {
    public Optional<Admin> findByUsername(String username);
    public Optional<Admin> findByEmail(String email);
}
