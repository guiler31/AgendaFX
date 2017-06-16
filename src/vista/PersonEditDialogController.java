package vista;


import java.text.DecimalFormat;

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
    @FXML
    private TextField FOLA;
    @FXML
    private TextField SSII;
    @FXML
    private TextField PROG;
    @FXML
    private TextField LMSGI;
    @FXML
    private TextField ENDS;
    @FXML
    private TextField BBDD;
    
    
    

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
    
    public String calcMedia(){
    	String media ="";
    	Double fol = Double.parseDouble(FOLA.getText());
    	Double si =Double.parseDouble(SSII.getText());
    	Double pro =Double.parseDouble(PROG.getText());
    	Double end =Double.parseDouble(ENDS.getText());
    	Double bd =Double.parseDouble(BBDD.getText());
    	Double lms =Double.parseDouble(LMSGI.getText());
    	Double medi= (fol+si+pro+end+bd+lms)/6;
    	
    	DecimalFormat oneDigit = new DecimalFormat("#.0");
    	String mediUno = oneDigit.format(medi);
    	
    	media = String.valueOf(mediUno);
		return media;
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
        SSII.setText(persona.getSsii());
        FOLA.setText(persona.getFola());
        PROG.setText(persona.getProg());
        ENDS.setText(persona.getEnds());
        BBDD.setText(persona.getBbdd());
        LMSGI.setText(persona.getLmsgi());

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
            persona.setTelefono(calcMedia());
            persona.setFola(FOLA.getText());
            persona.setSsii(SSII.getText());
            persona.setBbdd(BBDD.getText());
            persona.setEnds(ENDS.getText());
            persona.setLmsgi(LMSGI.getText());
            persona.setProg(PROG.getText());
            
            
            
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
            errorMessage += "Nombre no v�lido!\n";
        }
        if (ApellidoField.getText() == null || ApellidoField.getText().length() == 0) {
            errorMessage += "Apellido no v�lido!\n";
        }
        if (FOLA.getText() == null || FOLA.getText().length() == 0 || Double.parseDouble(FOLA.getText())>10.0) {
            errorMessage += "Nota no valida\n";
        }
        if (SSII.getText() == null || SSII.getText().length() == 0 || Double.parseDouble(SSII.getText())>10.0) {
            errorMessage += "Nota no valida\n";
        }
        if (PROG.getText() == null || PROG.getText().length() == 0 || Double.parseDouble(PROG.getText())>10.0) {
            errorMessage += "Nota no valida\n";
        }
        if (BBDD.getText() == null || BBDD.getText().length() == 0 || Double.parseDouble(BBDD.getText())>10.0) {
            errorMessage += "Nota no valida\n";
        }
        if (LMSGI.getText() == null || LMSGI.getText().length() == 0 || Double.parseDouble(LMSGI.getText())>10.0) {
            errorMessage += "Nota no valida\n";
        }
        if (ENDS.getText() == null || ENDS.getText().length() == 0 || Double.parseDouble(ENDS.getText())>10.0) {
            errorMessage += "Nota no valida\n";
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