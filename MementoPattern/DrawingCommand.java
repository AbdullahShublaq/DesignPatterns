package MementoPattern;

import java.awt.Graphics;

public interface DrawingCommand {

    public void execute();

    public void unexecute();

    public void setGraphics(Graphics g);
}
