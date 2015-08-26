package br.com.caelum.argentum.modelo;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class CandlestickFactory {
	public Candlestick constroiCandleParaData(Calendar data, List<Negociacao> negociacoes) {
		if(negociacoes.size()==0){
			throw new IllegalArgumentException("Lista de negociacoes vazia");
		}
		
		
		double maximo = negociacoes.get(0).getPreco();
		double minimo = negociacoes.get(0).getPreco();
		double volume = 0;

		for (Negociacao negociacao : negociacoes) {
			
			volume += negociacao.getVolume();

			if (negociacao.getPreco() > maximo) {
				maximo = negociacao.getPreco();
			} else if (negociacao.getPreco() < minimo) {
				minimo = negociacao.getPreco();
			}
		}

		double abertura = negociacoes.get(0).getPreco();
		double fechamento = negociacoes.get(negociacoes.size() - 1).getPreco();

		return new Candlestick(abertura, fechamento, minimo, maximo, volume, data);
	}

	public List<Candlestick> constroiCandles(List<Negociacao> todasNegociacoes) {
		  List<Candlestick> candles = new ArrayList<Candlestick>();

		  List<Negociacao> negociacoesDoDia = new ArrayList<Negociacao>();
		  Calendar dataAtual = todasNegociacoes.get(0).getData();

		  for (Negociacao negociacao : todasNegociacoes) {
			  if (negociacao.getData().before(dataAtual)) {
				    throw new IllegalStateException("negociações em ordem errada");
				  }
		    // se não for mesmo dia, fecha candle e reinicia variáveis
		    if (!negociacao.isMesmoDia(dataAtual)) {
		      Candlestick candleDoDia = constroiCandleParaData(dataAtual, 
		                            negociacoesDoDia);
		      candles.add(candleDoDia);
		      negociacoesDoDia = new ArrayList<Negociacao>();
		      dataAtual = negociacao.getData();
		    }
		    negociacoesDoDia.add(negociacao);
		  }
		  // adiciona último candle
		  Candlestick candleDoDia = constroiCandleParaData(dataAtual,
		         negociacoesDoDia);
		  candles.add(candleDoDia);

		  return candles;
		}
}