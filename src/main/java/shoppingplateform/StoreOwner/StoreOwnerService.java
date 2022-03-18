package shoppingplateform.StoreOwner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shoppingplateform.Store.Store;
import shoppingplateform.Store.StoreRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StoreOwnerService {

    @Autowired
    private StoreOwnerRepository storeOwnerRepository;
    @Autowired
    private StoreRepository storeRepository;

    public boolean login(String usernameEmail,String password) {
        Optional<StoreOwner> storeOwner=storeOwnerRepository.findByUsername(usernameEmail);
        if(storeOwner.isPresent()){
            if(storeOwner.get().getPassword().equals(password))
                return true;
        }else{
            storeOwner=storeOwnerRepository.findByEmail(usernameEmail);
            if(storeOwner.isPresent()){
                if(storeOwner.get().getPassword().equals(password))
                    return true;
            }
        }
        return false;
    }

    public boolean register(StoreOwner storeOwner) {
        if(!storeOwnerRepository.findByUsername(storeOwner.getUsername()).isPresent()){
            storeOwnerRepository.save(storeOwner);
            return true;
        }
        return false;
    }

    public boolean addStore(Store store){
        if(!storeRepository.findByName(store.getName()).isPresent()){
            storeRepository.save(store);
            return true;
        }
        else return false;
    }

    public List<StoreOwner> getAll(){
        List<StoreOwner> storeOwners=new ArrayList<>();
        storeOwnerRepository.findAll().forEach(storeOwners::add);
        return storeOwners;
    }

}
