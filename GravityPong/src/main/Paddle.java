package main;
import java.util.ArrayList;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.util.Duration;

public class Paddle implements Parameters, Objects
{
	Timeline TimeLineBall = new Timeline();
	private int AnimationSpeed=1;
	
	private ArrayList<Shape> Nodes = new ArrayList<Shape>();
	
	Rectangle Paddle = new Rectangle();
	private  double PosX, PosY;
	private  double VxActual=0, VyActual=0;
	private  double Weight=10;
	private  double BasePosX=Screen.primaryScene.getWidth() / 2;
	private  double BasePosY=Screen.primaryScene.getHeight() -30;
	
	PaddleCalculationPositionX paddleCalculationPositionX;
	PaddleCalculationPositionY paddleCalculationPositionY;
	
	//Obiekty dla debugingu
	
	private Line LimitLeft = new Line();
	private Line LimitRight = new Line();
	private Line LimitUp = new Line();
	private Line LimitDown = new Line();
	
	double PaddleLimitLeft = Paddle.getLayoutX();
	double PaddleLimitRight = Paddle.getLayoutX()+Paddle.getWidth();
	
	double PaddleLimitUp = Paddle.getLayoutY();
	double PaddleLimitDown = Paddle.getLayoutY()+Paddle.getHeight();
	
	public Paddle()
	{
		Paddle.setWidth(150);
		Paddle.setHeight(20);
		System.out.println(BasePosX + " " + BasePosY);
		Paddle.setLayoutX(BasePosX);
		Paddle.setLayoutY(BasePosY);
		PosX=Paddle.getLayoutX();
		PosY=Paddle.getLayoutY();
		
		//Linie do debuggingu
		LimitLeft.setFill(Color.BLACK);
		LimitRight.setFill(Color.BLACK);
		LimitUp.setFill(Color.BLACK);
		LimitDown.setFill(Color.BLACK);
		
		paddleCalculationPositionX = new PaddleCalculationPositionX(this, "Paddle Axis X");
		paddleCalculationPositionY = new PaddleCalculationPositionY(this, "Paddle Axis Y");
		
		paddleCalculationPositionX.start();
		paddleCalculationPositionY.start();
		
		TimeLineBall = new Timeline(new KeyFrame(Duration.millis(AnimationSpeed), ae -> Animation()));
		TimeLineBall.setCycleCount(Animation.INDEFINITE);
		TimeLineBall.play();		
		
		
	}
	
	private void Animation()
	{
		
		PosX=paddleCalculationPositionX.getPosXActual();
		PosY=paddleCalculationPositionY.getPosYActual();
		VxActual=paddleCalculationPositionX.getVxActual();
		VyActual=paddleCalculationPositionY.getVyActual();
		


		Paddle.setLayoutX(PosX);
		Paddle.setLayoutY(PosY);
		Screen.setActualVelocityLabel(String.format("%2.2f : %2.2f",PosX,PosY));
		
	}
	
	private void SetLines()
	{
		//Limity do debuggingu
		
		PaddleLimitLeft = Paddle.getLayoutX();
		PaddleLimitRight = Paddle.getLayoutX()+Paddle.getWidth();
		
		PaddleLimitUp = Paddle.getLayoutY();
		PaddleLimitDown = Paddle.getLayoutY()+Paddle.getHeight();
		
		LimitLeft.setStartX(PaddleLimitLeft);
		LimitLeft.setEndX(PaddleLimitLeft);
		LimitLeft.setStartY(0);
		LimitLeft.setEndY(primaryScene.getHeight());
		
		LimitRight.setStartX(PaddleLimitRight);
		LimitRight.setEndX(PaddleLimitRight);
		LimitRight.setStartY(0);
		LimitRight.setEndY(primaryScene.getHeight());
		
		LimitUp.setStartX(0);
		LimitUp.setEndX(primaryScene.getWidth());
		LimitUp.setStartY(PaddleLimitUp);
		LimitUp.setEndY(PaddleLimitUp);
		
		LimitDown.setStartX(0);
		LimitDown.setEndX(primaryScene.getWidth());
		LimitDown.setStartY(PaddleLimitDown);
		LimitDown.setEndY(PaddleLimitDown);
		
		
		
		
	}
	

//	***************
//	Getery i Setery
//	***************
	

	public double getPosX()
	{
		return Paddle.getLayoutX();
	}
	public double getPosY()
	{
		return Paddle.getLayoutY();
	}
	public void setPosX(int posX)
	{
		PosX = posX;
		Paddle.setLayoutX(PosX);
	}
	public void setPosY(int posY)
	{
		PosY = posY;
		Paddle.setLayoutY(PosY);
	}
	public Rectangle getPaddle()
	{
		return Paddle;
	}
	public void setPaddle(Rectangle paddle)
	{
		Paddle = paddle;
	}
	public double getWeight()
	{
		return Weight;
	}
	public void setWeight(double weight)
	{
		Weight = weight;
	}
	public double getVxActual()
	{
		return VxActual;
	}
	public void setVxActual(double vxActual)
	{
		paddleCalculationPositionX.setVxInput(vxActual);
	}
	public double getVyActual()
	{
		return VyActual;
	}

	public void setVyActual(double vyActual)
	{
		paddleCalculationPositionY.setVyInput(vyActual);
	}
	public double getBasePosX()
	{
		return BasePosX;
	}

	public double getBasePosY()
	{
		return BasePosY;
	}
	public double getPaddleWidth()
	{
		return Paddle.getWidth();
	}
	public double getPaddleHeigh()
	{
		return Paddle.getHeight();
	}
	public ArrayList<Shape> getNodes()
	{
		Nodes.add(Paddle);
		Nodes.add(LimitLeft);		
		Nodes.add(LimitRight);
		Nodes.add(LimitUp);
		Nodes.add(LimitDown);
		return Nodes;
	}



}
