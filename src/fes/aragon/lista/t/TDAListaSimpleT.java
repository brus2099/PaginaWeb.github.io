package fes.aragon.lista.t;

public class TDAListaSimpleT<T> {

	private Nodo<T> cabeza;
	private Nodo<T> cola;
	private int longitud;
	
	public TDAListaSimpleT() {
		cabeza = cola = null;
	}
	
	public void insertarCola(T dato){
		if (cabeza == null){
			cabeza = new Nodo<T>(dato);
			cola = cabeza;
		} else {
			Nodo<T> tmp = new Nodo<T>(dato);
			tmp.setSiguiente(this.cabeza);
			this.cabeza = tmp;
		}
		longitud ++;
	}
	
	public boolean esVacia() {
		return cabeza == null;
	}
	
	public void mostrarDatos() {
		for (Nodo<T> tmp = cabeza; tmp !=null; tmp = tmp.getSiguiente()) {
			System.out.println(tmp.toString());
		}
	}
	
	public int getLongitud(){
		return longitud;
	}
	
	public T obtenerDato(int indice) {
		boolean error = false;
		if ( indice < 0 || indice >=longitud ){
			error=true;
		}
		Nodo<T> tmp = null;
		if(!error) {
			int i = 0;
			for (tmp = cabeza; i !=indice ; tmp = tmp.getSiguiente(), i++);
		}
		if (tmp !=null) {
			return tmp.getDato();
		} else {
			return null;
		}
	}
	
	public void eliminarIndice(int indice) {
		boolean error = false;
		if (indice < 0 || indice >= longitud) {
			error = true;
		}
		if (!error) {
			if (indice == longitud -1) {
				this.eliminarCola();
			} else if (indice == 0) {
				this.eliminarCabeza();
			} else {
				int i =0;
				Nodo<T> tmp = cabeza.getSiguiente();
				Nodo<T> previo = cabeza;
				
				for (;tmp !=null && i != indice-1; previo = tmp, tmp = tmp.getSiguiente(), i++);
				previo.setSiguiente(tmp.getSiguiente());
				tmp.setSiguiente(null);
				longitud--;
			}
		}
	}
	
	public T eliminarCabeza(){
		Nodo<T> dato = null;
		if(this.cabeza==this.cola){
			dato = cabeza;
			this.cabeza=this.cola=null;
		} else {
			dato = cabeza;
			Nodo<T> tmp = cabeza.getSiguiente();
			cabeza = tmp;
		}
		longitud--;
		return dato.getDato();
	}
	
	public T eliminarCola(){
		Nodo<T> dato = null;
		if(this.cabeza==this.cola){
			dato = cabeza;
			this.cabeza=this.cola=null;
		} else {
			Nodo<T> tmp = cabeza.getSiguiente();
			Nodo<T> previo = cabeza;
			for (; tmp.getSiguiente() !=null; previo = tmp, tmp.getSiguiente());
			this.cola = previo;
			dato = tmp;
			this.cola.setSiguiente(null);
		}
		longitud--;
		return dato.getDato();
	}
	
	public boolean eliminarDato(T dato){
		boolean borrar = false;
		if ((this.cabeza==this.cola) && (dato.equals(this.cabeza.getDato()))){
			this.cabeza = this.cola = null;
			longitud--;
			borrar = true;
		} else if ((dato.equals(this.cabeza.getDato()))){
			this.cabeza = cabeza.getSiguiente();
			longitud--;
			borrar = true;
		} else {
			Nodo<T> tmp = cabeza.getSiguiente();
			Nodo<T> previo = cabeza;
			for (; tmp != null && !(tmp.getDato(). equals(dato)); previo = previo.getSiguiente(), tmp = tmp.getSiguiente());
			if ( tmp != null){
				previo.setSiguiente(tmp.getSiguiente());
				if ( tmp == this.cola){
					this.cola = previo;
					cola.setSiguiente(null);
				}
			longitud--;
			borrar = true;
			}
		}
		return borrar;
	}
	
	public int obtenerIndice(T dato){
		int indice = -1;
		if ( this.cabeza != null){
			if ((dato.equals(this.cabeza.getDato()))){
				indice = 0;
			} else {
				Nodo<T> tmp = cabeza.getSiguiente();
				int i = 1;
				for (; tmp != null && !(tmp.getDato().equals(dato)); tmp =tmp.getSiguiente(), i++);
				if( tmp != null ){
					indice = i;
				}
			}
		}
		return indice;
	}
	
}
