package controller;

import view.View;

import java.util.Map;

public abstract class Controller {
    String view(String name, Map<String, Object> args){
        try {
            Class<?> view_definition = Class.forName("view."+name);
            View view = (View) view_definition.newInstance();
            return  view.getAction();
        }catch (ClassNotFoundException e){
            System.out.println("Error: could not find view " + name);
            return "exit";
        } catch (InstantiationException | IllegalAccessException e) {
            System.out.println("Error: could not create instance of " + name);
            return "exit";
        }
    }
    String view(String name){
        return view(name, null);
    }
}
