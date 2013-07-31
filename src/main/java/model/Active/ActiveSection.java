package model.Active;

import model.Class;
import model.Section;

/**
 * Active Section implementation for Section storage
 * @author Joonho
 */
public abstract class ActiveSection extends Section {

    public ActiveSection(Class sectionClass) {
        super(sectionClass);
    }

    public abstract Section createNew(Class sectionClass);

    public abstract Section findById(String id);

    public abstract void save();
}
