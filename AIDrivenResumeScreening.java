package generics;

import java.util.ArrayList;

abstract class JobRole 
{
	private String type;
	private String name;
	private int applicationNo;
	
	public JobRole(String type,String name,int applicationNo)
	{
		this.type=type;
		this.name=name;
		this.applicationNo=applicationNo;
	}
	
	public void display()
	{
		System.out.println("job role:"+type);
		System.out.println("name:"+name);
		System.out.println("application Number:"+applicationNo);
	}
}

class SoftwareEngineer extends JobRole
{
	public SoftwareEngineer(String name,int applicationNo)
	{
		super("SoftwareEngineer",name,applicationNo);
	}
	
	@Override
	public void display()
	{
		super.display();
	}
}

class DataScientist extends JobRole
{
	public DataScientist(String name,int applicationNo)
	{
		super("DataScientist",name,applicationNo);
	}
	
	@Override
	public void display()
	{
		super.display();
	}
}

class ProductManager extends JobRole
{
	public ProductManager(String name,int applicationNo)
	{
		super("ProductManager",name,applicationNo);
	}
	
	@Override
	public void display()
	{
		super.display();
	}
}

class Resume<T extends JobRole>
{
	ArrayList<T> applicants;

	public Resume()
	{
		applicants=new ArrayList<>();
	}
	
	public void add(T j)
	{
		applicants.add(j);
	}
	
	public ArrayList<T> getList()
	{
		return applicants;
	}
}

public class AIDrivenResumeScreening
{
	public static void displayJobs(ArrayList<? extends JobRole> applicantList)
	{
		for(JobRole a: applicantList)
		{
			a.display();
		}
	}
	
	public static void main(String args[])
	{
		SoftwareEngineer s=new SoftwareEngineer("mukunda",1);
		DataScientist  d=new DataScientist("priya",2);
		ProductManager p=new ProductManager("rajasri",3);
		Resume<JobRole> list=new Resume<>();
		list.add(s);
		list.add(d);
		list.add(p);
		displayJobs(list.getList());
	}
}