package shoppingplateform.StoreOwner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import shoppingplateform.Store.Store;


import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/StoreOwner")
public class StoreOwnerController {
    @Autowired
    private StoreOwnerService storeOwnerService;

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    String login(HttpServletRequest request, Model model){
        String usernameEmail = request.getParameter("username");
        String password = request.getParameter("password");
        return storeOwnerService.login(usernameEmail, password)?"storeOwner":"";
    }

    @RequestMapping(value = "/register",method = RequestMethod.POST)
    String register(HttpServletRequest request, Model model){
        StoreOwner storeOwner = new StoreOwner(request.getParameter("username"),
                request.getParameter("password"),
                request.getParameter("firstName"),
                request.getParameter("lastName"),
                request.getParameter("email"));
        return storeOwnerService.register(storeOwner)?"storeOwner":"";
    }

    @RequestMapping(value = "/addStore",method = RequestMethod.POST)
    String addStore(HttpServletRequest request, Model model){
        Store store = new Store(request.getParameter("name"),
                request.getParameter("address"),
                request.getParameter("type"),
                007/*to be edited later*/);
        return storeOwnerService.addStore(store) ? "success" : "failed";
    }


    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public List<StoreOwner> getAll() {
        return storeOwnerService.getAll();
    }
}
