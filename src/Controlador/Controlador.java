package Controlador;

import java.io.IOException;

import Modelo.DatosPersona;
import Modelo.Persona;
import application.Main;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import vista.PersonEditDialogController;
import vista.PersonaController;

public class Controlador {

	private Stage primaryStage;
	private AnchorPane rootLayout;

	private DatosPersona personData;


	public void AbrirVentanaPrincipal(Stage primaryStage){
		try {
			this.primaryStage = primaryStage;

			 // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("../vista/AgendaUI.fxml"));
            rootLayout = (AnchorPane) loader.load();

         // Give the controller access to the main app.
            PersonaController vistacontroller = loader.getController();
            vistacontroller.setControlador(this);
            vistacontroller.setDatos(personData);

            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            scene.getStylesheets().add("application.css");
            primaryStage.setScene(scene);
            primaryStage.setTitle("Agenda");
            primaryStage.show();
            

           } catch(Exception e) {
			e.printStackTrace();
		}

	}


	/**
     * Opens a dialog to edit details for the specified person. If the user
     * clicks OK, the changes are saved into the provided person object and true
     * is returned.
     *
     * @param person the person object to be edited
     * @return true if the user clicked OK, false otherwise.
     */
    public boolean showPersonEditDialog(Persona person) {
        try {
            // Load the fxml file and create a new stage for the popup dialog.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("../vista/PersonEditDialog.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

            // Create the dialog Stage.
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Contacto");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(page);
            scene.getStylesheets().add("application.css");

            dialogStage.setScene(scene);

            // Set the person into the controller.
            PersonEditDialogController controller = loader.getController();
            controller.setVentanaDialoge(dialogStage);
            controller.setPerson(person);

            // Show the dialog and wait until the user closes it
            dialogStage.showAndWait();

            return controller.isOkClicked();

        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    /* este m�todo se llama cuando se ha presionado el bot�n nuevo
     * LLamar� al m�todo que abre la ventana de edici�n con un objeto Persona vac�o
     * Si devuelve OK, la a�ade al modelo*/

    public void NewPerson(){
    	Persona personNew = new Persona(null, null, null,null,null,null,null,null,null);
    	if(showPersonEditDialog(personNew))
    		this.personData.addPerson(personNew);

    }

    /* este m�todo se llama cuando se ha presionado el bot�n editar
     * LLamar� al m�todo que abre la ventana de edici�n con un objeto Persona que es el
     * seleccionado vac�o
     * Si devuelve OK, la a�ade al modelo set(iIndex, person)*/
    public void EditPerson(Persona person, int iIndex){
    	if (showPersonEditDialog(person)){
        	personData.getPersonData().set(iIndex,person);
        }

    }


	public void setpersonData(DatosPersona personData) {
		// TODO Auto-generated method stub
		this.personData = personData;

	}
}
