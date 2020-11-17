package application;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Program {

	public static void main(String[] args) throws ParseException {


	   Locale.setDefault(Locale.US);

	   Scanner sc = new Scanner(System.in);
	   
	  SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	   
	   List<Product> p = new ArrayList<>();
	   
	   
	   
	   System.out.print("Enter the number of products: ");
	   int N = sc.nextInt();
	   
	   for(int i =0; i<N; i++)
	   {
	      System.out.println("Product # " + (i+1) +" data: ");
	      System.out.println("Common, used or imported (c/u/i)? ");
	      char ch = sc.next().charAt(0);
	      System.out.println("Name: ");
	      sc.nextLine();
	      String name = sc.nextLine();
	      System.out.println("Price: ");
	      Double price = sc.nextDouble();
	      
	      if(ch == 'c' || ch == 'C')
	      {
	    	  Product p1 = new Product(name, price);
	    	  p.add(p1);
	    	  
	      }else if(ch == 'u' || ch == 'U')
	      {
	    	 System.out.println("Manufacture date (DD/MM/YYYY): ");
	    	 Date manufactureDate = (Date) sdf.parse(sc.next());
             Product p1 = new UsedProduct(name, price, manufactureDate);	    	 
	    	 p.add(p1); 
	      }else if(ch == 'i' || ch == 'I')
	    	  
	      {
	    	    System.out.println("Customs fee: ");
	    	    Double customsFee = sc.nextDouble();
	    	    
	    	    Product p1 = new ImportedProduct(name, price, customsFee);
	    	    p.add(p1);
	    	  
	      }
	    }
	   
	   System.out.println();
	   System.out.println("PRICE TAGS:\n");
	   
	   for(Product pro : p)
	   {
		   
		   System.out.println(pro.priceTag());
		   System.out.println();
		   
	   }
	   
	}

}
