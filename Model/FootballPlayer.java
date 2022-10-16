/* 
 * The MIT License
 *
 * Copyright 2021 intelligence.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package Model;

import java.util.ArrayList;

/**
 *
 * @author intelligence
 */
public class FootballPlayer extends Person implements TableMember {
   
   private int number;
   private String position;
   
   private ArrayList<String> attributenames = new ArrayList<>();
   private ArrayList<String> attributes = new ArrayList<>();
   
   public FootballPlayer()
   {
      super();
      name = "";
      position = "";    
      
      //Add attribute names to an ArrayList
      attributenames.add("number");
      attributenames.add("position");
      attributenames.add("name");
      attributenames.add("height");
      attributenames.add("weight");
      attributenames.add("hometown");
      attributenames.add("highSchool");
            
   }
   
   public FootballPlayer(int number, String name, String position, int feet, int inches, int weight, String hometown, String highSchool)
   {
      super(name, feet, inches, weight, hometown, highSchool);      
      this.number = number;
      this.position = position;
      
      //Add attribute names to an ArrayList
      attributenames.add("number");
      attributenames.add("position");
      attributenames.add("name");
      attributenames.add("height");
      attributenames.add("weight");
      attributenames.add("hometown");
      attributenames.add("highSchool");
      
   }
   
   //Accessor methods
   public int getNumber()
   {
      return this.number;
   }
   public String getPosition()
   {
      return this.position;
   }
   //Mutator methods
   public void setNumber(int number)
   {      
      this.number = number;
   }
   public void setPosition(String position)
   {
      this.position = position;
   }
   
   /**
    * Returns the name, height, weight, hometown, highSchool, number 
    * and position attributes for FootballPlayer in the format :
    * 
    *    Name : insert name of person
    *    Height : F'I"
    *    Weight : X lbs
    *    Home Town : insert hometown of person
    *    High School : insert highSchool of person    
    *    Number : insert number of FootballPlayer
    *    Position : insert position of FootballPlayer
    * 
    * Where F is the value of feet and I is the value of inches. Eg :
    *
    *    5"2' 
    *    
    * Where we consider value of feet to be 5 and inches to be 2.
    * 
    * Similarly, X is the value of weight. Eg :
    *
    *    240 lbs
    * 
    * Where we consider the value of weight to be 240.
    * 
    * Other attributes are displayed as shown above.
    *  
    * @return  the name, height, weight, hometown, highSchool, number and position attributes 
    */
   @Override
   public String toString()
   {
      //Building the string output to return.
      String output = super.toString();
      output = output + "\nNumber : " + this.getNumber();
      output = output + "\nPosition : " + this.getPosition();
      return output;      
   }
   
   /**
    * 
    * Returns the value of a specific attribute,
    * The input parameter starts with 0 for the first attribute, 
    * then 1 for the second attribute and so on.
    * 
    * @param n
    * @return Returns the value of a specific attribute
    * 
    */
   @Override
   public String getAttribute(int n)
   {
      attributes = new ArrayList<>();
      
      //Add attributes to an ArrayList
      attributes.add(Integer.toString(number));
      attributes.add(position);      
      attributes.add(name);
      attributes.add(super.height.toString());
      attributes.add(Integer.toString(weight));
      attributes.add(hometown);
      attributes.add(highSchool);
      
      return attributes.get(n);
   }
   
   /**
    *
    * Returns the value of all attributes as an ArrayList of Strings.
    * 
    * @return Returns the value of all attributes as an ArrayList of Strings
    */
   @Override
   public ArrayList<String> getAttributes()
   {
      attributes = new ArrayList<>();
      
      //Add attributes to an ArrayList
      attributes.add(Integer.toString(number));
      attributes.add(position);      
      attributes.add(name);
      attributes.add(super.height.toString());
      attributes.add(Integer.toString(weight));
      attributes.add(hometown);
      attributes.add(highSchool);

      return attributes;
   }
   
   /**
    *
    * Returns the name of a specific attribute,
    * The input parameter start with 0 for the first attribute, 
    * then 1 for the second attribute and so on.
    * 
    * @param n
    * @return Returns the name of a specific attribute
    */
   @Override
   public String getAttributeName(int n)
   {
      return attributenames.get(n);
   }
   
   /**
    * 
    * Returns the name of all attributes as an ArrayList of Strings.
    * 
    * @return Returns the name of all attributes as an ArrayList of Strings
    */
   @Override
   public ArrayList<String> getAttributeNames()
   {
      return attributenames;
   }
         
}
