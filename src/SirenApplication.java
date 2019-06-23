import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import processing.core.PApplet;
import processing.core.PImage;
import processing.event.MouseEvent;

import java.util.ArrayList;

@SuppressWarnings({"Duplicates", "SpellCheckingInspection"})
public class SirenApplication extends PApplet {
    private int y, x, randSize, yDist1, xDist1, yDist2, xDist2, yDist3, xDist3, yDist4, xDist4, yDist5, xDist5, yDist6, xDist6, yDist7, xDist7;
    private boolean circleOver1, circleOver2, circleOver3, circleOver4, circleOver5, circleOver6, circleOver7, circleOver8;
    private boolean click1, click2, click3, click4, click5, click6, click7, click8;
    private float smoothScale1, smoothScale2, smoothScale3, smoothScale4, smoothScale5, smoothScale6, smoothScale7, smoothScale8;
    private boolean randomGenerateOver, manualGenerateOver, backOver, backOver2, textOver, squareCreateOver, freedrawOver, saveOver, saveOver2, launchOver, launchOver2, horizontalOver, verticalOver, diagonalOver1, diagonalOver2, spawnOver, triangleOver, cavernOver, mazeOver;
    private boolean squareSelected, horizontalSelected, verticalSelected, diagonalSelected1, diagonalSelected2, freedrawSelected, spawnSelected, spawnSelected2, triangleSelected, cavernSelected, mazeSelected;
    private int buttonRandDimX, buttonManDimX, buttonDimY, buttonRandLocX, buttonRandLocY, buttonManLocX, buttonManLocY, shapeButtonWidth, shapeButtonHeight, shapeButtonLocY;
    private int backgroundXLoc, backgroundYLoc, backgroundWidth, backgroundHeight, taskBarXLoc, taskBarYLoc, taskBarHeight, taskBarWidth, page;
    private final int a = color(0, 0, 0, 175);
    private final int b = color(0, 0, 0, 0);
    private PImage img;
    private int underLineLen = 90;
    private int underLineLenButtonRand;
    private int underLineLenButtonMan;
    private int scale = 50;
    private boolean randCreate = true;
    private int randX = 0;
    private int randY = 0;
    @NotNull
    private ArrayList<squareColliders> squareCollidersFill = new ArrayList<>();
    @NotNull
    private ArrayList<squareColliders> squareCollidersFill2 = new ArrayList<>();
    @NotNull
    private ArrayList<TriangleColliders> triangleCollidersFill = new ArrayList<>();
    @NotNull
    private ArrayList<lineWallCollider> wallMain = new ArrayList<>();
    @NotNull
    private ArrayList<lineWallCollider> wallMain2 = new ArrayList<>();
    @NotNull
    private ArrayList<SpawnBox> spawnBoxes = new ArrayList<>();
    @NotNull
    private ArrayList<SpawnBox> spawnBoxes2 = new ArrayList<>();
    public int posX, posY;

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

        buttonRandLocX = width / 3;
        buttonRandLocY = height - 90;

        buttonManDimX = 520;

        buttonManLocX = (width >> 1) + width / 5;
        buttonManLocY = height - 90;

        backgroundXLoc = width >> 1;
        backgroundYLoc = height - 115;

        backgroundWidth = width;
        backgroundHeight = (int) (height / 3.5);

        underLineLenButtonRand = buttonRandLocX - (buttonRandDimX >> 1);
        underLineLenButtonMan = buttonManLocX - (buttonManDimX >> 1);

        taskBarXLoc = width >> 1;
        taskBarYLoc = height - height / 20;

        taskBarHeight = (height / 10);
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
                break;
            case 3:
                launchPage();
        }
    }

    @SuppressWarnings("Duplicates")
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
        image(img, 225, 50);

        setGradient(-(backgroundYLoc - (backgroundHeight / 2)), width, a, b);

        createBackground(backgroundXLoc, backgroundYLoc, backgroundWidth, backgroundHeight);
        if (randomGenerateOver) {
            if (underLineLenButtonRand <= buttonRandLocX + (buttonRandDimX >> 1)) {
                for (int i = 0; i < buttonRandLocX + (buttonRandDimX >> 1); i += 50) {
                    underLineLenButtonRand += 2;
                    createButton("Random Generation", buttonRandLocX, buttonRandLocY, buttonRandDimX, buttonDimY, randomGenerateOver, buttonRandLocX - (buttonRandDimX >> 1), underLineLenButtonRand);
                }
            } else
                createButton("Random Generation", buttonRandLocX, buttonRandLocY, buttonRandDimX, buttonDimY, randomGenerateOver, buttonRandLocX - (buttonRandDimX >> 1), underLineLenButtonRand);
        } else {
            if (underLineLenButtonRand > buttonRandLocX + (buttonRandDimX >> 1)) {
                for (int i = 0; i < buttonRandLocX + (buttonRandDimX >> 1); i += 50) {
                    underLineLenButtonRand -= 2;
                    createButton("Random Generation", buttonRandLocX, buttonRandLocY, buttonRandDimX, buttonDimY, randomGenerateOver, buttonRandLocX - (buttonRandDimX >> 1), underLineLenButtonRand);
                }
            } else {
                createButton("Random Generation", buttonRandLocX, buttonRandLocY, buttonRandDimX, buttonDimY, randomGenerateOver);
                underLineLenButtonRand = 300;
            }
        }
        if (manualGenerateOver) {
            if (underLineLenButtonMan <= buttonManLocX + (buttonManDimX >> 1)) {
                for (int i = 0; i < buttonManLocX + buttonManDimX / 2; i += 50) {
                    underLineLenButtonMan += 2;
                    createButton("Manual Environment Setup", buttonManLocX, buttonManLocY, buttonManDimX, buttonDimY, manualGenerateOver, buttonManLocX - (buttonManDimX >> 1), underLineLenButtonMan);
                }
            } else
                createButton("Manual Environment Setup", buttonManLocX, buttonManLocY, buttonManDimX, buttonDimY, manualGenerateOver, buttonManLocX - (buttonManDimX >> 1), underLineLenButtonMan);
        } else {
            if (underLineLenButtonMan > buttonManLocX + (buttonManDimX >> 1)) {
                for (int i = 0; i < buttonManLocX + buttonManDimX / 2; i += 50) {
                    underLineLenButtonMan -= 2;
                    createButton("Manual Environment Setup", buttonManLocX, buttonManLocY, buttonManDimX, buttonDimY, manualGenerateOver, buttonManLocX - (buttonManDimX >> 1), underLineLenButtonMan);
                }
            } else {
                createButton("Manual Environment Setup", buttonManLocX, buttonManLocY, buttonManDimX, buttonDimY, manualGenerateOver);
                underLineLenButtonMan = 600;
            }
        }

        if (textOver) {
            if (underLineLen <= 375) {
                for (int i = 0; i < 375; i += 50) {
                    underLineLen += 2;
                    createText(height - 200, underLineLen);
                }
            } else createText(height - 200, underLineLen);
        } else {
            if (underLineLen > 90) {
                for (int i = 0; i < 375; i += 50) {
                    underLineLen -= 3;
                    createText(height - 200, underLineLen);
                }
            } else createText(height - 200);
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
            yDist7 = xDist7 = (int) (width - random(height)) + 100;
            click1 = click2 = click3 = click4 = click5 = click6 = click7 = click8 = false;
            smoothScale1 = smoothScale2 = smoothScale3 = smoothScale4 = smoothScale5 = smoothScale6 = smoothScale7 = smoothScale8 = width >> 3;
        }
        y -= 10;
    }

    private void manualGenPage() {
        update();

        background(30);
        createBackground(taskBarXLoc, taskBarYLoc, taskBarWidth, taskBarHeight);
        createShapeButton("Back", 200, shapeButtonLocY, shapeButtonWidth, shapeButtonHeight, backOver);
        createShapeButton(510, shapeButtonLocY, shapeButtonWidth, shapeButtonHeight, squareCreateOver, "Square");
        createShapeButton(400, shapeButtonLocY, shapeButtonWidth, shapeButtonHeight, triangleOver, "Triangle");
        createShapeButton(610, shapeButtonLocY, shapeButtonWidth, shapeButtonHeight, horizontalOver, "Horizontal");
        createShapeButton(710, shapeButtonLocY, shapeButtonWidth, shapeButtonHeight, verticalOver, "Vertical");
        createShapeButton(810, shapeButtonLocY, shapeButtonWidth, shapeButtonHeight, diagonalOver1, "Diagonal1");
        createShapeButton(950, shapeButtonLocY, shapeButtonWidth, shapeButtonHeight, diagonalOver2, "Diagonal2");
        createShapeButton("Free Draw", 1100, shapeButtonLocY, shapeButtonWidth, shapeButtonHeight, freedrawOver, "Curve");
        createShapeButton("Set Spawn", 1270, shapeButtonLocY, shapeButtonWidth, shapeButtonHeight, spawnOver, "Square");
        createShapeButton("Save", 1450, shapeButtonLocY, shapeButtonWidth, shapeButtonHeight, saveOver);
        createShapeButton("Launch Game", 1600, shapeButtonLocY, shapeButtonWidth, shapeButtonHeight, launchOver);

        if (!(wallMain.isEmpty())) {
            for (lineWallCollider lineColliders : wallMain) {
                lineColliders.showBoundary();
            }
        }
        if (!(squareCollidersFill.isEmpty())) {
            for (squareColliders squareColliders : squareCollidersFill) {
                squareColliders.squareFill();
            }
        }
        if (!(triangleCollidersFill.isEmpty())) {
            for (TriangleColliders triangleColliders : triangleCollidersFill) {
                triangleColliders.triangleFill();
            }
        }
        if(!(spawnBoxes.isEmpty())){
            for(SpawnBox spawns : spawnBoxes){
                spawns.squareFill();
            }
        }

        if (squareSelected) {
            stroke(255);
            rect(mouseX, mouseY, scale, scale);
        }
        if (spawnSelected) {
            fill(240, 230, 140);
            rect(mouseX, mouseY, 30, 30);
        }
        if (horizontalSelected) {
            stroke(255);
            line(mouseX - (scale >> 1), mouseY, mouseX + (scale >> 1), mouseY);
        }
        if (verticalSelected) {
            stroke(255);
            line(mouseX, mouseY + (scale >> 1), mouseX, mouseY - (scale >> 1));
        }
        if (diagonalSelected1) {
            stroke(255);
            line(mouseX - (scale >> 1), mouseY - (scale >> 1), mouseX + (scale >> 1), mouseY + (scale >> 1));
        }
        if (diagonalSelected2) {
            stroke(255);
            line(mouseX - (scale >> 1), mouseY + (scale >> 1), mouseX + (scale >> 1), mouseY - (scale >> 1));
        }
        if (freedrawSelected) {
            cursor(CROSS);
        } else cursor(ARROW);
        if (triangleSelected) {
            stroke(255);
            fill(255);
            triangle(mouseX - (scale >> 1), mouseY + (scale >> 1), mouseX, mouseY - (scale >> 1), mouseX + (scale >> 1), mouseY + (scale >> 1));
        }
    }

    private void randomGenPage() {
        update();

        background(30);
        int spacing = 20;
        createBackground(taskBarXLoc, taskBarYLoc, taskBarWidth, taskBarHeight);
        createShapeButton("Back", 200, shapeButtonLocY, shapeButtonWidth, shapeButtonHeight, backOver2);
        createShapeButton("Maze Map", 500, shapeButtonLocY, 200, shapeButtonHeight, mazeOver);
        createShapeButton("Cube Cavern Map", 900, shapeButtonLocY, 350, shapeButtonHeight, cavernOver);
        createShapeButton("Save", 1400, shapeButtonLocY, shapeButtonWidth, shapeButtonHeight, saveOver2);
        createShapeButton("Launch Game", 1600, shapeButtonLocY, shapeButtonWidth, shapeButtonHeight, launchOver2);

        if(mazeSelected){
            stroke(255);
            while(randCreate){
                if(random(1) < 0.70){
                    wallMain2.add(new lineWallCollider(randX, randX + spacing, randY + 30, randY + spacing + 30, this));

                } else {
                    wallMain2.add(new lineWallCollider(randX, randX + spacing, randY + spacing + 30, randY + 30, this));
                }
                randX += spacing;
                if(randX > width){
                    randX = 0;
                    randY += spacing;
                }
                if(randY > height/1.2){
                    randCreate = false;
                }
            }
        } else if(cavernSelected){
            stroke(255);
            while(randCreate){
                if(random(1) < 0.36){
                    int X1 = randX - 10;
                    int X2 = randX + 10;
                    int X3 = randX - 10;
                    int X4 = randX + 10;
                    int Y1 = randY - 10;
                    int Y2 = randY - 10;
                    int Y3 = randY + 10;
                    int Y4 = randY + 10;

                    squareCollidersFill2.add(new squareColliders(randX, randY + 30, 20, this));
                    wallMain2.add(new lineWallCollider(X1, X2, Y1 + 30, Y2 + 30, this));
                    wallMain2.add(new lineWallCollider(X1, X3, Y1 + 30, Y3 + 30, this));
                    wallMain2.add(new lineWallCollider(X2, X4, Y2 + 30, Y4 + 30, this));
                    wallMain2.add(new lineWallCollider(X3, X4, Y3 + 30, Y4 + 30, this));
                }
                randX += spacing;
                if(randX > width){
                    randX = 0;
                    randY += spacing;
                }
                if(randY > height/1.2){
                    randCreate = false;
                }
            }
        }

        if (!(wallMain2.isEmpty())) {
            for (lineWallCollider lineColliders : wallMain2) {
                lineColliders.showBoundary();
            }
        }
        if (!(squareCollidersFill2.isEmpty())) {
            for (squareColliders squareColliders : squareCollidersFill2) {
                squareColliders.squareFill();
            }
        }
        if(!(spawnBoxes2.isEmpty())){
            for(SpawnBox spawns : spawnBoxes2){
                spawns.squareFill();
            }
        }
    }

    public void launchPage(){

    }

    private void gamePage(){
        background(30);

    }

    private void createBackground(int xLoc, int yLoc, int width, int height) {
//        noStroke();
        fill(202, 0, 5);
        rect(xLoc, yLoc, width, height);
    }

    private void createText(int yLoc, int end) {
        fill(255);
        textSize(40);
        text("Environment Setup", 90, yLoc);
        stroke(255);
        line(90, yLoc + 10, end, yLoc + 10);
        line(90, yLoc + 9, end, yLoc + 9);
    }

    private void createText(int yLoc) {
        fill(255);
        textSize(40);
        text("Environment Setup", 90, yLoc);
    }

    private void circleCreate(float x, float y, float randomSize) {
        ellipse((x), (y), randomSize, randomSize);
    }

    private void createButton(String label, int xLoc, int yLoc, int xDim, int yDim, boolean hover) {
        noStroke();
        fill(hover ? color(220, 0, 5) : color(202, 0, 5));
        rect(xLoc, yLoc, xDim, yDim);
        fill(200);
        textSize(40);
        text(label, xLoc - (xDim >> 1), yLoc + (yDim >> 2));
    }

    private void createButton(String label, int xLoc, int yLoc, int xDim, int yDim, boolean hover, int start, int end) {
        noStroke();
        fill(hover ? color(220, 0, 5) : color(202, 0, 5));
        rect(xLoc, yLoc, xDim, yDim);
        fill(200);
        textSize(40);
        text(label, xLoc - (xDim >> 1), yLoc + (yDim >> 2));
        stroke(255);
        line(start, yLoc + 15, end, yLoc + 15);
        line(start, yLoc + 14, end, yLoc + 14);
    }

    private void createShapeButton(String label, int xLoc, int yLoc, int xDim, int yDim, boolean hover) {
        noStroke();
        fill(hover ? color(220, 0, 5) : color(202, 0, 5));
        rect(xLoc, yLoc, xDim, yDim);
        fill(200);
        textSize(40);
        text(label, xLoc - (xDim / 2), yLoc + (yDim >> 2));
    }

    private void createShapeButton(String label, int xLoc, int yLoc, int xDim, int yDim, boolean hover, @NotNull String shape) {
        noStroke();
        fill(hover ? color(220, 0, 5) : color(202, 0, 5));
        rect(xLoc, yLoc, xDim, yDim);
        fill(200);
        textSize(20);
        if (shape.equals("Curve")) {
            text(label, xLoc - ((int) (xDim * 1.5)) + 100, yLoc + (yDim >> 2));
            noFill();
            stroke(255);
            curve((xLoc << 1) + 100, yLoc - 90, xLoc - (xDim >> 1) + 100, yLoc - 50, xLoc + 100, yLoc, xLoc + (xDim << 1) + 100, yLoc);
        }
        if (shape.equals("Square")) {
            textSize(20);
            text(label, xLoc - (xDim >> 1), yLoc + (yDim >> 1));
            fill(240, 230, 140);
            rect(xLoc, yLoc - (yDim >> 1) - 8, 30, 30);
        }
    }

    private void createShapeButton(int xLoc, int yLoc, int xDim, int yDim, boolean hover, @NotNull String shape) {
        noStroke();
        fill(hover ? color(220, 0, 5) : color(202, 0, 5));
        rect(xLoc, yLoc, xDim, yDim);
        if (shape.equals("Square")) {
            fill(255);
            stroke(255);
            rect(xLoc, yLoc - 5, 50, 50);
        }
        if (shape.equals("Triangle")) {
            fill(255);
            triangle(xLoc - 20, yLoc + 15, xLoc + 25 - 20, yLoc - 30, xLoc + 50 - 20, yLoc + 15);
        }
        if (shape.equals("Horizontal")) {
            stroke(255);
            strokeWeight(4);
            line(xLoc - xDim / 2, yLoc - 5, xLoc + xDim / 2, yLoc - 5);
        }
        if (shape.equals("Vertical")) {
            stroke(255);
            strokeWeight(4);
            line(xLoc, (yLoc - 5) - yDim / 2, xLoc, (yLoc - 5) + yDim / 2);
        }
        if (shape.equals("Diagonal1")) {
            stroke(255);
            strokeWeight(4);
            line(xLoc - xDim / 2, (yLoc - 5) - yDim / 2, xLoc + xDim / 2, (yLoc - 5) + yDim / 2);
        }
        if (shape.equals("Diagonal2")) {
            stroke(255);
            strokeWeight(4);
            line(xLoc - xDim / 2, (yLoc - 5) + yDim / 2, xLoc + xDim / 2, (yLoc - 5) - yDim / 2);
        }
    }

    private void setGradient(int y, float w, int c1, int c2) {
        noFill();
        if (ShadowGradient.BUTTON_TO_TOP == ShadowGradient.BUTTON_TO_TOP) {  // BOTTOM TO TOP GRADIENT FOR BOX SHADOWS
            for (float i = 0, j = y; j <= y + (float) 45 - 1 && i <= 0.8; j++, i += 0.1) {
                int c = lerpColor(c1, c2, i);
                stroke(c);
                line(0, -j, 0 + w, -j);
            }
        }
        if (ShadowGradient.BUTTON_TO_TOP == ShadowGradient.TOP_TO_BOTTOM) {  // TOP TO BOTTOM GRADIENT FOR BOX SHADOWS
            for (int i = y; i <= y + (float) 45 - 1; i++) {
                float inter = map(i, y, y + (float) 45, 0, 1);
                int c = lerpColor(c1, c2, inter);
                stroke(c);
                line(0, i, 0 + w, i);
            }
        } else if (ShadowGradient.BUTTON_TO_TOP == ShadowGradient.LEFT_TO_RIGHT) {  // LEFT TO RIGHT GRADIENT FOR BOX SHADOWS
            for (int i = (int) (0 + w); i > 1; i--) {
                float inter = map(i, 0, 0 + w, 0, 1);
                int c = lerpColor(c1, c2, inter);
                stroke(c);
                line(i, y, i, y + (float) 45);
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
    private boolean mouseOverText(int locY) {
        return (mouseX > (90 - (590 >> 1)) && (mouseX < 90 + (590 >> 1))) && (mouseY > locY - (32 >> 1)) && (mouseY < locY + (32 >> 1));
    }

    @Contract(pure = true)
    private boolean mouseOverBack(int locY, int dimX, int dimY) {
        return (mouseX > (200 - (dimX >> 1)) && (mouseX < 200 + (dimX >> 1)) && (mouseY > locY - (dimY >> 1)) && (mouseY < locY + (dimY >> 1)));
    }

    @Contract(pure = true)
    private boolean mouseOverBack(int locX, int locY, int dimX, int dimY) {
        return (mouseX > (locX - (dimX >> 1)) && (mouseX < locX + (dimX >> 1)) && (mouseY > locY - (dimY >> 1)) && (mouseY < locY + (dimY >> 1)));
    }

    @Contract(pure = true)
    private boolean mouseOverSquare(int locY, int dimX, int dimY) {
        return (mouseX > (510 - (dimX >> 1)) && (mouseX < 510 + (dimX >> 1)) && (mouseY > locY - (dimY >> 1)) && (mouseY < locY + (dimY >> 1)));
    }

    @Contract(pure = true)
    private boolean mouseOverTriangle(int locY, int dimX, int dimY) {
        return (mouseX > (360 - (dimX >> 1)) && (mouseX < 360 + (dimX >> 1))) && (mouseY > locY - (dimY >> 1)) && (mouseY < locY + (dimY >> 1));
    }

    @Contract(pure = true)
    private boolean mouseOverHorizontal(int locY, int dimX, int dimY) {
        return (mouseX > (610 - (dimX >> 1)) && (mouseX < 610 + (dimX >> 1))) && (mouseY > locY - (dimY >> 1)) && (mouseY < locY + (dimY >> 1));
    }

    @Contract(pure = true)
    private boolean mouseOverVertical(int locY, int dimX, int dimY) {
        return (mouseX > (710 - (dimX >> 1)) && (mouseX < 710 + (dimX >> 1))) && (mouseY > locY - (dimY >> 1)) && (mouseY < locY + (dimY >> 1));
    }

    @Contract(pure = true)
    private boolean mouseOverDiagonal1(int locX ,int locY, int dimX, int dimY) {
        return (mouseX > (locX - (dimX >> 1)) && (mouseX < locX + (dimX >> 1))) && (mouseY > locY - (dimY >> 1)) && (mouseY < locY + (dimY >> 1));
    }

    @Contract(pure = true)
    private boolean mouseOverDiagonal2(int locY, int dimX, int dimY) {
        return (mouseX > (950 - (dimX >> 1)) && (mouseX < 950 + (dimX >> 1))) && (mouseY > locY - (dimY >> 1)) && (mouseY < locY + (dimY >> 1));
    }

    @Contract(pure = true)
    private boolean mouseOverFreedraw(int locY, int dimX, int dimY) {
        return (mouseX > (1100 - (dimX >> 1)) && (mouseX < 1100 + (dimX >> 1))) && (mouseY > locY - (dimY >> 1)) && (mouseY < locY + (dimY >> 1));
    }

    @Contract(pure = true)
    private boolean mouseOverSave(int locY, int dimX, int dimY) {
        return (mouseX > (1400 - (dimX >> 1)) && (mouseX < 1400 + (dimX >> 1))) && (mouseY > locY - (dimY >> 1)) && (mouseY < locY + (dimY >> 1));
    }

    @Contract(pure = true)
    private boolean mouseOverSave(int locX, int locY, int dimX, int dimY) {
        return (mouseX > (locX - (dimX >> 1)) && (mouseX < locX + (dimX >> 1))) && (mouseY > locY - (dimY >> 1)) && (mouseY < locY + (dimY >> 1));
    }

    @Contract(pure = true)
    private boolean mouseOverLaunch(int locY, int dimX, int dimY) {
        return (mouseX > (1600 - (dimX >> 1)) && (mouseX < 1600 + (dimX >> 1))) && (mouseY > locY - (dimY >> 1)) && (mouseY < locY + (dimY >> 1));
    }

    @Contract(pure = true)
    private boolean mouseOverLaunch(int locX, int locY, int dimX, int dimY) {
        return (mouseX > (locX - (dimX >> 1)) && (mouseX < locX + (dimX >> 1))) && (mouseY > locY - (dimY >> 1)) && (mouseY < locY + (dimY >> 1));
    }

    @Contract(pure = true)
    private boolean mouseOverSpawnSet(int locY, int dimX, int dimY) {
        return (mouseX > (1270 - (dimX >> 1)) && (mouseX < 1270 + (dimX >> 1))) && (mouseY > locY - (dimY >> 1)) && (mouseY < locY + (dimY >> 1));
    }

    @Contract(pure = true)
    private boolean mouseOverSpawnSet(int locX, int locY, int dimX, int dimY) {
        return (mouseX > (locX - (dimX >> 1)) && (mouseX < locX + (dimX >> 1))) && (mouseY > locY - (dimY >> 1)) && (mouseY < locY + (dimY >> 1));
    }

    @Contract(pure = true)
    private boolean mouseOverMaze(int locX, int locY, int dimX, int dimY) {
        return (mouseX > (locX - (dimX >> 1)) && (mouseX < locX + (dimX >> 1))) && (mouseY > locY - (dimY >> 1)) && (mouseY < locY + (dimY >> 1));
    }

    @Contract(pure = true)
    private boolean mouseOverCavern(int locX, int locY, int dimX, int dimY) {
        return (mouseX > (locX - (dimX >> 1)) && (mouseX < locX + (dimX >> 1))) && (mouseY > locY - (dimY >> 1)) && (mouseY < locY + (dimY >> 1));
    }

    @Contract(pure = true)
    private void update() {
        boolean spawnOver2;
        if (mouseOverSpawnSet(shapeButtonLocY, shapeButtonWidth, shapeButtonHeight)) {
            spawnOver = true;
            squareCreateOver = freedrawOver = saveOver = launchOver = horizontalOver = verticalOver = diagonalOver1 = diagonalOver2 = triangleOver = cavernOver = mazeOver = saveOver2 = launchOver2 = false;
        } else if (mouseOverLaunch(shapeButtonLocY, shapeButtonWidth, shapeButtonHeight)) {
            launchOver = true;
            squareCreateOver = freedrawOver = saveOver = spawnOver = horizontalOver = verticalOver = diagonalOver1 = diagonalOver2 = triangleOver = cavernOver = mazeOver = saveOver2 = launchOver2 = false;
        } else if (mouseOverSave(shapeButtonLocY, shapeButtonWidth, shapeButtonHeight)) {
            saveOver = true;
            squareCreateOver = freedrawOver = launchOver = spawnOver = horizontalOver = verticalOver = diagonalOver1 = diagonalOver2 = triangleOver = cavernOver = mazeOver = saveOver2 = launchOver2 = false;
        } else if (mouseOverFreedraw(shapeButtonLocY, shapeButtonWidth, shapeButtonHeight)) {
            freedrawOver = true;
            squareCreateOver = launchOver = saveOver = spawnOver = horizontalOver = verticalOver = diagonalOver1 = diagonalOver2 = triangleOver = cavernOver = mazeOver = launchOver2 = saveOver2 = false;
        } else if (mouseOverDiagonal1(810, shapeButtonLocY, shapeButtonWidth, shapeButtonHeight)) {
            diagonalOver1 = true;
            launchOver = squareCreateOver = freedrawOver = saveOver = spawnOver = horizontalOver = verticalOver = diagonalOver2 = triangleOver = cavernOver = mazeOver = saveOver2 = launchOver2 = false;
        } else if (mouseOverDiagonal2(shapeButtonLocY, shapeButtonWidth, shapeButtonHeight)) {
            diagonalOver2 = true;
            squareCreateOver = freedrawOver = saveOver = spawnOver = horizontalOver = verticalOver = launchOver = diagonalOver1 = triangleOver = cavernOver = mazeOver = saveOver2 = launchOver2 = false;
        } else if (mouseOverVertical(shapeButtonLocY, shapeButtonWidth, shapeButtonHeight)) {
            verticalOver = true;
            squareCreateOver = freedrawOver = saveOver = spawnOver = horizontalOver = launchOver = diagonalOver1 = diagonalOver2 = triangleOver = cavernOver = mazeOver = saveOver2 = launchOver2 = false;
        } else if (mouseOverHorizontal(shapeButtonLocY, shapeButtonWidth, shapeButtonHeight)) {
            horizontalOver = true;
            squareCreateOver = freedrawOver = saveOver = spawnOver = launchOver = verticalOver = diagonalOver1 = diagonalOver2 = triangleOver = cavernOver = mazeOver = saveOver2 = launchOver2 = false;
        } else if (mouseOverSquare(shapeButtonLocY, shapeButtonWidth, shapeButtonHeight)) {
            squareCreateOver = true;
            launchOver = freedrawOver = saveOver = spawnOver = horizontalOver = verticalOver = diagonalOver1 = diagonalOver2 = triangleOver = cavernOver = mazeOver = saveOver2 = launchOver2 = false;
        } else if (mouseOverTriangle(shapeButtonLocY, shapeButtonWidth, shapeButtonHeight)) {
            triangleOver = true;
            launchOver = freedrawOver = saveOver = spawnOver = horizontalOver = verticalOver = diagonalOver1 = diagonalOver2 = cavernOver = mazeOver = saveOver2 = launchOver2 = false;
        } else {
            squareCreateOver = launchOver = freedrawOver = saveOver = spawnOver = horizontalOver = verticalOver = diagonalOver1 = diagonalOver2 = triangleOver = cavernOver = mazeOver = saveOver2 = launchOver2 = false;
        }

        if (mouseOverCavern(900, shapeButtonLocY, 350, shapeButtonHeight)) {
            cavernOver = true;
            mazeOver = saveOver2 = launchOver2 = spawnOver2 = false;
        } else if (mouseOverMaze(500, shapeButtonLocY, 200, shapeButtonHeight)) {
            mazeOver = true;
            cavernOver = saveOver2 = launchOver2 = spawnOver2 = false;
        } else if (mouseOverSave(1400, shapeButtonLocY, shapeButtonWidth, shapeButtonHeight)) {
            saveOver2 = true;
            cavernOver = mazeOver = launchOver2 = spawnOver2 = false;
        } else if (mouseOverLaunch(1600, shapeButtonLocY, shapeButtonWidth, shapeButtonHeight)) {
            launchOver2 = true;
            cavernOver = mazeOver = saveOver2 = spawnOver2 = false;
        } else {
            cavernOver = mazeOver = saveOver2 = launchOver2 = spawnOver2 = false;
        }

        textOver = mouseOverText(height - 180);

        if (mouseOverButtonRand(buttonRandLocX, buttonRandLocY, buttonRandDimX, buttonDimY)) {
            randomGenerateOver = true;
            backOver =  backOver2 = manualGenerateOver = false;
        } else if (mouseOverButtonMan(buttonManLocX, buttonManLocY, buttonManDimX, buttonDimY)) {
            manualGenerateOver = true;
            backOver =  backOver2 = randomGenerateOver = false;
        } else {
            manualGenerateOver = randomGenerateOver = false;
        }

        backOver2 = mouseOverBack(200, shapeButtonLocY, shapeButtonWidth, shapeButtonHeight);
        backOver = mouseOverBack(shapeButtonLocY, shapeButtonWidth, shapeButtonHeight);

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
        if ((page == 1 || page == 2) && launchOver) page = 3;

        if (page == 0 && randomGenerateOver) page = 1;
        else if (page == 0 && manualGenerateOver) page = 2;

        if (page == 1 && launchOver) page = 3;
        else if (page == 2 && launchOver) page = 4;

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
            if (y3 > (height - 115)) {
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
            if (y3 > (height - 115)) {
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
            if (y1 > (height - 115)) {
                horizontalSelected = false;
            } else wallMain.add(new lineWallCollider(x1, x2, y1, y2, this));
        }
        if (verticalSelected) {
            int x1 = mouseX;
            int x2 = mouseX;
            int y1 = mouseY + (scale >> 1);
            int y2 = mouseY - (scale >> 1);
            if (y1 > (height - 115)) {
                verticalSelected = false;
            } else wallMain.add(new lineWallCollider(x1, x2, y1, y2, this));
        }
        if (diagonalSelected1) {
            int x1 = mouseX - (scale >> 1);
            int x2 = mouseX + (scale >> 1);
            int y1 = mouseY - (scale >> 1);
            int y2 = mouseY + (scale >> 1);
            if (y1 > (height - 115)) {
                diagonalSelected1 = false;
            } else wallMain.add(new lineWallCollider(x1, x2, y1, y2, this));
        }
        if (diagonalSelected2) {
            int x1 = mouseX - (scale >> 1);
            int x2 = mouseX + (scale >> 1);
            int y1 = mouseY + (scale >> 1);
            int y2 = mouseY - (scale >> 1);
            if (y1 > (height - 115)) {
                diagonalSelected2 = false;
            } else wallMain.add(new lineWallCollider(x1, x2, y1, y2, this));
        }
        if (freedrawSelected) {
            int pos1 = mouseX;
            int pos2 = mouseY;
            int pos3 = pmouseX;
            int pos4 = pmouseY;
            if (pos2 > (height - 115)) {
                freedrawSelected = false;
            } else wallMain.add(new lineWallCollider(pos1, pos3, pos2, pos4, this));
        }
        if (triangleSelected && (mouseButton == LEFT)) {
            int x1 = mouseX - (scale >> 1);
            int x2 = mouseX;
            int x3 = mouseX + (scale >> 1);
            int y1 = mouseY + (scale >> 1);
            int y2 = mouseY - (scale >> 1);
            int y3 = mouseY + (scale >> 1);
            if (y1 > (height - 115)) {
                triangleSelected = false;
            } else {
                triangleCollidersFill.add(new TriangleColliders(x1, x2, x3, y1, y2, y3, this));
                wallMain.add(new lineWallCollider(x1, x2, y1, y2, this));
                wallMain.add(new lineWallCollider(x1, x3, y1, y3, this));
                wallMain.add(new lineWallCollider(x2, x3, y2, y3, this));
            }
        }
        if (triangleSelected && (mouseButton == RIGHT)) {
            int x1 = mouseX - (scale >> 1);
            int x2 = mouseX;
            int x3 = mouseX + (scale >> 1);
            int y1 = mouseY + (scale >> 1);
            int y2 = mouseY - (scale >> 1);
            int y3 = mouseY + (scale >> 1);
            if (y1 > (height - 115)) {
                triangleSelected = false;
            } else {
                wallMain.add(new lineWallCollider(x1, x2, y1, y2, this));
                wallMain.add(new lineWallCollider(x1, x3, y1, y3, this));
                wallMain.add(new lineWallCollider(x2, x3, y2, y3, this));
            }
        }
        if(spawnSelected){
            posX = mouseX;
            posY = mouseY;
            if (posY > (height - 115)) {
                spawnSelected = false;
            } else {
                spawnBoxes.add(new SpawnBox(posX, posY, 30, this));
            }
        }
        if(spawnSelected2){
            posX = mouseX;
            posY = mouseY;
            if (posY > (height - 115)) {
                spawnSelected2 = false;
            } else {
                spawnBoxes2.add(new SpawnBox(posX, posY, 30, this));
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
        } else if (triangleOver) {
            triangleSelected = !triangleSelected;
            scale = 50;
        }
        /*else spawnSelected = freedrawSelected = diagonalSelected2 = diagonalSelected1 = verticalSelected = horizontalSelected = squareSelected = false;*/

        if (cavernOver){
            cavernSelected = !cavernSelected;
        } else if (mazeOver){
            mazeSelected = !mazeSelected;
        }
    }

    public void mouseWheel(@NotNull MouseEvent event) {
        if (event.getCount() == -1) {
            scale += 5;
        } else scale -= 5;
    }

    public enum ShadowGradient {TOP_TO_BOTTOM, LEFT_TO_RIGHT, BUTTON_TO_TOP}
}