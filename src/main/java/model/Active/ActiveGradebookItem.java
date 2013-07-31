package model.Active;

import model.grading.GradebookCategory;
import model.grading.GradebookItem;

/**
 * Active GradebookItem implementation for GradebookItem storage
 * @author Joonho
 */
public abstract class ActiveGradebookItem extends GradebookItem {

    public ActiveGradebookItem(String itemName, double earned, double total,
            GradebookCategory category) {
        super(itemName, earned, total, category);
    }

    public abstract GradebookItem createNew(String itemName, double earned,
            double total, GradebookCategory category);

    public abstract GradebookItem findById(Object id);

    public abstract void save();
}
