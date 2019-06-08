import processing.core.PApplet;
import processing.core.PVector;

import java.util.ArrayList;

public class PlayerParticle {
    public final int FOV = 45;
    public final int SIZE = 30;
    public int posX;
    public int posY;
    public ArrayList<Raycaster> rays = new ArrayList<Raycaster>();
    private PVector pos;
    private PApplet parent;

    public PlayerParticle(PApplet applet){
        parent = applet;
        pos = new PVector(parent.width >> 1, (parent.height - 115) >> 1);
    }
    public PlayerParticle(int x, int y,PApplet applet){
        parent = applet;
        pos = new PVector(x,y);
    }

}
