package model;

import java.util.ArrayList;
import java.util.Collection;

import model.grading.Gradable;
import model.grading.scheme.DefaultGradingScheme;
import model.grading.scheme.GradingScheme;

/**
 * Class Implementation
 * Narrower instance of a Course with Sections
 * @author Joonho
 */
public class Class implements Gradable {
    private String className, semester;
    private Course classCourse;
    private GradingScheme gradingScheme;
    private String classID;

    private Collection<Section> sections;

    public Class(String name, String semester, Course classCourse) {
        this(name, semester, classCourse, new DefaultGradingScheme());
    }

    public Class(String name, String semester, Course classCourse,
            GradingScheme customScheme) {
        this.classCourse = classCourse;
        this.semester = semester;
        this.className = name;
        this.gradingScheme = customScheme;
        this.sections = new ArrayList<>();
        classID = className.concat(semester);
        classCourse.addClasses(this);
    }

    public void addSection(Section section) {
        if (!sections.contains(section)) {
            sections.add(section);
        }
    }

    @Override
    public double calculateAverage() {
        return new DefaultGradingScheme().getNumGrade(sections);
    }

    @Override
    public char calculateLetter() {
        return new DefaultGradingScheme().getLetterGrade(this);
    }
    public String getClassName() {
        return className;
    }

    public String getSemester() {
        return semester;
    }

    public Course getClassCourse() {
        return classCourse;
    }

    public GradingScheme getGradingScheme() {
        return gradingScheme;
    }

    public Collection<Section> getSections() {
        return sections;
    }

    public String getClassID() {
        return classID;
    }
}
