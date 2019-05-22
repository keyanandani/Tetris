import acm.graphics.*;
import acm.program.*;

import java.util.ArrayList;
import java.awt.*;
import java.awt.event.*;


public class Tetris extends GraphicsProgram implements KeyListener{
    private static final int SQUARESIZE = 20;
    private static final int NUMROWS = 20;
    private static final int NUMCOLUMNS = 10;
    private static final int SCREEN_WIDTH = NUMCOLUMNS*SQUARESIZE;
    private static final int SCREEN_HEIGHT = NUMROWS*SQUARESIZE;
    private static Square [][]grid;
    private static Brick activeBrick;
    private static int speed = 400;
    private static int clearedRows = 0;
    private static int level = 1;
    private static boolean gameOver = false;
    private static final int SCORE = 50;
    private static GLabel showLevel;

    public void run(){
        setTitle("Tetris");
        setCanvasSize(SCREEN_WIDTH, SCREEN_HEIGHT+SCORE);
        makeGrid();
        makeBrick();
        update();
        scoreBoard();


        while (!gameOver){
            clearBrick();
            checkRows();
            activeBrick.setY(activeBrick.getY()+1);
            if (colliding()){
                for(Position p: activeBrick.getSquares()){
                    if(p.getY()<0){
                        gameOver=true;
                    }
                }

                activeBrick.setY(activeBrick.getY()-1);
                update();
                if(!gameOver){

                    makeBrick();
                }

            }
            update();
            pause(speed);

        }

        lose();

    }


    //makes each brick and the corresponding colors
    public void makeBrick(){
        int random = (int)(Math.random()*7);
        if (random == 0){
            Brick brick = new Brick(Color.YELLOW, Shape.O, 0, 5, -2);
            activeBrick = brick;
        }
        if (random == 1){
            Brick brick = new Brick(Color.CYAN, Shape.I, 0, 5, -2);
            activeBrick = brick;
        }
        if (random == 2){
            Brick brick = new Brick(Color.BLUE, Shape.J, 0, 5, -2);
            activeBrick = brick;
        }
        if (random == 3){
            Brick brick = new Brick(Color.GREEN, Shape.S, 0, 5, -2);
            activeBrick = brick;
        }
        if (random == 4){
            Brick brick = new Brick(Color.RED, Shape.Z, 0, 5, -2);
            activeBrick = brick;
        }
        if (random == 5){
            Brick brick = new Brick(Color.ORANGE, Shape.L, 0, 5, -2);
            activeBrick = brick;
        }
        if (random == 6){
            Brick brick = new Brick(Color.MAGENTA, Shape.T, 0, 5, -2);
            activeBrick = brick;
        }
    }

    //this method erases the previous location of the brick as it moves down the screen
    public void clearBrick(){

        ArrayList<Position> squares = activeBrick.getSquares();
        for (Position p: squares) {
            if (p.getX() >= 0 && p.getY() >= 0 && p.getX() < NUMCOLUMNS && p.getY() < NUMROWS) {
                grid[p.getY()][p.getX()].turnOff();
            }
        }
    }

    //updates location of brick on screen
    public void update(){
        ArrayList<Position> squares = activeBrick.getSquares();
        for (Position p: squares){
            if (p.getX()>= 0 && p.getY()>=0 && p.getX()<NUMCOLUMNS && p.getY()<NUMROWS) {
                grid[p.getY()][p.getX()].turnOn();
                grid[p.getY()][p.getX()].setSquareColor(activeBrick.getColor());
            }
        }
    }

    //makes grid for gameboard
    public void makeGrid(){
        grid = new Square [NUMROWS][NUMCOLUMNS];
        for(int i = 0; i<NUMROWS; i++){
            for(int j=0; j<NUMCOLUMNS; j++){
                Square gridSquare = new Square(SQUARESIZE, false, Color.WHITE);
                add(gridSquare);
                GRect emptySquare = new GRect(SQUARESIZE, SQUARESIZE);
                add(emptySquare);
                emptySquare.setLocation(SQUARESIZE*j, SQUARESIZE*i+SCORE);
                grid[i][j] = gridSquare;
                gridSquare.setLocation(SQUARESIZE*j, SQUARESIZE*i+SCORE);
            }
        }
    }

    //checks if brick or wall is colliding with the active brick
   private boolean colliding() {
       for (Position p: activeBrick.getSquares()){
           if (p.getX() >= NUMCOLUMNS || p.getX() < 0){
               return true;
           }
           if (p.getY() >= NUMROWS || (p.getY()>=0 && grid [p.getY()][p.getX()].getOn())) {
               return true;
           }
       }
       return false;

   }
   //checks which row needs to be clears and clears it
   public void checkRows(){
        for(int i = 0; i<NUMROWS; i++){
            if(checkRow(grid[i])){
                clearRow(i);
            }
        }
   }

   //checks to see if row is full and needs to be cleared
   public boolean checkRow(Square[] row){
        for(Square s: row){
            if (s.getOn()==false){
                return false;
            }
        }
        return true;
   }

   //clears row
   public void clearRow(int i){
        clearedRows++;
        for(int j = i; j>0; j--){
            for(int c = 0; c<NUMCOLUMNS; c++){
                grid[j][c].setSquareColor(grid[j-1][c].getColor());
                grid[j][c].setOn(grid[j-1][c].getOn());

            }
        }
        for(int c = 0; c<NUMCOLUMNS; c++){
            grid[0][c].turnOff();
        }
        if(clearedRows>=5){
            clearedRows = 0;
            changeLevel();
        }
   }

   //changes level

   public void level(){
       speed = speed - 30;
   }

    public void changeLevel(){
            level++;
            showLevel.setText("Level: " + level);
            level();
        }

    public void lose(){
        GLabel lose = new GLabel("Game Over, You Lose");
        lose.setFont(new Font("Droid Sans", Font.BOLD, 17));
        lose.setColor(Color.RED);
        lose.setLocation(SCREEN_WIDTH/2-lose.getWidth()/2, SCREEN_HEIGHT/2);
        GRect background = new GRect(lose.getWidth()+20, lose.getHeight()+20);
        background.setLocation(SCREEN_WIDTH/2-lose.getWidth()/2-10, SCREEN_HEIGHT/2-lose.getHeight()-10);
        background.setFilled(true);
        background.setFillColor(Color.WHITE);
        add(background);
        add (lose);
    }

    public void scoreBoard(){
        GRect scoreBoard = new GRect(SCREEN_WIDTH, SCORE);
        scoreBoard.setLocation(0,0);
        scoreBoard.setFilled(true);
        scoreBoard.setFillColor(Color.BLACK);
        add(scoreBoard);
        showLevel = new GLabel("Level: " + level);
        showLevel.setLocation(3,30);
        showLevel.setFont(new Font ("Droid Sans", Font.BOLD, 20));
        showLevel.setColor(Color.WHITE);
        add(showLevel);
    }



    //key movements
    @Override
    public void keyPressed(KeyEvent e){
       //moves right
       if (e.getKeyCode() == 37){
           clearBrick();
           activeBrick.setX(activeBrick.getX()-1);
           if (colliding()){
               activeBrick.setX(activeBrick.getX()+1);
           }
           update();
       }
       //moves left
        if (e.getKeyCode() == 39){
            clearBrick();
            activeBrick.setX(activeBrick.getX()+1);
            if (colliding()){
                activeBrick.setX(activeBrick.getX()-1);
            }
            update();

        }
        //drops brick with spacebar
        if (e.getKeyCode() == 32){
            clearBrick();
            while(!colliding()){
                activeBrick.setY(activeBrick.getY()+1);
            }
            activeBrick.setY(activeBrick.getY()-1);
            update();
        }
        //up arrow rotates brick clockwise 90 degrees
        if (e.getKeyCode() == 38){
            clearBrick();
            activeBrick.rotate();
            if (colliding()){
                activeBrick.rotate();
                activeBrick.rotate();
                activeBrick.rotate();
            }
            update();
        }
    }

}