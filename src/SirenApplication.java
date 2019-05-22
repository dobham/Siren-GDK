import org.jetbrains.annotations.Contract;
import processing.core.PApplet;
import processing.core.PImage;

public class SirenApplication extends PApplet {
    private int y;
    private int x;
    private int randSize;
    private int yDist1, xDist1, yDist2, xDist2, yDist3, xDist3, yDist4, xDist4, yDist5, xDist5, yDist6, xDist6, yDist7, xDist7;
    private boolean isOver;
    private boolean circleOver1, circleOver2, circleOver3, circleOver4, circleOver5, circleOver6, circleOver7, circleOver8;
    private boolean click1, click2, click3, click4, click5, click6, click7, click8;
    private float smoothScale1, smoothScale2, smoothScale3, smoothScale4, smoothScale5, smoothScale6, smoothScale7, smoothScale8;
    private boolean randomGenerateOver, manualGenerateOver, backOver;
    private int buttonDimX, buttonDimY, buttonRandLocX, buttonRandLocY, buttonManLocX, buttonManLocY;
    private int backgroundXLoc, backgroundYLoc, backgroundWidth, backgroundHeight, page;
    private int a = color(0,0,0,175);
    private int b = color(0,0,0,0);
    private PImage img;

    public static void main(String[] args) {
        PApplet.main("SirenApplication", args);
    }

    public void settings() {
        size(1000, 800);
        img = loadImage("Images and Textures/LogoWithText.png");
    }

    public void setup() {

        buttonDimX = 300;
        buttonDimY = 65;

        buttonRandLocX = width/2 - 200;
        buttonRandLocY = height - 75;

        buttonManLocX = width/2 + 200;
        buttonManLocY = height - 75;

        backgroundXLoc = width/2;
        backgroundYLoc = height-115;

        backgroundWidth = width;
        backgroundHeight = (int)(height/3.5);

        page = 0;
        randSize = width / 8;
        x = (int) random(width);
        y = 25;
        smoothScale1 = smoothScale2 = smoothScale3 = smoothScale4 = smoothScale5 = smoothScale6 = smoothScale7 = smoothScale8 = width / 8;
        ellipseMode(CENTER);
        rectMode(CENTER);
        noStroke();
    }

    public void draw() {
        pageSelector();
    }

    private void pageSelector() {
        switch (page) {
            case 0:
                MainPage();
                break;
            case 1:
                randomGenPage();
                break;
            case 2:
                manualGenPage();
        }
    }

    private void MainPage() {
        update();
        background(30);
        noStroke();
//        fill(202, 0, 5);

        fill(255);
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
        image(img, 0,0);

        setGradient(0,-(backgroundYLoc-(backgroundHeight/2)),width,45,a,b,ShadowGradient.BUTTON_TO_TOP);

        createBackground(backgroundXLoc, backgroundYLoc, backgroundWidth, backgroundHeight);

        createButton("Random Map Generation", buttonRandLocX, buttonRandLocY, buttonDimX, buttonDimY, randomGenerateOver);
        createText("Environment Setup",width/2, height/2);

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

    private void randomGenPage() {
        background(220);

    }

    private void manualGenPage() {
        background(303);
    }

    private void createBackground(int xLoc, int yLoc, int width, int height){
//        noStroke();
        fill(202, 0, 5);
        rect(xLoc, yLoc, width, height);
    }

    private void createText(String text, int xLoc, int yLoc){
        textSize(32);
        text(text, xLoc, yLoc);
        stroke(255);
        line(xLoc, yLoc+10, (int)(xLoc+xLoc/1.75), yLoc+10);
    }

    private void circleCreate(float x, float y, float randomSize) {
        ellipse((x), (y), randomSize, randomSize);
    }

    private void createButton(String label, int xLoc, int yLoc, int xDim, int yDim, boolean hover){
        fill(hover ? 100 : 150);
        rect(xLoc, yLoc, xDim, yDim);
        fill(200);
        text(label, xLoc-(xDim/2), yLoc);
    }

    public enum ShadowGradient {TOP_TO_BOTTOM, LEFT_TO_RIGHT, BUTTON_TO_TOP};

    private void setGradient(int x, int y, float w, float h, int c1, int c2, ShadowGradient axis ) {
        noFill();
        if (axis == ShadowGradient.BUTTON_TO_TOP) {  // BOTTOM TO TOP GRADIENT FOR BOX SHADOWS
            for (float i = 0, j = y; j <= y+h-1 && i <= 0.8; j++, i+=0.1) {
                int c = lerpColor(c1,c2, i);
                stroke(c);
                line(x, -j, x+w, -j);
            }
        } if (axis == ShadowGradient.TOP_TO_BOTTOM) {  // TOP TO BOTTOM GRADIENT FOR BOX SHADOWS
            for (int i = y; i <= y+h-1; i++) {
                float inter = map(i, y, y+h, 0, 1);
                int c = lerpColor(c1, c2, inter);
                stroke(c);
                line(x, i, x+w, i);
            }
        } else if (axis == ShadowGradient.LEFT_TO_RIGHT) {  // LEFT TO RIGHT GRADIENT FOR BOX SHADOWS
            for (int i = (int) (x+w); i > x +1; i--) {
                float inter = map(i, x, x+w, 0, 1);
                int c = lerpColor(c1, c2, inter);
                stroke(c);
                line(i, y, i, y+h);
            }
        }
        noStroke();
    }

    @Contract(pure = true)
    private boolean mouseOverCircle(int randomSize, int x, int y) {
        if ((mouseX >= x - randomSize / 2 && mouseX <= x + randomSize / 2) && (mouseY >= y - randomSize / 2 && mouseY <= y + randomSize / 2))
            return true;
        else return false;
    }

    @Contract(pure = true)
    private boolean mouseOverButton(int locX, int locY, int dimX, int dimY) {
        if ((mouseX > (locX - dimX/2) && (mouseX < locX + dimX/2)) && (mouseY > locY - dimY/2) && (mouseY < locY + dimY/2) ){
            return true;
        }
        else return false;
    }

    @Contract(pure = true)
    private void update() {

        if(mouseOverButton(buttonRandLocX,buttonRandLocY, buttonDimX, buttonDimY)){
            randomGenerateOver = true;
            backOver = manualGenerateOver = false;
        }
        else {
            backOver = manualGenerateOver = randomGenerateOver = false;
        }

        if (mouseOverCircle(randSize, x, y)) {
            circleOver2 = circleOver3 = circleOver4 = circleOver5 = circleOver6 = circleOver7 = circleOver8 = false;
            circleOver1 = true;
        } else if (mouseOverCircle(randSize, xDist1, y + yDist1)) {
            circleOver1 = circleOver3 = circleOver4 = circleOver5 = circleOver6 = circleOver7 = circleOver8 = false;
            circleOver2 = true;
        } else if (mouseOverCircle(randSize, xDist2, y + yDist2)) {
            circleOver1 = circleOver2 = circleOver4 = circleOver5 = circleOver6 = circleOver7 = circleOver8 = false;
            circleOver3 = true;
        } else if (mouseOverCircle(randSize, xDist3, y + yDist3)) {
            circleOver1 = circleOver2 = circleOver3 = circleOver5 = circleOver6 = circleOver7 = circleOver8 = false;
            circleOver4 = true;
        } else if (mouseOverCircle(randSize, x + xDist4, y + yDist4)) {
            circleOver1 = circleOver2 = circleOver3 = circleOver4 = circleOver6 = circleOver7 = circleOver8 = false;
            circleOver5 = true;
        } else if (mouseOverCircle(randSize, x + xDist5, y + yDist5)) {
            circleOver1 = circleOver2 = circleOver3 = circleOver4 = circleOver5 = circleOver7 = circleOver8 = false;
            circleOver6 = true;
        } else if (mouseOverCircle(randSize, x + xDist6, y + yDist6)) {
            circleOver1 = circleOver2 = circleOver3 = circleOver4 = circleOver5 = circleOver6 = circleOver8 = false;
            circleOver7 = true;
        } else if (mouseOverCircle(randSize, x + xDist7, y + yDist7)) {
            circleOver1 = circleOver2 = circleOver3 = circleOver4 = circleOver5 = circleOver6 = circleOver7 = false;
            circleOver8 = true;
        } else
            circleOver1 = circleOver2 = circleOver3 = circleOver4 = circleOver5 = circleOver6 = circleOver7 = circleOver8 = false;
    }

    public void mousePressed() {

        if (page == 1 && backOver) page = 0;
        if (page == 2 && backOver) page = 0;

        if (page == 0 && randomGenerateOver) page = 1;
        else if (page == 0 && manualGenerateOver) page = 2;

        if (circleOver1) click1 = true;
        else if (circleOver2) click2 = true;
        else if (circleOver3) click3 = true;
        else if (circleOver4) click4 = true;
        else if (circleOver5) click5 = true;
        else if (circleOver6) click6 = true;
        else if (circleOver7) click7 = true;
        else if (circleOver8) click8 = true;
    }


    //    public void mouseMoved() {
//        isInside();
//    }
}