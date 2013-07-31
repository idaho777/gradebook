package model.Active;

import model.Class;
import model.Course;
import model.grading.scheme.GradingScheme;

/**
 * Active Class implementation for Class storage
 * @author Joonho
 */
public abstract class ActiveClass extends Class {

    public ActiveClass(String name, String semester, Course classCourse,
            GradingScheme customScheme) {
        super(name, semester, classCourse, customScheme);
    }

    public abstract Class createNew(String name, String semester,
            Course classCourse, GradingScheme customScheme);

    public abstract Class findById(String id);  //name+semester

    public abstract void save();
}
