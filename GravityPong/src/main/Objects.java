package main;

import java.util.ArrayList;
import java.util.Random;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;


//Wszystkie obiekty w Interfejsach sa static bez modyfikatora

public interface Objects
{
	
	
	
    // Obiekty JavaFx
	
	Pane primaryPane = new Pane();
	Scene primaryScene = new Scene(primaryPane,800,800);
	
	
	// Do testów dwie pilki statyczne nie dodane do listy obiektow
	
	Ball TestBall_1 = new Ball(0,0,30,Color.CHARTREUSE);
	Ball TestBall_2 = new Ball(400,400,50,Color.BLUE);
	
	Paddle primaryPaddle = new Paddle();
	
	ArrayList<Ball> Balls = new ArrayList<Ball>();
	Circle CollisionPoint = new Circle();
	int NumbersOfBalls = 3;
	
	ArrayList<Shape> CollisionShapes = new ArrayList<Shape>();
	
	CheckBallZone checkBallZone = new CheckBallZone();
	
	
	Random Random = new Random();
	
	Line LimitLeft = new Line();
	Line LimitRight = new Line();
	Line LimitUp = new Line();
	Line LimitDown = new Line();
	
	Rectangle ZoneRectangle_1 = new Rectangle();
	Rectangle ZoneRectangle_2 = new Rectangle();
	Rectangle ZoneRectangle_3 = new Rectangle();
	Rectangle ZoneRectangle_4 = new Rectangle();
	Rectangle ZoneRectangle_5 = new Rectangle();
	Rectangle ZoneRectangle_6 = new Rectangle();
	Rectangle ZoneRectangle_7 = new Rectangle();
	Rectangle ZoneRectangle_8 = new Rectangle();
	
	

	
	

	


}
