package vista;

import Controlador.Controlador;
import Modelo.DatosPersona;
import Modelo.Persona;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.cell.PropertyValueFactory;


public class PersonaController {

	@FXML
	private TableView<Persona> Tabla;

	@FXML
	private TableColumn<Persona,String> ColName;

	@FXML
	private TableColumn<Persona,String> ColApellido;

	@FXML
	private TableColumn<Persona,String> ColTelefono;

	@FXML
	private Button Nuevo;

	@FXML
	private Button Editar;

	@FXML
	private Button Borrar;



	// Reference to the Controlador.
    private Controlador controlador;

    // Reference to the data
    private DatosPersona personData;

	/**
     * Called when the user clicks on the delete button.
     */
    @FXML
    private void handleDeletePerson() {
        int selectedIndex = Tabla.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
        	this.personData.getPersonData().remove(selectedIndex);
        	Tabla.setItems( this.personData.getPersonData());

        } else {
            // Nothing selected.
        	Alert alert = new Alert(AlertType.WARNING);
        	ShowAlertNoSelectionPerson(alert);
        }
    }

    /**
     * Called when the user clicks the new button. Opens a dialog to edit
     * details for a new person.
     */
    @FXML
    private void handleNewPerson() {
        controlador.NewPerson();
        Tabla.setItems(this.personData.getPersonData());
    }

    /**
     * Called when the user clicks the edit button. Opens a dialog to edit
     * details for the selected person.
     */
    @FXML
    private void handleEditPerson() {
        Persona selectedPerson = Tabla.getSelectionModel().getSelectedItem();
        if (selectedPerson != null) {
        	int iIndex = Tabla.getSelectionModel().getSelectedIndex();
            controlador.EditPerson(selectedPerson, iIndex);
            Tabla.setItems(this.personData.getPersonData());
        }
        else
        {
        	// Nothing selected.
        	Alert alert = new Alert(AlertType.ERROR);
        	ShowAlertNoSelectionPerson(alert);
        }
    }

    private void ShowAlertNoSelectionPerson(Alert alert){

        alert.setTitle("No Seleccionado");
        alert.setHeaderText("Persona no seleccionada");
        alert.setContentText("Por favor!!! Seleccione una persona de la tabla");

        alert.showAndWait();
    }

	public void setControlador(Controlador controlador) {
		// TODO Auto-generated method stub
		this.controlador = controlador;
	}

	public void setDatos(DatosPersona personData2) {
		this.personData = personData2;
		// TODO Auto-generated method stub
		Tabla.setItems(this.personData.getPersonData());
        ColName.setCellValueFactory(new PropertyValueFactory<Persona,String>("nombre"));
		ColApellido.setCellValueFactory(new PropertyValueFactory<Persona,String>("apellido"));
		ColTelefono.setCellValueFactory(new PropertyValueFactory<Persona,String>("telefono"));


	}
}
