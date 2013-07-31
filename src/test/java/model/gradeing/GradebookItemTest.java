package model.gradeing;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import model.grading.GradebookCategory;
import model.grading.GradebookItem;

public class GradebookItemTest {

	@Test
	public void testCreateGradebookItem() {
		GradebookCategory category = new GradebookCategory("Physical Labor", 0.5);
		GradebookItem item = new GradebookItem("Planting", 30,40, category);
		
		assertTrue(item.getGrade() == 75.0);
		System.out.println(item.getEarned());
		assertTrue(item.getEarned() == 30);
		assertTrue(item.getTotal() == 40.0);
		assertTrue(item.getCategory().equals(category));
	}
	
}
