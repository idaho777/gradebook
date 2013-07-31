package model.grading.scheme;

import java.util.Collection;

import model.grading.Gradable;
import model.grading.GradebookItem;

/**
 * GradingScheme interface Implementation
 * Interface for future GradingSchemes.
 * @author Joonho
 */
public interface GradingScheme {

    <T extends Gradable> double getNumGrade(Collection<T> gradables);
    double getStuNumGrade(Collection<GradebookItem> items);
    char getLetterGrade(Gradable grading);
}
