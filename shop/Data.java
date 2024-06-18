
package shop;
import java.io.*;
import java.util.Scanner;
import java.util.*;
public class Data {
    public String file_name = "data.txt";
    public int amount_data;
    public List<String> name = new ArrayList<String>();
    public List<Integer> price = new ArrayList<Integer>();
    public List<Integer> amount_goods = new ArrayList<Integer>();
    public void Data_created(){ // creeted new File 
        try{
            File file = new File(file_name);
            if(file.createNewFile()){
                System.out.println("File name : " + file.getName());
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    public void input_data(String Nname , int Nprice , int Namount){
        try{
            int count_n = amount_data;
            FileWriter file = new FileWriter(file_name,true);
            this.name.add(Nname);
            this.price.add(Nprice);
            this.amount_goods.add(Namount);
            file.write(this.name.get(count_n) + " " + this.price.get(count_n)+ " " + this.amount_goods.get(count_n) + "\n");
//            file.write("Hello 100 10\nTeety_TTT 100 10\nRrrr 10 10\nSaharat 100 10\nApple 10 100");
//            file.write("");
            file.close();
            
        }catch(IOException e){
            System.out.println("Error input_data.");
        }
    }
    public void read_data(){ // Frist Read to check value what is N ?
        try{
            File file = new File(file_name);
            Scanner read = new Scanner(file);
            int i = 0;
  
            while(read.hasNext()){
                String data = read.next();
                this.amount_data++;
                name.add(data);
                int data_int = read.nextInt();
                price.add(data_int);
                
                int data_amount_int = read.nextInt();
                amount_goods.add(data_amount_int);
//                System.out.println(i + "Name : " + name[i] + " Price -> " +  price[i] + "Amount -> " + amount_goods[i]);
                i++;
                // bug not read write space ;
            }
            read.close();
            

            System.out.println("N = " + this.amount_data);
            
        }catch(IOException e){
            System.out.println("Error Read");
        }
    }
    public void modify(int index,String Rname , int Rprice , int Ramount){
        this.name.set(index,Rname);
        this.price.set(index,Rprice);
        this.amount_goods.set(index,Ramount);
        System.out.println("Modify : " + index + " -> Complete.");
    }
    
    public void delete(int index,String Dname , int Dprice , int Damount){
        this.name.remove(index);
        this.price.remove(index);
        this.amount_goods.remove(index);
        System.out.println("Remove : " + index);
    }
    public void update(){
        try{ // clear txt old
            FileWriter file_clear = new FileWriter(file_name);
            file_clear.write("");
            file_clear.close();
        }catch(IOException e){
            System.out.println("Error clear old text in : " + file_name);
        }
        try{
            FileWriter file_update = new FileWriter(file_name,true);
            for(int i = 0 ; i < this.amount_data ; i++){
                file_update.write(this.name.get(i) + " " + this.price.get(i) + " " + this.amount_goods.get(i) + "\n");
            }
            file_update.close();
        }catch(IOException e){
            System.out.println("Error File update.");
        }
    }
    // value to using
    public String getName_goods(int index){
        return this.name.get(index);
    }
    public int getPrice_goods(int index){
        return this.price.get(index);
    }
    public int getAmount_goods(int index){
        return this.amount_goods.get(index);
    }
    public int getSize_goods(){
        return this.amount_data;
    }
    public void Increase_amount(int index,int value){
        int old_value = amount_goods.get(index);
        old_value+=value;
        amount_goods.set(index,old_value);
    }
    public void add_goods(String Nname , int Nprice ,int Namount){
        this.name.add(Nname);
        this.price.add(Nprice);
        this.amount_goods.add(Namount);
    }
    public void clear(){
        this.name.clear();
        this.price.clear();
        this.amount_goods.clear();
    }
    public void check_size(){
        amount_data = 0;
        for (String i : this.name) {
            amount_data++;
        }
    }
    public void sold(int index,int Samount){
        int temp = this.amount_goods.get(index) - Samount;
        this.amount_goods.set(index,temp);
    }
}
// created_file -> read_file  # mustbe -> it can using function get.
// input_data -> update
// modify_data -> update
// delete_data -> update