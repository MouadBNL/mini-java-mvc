# Mini MVC framework using Java

This the project contains the necessary components needed to create a simple MVC console app.

## Router
The router is called on the Main class, and is responsible for the calling the right controller with the right method.
```java
Router.run("IndexController@index");
```

## Controller
The controller is responsible for any data processing / user input. and returning either a route name or a view that shows the data and itself will call another route.
```java
class IndexController extends Controller {
    public String index() {
        return view("IndexView");
    }
}
```


## View 
The view is a CLI app, where the user is presented with a menu, and asked to choose an action. the action chosen is then returned as a route name and the route is called.
the view creation is as simple as adding items to the view, and specifying which route to return if the item was selected

```java
class IndexView extends View{
    public IndexView() {
        super("Index"); // View name that will appear in the console.
        addMenuItem("Action Etudiant", "EtudiantController@index");
        addMenuItem("Action Bibliotheque", "LibraryController@index");
    }
}
```

## Model
The model are responsible for the interaction with the database.
```java
class Etudiant extends Model{
    // Declaration of attributes
    private String nom;
    // getters & setters
    
    // Overriding the CRUD operations
    @Override
    public boolean create() {
        try {
            PreparedStatement create_statement = this.conn.prepareStatement("INSERT INTO etudiants(nom, cne, note, tel) VALUES (?,?,?,?);");
            create_statement.setString(1, this.nom);
            create_statement.setString(2, this.cne);
            create_statement.setFloat(3, this.note);
            create_statement.setString(4, this.tel);

            create_statement.execute();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
```