package ooss;

import java.util.Objects;

public class Klass {
    private final int id;
    private Student classLeader;

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
}
