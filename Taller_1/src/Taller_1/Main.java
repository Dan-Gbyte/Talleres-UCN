package Taller_1;

import java.io.File;
import java.util.Scanner;


public class Main {
	
	/*
	Daniel Gabriel Moreno Moreno
	22.152.252-4 
	Ingeniería Civil en computación e informática
	
	
	Demian Antonio Catalán Cruces
	22.241.541-1
	Ingeniería Civil en computación e informática
	*/
	
	public static void menuUsuarios(String usuarioLogueado, Scanner entrada, String[] protagonista, String[] fechaAct, String[] actividades, int contRegistros, int[] cantidadHoras, String[] nombres, String[] contrasenas){
		//tuve que agregar las otras listas para el cambio de contraseña
		int opcionSubmenu = 0;
		
		do {
			System.out.println("\n--- Bienvenido " + usuarioLogueado + "! ---");
			System.out.println("Que deseas realizar?\n\n"
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
				contRegistros = registrar(usuarioLogueado, entrada, fechaAct, actividades, cantidadHoras, protagonista, contRegistros);
				
				break;
				
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
						System.out.println("Regresando al menu anterior...");
					}else if(eleccion >0 && eleccion <= contador) {
						int idxActElegida = indicesActUsuario[eleccion-1]; //INDICE ACTIVIDAD ELEGIDA
						
						modificar(idxActElegida, entrada, fechaAct, actividades, cantidadHoras);
						// ACA DEBE IR LA FUNCION DE MODIFICAR (YA TENEMOS LA ACTIVIDAD) EN PROCESO...
						
					}else {
						System.out.println("Error... Eleccion fuera de rango");
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
						
						eliminar(idxActElegida, fechaAct, actividades, cantidadHoras, protagonista);
						// ACA DEBE IR LA FUNCION DE ELIMINAR (YA TENEMOS LA ACTIVIDAD)
						
					}else {
						System.out.println("Error... Eleccion fuera de rango");
					}
					
					
				}catch(Exception e){
					System.out.println("Error al ingresar opcion..."+ e.getLocalizedMessage());
					
				}
				
				break;
				
			case 4:
				System.out.println("Ingrese su contraseña actual:");
				String contrasena = entrada.nextLine(); 
				
				System.out.println("Ingrese su nueva contraseña:");
				String nuevaContrasena = entrada.nextLine();
				
					cambioPassword(usuarioLogueado, nombres, contrasenas, contrasena, nuevaContrasena) ;
				break;
				
			case 5:
				System.out.println("Saliendo del menú de usuarios...\n");
				break;
			
			default:
				
				System.out.println("\nOpción no válida. Por favor, ingrese otra");
				break;
			}
			  
			
		}while(opcionSubmenu != 5);
		
		
		
	}
	
	public static int registrar(String usuarioLogueado, Scanner entrada, String[] fechaAct, String[] actividades, int[] cantidadHoras, String[] protagonista, int contRegistros){
						// Guardamos al usuario actual en el espacio disponible
				protagonista[contRegistros] = usuarioLogueado;
				
				System.out.print("Ingrese la fecha (DD/MM/AAAA): ");
				fechaAct[contRegistros] = entrada.nextLine();
				
				System.out.print("Ingrese la actividad (ej: estudiar POO): ");
				actividades[contRegistros] = entrada.nextLine();
				
				System.out.print("Ingrese la duración (en horas): ");
				try {
					do {
						cantidadHoras[contRegistros] = Integer.parseInt(entrada.nextLine());
						if (cantidadHoras[contRegistros] <= 0 || cantidadHoras[contRegistros] > 24) {
							System.out.println("Ingrese una cantidad de horas válida:");
						} else {
							System.out.println("\nActividad registrada ");
						}
					} while (cantidadHoras[contRegistros] <= 0 || cantidadHoras[contRegistros] > 24);
					//devolvemos el contador MAS 1 PARA REGISTRAR LA NUEVA ACTIVIDAD
					return contRegistros + 1; 
					
				} catch (Exception e) {
					System.out.println("Error en las horas. Ingrese solo numeros enteros. Registro cancelado." + e.getLocalizedMessage());
					// Si el usuario se equivoca y pone letras el contador tal cual estaba para no romper todo
					return contRegistros; 
				}
	}
	
	public static void guardarEnRegistros(String[] protagonista, String[] fechaAct, String[] actividades, int[] cantidadHoras, int contRegistros){
		try {
			
			java.io.PrintWriter escritor = new java.io.PrintWriter("Registros.txt");//CREANDO PAGINA EN BLANCO
			for (int i = 0; i < contRegistros; i++) {
				
				if (protagonista[i] != null && !protagonista[i].equals("ELIMINADO")) {
					
					// ESCRIBIMOS LA LINEA DE NUEVO
					escritor.println(protagonista[i] + ";" + fechaAct[i] + ";" + cantidadHoras[i] + ";" + actividades[i]);
				}
			}
			
			
			escritor.close();
			
		}catch(Exception e) {
			System.out.println("Error al registrar tu modificacion...");
		}
		
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
				
				case 0:
					System.out.println("Regresando...");
										
					break;
				case 1:
					//Modificar Fecha logica
					System.out.print("Ingrese nueva fecha (formato: DD/MM/AAAA): ");
					fechaAct[idxActElegida] = entrada.nextLine();
					System.out.println("\nFecha modificada..");
					
					break;
				case 2:
					System.out.print("Ingrese nueva duración (EN HORAS): ");
					try {
						do {
							cantidadHoras[idxActElegida] = Integer.parseInt(entrada.nextLine());
							if (cantidadHoras[idxActElegida] <= 0 || cantidadHoras[idxActElegida] > 24) {
								System.out.println("Ingrese una cantidad de horas válida:");
							} else {
								System.out.println("\nDuracion modificada con exito");
							}
						} while (cantidadHoras[idxActElegida] <= 0 || cantidadHoras[idxActElegida] > 24);
					} catch (Exception e) {
						System.out.println("Error: Debes ingresar un numero natural."+ e.getLocalizedMessage());
					}
					break;
				case 3:
					System.out.print("Ingrese nueva actividad: ");
					actividades[idxActElegida] = entrada.nextLine();
					System.out.println("\nActividad modificada..");
					break;
				default:
					System.out.println("\nOpción no válida. Por favor, ingrese 1, 2 o 3.");
					break;
				}
				
			}catch(Exception e) {
				System.out.println("Error al ingresar opcion.."+ e.getLocalizedMessage());
			}
			
	}
	
	public static void eliminar(int idxActElegida, String[] fechaAct, String[] actividades, int[] cantidadHoras, String[] protagonista) {
		System.out.println("Actividad " + actividades[idxActElegida] + " eliminada.."); // mostrar la actividad a eliminar
		
		actividades[idxActElegida] = "ELIMINADA"; 
		fechaAct[idxActElegida] = "ELIMINADA";
		cantidadHoras[idxActElegida] = 0; // cero porque es un array de enteros
		protagonista[idxActElegida] = "ELIMINADO";
		
		
	}
	
	public static void cambioPassword(String Usuario, String[] nombres, String contrasenas[], String password, String newPassword) {
		
		boolean cambio = false;
		
		for (int i = 0; i < 50; i++) { //buscamos el usuario cuya contraseña vamos a cambiar y cambiamos la lista
			
			if (nombres[i] == null) {
				break;
			} else if (nombres[i].equals(Usuario) && contrasenas[i].equals(password)) {
				contrasenas[i] = newPassword;
				cambio = true;
			} 
		
		}
		
		try {
			java.io.PrintWriter escritor = new java.io.PrintWriter("Usuarios.txt");
			
			if (cambio == true) {
				for (int i = 0; i < 50; i++) {
					if (nombres[i] == null) {break;} //terminamos el for si ya no hay usuarios
				
					escritor.println(nombres[i] + ";" + contrasenas[i]);
				}
			}
			escritor.close();
		} catch (Exception e) {
			System.out.println("Hubo un problema al sobreescribir el archivo");
		}
		
		if (cambio == false) {
			System.out.println("Contraseña incorrecta.");
		}
		
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
	
	public static void mayorProcrastinador (String[] usuario,String[] protagonista, String[] actividad, String[] fecha, int[] horas) {
		
		int[] horasProcrastinando = new int[50];
		
		for(int i = 0; i <50 ; i++) { //recorremos usuarios
			if (usuario[i] == null) {
				break;
			}	
			horasProcrastinando[i] = 0; //no se si tengo que inicializar la variable
			for(int j = 0; j < 300; j++) { //recorremos actividades buscando las de ese usuario
				if (usuario[i].equals(protagonista[j]) && !actividad[j].equals("estudiar")) { //verificamos que no este estudiando 
				horasProcrastinando[i] += horas[j];
				}
			} 
					
		}
		int maxHorasProcrastinando = 0;
		int indiceGanador = 0;
		for (int i = 0; i <50; i++) {
			if (usuario[i] == null) { 
                break; // para terminar el for cuando no hayan mas datos
                
            }else if (horasProcrastinando[i] > maxHorasProcrastinando) { // buscamos al que tiene mas horas procrastinadas
                maxHorasProcrastinando = horasProcrastinando[i]; 
                indiceGanador = i; 
			}
		}
		System.out.println("el usuario que más procrastinó fué " + usuario[indiceGanador] + " con " + maxHorasProcrastinando + " horas procrastinando.");
	}
	
	public static void mostrarActividades(String[] protagonista, String[] actividad, String[] fecha, int[] horas) {
		
		//esta es tan simple que no creo que necesite explicacion
		for (int i = 0; i < 300; i++) {
			if (protagonista[i] != null) {
				System.out.println(fecha[i] + ", " + protagonista[i] + " realizó la actividad " + actividad[i] + " durante " + horas[i] + " horas.");
			}
		}
		System.out.println("\n");
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
				
			System.out.println("--- Bienvenido al menú principal ---\n\n"
					+ "1) Menu de Usuarios\n"
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
							
							
							menuUsuarios(usuarioLogueado, entrada, protagonista, fechasAct, actividades, contRegistros, cantidadHoras, nombres, contrasenas);
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
						mayorProcrastinador(nombres, protagonista, actividades, fechasAct, cantidadHoras);
						break;
						
					case 4:
						mostrarActividades(protagonista, actividades, fechasAct, cantidadHoras);
						System.out.println("Volviendo al menú principal...\n");
						break;
						
					}
					
					
					// ACA EL OTRO MENU
					
					break; 
					
				case 3:
					System.out.println("\nSaliendo del sistema......");
					guardarEnRegistros(protagonista, fechasAct, actividades, cantidadHoras, contRegistros);
					
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