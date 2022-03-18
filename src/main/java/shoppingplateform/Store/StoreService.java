package shoppingplateform.Store;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shoppingplateform.Product.Product;
import shoppingplateform.Product.ProductRepository;

import java.util.ArrayList;

@Service
public class StoreService {
    private ArrayList<Product> products = new ArrayList<>();
    @Autowired
    private ProductRepository productRepository;

    public boolean addProduct(Integer id){
        Product product = productRepository.findById(id).get();
        if(product != null){
            products.add(product);
            return true;
        }
        return false;
    }

}
