package Taller_1;

import java.io.File;
import java.util.Scanner;






public class Main {
	
	/*cuando creas un scanner dentro de una funcion al salir se rompe */
	public static void menuUsuarios(String usuarioLogueado, Scanner entrada, String[] protagonista, String[] fechaAct, String[] actividades, int contRegistros, int[] cantidadHoras ){
		int opcionSubmenu = 0;
		
		do {
			System.out.println("Bienvenido " + usuarioLogueado + "!");
			System.out.println("Que deseas realizar?\n"
					+ "\n"
					+ "1) Registrar actividad.\n"
					+ "2) Modificar actividad.\n"
					+ "3) Eliminar actividad.\n"
					+ "4) Cambiar contraseña.\n"
					+ "5) Salir.");
			try{
				opcionSubmenu = Integer.valueOf(entrada.nextLine());
			} catch(Exception e) {
				System.out.println("Error: Option no valida"+ e.getLocalizedMessage());
				opcionSubmenu = 0;
			}
			
			switch(opcionSubmenu) {
			case 1:
				System.out.println("Opcion registrar");
			case 2: 
				System.out.println("Cual actividad deseas modificar?");
				
				int[] indicesActUsuario = new int[300];
				int contador = 0;
				
				//PRINTEAMOS LA LINEA  REGISTRADA CON EL USUARIO..
				
				System.out.println("0)Regresar ");
				for (int i = 0; i < contRegistros;i++) {//para encontrar las actividades del protagonista
					if (usuarioLogueado.equals(protagonista[i])){
		
						System.out.println((contador + 1) + ") " + protagonista[i] + ";" + fechaAct[i] + ";" + cantidadHoras[i] + ";" + actividades[i]);
						//AL FINAL PRINTIE ASI 
						indicesActUsuario[contador] = i;//AÑADIMOS EL INDICE A UN ARRAY
						contador++;//CONTADOR DE CUANTOS INDICES LLEVAMOS EN EL ARRAY
					}
				}
				
				try {
					int eleccion = Integer.valueOf(entrada.nextLine());
					
					if (eleccion == 0) {
						System.out.println("Regresando al menu anterior....");
					}else if(eleccion >0 && eleccion <= contador) {
						int idxActElegida = indicesActUsuario[eleccion-1]; //INDICE ACTIVIDAD ELEGIDA
						
						
						// ACA DEBE IR LA FUNCION DE MODIFICAR (YA TENEMOS LA ACTIVIDAD) EN PROCESO...
						
					}else {
						System.out.println("Error.. Eleccion fuera de rango");
					}
					
					
				}catch(Exception e){
					System.out.println("Error al ingresar opcion.."+ e.getLocalizedMessage());
					
				}
				
				
				
				break;
				
				
			case 3:
				System.out.println("Opcion eliminar");// tambien menu para eligir cual
				
				int[] indicesActUsuario2 = new int[300];
				int contadorActs = 0;
				
				System.out.println("0)Regresar ");
				for (int i = 0; i < contRegistros;i++) {//para encontrar las actividades del protagonista
					if (usuarioLogueado.equals(protagonista[i])){
		
						System.out.println((contadorActs + 1) + ") " + protagonista[i] + ";" + fechaAct[i] + ";" + cantidadHoras[i] + ";" + actividades[i]);
						indicesActUsuario2[contadorActs] = i;
						contadorActs++;
					}
				}	
				
				try {
					int eleccion = Integer.valueOf(entrada.nextLine());
					
					if (eleccion == 0) {
						System.out.println("Regresando al menu anterior....");
					}else if(eleccion >0 && eleccion <= contadorActs) {
						int idxActElegida = indicesActUsuario2[eleccion-1]; //INDICE ACTIVIDAD ELEGIDA
						
						// ACA DEBE IR LA FUNCION DE ELIMINAR (YA TENEMOS LA ACTIVIDAD)
						
					}
					
					
				}catch(Exception e){
					System.out.println("Error al ingresar opcion.."+ e.getLocalizedMessage());
					
				}
				
				break;
				
			case 4:
				System.out.println("Cambiar contrasena.");
				break;
				
			case 5:
				System.out.println("Saliendo del Submenu..");
				break;
			
				//FALTO EL DEFAULT?
				
			}
			  
			
		}while(opcionSubmenu != 5);
		
		
	}
	
	public static void registrar(){
		
	}
	
	public static void modificar(int idxActElegida, Scanner entrada, String[] fechaAct, String[] actividades, int[] cantidadHoras/*tarea a modificar, tarea reemplazante*/) {
			String actividadElegida = actividades[idxActElegida];
			System.out.println("\n¿Qué deseas modificar de la actividad " + actividadElegida + "?");
			System.out.println("\n"
					+ "0) Regresar.\n"
					+ "1) Fecha\n"
					+ "2) Duracion\n"
					+ "3) Tipo de actividad\n"); //MENU DEL MENU DEL MENU DEL MENU PARA SABER QUE QUIERE MODIFICAR
			
			try {//SIEMPRE TRY CATCH POR SI NO PONE UN NUMERO..
				int opcionMod = Integer.valueOf(entrada.nextLine());
				
				switch(opcionMod) {
				
				
				}
				
			}catch(Exception e) {
				System.out.println("Error al ingresar opcion.."+ e.getLocalizedMessage());
			}
			
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
		int contRegistros = 0;
		
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
				
				contRegistros++;
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
							String usuarioLogueado = nombres[indiceUsuario];
							menuUsuarios(usuarioLogueado, entrada, protagonista, fechasAct, actividades, contRegistros, cantidadHoras);
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