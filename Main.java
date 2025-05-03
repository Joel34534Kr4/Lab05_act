package actividad6;

import java.util.*;

public class Main {
	public static void main(String[] args) {
		//Una instancia del gestor de tareas y otra que seria de las tareas completadas
        GestorDeTareas<Tarea> gestor = new GestorDeTareas<>();
        List<Tarea> tareascommpletadas = new ArrayList<>();
		//para poder ingresar datos
        Scanner entrada = new Scanner(System.in);
		
		
		boolean continuar = true;
		
		//menu de opciones
		while(continuar) {
			System.out.println("\n|||----MENÚ---|||");
			String[] opciones = {"Agregar tarea", "Eliminar tarea", "tareas actuales", "Verificar si existe una tarea", "Invertir lista de tareas", "Completar una tarea (transferir a tareas completadas)", "Mostrar tareas completadas", "Salir"};
			for (int i = 0; i < opciones.length; i++) {
			    System.out.println((i + 1) + ". " + opciones[i]);
			}
		    System.out.println("Seleccione una opción: ");
		    int opcion = entrada.nextInt();
		    entrada.nextLine();//Limpieza del buffer
		    
		    switch(opcion) {
		        case 1: //Para poder agregar una nueva tarea mas su prioridad
		        	System.out.println("Título de la tarea: ");
		        	String titulo = entrada.nextLine();
		        	int prioridad;
		        	do {
		        		System.out.print("Inserte prioridad: ");
		        		prioridad = entrada.nextInt();
		        		entrada.nextLine();
		        		} while(prioridad < 0);
		        	gestor.agregarTarea(new Tarea(titulo, prioridad));
		        	System.out.println("Tarea agregada. ");
		        	break;
		        case 2: //para poder eliminar la tarea por su titulo, en caso que no lo encuentre se ejecutará el else
		        	System.out.print("Titulo de la tarea a eliminar");
		        	String eliminar = entrada.nextLine();
		        	if(gestor.eliminartarea(new Tarea(eliminar, 0))) {
		        		System.out.println("Tarea eliminada. ");
		        		}else {
		        			System.err.println("Tarea no encontrada");
		        			}
		        	break;
		        	
		        case 3: //se imprime las tareas actuales llamando un metodo 
		        	System.out.println("Imprimir tareas actuales");
		        	gestor.imprimirtareas();
		        	break;
		        	
		        case 4: //esto verifica si la tarea existe
		        	System.out.print("Título de la tarea a verificar: ");
		        	String buscar = entrada.nextLine();
		        	boolean existe = gestor.contenedortareas(new Tarea(buscar, 0));
		        	if (existe) {
		        		System.out.println("Existe.");
		        		}else {
		        			System.err.println("No existe");
		        			}
		        	break;
		        	
		        case 5: //invertir la lista de tareas
		        	gestor.invertirTareas();
		        	System.out.println("Lista de tareas invertida.");
		        	break;
		        	
		        case 6: //marca tarea como completada
		        	System.out.print("Titulo de la tarea completada: ");
		        	String completada = entrada.nextLine();
		        	Tarea tareacompletada = new Tarea(completada, 0);
		        	if(gestor.eliminartarea(tareacompletada)) {
		        		tareascommpletadas.add(tareacompletada);
		        		System.out.println("Tarea movida a la lista de tareas completadas.");
		        	}else {
		        		System.err.println("Tarea no encontrada. ");
		        	}
		        	break;
		        case 7: //muestra las tareas pendientes y completadas
		        	System.out.println("\nTareas pendientes: ");
		        	gestor.imprimirtareas();
		        	System.out.println("\nTareas completadas: ");
		        	for (Tarea t : tareascommpletadas) {
		        		System.out.println(t);
		        	}
		        	break;
		        case 8: //salida del programa
		        	continuar = false;
		        	System.out.println("Programa finalizado. ");
		        	break;
		        default:
		        	System.out.println("Opción invalida. ");
		        	break;
		        		
		        		
		    }
		    

		}
		entrada.close(); //cierra el scaner
 }
	

}
