package controller;

public class IndexController extends Controller {

    public String index() {
        return view("IndexView");
    }

    public String store() {
        System.out.println("Store method called");
        return "exit";
    }
}
