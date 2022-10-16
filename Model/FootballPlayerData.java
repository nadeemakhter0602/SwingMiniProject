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

import java.beans.XMLDecoder;
import java.util.*;
import java.io.*;

/**
 *
 * @author intelligence
 */
public class FootballPlayerData implements TableData,Displayable,Sortable {
   
   private ArrayList<FootballPlayer> players;
   private FootballPlayer fp = new FootballPlayer();
   int sortType;
   int sortField;
   
   private int firstLineToDisplay;
   private int lineToHighlight;
   private int lastLineToDisplay;
   private int linesBeingDisplayed;
   
   //ArrayList for storing the Comparators
   private ArrayList<Comparator<FootballPlayer>> sortingComparators;
   
   public FootballPlayerData()
   {
      sortingComparators = new ArrayList();
      
      //adding the comparators for each attribute of FootballPlayer to ArrayList
      sortingComparators.add((FootballPlayer f1, FootballPlayer f2) -> Integer.compare(f1.getNumber(), f2.getNumber()));
      sortingComparators.add((FootballPlayer f1, FootballPlayer f2) -> f1.getPosition().compareTo(f2.getPosition()));
      sortingComparators.add((FootballPlayer f1, FootballPlayer f2) -> f1.getName().compareTo(f2.getName()));
      sortingComparators.add((FootballPlayer f1, FootballPlayer f2) -> f1.getHeight().toString().compareTo(f2.getHeight().toString()));
      sortingComparators.add((FootballPlayer f1, FootballPlayer f2) -> Integer.compare(f1.getWeight(), f2.getWeight()));
      sortingComparators.add((FootballPlayer f1, FootballPlayer f2) -> f1.getHometown().compareTo(f2.getHometown()));
      sortingComparators.add((FootballPlayer f1, FootballPlayer f2) -> f1.getHighSchool().compareTo(f2.getHighSchool()));
      
      players = new ArrayList<>();
      loadTable();    
   }
   
   public void ReadPlayersFromXML()
   {
      try
      {         
         FootballPlayer fp;
         XMLDecoder decoder;
         decoder = new XMLDecoder(new BufferedInputStream(new FileInputStream("FootballPlayerTable.xml")));
         fp = new FootballPlayer();
         
         while(fp != null)
         {
            try
            {
               fp = (FootballPlayer) decoder.readObject();
               players.add(fp);
            }
            catch (ArrayIndexOutOfBoundsException theend)
            {
               //System.out.println("end of file");
               break;
            }
         }
         
         decoder.close();         
      }
      catch (Exception xx)
      {
         xx.printStackTrace();         
      }
   }
   
   /**
    *
    * The following method needs to be called in the 
    * constructor to make the table ready and available right away. 
    * 
    * It loads real data into the array list. 
    * 
    * The method ReadPlayersFromXML( ) reads the FootballPlayer objects from 
    * an XML file and loads them into the players ArrayList.
    * 
    */
   @Override
   public void loadTable()
   {
      ReadPlayersFromXML();
   }
   
   /**
    *
    * Returns the full table of data. 
    * Although right now is not required, soon we will need this method 
    * to return a specific ArrayList instead of a generic ArrayList.
    * 
    * @return Returns the full table of data
    */
   @Override
   public ArrayList<FootballPlayer> getTable()
   {
      return players;
   }
   
   /**
    *
    * The method will return an ArrayList of Strings 
    * with the names of the FootballPlayer fields (the "headers").
    * 
    * @return Returns an ArrayList of Strings
    */
   @Override
   public ArrayList<String> getHeaders()
   {
      return fp.getAttributeNames();
   }
   
   /**
    *
    * The method will return an ArrayList of Strings with the values 
    * of the FootballPlayer object in a chosen line "n" in the table.
    * 
    * @param line chosen line "n" in the table of the FootballPlayer Object
    * @return The method will return an ArrayList of Strings
    */
   @Override
   public ArrayList<String> getLine(int line)
   {
      return players.get(line).getAttributes();
   }
   
   /**
    *
    * This methods used the getLine( ) method. 
    * It gets a set of lines (each one of them an array of Strings) 
    * from getLine(int n) and adds them to an array of arrays. 
    * It returns this array of arrays.
    * 
    * @param firstLineToDisplay  Starting line for Array of Arrays
    * @param lastLineToDisplay   Ending line for Array of Arrays
    * @return Returns an Array of Arrays
    */
   @Override
   public ArrayList<ArrayList<String>> getLines(int firstLineToDisplay, int lastLineToDisplay)
   {
      ArrayList<ArrayList<String>> lines = new ArrayList<>();
      
      for(int i = firstLineToDisplay ; i <= lastLineToDisplay ; i++)
      {
         lines.add(getLine(i));
      }
      
      return lines;
   }

   /**
    *
    * This method is about an int attribute that will hold the number 
    * of the first line to be displayed. 
    * 
    * The number represents the index of an element in the array of the 
    * class that implements the TableData interface, i.e the current class 
    * FootballPlayerData.
    * 
    * @return the firstLineToDisplay attribute which represents the index of an 
    * element in the array of FootballPlayerData
    */
   @Override
   public int getFirstLineToDisplay()
   {
      return firstLineToDisplay;
   }
   
   /**
    * This method is about an int attribute that will hold the number 
    * of the first line to be displayed. 
    * 
    * The number represents the index of an element in the array of the 
    * class that implements the TableData interface, i.e the current class 
    * FootballPlayerData.
    * 
    * @param firstLineToDisplay The number represents the index of an element in 
    * the array of FootballPlayerData
    */
   @Override
   public void setFirstLineToDisplay(int firstLineToDisplay)
   {
      this.firstLineToDisplay = firstLineToDisplay;
   }
   
   /**
    *
    * This method is about an int attribute that will hold 
    * the number of the line on the screen that should be highlighted. 
    * 
    * @return returns number of line on the screen to be highlighted
    */
   @Override
   public int getLineToHighlight()
   {
      return lineToHighlight;
   }
   
   /**
    *
    * This method is about an int attribute that will hold 
    * the number of the line on the screen that should be highlighted. 
    *  
    * @param lineToHighlight the line number to be highlighted
    */
   @Override
   public void setLineToHighlight(int lineToHighlight)
   {
      this.lineToHighlight = lineToHighlight;
   }
   
   /**
    * 
    * This method is about an int attribute that 
    * will hold the number of the last line to be displayed. 
    * 
    * The number represents the index of an element in the 
    * array of the class that implements the TableData interface, i.e
    * the current class FootballPlayerData.
    * 
    * @return returns the number representing the index of an element in 
    * an array of FootballPlayerData
    */
   @Override
   public int getLastLineToDisplay()
   {
      return lastLineToDisplay;
   }
   
   /**
    * 
    * This method is about an int attribute that 
    * will hold the number of the last line to be displayed. 
    * 
    * The number represents the index of an element in the 
    * array of the class that implements the TableData interface, i.e
    * the current class FootballPlayerData.
    * 
    * @param lastLineToDisplay it's the number representing the index of an element in
    * an array of FootballPlayerData
    */
   @Override
   public void setLastLineToDisplay(int lastLineToDisplay)
   {
      this.lastLineToDisplay = lastLineToDisplay;
   }
   
   /**
    * 
    * This method is about an int attribute that will hold 
    * the number of the lines that will appear on 
    * the screen at one time. 
    * 
    * It will be most likely 20 but it should a variable. 
    * The application should work with any number of lines. 
    * So if this number is set to 10 or 15, 
    * this is the number of lines that should appear on the screen.
    * 
    * @return the number of lines appearing on the screen at once
    */
   @Override
   public int getLinesBeingDisplayed()
   {
      return linesBeingDisplayed;
   }
   
   /**
    * 
    * This method is about an int attribute that will hold 
    * the number of the lines that will appear on 
    * the screen at one time. 
    * 
    * It will be most likely 20 but it should a variable. 
    * The application should work with any number of lines. 
    * So if this number is set to 10 or 15, 
    * this is the number of lines that should appear on the screen.
    * 
    * @param linesBeingDisplayed number of lines appearing on screen at once
    */
   @Override
   public void setLinesBeingDisplayed(int linesBeingDisplayed)
   {
      this.linesBeingDisplayed = linesBeingDisplayed;
   }
   
   /**
    *
    * This is the method that will execute the sort itself. 
    * It will choose the sort algorithm based on the input parameter sortType,
    * and choose the field to the be sorted based on the input parameter 
    * sortField.
    * 
    * @param sortType an int number (1,2 or 3) to represent the user choice of algorithm
    * @param sortField an int number (0 to n) to represent the user choice of the field
    */
   @Override
   public void sort(int sortType, int sortField)
   {
      if(sortType == 1 && sortField >= 0 && sortField < fp.getAttributeNames().size())
      {
         selectionSort(players, sortingComparators.get(sortField));
      }
      else if(sortType == 2 && sortField >= 0 && sortField < fp.getAttributeNames().size())
      {
         Collections.sort(players, sortingComparators.get(sortField));
      }
      else if(sortType == 3 && sortField >= 0 && sortField < fp.getAttributeNames().size())
      {        
         //Temporary Array to store the FootballPlayer objects for conversion
         //to array so that we can use Arrays.sort() method
         FootballPlayer[] objects = new FootballPlayer[players.size()];
         
         for(int i = 0 ; i < players.size() ; i++)
         {
            objects[i] = players.get(i);
         }
         
         Arrays.sort(objects, sortingComparators.get(sortField));         
         players = new ArrayList<>();
         players.addAll(Arrays.asList(objects));
      }
   }

   /**
    *
    * Returns an int number (1,2 or 3) to represent the user choice of 
    * algorithm updating the sortType attribute. 
    *    (1) Selection
    *    (2) Merge/ArrayList()
    *    (3) Quick/Arrays[]
    * 
    * @return an int number (1,2 or 3) to represent the user choice of algorithm
    */
   @Override
   public int getSortType() 
   {
      return sortType;
   }

   /**
    *
    * Sets an int number (1,2 or 3) to represent the user choice of 
    * algorithm updating the sortType attribute. 
    *    (1) Selection
    *    (2) Merge/ArrayList()
    *    (3) Quick/Arrays[]
    * 
    * @param sortType an int number (1,2 or 3) to represent the user choice of algorithm
    */
   @Override
   public void SetSortType(int sortType) 
   {
      this.sortType = sortType;
   }

   /**
    *
    * Returns an int number (0 to n) to represent 
    * the user choice of the field to be used as the sort key.
    * 
    * @return an int number (0 to n) to represent the user choice of the field
    */
   @Override
   public int getSortField() 
   {
      return sortField;
   }

   /**
    *
    * Defines a new value for sortField.
    * 
    * @param sortField an int number (0 to n) to represent the user choice of the field
    */
   @Override
   public void SetSortField(int sortField) 
   {
      this.sortField = sortField;
   }

   private void selectionSort(ArrayList<FootballPlayer> players, Comparator<FootballPlayer> comparator) 
   {
      int currentMinIndex;
      for(int i = 0 ; i < players.size() ; i++)
      {
         currentMinIndex = i;
         for(int j = i + 1 ; j < players.size() ; j++)
         {
            if(comparator.compare(players.get(j), players.get(currentMinIndex)) < 0)
            {
               currentMinIndex = j;
            }
         }
         Collections.swap(players, currentMinIndex, i);
      }
   }
   
}
