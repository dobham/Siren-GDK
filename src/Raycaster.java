import processing.core.PApplet;
import processing.core.PVector;

public class Raycaster {
    PApplet parent;
    public PVector pos, dir;
    public Raycaster(PVector position, float angle, PApplet applet){
        pos = position;
        dir = PVector.fromAngle(angle);
        parent = applet;
    }

    public void setAngle(float angle){
        dir = PVector.fromAngle(angle);
    }

    public void castRay(lineWallCollider wall){
        float x1 = wall.a.x;
        float x2 = wall.b.x;
        float x3 = pos.x;
        float x4 = pos.x + dir.x;
        float y1 = wall.a.y;
        float y2 = wall.b.y;
        float y3 = pos.y;
        float y4 = pos.y + dir.y;

        float den = (x1 - x2) * (y3 - y4) - (y1 - y2) * (x3 - x4);
    }
}
