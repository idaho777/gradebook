package model.gradeing;

import org.junit.Before;
import org.junit.Test;

import model.Class;
import model.Course;
import model.Section;
import model.Student;
import model.grading.scheme.DefaultGradingScheme;
import model.grading.scheme.GradingScheme;

public class DefaultGradingSchemeTest {
	
    @Before
    public void setUp() {
        Course course = new Course("Farming",1337,"Farming 101");
        GradingScheme scheme = new DefaultGradingScheme();
        Class classe = new Class("Farming with Simpkins", "Summer 2013", course, scheme);
        Section section = new Section(classe);
        Student student = new Student("Joonho", section);
    }
    
	@Test
	public void testLetterGrade() {
	    
		
	}
	
	
}
