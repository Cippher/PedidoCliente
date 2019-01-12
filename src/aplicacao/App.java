package aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entidades.Cliente;
import entidades.ItemPedido;
import entidades.Pedido;
import entidades.Produto;
import entidades.enums.StatusDoPedido;

public class App {

	public static void main(String[] args) throws ParseException {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.printf("Entre com os dados do cliente: \n");
		System.out.printf("Nome: ");
		String nome = sc.nextLine();
		System.out.printf("Email: ");
		String email = sc.nextLine();
		System.out.println("Data de nascimento: ");
		Date data = sdf.parse(sc.next());
		
		Cliente cliente = new Cliente(nome, email, data);
		
		System.out.printf("\nEntre com os dados do pedido: \n");
		System.out.printf("Status: ");
		String status = sc.next();
		
		Pedido pedido = new Pedido(new Date(), StatusDoPedido.valueOf(status), cliente);
		
		System.out.printf("Quantos itens tem esse pedido: ");
		int numero = sc.nextInt();
		sc.nextLine();
		
		for(int i = 0; i < numero; i++) {
			System.out.printf("Entre com os dados do primeiro pedido: \n");
			System.out.printf("Nome do produto: ");
			String nomeProduto = sc.nextLine();
			System.out.print("Preço do produto: ");
			double precoProduto = sc.nextDouble();
			System.out.printf("Quantidade de itens: ");
			int quantidadeProduto = sc.nextInt();
			sc.nextLine();
			
			Produto produto = new Produto(nomeProduto, precoProduto);
			ItemPedido itemPedido = new ItemPedido(quantidadeProduto, produto.getPreco(), produto);
			pedido.addItemPedido(itemPedido);
		}
		
		System.out.println(pedido);
		
		sc.close();
	}

}
