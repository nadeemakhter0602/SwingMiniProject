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
package View;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

/**
 *
 * @author intelligence
 */
public class CenterPanel implements ActionListener {
   
   private JPanel centerpanel;
   
   private ArrayList<JButton> headerButtons;
   private ArrayList<ArrayList<JButton>> lineButtons;
   
   private int sortField = -1;
      
   public CenterPanel(JPanel initialpanel)
   {
      centerpanel = new JPanel();
      initialpanel.add(centerpanel);
      centerpanel.setBackground(Color.BLACK);
      headerButtons = new ArrayList<>();
      lineButtons = new ArrayList<>();
   }
   
   /**model.getFpData()
    * 
    * Creates the header and line buttons in the InitialPanel 
    * which in turn is a component of the JFrame named InitialFrame.
    * 
    * @param linesBeingDisplayed number of lines to be displayed in rows
    * @param headerSize number of headers to be displayed in columns
    */
   public void createButtons(int linesBeingDisplayed, int headerSize)
   {
      centerpanel.setLayout(new GridLayout(linesBeingDisplayed + 1, headerSize, 2, 2));
            
      ArrayList<JButton> lineButtonRow;
            
      for(int i = 0 ; i < headerSize ; i++ )
      {
         JButton headerButton = new JButton();
         headerButton.setBackground(Color.LIGHT_GRAY);
         centerpanel.add(headerButton);         
         headerButtons.add(headerButton);
      }
      
      for(int i = 0 ; i < linesBeingDisplayed ; i++)
      {         
         lineButtonRow = new ArrayList<>();
         
         for(int j = 0 ; j < headerSize ; j++)
         {
            JButton lineButton = new JButton();
            centerpanel.add(lineButton);
            lineButtonRow.add(lineButton);
         }
         
         lineButtons.add(lineButtonRow);         
      }  
   }
      
   /**
    *
    * Sets the text on the buttons which it gets from the Controller
    * which in turn gets it from Model. Has an Array of Arrays with data
    * of each football player and an ArrayList with the header Strings.
    * 
    * @param data data of each football player in a nested ArrayList
    * @param headers headers of the player data in an ArrayList
    */
   public void setButtonsData(ArrayList<ArrayList<String>> data, ArrayList<String> headers)
   {
      for(int i = 0 ; i < data.size() ; i++)
      {
         for(int j = 0 ; j < headers.size() ; j++)
         {
            lineButtons.get(i).get(j).setText(data.get(i).get(j));
         }
      }
      
      for(int i = 0 ; i < headers.size() ; i++)
      {
         headerButtons.get(i).setText(headers.get(i));
         headerButtons.get(i).addActionListener(this);
      }
   }
      
   /**
    *
    * Method to access the JPanel centerpanel attribute.
    * 
    * @return an attribute of type JPanel
    */
   public JPanel getCenterPanel()
   {
      return centerpanel;
   }

   /**
    *
    * Method to mutate the JPanel centerpanel attribute.
    * 
    * @param centerpanel a parameter of type JPanel
    */
   public void setCenterPanel(JPanel centerpanel)
   {
      this.centerpanel = centerpanel;
   }
   
   /**
    *
    * Returns the ArrayList with references to the header buttons.
    * 
    * @return returns an ArrayList of references to the header buttons.
    */
   public ArrayList<JButton> getheaderButtons()
   {
      return headerButtons;
   }
   
   /**
    *
    * Takes an ArrayList of JButtons as parameter and sets the 
    * headerButtons attribute.
    * 
    * @param headerButtons parameter with references to JButtons
    */
   public void setheaderButtons(ArrayList<JButton> headerButtons)
   {
      this.headerButtons = headerButtons;
   }
   
   /**
    *
    * Returns the nested ArrayList with references to the line buttons.
    * 
    * @return returns a nested ArrayList of references to the line buttons.
    */
   public ArrayList<ArrayList<JButton>> getlineButtons()
   {
      return lineButtons;
   }
   
   /**
    *
    * Takes a nested ArrayList of JButtons as parameter and sets the 
    * lineButtons attribute.
    * 
    * @param lineButtons parameter with references to the new line buttons
    */
   public void setlineButtons(ArrayList<ArrayList<JButton>> lineButtons)
   {
      this.lineButtons = lineButtons;
   }

   public void setSortField(int sortField)
   {
      this.sortField = sortField;
   } 
   
   public int getSortField()
   {
      return sortField;
   }

   /**
    *
    * The following method is for listening to action triggers
    * in the header buttons and make appropriate changes to them.
    * 
    * @param actionEvent this is the reference variable for the action trigger
    */
   @Override
   public void actionPerformed(ActionEvent actionEvent)
   {
      for(JButton button : headerButtons)
      {
         if(button.getText().equals(actionEvent.getActionCommand()))
         {
            button.setBackground(Color.darkGray);
            button.setForeground(Color.white);
            sortField = headerButtons.indexOf(button);
            System.out.println(sortField);
         }
         else
         {
            button.setForeground(Color.black);
            button.setBackground(Color.lightGray);
         }
      }
   }
   
}
