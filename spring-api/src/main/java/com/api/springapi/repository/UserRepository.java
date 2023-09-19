package com.api.springapi.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.api.springapi.model.User;

@Repository
public class UserRepository {
    public void save(User user){
        if(user.getId() == null){
            System.out.println("SAVE - Rcebendo o usuário na camada de repositorio");
        }
        else{
            System.out.println("UPDATE - Rcebendo o usuário na camada de repositorio");
        }

        System.out.println(user);
    }
    public void deleteById(Integer id){
        System.out.println(String.format("DELETE/id - Recebendo o id: %d para excluir o um usuário", id));
        System.out.println(id);
    }
    public List<User> findAll(){
        System.out.println("LIST - Listando os usuários do sistema");
        List<User> users = new ArrayList<>();
        users.add(new User("Vinícius", "123"));
        users.add(new User("Vinícius1", "123"));
        return users;
    }
    public User findById(Integer id){
        System.out.println(String.format("FIND/id - Recebendo o id: %d para localizar um usuário", id));
        return new User("Vinícius", "123");
    }
    public User findByUsername(String username){
        System.out.println(String.format("FIND/username - Recebendo o username: %s para localizar um usuário", username));
        return new User("Vinícius", "123");
    }
}
