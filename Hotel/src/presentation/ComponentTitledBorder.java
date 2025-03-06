package presentation;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.Point;
import java.awt.Rectangle;


import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JComponent;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;

public class ComponentTitledBorder implements Border, MouseListener, SwingConstants{ 
	       private int offset = 5; 
	    
	       private Component comp; 	       
		   private JComponent container; 
	       private Rectangle rect; 
	       private Border border; 
	       private JToggleButton toggleB;
    
       public ComponentTitledBorder(Component comp, JComponent container, Border border){ 
           this.comp = comp; 
           this.container = container; 
           this.border = border; 
           this.container.addMouseListener(this); 
           this.toggleB = ((JToggleButton) comp);
           
       } 
                 
       public boolean isBorderOpaque(){ 
           return true; 
       } 
    
       public void paintBorder(Component c, Graphics g, int x, int y, int width, int height){ 
           Insets borderInsets = border.getBorderInsets(c); 
           Insets insets = getBorderInsets(c); 
           int temp = (insets.top-borderInsets.top)/2; 
           border.paintBorder(c, g, x, y+temp, width, height-temp); 
           Dimension size = comp.getPreferredSize(); 
           rect = new Rectangle(offset, 0, size.width, size.height); 
           SwingUtilities.paintComponent(g, comp, (Container)c, rect); 
       } 
    
       public Insets getBorderInsets(Component c){ 
           Dimension size = comp.getPreferredSize(); 
           Insets insets = border.getBorderInsets(c); 
           insets.top = Math.max(insets.top, size.height); 
           return insets; 
       } 
    
       private void dispatchEvent(MouseEvent me){ 
           if(rect!=null && rect.contains(me.getX(), me.getY())){ 
               Point pt = me.getPoint(); 
               pt.translate(-offset, 0); 
               comp.setBounds(rect); 
               comp.dispatchEvent(new MouseEvent(comp, me.getID() 
                       , me.getWhen(), me.getModifiers() 
                       , pt.x, pt.y, me.getClickCount() 
                       , me.isPopupTrigger(), me.getButton())); 
               if(!comp.isValid()) 
                   container.repaint(); 
           } 
       } 
    
       public void mouseClicked(MouseEvent me){ 
           dispatchEvent(me); 
       } 
    
       public void mouseEntered(MouseEvent me){ 
           dispatchEvent(me); 
       } 
    
       public void mouseExited(MouseEvent me){ 
           dispatchEvent(me); 
       } 
    
       public void mousePressed(MouseEvent me){ 
           dispatchEvent(me); 
       } 
    
       public void mouseReleased(MouseEvent me){ 
           dispatchEvent(me); 
       } 
       public Component getComp() {
			return comp;
		}

		public void setComp(Component comp) {
			this.comp = comp;
		}

   }