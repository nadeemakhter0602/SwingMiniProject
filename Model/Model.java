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
public class Model {
   
   private FootballPlayerData fpData = new FootballPlayerData(); 
   
   public Model() 
   { 
      System.out.println("============================================================="); 
      System.out.println("the table size is "+ fpData.getTable().size()); 
      System.out.println("============================================================="); 
      this.displayArray(fpData.getHeaders()); 
      this.displayArray(fpData.getLine(4)); 
      System.out.println("============================================================="); 
      this.displayArray(fpData.getHeaders()); 
      this.displayArray(fpData.getLine(121)); 
      System.out.println("============================================================="); 
      this.displayArrayOfArrays(fpData.getLines(70, 72)); 
      System.out.println("============================================================="); 
      this.displayArrayOfArrays(fpData.getLines(100, 101)); 
      System.out.println("============================================================="); 
      System.out.println("============================================================="); 
      System.out.println("the table size is "+ fpData.getTable().size());
   } 
   
   public void displayArrayOfArrays(ArrayList<ArrayList<String>> manyLines) 
   { 
      for (int i = 0; i < manyLines.size(); i++) 
      { 
         displayArray(manyLines.get(i)); 
      } 
   } 
   
   public void displayArray(ArrayList<String> oneLineOnly) 
   { 
      for (int k = 0; k < oneLineOnly.size(); k++) 
      { 
         System.out.print(oneLineOnly.get(k)); System.out.print(" "); 
      } 
      System.out.println(""); 
   } 
   
   /** * @return the fpData */ 
   public FootballPlayerData getFpData() 
   { 
      return fpData; 
   } 
   
   /** * @param fpData the fpData to set */ 
   public void setFpData(FootballPlayerData fpData)
   { 
      this.fpData = fpData; 
   }      
   
}
