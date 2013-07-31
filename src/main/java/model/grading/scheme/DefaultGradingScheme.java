package model.grading.scheme;

import java.text.DecimalFormat;
import java.util.Collection;

import model.grading.Gradable;
import model.grading.GradebookItem;

/**
 * DefaultGradingScheme Implementation
 * Default grading scheme if none is provided.
 * @author Joonho
 */
public class DefaultGradingScheme implements GradingScheme {
    public static final double FRACTODECI = 100.0;
    public static final double A = 90.0;
    public static final double B = 80.0;
    public static final double C = 70.0;
    public static final double D = 60.0;

    private DecimalFormat format = new DecimalFormat("0.0");

    public <T extends Gradable> double getNumGrade(Collection<T> gradables) {
        int sum = 0;
        for (Gradable gradable : gradables) {
            sum += gradable.calculateAverage();
        }
        String formated = format.format(sum / gradables.size());
        return Double.parseDouble(formated);
    }

    @Override
    public double getStuNumGrade(Collection<GradebookItem> items) {
        double grade = 0.0;
        double total = 0.0;
        for (GradebookItem item: items) {
            grade += item.getCategory().getWeight() * item.getEarned();
            total += item.getCategory().getWeight() * item.getTotal();
        }
        String formated = format.format(FRACTODECI * (grade / total));
        return Double.parseDouble(formated);
    }

    public char getLetterGrade(Gradable gradable) {
        double grade = gradable.calculateAverage();
        if (grade >= A) {
            return 'A';
        } else if (grade >= B) {
            return 'B';
        } else if (grade >= C) {
            return 'C';
        } else if (grade >= D) {
            return 'D';
        } else {
            return 'F';
        }
    }
}
