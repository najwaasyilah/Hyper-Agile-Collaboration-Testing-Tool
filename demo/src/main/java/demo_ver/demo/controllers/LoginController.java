package demo_ver.demo.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;
import demo_ver.demo.model.User;
import demo_ver.demo.service.AuthService;


@Controller
public class LoginController {

   
    private final AuthService authService;

    public LoginController(AuthService authService) {
        this.authService = authService;
    }

    @GetMapping("/login")
    public String showLoginPage() {
        return "login";
    }

    // @PostMapping("/login")
    // public ResponseEntity<String> login(@RequestBody User loginUser) {
    //     String username = loginUser.getUsername();
    //     String password = loginUser.getPassword();
    //     String roleId = loginUser.getRoleId();

    //     if (loginService.validateLogin(username, password, roleId)) {

    //         return ResponseEntity.ok("Login Successful!");
    //     } else {
    //         return ResponseEntity.status(401).body("Invalid username or password or roleId");
    //     }
    // }

    @PostMapping("/login")
    public ResponseEntity<String> login(@ModelAttribute User loginUser) {
        String username = loginUser.getUsername();
        String password = loginUser.getPassword();
        String roleId = loginUser.getRoleId();

        if (authService.validateLogin(username, password, roleId)) {
            return ResponseEntity.ok("Login Successful!");
        } else {
            return ResponseEntity.status(401).body("Invalid username or password or roleId");
        }
    }

}



