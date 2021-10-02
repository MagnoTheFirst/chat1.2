package com.example.chatdemo.services;

import com.example.chatdemo.model.Dice;
import com.example.chatdemo.model.User;
import com.example.chatdemo.model.UserAccount;
import com.example.chatdemo.repos.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userrepo;

    public UserService(UserRepository userrepo){this.userrepo =userrepo;}

    public List<UserAccount> getUsers(){return userrepo.findAll(); }

    //public Optional<User> getUserByEmail(String email){ return userrepo.findByName(email);}


    public boolean checkIfUserExists(String email){
        List<UserAccount> users = getUsers();
        for(int i = 0; i < users.size(); i++){
            if(users.get(i).getEmail().equals(email)){
                return true;
            }
            else if(users.get(i).getEmail() == null){
                return false;
            }
            else{
                return false;
            }

        }
        return false;
    }

    public boolean addNewUser(UserAccount user){
        if(checkIfUserExists(user.getEmail()))
        {
            return true;
        }
        else{
            userrepo.saveAndFlush(user);
            return false;
        }
    }
}
