package ooss;

import java.text.MessageFormat;
import java.util.Objects;

public class Klass {
    private final int id;
    private Student classLeader;

    private Teacher teacher;

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Student getClassLeader() {
        return classLeader;
    }

    public void setClassLeader(Student classLeader) {
        this.classLeader = classLeader;
    }

    public Klass(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Klass klass = (Klass) o;
        return id == klass.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public boolean isLeader(Student tom) {
        if (tom.getKlass() != null) {
            if (tom.getKlass().equals(this)) {
                return tom.equals(this.getClassLeader());
            }
        }
        return false;
    }

    public void assignLeader(Student tom) {
        if(tom.getKlass()==this) {
            this.setClassLeader(tom);
            String message = MessageFormat.format("I am {0}, teacher of Class {1}. I know {2} become Leader.",teacher.getName(),id,tom.getName());
            System.out.println(message);
        }
        else System.out.println("It is not one of us.");
    }

    public void attach(Teacher jerry) {
        setTeacher(jerry);
    }
}
