package Modelo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class DatosPersona {

	/**
     * The data as an observable list of Persons.
     */
    private ObservableList<Persona> personData = FXCollections.observableArrayList();

	public DatosPersona() {

		//Inits personData
		this.personData.add(new Persona("David", "Perez", "600521521"));
	    this.personData.add(new Persona("Pedro", "Camachor", "600521521"));
	}

	/**
     * Returns the data as an observable list of Persons.
     * @return
     */
    public ObservableList<Persona> getPersonData() {
        return personData;
    }

    public void setPersonData(ObservableList<Persona> personData){
    	this.personData = personData;
    }

    public void addPerson(Persona personNew){
    	this.personData.add(personNew);
    }

}
