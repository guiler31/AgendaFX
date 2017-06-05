package application;


import Controlador.Controlador;
import Modelo.DatosPersona;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
	DatosPersona personData;
	Controlador controlador;

    @Override
	public void start(Stage primaryStage) {
    	/* Crea el objeto con el modelo de datos (como si hiciera un acceso a una bbdd o
		 * fichero) este objeto es el que luego se enviará a la Vista
		 */
    	personData = new DatosPersona();
    	controlador = new Controlador();


    	controlador.setpersonData(personData);

    	controlador.AbrirVentanaPrincipal(primaryStage);
    }

    public static void main(String[] args) {

		launch(args);
	}


}