package model.grading;

/**
 * GradebookItem Implementation
 * Actual Item or Assignment for a student
 * @author Joonho
 */
public class GradebookItem {
    private static final double DEFAULTTOTAL = 100.0;

    private String itemName;
    private double grade, earned, total;
    private GradebookCategory category;


    public GradebookItem(String itemName, GradebookCategory category) {
        this(itemName, 0.0, DEFAULTTOTAL, category);
    }

    public GradebookItem(String itemName, double earned, double total,
            GradebookCategory category) {
        this.itemName = itemName;
        this.earned = earned;
        this.total = total;
        this.grade = earned / total;
        this.category = category;
    }

    public double getGrade() {
        return grade * DEFAULTTOTAL;
    }

    public double getEarned() {
        return earned;
    }

    public double getTotal() {
        return total;
    }

    public GradebookCategory getCategory() {
        return category;
    }
}
