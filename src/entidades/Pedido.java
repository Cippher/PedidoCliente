package entidades;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entidades.enums.StatusDoPedido;

public class Pedido {
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	private static SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy");
	
	private Date momento = new Date();
	private StatusDoPedido status;
	private List<ItemPedido> itemPedido = new ArrayList<>();
	private Cliente cliente;
	
	public Pedido() {		
	}

	public Pedido(Date momento, StatusDoPedido status, Cliente cliente) {
		this.momento = momento;
		this.status = status;
		this.cliente = cliente;
	}

	public Date getMomento() {
		return momento;
	}

	public void setMomento(Date momento) {
		this.momento = momento;
	}

	public StatusDoPedido getStatus() {
		return status;
	}

	public void setStatus(StatusDoPedido status) {
		this.status = status;
	}
	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public void addItemPedido(ItemPedido itemPedido) {
		this.itemPedido.add(itemPedido);
	}
	
	public void removeItemPedido(ItemPedido itemPedido) {
		this.itemPedido.remove(itemPedido);
	}
	
	public double total() {
		double total = 0;
		for(ItemPedido p : itemPedido) {
			total += p.getPreco() * p.getQuantidade();
		}
		return total;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("\nPEDIDO!\n");
		sb.append("Momento do pedido: " + sdf.format(momento));
		sb.append("\nStatus do pedido: " + status);
		sb.append("\nCliente: " + cliente.getNome() + " ");
		sb.append("(" + sdf2.format(cliente.getDataDeNascimento()) + ")" + " ");
		sb.append(" - " + cliente.getEmail());
		sb.append("\nItens do pedido: \n");
		
		for(ItemPedido ip : itemPedido) {
			sb.append(ip.getProduto().getNome());
			sb.append(" $" + String.format("%.2f", ip.getPreco()));
			sb.append(", Quantidade: " + ip.getQuantidade());
			sb.append(", Subtotal: " + String.format("%.2f", ip.subTotal()) + "\n");
		}
		sb.append("\nTotal: " + String.format("%.2f", total()));
		
		return sb.toString();
	}
}
