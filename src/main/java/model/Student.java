package model;

import java.util.Collection;
import java.util.HashSet;

import model.grading.Gradable;
import model.grading.GradebookItem;
import model.grading.scheme.GradingScheme;

/**
 * Student Implementation
 * Part of only one section.
 * @author Joonho
 */
public class Student implements Gradable {
    private String name;
    private Section classSection;
    private GradingScheme gradingScheme;

    private Collection<GradebookItem> gradebookItems;


    public Student(String name, Section section) {
        this.name = name;
        classSection = section;
        classSection.addStudent(this);
        gradingScheme = section.getSectionClass().getGradingScheme();
        gradebookItems = new HashSet<>();
    }

    public void addGradebookItem(GradebookItem item) {
        if (!gradebookItems.contains((GradebookItem) item)) {
            gradebookItems.add(item);
        }
    }

    public void removeGradebookItem(GradebookItem item) {
        if (gradebookItems.contains((GradebookItem) item)) {
            gradebookItems.remove(item);
        }
    }

    @Override
    public double calculateAverage() {
        return gradingScheme.getStuNumGrade(gradebookItems);
    }

    @Override
    public char calculateLetter() {
        return gradingScheme.getLetterGrade(this);
    }

    public String getName() {
        return name;
    }

    public Section getClassSection() {
        return classSection;
    }

    public GradingScheme getGradingScheme() {
        return gradingScheme;
    }

    public Collection<GradebookItem> getGradebookItems() {
        return gradebookItems;
    }
}
