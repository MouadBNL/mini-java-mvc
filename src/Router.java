import controller.Controller;
import controller.IndexController;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class Router {

    public Router() {
    }

    public static String run(String action) {
        String controller_name = action.split("@")[0];
        String method_name = action.split("@")[1];
//        Controller controllerInstance = routes.get("IndexController");
        try {
            Class<?> controller_definition = Class.forName("controller."+controller_name);
            Controller controller = (Controller) controller_definition.newInstance();
            Method m = controller.getClass().getMethod(method_name);
            return (String) m.invoke(controller);
        }
        catch (ClassNotFoundException e){
            System.out.println("Error: Could not find class controller."+controller_name);
            System.out.println(e.getMessage());
            return "exit";
        } catch (Exception e) {
            System.out.println("Error: Method "+method_name+" not found on class controller."+controller_name);
            e.printStackTrace();
        }
        return "exit";
    }
}
