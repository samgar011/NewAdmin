package com.example.newadmin.user;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepo wp;

    public List<User>listAll(){
        return (List<User>) wp.findAll();
    }

    public void save(User user) {
        wp.save(user);
    }

    public User get(Integer id) throws UserNotFoundException {
        Optional<User> result = wp.findById(id);

        if(result.isPresent()){
            return result.get();

        }
        throw new UserNotFoundException("There is no such user found with Id" + id);
    }

    public void delete(Integer id) throws UserNotFoundException {
        Long count = wp.countById(id);
        if(count == null || count == 0){
            throw new UserNotFoundException("There is no such user found with Id" + id);

        }
        wp.deleteById(id);

    }
//    public List <User> findbyKeyWord(String keyword){
//
//        return (List<User>) wp.findbyKeyWord(keyword);
//    }
}

