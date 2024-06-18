
package shop;
import java.util.Scanner;
import java.io.*;
import java.util.Scanner;
import java.util.*;
   

public class Bill {
        public List<String> menuNumber = new ArrayList<String>();
        public List<String> menuName = new ArrayList<String>();
        public List<Integer> price = new ArrayList<Integer>();
        public List<Integer> amount = new ArrayList<Integer>();
        public String bill = "";
	
	public String getMenuNumber(int index){
		return menuNumber.get(index);
                
	}
	public String getMenuName(int index){
		return menuName.get(index);
	}
	
	public int getPrice (int index){
                return price.get(index);
	}
        
        public int getAmount(int index){
            return  amount.get(index);
        }
        
        public int sum(){
            int sum = 0;
            for (int i = 0 ; i < menuName.size() ; i++){
                sum += (price.get(i) * amount.get(i)); 
                
            }
            return sum;

        }
        
        public void add(String name,int Nprice,int Namount){
            menuName.add(name);
            price.add(Nprice);
            amount.add(Namount);
            menuNumber.add(String.valueOf(menuName.size() + 1));
            
        } 
        
        public String printBill(){
            bill = "";
            bill+="<html>==============<br>";
            bill+="&ensp;     Bill     <br>";
            bill+="==============<br>";
            for(int i = 0;i < menuName.size();i++){
                bill+= menuName.get(i) + " : &ensp;&ensp;" + price.get(i) + " x &ensp;&ensp; " + amount.get(i) + "<br>";
                
            }
            bill+= "total = &ensp;" + sum() + "<br></html>";
        return bill;
        }
        public void clear(){
            bill="";
            menuNumber.clear();
            menuName.clear();
            price.clear();
            amount.clear();
            
        }
	
	
	//public String toString (){
		//return "type "+menutype+ "list   "+menulist +"price   "+price;
	//}
}
 
