package boot.learn;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.WebResourceRoot;
import org.apache.catalina.startup.Tomcat;
import org.apache.catalina.webresources.DirResourceSet;
import org.apache.catalina.webresources.StandardRoot;

/**
 * @author machenggong
 * @date 2020/12/03
 */
public class MySpringApplication {

    public static void run() {
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(9080);
        String sourcePath = MySpringApplication.class.getResource("/").getPath();

        Context context = tomcat.addWebapp("", "");
        WebResourceRoot resources = new StandardRoot(context);
        resources.addPreResources(new DirResourceSet(resources,"/WEB-INF/classes",sourcePath,"/"));
        context.setResources(resources);
    try {
            tomcat.start();
        } catch (LifecycleException e) {
            e.printStackTrace();
        }
    }

}
