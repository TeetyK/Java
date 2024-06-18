/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package shop;
import java.io.*;
import java.util.*;


/**
 *
 * @author TeetonLP
 */
public class Chart {
   public List<String> name = new ArrayList<String>();
   public List<String> price = new ArrayList<String>();
   public List<String> amount = new ArrayList<String>();
   public void add(String name , String price , String amount){
       this.name.add(name);
       this.price.add(price);
       this.amount.add(amount);
   }
   public void clear(){
       this.name.clear();
       this.price.clear();
       this.amount.clear();
   }
}
