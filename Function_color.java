import java.awt.Color;

public class Function_color {
    GUI gui;

    public Function_color(GUI gui){

        this.gui = gui;
    }

    public void changeColor(String color){
          
        switch(color){
          case "White":
          gui.window.getContentPane().setBackground(Color.white);
          gui.textArea.setBackground(Color.white);
          gui.textArea.setForeground(Color.black);
          break;

          case "Black":
          gui.window.getContentPane().setBackground(Color.black);
          gui.textArea.setBackground(Color.black);
          gui.textArea.setForeground(Color.white);
          break;

          case "Red":
          gui.window.getContentPane().setBackground(new Color(255,0,0));
          gui.textArea.setBackground(new Color(255,0,0));
          gui.textArea.setForeground(Color.white);
          break;

          
          case "Green":
          gui.window.getContentPane().setBackground(new Color(0,255,0));
          gui.textArea.setBackground(new Color(0,255,0));
          gui.textArea.setForeground(Color.white);
          break;

          
          case "Blue":
          gui.window.getContentPane().setBackground(new Color(0,0,255));
          gui.textArea.setBackground(new Color(0,0,255));
          gui.textArea.setForeground(Color.white);
          break;
        }
    }
    
}
