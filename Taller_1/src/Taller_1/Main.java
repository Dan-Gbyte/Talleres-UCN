package Taller_1;

import java.io.File;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		String[] nombres = new String[50];
		String[] contrasenas = new String[50];
		
		int contPersonas = 0;
		
		try {
			File file = new File("Usuarios.txt");
			Scanner s = new Scanner(file);
			
			while(s.hasNextLine()){
				String linea = s.nextLine();
				
				String[] partes = linea.split(";");
				System.out.println(partes[0]);
				
			}
			
		}catch(Exception e){
			System.out.println("Ocurrió un error al leer el archivo.." + e.getLocalizedMessage());
			
			
		}
		
		
		
		System.out.println("Demian");
		
	}

}
