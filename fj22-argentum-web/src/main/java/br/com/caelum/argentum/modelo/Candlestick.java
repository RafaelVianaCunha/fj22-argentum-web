package br.com.caelum.argentum.modelo;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public final class Candlestick {
	private final double abertura; // preço da primeira negociação do dia;
	private final double fechamento; // preço da última negociação do dia;
	private final double minimo;// preço da negociação mais barata do dia;
	private final double maximo;// preço da negociação mais cara do dia;
	private final double volume;// quantidade de dinheiro que passou em todas as
								// negociações nesse dia;
	private final Calendar data;// a qual dia o resumo se refere.

	public Candlestick(double abertura, double fechamento, double minimo, double maximo, double volume, Calendar data) {

		if (maximo < minimo) {
			throw new IllegalArgumentException("Valor maximo não pode ser maior que minimo");
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

	// Informa se o Candlestick é alto ou baixo
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
		String string = ("[Abertura " + abertura + ", Fechamento " + fechamento + ", Mínima " + minimo + ", Máxima "
				+ maximo + ", Volume " + volume + ", Data " + dataFormatada + "]");

		return string;

	}
}
