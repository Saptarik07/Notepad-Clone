import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.UndoManager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI implements ActionListener {
    JFrame window;
    //TEXT AREA
    JTextArea textArea;
    JScrollPane scrollPane;
    boolean wordWrapOn = false;
    // TOP MENU BAR
    JMenuBar menuBar;
    JMenu menuFile, menuEdit, menuFormat, menuColor;
    //FILE MENU
    JMenuItem iNew, iOpen, iSave, iSaveAs, iExit;
    //EDIT MENU
    JMenuItem iUndo,iRedo;
    //FORMAT MENU
    JMenuItem iWrap,iFontArial,iFontCSMS,iFontTNR,iFontSize8,iFontSize12,iFontSize16,iFontSize20,iFontSize24,iFontSize28;
    JMenu menuFont,menuFontsize;
    //COLOR MENU
    JMenuItem iColor1,iColor2,iColor3,iColor4,iColor5;

    Function_file file = new Function_file(this);
    Function_format format = new Function_format(this);
    Function_color color = new Function_color(this);
    Function_edit edit = new Function_edit(this);

    keyHandler kh = new keyHandler(this);


    UndoManager um = new UndoManager();
    public static void main(String args[]) {
        new GUI();
    }

    public GUI() {
        CreateWindow();
        CreateTextArea();
        createMenuBar();
        CreateMenuItems();
        createEditMenu();
        CreateFormatmenu();
        createColorMenu();

        format.selectedFont = "Arial";
        format.createFont(16);
        format.wordWrap();
        color.changeColor("White");
        window.setVisible(true);
    }

    public void CreateWindow() {
        window = new JFrame("Notepad");
        window.setSize(800, 600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void CreateTextArea() {
        textArea = new JTextArea();
        textArea.setFont(format.arial);

        textArea.addKeyListener(kh);


        textArea.getDocument().addUndoableEditListener(
            new UndoableEditListener() {
                public void undoableEditHappened(UndoableEditEvent e){
                    um.addEdit(e.getEdit());
                }
            }
        );
        scrollPane = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        window.add(scrollPane);
        window.add(textArea);
    }

    public void createMenuBar() {
        menuBar = new JMenuBar();
        window.setJMenuBar(menuBar);
        menuFile = new JMenu("File");
        menuBar.add(menuFile);

        menuEdit = new JMenu("Edit");
        menuBar.add(menuEdit);

        menuFormat = new JMenu("Format");
        menuBar.add(menuFormat);

        menuColor = new JMenu("Color");
        menuBar.add(menuColor);
    }

    public void CreateMenuItems() {
        iNew = new JMenuItem("New");
        iNew.addActionListener(this);
        iNew.setActionCommand("New");
        menuFile.add(iNew);

        iOpen = new JMenuItem("Open");
       iOpen.addActionListener(this);
        iOpen.setActionCommand("Open"); 
        menuFile.add(iOpen);

        iSave = new JMenuItem("Save");
        iSave.addActionListener(this);
        iSave.setActionCommand("Save");
        menuFile.add(iSave);

        iSaveAs = new JMenuItem("Save As");
        iSaveAs.addActionListener(this);
        iSaveAs.setActionCommand("Save As");
        menuFile.add(iSaveAs);

        iExit = new JMenuItem("Exit");
        iExit.addActionListener(this);
        iExit.setActionCommand("Exit");
        menuFile.add(iExit);
    }

    public void createEditMenu(){
       iUndo = new JMenuItem("Undo");
       iUndo.addActionListener(this);
       iUndo.setActionCommand("Undo");
       menuEdit.add(iUndo);

       iRedo = new JMenuItem("Redo");
       iRedo.addActionListener(this);
       iRedo.setActionCommand("Redo");
       menuEdit.add(iRedo);
    }
    
    public void CreateFormatmenu(){
        iWrap = new JMenuItem("Word Wrap: Off");
        iWrap.addActionListener(this);
        iWrap.setActionCommand("Word Wrap");
        menuFormat.add(iWrap);

        menuFont = new JMenu("Font");
        menuFormat.add(menuFont);

        iFontArial = new JMenuItem("Arial");
        iFontArial.addActionListener(this);
        iFontArial.setActionCommand("Arial");
        menuFont.add(iFontArial);

        iFontCSMS = new JMenuItem("Comic Sans MS");
        iFontCSMS.addActionListener(this);
        iFontCSMS.setActionCommand("Comic San MS");
        menuFont.add(iFontCSMS);

        iFontTNR = new JMenuItem("Times New Roman");
        iFontTNR.addActionListener(this);
        iFontTNR.setActionCommand("Times New Roman");
        menuFont.add(iFontTNR);

        menuFontsize = new JMenu("Font Size");
        menuFormat.add(menuFontsize);

        iFontSize8 = new JMenuItem("8");
        iFontSize8.addActionListener(this);
        iFontSize8.setActionCommand("size 8");
        menuFontsize.add(iFontSize8);

        iFontSize12 = new JMenuItem("12");
        iFontSize12.addActionListener(this);
        iFontSize12.setActionCommand("size 12");
        menuFontsize.add(iFontSize12);

        iFontSize16 = new JMenuItem("16");
        iFontSize16.addActionListener(this);
        iFontSize16.setActionCommand("size 16");
        menuFontsize.add(iFontSize16);

        iFontSize20 = new JMenuItem("20");
        iFontSize20.addActionListener(this);
        iFontSize20.setActionCommand("size 20");
        menuFontsize.add(iFontSize20);

        iFontSize24 = new JMenuItem("24");
        iFontSize24.addActionListener(this);
        iFontSize24.setActionCommand("size 24");
        menuFontsize.add(iFontSize24);

        iFontSize28 = new JMenuItem("28");
        iFontSize28.addActionListener(this);
        iFontSize28.setActionCommand("size 28");
        menuFontsize.add(iFontSize28);
    }

    public void createColorMenu(){
       iColor1 = new JMenuItem("White");
       iColor1.addActionListener(this);
       iColor1.setActionCommand("White");
       menuColor.add(iColor1);

       iColor2 = new JMenuItem("Black");
       iColor2.addActionListener(this);
       iColor2.setActionCommand("Black");
       menuColor.add(iColor2);

       iColor3 = new JMenuItem("Red");
       iColor3.addActionListener(this);
       iColor3.setActionCommand("Red");
       menuColor.add(iColor3);

       iColor4 = new JMenuItem("Green");
       iColor4.addActionListener(this);
       iColor4.setActionCommand("Green");
       menuColor.add(iColor4);

       iColor5 = new JMenuItem("Blue");
       iColor5.addActionListener(this);
       iColor5.setActionCommand("Blue");
       menuColor.add(iColor5);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch (command) {
            case "New":
                file.newFile();
                break;

            case "Open":
                file.open();
                break;
            
            case "Save":
             file.save();
             break;

             
            case "Save As":
             file.saveAs();
             break;
            
            case "Exit":
             file.exit();
             break;

             case "Undo":
             edit.undo();
             break;

             case "Redo":
             edit.redo();
             break;

             case "Word Wrap":
             format.wordWrap();
             break;

             case "Arial":
             format.setFont(command);
             break;


             case "Comic San MS":
             format.setFont(command);
             break;

             case "Times New Roman":
             format.setFont(command);
             break;


             case "size 8":
             format.createFont(8);
             break;

             case "size 12":
             format.createFont(12);
             break;

             case "size 16":
             format.createFont(16);
             break;

             case "size 20":
             format.createFont(20);
             break;

             case "size 24":
             format.createFont(24);
             break;

             case "size 28":
             format.createFont(28);
             break;

             case "White":
             color.changeColor(command);
             break;

             case "Black":
             color.changeColor(command);
             break; 

             case "Red":
             color.changeColor(command);
             break;

             case "Green":
             color.changeColor(command);
             break;

             case "Blue":
             color.changeColor(command);
             break;
        }
    }
}
