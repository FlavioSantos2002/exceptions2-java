package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {
	
	private Integer numeroQuarto;
	private Date entrada;
	private Date saida;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Reservation() {
	}
	
	public Reservation(Integer numeroQuarto, Date entrada, Date saida) {
		this.numeroQuarto = numeroQuarto;
		this.entrada = entrada;
		this.saida = saida;
	}

	public Integer getNumeroQuarto() {
		return numeroQuarto;
	}

	public void setNumeroQuarto(Integer numeroQuarto) {
		this.numeroQuarto = numeroQuarto;
	}

	public Date getEntrada() {
		return entrada;
	}

	public Date getSaida() {
		return saida;
	}

	public long duration() {
		long diff = saida.getTime() - entrada.getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}
	
	public void updateDates(Date entrada, Date saida) {
		this.entrada = entrada;
		this.saida = saida;
	}

	@Override
	public String toString() {
		return "quarto "
				+numeroQuarto
				+", entrada"
				+sdf.format(entrada)
				+", saida"
				+sdf.format(saida)
				+", "
				+duration()
				+" noites";
	}

}
