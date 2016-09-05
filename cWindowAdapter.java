/**
 * Created by Swayze on 9/4/2016.
 */
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


//	A window adapter is an object that is attached to a Window class (and its subclasses)
//	It listens for prompts from the system and calls the appropriate functions, which can be overridden
//	like a window beings asked to close. It needs to be created and added to a Frame for this to work.

public class cWindowAdapter extends WindowAdapter{

    public void windowClosing(WindowEvent e){
        //System.out.println("window closing");
        System.exit(0);
    }

    public void windowActivated(WindowEvent e){
        //System.out.println("window activated");
        //System.exit(0);
    }

    public void windowDeactivated(WindowEvent e){
       // System.out.println("window deactivated");
        //System.exit(0);
    }

    public void windowIconified(WindowEvent e){
        //System.out.println("window iconified");
        //System.exit(0);
    }

    public void windowDeiconified(WindowEvent e){
        //System.out.println("window deiconified");
        //System.exit(0);
    }

    public void windowOpened(WindowEvent e){
        //System.out.println("window deiconified");
        //System.exit(0);
    }

}
