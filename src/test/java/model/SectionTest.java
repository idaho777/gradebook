package model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import model.Class;
import model.Course;
import model.Section;
import model.Student;
import model.grading.GradebookCategory;
import model.grading.GradebookItem;

import org.junit.Before;
import org.junit.Test;

public class SectionTest {
    Course course;
    Class classe;
    Section section;
    
    @Before
    public void setUp() {
        course = new Course("Farming",1337,"Farming 101");
        classe = new Class("Farming with Simpkins", "Summer 2013", course);
    }
    
    @Test
	public void testCreateSection1() {
		section = new Section(classe);
		
		assertTrue(section.getSectionClass().equals(classe));
		assertTrue(section.getStudents().isEmpty());
	}
	
	@Test
	public void testSectionAddStudent() {
		section = new Section(classe);
		Student student = new Student("Joonho", section);
		section.addStudent(student);
		
		assertFalse(section.getStudents().isEmpty());
		assertTrue(section.getStudents().contains(student));
	}	
	
	@Test
	public void testSectionAddintDuplicateStudent() {
		section = new Section(classe);
		Student student = new Student("Joonho", section);
		section.addStudent(student);
		section.addStudent(student);
		
		assertTrue(section.getStudents().size() == 1);
	}
	
	@Test
	public void testAddingToOtherSections() {
		Section section1 = new Section(classe);
		Section section2 = new Section(classe);
		Student student = new Student("Joonho", section1);
		section2.addStudent(student);
		
		assertTrue(section1.getStudents().contains(student));
		assertFalse(section2.getStudents().contains(student));
		assertTrue(student.getClassSection().equals(section1));
		assertFalse(student.getClassSection().equals(section2));
	}
	
	@Test
	public void testSectionRemoveStudent() {
		section = new Section(classe);
		Student student = new Student("Joonho", section);
		section.addStudent(student);
		section.removeStudent(student);
		
		assertTrue(section.getStudents().isEmpty());
		assertFalse(section.getStudents().contains(student));
	}
	
	@Test
	public void testCalculateAverage() {
	    section = new Section(classe);
	    Student stu1 = new Student("Bob", section);
        Student stu2 = new Student("Sam", section);
        Student stu3 = new Student("Bill", section);
        Student stu4 = new Student("Simpkins", section);
        
        GradebookCategory catagory1 = new GradebookCategory("Test", 0.6);
        GradebookCategory catagory2 = new GradebookCategory("Quiz", 0.3);
        GradebookCategory catagory3 = new GradebookCategory("HW", 0.1);
        
        stu1.addGradebookItem(new GradebookItem("Exam1", 90, 100, catagory1));
        stu2.addGradebookItem(new GradebookItem("Exam1", 80, 100, catagory1));
        stu3.addGradebookItem(new GradebookItem("Exam1", 85, 100, catagory1));
        stu4.addGradebookItem(new GradebookItem("Exam1", 98, 100, catagory1));
        
        stu1.addGradebookItem(new GradebookItem("Quiz", 94, 100, catagory2));
        stu2.addGradebookItem(new GradebookItem("Quiz", 30, 100, catagory2));
        stu3.addGradebookItem(new GradebookItem("Quiz", 55, 100, catagory2));
        stu4.addGradebookItem(new GradebookItem("Quiz", 79, 100, catagory2));
        
        stu1.addGradebookItem(new GradebookItem("HW", 92, 100, catagory3));
        stu2.addGradebookItem(new GradebookItem("HW", 20, 100, catagory3));
        stu3.addGradebookItem(new GradebookItem("HW", 83, 100, catagory3));
        stu4.addGradebookItem(new GradebookItem("HW", 99, 100, catagory3));
	    
        assertEquals(section.calculateAverage(),79.0,0);
	}
	
	@Test
	public void testLetterGrade() {
        section = new Section(classe);
        Student stu1 = new Student("Bob", section);
        Student stu2 = new Student("Sam", section);
        Student stu3 = new Student("Bill", section);
        Student stu4 = new Student("Simpkins", section);
        
        GradebookCategory catagory1 = new GradebookCategory("Test", 0.6);
        GradebookCategory catagory2 = new GradebookCategory("Quiz", 0.3);
        GradebookCategory catagory3 = new GradebookCategory("HW", 0.1);
        
        stu1.addGradebookItem(new GradebookItem("Exam1", 90, 100, catagory1));
        stu2.addGradebookItem(new GradebookItem("Exam1", 80, 100, catagory1));
        stu3.addGradebookItem(new GradebookItem("Exam1", 85, 100, catagory1));
        stu4.addGradebookItem(new GradebookItem("Exam1", 98, 100, catagory1));
        
        stu1.addGradebookItem(new GradebookItem("Quiz", 94, 100, catagory2));
        stu2.addGradebookItem(new GradebookItem("Quiz", 30, 100, catagory2));
        stu3.addGradebookItem(new GradebookItem("Quiz", 55, 100, catagory2));
        stu4.addGradebookItem(new GradebookItem("Quiz", 79, 100, catagory2));
        
        stu1.addGradebookItem(new GradebookItem("HW", 92, 100, catagory3));
        stu2.addGradebookItem(new GradebookItem("HW", 20, 100, catagory3));
        stu3.addGradebookItem(new GradebookItem("HW", 83, 100, catagory3));
        stu4.addGradebookItem(new GradebookItem("HW", 99, 100, catagory3));
        
        assertEquals(section.calculateLetter(), 'C', 0);
	}
}
