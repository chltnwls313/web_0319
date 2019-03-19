package ks.hs.dgsw.web190319;

import java.util.List;

public interface UserServuce {

    List<User> list();
    User view(String name);
    boolean add(User user);
    User update(User user);
    boolean delete(String name);
}
