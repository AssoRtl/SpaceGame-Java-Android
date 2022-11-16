package com.example.spacegamev2;

import android.app.Instrumentation;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.CountDownTimer;
import android.view.KeyEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import java.util.ArrayList;

public class GameView extends SurfaceView implements Runnable {
    public static int maxX = 30;
    public static int maxY = 42;
    public static float unitW = 0;
    public static float unitH = 0;
    static boolean firstTime = true;
    static boolean gameRunning = true;
    static Ship ship;
    private Boom boom;
    private Space space;
    private Thread gameThread = null;
    private Thread sleepThread = null;
    private Paint paint;
    private Canvas canvas;
    private SurfaceHolder surfaceHolder;
    static ArrayList<Asteroid> asteroids = new ArrayList<>();
    private int ASTEROID_INTERVAL = 30;
    static double GAMEOVER_INTERVAL = 0.001;
    private int currentTime = 0;
    static int GameOverTime = 0;



    public GameView(Context context) {
        super(context);
        surfaceHolder = getHolder();
        paint = new Paint();
        gameThread = new Thread(this);
        gameThread.start();
    }


    @Override
    public void run() {
        while (gameRunning) {
            update();
            draw();
            checkCollision();
            checkIfNewAsteroid();
            control();
            ScoreClass.controlScore();
        }
    }
        private void update() {
        if (!firstTime) {
            ship.update();
            boom.update();
            for (Asteroid asteroid : asteroids) {
                asteroid.update();
            }
        }
    }
    private void draw() {
        if (surfaceHolder.getSurface().isValid()) {
            if (firstTime) {
                firstTime = false;
                unitW = surfaceHolder.getSurfaceFrame().width() / maxX;
                unitH = surfaceHolder.getSurfaceFrame().height() / maxY;
                space = new Space(getContext());
                ship = new Ship(getContext());
                boom = new Boom(getContext());
            }
            canvas = surfaceHolder.lockCanvas();
            canvas.drawColor(Color.BLACK);
            space.drow(paint,canvas);
            ship.drow(paint, canvas);
            boom.drow(paint, canvas);
            for (Asteroid asteroid : asteroids) {
                asteroid.drow(paint, canvas);
            }
            surfaceHolder.unlockCanvasAndPost(canvas);
        }
    }
    private void control() {
        try {
            gameThread.sleep(8);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    private void control1() {
        try {
            sleepThread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
        private void checkCollision ()
        {
            for (Asteroid asteroid : asteroids) {
                if (asteroid.isCollision(ship.x, ship.y, ship.size)) {
                    boom.x = (ship.x) - 3;
                    boom.y = (ship.y) - 3;
                    if (GameOverTime >= GAMEOVER_INTERVAL) {
                        control1();
                        gameRunning = false;
                        Instrumentation inst = new Instrumentation();
                        inst.sendKeyDownUpSync(KeyEvent.KEYCODE_BACK);
                    } else {
                        GameOverTime++;
                    }
                }
            }
        }
        private void checkIfNewAsteroid () {
            if (currentTime >= ASTEROID_INTERVAL) {
                Asteroid asteroid = new Asteroid(getContext());
                asteroids.add(asteroid);
                currentTime = 0;
            } else {
                currentTime++;
            }
        }
    }



