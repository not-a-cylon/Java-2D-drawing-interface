import java.awt.*;

/**
 * Created by Swayze on 9/4/2016.
 * The brain of the program, subject to change drastically based on whatever program the panels and frames end up being used for.
 */
public class Launch {

    private GUIDirector gui;

    private boolean KEEP_GOING = true;          //  While true, the game brain will keep running;

    private int PAINT_DELAY = 10;               //  Delay between painting frames;
    private int LOGIC_DELAY = 100;               //  Delay between processing data (if it's even needed)

    private int FRAME_WIDTH = 800;              //  Desired width and height of the frames.
    private int FRAME_HEIGHT = 800;


    public static void main(String[] args){
        Launch launch = new Launch();
    }

    private Launch(){

        //  Set up a GUI Director
        gui = new GUIDirector();
        gui.setFrameSize(FRAME_WIDTH,FRAME_HEIGHT);
        gui.setPaintDelay(PAINT_DELAY);

        //  Create a dummy DrawableObject
        DrawableObject square = new DrawableObject();
        square.setSize(20,20);
        square.setLocation(100,100);

        //  Add dummy to the canvas
        gui.addToDrawables(square);

        //  Brain of the program; surrounded by try-catch because of the 'sleep' method.
        try{
            while(KEEP_GOING) {
                Thread.sleep(LOGIC_DELAY);
                //square.setX(square.getX()+1);       //  location of the dummy is incremented just for show. Add real program logic here.
            }
        } catch(InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + " was interrupted");
        }

    }



}
