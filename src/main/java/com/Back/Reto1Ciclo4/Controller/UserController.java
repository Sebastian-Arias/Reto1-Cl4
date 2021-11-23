package com.Back.Reto1Ciclo4.Controller;

import com.Back.Reto1Ciclo4.Entity.User;
import com.Back.Reto1Ciclo4.Service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Home
 */
@RestController
@RequestMapping("/api/user")
@CrossOrigin("*")            //<--Para no tener problemas al enlazarlo con el backend
public class UserController {
    
    @Autowired
    private UserService UserController;
    
    @GetMapping("/all")
    public List<User> getAll() {
        return UserController.getAll();
    }
    
    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public User registrar(@RequestBody User user) {
        return UserController.registrar(user);
    }
    
    @GetMapping("/{email}/{password}")
    public User autenticarUsuario(@PathVariable("email") String email, @PathVariable("password") String password) {
        return UserController.autenticarUsuario(email, password);
    }

    @GetMapping("/{email}")
    public boolean existeEmail(@PathVariable("email") String email) {
        return UserController.existeEmail(email);
    }  
}
