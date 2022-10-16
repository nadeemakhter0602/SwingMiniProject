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
import java.util.ArrayList;
import javax.swing.*;

/**
 *
 * @author intelligence
 */
public class View {
   
   private InitialFrame initialframe;
               
   /**
    * To avoid problems (including the potential for deadlock), 
    * all Swing GUI components must be created and updated 
    * from the event dispatching thread, not the main 
    * thread of the application. 
    */
   public View()
   {
      SwingUtilities.invokeLater(new Runnable() 
      { 
         @Override
         public void run() 
         { 
            initialframe = new InitialFrame();      
         } 
      });
      
   }
      
   /**
    * 
    * Control calls a method in view with the number of lines with
    * columns to be displayed. Here View has to access InitialFrame, and 
    * InitialPanel to access the method in CenterPanel which will create
    * the header and line buttons in place, without text yet.
    * 
    * @param linesBeingDisplayed number of rows with data to be displayed
    * @param headerSize number of headers i.e columns to be displayed
    */
   public void CenterInitialSetup(int linesBeingDisplayed, int headerSize)
   {
      
      initialframe.getInitialPanel().getCenterPanel().createButtons(linesBeingDisplayed, headerSize);
      
      initialframe.getInitialFrame().validate();
      initialframe.getInitialPanel().getInitialPanel().validate();
      initialframe.getInitialPanel().getCp().validate();
      
      initialframe.getInitialFrame().repaint();
      initialframe.getInitialPanel().getInitialPanel().repaint();
      initialframe.getInitialPanel().getCp().repaint();
      
   }              
   
   /**
    * 
    * Controller calls a method in View which in turn sends the actual
    * data to be displayed in the header and line buttons,to the 
    * CenterPanel. View has to access InitialFrame and InitialPanel to call
    * the method in CenterPanel. The parameters are received from model and 
    * contain actual text from the data tables.
    * 
    * @param data An array of arrays containing football player data
    * @param headers An ArrayList containing the headers of football player data
    */
   public void CenterUpdate(ArrayList<ArrayList<String>> data, ArrayList<String> headers)
   {
      initialframe.getInitialPanel().getCenterPanel().setButtonsData(data, headers);
      
      initialframe.getInitialFrame().validate();
      initialframe.getInitialPanel().getInitialPanel().validate();
      initialframe.getInitialPanel().getCp().validate();
      
      initialframe.getInitialFrame().repaint();
      initialframe.getInitialPanel().getInitialPanel().repaint();
      initialframe.getInitialPanel().getCp().repaint();      
   }
   
   /**
    * 
    * Method to access the initialframe attribute.
    * 
    * @return returns an attribute of type InitialFrame
    */
   public InitialFrame getInitialFrame()
   {
      return initialframe;
   }

   /**
    * 
    * Method to mutate the initialframe attribute.
    * 
    * @param initialframe parameter of InitialFrame type
    */
   public void setInitialFrame(InitialFrame initialframe)
   {
      this.initialframe = initialframe;
   }           
}
