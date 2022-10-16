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
public class InitialPanel {
   
   private CenterPanel centerpanel;
   private WestPanel westpanel;
   
   private JPanel initialpanel;
   private JPanel northpanel;
   private JPanel southpanel;
   
   private JLabel northlabel;
   private JLabel southlabel;
      
   public InitialPanel(JFrame initialframe)
   {
      initialpanel = new JPanel();
      initialpanel.setLayout(new BorderLayout());
      
      initialframe.add(initialpanel);
      
      northpanel = new JPanel();
      northpanel.setBackground(Color.BLACK);
      northlabel = new JLabel("North Panel");
      northlabel.setForeground(Color.white);
      northpanel.add(northlabel);
      
      initialpanel.add(northpanel, BorderLayout.NORTH);
      
      southpanel = new JPanel();
      southpanel.setBackground(Color.BLACK);
      southlabel = new JLabel("South Panel");
      southlabel.setForeground(Color.white);      
      southpanel.add(southlabel);   

      initialpanel.add(southpanel, BorderLayout.SOUTH);      
      
      centerpanel = new CenterPanel(initialpanel);
      westpanel = new WestPanel(initialpanel, centerpanel);
   }
      
   /**
    *
    * Accessor to get the CenterPanel JPanel.
    * 
    * @return returns the JPanel of CenterPanel
    */
   public JPanel getCp()
   {
      return centerpanel.getCenterPanel();
   }
   
   /**
    *
    * Accessor for centerpanel attribute.
    * 
    * @return returns an attribute of type CenterPanel
    */
   public CenterPanel getCenterPanel()
   {
      return centerpanel;
   }

   /**
    *
    * Accessor for initialpanel attribute.
    * 
    * @return returns an attribute of type JPanel
    */
   public JPanel getInitialPanel()
   {
      return initialpanel;
   }

   /**
    *
    * Mutator to set the CenterPanel JPanel.
    * 
    * @param centerpanel parameter of type JPanel to set the centerpanel
    */
   public void setCp(JPanel centerpanel)
   {
      this.centerpanel.setCenterPanel(centerpanel);
   }
   
   /**
    *
    * Mutator for centerpanel attribute.
    * 
    * @param centerpanel parameter of type CenterPanel
    */
   public void setCenterPanel(CenterPanel centerpanel)
   {
      this.centerpanel = centerpanel;
   }

   /**
    *
    * Mutator for initialpanel attribute.
    * 
    * @param initialpanel parameter of type JPanel to set the initialpanel
    */
   public void setInitialPanel(JPanel initialpanel)
   {
      this.initialpanel = initialpanel;
   }
   
   /**
    *
    * Accessor for westpanel reference variable with an attribute
    * of type WestPanel.
    * 
    * @return the reference variable associated with the WestPanel
    */
   public WestPanel getWestPanel()
   {
      return westpanel;
   }
   
}
