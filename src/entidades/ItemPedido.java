package entidades;

public class ItemPedido {

	private int quantidade;
	private double preco;
	private Produto produto;

	public ItemPedido() {
	}

	public ItemPedido(int quantidade, double preco, Produto produto) {
		this.quantidade = quantidade;
		this.preco = preco;
		this.produto = produto;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public double getPreco() {
		return preco;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public double subTotal() {
		return quantidade * preco;
	}
}
