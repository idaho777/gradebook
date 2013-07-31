package model.gradeing;

import static org.junit.Assert.assertTrue;
import model.grading.GradebookCategory;

import org.junit.Test;

public class GradebookCategoryTest {
	
	@Test
	public void testCreateCategory() {
		GradebookCategory category = new GradebookCategory("Physical Labor", 0.5);
		
		assertTrue(category.getCategoryName().equals("Physical Labor"));
		assertTrue(category.getWeight() == 0.5);
	}
}
