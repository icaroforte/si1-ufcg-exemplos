package si20121.antes.grasp3;

import java.util.Collection;

import si20121.antes.grasp3.Pagamento.Forma;


public class TPDV {

	private Venda vendaAtual;
	private CatalogoDeProdutos catalogo;
	private Loja loja;
	private EmissorDeNotaFiscal emissorDeNotaFiscal;

	public TPDV(Loja loja, CatalogoDeProdutos catalogo, EmissorDeNotaFiscal emissor) {
		this.catalogo = catalogo;
		emissorDeNotaFiscal = emissor;
	}

	public void novaVenda() {
		vendaAtual = new Venda();
	}

	public void addItemVenda(int codigo, int quantidade)
			throws VendaInvalidaException {
		// Creator novamente:
		vendaAtual.novoItemVenda(catalogo.getProduto(codigo), quantidade);
	}

	public float getTotalAtual() {
		return vendaAtual.getTotal();
	}

	public float getDebito() {
		return vendaAtual.getDebito();
	}

	public void pagar(float valor, Forma cartao) {
		vendaAtual.pagar(valor, cartao);
	}

	public boolean isVendaAberta() {
		return vendaAtual.isAberta();
	}

	public void finalizaVenda() {
		vendaAtual.finaliza();
		loja.armazena(vendaAtual);
	}

	public Collection<Venda> getVendasRealizadas() {
		return loja.getVendasRealizadas();
	}

	public NotaFiscal emitirNotaFiscal() {
		// TODO verificar se está finalizada
		NotaFiscal nota = emissorDeNotaFiscal.getNotaFiscal(vendaAtual);
		return nota;
	}

}
