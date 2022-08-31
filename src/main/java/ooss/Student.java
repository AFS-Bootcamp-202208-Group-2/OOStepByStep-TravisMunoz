package ooss;

import java.text.MessageFormat;

public class Student extends Person {

    private Klass klass;

    public Klass getKlass() {
        return klass;
    }

    public void setKlass(Klass klass) {
        this.klass = klass;
    }

    public Student(int id, String name, int age) {
        super(id, name, age);
    }

    public String introduce() {
        String message = MessageFormat.format("My name is {0}. I am {1} years old. I am a student.", super.getName(), super.getAge());
        if (this.getKlass() !=null)
        {
            message += " I am in class " + this.getKlass().getId()+".";
        }
        return message;
    }




    public boolean isIn(Klass klass) {
        return klass.equals(this.getKlass());
    }

    public void join(Klass klass) {
        this.setKlass(klass);
    }
}
