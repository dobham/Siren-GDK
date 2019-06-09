import processing.core.PApplet;
import processing.core.PVector;

public class lineWallCollider {
    public PVector a, b;
    private PApplet parent;
    public lineWallCollider(int x1, int x2, int y1, int y2, PApplet applet){
        parent = applet;
        a = new PVector(x1,y1);
        b = new PVector(x2,y2);
    }
    public void showBoundary(){
        parent.stroke(255);
        parent.line(a.x, a.y, b.x, b.y);
    }
}
