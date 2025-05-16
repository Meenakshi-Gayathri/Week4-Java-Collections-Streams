package generics;
import java.util.ArrayList;

class Product<T>
{
	private String name;
	private double price;
	private T category;
	
	public Product(String name,double price,T category)
	{
		this.name=name;
		this.price=price;
		this.category=category;
	}
	
	public void display()
	{
		System.out.println("the product name:"+name);
		System.out.println("the product price:"+price);
		System.out.println("the product category:"+category);
	}
	
	public double getPrice()
	{
		return price;
	}
	
	public void setPrice(double newPrice)
	{
		price=newPrice;
	}
	
}


enum BookCategory 
{
	fictional,horror,scientific,romance,comedy;
}

enum ClothingCategory
{
	men,women,kids;
}

enum GadgetsCategory
{
	mobiles,laptops,tabs;
}


public class DynamicOnlineMarketplace
{
	public static<T extends Product<?>> void updatePrice(T product, double percentage )
	{
		double newPrice=product.getPrice()*(1-(percentage/100));
		product.setPrice(newPrice);
	}
	
	
	public static void main(String args[])
	{
		Product<BookCategory> p1=new Product<>("love",750,BookCategory.romance);
		Product<ClothingCategory> p2=new Product<>("shirt",2500,ClothingCategory.men);
		Product<GadgetsCategory> p3=new Product<> ("samsung S23",80000,GadgetsCategory.mobiles);
		updatePrice(p1,5.5);
		updatePrice(p2,15.5);
		updatePrice(p3,10);
		ArrayList<Product<?>> list =new ArrayList<>();
		list.add(p1);
		list.add(p2);
		list.add(p3);
		for(Product<?> p:list)
		{
			p.display();
		}
	}
}