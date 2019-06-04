import org.jetbrains.annotations.Contract;
import processing.core.PApplet;
import processing.core.PVector;

public class TriangleColliders {
    private PApplet parent;
    private PVector a,b,c;
    public TriangleColliders(int x1, int x2, int x3, int y1, int y2, int y3, PApplet applet){
        parent = applet;
        a = new PVector(x1,y1);
        b = new PVector(x2,y2);
        c = new PVector(x3,y3);
    }
    public void triangleNoFill(){
        parent.fill(255);
        parent.triangle(a.x, a.y, b.x, b.y, c.x, c.y);
    }
}
