package model;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import model.Class;
import model.Course;
import model.Section;
import model.grading.GradebookCategory;
import model.grading.GradebookItem;
import model.grading.scheme.DefaultGradingScheme;
import model.grading.scheme.GradingScheme;

import org.junit.Before;
import org.junit.Test;

public class ClassTest {
    Course course;
    Class classe;
    GradingScheme scheme = new DefaultGradingScheme();
    
    @Before
    public void setUp() {
        course = new Course("Farming",1337,"Farming 101");
        scheme = new DefaultGradingScheme();
    }
    
    @Test
    public void testCreateClass1() {
        classe = new Class("Farming with Simpkins","Summer 2013", course);

        assertTrue(course != null);
        assertTrue(classe.getClassName().equals("Farming with Simpkins"));
        assertTrue(classe.getSemester().equals("Summer 2013"));
        assertTrue(classe.getClassCourse().equals(course));
        assertTrue(classe.getGradingScheme() != null);
        assertTrue(classe.getSections().isEmpty());
    }

    @Test
    public void testCreateClass2() {
        GradingScheme scheme = new DefaultGradingScheme();
        classe = new Class("Farming with Simpkins","Summer 2013", 
                course, scheme);
        
        assertTrue(course != null);
        assertTrue(classe.getClassName().equals("Farming with Simpkins"));
        assertTrue(classe.getSemester().equals("Summer 2013"));
        assertTrue(classe.getClassCourse().equals(course));
        assertTrue(classe.getGradingScheme().equals(scheme));
        assertTrue(classe.getSections().isEmpty());
    }

    @Test
    public void testAddSection() {
        classe = new Class("Farming with Simpkins","Summer 2013", course);
        Section section = new Section(classe);
        
        assertFalse(classe.getSections().isEmpty());
        assertTrue(classe.getSections().size() == 1);
        assertTrue(classe.getSections().contains(section));
    }
    
    @Test
    public void testAddDuplicateSection() {
        classe = new Class("Farming with Simpkins","Summer 2013", course);
        Section section1 = new Section(classe);
        classe.addSection(section1);
        
        assertFalse(classe.getSections().isEmpty());
        assertTrue(classe.getSections().size() == 1);
        assertTrue(classe.getSections().contains(section1));
    }

    @Test
    public void testCalculateAverage() {
        classe = new Class("Farming with Simpkins","Summer 2013", course);
        Section section1 = new Section(classe);
        Section section2 = new Section(classe);
        Section section3 = new Section(classe);
        Section section4 = new Section(classe);
        
        Student stu1 = new Student("Bob", section1);
        Student stu2 = new Student("Sam", section2);
        Student stu3 = new Student("Bill", section3);
        Student stu4 = new Student("Simpkins", section4);
        
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

        assertEquals(classe.calculateAverage(),79.0,0);
    }
    
    @Test
    public void testCalculateLetter() {
        classe = new Class("Farming with Simpkins","Summer 2013", course);
        Section section1 = new Section(classe);
        Section section2 = new Section(classe);
        Section section3 = new Section(classe);
        Section section4 = new Section(classe);
        
        Student stu1 = new Student("Bob", section1);
        Student stu2 = new Student("Sam", section2);
        Student stu3 = new Student("Bill", section3);
        Student stu4 = new Student("Simpkins", section4);
        
        GradebookCategory catagory1 = new GradebookCategory("Test", 0.6);
        GradebookCategory catagory2 = new GradebookCategory("Quiz", 0.3);
        GradebookCategory catagory3 = new GradebookCategory("HW", 0.1);
        
        stu1.addGradebookItem(new GradebookItem("Exam1", 40, 100, catagory1));
        stu2.addGradebookItem(new GradebookItem("Exam1", 40, 100, catagory1));
        stu3.addGradebookItem(new GradebookItem("Exam1", 50, 100, catagory1));
        stu4.addGradebookItem(new GradebookItem("Exam1", 90, 100, catagory1));
        
        stu1.addGradebookItem(new GradebookItem("Quiz", 93, 100, catagory2));
        stu2.addGradebookItem(new GradebookItem("Quiz", 36, 100, catagory2));
        stu3.addGradebookItem(new GradebookItem("Quiz", 73, 100, catagory2));
        stu4.addGradebookItem(new GradebookItem("Quiz", 12, 100, catagory2));
        
        stu1.addGradebookItem(new GradebookItem("HW", 11, 100, catagory3));
        stu2.addGradebookItem(new GradebookItem("HW", 22, 100, catagory3));
        stu3.addGradebookItem(new GradebookItem("HW", 33, 100, catagory3));
        stu4.addGradebookItem(new GradebookItem("HW", 44, 100, catagory3));

        assertEquals(classe.calculateLetter(),'F',0);
    }
    

}
