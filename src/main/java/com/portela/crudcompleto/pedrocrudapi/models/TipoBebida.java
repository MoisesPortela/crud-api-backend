package com.portela.crudcompleto.pedrocrudapi.models;

public enum TipoBebida {
	VINHO(1),SUCO(2),REFRIGERANTE(3),CERVEJA(4),WHISKY(5), ESTIMULANTE(6);
	private int code;
	
	private TipoBebida(int code) {
		this.code = code;
	}
	public int getCode() {
		return code;
	}
	public static TipoBebida valueOf(int code) {
		for (TipoBebida tipoBebida:TipoBebida.values()) {
			if(tipoBebida.getCode()==code)
				return tipoBebida;
		}
		throw new IllegalArgumentException("Tipo de bebida inválido");
	}

}
