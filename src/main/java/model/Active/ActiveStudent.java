package model.Active;

import model.Section;
import model.Student;

/**
 * Active Student implementation for Student storage
 * @author Joonho
 */
public abstract class ActiveStudent extends Student {

    public ActiveStudent(String name, Section section) {
        super(name, section);
    }

    public abstract Student createNew(String name, Section section);

    public abstract Student findById(String id);

    public abstract void save();
}
