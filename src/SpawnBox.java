import processing.core.PApplet;

public class SpawnBox {
    private PApplet parent;
    private int x, y, s;
    public SpawnBox(int xVal, int yVal, int scale, PApplet applet){
        parent = applet;
        x =xVal;
        y = yVal;
        s = scale;
    }
    public void squareFill(){
        parent.fill(240, 230, 140);
        parent.rect(x, y, s, s);
    }
}