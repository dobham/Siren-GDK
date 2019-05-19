import org.jetbrains.annotations.Contract;
import processing.core.PApplet;

import java.awt.*;

public class SirenApplication extends PApplet {
    private int y;
    private int x;
    private int randSize;
    private int yDist1,xDist1,yDist2,xDist2,yDist3,xDist3,yDist4,xDist4,yDist5,xDist5,yDist6,xDist6,yDist7,xDist7;
    private boolean isOver;
    private boolean circleOver1,circleOver2,circleOver3,circleOver4,circleOver5,circleOver6,circleOver7,circleOver8;
    private boolean click1,click2,click3,click4,click5,click6,click7,click8;
    private float smoothScale1, smoothScale2, smoothScale3, smoothScale4, smoothScale5, smoothScale6, smoothScale7, smoothScale8;

    public static void main(String[] args) {
        PApplet.main("SirenApplication", args);
    }

    public void settings(){
        size(1000,800);
    }

    public void setup() {
        randSize = width/8;
        x = (int)random(width);
        y = 25;
        smoothScale1 = smoothScale2 = smoothScale3 = smoothScale4 = smoothScale5 = smoothScale6 = smoothScale7 = smoothScale8 = width/8;
        ellipseMode(CENTER);
    }

    public void draw() {
        update();
        background(0);
        fill(127,0,0);
        if(click1){
            for(int i = 0; i < width/8; i+=1000){
                smoothScale1 -= 8;
                circleCreate(x, y, smoothScale1);
            }
        } else circleCreate(x, y, randSize);
        if(click2){
            for(int i = 0; i < width/8; i+=1000){
                smoothScale2 -= 8;
                circleCreate(xDist1, y+yDist1, smoothScale2);
            }
        } else circleCreate(xDist1, y+yDist1, randSize);
        if(click3){
            for(int i = 0; i < width/8; i+=1000){
                smoothScale3 -= 8;
                circleCreate(xDist2, y+yDist2, smoothScale3);
            }
        } else circleCreate(xDist2, y+yDist2, randSize);
        if(click4){
            for(int i = 0; i < width/8; i+=1000){
                smoothScale4 -= 8;
                circleCreate(xDist3, y+yDist3, smoothScale4);
            }
        } else circleCreate(xDist3, y+yDist3, randSize);
        if(click5){
            for(int i = 0; i < width/8; i+=1000){
                smoothScale5 -= 8;
                circleCreate(x+xDist4, y+yDist4, smoothScale5);
            }
        } else circleCreate(x+xDist4, y+yDist4, randSize);
        if(click6){
            for(int i = 0; i < width/8; i+=1000){
                smoothScale6 -= 8;
                circleCreate(x+xDist5, y+yDist5, smoothScale6);
            }
        } else circleCreate(x+xDist5, y+yDist5, randSize);

        if(click7){
            for(int i = 0; i < width/8; i+=1000){
                smoothScale7 -= 8;
                circleCreate(x+xDist6, y+yDist6, smoothScale7);
            }
        } else circleCreate(x+xDist6, y+yDist6, randSize);
        if(click8){
            for(int i = 0; i < width/8; i+=1000){
                smoothScale8 -= 8;
                circleCreate(x+xDist7, y+yDist7, smoothScale8);
            }
        }
        else circleCreate(x+xDist7, y+yDist7, randSize);

        //Possibly add a system where each individual circle that goes above the respawn line is SEPERATLY spawned in
        //Will greatly improve looks

        if(y < (-yDist6-100)){
            x = (int)random(width);
            y = height;
            yDist1 = xDist1 = (int)(50 + random(100));
            yDist2 = xDist2 = (int)(150 + random(200));
            yDist3 = xDist3 = (int)(250 + random(300));
            yDist4 = xDist4 = (int)(350 + random(400));
            yDist5 = xDist5 = (int)(450 + random(300));
            yDist6 = xDist6 = (int)(550 + random(200));
            yDist7 = xDist7 = (int)(650 + random(100));
            click1 = click2 = click3 = click4 = click5 = click6 = click7 = click8 = false;
            smoothScale1 = smoothScale2 = smoothScale3 = smoothScale4 = smoothScale5 = smoothScale6 = smoothScale7 = smoothScale8 = width/8;
        }
        y-=10;
    }

    private void circleCreate(float x, float y, float randomSize){
        ellipse((x), (y), randomSize, randomSize);
    }

    public void mousePressed(){
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
    private boolean mouseOver(int randomSize, int x, int y){
        if((mouseX >= x-randomSize/2 && mouseX <= x+randomSize/2) && (mouseY >= y-randomSize/2 && mouseY <= y+randomSize/2)) return true;
        else return false;
    }

    private void update() {
        if (mouseOver(randSize, x, y)) {
            circleOver2 = circleOver3 = circleOver4 = circleOver5 = circleOver6 = circleOver7 = circleOver8 = false;
            circleOver1 = true;
        }
        else if (mouseOver(randSize, xDist1, y+yDist1)) {
            circleOver1 = circleOver3 = circleOver4 = circleOver5 = circleOver6 = circleOver7 = circleOver8 = false;
            circleOver2 = true;
        }
        else if (mouseOver(randSize, xDist2, y+yDist2)) {
            circleOver1 = circleOver2 = circleOver4 = circleOver5 = circleOver6 = circleOver7 = circleOver8 = false;
            circleOver3 = true;
        }
        else if (mouseOver(randSize, xDist3, y+yDist3)) {
            circleOver1 = circleOver2 = circleOver3 = circleOver5 = circleOver6 = circleOver7 = circleOver8 = false;
            circleOver4 = true;
        }
        else if (mouseOver(randSize, x+xDist4, y+yDist4)) {
            circleOver1 = circleOver2 = circleOver3 = circleOver4 = circleOver6 = circleOver7 = circleOver8 = false;
            circleOver5 = true;
        }
        else if (mouseOver(randSize, x+xDist5, y+yDist5)) {
            circleOver1 = circleOver2 = circleOver3 = circleOver4 = circleOver5 = circleOver7 = circleOver8 = false;
            circleOver6 = true;
        }
        else if (mouseOver(randSize, x+xDist6, y+yDist6)) {
            circleOver1 = circleOver2 = circleOver3 = circleOver4 = circleOver5 = circleOver6 = circleOver8 = false;
            circleOver7 = true;
        }
        else if (mouseOver(randSize, x+xDist7, y+yDist7)) {
            circleOver1 = circleOver2 = circleOver3 = circleOver4 = circleOver5 = circleOver6 = circleOver7 = false;
            circleOver8 = true;
        }
        else circleOver1 = circleOver2 = circleOver3 = circleOver4 = circleOver5 = circleOver6 = circleOver7 = circleOver8 = false;
    }
}