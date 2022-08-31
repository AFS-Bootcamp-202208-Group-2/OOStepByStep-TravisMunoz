package ooss;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

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
        String message =  MessageFormat.format("My name is {0}. I am {1} years old. I am a teacher." ,super.getName(),super.getAge());
        List<Integer> klasses = new ArrayList<>();
        String klassesDelimited;
        if (this.getKlassList() !=null)
        {
            message += " I teach Class ";
//            klasses=  this.getKlassList().stream().map(Klass::getId).collect(Collectors.joining(" and ")
            klasses = this.getKlassList().stream().map(Klass::getId).collect(toList());
            klassesDelimited = klasses.stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(", "));
            message += klassesDelimited +".";
        }
        return message;
    }

    public boolean belongsTo(Klass klass) {
        return this.getKlassList().contains(klass) ;
    }

    public void assignTo(Klass klass) {
        setKlassList(klass);
    }

}
