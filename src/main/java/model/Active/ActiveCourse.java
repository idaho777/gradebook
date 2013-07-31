package model.Active;

import java.util.Collection;
import model.Course;

/**
 * Active Course implementation for Course storage
 * @author Joonho
 */
public abstract class ActiveCourse extends Course {

    public ActiveCourse(String subject, int courseNum, String name,
            Collection<Course> preReq) {
        super(subject, courseNum, name, preReq);
    }

    public abstract Course createNew(String subject, int courseNum,
            String name, Collection<Course> preReq);

    public abstract Course findById(int courseNum);

    public abstract void save();
}
