package model;

import static org.junit.Assert.*;
import model.grading.GradebookCategory;
import model.grading.GradebookItem;
import model.grading.scheme.GradingScheme;
import model.Class;
import model.Course;
import model.Section;
import model.Student;
import model.grading.scheme.DefaultGradingScheme;

import org.junit.Before;
import org.junit.Test;

public class StudentTest {
    Course course;
    GradingScheme scheme;
    Class classe;
    Section section;
    Student student;
    
    @Before
    public void setUp() {
        course = new Course("Farming",1337,"Farming 101");
        scheme = new DefaultGradingScheme();
        classe = new Class("Farming with Simpkins", "Summer 2013", course, scheme);
        section = new Section(classe);
    }
    
	@Test
	public void testCreateStudent() {
        student = new Student("Joonho", section);
	    
		assertTrue(student.getName().equals("Joonho"));
		assertTrue(student.getClassSection().equals(section));
		assertTrue(student.getGradingScheme().equals(scheme));
		assertTrue(student.getGradebookItems().isEmpty());
	}
	
	@Test
	public void testAddGradebookItem() {
        student = new Student("Joonho", section);
	    GradebookCategory category = new GradebookCategory("Field Work", .4);
	    GradebookItem item1 = new GradebookItem("Hoing", 33, 40, category);
        GradebookItem item2 = new GradebookItem("Plowing", 28, 30, category);
        
        student.addGradebookItem(item1);
        student.addGradebookItem(item2);
        
        assertTrue(student.getGradebookItems().contains(item1));
        assertTrue(student.getGradebookItems().contains(item2));
        assertTrue(student.getGradebookItems().size() == 2);
	}
	
	@Test
	public void testAddSameItem() {
	    student = new Student("Joonho", section);
	    GradebookCategory category = new GradebookCategory("Field Work", .4);
	    GradebookItem item1 = new GradebookItem("Hoing", 33, 40, category);
	    student.addGradebookItem(item1);
	    student.addGradebookItem(item1);
	        
	    assertTrue(student.getGradebookItems().contains(item1));
	    assertTrue(student.getGradebookItems().size() == 1);
	}
	
	@Test
	public void testRemoveItem() {
	    student = new Student("Joonho", section);
        GradebookCategory category = new GradebookCategory("Field Work", .4);
        GradebookItem item1 = new GradebookItem("Hoing", 33, 40, category);
        GradebookItem item2 = new GradebookItem("Plowing", 28, 30, category);

        student.addGradebookItem(item1);
        student.addGradebookItem(item2);
        student.removeGradebookItem(item1);
        student.removeGradebookItem(item2);
        assertFalse(student.getGradebookItems().contains(item1));
        assertFalse(student.getGradebookItems().contains(item2));
        assertTrue(student.getGradebookItems().size() == 0);
    }

    @Test
    public void testCalculateAverage1() {
        student = new Student("Joonho", section);
        GradebookCategory category = new GradebookCategory("Field Work", .4);
        GradebookItem item1 = new GradebookItem("Hoing", 33, 40, category);
        GradebookItem item2 = new GradebookItem("Plowing", 28, 30, category);
        GradebookItem item3 = new GradebookItem("Watering", 14, 15, category);
        
        student.addGradebookItem(item1);
        student.addGradebookItem(item2);
        student.addGradebookItem(item3);
        
        double grade = student.calculateAverage();
        
        assertEquals(grade,88.2,0);
    }	
    
    public void testCalculateAverage2() {
        student = new Student("Joonho", section);
        GradebookCategory category1 = new GradebookCategory("Field Work", .4);
        GradebookItem item1 = new GradebookItem("Hoing", 33, 40, category1);
        GradebookItem item2 = new GradebookItem("Plowing", 28, 30, category1);
        GradebookItem item3 = new GradebookItem("Watering", 14, 15, category1);
        
        GradebookCategory category2 = new GradebookCategory("Test", .6);
        GradebookItem item4 = new GradebookItem("Test 1", 40, 50, category2);
        GradebookItem item5 = new GradebookItem("Test 2", 45, 50, category2);
        GradebookItem item6 = new GradebookItem("Test 3", 44, 50, category2);
        
        student.addGradebookItem(item1);
        student.addGradebookItem(item2);
        student.addGradebookItem(item3);
        student.addGradebookItem(item4);
        student.addGradebookItem(item5);
        student.addGradebookItem(item6);
        
        double grade = student.calculateAverage();
        System.out.println(grade);
        
        assertEquals(grade,86.6,0);
    }
    
    public void testCalculateLetter1() {
        student = new Student("Joonho", section);
        GradebookCategory category = new GradebookCategory("Field Work", .4);
        GradebookItem item1 = new GradebookItem("Hoing", 33, 40, category);
        GradebookItem item2 = new GradebookItem("Plowing", 28, 30, category);
        GradebookItem item3 = new GradebookItem("Watering", 4, 15, category);
        
        student.addGradebookItem(item1);
        student.addGradebookItem(item2);
        student.addGradebookItem(item3);
        
        char letter = student.calculateLetter();
        
        assertEquals(letter,'C',0);
    }
    
    public void testCalculateLetter2() {
        student = new Student("Joonho", section);
        GradebookCategory category1 = new GradebookCategory("Field Work", .4);
        GradebookItem item1 = new GradebookItem("Hoing", 37, 40, category1);
        GradebookItem item2 = new GradebookItem("Plowing", 28, 30, category1);
        GradebookItem item3 = new GradebookItem("Watering", 14, 15, category1);
        
        GradebookCategory category2 = new GradebookCategory("Test", .6);
        GradebookItem item4 = new GradebookItem("Test 1", 50, 50, category2);
        GradebookItem item5 = new GradebookItem("Test 2", 50, 50, category2);
        GradebookItem item6 = new GradebookItem("Test 3", 50, 50, category2);
        
        student.addGradebookItem(item1);
        student.addGradebookItem(item2);
        student.addGradebookItem(item3);
        student.addGradebookItem(item4);
        student.addGradebookItem(item5);
        student.addGradebookItem(item6);
        
        char letter = student.calculateLetter();
        
        assertEquals(letter,'A',0);
    }
}
