package boot.learn;

import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.HandlesTypes;
import java.util.Set;

/**
 * @author machenggong
 * @date 2020/12/03
 */
public class MyServletInitializer implements ServletContainerInitializer {

    public void onStartup(Set<Class<?>> set, ServletContext servletContext) throws ServletException {
        System.out.println(set);
    }
}
