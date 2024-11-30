package com.example.Spring.Data;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Data
@RequestMapping("/persons")
public class UserController
{
    @Autowired
    UserService userService;

    @GetMapping("/add/{firstname}/{lastname}")
    public String addUser(@PathVariable String firstname, @PathVariable String lastname)
    {
        userService.addUser(new User(firstname,lastname));
        return "User " + firstname + " was added";
    }

    @GetMapping("/get/{id}")
    public String getUserById(@PathVariable long id)
    {
        return userService.getUserById(id).toString();
    }

    @GetMapping("/delete/{id}")
    public String deleteUserById(@PathVariable long id)
    {
        String result = userService.getUserById(id).toString();
        userService.deleteUserById(id);
        return result + " was deleted";

    }

    @GetMapping("/update/{id}/{firstname}")
    public String addUser(@PathVariable long id, @PathVariable String firstname)
    {
        String oldName = userService.getUserById(id).getFirstname();
        userService.updateFirstname(firstname,id);
        return "name " + oldName + " was changed to " + firstname;
    }


}
