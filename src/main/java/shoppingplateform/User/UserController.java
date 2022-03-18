package shoppingplateform.User;

import org.apache.catalina.connector.Response;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URL;

@RestController
public class UserController {

    @RequestMapping("/x")
    String login(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String type = request.getParameter("user");
        switch (type){
            case "admin":{
                response.sendRedirect("/Admin/login");
                return "Admin";
            }
        }

        return "s";
    }
}
