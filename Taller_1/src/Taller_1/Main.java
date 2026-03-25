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
				
				String[] partes = linea.strip().split(";");
				//System.out.println(partes[0]);
				
				nombres[contPersonas] = partes[0]; 
				contrasenas[contPersonas] = partes[1];
				
				contPersonas += 1;
			}
			s.close();	
		}catch(Exception e){
			System.out.println("Ocurrió un error al leer el archivo.." + e.getLocalizedMessage());
		
		}
		
		//aqui empieza mi trabajo
		
		Scanner entrada = new Scanner(System.in);
		
		System.out.println("1) Menu de Usuarios\r\n" + "2) Menu de Analisis\r\n" + "3) Salir");
		
		Integer menu = Integer.valueOf(entrada.nextLine()); // esto quizá hay que ahcerlo con un try y catch para evitar errores pero eso se ve depues
		
		do {
			
			if (menu == 1) {
				boolean acceso = false;
				while (acceso == false) {
					int indiceUsuario = 50;
					
					System.out.println("\nUsuario: ");
					String usuario = entrada.nextLine();
					
					for ( int i = 0; i < nombres.length; i++ ) {
						if (usuario.equals(nombres[i]) == true) {
							indiceUsuario = i;
							break;
						}
					}
					
					System.out.println("Contraseña: ");
					String contrasena = entrada.nextLine();
					
					if (indiceUsuario <= 49 && contrasena.equals(contrasenas[indiceUsuario]) == true) {
						acceso = true;
						System.out.println("\nAcceso correcto!");
					} else {
						System.out.println("\nacceso denegado");
					}
					
					
				}
				
				menu = 3; //para evitar bucle infinito por el momento
			} 
			
			else if (menu == 2) {
				System.out.println("menu de analisis");
				
				menu = 3; //para evitar bucle infinito por el momento
			}
			
		} while (menu != 3);
		
		entrada.close();
		
		System.out.println("\nAlgoritmo finalizado"); //para saber que termino y todo funciono
	}

}
