package generics;

import java.util.ArrayList;

abstract class CourseType 
{
	private String courseName;
	
	public CourseType(String courseName)
	{
		this.courseName=courseName;
	}
	
	public void display()
	{
		System.out.println("the course Name:"+courseName);
	}
	
	abstract public void evaluation();
	
}

class ExamCourse extends CourseType
{

	
	public ExamCourse(String courseName)
	{
		super(courseName);
	}
	
	@Override
	public void evaluation()
	{
		System.out.println("the evaluation is exam based");
	}

}

class AssignmentCourse extends CourseType
{

	
	public AssignmentCourse(String courseName)
	{
		super(courseName);
	}
	
	@Override
	public void evaluation()
	{
		System.out.println("the evaluation is assigment based");
	}
}

class ResearchCourse extends CourseType
{

	
	public ResearchCourse(String courseName)
	{
		super(courseName);
	}
	
	@Override
	public void evaluation()
	{
		System.out.println("the evaluation is research based");
	}
}

class Course<T extends CourseType>
{
	private ArrayList<T> courses;
	
	public Course()
	{
		courses=new ArrayList<>();
	}
	
	public void add(T c)
	{
		courses.add(c);
	}
	
	public ArrayList<T> getCourses()
	{
		return courses;
	}
	
}

public class MultiLevelUniversityCourse
{
	public static void displayCourses(ArrayList<? extends CourseType> courseList)
	{
		for(CourseType c: courseList)
		{
			c.display();
			c.evaluation();
		}
	}
	
	public static void main(String args[])
	{
		ExamCourse e1=new ExamCourse("oops");
		AssignmentCourse e2=new AssignmentCourse("VAC");
		ResearchCourse e3=new ResearchCourse("project");
		
		Course<CourseType> courseList=new Course<>();
		courseList.add(e1);
		courseList.add(e2);
		courseList.add(e3);
		displayCourses(courseList.getCourses());
	}
}
