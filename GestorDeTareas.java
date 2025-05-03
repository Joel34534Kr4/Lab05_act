package actividad6;
import java.util.List;
import java.util.ArrayList;

public class GestorDeTareas<T> {
	private Node<T> head;
	
	public GestorDeTareas() {
		this.head = null;
	}
	
	public void agregarTarea(T tarea) {
		Node<T> nuevomodo = new Node<>(tarea);
		if(head == null) {
			head = nuevomodo;
		}else {
			Node<T> actual = head;
			while (actual.getNext() != null) {
				actual = actual.getNext();
			}
			actual.setNext(nuevomodo);
		}
	}
	
	public boolean eliminartarea(T tarea) {
		if(head == null) {
			return false;
		}
		if(head.getData().equals(tarea)) {
			head = head.getNext();
			return true;
		}

        Node<T> actual = head;
        while (actual.getNext() != null) {
            if (actual.getNext().getData().equals(tarea)) {
                actual.setNext(actual.getNext().getNext());
                return true;
            }
            actual = actual.getNext();
        }
        return false;
	}
	public boolean contenedortareas(T tarea) {
		Node<T> actual = head;
		while(actual != null) { 
			if(actual.getData().equals(tarea)) {
				return true;
			}
			actual = actual.getNext();
		}
		return false;
		
		
		 
	}
	public void imprimirtareas() {
		Node<T> actual = head;
		while(actual != null) {
			System.out.println(actual.getData());
		    actual = actual.getNext();
		}
	}
	public int contadordetareas() {
		int cont = 0;
		Node<T> actual = head;
		while(actual != null) {
			cont++;
			actual = actual.getNext();
				
		}
		return cont;
	}
	  public T obtenerTareaMasPrioritaria() {
	        if (head == null) {
	        	return null;
	        }

	        if (!(head.getData() instanceof Tarea)) {
	            throw new UnsupportedOperationException("Solo se puede obtener tarea prioritaria si los elementos son de tipo Tarea.");
	        }

	        Node<T> actual = head;
	        Tarea tareaMasPrioritaria = (Tarea) actual.getData();
	        actual = actual.getNext();

	        while (actual != null) {
	            Tarea tareaActual = (Tarea) actual.getData();
	            if (tareaActual.getPrioridad() > tareaMasPrioritaria.getPrioridad()) {
	                tareaMasPrioritaria = tareaActual;
	            }
	            actual = actual.getNext();
	        }

	        return (T) tareaMasPrioritaria;
	        
	  }
	  public void invertirTareas() {
	        Node<T> anterior = null;
	        Node<T> actual = head;
	        Node<T> siguiente = null;

	        while (actual != null) {
	            siguiente = actual.getNext();
	            actual.setNext(anterior);
	            anterior = actual;
	            actual = siguiente;
	        }
	        head = anterior;
	    }

	    public List<T> obtenerListaTareas() {
	        List<T> lista = new ArrayList<>();
	        Node<T> actual = head;
	        while (actual != null) {
	            lista.add(actual.getData());
	            actual = actual.getNext();
	        }
	        return lista;
	    }

	  


}
