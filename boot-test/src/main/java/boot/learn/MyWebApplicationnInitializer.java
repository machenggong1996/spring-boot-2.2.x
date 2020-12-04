package boot.learn;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * @author machenggong
 * @date 2020/12/03
 */
public class MyWebApplicationnInitializer implements WebApplicationInitializer {

    /**
     * tomcat 启动可以执行 WebApplicationInitializer#onStartup方法
     * @param servletContext
     * @throws ServletException
     */
    public void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext applicationContext = new AnnotationConfigWebApplicationContext();
        applicationContext.register(AppConfig.class);
        applicationContext.refresh();
        DispatcherServlet dispatcherServlet = new DispatcherServlet(applicationContext);
        ServletRegistration.Dynamic registration = servletContext.addServlet("xx",dispatcherServlet);
        registration.addMapping("*.do");
        registration.setLoadOnStartup(1);
    }
}
