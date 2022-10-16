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
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

/**
 *
 * @author intelligence
 */
public class WestPanel implements ActionListener {
   
   private JPanel westpanel;
   
   private CenterPanel centerpanel;
   
   private JButton choice;
   private JButton selectionSort;
   private JButton mergeSort;
   private JButton quickSort;
   
   private int sortType;
   
   private Model.FootballPlayerData FpData;
   
   private View view;
   
   private Controller.Controller controller;
      
   public WestPanel(JPanel initialpanel, CenterPanel centerpanel)
   {
      westpanel = new JPanel();
      
      choice = new JButton("Choose a SORT type : ");
      selectionSort = new JButton("Selection Sort/\nSelf Implemented");
      mergeSort = new JButton("Merge Sort/ArrayList()");
      quickSort = new JButton("Quick Sort/Arrays[]");
      
      initialpanel.add(westpanel, BorderLayout.WEST);
      westpanel.setPreferredSize(new Dimension(250, 250));
      westpanel.setLayout(new GridLayout(4, 1));
      
      westpanel.add(choice);
      choice.setBackground(Color.LIGHT_GRAY);
      
      westpanel.add(selectionSort);
      selectionSort.setBackground(Color.LIGHT_GRAY);
      
      westpanel.add(mergeSort);
      mergeSort.setBackground(Color.LIGHT_GRAY);
      
      westpanel.add(quickSort);   
      quickSort.setBackground(Color.LIGHT_GRAY);    
      
      selectionSort.addActionListener(this);
      quickSort.addActionListener(this);
      mergeSort.addActionListener(this);
      
      this.centerpanel = centerpanel;
   }
   
   /**
    *
    * Accessor for westpanel reference variable with an attribute
    * of type JPanel.
    * 
    * @return the JPanel associated with the WestPanel
    */
   public JPanel getWestPanel()
   {
      return westpanel;
   }
   
   public int getSortType()
   {
      return sortType;
   }
   
   public void setSortType(int sortType)
   {
      this.sortType = sortType;
   }
   
   public void setFpData(Model.FootballPlayerData FpData)
   {
      this.FpData = FpData;
   }
   
   public void setView(View view)
   {
      this.view = view;
   }
   
   public void setController(Controller.Controller controller)
   {
      this.controller = controller;
   }
   
   @Override
   public void actionPerformed(ActionEvent actionEvent)
   {      
      if(selectionSort.getText().equals(actionEvent.getActionCommand()))
      {
         sortType = 1;
      }
      else if(quickSort.getText().equals(actionEvent.getActionCommand()))
      {
         sortType = 3;
      }
      else if(mergeSort.getText().equals(actionEvent.getActionCommand()))
      {
         sortType = 2;
      }
      
      FpData.sort(sortType, centerpanel.getSortField());
      view.CenterUpdate(FpData.getLines(controller.getFirstLine(), controller.getLastLine()), FpData.getHeaders());
      centerpanel.getCenterPanel().repaint();
      centerpanel.getCenterPanel().validate();
   }
   
}
