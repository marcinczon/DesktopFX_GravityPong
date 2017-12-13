package main;

import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;

public class Balls implements I_Parameters, I_Objects
{
	public static void CreateBalls()
	{
		// *********************************************** //
		// Proba Stworzenia obiektu Shape z kazdej pi�ki 
		// Jezeli obiekt powstaie to znaczy ze nastapi�o zdezenie
		// Sprawdzanie kazdej pi�ki z kazda za duzo oblicen potzebnych
		// Warto doda� listenera
		// *********************************************** //
		
		if (Mode_1)
		{
			// Tworzenie pilek

			for (int i = 0; i < NumbersOfBalls; i++)
			{
				Ball _Ball = new Ball((double) Random.nextInt((int) primaryScene.getWidth()),(double) Random.nextInt((int) primaryScene.getHeight()), (double) Random.nextInt(50),Color.AQUAMARINE);
				Balls.add(_Ball);
			}

			// Tworzenie obiektow do wykrywania zdezenia

			for (Ball index : Balls)
			{
				for (Ball index2 : Balls)
				{
					if (!index.equals(index2))
					{
						Shape collisionShape = Shape.intersect(index.get_ball(), index2.get_ball());
						CollisionShapes.add(collisionShape);
					}
				}
			}

			// Dodanie pi�ek na ekran

			for (Ball index : Balls)
			{
				primaryPane.getChildren().addAll(index.getNodes());
			}
		}
	}
}
