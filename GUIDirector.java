import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Swayze on 9/4/2016.
 *
 * Designed to be the go-to guy for the interface. Houses the frame, panel, and other interface things.
 *
 */
public class GUIDirector extends Thread{

    private cWindowAdapter cwa;
    private cFrame frame;
    private cPanel panel;

    private int FRAME_WIDTH;
    private int FRAME_HEIGHT;

    private int PAINT_DELAY;    /// Number of milliseconds the GUI waits before refreshing the screen.
    private boolean CONTINUE_PAINTING;

    private ArrayList<DrawableObject> drawables;

    public GUIDirector() {
        //  Initialize stuff,
        initializeParams();
        initializeFrame();
        initializePanel();
        //  Add the canvas to the panel,
        frame.add(panel);
        //  And begin.
        start();
    }

    private void initializeParams(){
        drawables = new ArrayList<DrawableObject>();
        PAINT_DELAY = 50;
        CONTINUE_PAINTING = true;
    }

    private void initializeFrame() {
        frame = new cFrame("TESTING");
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        cwa = new cWindowAdapter();
        frame.addWindowListener(cwa);
        frame.setVisible(true);
    }

    private void initializePanel() {
        panel = new cPanel(frame.getWidth(),frame.getHeight());
        panel.loadToScreen(drawables);
        panel.repaint();
    }

    //  Called when 'start()' is called.
    public void run(){
        try{
            while(CONTINUE_PAINTING) {
                Thread.sleep(PAINT_DELAY);
                panel.loadToScreen(drawables);
            }
        } catch(InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + " was interrupted");
        }
    }

    //  Sets the time interval for refreshing graphics
    public void setPaintDelay(int delay){
        PAINT_DELAY = delay;
    }

    //  Toggles refreshing of graphics. Basically all images get frozen in place, but the game logic keeps ticking.
    public void togglePainting(){
        CONTINUE_PAINTING = !CONTINUE_PAINTING;
    }

    //Sets the size of the frame;   takes in two integers, width and height;
    public void setFrameSize(int width, int height) {
        frame.setSize(width, height);
    }

    //  Sets the size of the Canvas (panel) to that of its parent frame;
    public void matchCanvasSize() {
        setPanelSize(frame.getWidth(),frame.getHeight());
    }

    //Sets the size of the panel;   takes in two integers, width and height;
    public void setPanelSize(int width, int height) {
        panel.setSize(width, height);
    }

    //Sets the size of the frame;
    public void setBackgroundColor(Color color) {
        panel.setBackgroundColor(color);
    }

    //  Adds a DrawableObject to the drawables list, which is then drawn onscreen by the panel at every cycle.
    public void addToDrawables(DrawableObject obj){
        if(!drawables.contains(obj)){
            drawables.add(obj);
        }
    }

    //  Removes a DrawableObject from the drawables list, which is then drawn onscreen by the panel at every cycle.
    public void removeFromDrawables(DrawableObject obj){
        if(drawables.contains(obj)){
            drawables.remove(obj);
        }
    }
}
