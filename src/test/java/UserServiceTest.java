import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import ru.innopolis.stc9.lesson20ee2.service.UserService;

import java.sql.SQLException;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

import static junit.framework.Assert.*;

public class UserServiceTest {
    private static Logger logger = Logger.getLogger(UserServiceTest.class);
    private UserService userService;

    @Before
    public void before(){
        this.userService = new UserService();
    }

    @Test
    public void checkAuthTest(){
        assertTrue(this.userService.checkAuth("prof", "prof"));
        assertTrue(this.userService.checkAuth("stud1", "stud1"));
        assertFalse(this.userService.checkAuth("prof1", "profsdfjfg"));
    }

    @Test
    public void getRoleTest(){
        assertTrue(this.userService.getRole("prof") == 2);
        assertTrue(this.userService.getRole("stud1") == 1);
    }

    @Test
    public void getNameTest(){
        assertTrue(this.userService.getName("prof").equals("BIG INTELLECT"));
        assertTrue(this.userService.getName("stud1").equals("Ivanov"));

    }

    @Test
    public void getUserIdTest(){
        assertTrue(this.userService.getUserId("prof") == 1);
        assertTrue(this.userService.getUserId("stud1") == 2);
    }


}
