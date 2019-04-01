package beans.web.passwordUtil;

import org.junit.Test;
import util.PasswordUtil;

public class PasswordUtilTest {

    @Test
    public void testEncode(){
        System.out.println(PasswordUtil.encode("12345"));
    }
}
