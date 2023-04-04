import java.util.Objects;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        boolean exit = false;
        String action = "IndexController@index";
//        String action = "EtudiantController@store";
        while(!exit) {
            System.out.println("Selected action: " + action);
            if(action.equals("exit")){
                exit = true;
            } else {
                action = Router.run(action);
            }
        }
    }
}