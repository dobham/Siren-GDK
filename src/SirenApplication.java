import org.jetbrains.annotations.Contract;
import processing.core.PApplet;

import java.awt.*;

public class SirenApplication extends PApplet {
    private int y;
    private int x;
    private int randSize;
    private int yDist1, xDist1, yDist2, xDist2, yDist3, xDist3, yDist4, xDist4, yDist5, xDist5, yDist6, xDist6, yDist7, xDist7;
    private boolean isOver;
    private boolean circleOver1, circleOver2, circleOver3, circleOver4, circleOver5, circleOver6, circleOver7, circleOver8;
    private boolean click1, click2, click3, click4, click5, click6, click7, click8;
    private float smoothScale1, smoothScale2, smoothScale3, smoothScale4, smoothScale5, smoothScale6, smoothScale7, smoothScale8;
    static int MAX;
    static int GAP;
    static int DIM;
    static int RAD;
    static  int W, H,TXTSZ;
    static  int BTNC, HOVC;
    private int TXTC;
    String label;
    short xx, yy, xW, yH;
    boolean isHovering;
    int page, cx,cy;

    public static void main(String[] args) {
        PApplet.main("SirenApplication", args);
    }

    public void settings() {
        size(1000, 800);
    }

    public void setup() {
         final int MAX = 2, GAP = 50, DIM = 120, RAD = DIM >> 1;
         page = 0;
         final int W = 60, H = 40, TXTSZ = 20;
         final int BTNC = 120, HOVC = 220;
         final int TXTC = 0;
        randSize = width / 8;
        x = (int) random(width);
        y = 25;
        smoothScale1 = smoothScale2 = smoothScale3 = smoothScale4 = smoothScale5 = smoothScale6 = smoothScale7 = smoothScale8 = width / 8;
        ellipseMode(CENTER);
        cx = width >> 1;
        cy = height >> 1;
//        Button("BACK", GAP, height - H - GAP);
    }

    public void draw() {
        pageSelector();
    }

    private void page0() {
        update();
        background(0);
        fill(127, 0, 0);
        if (click1) {
            for (int i = 0; i < width / 8; i += 1000) {
                smoothScale1 -= 8;
                circleCreate(x, y, smoothScale1);
            }
        } else circleCreate(x, y, randSize);
        if (click2) {
            for (int i = 0; i < width / 8; i += 1000) {
                smoothScale2 -= 8;
                circleCreate(xDist1, y + yDist1, smoothScale2);
            }
        } else circleCreate(xDist1, y + yDist1, randSize);
        if (click3) {
            for (int i = 0; i < width / 8; i += 1000) {
                smoothScale3 -= 8;
                circleCreate(xDist2, y + yDist2, smoothScale3);
            }
        } else circleCreate(xDist2, y + yDist2, randSize);
        if (click4) {
            for (int i = 0; i < width / 8; i += 1000) {
                smoothScale4 -= 8;
                circleCreate(xDist3, y + yDist3, smoothScale4);
            }
        } else circleCreate(xDist3, y + yDist3, randSize);
        if (click5) {
            for (int i = 0; i < width / 8; i += 1000) {
                smoothScale5 -= 8;
                circleCreate(x + xDist4, y + yDist4, smoothScale5);
            }
        } else circleCreate(x + xDist4, y + yDist4, randSize);
        if (click6) {
            for (int i = 0; i < width / 8; i += 1000) {
                smoothScale6 -= 8;
                circleCreate(x + xDist5, y + yDist5, smoothScale6);
            }
        } else circleCreate(x + xDist5, y + yDist5, randSize);

        if (click7) {
            for (int i = 0; i < width / 8; i += 1000) {
                smoothScale7 -= 8;
                circleCreate(x + xDist6, y + yDist6, smoothScale7);
            }
        } else circleCreate(x + xDist6, y + yDist6, randSize);
        if (click8) {
            for (int i = 0; i < width / 8; i += 1000) {
                smoothScale8 -= 8;
                circleCreate(x + xDist7, y + yDist7, smoothScale8);
            }
        } else circleCreate(x + xDist7, y + yDist7, randSize);

        //Possibly add a system where each individual circle that goes above the respawn line is SEPERATLY spawned in
        //Will greatly improve looks
        Button("NEXT", 100, 100, 100,40, 90, isHovering);
        if (y < (-yDist6 - 100)) {
            x = (int) random(width);
            y = height;
            yDist1 = xDist1 = (int) (50 + random(100));
            yDist2 = xDist2 = (int) (150 + random(200));
            yDist3 = xDist3 = (int) (250 + random(300));
            yDist4 = xDist4 = (int) (350 + random(400));
            yDist5 = xDist5 = (int) (450 + random(300));
            yDist6 = xDist6 = (int) (550 + random(200));
            yDist7 = xDist7 = (int) (650 + random(100));
            click1 = click2 = click3 = click4 = click5 = click6 = click7 = click8 = false;
            smoothScale1 = smoothScale2 = smoothScale3 = smoothScale4 = smoothScale5 = smoothScale6 = smoothScale7 = smoothScale8 = width / 8;
        }
        y -= 10;
    }

    public void page1() {
        fill(120);
        rect(cx - RAD, GAP * 2 - RAD, DIM, DIM);
    }

    private void circleCreate(float x, float y, float randomSize) {
        ellipse((x), (y), randomSize, randomSize);
    }

    public void pageSelector() {
        switch (page) {
            case 0:
                page0();
                break;
            case 1:
                page1();
        }
    }

    public void mouseMoved() {
        isInside();
    }

    public void mousePressed() {
        if (page > 0 && isHovering) --page;
        else if (page < MAX && isHovering) ++page;
        if (circleOver1) click1 = true;
        else if (circleOver2) click2 = true;
        else if (circleOver3) click3 = true;
        else if (circleOver4) click4 = true;
        else if (circleOver5) click5 = true;
        else if (circleOver6) click6 = true;
        else if (circleOver7) click7 = true;
        else if (circleOver8) click8 = true;
        //else click1 = click2 = click3 = click4 = click5 = click6 = click7 = click8 = false;
    }

    //Annotations Lib
    @Contract(pure = true)
    //Annotations Lib
    private boolean mouseOver(int randomSize, int x, int y) {
        if ((mouseX >= x - randomSize / 2 && mouseX <= x + randomSize / 2) && (mouseY >= y - randomSize / 2 && mouseY <= y + randomSize / 2))
            return true;
        else return false;
    }

    private void update() {
        if (mouseOver(randSize, x, y)) {
            circleOver2 = circleOver3 = circleOver4 = circleOver5 = circleOver6 = circleOver7 = circleOver8 = false;
            circleOver1 = true;
        } else if (mouseOver(randSize, xDist1, y + yDist1)) {
            circleOver1 = circleOver3 = circleOver4 = circleOver5 = circleOver6 = circleOver7 = circleOver8 = false;
            circleOver2 = true;
        } else if (mouseOver(randSize, xDist2, y + yDist2)) {
            circleOver1 = circleOver2 = circleOver4 = circleOver5 = circleOver6 = circleOver7 = circleOver8 = false;
            circleOver3 = true;
        } else if (mouseOver(randSize, xDist3, y + yDist3)) {
            circleOver1 = circleOver2 = circleOver3 = circleOver5 = circleOver6 = circleOver7 = circleOver8 = false;
            circleOver4 = true;
        } else if (mouseOver(randSize, x + xDist4, y + yDist4)) {
            circleOver1 = circleOver2 = circleOver3 = circleOver4 = circleOver6 = circleOver7 = circleOver8 = false;
            circleOver5 = true;
        } else if (mouseOver(randSize, x + xDist5, y + yDist5)) {
            circleOver1 = circleOver2 = circleOver3 = circleOver4 = circleOver5 = circleOver7 = circleOver8 = false;
            circleOver6 = true;
        } else if (mouseOver(randSize, x + xDist6, y + yDist6)) {
            circleOver1 = circleOver2 = circleOver3 = circleOver4 = circleOver5 = circleOver6 = circleOver8 = false;
            circleOver7 = true;
        } else if (mouseOver(randSize, x + xDist7, y + yDist7)) {
            circleOver1 = circleOver2 = circleOver3 = circleOver4 = circleOver5 = circleOver6 = circleOver7 = false;
            circleOver8 = true;
        } else
            circleOver1 = circleOver2 = circleOver3 = circleOver4 = circleOver5 = circleOver6 = circleOver7 = circleOver8 = false;
    }
    void Button(String txt, int xLoc, int yLoc, int width, int height, int color, boolean hover){
        label = txt;
        fill(hover ? 120 : 220);
        rect(xLoc, yLoc, width, height);
        fill(color);
        text(label, xLoc + width / 2, yLoc + height / 2);
    }
    boolean isInside() {
        return isHovering = mouseX > xx && mouseX < xW && mouseY > yy && mouseY < yH;
    }
}
//class Button extends PApplet {
//    static final int W = 60, H = 40, TXTSZ = 020;
//    static final int BTNC = 120, HOVC = 220;
//    private final int TXTC = 0;
//
//    final String label;
//    final short x, y, xW, yH;
//
//    boolean isHovering;
//
//    Button(String txt, int xx, int yy) {
//        label = txt;
//        x = (short) xx;
//        y = (short) yy;
//        xW = (short) (xx + W);
//        yH = (short) (yy + H);
//    }
//
//    void display() {
//        fill(isHovering ? 120 : 220);
//        rect(xx, yy, W, H);
//
//        fill(TXTC);
//        text(label, xx + W / 2, yy + H / 2);
//    }
//
//    boolean isInside() {
//        return isHovering = mouseX > x && mouseX < xW && mouseY > y && mouseY < yH;
//    }
//}