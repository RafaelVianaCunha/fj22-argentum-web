package br.com.caelum.argentum.modelo;

import java.util.Calendar;

// usar um builder se o construtor tiver muitos parâmetros!

public class CandleBuilder {
	private double abertura; // preço da primeira negociação do dia;
	private double fechamento; // preço da última negociação do dia;
	private double minimo;// preço da negociação mais barata do dia;
	private double maximo;// preço da negociação mais cara do dia;
	private double volume;// quantidade de dinheiro que passou em todas as
							// negociações nesse dia;
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
