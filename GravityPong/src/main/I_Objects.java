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

public interface I_Objects
{
	// Obiekty JavaFx
	
	Pane primaryPane = new Pane();
	Scene primaryScene = new Scene(primaryPane,800,800);
	
	
	// Obiekty do Paddle
	
	Paddle primaryPaddle = new Paddle();
	Line LimitLeft = new Line();
	Line LimitRight = new Line();
	Line LimitUp = new Line();
	Line LimitDown = new Line();
	
	// Do testów dwie pilki statyczne nie dodane do listy obiektow
	
	Ball TestBall_1 = new Ball(0,0,30,Color.CHARTREUSE);
	Ball TestBall_2 = new Ball(400,400,50,Color.BLUE);
	
	// Tworzenie tablicy pi³ek
	
	int NumbersOfBalls = 3;
	ArrayList<Ball> Balls = new ArrayList<Ball>();
	Circle CollisionPoint = new Circle();
	
	
	// Obiekty do sprawdzania zderzen
	
	// Wielu pi³ek
	ArrayList<Shape> CollisionShapes = new ArrayList<Shape>();	
	
	// Dwoch testowych
	ZoneBall_Thread checkBallZone = new ZoneBall_Thread();
	Collisions_Thread collisions = new Collisions_Thread();
	
	// Obiekty przechowuj¹ce bity (POLA BITOWE)
	ZonesBall_Bits zonesBit = new ZonesBall_Bits();
	Collisions_Bits collisionsBits = new Collisions_Bits();
	
	Rectangle ZoneRectangle_1 = new Rectangle();
	Rectangle ZoneRectangle_2 = new Rectangle();
	Rectangle ZoneRectangle_3 = new Rectangle();
	Rectangle ZoneRectangle_4 = new Rectangle();
	Rectangle ZoneRectangle_5 = new Rectangle();
	Rectangle ZoneRectangle_6 = new Rectangle();
	Rectangle ZoneRectangle_7 = new Rectangle();
	Rectangle ZoneRectangle_8 = new Rectangle();
	
	// Liczby losowe
	
	Random Random = new Random();
	

	
}
