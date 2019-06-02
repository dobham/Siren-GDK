import processing.core.PApplet;
import processing.core.PVector;

public class squareColliders extends PApplet {
    private PVector a, b, c, d;
    public squareColliders(int x1, int x2, int x3, int x4, int y1, int y2, int y3, int y4){
        a = new PVector(x1, y1);
        b = new PVector(x2, y2);
        c = new PVector(x3, y3);
        d = new PVector(x4, y4);
    }
    public void squareNoFill(){
        stroke(255);
        line(a.x, a.y, b.x, b.y);
        line(a.x, a.y, c.x, c.y);
        line(b.x, b.y, d.x, d.y);
        line(c.x, c.y, d.x, d.y);
    }
    public void squareFill(){
        stroke(255);
        line(a.x, a.y, b.x, b.y);
        line(a.x, a.y, c.x, c.y);
        line(b.x, b.y, d.x, d.y);
        line(c.x, c.y, d.x, d.y);
        fill(255);
        rect(a.x + b.x/2, a.y - c.y, b.x - a.x, b.x - a.x);
    }
}