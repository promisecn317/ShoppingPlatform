package shoppingplateform.StoreOwner;

import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface StoreOwnerRepository extends CrudRepository<StoreOwner, Integer> {

    public Optional<StoreOwner> findByUsername(String username);
    public Optional<StoreOwner> findByEmail(String email);

}
