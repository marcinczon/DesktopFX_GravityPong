package main;
import java.util.ArrayList;
import java.util.Random;



import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Path;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.util.Duration;

public class Ball implements I_Parameters
{
	public static int BallCounter=0;
	public int BallNummer=0;
	Circle Ball = new Circle();
	Circle CollisionPoint = new Circle();
	Timeline TimeLineBall = new Timeline();
	
	private ArrayList<Shape> Nodes = new ArrayList<Shape>();
	   
	private int AnimationSpeed=1;	
	private  double VxActual=0;
	private  double VyActual=0;
	private  double Weight=0;
	
	//Wektory prêdkoœci
	private Line VectorX = new Line();
	private Line VectorY = new Line();
	
	private Label LabelVelocityX = new Label();
	private Label LabelVelocityY = new Label();

	
	// Obliczenia wielow¹tkowe
	Ball_CalculationPositionX ball_CalculationPositionX;
	Ball_CalculationPositionY ball_CalculationPositionY;
	


	
	public Ball(double X, double Y, double Weight, Color _Color)
	{
		//Oznczanie numeru pi³ki
		BallCounter++;
		BallNummer=BallCounter;
		
		//Ustawianie parametrów pi³ki
		Ball.setRadius(Weight);		
		Ball.setCenterX(X);
		Ball.setCenterY(Y);
		this.Weight=Weight;
		Ball.setFill(Color.color(Math.random(), Math.random(), Math.random()));
		//Ball.setFill(_Color);
		
		
		//Losowanie predkoœci pocz¹tkowej pi³ki
		Random _random = new Random();
		VxActual=(double)_random.nextInt(40)-20;
		VyActual=(double)_random.nextInt(5)-10;
		
		//Utworzenie funkcji watkowych do obliczania po³o¿enia		
		ball_CalculationPositionX = new Ball_CalculationPositionX(this,VxActual,"  Axis X ");
		ball_CalculationPositionY = new Ball_CalculationPositionY(this,VyActual,Weight,"  Axis Y ");
		ball_CalculationPositionX.start();
		ball_CalculationPositionY.start();
		
	
		//Utworzenie punktu kolizyjnego z inn¹ pi³k¹
		CollisionPoint.setRadius(2);
		CollisionPoint.setFill(Color.RED);
		
		//Animacja pi³ki
		TimeLineBall = new Timeline(new KeyFrame(Duration.millis(AnimationSpeed), ae -> MoveBall()));
		TimeLineBall.setCycleCount(Animation.INDEFINITE);
		TimeLineBall.play();		
		}
	private void SetVectors()
	{
		VectorX.setFill(Color.RED);
		VectorX.setStartX(Ball.getCenterX());
		VectorX.setStartY(Ball.getCenterY());
		VectorX.setEndX(Ball.getCenterX()+VxActual);
		VectorX.setEndY(Ball.getCenterY());
		
		VectorY.setFill(Color.BLUE);
		VectorY.setStartX(Ball.getCenterX());
		VectorY.setStartY(Ball.getCenterY());
		VectorY.setEndX(Ball.getCenterX());
		VectorY.setEndY(Ball.getCenterY()+VyActual);
	}
	private void SetVelocityLabel()
	{
		LabelVelocityX.setLayoutX(Ball.getCenterX()+10);
		LabelVelocityX.setLayoutY(Ball.getCenterX()+10);
		
		LabelVelocityY.setLayoutX(Ball.getCenterX()+10);
		LabelVelocityY.setLayoutY(Ball.getCenterX()+20);
		
		LabelVelocityX.setText(String.format("%2.2f",VxActual));
		LabelVelocityY.setText(String.format("%2.2f",VyActual));
		
	}

	private void MoveBall()
	{		
		// Zastapione obliczenia przez watek
		VxActual = ball_CalculationPositionX.getVxActual();
		VyActual = ball_CalculationPositionY.getVyActual();

		Ball.setCenterX(ball_CalculationPositionX.getPositionX());
		Ball.setCenterY(ball_CalculationPositionY.getPositionY());

		if (ShowVectors)
		{
			SetVectors();
		}
		//setCollisionPoint(0, 0);

	}
	public void setCollisionPoint(double _x, double _y)
	{
		CollisionPoint.setLayoutX(Ball.getCenterX()+_x);
		CollisionPoint.setLayoutY(Ball.getCenterY()+_y);		
	}
	
//	***************
//	Getery i Setery
//	***************
	
	public void setPositionX(double PositionX)
	{
		Ball.setCenterX(PositionX);
	}
	public void setPositionY(double PositionY)
	{
		Ball.setCenterY(PositionY);
	}
	public double getPositionX()
	{
		return Ball.getCenterX();
		
	}
	public double getPositionY()
	{
		return Ball.getCenterY();
		
	}
	public Circle get_ball()
	{
		return Ball;
	}

	public void set_ball(Circle _ball)
	{
		this.Ball = _ball;
	}
	public  double getWeight()
	{
		return Weight;
	}
	public  double getRadius()
	{
		return Ball.getRadius();
	}
	public  void setWeight(double weight)
	{
		Weight = weight;
	}
	public Line getVectorX()
	{
		return VectorX;
	}
	public Line getVectorY()
	{
		return VectorY;
	}
	public void setVectorX(Line vectorX)
	{
		VectorX = vectorX;
	}
	public void setVectorY(Line vectorY)
	{
		VectorY = vectorY;
	}
	public double getVxActual()
	{
		return VxActual;
	}
	public double getVyActual()
	{
		return VyActual;
	}
	public void setVxActual(double vxActual)
	{
		VxActual = vxActual;
	}
	public void setVyActual(double vyActual)
	{
		VyActual = vyActual;
	}
	public ArrayList<Shape> getNodes()
	{
		Nodes.add(CollisionPoint);
		Nodes.add(Ball);		
		Nodes.add(VectorX);
		Nodes.add(VectorY);
		return Nodes;
	}
	public int getBallNummer()
	{
		return BallNummer;
	}
}
///