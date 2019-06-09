import processing.core.PApplet;
import processing.core.PVector;

import java.util.ArrayList;

public class PlayerParticle {
    private final int FOV = 45;
    private PVector pos;
    private PApplet parent;
    private int heading;
    public ArrayList<Raycaster> rays = new ArrayList<>();
    public ArrayList<Double> programScene;

    public PlayerParticle(PApplet applet){
        parent = applet;
        heading = 0;
        pos = new PVector(parent.width >> 1, (parent.height - 115) >> 1);
        for(int i = -FOV  >> 1; i < FOV >> 1; i++){
           rays.add(new Raycaster(pos, PApplet.radians(i), applet));
        }
    }
    public PlayerParticle(int x, int y,PApplet applet){
        parent = applet;
        heading = 0;
        pos = new PVector(x,y);
        for(int i = -FOV  >> 1; i < FOV >> 1; i++){
            rays.add(new Raycaster(pos, PApplet.radians(i), applet));
        }
    }

    public ArrayList view(ArrayList<lineWallCollider> walls){
        programScene = new ArrayList<>();
        for (int i = 0; i < rays.size(); i++) {
            Raycaster ray = rays.get(i);
            PVector closest = null;
            double record = Double.POSITIVE_INFINITY;
            for (lineWallCollider wall : walls) {
                PVector pt = ray.castRay(wall);
                if (pt != null) {
                    float d = PVector.dist(pos, pt);
                    float a = ray.dir.heading() - heading;
                    float z = d * PApplet.cos(a);
                    if (d < record) {
                        record = z;
                        closest = pt;
                    }
                }
            }
            if (closest != null) {
                parent.stroke(255);
                parent.line(this.pos.x, this.pos.y, closest.x, closest.y);
            }
//            programScene.get(i) = record;
        }
        return programScene;
    }
    public void show(){
        parent.fill(240,230,140);
        int SIZE = 30;
        parent.rect(pos.x, pos.y, SIZE, SIZE);
    }
}
