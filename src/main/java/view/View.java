package view;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public abstract class View {
    protected class ViewAction {
        public String action_description;
        public String action_route;
        public ViewAction(String desc, String route){
            this.action_description = desc;
            this.action_route = route;
        }
    }
    protected List<ViewAction> actions;
    protected String view_name;

    protected View(String name) {
        view_name = name;
        actions = new ArrayList<ViewAction>();
        addMenuItem("Quiter", "exit");
    }

    protected void addMenuItem(String description, String route){
        actions.add(new ViewAction(description, route));
    }
    private void printMenu() {
        System.out.println(view_name + " Menu:");
        for(int i = 0; i < actions.size(); i++){
            System.out.println((i)+": " + actions.get(i).action_description);
        }
        System.out.println();
//        System.out.println(actions);
    }
    public String getAction() {
        printMenu();

        Scanner sc = new Scanner(System.in);
        int action_idx = sc.nextInt();
        sc.nextLine();
        if(action_idx == 0) return "exit";
        return actions.get(action_idx).action_route;
    }
}
