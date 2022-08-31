package ooss;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

public class Teacher extends Person{

    List<Klass> klassList = new ArrayList<>();
    public List<Klass> getKlassList() {
        return klassList;
    }

    public void setKlassList(Klass klass) {
        this.klassList.add(klass);
    }

    public Teacher(int id, String name, int age) {
        super(id, name, age);
    }

    public String introduce() {
        return MessageFormat.format("My name is {0}. I am {1} years old. I am a teacher." ,super.getName(),super.getAge());
    }

    public boolean belongsTo(Klass klass) {
        return this.getKlassList().contains(klass) ;
    }

    public void assignTo(Klass klass) {
        setKlassList(klass);
    }

}
