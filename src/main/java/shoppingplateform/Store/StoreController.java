package shoppingplateform.Store;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/Store")
public class StoreController {
    @Autowired
    private StoreService storeService;

    @RequestMapping(value = "/addProduct",method = RequestMethod.POST)
    String addProduct(HttpServletRequest request){
        Integer id = Integer.parseInt(request.getParameter("id"));
        return storeService.addProduct(id)?"success":"fail";
    }
}
