package br.com.caelum.argentum.test;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import org.junit.Test;

import br.com.caelum.argentum.modelo.Negociacao;
import br.com.caelum.argentum.reader.LeitorXML;

public class LeitorXMLTest {

	@SuppressWarnings("deprecation")
	@Test
	public void carregaXmlComUmaNegociacaoEmListaUnitaria() {
		String xmlDeTeste = "<list>" +
		          "  <negociacao>" +
		          "    <preco>43.5</preco>" +
		          "    <quantidade>1000</quantidade>" +
		          "    <data>" +
		          "      <time>1322233344455</time>" +
		          "    </data>" +
		          "  </negociacao>" +
		          "</list>";
	  
	  LeitorXML leitor = new LeitorXML();

	  InputStream xml = new ByteArrayInputStream(xmlDeTeste.getBytes());

	  List<Negociacao> negociacoes = leitor.carrega(xml);
	  
	  assertEquals(1, negociacoes.size());
	  assertEquals(43.5, negociacoes.get(0).getPreco(),0000.1);
	  assertEquals(1000, negociacoes.get(0).getQuantidade(),0000.1);
	  
	  
	  
	}

}
