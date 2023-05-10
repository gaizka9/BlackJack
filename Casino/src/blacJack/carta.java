package blacJack;

import java.io.Serializable;

public class carta implements Serializable{
	private String figura;
	private String numero;
	private int valor;
	
	public carta() {
		this.figura = "";
		this.numero = "";
		this.valor = 0;
	}

	public carta(String f, String n, int v) {
		this.figura = f;
		this.numero = n;
		this.valor = v;
	}

	public String getFigura() {
		return figura;
	}

	public void setFigura(String figura) {
		this.figura = figura;
	}
	
	public String getNumero() {
		return numero;
	}

	public void setNumero(String figura) {
		this.numero = figura;
	}
	
	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	@Override
	public String toString() {
		return figura + numero + " valor= " + valor;
	}
}
