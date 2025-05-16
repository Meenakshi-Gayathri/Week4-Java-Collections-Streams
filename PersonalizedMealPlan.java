package generics;

import java.util.ArrayList;

interface MealPlan
{
	public void displayPlan();
}

class Vegetarian implements MealPlan
{
	
	public void displayPlan()
	{
		System.out.println("plan for Vegetarian");
	}
}

class Vegan implements MealPlan
{

	public void displayPlan()
	{
		System.out.println("plan for vegan");
	}
}

class Keto implements MealPlan
{

	public void displayPlan()
	{
		System.out.println("plan for keto diet");
	}
}

class Meal<T extends MealPlan>
{
	ArrayList<T> plans;
	
	public Meal()
	{
		plans=new ArrayList<>();
	}
	
	public void add(T m)
	{
		plans.add(m);
	}
	
	public ArrayList<T> getMeals()
	{
		return plans;
	}
}

public class PersonalizedMealPlan
{
	public static void generate(ArrayList<? extends MealPlan> plans)
	{
		for(MealPlan p: plans)
		{
			p.displayPlan();
		}
	}
	
	public static void main(String[] args)
	{
		Vegetarian m1=new Vegetarian();
		Vegan m2=new Vegan();
		Keto m3=new Keto();
		Meal<MealPlan> meals=new Meal<>();
		meals.add(m1);
		meals.add(m2);
		meals.add(m3);
		generate(meals.getMeals());
	}
}
