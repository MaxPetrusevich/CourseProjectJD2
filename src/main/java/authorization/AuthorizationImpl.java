package authorization;



import dao.impl.DaoUserImpl;
import dao.interfaces.Dao;
import entities.User;
import lombok.SneakyThrows;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class AuthorizationImpl implements Authorization {
    public static final String EMAIL = "Email";
    public static final String PASSWORD = "Password";
    public static final String NAME = "Name";
    private final Dao dao = new DaoUserImpl();

    @SneakyThrows
    @Override
    public void signIn(HttpServletRequest req) {
        List<User> users = dao.findAll(new User());
        String email = req.getParameter(EMAIL);
        String password = req.getParameter(PASSWORD);
        for (User user :
                users) {
            if (user.getEmail().compareTo(email) == 0) {
                if (user.getPassword().compareTo(password) == 0) {
                    req.setAttribute("status", "Auto");
                    req.setAttribute("role", user.isRole() ? "Admin" : "User");
                    return;
                }
            }
        }
        req.setAttribute("status", "NoAuto");
    }

    @SneakyThrows
    @Override
    public void registration(HttpServletRequest req) {
        String name = req.getParameter(NAME);
        String email = req.getParameter(EMAIL);
        String password = req.getParameter(PASSWORD);
        boolean role = false;
        User user = User.builder().username(name).email(email).password(password).role(role).build();
        dao.save(user);
        req.setAttribute("status", "Auto");
        req.setAttribute("users", dao.findAll(new User()));

    }

}
