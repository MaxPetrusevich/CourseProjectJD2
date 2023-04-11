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
    public static final String STATUS = "status";
    public static final String AUTO = "Auto";
    public static final String ROLE = "role";
    public static final String ADMIN = "Admin";
    public static final String USER = "User";
    public static final String NO_AUTO = "NoAuto";
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
                    req.setAttribute(STATUS, AUTO);
                    req.setAttribute(ROLE, user.isRole() ? ADMIN : USER);
                    return;
                }
            }
        }
        req.setAttribute(STATUS, NO_AUTO);
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
        req.setAttribute(STATUS, AUTO);

    }

}
