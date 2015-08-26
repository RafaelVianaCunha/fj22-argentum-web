package br.com.caelum.argentum.modelo;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public final class Candlestick {
	private final double abertura; // pre�o da primeira negocia��o do dia;
	private final double fechamento; // pre�o da �ltima negocia��o do dia;
	private final double minimo;// pre�o da negocia��o mais barata do dia;
	private final double maximo;// pre�o da negocia��o mais cara do dia;
	private final double volume;// quantidade de dinheiro que passou em todas as
								// negocia��es nesse dia;
	private final Calendar data;// a qual dia o resumo se refere.

	public Candlestick(double abertura, double fechamento, double minimo, double maximo, double volume, Calendar data) {

		if (maximo < minimo) {
			throw new IllegalArgumentException("Valor maximo n�o pode ser maior que minimo");
		}
		if (data == null) {
			throw new IllegalArgumentException("data nao pode ser nula");
		}
		this.abertura = abertura;
		this.fechamento = fechamento;
		this.minimo = minimo;
		this.maximo = maximo;
		this.volume = volume;
		this.data = data;
	}

	public double getAbertura() {
		return abertura;
	}

	public double getFechamento() {
		return fechamento;
	}

	public double getMinimo() {
		return minimo;
	}

	public double getMaximo() {
		return maximo;
	}

	public double getVolume() {
		return volume;
	}

	public Calendar getData() {
		return data;
	}

	// Informa se o Candlestick � alto ou baixo
	public boolean isAlta() {
		if (this.abertura <= this.fechamento) {
			return true;
		}
		return false;

	}

	public boolean isBaixa() {		
		if (this.abertura > this.fechamento) {
			return true;
		}
		return false;
	}

	@Override
	public String toString() {
		String dataFormatada = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(data.getTime());
		String string = ("[Abertura " + abertura + ", Fechamento " + fechamento + ", M�nima " + minimo + ", M�xima "
				+ maximo + ", Volume " + volume + ", Data " + dataFormatada + "]");

		return string;

	}
}
