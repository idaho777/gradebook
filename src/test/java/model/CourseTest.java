package model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Collection;

import model.Course;
import model.grading.GradebookCategory;
import model.grading.GradebookItem;

import org.junit.Test;

public class CourseTest {
	
	@Test
	public void testCreateCourse1() {
		Course course = new Course("Farming",1337,"Farming 101");
		assertTrue(course != null);
		assertTrue(course.getSubject().equals("Farming"));
		assertTrue(course.getCourseNum() == 1337);
		assertTrue(course.getName().equals("Farming 101"));
		assertTrue(course.getPreReq().isEmpty());
		assertTrue(course.getClasses().isEmpty());
	}
	
	@Test
	public void testCreateCourse2() {
		Collection<Course> preReq = new ArrayList<>();
		preReq.add(new Course("Farming",1337,"Farming 101"));
		
		Course course = new Course("Farming",1338,"Farming 202",preReq);
		assertTrue(course != null);
		assertTrue(course.getSubject().equals("Farming"));
		assertTrue(course.getCourseNum() == 1338);
		assertTrue(course.getName().equals("Farming 202"));
		assertFalse(course.getPreReq().isEmpty());
		assertTrue(course.getClasses().isEmpty());
	}
	
	@Test
	public void testCoursePreReq() {
		Course pre = new Course("Farming",1337,"Farming 101");
		Collection<Course> preReq = new ArrayList<>();
		preReq.add(pre);	
		Course course = new Course("Farming",1338,"Farming 202",preReq);

		assertTrue(course.getPreReq().contains(pre));
		assertTrue(course.getPreReq().size() == 1);
	}

	public void testAddSection() {
	    Course course = new Course("Farming",1337,"Farming 101");
	    Class classe = new Class("Farming with Simpkins","Fall 2013", course);
	    course.addClasses(classe);

	    assertTrue(course.getClasses().size() == 1);
	}
	
    @Test
    public void testCalculateAverage() {
        Course course = new Course("Farming",1337,"Farming 101");
        Class c1 = new Class("Farming with Simpkins","Fall 2013", course);
        Class c2 = new Class("Farming with Rogers","Fall 2013", course);
        Class c3 = new Class("Farming with Peters","Fall 2013", course);
        Class c4 = new Class("Farming with Minis","Fall 2013", course);


        Section section1 = new Section(c1);
        Section section2 = new Section(c2);
        Section section3 = new Section(c3);
        Section section4 = new Section(c4);

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

        assertEquals(course.calculateAverage(),79.0,0);
    }
      
    public void testLetterGrade() {
        Course course = new Course("Farming",1337,"Farming 101");
        Class c1 = new Class("Farming with Simpkins","Fall 2013", course);
        Class c2 = new Class("Farming with Rogers","Fall 2013", course);
        Class c3 = new Class("Farming with Peters","Fall 2013", course);
        Class c4 = new Class("Farming with Minis","Fall 2013", course);


        Section section1 = new Section(c1);
        Section section2 = new Section(c2);
        Section section3 = new Section(c3);
        Section section4 = new Section(c4);

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

        assertEquals(course.calculateLetter(),'C',0);
    }

}
