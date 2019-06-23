import processing.core.PApplet;
import processing.core.PVector;

public class Raycaster {
    private final PApplet parent;
    private final PVector pos;
            public PVector dir;
            public PVector pt;

    public Raycaster(PVector position, float angle, PApplet applet){
                pos = position;
                dir = PVector.fromAngle(angle);
                parent = applet;
            }

            public void setAngle(float angle){
                dir = PVector.fromAngle(angle);
            }

            public PVector castRay(lineWallCollider wall){
                float x1 = wall.a.x;
                float x2 = wall.b.x;
                float x3 = pos.x;
                float x4 = pos.x + dir.x;
                float y1 = wall.a.y;
                float y2 = wall.b.y;
                float y3 = pos.y;
                float y4 = pos.y + dir.y;

                float den = (x1 - x2) * (y3 - y4) - (y1 - y2) * (x3 - x4);
                if (den == 0) {
            return null;
        }

        float t = ((x1 - x3) * (y3 - y4) - (y1 - y3) * (x3 - x4)) / den;
        float u = -((x1 - x2) * (y1 - y3) - (y1 - y2) * (x1 - x3)) / den;
        if (t > 0 && t < 1 && u > 0) {
        PVector pt = new PVector();
            pt.x = x1 + t * (x2 - x1);
            pt.y = y1 + t * (y2 - y1);
            return pt;
        } else {
            return null;
        }
    }
}
