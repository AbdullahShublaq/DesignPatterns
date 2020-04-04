package MementoPattern;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import MementoPattern.ControlPanel.ControlPanelListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FreeDrawApp extends JFrame {

    DrawCommandManager manager;

    public FreeDrawApp() {
        this.setTitle("draw app");
        manager = new DrawCommandManager();

        this.setSize(400, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setLayout(new BorderLayout());
        this.getContentPane().setBackground(Color.WHITE);
        final DrawingPanel drawPanel = new DrawingPanel(manager);
        this.getContentPane().add(drawPanel, BorderLayout.CENTER);
        String[] btns = {"Undo", "Redo"};
        ControlPanel cp = new ControlPanel(btns);
        cp.addControlPanelListener(new ControlPanelListener() {

            @Override
            public void buttonPressed(String btnName) {
                if (btnName.equals("Undo")) {
                    manager.undo();

                } else if (btnName.equals("Redo")) {
                    manager.redo();
                }
            }

        });
        
        //TODO For Memento Pattern
        this.addWindowListener(new WindowAdapter() {
            //save the commands when close the window
            @Override
            public void windowClosing(WindowEvent e) {
                try {
                    FileOutputStream fos = new FileOutputStream(new File("").getAbsolutePath().concat("\\src\\MementoPattern\\commands.dat"));
                    ObjectOutputStream oos = new ObjectOutputStream(fos);
                    oos.writeObject(manager.getCommands());
                    oos.close();
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(FreeDrawApp.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(FreeDrawApp.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            @Override
            public void windowDeiconified(WindowEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void windowIconified(WindowEvent e) {
                // TODO Auto-generated method stub

            }

        });
        //end 

        this.getContentPane().add(cp, BorderLayout.SOUTH);
        this.setLocationRelativeTo(null);
        this.setVisible(true);

        //TODO For Memento Pattern
        try {
            String path = new File("").getAbsolutePath().concat("\\src\\MementoPattern\\commands.dat");
            File f = new File(path);
            if (f.exists()) {
                FileInputStream fis = new FileInputStream(f);
                ObjectInputStream ois = new ObjectInputStream(fis);
                List<DrawingCommand> savedCommands = (List<DrawingCommand>)ois.readObject();
                manager.loadCommands(savedCommands);
                for(DrawingCommand command: savedCommands){
                    command.setGraphics(this.getGraphics());
                    command.execute();
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FreeDrawApp.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FreeDrawApp.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FreeDrawApp.class.getName()).log(Level.SEVERE, null, ex);
        }
        //end
    }

    public static void main(String args[]) {
        new FreeDrawApp();
    }

}
