import java.util.ArrayList;

class Human {

    private String name;

    Human() {
        name = "";
    }

    Human (String name) {
        this.name = name;
    }

    void setName(String n) {
        name = n;
    }

    String getName() {
        return name;
    }

    Food eat(ArrayList<Food> fl) {
        Food f = fl.get(fl.size()-1);
        fl.remove(fl.size()-1);
        return f;
    }
}