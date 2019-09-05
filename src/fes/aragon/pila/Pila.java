package fes.aragon.pila;

import fes.aragon.lista.t.TDAListaSimpleT;

public class Pila<T> {

		TDAListaSimpleT<T> pila = new TDAListaSimpleT<>();
		
		public Pila() {
		}

		public void insertar(T dato) {
			this.pila.insertarCola(dato);
		}

		public T sacar() {
			return this.pila.eliminarCola();
		}

		public boolean vacia() {
			return this.pila.esVacia();
		}

		public T verArriba() {
			T dato = this.pila.eliminarCola();
			this.insertar(dato);
			return dato;
		}
}
