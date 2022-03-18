package shoppingplateform.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/Product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/addProductToSystem",method = RequestMethod.POST)
    void addProduct(HttpServletRequest request, Model model){
        Product product = new Product(request.getParameter("name"),
                Double.parseDouble(request.getParameter("price")),
                request.getParameter("category"),
                request.getParameter("brandName"),
                request.getParameter("type"));
        productService.addProduct(product);
    }

}
