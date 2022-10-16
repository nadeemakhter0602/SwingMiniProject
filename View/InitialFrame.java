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

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author intelligence
 */
public class InitialFrame {
   
   private InitialPanel initialpanel;
   private JFrame initialframe;
   
   public InitialFrame()
   {      
      initialframe = new JFrame("Table Viewer");
      initialframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      initialframe.setExtendedState(JFrame.MAXIMIZED_BOTH);
      initialframe.setVisible(true);
      initialpanel = new InitialPanel(initialframe);
   }
      
   /**
    *
    * Accessor for initialpanel attribute.
    * 
    * @return returns an attribute of type InitialPanel
    */
   public InitialPanel getInitialPanel()
   {
      return initialpanel;
   }
   
   /**
    * 
    * Accessor for initialframe attribute.
    * 
    * @return returns an attribute of type JFrame
    */
   public JFrame getInitialFrame()
   {
      return initialframe;
   }

   /**
    *
    * Mutator for initialpanel attribute.
    * 
    * @param initialpanel parameter of InitialPanel type
    */
   public void setInitialPanel(InitialPanel initialpanel)
   {
      this.initialpanel = initialpanel;
   }
   
   /**
    * 
    * Mutator for initialframe attribute.
    * 
    * @param initialframe parameter of JFrame type
    */
   public void setInitialFrame(JFrame initialframe)
   {
      this.initialframe = initialframe;
   }
           
   
}
