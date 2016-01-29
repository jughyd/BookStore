package mvc.bookstore.rest;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import javax.mvc.engine.ViewEngine;
import javax.ws.rs.core.Application;
import javax.ws.rs.ApplicationPath;
import mvc.bookstore.controller.HomeController;

/**
 * 
 *  @author Rajmahendra Hegde <rajmahendra@gmail.com>
 */
@ApplicationPath("mvc")
public class RestApplication extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> s = new HashSet();
        s.add(HomeController.class);
        return s;
    }

    /**
     *
     * @return
     */
    @Override
    public Map<String, Object> getProperties() {
        final Map<String, Object> map = new HashMap<>();
     //   map.put(ViewEngine.VIEW_FOLDER, "/");
        return map;
    }

}
