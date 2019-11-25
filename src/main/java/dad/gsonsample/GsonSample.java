package dad.gsonsample;

import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GsonSample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	
	
		String nombre=nuevaPalabra("nombre");
		String apellido1=nuevaPalabra("primer apellido");
		String apellido2=nuevaPalabra("segundo apellido");
		int edad=nuevaEdad("edad");
				
	
			Persona p =new Persona();
			p.setNombre(nombre);
			p.setApellidos(apellido1.concat(" ").concat(apellido2));
			p.setEdad(edad);
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			String json = gson.toJson(p);
			System.out.println(json);

	}
	  
	
	private static int nuevaEdad(String campo) {
		System.out.println("Introduce "+campo+":");
		Scanner sc=new Scanner(System.in);
		int num=-1;
		try {
		 num=sc.nextInt();
		 }
		 catch (java.util.InputMismatchException e) {
			 System.out.println("El campo esta vacio o tiene un caracter invalido");
			num=nuevaEdad("edad");
			} 
		sc.close();
		return num;
	}
	public static boolean checkNumber(int num){
		boolean check=false;
		if (num>0) check=true;
		return check;}

	public static boolean checkLetter(String palabra) {
		boolean check=false;
		if (palabra.length()==0) check=false; else
		if (palabra.matches("[A-z]*"))
			check=true;
		System.out.println(check);
		return  check;
	}
	
	public static String nuevaPalabra(String campo) {
		System.out.println("Introduce "+campo+":");
		Scanner sc=new Scanner(System.in);
		String palabra=sc.nextLine();
		while (checkLetter(palabra)==false) {
			System.out.println("El campo esta vacio o tiene un caracter invalido");
			System.out.println("Introduce "+campo+":");
			palabra=sc.nextLine();

		}
		return palabra;
	};
}
