package model.grading;

/**
 * Gradable interface Implementation
 * Marks Objects that are gradable.
 * @author Joonho
 */
public interface Gradable {

    double calculateAverage();
    char calculateLetter();
}
