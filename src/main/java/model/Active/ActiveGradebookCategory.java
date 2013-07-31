package model.Active;

import model.grading.GradebookCategory;

/**
 * Active GradebookCategory implementation for GradebookCagegory storage
 * @author Joonho
 */
public abstract class ActiveGradebookCategory extends GradebookCategory {

    public ActiveGradebookCategory(String categoryName, double weight) {
        super(categoryName, weight);
    }

    public abstract GradebookCategory createNew(String categoryName,
            double weight);

    public abstract GradebookCategory findById(Object id);

    public abstract void save();
}
