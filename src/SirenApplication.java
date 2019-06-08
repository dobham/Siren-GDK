import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import processing.core.PApplet;
import processing.core.PImage;
import processing.event.MouseEvent;

import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;

public class SirenApplication extends PApplet {
    private int y;
    private int x;
    private int pos1, pos2, pos3, pos4;
    private int randSize;
    private int yDist1, xDist1, yDist2, xDist2, yDist3, xDist3, yDist4, xDist4, yDist5, xDist5, yDist6, xDist6, yDist7, xDist7;
    private boolean circleOver1, circleOver2, circleOver3, circleOver4, circleOver5, circleOver6, circleOver7, circleOver8;
    private boolean click1, click2, click3, click4, click5, click6, click7, click8;
    private float smoothScale1, smoothScale2, smoothScale3, smoothScale4, smoothScale5, smoothScale6, smoothScale7, smoothScale8;
    private boolean randomGenerateOver, manualGenerateOver, backOver, textOver, squareCreateOver, freedrawOver, saveOver, launchOver, horizontalOver, verticalOver, diagonalOver1, diagonalOver2, spawnOver, triangleOver;
    private int buttonRandDimX, buttonManDimX, buttonDimY, buttonRandLocX, buttonRandLocY, buttonManLocX, buttonManLocY, shapeButtonWidth, shapeButtonHeight, shapeButtonLocY;
    private int backgroundXLoc, backgroundYLoc, backgroundWidth, backgroundHeight, taskBarXLoc, taskBarYLoc, taskBarHeight, taskBarWidth, page;
    private int a = color(0,0,0,175);
    private int b = color(0,0,0,0);
    private PImage img;
    private int underLineLen = 90;
    private int underLineLenButtonRand;
    private int underLineLenButtonMan;
    public int scale = 50;
    public boolean squareSelected, horizontalSelected, verticalSelected, diagonalSelected1, diagonalSelected2, freedrawSelected, spawnSelected, triangleSelected;
    public ArrayList<squareColliders> squareCollidersFill = new ArrayList<squareColliders>();
    public ArrayList<TriangleColliders> triangleCollidersFill = new ArrayList<TriangleColliders>();
    public ArrayList<lineWallCollider> wallMain = new ArrayList<lineWallCollider>();

    public static void main(String[] args) {
        PApplet.main("SirenApplication", args);
    }

    public void settings() {
        fullScreen();
        img = loadImage("Images and Textures/LogoWithText.png");

    }

    public void setup() {
        PImage icon = loadImage("Images and Textures/LogoWithText.png");
        surface.setIcon(icon);

        shapeButtonWidth = 100;
        shapeButtonHeight = 35;

        shapeButtonLocY = height - 50;

        buttonRandDimX = 385;
        buttonDimY = 50;

        buttonRandLocX = width/3;
        buttonRandLocY = height - 90;

        buttonManDimX = 520;

        buttonManLocX = (width >> 1) + width/5;
        buttonManLocY = height - 90;

        backgroundXLoc = width >> 1;
        backgroundYLoc = height-115;

        backgroundWidth = width;
        backgroundHeight = (int)(height/3.5);

        underLineLenButtonRand = buttonRandLocX - (buttonRandDimX >> 1);
        underLineLenButtonMan = buttonManLocX - (buttonManDimX >> 1);

        taskBarXLoc = width >> 1;
        taskBarYLoc = height-height/20;

        taskBarHeight =(height/10);
        taskBarWidth = width;

        page = 0;
        randSize = width >> 3;
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
            for (int i = 0; i < width >> 3; i += 1000) {
                smoothScale1 -= 8;
                circleCreate(x, y, smoothScale1);
            }
        } else circleCreate(x, y, randSize);
        if (click2) {
            for (int i = 0; i < width >> 3; i += 1000) {
                smoothScale2 -= 8;
                circleCreate(xDist1, y + yDist1, smoothScale2);
            }
        } else circleCreate(xDist1, y + yDist1, randSize);
        if (click3) {
            for (int i = 0; i < width >> 3; i += 1000) {
                smoothScale3 -= 8;
                circleCreate(xDist2, y + yDist2, smoothScale3);
            }
        } else circleCreate(xDist2, y + yDist2, randSize);
        if (click4) {
            for (int i = 0; i < width >> 3; i += 1000) {
                smoothScale4 -= 8;
                circleCreate(xDist3, y + yDist3, smoothScale4);
            }
        } else circleCreate(xDist3, y + yDist3, randSize);
        if (click5) {
            for (int i = 0; i < width >> 3; i += 1000) {
                smoothScale5 -= 8;
                circleCreate(x + xDist4, y + yDist4, smoothScale5);
            }
        } else circleCreate(x + xDist4, y + yDist4, randSize);
        if (click6) {
            for (int i = 0; i < width >> 3; i += 1000) {
                smoothScale6 -= 8;
                circleCreate(x + xDist5, y + yDist5, smoothScale6);
            }
        } else circleCreate(x + xDist5, y + yDist5, randSize);

        if (click7) {
            for (int i = 0; i < width >> 3; i += 1000) {
                smoothScale7 -= 8;
                circleCreate(x + xDist6, y + yDist6, smoothScale7);
            }
        } else circleCreate(x + xDist6, y + yDist6, randSize);
        if (click8) {
            for (int i = 0; i < width >> 3; i += 1000) {
                smoothScale8 -= 8;
                circleCreate(x + xDist7, y + yDist7, smoothScale8);
            }
        } else circleCreate(x + xDist7, y + yDist7, randSize);

        //Possibly add a system where each individual circle that goes above the respawn line is SEPERATLY spawned in
        //Will greatly improve looks
        image(img, 225,50);

        setGradient(0,-(backgroundYLoc-(backgroundHeight/2)),width,45,a,b,ShadowGradient.BUTTON_TO_TOP);

        createBackground(backgroundXLoc, backgroundYLoc, backgroundWidth, backgroundHeight);
        if(randomGenerateOver){
            if(underLineLenButtonRand <= buttonRandLocX + (buttonRandDimX >> 1)){
                for (int i = 0; i < buttonRandLocX + (buttonRandDimX >> 1); i+=50) {
                    underLineLenButtonRand +=2;
                    createButton("Random Generation", buttonRandLocX, buttonRandLocY, buttonRandDimX, buttonDimY, randomGenerateOver, buttonRandLocX - (buttonRandDimX >> 1), underLineLenButtonRand);
                }
            }
            else createButton("Random Generation", buttonRandLocX, buttonRandLocY, buttonRandDimX, buttonDimY, randomGenerateOver, buttonRandLocX - (buttonRandDimX >> 1), underLineLenButtonRand);
        }
        else {
            if (underLineLenButtonRand > buttonRandLocX + (buttonRandDimX >> 1)){
                for (int i = 0; i < buttonRandLocX + (buttonRandDimX >> 1); i+=50) {
                    underLineLenButtonRand-=2;
                    createButton("Random Generation", buttonRandLocX, buttonRandLocY, buttonRandDimX, buttonDimY, randomGenerateOver, buttonRandLocX - (buttonRandDimX >> 1), underLineLenButtonRand);
                }
            }
            else {
                createButton("Random Generation", buttonRandLocX, buttonRandLocY, buttonRandDimX, buttonDimY, randomGenerateOver);
                underLineLenButtonRand = 300;
            }
        }
        if (manualGenerateOver){
            if(underLineLenButtonMan <= buttonManLocX + (buttonManDimX >> 1)){
                for (int i = 0; i < buttonManLocX + buttonManDimX/2; i+=50) {
                    underLineLenButtonMan+=2;
                    createButton("Manual Environment Setup", buttonManLocX, buttonManLocY, buttonManDimX, buttonDimY, manualGenerateOver, buttonManLocX - (buttonManDimX >> 1), underLineLenButtonMan);
                }
            }
            else createButton("Manual Environment Setup", buttonManLocX, buttonManLocY, buttonManDimX, buttonDimY, manualGenerateOver, buttonManLocX - (buttonManDimX >> 1), underLineLenButtonMan);
        }
        else {
            if (underLineLenButtonMan > buttonManLocX + (buttonManDimX >> 1)){
                for (int i = 0; i < buttonManLocX + buttonManDimX/2; i+=50) {
                    underLineLenButtonMan-=2;
                    createButton("Manual Environment Setup", buttonManLocX, buttonManLocY, buttonManDimX, buttonDimY, manualGenerateOver, buttonManLocX - (buttonManDimX >> 1), underLineLenButtonMan);
                }
            }
            else {
                createButton("Manual Environment Setup", buttonManLocX, buttonManLocY, buttonManDimX, buttonDimY, manualGenerateOver);
                underLineLenButtonMan = 600;
            }
        }

        if(textOver){
            if (underLineLen <= 375){
                for (int i = 0; i < 375; i+=50) {
                    underLineLen += 2;
                    createText("Environment Setup",90, height-200, 90, underLineLen);
                }
            }
            else createText("Environment Setup",90, height-200, 90, underLineLen);
        }
        else {
            if (underLineLen > 90){
                for (int i = 0; i < 375; i+=50) {
                    underLineLen -= 3;
                    createText("Environment Setup",90, height-200, 90, underLineLen);
                }
            }
            else createText("Environment Setup",90, height-200);
        }

        if (y < (-yDist7 - 100)) {
            x = (int) random(width);
            y = height;
            yDist1 = xDist1 = (int) (width - random(width));
            yDist2 = xDist2 = (int) (width - random(width));
            yDist3 = xDist3 = (int) (width - random(width));
            yDist4 = xDist4 = (int) (width - random(width));
            yDist5 = xDist5 = (int) (width - random(width));
            yDist6 = xDist6 = (int) (width - random(width));
            yDist7 = xDist7 = (int) (width - random(height))+100;
            click1 = click2 = click3 = click4 = click5 = click6 = click7 = click8 = false;
            smoothScale1 = smoothScale2 = smoothScale3 = smoothScale4 = smoothScale5 = smoothScale6 = smoothScale7 = smoothScale8 = width >> 3;
        }
        y -= 10;
    }
    private void manualGenPage() {
        update();

        background(30);
        createBackground(taskBarXLoc, taskBarYLoc, taskBarWidth, taskBarHeight);
        createShapeButton("Back",200, shapeButtonLocY, shapeButtonWidth, shapeButtonHeight, backOver);
        createShapeButton(510, shapeButtonLocY, shapeButtonWidth, shapeButtonHeight, squareCreateOver, "Square");
        createShapeButton(400, shapeButtonLocY, shapeButtonWidth, shapeButtonHeight, triangleOver, "Triangle");
        createShapeButton(610, shapeButtonLocY, shapeButtonWidth, shapeButtonHeight, horizontalOver, "Horizontal");
        createShapeButton(710, shapeButtonLocY, shapeButtonWidth, shapeButtonHeight, verticalOver, "Vertical");
        createShapeButton(810, shapeButtonLocY, shapeButtonWidth, shapeButtonHeight, diagonalOver1, "Diagonal1");
        createShapeButton(950, shapeButtonLocY, shapeButtonWidth, shapeButtonHeight, diagonalOver2, "Diagonal2");
        createShapeButton("Free Draw" , 1100, shapeButtonLocY, shapeButtonWidth, shapeButtonHeight, freedrawOver, "Curve");
        createShapeButton("Set Spawn" , 1270, shapeButtonLocY, shapeButtonWidth, shapeButtonHeight, spawnOver, "Square");
        createShapeButton("Save",   1450, shapeButtonLocY, shapeButtonWidth, shapeButtonHeight, saveOver);
        createShapeButton("Launch Game",  1600, shapeButtonLocY, shapeButtonWidth, shapeButtonHeight, launchOver);

        if (!(wallMain.isEmpty())){
            for(lineWallCollider lineColliders : wallMain){
                lineColliders.showBoundary();
            }
        }
        if (!(squareCollidersFill.isEmpty())){
            for(squareColliders squareColliders : squareCollidersFill){
                squareColliders.squareFill();
            }
        }
        if(!(triangleCollidersFill.isEmpty())){
            for(TriangleColliders triangleColliders : triangleCollidersFill){
                triangleColliders.triangleFill();
            }
        }

        if(squareSelected){
            stroke(255);
            rect(mouseX, mouseY, scale, scale);
        }
        if(spawnSelected){
            fill(240,230,140);
            rect(mouseX, mouseY, scale, scale);
        }
        if(horizontalSelected){
            stroke(255);
            line(mouseX - (scale >> 1), mouseY, mouseX + (scale >> 1), mouseY);
        }
        if(verticalSelected){
            stroke(255);
            line(mouseX, mouseY + (scale >> 1), mouseX, mouseY - (scale >> 1));
        }
        if(diagonalSelected1){
            stroke(255);
            line(mouseX - (scale >> 1), mouseY - (scale >> 1), mouseX + (scale >> 1), mouseY + (scale >> 1));
        }
        if(diagonalSelected2){
            stroke(255);
            line(mouseX - (scale >> 1), mouseY + (scale >> 1), mouseX + (scale >> 1), mouseY - (scale >> 1));
        }
        if(freedrawSelected){
            cursor(CROSS);
        }
        if(triangleSelected){
            stroke(255);
            fill(255);
            triangle(mouseX - (scale >> 1), mouseY + (scale >> 1), mouseX, mouseY - (scale >> 1), mouseX + (scale >> 1), mouseY + (scale >> 1));
        }
    }

    private void randomGenPage() {
        background(30);
        createBackground(taskBarXLoc, taskBarYLoc, taskBarWidth, taskBarHeight);
    }

    private void createBackground(int xLoc, int yLoc, int width, int height){
//        noStroke();
        fill(202, 0, 5);
        rect(xLoc, yLoc, width, height);
    }

    private void createText(String text, int xLoc, int yLoc,int start, int end){
        fill(255);
        textSize(40);
        text(text, xLoc, yLoc);
        stroke(255);
        line(start, yLoc+10, end, yLoc+10);
        line(start, yLoc+9, end, yLoc+9);
    }

    private void createText(String text, int xLoc, int yLoc){
        fill(255);
        textSize(40);
        text(text, xLoc, yLoc);
    }

    private void circleCreate(float x, float y, float randomSize) {
        ellipse((x), (y), randomSize, randomSize);
    }

    private void createButton(String label, int xLoc, int yLoc, int xDim, int yDim, boolean hover){
        noStroke();
        fill(hover ? color(220,0,5) : color(202,0,5));
        rect(xLoc, yLoc, xDim, yDim);
        fill(200);
        textSize(40);
        text(label, xLoc -(xDim >> 1), yLoc + (yDim >> 2));
    }

    private void createButton(String label, int xLoc, int yLoc, int xDim, int yDim, boolean hover, int start, int end){
        noStroke();
        fill(hover ? color(220,0,5) : color(202,0,5));
        rect(xLoc, yLoc, xDim, yDim);
        fill(200);
        textSize(40);
        text(label, xLoc - (xDim >> 1), yLoc + (yDim >> 2));
        stroke(255);
        line(start, yLoc+15, end, yLoc+15);
        line(start, yLoc+14, end, yLoc+14);
    }

    private void createShapeButton(String label, int xLoc, int yLoc, int xDim, int yDim, boolean hover){
        noStroke();
        fill(hover ? color(220,0,5) : color(202,0,5));
        rect(xLoc, yLoc, xDim, yDim);
        fill(200);
        textSize(40);
        text(label, xLoc-(xDim/2), yLoc + (yDim >> 2));
    }

    private void createShapeButton(String label, int xLoc, int yLoc, int xDim, int yDim, boolean hover, @NotNull String shape){
        noStroke();
        fill(hover ? color(220,0,5) : color(202,0,5));
        rect(xLoc, yLoc, xDim, yDim);
        fill(200);
        textSize(20);
        if(shape.equals("Curve")){
            text(label, xLoc-((int)(xDim * 1.5)) + 100, yLoc + (yDim >> 2));
            noFill();
            stroke(255);
            curve((xLoc << 1) + 100, yLoc-90, xLoc - (xDim >> 1) + 100, yLoc-50, xLoc + 100, yLoc, xLoc + (xDim << 1) + 100, yLoc);
        }
        if(shape.equals("Square")){
            textSize(20);
            text(label, xLoc-(xDim >> 1), yLoc+ (yDim >> 1));
            fill(240,230,140);
            rect(xLoc, yLoc-yDim/2 - 8, 30,30);
        }
    }

    private void createShapeButton(int xLoc, int yLoc, int xDim, int yDim, boolean hover, @NotNull String shape){
        noStroke();
        fill(hover ? color(220,0,5) : color(202,0,5));
        rect(xLoc, yLoc, xDim, yDim);
        if(shape.equals("Square")){
            fill(255);
            stroke(255);
            rect(xLoc, yLoc-5, 50,50);
        }
        if(shape.equals("Triangle")){
            fill(255);
            triangle(xLoc-20, yLoc+15, xLoc+25-20, yLoc-30, xLoc+50-20, yLoc+15);
        }
        if(shape.equals("Horizontal")){
            stroke(255);
            strokeWeight(4);
            line(xLoc - xDim/2, yLoc-5, xLoc + xDim/2, yLoc-5);
        }
        if(shape.equals("Vertical")){
            stroke(255);
            strokeWeight(4);
            line(xLoc, (yLoc-5) - yDim/2, xLoc, (yLoc-5) + yDim/2);
        }
        if(shape.equals("Diagonal1")){
            stroke(255);
            strokeWeight(4);
            line(xLoc - xDim/2, (yLoc-5) - yDim/2, xLoc + xDim/2, (yLoc-5) + yDim/2);
        }
        if(shape.equals("Diagonal2")){
            stroke(255);
            strokeWeight(4);
            line(xLoc - xDim/2, (yLoc-5) + yDim/2, xLoc + xDim/2, (yLoc-5) - yDim/2);
        }
    }

    public enum ShadowGradient {TOP_TO_BOTTOM, LEFT_TO_RIGHT, BUTTON_TO_TOP}

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
        return (mouseX >= x - (randomSize >> 1) && mouseX <= x + (randomSize >> 1)) && (mouseY >= y - (randomSize >> 1) && mouseY <= y + (randomSize >> 1));
    }

    @Contract(pure = true)
    private boolean mouseOverButtonRand(int locX, int locY, int dimX, int dimY) {
        return (mouseX > (locX - (dimX >> 1)) && (mouseX < locX + (dimX >> 1))) && (mouseY > locY - (dimY >> 1)) && (mouseY < locY + (dimY >> 1));
    }

    @Contract(pure = true)
    private boolean mouseOverButtonMan(int locX, int locY, int dimX, int dimY) {
        return (mouseX > (locX - (dimX >> 1)) && (mouseX < locX + (dimX >> 1))) && (mouseY > locY - (dimY >> 1)) && (mouseY < locY + (dimY >> 1));
    }

    @Contract(pure = true)
    private boolean mouseOverText(int locX, int locY, int dimX, int dimY) {
        return (mouseX > (locX - (dimX >> 1)) && (mouseX < locX + (dimX >> 1))) && (mouseY > locY - (dimY >> 1)) && (mouseY < locY + (dimY >> 1));
    }

    @Contract(pure = true)
    private boolean mouseOverBack(int locX, int locY, int dimX, int dimY) {
        return (mouseX > (locX - (dimX >> 1)) && (mouseX < locX + (dimX >> 1)) && (mouseY > locY - (dimY >> 1)) && (mouseY < locY + (dimY >> 1)));
    }

    @Contract(pure = true)
    private boolean mouseOverSquare(int locX, int locY, int dimX, int dimY) {
        return (mouseX > (locX - (dimX >> 1)) && (mouseX < locX + (dimX >> 1)) && (mouseY > locY - (dimY >> 1)) && (mouseY < locY + (dimY >> 1)));
    }

    @Contract(pure = true)
    private boolean mouseOverTriangle(int locX, int locY, int dimX, int dimY) {
        return (mouseX > (locX - (dimX >> 1)) && (mouseX < locX + (dimX >> 1))) && (mouseY > locY - (dimY >> 1)) && (mouseY < locY + (dimY >> 1));
    }

    @Contract(pure = true)
    private boolean mouseOverHorizontal(int locX, int locY, int dimX, int dimY) {
        return (mouseX > (locX - (dimX >> 1)) && (mouseX < locX + (dimX >> 1))) && (mouseY > locY - (dimY >> 1)) && (mouseY < locY + (dimY >> 1));
    }

    @Contract(pure = true)
    private boolean mouseOverVertical(int locX, int locY, int dimX, int dimY) {
        return (mouseX > (locX - (dimX >> 1)) && (mouseX < locX + (dimX >> 1))) && (mouseY > locY - (dimY >> 1)) && (mouseY < locY + (dimY >> 1));
    }

    @Contract(pure = true)
    private boolean mouseOverDiagonal1(int locX, int locY, int dimX, int dimY) {
        return (mouseX > (locX - (dimX >> 1)) && (mouseX < locX + (dimX >> 1))) && (mouseY > locY - (dimY >> 1)) && (mouseY < locY + (dimY >> 1));
    }

    @Contract(pure = true)
    private boolean mouseOverDiagonal2(int locX, int locY, int dimX, int dimY) {
        return (mouseX > (locX - (dimX >> 1)) && (mouseX < locX + (dimX >> 1))) && (mouseY > locY - (dimY >> 1)) && (mouseY < locY + (dimY >> 1));
    }

    @Contract(pure = true)
    private boolean mouseOverFreedraw(int locX, int locY, int dimX, int dimY) {
        return (mouseX > (locX - (dimX >> 1)) && (mouseX < locX + (dimX >> 1))) && (mouseY > locY - (dimY >> 1)) && (mouseY < locY + (dimY >> 1));
    }

    @Contract(pure = true)
    private boolean mouseOverSave(int locX, int locY, int dimX, int dimY) {
        return (mouseX > (locX - (dimX >> 1)) && (mouseX < locX + (dimX >> 1))) && (mouseY > locY - (dimY >> 1)) && (mouseY < locY + (dimY >> 1));
    }

    @Contract(pure = true)
    private boolean mouseOverLaunch(int locX, int locY, int dimX, int dimY) {
        return (mouseX > (locX - (dimX >> 1)) && (mouseX < locX + (dimX >> 1))) && (mouseY > locY - (dimY >> 1)) && (mouseY < locY + (dimY >> 1));
    }

    @Contract(pure = true)
    private boolean mouseOverSpawnSet(int locX, int locY, int dimX, int dimY) {
        return (mouseX > (locX - (dimX >> 1)) && (mouseX < locX + (dimX >> 1))) && (mouseY > locY - (dimY >> 1)) && (mouseY < locY + (dimY >> 1));
    }


    @Contract(pure = true)
    private void update() {
        if(mouseOverSpawnSet(1270, shapeButtonLocY, shapeButtonWidth, shapeButtonHeight)){
            spawnOver = true;
            squareCreateOver = freedrawOver= saveOver= launchOver= horizontalOver= verticalOver= diagonalOver1 = diagonalOver2 = triangleOver = false;
        } else if (mouseOverLaunch(1600, shapeButtonLocY, shapeButtonWidth, shapeButtonHeight)){
            launchOver = true;
            squareCreateOver = freedrawOver= saveOver= spawnOver= horizontalOver= verticalOver= diagonalOver1 = diagonalOver2 = triangleOver = false;
        } else if (mouseOverSave(1400, shapeButtonLocY, shapeButtonWidth, shapeButtonHeight)){
            saveOver = true;
            squareCreateOver = freedrawOver= launchOver= spawnOver= horizontalOver= verticalOver= diagonalOver1 = diagonalOver2 = triangleOver = false;
        } else if (mouseOverFreedraw(1100, shapeButtonLocY, shapeButtonWidth, shapeButtonHeight)){
            freedrawOver = true;
            squareCreateOver = launchOver= saveOver= spawnOver= horizontalOver= verticalOver= diagonalOver1 = diagonalOver2 = triangleOver = false;
        } else if (mouseOverDiagonal1(810, shapeButtonLocY, shapeButtonWidth, shapeButtonHeight)){
             diagonalOver1 = true;
             launchOver = squareCreateOver = freedrawOver= saveOver= spawnOver= horizontalOver= verticalOver= diagonalOver2 = triangleOver = false;
        } else if (mouseOverDiagonal2(950, shapeButtonLocY, shapeButtonWidth, shapeButtonHeight)){
            diagonalOver2 = true;
            squareCreateOver = freedrawOver= saveOver= spawnOver= horizontalOver= verticalOver= launchOver = diagonalOver1 = triangleOver = false;
        } else if (mouseOverVertical(710, shapeButtonLocY, shapeButtonWidth, shapeButtonHeight)){
            verticalOver = true;
            squareCreateOver = freedrawOver= saveOver= spawnOver= horizontalOver= launchOver= diagonalOver1 = diagonalOver2 = triangleOver = false;
        } else if (mouseOverHorizontal(610, shapeButtonLocY, shapeButtonWidth, shapeButtonHeight)){
            horizontalOver = true;
            squareCreateOver = freedrawOver= saveOver= spawnOver= launchOver= verticalOver= diagonalOver1 = diagonalOver2 = triangleOver = false;
        } else if (mouseOverSquare(510, shapeButtonLocY, shapeButtonWidth, shapeButtonHeight)){
            squareCreateOver = true;
            launchOver = freedrawOver= saveOver= spawnOver= horizontalOver= verticalOver= diagonalOver1 = diagonalOver2 = triangleOver = false;
        }else if (mouseOverTriangle(360, shapeButtonLocY,shapeButtonWidth,shapeButtonHeight)){
            triangleOver = true;
            launchOver = freedrawOver= saveOver= spawnOver= horizontalOver= verticalOver= diagonalOver1 = diagonalOver2 = false;
        } else {
            squareCreateOver = launchOver = freedrawOver = saveOver = spawnOver = horizontalOver = verticalOver = diagonalOver1 = diagonalOver2 = triangleOver = false;
        }

        textOver = mouseOverText(90, height - 180, 590, 32);

        if(mouseOverButtonRand(buttonRandLocX,buttonRandLocY, buttonRandDimX, buttonDimY)){
            randomGenerateOver = true;
            backOver = manualGenerateOver = false;
        } else if(mouseOverButtonMan(buttonManLocX,buttonManLocY, buttonManDimX, buttonDimY)) {
            manualGenerateOver = true;
            backOver = randomGenerateOver = false;
        } else if(mouseOverBack(200, shapeButtonLocY, shapeButtonWidth, shapeButtonHeight)){
            backOver = true;
            manualGenerateOver = randomGenerateOver = false;
        } else {
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

            if (squareSelected && (mouseButton == LEFT)) { //FILL
                int xMain = mouseX;
                int yMain = mouseY;
                int x1 = mouseX - (scale >> 1);
                int x2 = mouseX + (scale >> 1);
                int x3 = mouseX - (scale >> 1);
                int x4 = mouseX + (scale >> 1);
                int y1 = mouseY + (scale >> 1);
                int y2 = mouseY + (scale >> 1);
                int y3 = mouseY - (scale >> 1);
                int y4 = mouseY - (scale >> 1);
                if(y > (height-115)){
                    squareSelected = false;
                } else {
                    squareCollidersFill.add(new squareColliders(xMain, yMain, scale, this));
                    wallMain.add(new lineWallCollider(x1, x2, y1, y2, this));
                    wallMain.add(new lineWallCollider(x1, x3, y1, y3, this));
                    wallMain.add(new lineWallCollider(x2, x4, y2, y4, this));
                    wallMain.add(new lineWallCollider(x3, x4, y3, y4, this));
                }
            }
            if (squareSelected && (mouseButton == RIGHT)) {  //NO FILL
                int x1 = mouseX - (scale >> 1);
                int x2 = mouseX + (scale >> 1);
                int x3 = mouseX - (scale >> 1);
                int x4 = mouseX + (scale >> 1);
                int y1 = mouseY + (scale >> 1);
                int y2 = mouseY + (scale >> 1);
                int y3 = mouseY - (scale >> 1);
                int y4 = mouseY - (scale >> 1);
                if(y3 > (height-115)){
                    squareSelected = false;
                } else {
                    wallMain.add(new lineWallCollider(x1, x2, y1, y2, this));
                    wallMain.add(new lineWallCollider(x1, x3, y1, y3, this));
                    wallMain.add(new lineWallCollider(x2, x4, y2, y4, this));
                    wallMain.add(new lineWallCollider(x3, x4, y3, y4, this));
                }
            }
            if (horizontalSelected) {
                int x1 = mouseX - (scale >> 1);
                int x2 = mouseX + (scale >> 1);
                int y1 = mouseY;
                int y2 = mouseY;
                if(y1 > (height-115)){
                    horizontalSelected = false;
                } else wallMain.add(new lineWallCollider(x1, x2, y1, y2, this));
            }
            if (verticalSelected) {
                int x1 = mouseX;
                int x2 = mouseX;
                int y1 = mouseY + (scale >> 1);
                int y2 = mouseY - (scale >> 1);
                if(y1 > (height-115)){
                    verticalSelected = false;
                } else wallMain.add(new lineWallCollider(x1, x2, y1, y2, this));
            }
            if (diagonalSelected1) {
                int x1 = mouseX - (scale >> 1);
                int x2 = mouseX + (scale >> 1);
                int y1 = mouseY - (scale >> 1);
                int y2 = mouseY + (scale >> 1);
                if(y1 > (height-115)){
                    diagonalSelected1 = false;
                } else wallMain.add(new lineWallCollider(x1, x2, y1, y2, this));
            }
            if (diagonalSelected2) {
                int x1 = mouseX - (scale >> 1);
                int x2 = mouseX + (scale >> 1);
                int y1 = mouseY + (scale >> 1);
                int y2 = mouseY - (scale >> 1);
                if(y1 > (height-115)){
                    diagonalSelected2 = false;
                } else wallMain.add(new lineWallCollider(x1, x2, y1, y2, this));
            }
            if (freedrawSelected) {
                pos1 = mouseX;
                pos2 = mouseY;
                pos3 = pmouseX;
                pos4 = pmouseY;
                if(pos2 > (height-115)){
                    freedrawSelected = false;
                } else wallMain.add(new lineWallCollider(pos1, pos3, pos2, pos4, this));
            }
            if(triangleSelected && (mouseButton == LEFT)) {
                int x1 = mouseX - (scale >> 1);
                int x2 = mouseX;
                int x3 = mouseX + (scale >> 1);
                int y1 = mouseY + (scale >> 1);
                int y2 = mouseY - (scale >> 1);
                int y3 = mouseY + (scale >> 1);
                if(y1 > (height-115)){
                    triangleSelected = false;
                } else  {
                    triangleCollidersFill.add(new TriangleColliders(x1, x2, x3, y1, y2,y3,this));
                    wallMain.add(new lineWallCollider(x1, x2, y1, y2, this));
                    wallMain.add(new lineWallCollider(x1, x3, y1, y3, this));
                    wallMain.add(new lineWallCollider(x2, x3, y2, y3, this));
                }
            }

            if(triangleSelected && (mouseButton == RIGHT)) {
                int x1 = mouseX - (scale >> 1);
                int x2 = mouseX;
                int x3 = mouseX + (scale >> 1);
                int y1 = mouseY + (scale >> 1);
                int y2 = mouseY - (scale >> 1);
                int y3 = mouseY + (scale >> 1);
                if(y1 > (height-115)){
                    triangleSelected = false;
                } else {
                    wallMain.add(new lineWallCollider(x1, x2, y1, y2, this));
                    wallMain.add(new lineWallCollider(x1, x3, y1, y3, this));
                    wallMain.add(new lineWallCollider(x2, x3, y2, y3, this));
                }
            }

        if (squareCreateOver) {
            squareSelected = !squareSelected;
            scale = 50;
        } else if (horizontalOver) {
            horizontalSelected = !horizontalSelected;
            scale = 50;
        } else if (verticalOver) {
            verticalSelected = !verticalSelected;
            scale = 50;
        } else if (diagonalOver1) {
            diagonalSelected1 = !diagonalSelected1;
            scale = 50;
        } else if (diagonalOver2) {
            diagonalSelected2 = !diagonalSelected2;
            scale = 50;
        } else if (freedrawOver) {
            freedrawSelected = !freedrawSelected;
            scale = 50;
        } else if (spawnOver) {
            spawnSelected = !spawnSelected;
            scale = 50;
        } else if (triangleOver){
            triangleSelected = !triangleSelected;
            scale = 50;
        }

        /*else spawnSelected = freedrawSelected = diagonalSelected2 = diagonalSelected1 = verticalSelected = horizontalSelected = squareSelected = false;*/
    }

    public void mouseWheel(@NotNull MouseEvent event){
        if(event.getCount() == -1){
            scale += 5;
        } else scale -= 5;
    }
}