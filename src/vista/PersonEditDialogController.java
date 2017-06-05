package vista;


import Modelo.Persona;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


/**
 * Dialog to edit details of a person.
 *
 */
public class PersonEditDialogController {

    @FXML
    private TextField NombreField;
    @FXML
    private TextField ApellidoField;
    @FXML
    private TextField TelefonoField;

    private Stage ventanaDos;
    private Persona persona;
    private boolean okClicked = false;

    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {
    }

    /**
     * Establece el Stage de esta ventana para poder cerrarla
     *
     * @param ventanaDos
     */
    public void setVentanaDialoge(Stage ventanaDos) {
        this.ventanaDos = ventanaDos;
    }

    /**
     * Sets the person to be edited in the dialog.
     *
     * @param person
     */
    public void setPerson(Persona persona) {
        this.persona = persona;

        NombreField.setText(persona.getNombre());
        ApellidoField.setText(persona.getApellido());
        TelefonoField.setText(persona.getTelefono());
    }

    /**
     * Returns true if the user clicked OK, false otherwise.
     *
     * @return
     */
    public boolean isOkClicked() {
    	return okClicked;
    }

    /**
     * Called when the user clicks ok.
     */
    @FXML
    private void handleOk() {
    	if (isInputValid()) {
            persona.setNombre(NombreField.getText());
            persona.setApellido(ApellidoField.getText());
            persona.setTelefono(TelefonoField.getText());

            okClicked = true;
            ventanaDos.close();
        }
    }

    /**
     * Called when the user clicks cancel.
     */
    @FXML
    private void handleCancel() {
    	ventanaDos.close();
    }

    /**
     * Validates the user input in the text fields.
     *
     * @return true if the input is valid
     */
    private boolean isInputValid() {
        String errorMessage = "";

        if (NombreField.getText() == null || NombreField.getText().length() == 0) {
            errorMessage += "Nombre no válido!\n";
        }
        if (ApellidoField.getText() == null || ApellidoField.getText().length() == 0) {
            errorMessage += "Apellido no válido!\n";
        }
        if (TelefonoField.getText() == null || TelefonoField.getText().length() != 9) {
            errorMessage += "Teléfono no válido!\n";
        }else {
            // try to parse the postal code into an int.
            try {
                Integer.parseInt(TelefonoField.getText());
            } catch (NumberFormatException e) {
                errorMessage += "Teléfono no válido!\n";
            }
        }


        if (errorMessage.length() == 0) {
            return true;
        } else {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Campos incorrectos!!");
            alert.setContentText("Por favor, corrija campos incorrectos");

            alert.showAndWait();
            return false;
        }
    }



}