package ks.hs.dgsw.web190319;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserServuce userServuce;

    @GetMapping("/user")
    @ResponseBody
    public List<User> list() {
        return this.userServuce.list();
   }
   @GetMapping("/user/{name}")
   @ResponseBody
    public User view(@PathVariable String id){
        return this.userServuce.view(id);
   }
   @PostMapping("/user")
   @ResponseBody
    public boolean add(@RequestBody User user){
        return this.userServuce.add(user);
   }
    @PutMapping("/user")
    @ResponseBody
    public User update(@RequestBody User user){
        return this.userServuce.update(user);
    }
    @DeleteMapping("/user/{name}")
    @ResponseBody
    public boolean delete(@PathVariable String name){
        return  this.userServuce.delete(name);
    }
}
