import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by Swayze on 9/4/2016.

    This is intended to be a base class for a Drawable Object, containing only basic size and location methods.

 */
public class DrawableObject {

    private BufferedImage defaultIcon;
    private Graphics2D graphics;

    private int width;
    private int height;

    private int x;
    private int y;

    DrawableObject(){
        setSize(50,50);
        setLocation(0,0);
        generateIcon();
    }

    private void generateIcon(){
        defaultIcon = new BufferedImage(getWidth(),getHeight(),defaultIcon.TYPE_INT_ARGB);
        graphics = (Graphics2D)defaultIcon.getGraphics();
        graphics.setColor(Color.GRAY);
        graphics.fillRect(0, 0, getWidth(), getHeight());
    }

    public void setIcon(BufferedImage image){
        defaultIcon = image;
    }

    public BufferedImage getCurrentIcon(){
        return defaultIcon;
    }

    //  Standard setters and getters for the width and height of the object;
    public void setSize(int W, int H){
        setWidth(W);
        setHeight(H);
    }

    public void setWidth(int w){
        width = w;
    }

    public void setHeight(int h){
        height = h;
    }

    public int getWidth(){
        return width;
    }

    public int getHeight(){
        return height;
    }

    //  Standard setters and getters for the x and y coordinates of the object;
    public void setLocation(int X, int Y){
        setX(X);
        setY(Y);
    }

    public void setX(int X){
        x = X;
    }

    public void setY(int Y){
        y = Y;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

}
