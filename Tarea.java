package actividad6;

public class Tarea {
	private String titulo; 
	private int prioridad;
	
	public Tarea(String titulo, int prioridad) {
		this.titulo = titulo; 
		this.prioridad = prioridad;
	}
	public String getTitulo() {return titulo;	}
	public int getPrioridad() {return prioridad;}
	@Override
	public String toString() {
		return "Tarea: " + titulo + " (Prioridad:" + prioridad + ")";
	}
	@Override
	public boolean equals(Object obj) {
	    if (this == obj) return true;
	    if (obj == null || getClass() != obj.getClass()) return false;
	    Tarea tarea = (Tarea) obj;
	    return titulo.equalsIgnoreCase(tarea.titulo); // comparación por título
	}

	@Override
	public int hashCode() {
	    return titulo.toLowerCase().hashCode();
	}

}
