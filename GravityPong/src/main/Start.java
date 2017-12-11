package main;
import javafx.application.Application;
import javafx.stage.Stage;


//***
//Doda� zabezpieczenie od przenikania si� obiekt�w
//Doda� trajektorie lotu pi�ki
//Doda� podwojne przyciskanie 
//Doda� nad wektorami predkosci odczyt pr�dko��i
//Doda� rotacje pi�ki
//Mozna doda� �adowanie "mocy" podskoku, im d�uzej tym wieksza pr�dko�� poczatkowa
//Uruchomi� timer kiedy zostanie wcisniety przycisk, po "Released" obliczy� now� pr�dko��
//Przeskalowanie parametru t predkosci i przyspiesze� zrobi� oddzieln� klase albo interfejs
//Utworzy� jedn� funkcj� do oblicze� po�ozenia i wywo�ywa� j� z kazdej pi�ki zamiast tworzy� nowe obiekty
//***


public class Start extends Application implements Objects
{
	Screen _Screen = new Screen();
	public static void main(String[] args)
	{
		launch();
	}

	@Override
	public void start(Stage primaryStage) throws Exception
	{
		primaryStage.setScene(primaryScene);
		primaryStage.show();
		
	}
}
