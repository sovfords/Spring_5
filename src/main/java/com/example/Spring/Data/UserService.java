package com.example.Spring.Data;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Data
public class UserService
{
    @Autowired
    UserRepository repository;

    public void addUser(User user)
    {
        repository.save(user);
    }

    public User getUserById(long id)
    {
        return repository.findById(id).get();
    }

    public void updateFirstname(String name,long id)
    {
        User user = getUserById(id);
        user.setFirstname(name);
        addUser(user);
    }

    public void deleteUserById(long id)
    {
        repository.deleteById(id);
    }





}
