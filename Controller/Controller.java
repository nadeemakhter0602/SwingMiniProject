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
package Controller;

import java.awt.event.*;

/**
 *
 * @author intelligence
 */
public class Controller {
   
   Model.Model model; 
   View.View view;
   
   int firstLine;
   int lastLine;
   int FpDataSize;
   int numberOfLines;
   
   public Controller(Model.Model m, View.View v) 
   { 
      model = m; 
      view = v; 
      
      view.getInitialFrame().getInitialPanel().getWestPanel().setFpData(model.getFpData());
      view.getInitialFrame().getInitialPanel().getWestPanel().setView(view);
      view.getInitialFrame().getInitialPanel().getWestPanel().setController(this);      
      
      model.getFpData().setFirstLineToDisplay(0);
      model.getFpData().setLinesBeingDisplayed(20);
      
      firstLine = model.getFpData().getFirstLineToDisplay();
      lastLine = model.getFpData().getLinesBeingDisplayed() + firstLine - 1;
      numberOfLines = model.getFpData().getLinesBeingDisplayed();
      FpDataSize = model.getFpData().getTable().size();
      
      model.getFpData().setLastLineToDisplay(model.getFpData().getLinesBeingDisplayed() + model.getFpData().getFirstLineToDisplay() - 1);            
      
      view.CenterInitialSetup(model.getFpData().getLinesBeingDisplayed(), model.getFpData().getHeaders().size());
      view.CenterUpdate(model.getFpData().getLines(model.getFpData().getFirstLineToDisplay(), model.getFpData().getLastLineToDisplay()), model.getFpData().getHeaders()); 
      addScrolling();
   }
   
   public int getFirstLine()
   {
      return firstLine;
   }
   
   public int getLastLine()
   {
      return lastLine;
   }
   
   private void addScrolling()
   {
      view.getInitialFrame().getInitialPanel().getCp().addMouseWheelListener(
              new MouseWheelListener()
              {
                 @Override
                 public void mouseWheelMoved(MouseWheelEvent e)
                 {
                    int units = e.getUnitsToScroll();

                    if(lastLine + units < FpDataSize && firstLine + units >= 0)
                    {
                       firstLine += units;
                       lastLine += units;                       
                    }
                    
                    if(0 - firstLine >= units)
                    {
                       firstLine = 0;
                       lastLine = numberOfLines - 1;
                    }
                    else if(FpDataSize - lastLine <= units)
                    {
                       lastLine = FpDataSize - 1;
                       firstLine = lastLine - (numberOfLines - 1);
                    }
                    view.CenterUpdate(model.getFpData().getLines(firstLine, lastLine), model.getFpData().getHeaders());                    
                 }
              }
      );
   }
   
}
