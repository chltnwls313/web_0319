package ks.hs.dgsw.web190319;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class UserServiceImpl implements UserServuce{

    List<User> userList;

    public UserServiceImpl() {
        userList = new ArrayList<>();
        userList.add(new User("usr1", "user111@dgsw","id1"));
        userList.add(new User("usr2", "user222@dgsw","id2"));
        userList.add(new User("usr3", "user333@dgsw","id3"));
    }

    @Override
    public List<User> list(){
        return this.userList;
    }

    @Override
    public User view(String id) {
        return this.userList.stream()
                .filter(user -> user.getName().equals(id))
                .findAny()
                .orElse(null);
    }
    public User find1(String name){
        Iterator<User> userIterator = this.userList.iterator();
        while (userIterator.hasNext()){
            User user = userIterator.next();
            if (user.getName().equals(name))
                return user;
        }
        return null;
    }
    public User find2(String name){
        for(User user : this.userList){
            if (user.getName().equals(name))
                return user;
        }
        return null;
    }
    public User find3(String name){
        User found = this.userList.stream()
                .filter(user -> user.getName().equals(name))
                .findAny()
                .orElse(null);
        return found;
    }

    @Override
    public boolean add(User user){
        return this.userList.add(user);
    }

    @Override
    public User update(User user){
        User found = this.view(user.getId());
        if (found != null)
            found.setEmail(user.getEmail());
        return found;
    }
    @Override
    public boolean delete(String id){
        User found = this.view(id);
        return  this.userList.remove(found);
    }
}
//GET(read) POST(insert) PUT(update) DELETE(delete)
//CRUD Create Read Update Delete
//SQL  insert select update delete