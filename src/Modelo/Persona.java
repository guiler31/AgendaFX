package Modelo;

public class Persona {
	private String nombre;
	private String apellido;
	private String telefono;
	private String fola;
	private String ssii;
	private String prog;
	private String bbdd;
	private String lmsgi;
	private String ends;
	
	public Persona(String nombre, String apellido, String telefono, String fola, String ssii, String prog, String bbdd,
			String lmsgi, String ends) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.telefono = telefono;
		this.fola = fola;
		this.ssii = ssii;
		this.prog = prog;
		this.bbdd = bbdd;
		this.lmsgi = lmsgi;
		this.ends = ends;
	}

	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getFola() {
		return fola;
	}

	public void setFola(String fola) {
		this.fola = fola;
	}

	public String getSsii() {
		return ssii;
	}

	public void setSsii(String ssii) {
		this.ssii = ssii;
	}

	public String getProg() {
		return prog;
	}

	public void setProg(String prog) {
		this.prog = prog;
	}

	public String getBbdd() {
		return bbdd;
	}

	public void setBbdd(String bbdd) {
		this.bbdd = bbdd;
	}

	public String getLmsgi() {
		return lmsgi;
	}

	public void setLmsgi(String lmsgi) {
		this.lmsgi = lmsgi;
	}

	public String getEnds() {
		return ends;
	}

	public void setEnds(String ends) {
		this.ends = ends;
	}

}
