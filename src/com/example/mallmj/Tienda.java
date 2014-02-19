package com.example.mallmj;

public class Tienda {

	public String Nombre, Direccion, Telefono, Horario, Website, Email;
	
	public Tienda (String nombre, 
				   String direccion,
				   String telefono, 
				   String horario,
				   String website,
				   String email){
		
		this.Nombre=nombre;
		this.Direccion=direccion;
		this.Telefono=telefono;
		this.Horario=horario;
		this.Website=website;
		this.Email=email;
		
	}
	public String GetNombre(){
		return this.Nombre;
	}
	
}
