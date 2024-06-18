/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package shop;
import java.io.*;
import java.util.*;
import java.time.*;
public class account_goods {
    public List<String> date = new ArrayList<String>();
    public List<String> name = new ArrayList<String>();
    public List<String> price = new ArrayList<String>();
    public List<String> amount = new ArrayList<String>();
    public int sum = 0;
    public int count = 0;
    public String file_name = "account.txt";
    // fuction
    public void input_data(String Nname, int Nprice , int Namount){
        this.name.add(Nname);
        this.price.add(String.valueOf(Nprice));
        this.amount.add(String.valueOf(Namount));
        this.date.add(String.valueOf(LocalDate.now()));
    }// return to get value is String into List other.
    public String getDate(int index){
        return date.get(index);
    }
    public String getName(int index){
        return name.get(index);
    }
    public String getPrice(int index){
        return price.get(index);
    }
    public String getAmount(int index){
        return amount.get(index);
    }
    public int sum(){
        for(int i = 0 ; i < name.size() ; i++){
            sum+=(Integer.valueOf(price.get(i)) * Integer.valueOf(amount.get(i)));
        }
        return sum;
    } 
    // acccount file 
    public void createdFile(){
        try{
            File new_file = new File(file_name);
            if(new_file.createNewFile()){
                System.out.println("File created :" + file_name);
            }
        }catch(IOException e){
            System.out.println("Created File Error.");
            e.printStackTrace();
        }
        
    }
    public void read(){
        try{
            File file_read = new File(file_name);
            Scanner read = new Scanner(file_read);
            int i =0;
            while(read.hasNext()){
                count++;
                String date_data = read.next();
                date.add(date_data);
                String name_data = read.next();
                name.add(name_data);
                String price_data = read.next();
                price.add(price_data);
                String amount_data = read.next();
                amount.add(amount_data);
            }
            
        }catch(IOException e){
            System.out.println("Get account from file Error.");
            e.printStackTrace();
        }
    }
    public void save(){
        try{ // clear txt old
            FileWriter file_clear = new FileWriter(file_name);
            file_clear.write("");
            file_clear.close();
        }catch(IOException e){
            System.out.println("Error clear old text in : " + file_name);
        }
        try{
            FileWriter file_update = new FileWriter(file_name,true);
            for(int i = 0 ; i < name.size() ; i++){
                file_update.write(this.date.get(i) + " " +this.name.get(i) + " " + this.price.get(i) + " " + this.amount.get(i) + "\n");
            }
            file_update.close();
        }catch(IOException e){
            System.out.println("Error File update.");
        }
    }
    
}
