package main;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class Paddle implements Parameters
{
	Timeline TimeLineBall = new Timeline();
	private int AnimationSpeed=1;
	
	
	Rectangle Paddle = new Rectangle();
	private  double PosX, PosY;
	private  double VxActual=0, VyActual=0;
	private  double Weight=10;
	private  double BasePosX=Screen.primaryScene.getWidth() / 2;
	private  double BasePosY=Screen.primaryScene.getHeight() -30;
	
	PaddleCalculationPositionX paddleCalculationPositionX;
	PaddleCalculationPositionY paddleCalculationPositionY;
	
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

		Paddle.setLayoutX(PosX);
		Paddle.setLayoutY(PosY);
		Screen.setActualVelocityLabel(String.format("%2.2f : %2.2f",PosX,PosY));
		
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



}
