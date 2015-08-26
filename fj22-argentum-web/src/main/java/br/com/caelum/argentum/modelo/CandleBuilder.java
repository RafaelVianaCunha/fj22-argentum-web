package br.com.caelum.argentum.modelo;

import java.util.Calendar;

// usar um builder se o construtor tiver muitos par�metros!

public class CandleBuilder {
	private double abertura; // pre�o da primeira negocia��o do dia;
	private double fechamento; // pre�o da �ltima negocia��o do dia;
	private double minimo;// pre�o da negocia��o mais barata do dia;
	private double maximo;// pre�o da negocia��o mais cara do dia;
	private double volume;// quantidade de dinheiro que passou em todas as
							// negocia��es nesse dia;
	private Calendar data;// a qual dia o resumo se refere.

	public CandleBuilder comAbertura(double abertura) {
		this.abertura = abertura;
		return this;
	}

	public CandleBuilder comFechamento(double fechamento) {
		this.fechamento = fechamento;
		return this;
	}

	public CandleBuilder comMinimo(double minimo) {
		this.minimo = minimo;
		return this;
	}

	public CandleBuilder comMaximo(double maximo) {
		this.maximo = maximo;
		return this;
	}

	public CandleBuilder comVolume(double volume) {
		this.volume = volume;
		return this;
	}

	public CandleBuilder comData(Calendar data) {
		this.data = data;
		return this;
	}

	public Candlestick geraCandle() {
		return new Candlestick(abertura, fechamento, minimo, maximo, volume, data);
	}

}
