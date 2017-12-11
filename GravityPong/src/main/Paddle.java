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
		
		SetLines();


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
		
//		1  |	 2		| 3
//		___|____________|___
//	4   ___|____________|___  5
//		   |            |
//		6  |	7    	| 8
		
		ZoneRectangle_1.setLayoutX(0);
		ZoneRectangle_1.setLayoutY(0);
		ZoneRectangle_1.setWidth(PaddleLimitLeft);
		ZoneRectangle_1.setHeight(PaddleLimitUp);		
		
		ZoneRectangle_2.setLayoutX(PaddleLimitLeft);
		ZoneRectangle_2.setLayoutY(0);
		ZoneRectangle_2.setWidth(getPaddleWidth());
		ZoneRectangle_2.setHeight(PaddleLimitUp);
		
		ZoneRectangle_3.setLayoutX(PaddleLimitRight);
		ZoneRectangle_3.setLayoutY(0);
		ZoneRectangle_3.setWidth(primaryScene.getWidth());
		ZoneRectangle_3.setHeight(PaddleLimitUp);
		
		ZoneRectangle_4.setLayoutX(0);
		ZoneRectangle_4.setLayoutY(PaddleLimitUp);
		ZoneRectangle_4.setWidth(PaddleLimitLeft);
		ZoneRectangle_4.setHeight(getPaddleHeigh());
		
		ZoneRectangle_5.setLayoutX(getPosX()+getPaddleWidth());
		ZoneRectangle_5.setLayoutY(PaddleLimitUp);
		ZoneRectangle_5.setWidth(primaryScene.getWidth());
		ZoneRectangle_5.setHeight(getPaddleHeigh());

		ZoneRectangle_6.setLayoutX(0);
		ZoneRectangle_6.setLayoutY(PaddleLimitDown);
		ZoneRectangle_6.setWidth(PaddleLimitLeft);
		ZoneRectangle_6.setHeight(primaryScene.getHeight());
		
		ZoneRectangle_7.setLayoutX(PaddleLimitLeft);
		ZoneRectangle_7.setLayoutY(PaddleLimitDown);
		ZoneRectangle_7.setWidth(getPaddleWidth());
		ZoneRectangle_7.setHeight(primaryScene.getHeight());
		
		ZoneRectangle_8.setLayoutX(PaddleLimitRight);
		ZoneRectangle_8.setLayoutY(PaddleLimitDown);
		ZoneRectangle_8.setWidth(primaryScene.getWidth());
		ZoneRectangle_8.setHeight(primaryScene.getHeight());		
		
		//ZoneRectangle_1.setFill(Color.TRANSPARENT);
		ZoneRectangle_2.setFill(Color.TRANSPARENT);
		ZoneRectangle_3.setFill(Color.TRANSPARENT);
		ZoneRectangle_4.setFill(Color.TRANSPARENT);
		ZoneRectangle_5.setFill(Color.TRANSPARENT);
		ZoneRectangle_6.setFill(Color.TRANSPARENT);
		ZoneRectangle_7.setFill(Color.TRANSPARENT);
		ZoneRectangle_8.setFill(Color.TRANSPARENT);

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
		
		Nodes.add(ZoneRectangle_1);
		Nodes.add(ZoneRectangle_2);
		Nodes.add(ZoneRectangle_3);
		Nodes.add(ZoneRectangle_4);
		Nodes.add(ZoneRectangle_5);
		Nodes.add(ZoneRectangle_6);
		Nodes.add(ZoneRectangle_7);
		Nodes.add(ZoneRectangle_8);
		return Nodes;
	}



}
