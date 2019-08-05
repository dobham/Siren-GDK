import processing.core.PApplet;
import processing.core.PVector;

import java.util.ArrayList;

public class PlayerParticle {
    private final int FOV = 45;
    private PVector pos;
    private PApplet parent;
    private float heading;
    public ArrayList<Raycaster> rays = new ArrayList<>();
    public ArrayList<Float> programScene;

    public PlayerParticle(PApplet applet){
        heading = 0;
        parent = applet;
        pos = new PVector(parent.width /2, (parent.height - 115)/2);
        for(int i = -FOV  /2; i < FOV /2; i++){
           rays.add(new Raycaster(pos, PApplet.radians(i), applet));
           System.out.println(PApplet.radians(i));
        }
    }

    public PlayerParticle(int x, int y,PApplet applet){
        parent = applet;
        pos = new PVector(x,y);
        for(int i = (-FOV  >> 1); i < (FOV >> 1); i++){
            rays.add(new Raycaster(pos, PApplet.radians(i), applet));
            System.out.println(PApplet.radians(i));
        }
    }

    public void playerRotate(float angle){
        heading += angle;
        int index = 0;
        for (int a = -FOV /2; a < FOV/2; a++){
            rays.get(index).setAngle(PApplet.radians(a) + heading);
            index++;
        }
    }

    public void playerMove(int magnitude){
        PVector velocity = PVector.fromAngle(heading);
        velocity.setMag(magnitude);
        pos.add(velocity);
    }

    public ArrayList<Float> view(ArrayList<lineWallCollider> walls){
        programScene = new ArrayList<>();
        for (int i = 0; i < rays.size(); i++) {
            final Raycaster ray = rays.get(i);
            float record = Float.POSITIVE_INFINITY;
            for (lineWallCollider wall : walls) {
                PVector pt = ray.castRay(wall);
                    if (pt != null) {
                        float d = PVector.dist(pos, pt);
                        float a = ray.dir.heading() - heading;
                        d *= parent.cos(a);
                        if (d < record) {
                            record = d;
                        }
                    }
                }
            programScene.add(i, record);
        }
        System.out.println(programScene);
        return programScene;
    }
}
