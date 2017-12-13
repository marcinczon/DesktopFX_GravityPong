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

public class Paddle implements I_Parameters, I_Objects
{
//		1  |	 2		| 3
//	    ___|____________|___
//  4   ___|____________|___  5
//	       |            |
//	    6  |	7    	| 8
	
	
	Timeline TimeLineBall = new Timeline();
	private int AnimationSpeed=1;
	
	private ArrayList<Shape> Nodes = new ArrayList<Shape>();
	
	Rectangle Paddle = new Rectangle();
	
	private  double PosX, PosY;
	private  double VxActual=0, VyActual=0;
	private  double Weight=4;
	private  double BasePosX=Screen.primaryScene.getWidth() / 2;
	private  double BasePosY=Screen.primaryScene.getHeight() -30;
	private  double PaddleCenterX=Paddle.getLayoutX()+PaddleWidth/2;
	private  double PaddleCenterY=Paddle.getLayoutY()+PaddleHeight/2;
	
	Paddle_CalculationPositionX paddleCalculationPositionX;
	Paddle_CalculationPositionY paddleCalculationPositionY;
	
	//Obiekty dla debugingu
	double d_PaddleLimitLeft = Paddle.getLayoutX();
	double d_PaddleLimitRight = Paddle.getLayoutX()+Paddle.getWidth();
	
	double d_PaddleLimitUp = Paddle.getLayoutY();
	double d_PaddleLimitDown = Paddle.getLayoutY()+Paddle.getHeight();
	
	//Wektory prêdkoœci
	private Line VectorX = new Line();
	private Line VectorY = new Line();

	
	public Paddle()
	{
		Paddle.setWidth(PaddleWidth);
		Paddle.setHeight(PaddleHeight);
		System.out.println(BasePosX + " " + BasePosY);
		Paddle.setLayoutX(BasePosX);
		Paddle.setLayoutY(BasePosY);
		Paddle.setFill(Color.CHARTREUSE);
		PosX=Paddle.getLayoutX();
		PosY=Paddle.getLayoutY();				

		
		paddleCalculationPositionX = new Paddle_CalculationPositionX(this, "Paddle Axis X");
		paddleCalculationPositionY = new Paddle_CalculationPositionY(this, "Paddle Axis Y");
		
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
		
		PaddleCenterX=Paddle.getLayoutX()+PaddleWidth/2;
		PaddleCenterY=Paddle.getLayoutY()+PaddleHeight/2;
		
		SetLines();
		if (ShowVectors)
		{
			SetVectors();
		}


		Paddle.setLayoutX(PosX);
		Paddle.setLayoutY(PosY);
		Screen.setActualVelocityLabel(String.format("%2.2f : %2.2f",VxActual,VyActual));
		
	}
	
	private void SetLines()
	{
		//Limity do debuggingu
		
		d_PaddleLimitLeft = Paddle.getLayoutX();
		d_PaddleLimitRight = Paddle.getLayoutX()+Paddle.getWidth();		
		d_PaddleLimitUp = Paddle.getLayoutY();
		d_PaddleLimitDown = Paddle.getLayoutY()+Paddle.getHeight();
		
		Line_LimitLeft.setStartX(d_PaddleLimitLeft);
		Line_LimitLeft.setEndX(d_PaddleLimitLeft);
		Line_LimitLeft.setStartY(0);
		Line_LimitLeft.setEndY(primaryScene.getHeight());
		
		Line_LimitRight.setStartX(d_PaddleLimitRight);
		Line_LimitRight.setEndX(d_PaddleLimitRight);
		Line_LimitRight.setStartY(0);
		Line_LimitRight.setEndY(primaryScene.getHeight());
		
		Line_LimitUp.setStartX(0);
		Line_LimitUp.setEndX(primaryScene.getWidth());
		Line_LimitUp.setStartY(d_PaddleLimitUp);
		Line_LimitUp.setEndY(d_PaddleLimitUp);
		
		Line_LimitDown.setStartX(0);
		Line_LimitDown.setEndX(primaryScene.getWidth());
		Line_LimitDown.setStartY(d_PaddleLimitDown);
		Line_LimitDown.setEndY(d_PaddleLimitDown);
		
//		1  |	 2		| 3
//		___|____________|___
//	4   ___|____________|___  5
//		   |            |
//		6  |	7    	| 8
		
		Rectangle_Zone_1.setLayoutX(0);
		Rectangle_Zone_1.setLayoutY(0);
		Rectangle_Zone_1.setWidth(d_PaddleLimitLeft);
		Rectangle_Zone_1.setHeight(d_PaddleLimitUp);		
		
		Rectangle_Zone_2.setLayoutX(d_PaddleLimitLeft);
		Rectangle_Zone_2.setLayoutY(0);
		Rectangle_Zone_2.setWidth(getPaddleWidth());
		Rectangle_Zone_2.setHeight(d_PaddleLimitUp);
		
		Rectangle_Zone_3.setLayoutX(d_PaddleLimitRight);
		Rectangle_Zone_3.setLayoutY(0);
		Rectangle_Zone_3.setWidth(primaryScene.getWidth());
		Rectangle_Zone_3.setHeight(d_PaddleLimitUp);
		
		Rectangle_Zone_4.setLayoutX(0);
		Rectangle_Zone_4.setLayoutY(d_PaddleLimitUp);
		Rectangle_Zone_4.setWidth(d_PaddleLimitLeft);
		Rectangle_Zone_4.setHeight(getPaddleHeigh());
		
		Rectangle_Zone_5.setLayoutX(getPosX()+getPaddleWidth());
		Rectangle_Zone_5.setLayoutY(d_PaddleLimitUp);
		Rectangle_Zone_5.setWidth(primaryScene.getWidth());
		Rectangle_Zone_5.setHeight(getPaddleHeigh());

		Rectangle_Zone_6.setLayoutX(0);
		Rectangle_Zone_6.setLayoutY(d_PaddleLimitDown);
		Rectangle_Zone_6.setWidth(d_PaddleLimitLeft);
		Rectangle_Zone_6.setHeight(primaryScene.getHeight());
		
		Rectangle_Zone_7.setLayoutX(d_PaddleLimitLeft);
		Rectangle_Zone_7.setLayoutY(d_PaddleLimitDown);
		Rectangle_Zone_7.setWidth(getPaddleWidth());
		Rectangle_Zone_7.setHeight(primaryScene.getHeight());
		
		Rectangle_Zone_8.setLayoutX(d_PaddleLimitRight);
		Rectangle_Zone_8.setLayoutY(d_PaddleLimitDown);
		Rectangle_Zone_8.setWidth(primaryScene.getWidth());
		Rectangle_Zone_8.setHeight(primaryScene.getHeight());		

	}
	private void SetVectors()
	{
		VectorX.setFill(Color.RED);
		VectorX.setStartX(PaddleCenterX);
		VectorX.setStartY(PaddleCenterY);
		VectorX.setEndX(PaddleCenterX+VxActual);
		VectorX.setEndY(PaddleCenterY);
		
		VectorY.setFill(Color.BLUE);
		VectorY.setStartX(PaddleCenterX);
		VectorY.setStartY(PaddleCenterY);
		VectorY.setEndX(PaddleCenterX);
		VectorY.setEndY(PaddleCenterY+VyActual);
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
		Nodes.add(Line_LimitLeft);		
		Nodes.add(Line_LimitRight);
		Nodes.add(Line_LimitUp);
		Nodes.add(Line_LimitDown);
		Nodes.add(VectorX);
		Nodes.add(VectorY);
		
		Nodes.add(Rectangle_Zone_1);
		Nodes.add(Rectangle_Zone_2);
		Nodes.add(Rectangle_Zone_3);
		Nodes.add(Rectangle_Zone_4);
		Nodes.add(Rectangle_Zone_5);
		Nodes.add(Rectangle_Zone_6);
		Nodes.add(Rectangle_Zone_7);
		Nodes.add(Rectangle_Zone_8);
		return Nodes;
	}



}
