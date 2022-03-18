package shoppingplateform.Store;

import org.springframework.data.repository.CrudRepository;
import shoppingplateform.StoreOwner.StoreOwner;

import java.util.Optional;

public interface StoreRepository extends CrudRepository<Store, Integer> {
    public Optional<Store> findByName(String name);

}
