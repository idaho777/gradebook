package model;

import java.util.ArrayList;
import java.util.Collection;

import model.grading.Gradable;
import model.grading.scheme.DefaultGradingScheme;

/**
 * Section Implementation
 * Part of a Class and holds instances of Students in section.
 * @author Joonho
 */
public class Section implements Gradable {
    private static int globalCount;
    private static final int COUNTMOD = 51;

    private String sectionID;
    private Class sectionClass;
    private Collection<Student> students;

    public Section(Class sectionClass) {
        this.sectionClass = sectionClass;
        this.sectionClass.addSection(this);
        students = new ArrayList<>();
        globalCount++;
        sectionID = sectionClass.getClassID() + (globalCount % COUNTMOD);
    }

    public void addStudent(Student newStu) {
        boolean canAdd = true;
        for (Section section: sectionClass.getSections()) {
            if (section.getStudents().contains((Student) newStu)) {
                canAdd = false;
            }
        }
        if (canAdd && !students.contains((Student) newStu)) {
            students.add(newStu);
        }
    }

    public void removeStudent(Student removed) {
        if (students.contains((Student) removed)) {
            students.remove(removed);
        }
    }

    @Override
    public double calculateAverage() {
        return new DefaultGradingScheme().getNumGrade(students);
    }

    @Override
    public char calculateLetter() {
        return new DefaultGradingScheme().getLetterGrade(this);
    }

    public Class getSectionClass() {
        return sectionClass;
    }

    public Collection<Student> getStudents() {
        return students;
    }

    public String getID() {
        return sectionID;
    }
}
