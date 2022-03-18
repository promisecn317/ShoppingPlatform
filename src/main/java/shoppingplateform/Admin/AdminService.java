package shoppingplateform.Admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    public boolean login(Admin adm) {
        Optional<Admin> admin=adminRepository.findByUsername(adm.getUsername());
        if(admin.isPresent()){
            if(admin.get().getPassword().equals(adm.getPassword()))
                return true;
        }else{
            admin=adminRepository.findByEmail(adm.getUsername());
            if(admin.isPresent()){
                if(admin.get().getPassword().equals(adm.getPassword()))
                    return true;
            }
        }
        return false;
    }
}
