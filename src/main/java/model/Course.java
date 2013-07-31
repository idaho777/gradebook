package model;

import java.util.ArrayList;
import java.util.Collection;

import model.grading.Gradable;
import model.grading.scheme.DefaultGradingScheme;

/**
 * Course Implementation
 * Holds instances of Classes and Prerequisite Courses
 * @author Joonho
 */
public class Course implements Gradable {
    private String subject, name;
    private Collection<Course> preReq;
    private Collection<Class> classes;
    private int courseNum;

    public Course(String subject, int courseNum, String name) {
        this.subject = subject;
        this.courseNum = courseNum;
        this.name = name;
        preReq = new ArrayList<>();
        classes = new ArrayList<>();
    }

    public Course(String subject, int courseNum, String name,
            Collection<Course> preReq) {
        this(subject, courseNum, name);
        this.preReq = preReq;
    }

    public void addPreReq(Course preCourse) {
        if (!preReq.contains(preCourse)) {
            preReq.add(preCourse);
        }
    }

    public void addClasses(Class classe) {
        if (!classes.contains(classe)) {
            classes.add(classe);
        }
    }

    @Override
    public double calculateAverage() {
        return new DefaultGradingScheme().getNumGrade(classes);
    }

    @Override
    public char calculateLetter() {
        return new DefaultGradingScheme().getLetterGrade(this);
    }

    public String getSubject() {
        return subject;
    }

    public String getName() {
        return name;
    }

    public Collection<Course> getPreReq() {
        return preReq;
    }

    public Collection<Class> getClasses() {
        return classes;
    }

    public int getCourseNum() {
        return courseNum;
    }
}
