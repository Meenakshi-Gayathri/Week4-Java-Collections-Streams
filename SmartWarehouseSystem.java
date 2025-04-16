import java.util.List;
import java.util.ArrayList;

abstract class WarehouseItem{
 private String name;
 private double price;
 
 public WarehouseItem(String name,double price){
  this.name = name;
  this.price = price;
 }
 public abstract String getCategory();
 public String getName(){return name;}
 public double getPrice(){return price;}
 public void displayInfo(){
  System.out.println("Category: "+ getCategory());
  System.out.println("Name: "+ getName());
  System.out.println("Price: "+ getPrice());
 }
}

class Electronics extends WarehouseItem{
 public Electronics(String name,double price){
  super(name,price);
 }
 @Override
 public String getCategory(){
  return "Electronics";
 }
}

class Groceries extends WarehouseItem{
 public Groceries(String name,double price){
  super(name,price);
 }
 @Override
 public String getCategory(){
  return "Groceries";
 }
}

class Furniture extends WarehouseItem{
 public Furniture(String name,double price){
  super(name,price);
 }
 @Override
 public String getCategory(){
  return "Furniture";
 }
}

class Storage<T extends WarehouseItem>{
 private List<T> items;
 public Storage(){
  items = new ArrayList<>();
 }
 public void addItem(T item){
  items.add(item);
 }
 public List<T> getItems(){
  return items;
 }
}

class WarehouseUtility{
 public static void displayItems(List<? extends WarehouseItem> items){
 for(WarehouseItem item:items){
  item.displayInfo();
 }
 }
}

public class SmartWarehouseSystem {
    public static void main(String[] args) {
        Storage<Electronics> electronicsStorage = new Storage<>();
        electronicsStorage.addItem(new Electronics("Laptop", 1200.00));
        electronicsStorage.addItem(new Electronics("Smartphone", 800.00));

        Storage<Groceries> groceryStorage = new Storage<>();
        groceryStorage.addItem(new Groceries("Rice", 40.00));
        groceryStorage.addItem(new Groceries("Milk", 3.50));

        Storage<Furniture> furnitureStorage = new Storage<>();
        furnitureStorage.addItem(new Furniture("Chair", 75.00));
        furnitureStorage.addItem(new Furniture("Desk", 200.00));

        System.out.println("--- Electronics ---");
        WarehouseUtility.displayItems(electronicsStorage.getItems());

        System.out.println("\n--- Groceries ---");
        WarehouseUtility.displayItems(groceryStorage.getItems());

        System.out.println("\n--- Furniture ---");
        WarehouseUtility.displayItems(furnitureStorage.getItems());
    }
}