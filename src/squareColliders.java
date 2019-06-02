import processing.core.PApplet;
import processing.core.PVector;

public class squareColliders {
    private PVector a, b, c, d;
    PApplet parent;
    public squareColliders(int x1, int x2, int x3, int x4, int y1, int y2, int y3, int y4, PApplet applet){
        parent = applet;
        a = new PVector(x1, y1);
        b = new PVector(x2, y2);
        c = new PVector(x3, y3);
        d = new PVector(x4, y4);
    }
    public void squareNoFill(){
        parent.stroke(255);
        parent.line(a.x, a.y, b.x, b.y);
        parent.line(a.x, a.y, c.x, c.y);
        parent.line(b.x, b.y, d.x, d.y);
        parent.line(c.x, c.y, d.x, d.y);
    }
//    public void squareFill(){
//        parent.line(a.x, a.y, b.x, b.y);
//        parent.line(a.x, a.y, c.x, c.y);
//        parent.line(b.x, b.y, d.x, d.y);
//        parent.line(c.x, c.y, d.x, d.y);
//        parent.fill(255);
//        parent.rect(a.x + b.x/2, a.y - c.y, b.x - a.x, b.x - a.x);
//    }
}