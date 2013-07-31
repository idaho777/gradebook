package model.grading;

/**
 * GradebookCategory Implementation
 * Category for certain GradebookItems. ex.Test, Quiz, Homework, etc.
 * @author Joonho
 */
public class GradebookCategory {
    private String categoryName;
    private double weight; //decimal value

    public GradebookCategory(String categoryName, double weight) {
        this.categoryName = categoryName;
        this.weight = weight;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public double getWeight() {
        return weight;
    }
}
