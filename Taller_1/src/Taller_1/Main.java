package Taller_1;

import java.io.File;
import java.util.Scanner;

public class Main {
	
	public static void registrar(){
		
	}
	
	public static void modificar(/*tarea a modificar, tarea reemplazante*/) {
		
	}
	
	public static void eliminar(/*tarea a eliminar*/) {
		
	}
	
	public static void cambioPassword(/*password actual, nueva contraseña*/) {
		
	}

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
		
		
		
		Scanner entrada = new Scanner(System.in);
		
		
		
		int menu ;
		
		do {  //do while es clave para que te siga preguntando cuando salgas de hacer algo 
			System.out.println("1) Menu de Usuarios\r\n" + "2) Menu de Analisis\r\n" + "3) Salir");
			try {
				
				menu = Integer.valueOf(entrada.nextLine()); 
			} catch(Exception e) {
				System.out.println("Error: Por favor solo ingresar numeros.");
				menu = 0; 
				
			}	
			
			//NUEVO PRIMER MENU, MEJORADO Y ORDENADITO
			switch (menu) {
			
				case 1:
					// Aqui está tu misma logica
					boolean acceso = false;
					while (acceso == false) {
						int indiceUsuario = 50;
						
						System.out.print("\nUsuario: ");
						String usuario = entrada.nextLine();
						
						for ( int i = 0; i < nombres.length; i++ ) {
							if (usuario.equals(nombres[i]) == true) {
								indiceUsuario = i;
								break;
							}
						}
						
						System.out.print("Contraseña: ");
						String contrasena = entrada.nextLine();
						
						
						if (indiceUsuario <= 49 && contrasena.equals(contrasenas[indiceUsuario]) == true) {
							acceso = true;
							System.out.println("\n¡Acceso correcto");
							
							// AQUI IRÁ EL SUB-MENU DE USUARIOS 
							
							
							
							
						} else {
							System.out.println("\nAcceso denegado, intente nuevamente.");
						}
					}
					break; 
					
				case 2:
					System.out.println("\n--- Bienvenido al Menu de Analisis ---");
					
					// ACA EL OTRO MENU
					
					break; 
					
				case 3:
					System.out.println("\nSaliendo del sistema......");
					break;
					
				default:
					
					System.out.println("\nOpción no válida. Por favor, ingrese 1, 2 o 3.");
					break;
			}
			
		} while (menu != 3);
		
		entrada.close();
		
		System.out.println("\nAlgoritmo finalizado"); //para saber que termino
		
		
	}

}
