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
	
	public static void actividadMasRealizada(String[] nombres, String[] protagonista,String[] actividades, int[] horas) {
		//sin finalizar
		//tres for son demasiados?
		
		for (int i = 0; i < 50; i++) { //recorre cada usuario
			if (nombres[i] == null) {
				break; //terminamos si ya no hay usuarios
			}
			
			String[] actividadesUnicas = new String[300];
			int[] HorasPorActividad = new int[300];
			
			for (int j = 0; j< 300; j++) { //recorre los datos de cada actividad, usando de referencia al que la realiza
				if ( protagonista[j] == null) {
					break; //terminamos si ya no hay actividades
					
				} else if (nombres[i].equals(protagonista[j])) {
					
					for (int h = 0; h<300; h++) { //recorre las actividades unicas hasta encontrar una igual
						
						if (actividadesUnicas[h] != null && actividadesUnicas[h].equals(actividades[j])) { //si la actividad existe, le agregamos las horas de actividad
							 HorasPorActividad[h] = HorasPorActividad[h] + horas[j];
							 break;
									 
						} else if (actividadesUnicas[h] == null) { //si no existe, la agregamos a la lista y cortamos el for para continuar
							actividadesUnicas[h] = actividades[j];
							HorasPorActividad[h] = HorasPorActividad[h] + horas[j];
							break;
						}
						
					}
				}
			}
		}
		
	}
	
	public static void main(String[] args) {
		
		//quiza la lectura de este archivo deba ser en caso de abrir el menu 1
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
		
		 // rehice esto como 3 veces tratando de dejarlo listo para en los metodos hacer poco, pero me rindo, me limite a dejar cada dato en una lista
		
		String[] protagonista = new String[300]; //protagonista de la actividad, por supuesto
		String[] actividades = new String[300];
		String[] fechasAct = new String[300];
		int[] cantidadHoras = new int[300]; //quiza deba tomarlo como string o hacer control de errores pero no es un input asi que no se si va
		
		
		try {
			File file = new File("Registros.txt");
			Scanner s = new Scanner(file);
			int i = 0;
			
			while(s.hasNextLine()){
				String linea = s.nextLine();
				String[] partes = linea.strip().split(";");
				
				protagonista[i] = partes[0];
				fechasAct[i] = partes[1];
				actividades[i] = partes[3];
				cantidadHoras[i] = Integer.parseInt(partes[2]);
				i++;
			}
			s.close();
		}  catch(Exception e){
				System.out.println("Ocurrió un error al leer el archivo.." + e.getLocalizedMessage());
		}
		
		
		
		Scanner entrada = new Scanner(System.in);
		
		int menu ;
		
		
		do {  //do while es clave para que te siga preguntando cuando salgas de hacer algo 
				//no lo puse porque no sabia si el menu debia continuar, aunque pensandolo el salir como opcion indica que si
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
							System.out.println("\n¡Acceso correcto!");
							
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
