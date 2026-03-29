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
	
	private static void actividadMasRealizada (String[] actividades, int[] horas) {
		
		String[] actividadesUnicas = new String[300];
		int[] horasPorActividad = new int[300];
		
		for (int i = 0; i < 300; i++) { //recorremos las actividades
			if (actividades[i] == null) {
				break; //terminamos el codigo si ya no hay mas actividades
				
			}
			
			for (int j = 0; j < 300; j++) { //recorremos las actividades unicas
				if (actividadesUnicas[j] != null && actividadesUnicas[j].equals(actividades[i])) { //si la actividad existe, le agregamos las horas de actividad
					 horasPorActividad[j] = horasPorActividad[j] + horas[i];
					 break;
							 
				} else if (actividadesUnicas[j] == null) { //si no existe, la agregamos a la lista y cortamos el for para continuar
					actividadesUnicas[j] = actividades[i];
					horasPorActividad[j] = horasPorActividad[j] + horas[i];
					break;
				}
				
			}
		}
		
		String actividadMasFrecuente = "Ninguna";
		int maxHoras = 0;
		
		for (int k = 0; k < 300; k++) { //recorremos la informacion recolectada
			if (horasPorActividad == null) { //terminamos si no hay mas datos
				break;
			}else if (horasPorActividad[k] > maxHoras) { //buscamos la mayor cantidad de horas
				maxHoras = horasPorActividad[k];
				actividadMasFrecuente = actividadesUnicas[k];//guardamos la actividad
			}
		}
		//printeamos
		System.out.println("\nLa actividad más realizada fue:\n\n*" + actividadMasFrecuente + " -> con " + maxHoras + " horas registradas\n");
		
	}
	
	public static void actividadMasRealizadaUsuario(String[] nombres, String[] protagonista,String[] actividades, int[] horas) {
		//sin finalizar
		//tres for son demasiados? se me habia ocurrido una forma mas eficiente en la tarde pero se me olvido ya
		
		System.out.println("Actividades mas realizadas por cada usuario:\n");
		for (int i = 0; i < 50; i++) { //recorre cada usuario
			if (nombres[i] == null) {
				break; //terminamos si ya no hay usuarios
			}
			
			String[] actividadesUnicas = new String[300];
			int[] horasPorActividad = new int[300];
			
			for (int j = 0; j< 300; j++) { //recorre los datos de cada actividad
				if ( protagonista[j] == null) {
					break; //terminamos si ya no hay actividades
					
				} else if (nombres[i].equals(protagonista[j])) {
					
					for (int h = 0; h<300; h++) { //recorre las actividades unicas
						
						if (actividadesUnicas[h] != null && actividadesUnicas[h].equals(actividades[j])) { //si la actividad existe, le agregamos las horas de actividad
							 horasPorActividad[h] = horasPorActividad[h] + horas[j];
							 break;
									 
						} else if (actividadesUnicas[h] == null) { //si no existe, la agregamos a la lista y cortamos el for para continuar
							actividadesUnicas[h] = actividades[j];
							horasPorActividad[h] = horasPorActividad[h] + horas[j];
							break;
						}
						
					}
				}
			}
			
			int maxHoras = 0;
			String actividadMasFrecuente = "Ninguna";
			
			for (int k = 0; k < 300; k++) { //recorremos los datos recolectados
	            if (actividadesUnicas[k] == null) { 
	                break; // para terminar el for cuando no hayan mas datos
	            }
	            
	            if (horasPorActividad[k] > maxHoras) { // Actualizamos el récord de horas
	                maxHoras = horasPorActividad[k]; 
	                actividadMasFrecuente = actividadesUnicas[k]; 
	            }
	        }
	        
	        // Imprimimos el resultado para este usuario
	        if (maxHoras > 0) {
	            System.out.println("*" + nombres[i] + " -> " + actividadMasFrecuente + " -> con " + maxHoras + " horas registradas");
	        }
		}
		
		System.out.println(); //por razones meramente esteticas
		
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
		
		
		do {
				
			System.out.println("1) Menu de Usuarios\n"
					+ "2) Menu de Analisis"
					+ "\n3) Salir");
			
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
					
					System.out.println("\nQue deseas realizar?\n"
							+ "1) Actividad más realizada\r\n"
							+ "2) Actividad más realizada por cada usuario\r\n"
							+ "3) Usuario con mayor procastinacion\r\n"
							+ "4) Ver todas las actividades\r\n"
							+ "5) Salir");
					
					short submenu;
					try {
						submenu = Short.valueOf(entrada.nextLine()); 
					} catch(Exception e) {
						System.out.println("Error: Por favor solo ingresar numeros.");
						submenu = 0; 
						
					}
					switch (submenu) {
					
					case 1: 
						actividadMasRealizada (actividades , cantidadHoras);
						break;
						
					case 2:
						actividadMasRealizadaUsuario(nombres, protagonista, actividades, cantidadHoras);
						break;
						
					case 3:
						//metodo de procrastinacion
						
					case 4:
						//metodo para ver todas las actividades
						
					}
					
					
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