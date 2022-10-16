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
public class Height {
   
   private int feet;
   private int inches;
   
   public Height()
   {
      feet = 0;
      inches = 0;
   }
   
   public Height(int feet,int inches)
   {
      this.feet = feet;
      this.inches = inches;
   }
      
   //Accessor methods
   public int getFeet()
   {
      return this.feet;
   }
   public int getInches()
   {
      return this.inches;
   }
   
   //mutator methods
   public void setFeet(int feet)
   {
      this.feet = feet;
   }
   public void setInches(int inches)
   {
      this.inches = inches;
   }
    
   /**
    * Returns the feet and inches constituting the height in the format :
    *    
    *    F'I"
    * 
    * Where F is the value of feet and I is the value of inches. Eg :
    *
    *    5"2' 
    *    
    * Where we consider value of feet to be 5 and inches to be 2.
    * 
    * @return  the feet and inches constituting the height in a specific format 
    */
   @Override
   public String toString()
   {
      return feet+"\'"+inches+"\"";
   }
   
}
