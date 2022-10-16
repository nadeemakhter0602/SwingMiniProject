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

/**
 *
 * @author intelligence
 */
public class Person {
   
   protected String name;
   protected Height height;
   protected int weight;
   protected String hometown;
   protected String highSchool;
   
   public Person()
   {
      name = "";
      height = new Height();
      weight = -1;
      hometown = "";
      highSchool = "";
   }
   
   public Person(String name, int feet, int inches, int weight, String hometown, String highSchool)
   {
      this.name = name;
      this.height = new Height(feet,inches);
      this.weight = weight;
      this.hometown = hometown;
      this.highSchool = highSchool;
   }
   
   //Accessor methods
   public String getName()
   {
      return this.name;
   }
   public Height getHeight()
   {
      return this.height;
   }   
   public int getWeight()
   {
      return this.weight;
   }
   public String getHometown()
   {
      return this.hometown;
   }
   public String getHighSchool()
   {
      return this.highSchool;
   }
   
   //Mutator methods
   public void setName(String name)
   {
      this.name = name;
   }
   public void setHeight(Height height)
   {
      this.height = height;
   }
   public void setWeight(int weight)
   {
      this.weight = weight;
   }
   public void setHometown(String hometown)
   {
      this.hometown = hometown;
   }
   public void setHighSchool(String highSchool)
   {
      this.highSchool = highSchool;
   }

   /**
    * Returns the name, height, weight, hometown and highSchool attributes 
    * in the format :
    *    
    *    Name : insert name of person
    *    Height : F'I"
    *    Weight : X lbs
    *    Home Town : insert hometown of person
    *    High School : insert highSchool of person
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
    * @return  the name, height, weight, hometown and highSchool attributes 
    */
   @Override
   public String toString()
   {
      //Building the string output to return.
      String output = "Name : " + this.getName();
      output = output + "\nHeight : " + this.getHeight().toString();
      output = output + "\nWeight : " + this.getWeight() + " lbs";
      output = output + "\nHome Town : " + this.getHometown();
      output = output + "\nHigh School : " + this.getHighSchool();
      return output;      
   }
   
}
