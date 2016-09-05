/**
 * Created by Swayze on 9/4/2016.
 */
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;

//	The frame houses everything.
public class cFrame extends JFrame {

    private Toolkit tk;
    private Image titleIcon;

    public cFrame(){
        super();
    }

    public cFrame(String s){
        super(s);
    }

    //	Sets the frame's titleIcon to the passed filename located under 'images' directory.
    public void setTitleIcon(String filename){
        tk = Toolkit.getDefaultToolkit();
        System.out.println(System.getProperty("user.dir") + "\\images\\" + filename);
        titleIcon = tk.getImage(System.getProperty("user.dir") + "\\images\\" + filename);
        setIconImage(titleIcon);
    }

}

