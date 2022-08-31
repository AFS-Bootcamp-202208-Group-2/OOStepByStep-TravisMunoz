package ooss;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Klass {
    private final int id;
    private Student classLeader;

    private Teacher teacher;

    public Student getStudentWatch() {
        return studentWatch;
    }

    public void setStudentWatch(Student studentWatch) {
        this.studentWatch = studentWatch;
    }

    private Student studentWatch;


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
        if (tom.getKlass() == this) {
            this.setClassLeader(tom);
            if (teacher != null) {
                String message = MessageFormat.format("I am {0}, teacher of Class {1}. I know {2} become Leader.", teacher.getName(), id, tom.getName());
                System.out.println(message);
            }
            if (studentWatch != null) {
                String message = MessageFormat.format("I am {0}, student of Class {1}. I know {2} become Leader.", studentWatch.getName(), id, tom.getName());
                System.out.println(message);
            }

        } else System.out.println("It is not one of us.");
    }

    public void attach(Teacher jerry) {
        setTeacher(jerry);
    }

    public void attach(Student student) {
        setStudentWatch(student);
    }
}
