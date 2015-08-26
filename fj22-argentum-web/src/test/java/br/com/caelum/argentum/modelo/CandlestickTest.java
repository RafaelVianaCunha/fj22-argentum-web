package br.com.caelum.argentum.modelo;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class CandlestickTest {

	@Test(expected = IllegalArgumentException.class)
	public void precoMaximoNaoPodeSerMenorQueMinimo() {

		new Candlestick(10, 20, 20, 10, 10000, Calendar.getInstance());
	}
	
	@Test
	public void quandoAberturaIgualFechamentoEhAlta() {

		Candlestick candlestick = new Candlestick(10, 10, 10, 10, 10000, Calendar.getInstance());
		Assert.assertTrue(candlestick.isAlta());
		Assert.assertTrue(!candlestick.isBaixa());
		
	}
	
	@Test
	public void paraNegociacoesDeTresDiasDistintosGeraTresCandles() {
	  Calendar hoje = Calendar.getInstance();
	  
	  Negociacao negociacao1 = new Negociacao(40.5, 100, hoje);
	  Negociacao negociacao2 = new Negociacao(45.0, 100, hoje);
	  Negociacao negociacao3 = new Negociacao(39.8, 100, hoje);
	  Negociacao negociacao4 = new Negociacao(42.3, 100, hoje);
	  
	  Calendar amanha = (Calendar) hoje.clone();
	  amanha.add(Calendar.DAY_OF_MONTH, 1);
	  
	  Negociacao negociacao5 = new Negociacao(48.8, 100, amanha);
	  Negociacao negociacao6 = new Negociacao(49.3, 100, amanha);
	  
	  Calendar depois = (Calendar) amanha.clone();
	  depois.add(Calendar.DAY_OF_MONTH, 1);
	  
	  Negociacao negociacao7 = new Negociacao(51.8, 100, depois);
	  Negociacao negociacao8 = new Negociacao(52.3, 100, depois);
	  
	  List<Negociacao> negociacoes = Arrays.asList(negociacao1, negociacao2, 
	    negociacao3, negociacao4, negociacao5, negociacao6, negociacao7, 
	    negociacao8);
	  
	  CandlestickFactory fabrica = new CandlestickFactory();
	  
	  List<Candlestick> candles = fabrica.constroiCandles(negociacoes);
	  
	  Assert.assertEquals(3, candles.size());
	  Assert.assertEquals(40.5, candles.get(0).getAbertura(), 0.00001);
	  Assert.assertEquals(42.3, candles.get(0).getFechamento(), 0.00001);
	  Assert.assertEquals(48.8, candles.get(1).getAbertura(), 0.00001);
	  Assert.assertEquals(49.3, candles.get(1).getFechamento(), 0.00001);
	  Assert.assertEquals(51.8, candles.get(2).getAbertura(), 0.00001);
	  Assert.assertEquals(52.3, candles.get(2).getFechamento(), 0.00001);
	}
	
	@Test(expected = IllegalStateException.class)
	public void naoPermiteConstruirCandlesComNegociacoesForaDeOrdem() {
	  Calendar hoje = Calendar.getInstance();
	  
	  Negociacao negociacao1 = new Negociacao(40.5, 100, hoje);
	  Negociacao negociacao2 = new Negociacao(45.0, 100, hoje);
	  Negociacao negociacao3 = new Negociacao(39.8, 100, hoje);
	  Negociacao negociacao4 = new Negociacao(42.3, 100, hoje);
	  
	  Calendar amanha = (Calendar) hoje.clone();
	  amanha.add(Calendar.DAY_OF_MONTH, 1);
	  
	  Negociacao negociacao5 = new Negociacao(48.8, 100, amanha);
	  Negociacao negociacao6 = new Negociacao(49.3, 100, amanha);
	  
	  Calendar depois = (Calendar) amanha.clone();
	  depois.add(Calendar.DAY_OF_MONTH, 1);
	  
	  Negociacao negociacao7 = new Negociacao(51.8, 100, depois);
	  Negociacao negociacao8 = new Negociacao(52.3, 100, depois);
	  
	  List<Negociacao> negociacoes = Arrays.asList(negociacao1, negociacao5, 
	    negociacao3, negociacao4, negociacao2, negociacao6, negociacao7, 
	    negociacao8);
	  
	  CandlestickFactory fabrica = new CandlestickFactory();
	  
	  List<Candlestick> candles = fabrica.constroiCandles(negociacoes);
	  
	  Assert.assertEquals(3, candles.size());
	  Assert.assertEquals(40.5, candles.get(0).getAbertura(), 0.00001);
	  Assert.assertEquals(42.3, candles.get(0).getFechamento(), 0.00001);
	  Assert.assertEquals(48.8, candles.get(1).getAbertura(), 0.00001);
	  Assert.assertEquals(49.3, candles.get(1).getFechamento(), 0.00001);
	  Assert.assertEquals(51.8, candles.get(2).getAbertura(), 0.00001);
	  Assert.assertEquals(52.3, candles.get(2).getFechamento(), 0.00001);
	}

}
