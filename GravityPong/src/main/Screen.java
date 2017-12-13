package main;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import javax.swing.plaf.basic.BasicSplitPaneUI.KeyboardUpLeftHandler;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Bounds;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Screen implements Runnable , I_Parameters, I_Objects
{	
	
//	********************************************************************************
//	Mozna dodaæ wiele w¹tków, jedne na obliczenia zdezenia pilek, a drugi do wyœwietlania
//
//	********************************************************************************
	
	//Animacja
	Timeline TimeLineScreen = new Timeline();
	
	//Labelka do wyswietlania wyników
	static Label ActualVelocityLabel = new Label("Velocity");	
	
	//Urzywanie w¹tków
	private Thread LocalThread;
	private String ThreadName="Thread Screen";	
	

	public Screen()
	{
		// Utworzenie w¹tku
		LocalThread = new Thread(this, ThreadName);
		LocalThread.setDaemon(true);
		
		primaryPane.setPrefSize(primaryScene.getWidth(), primaryScene.getHeight());
		
		ActualVelocityLabel.setLayoutX(10);
		ActualVelocityLabel.setLayoutY(30);
		primaryPane.getChildren().add(ActualVelocityLabel);
		primaryPane.getChildren().addAll(primaryPaddle.getNodes());
		primaryPane.getChildren().add(CollisionPoint);

		// Test
		CreateTestsBalls();
		RunEvents();
		this.start();

		paddleZone_Thread.Start();
	}

	private void CreateTestsBalls()
	{
		primaryPane.getChildren().addAll(TestBall_1.getNodes());
		primaryPane.getChildren().addAll(TestBall_2.getNodes());
	}
	
	
//Funkcje dla W¹tków
	
	@Override
	public void run()
	{
		while(true)
		{
			synchronized (this)
			{
				Collisions_Detection.Collision_Detection_3();
			}
			try
			{
				Thread.sleep(ScreenSleepTimeThread);
			} catch (InterruptedException e)
			{
				e.printStackTrace();
			}
			
		}

	}
	public void start()
	{
		LocalThread.start();
	}

	
	// ************************
	// ***    Sterowanie    ***
	// ************************
	
	public void RunEvents()
	{
		primaryScene.setOnKeyPressed(new EventHandler<KeyEvent>()
		{
			@Override
			public void handle(KeyEvent keyEvent)
			{
				switch (keyEvent.getCode())
				{
				case W:
					primaryPaddle.setVyActual(PaddleControllUpVelocity);
					break;
				case S:
					primaryPaddle.setVyActual(PaddleControllDownVelocity);
					break;
				case A:
					primaryPaddle.setVxActual(PaddleControlLeftVelocity);
					break;
				case D:
					primaryPaddle.setVxActual(PaddleControllRightVelocity);
					break;
				}
			}
		});
	}

//	***************
//	Getery i Setery
//	***************
	
	static public void setActualVelocityLabel (double _VelocityX,double _VelocityY)
	{
		String _VelocityText = String.format("X: %2.2f Y: %2.2f", _VelocityX,_VelocityY);
		ActualVelocityLabel.setText(_VelocityText);
	}
	public static void setActualVelocityLabel(String _text)
	{		
		ActualVelocityLabel.setText(_text);
	}



}
