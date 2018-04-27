package produtos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import logisticsmanagementws.ConnectionMySQL;

public class ProdutoDAO {
	
	Connection connection = ConnectionMySQL.getConexao();
	ResultSet result;	

	public ArrayList<Produto> getProdutos() {
		
		ArrayList<Produto> produtos = new ArrayList();
		
		produtos.add(new Produto(01, "ração dogão", "dogfood", "ração para caes", 000000000, 1, 10.0, 12.0));
		produtos.add(new Produto(02, "ração gatao", "catfood", "ração para gatos", 111111111, 2, 11.0, 13.0));
		produtos.add(new Produto(03, "ração tatu", "tatufood", "ração para tatus", 222222222, 2, 12.0, 14.0));
		produtos.add(new Produto(04, "ração peixao", "fishfood", "ração para peixes", 333333333, 1, 13.0, 15.0));
		produtos.add(new Produto(05, "ração pangaré", "horsefood", "ração para cavalos", 444444444, 1, 14.0, 16.0));
		
		return produtos;
	}

	public void cadastrarProduto(Produto produto) {
		
		try {
			connection.setAutoCommit(false);
					
			String insert = "INSERT INTO produto(nome_produto, "
												 + "marca_produto, "
												 + "descricao_produto, "
												 + "codigo_barras_produto, "
												 + "unid_medida_produto, "
												 + "valor_custo_produto, "
												 + "valor_venda_produto) "
						               + "VALUES('"+ produto.getNomeProduto()+"', '"
						                         + produto.getMarcaProduto()+"', '"
						                         + produto.getDescricaoProduto()+"', "
						                         + produto.getCodigoBarrasProduto()+", "
						                         + produto.getUnidMedidaProduto()+", "
						                         + produto.getValorCustoProduto()+", "
						                         + produto.getValorVendaProduto()+");";
			//String query = "SELECT id FROM points ORDER BY id DESC LIMIT 1;";
			
			PreparedStatement statementInsert = connection.prepareStatement(insert);
			//PreparedStatement statementQuery =  connection.prepareStatement(query);
			
			statementInsert.executeUpdate(insert);
			//result = statementQuery.executeQuery(query);
			
			connection.commit();
			
			//result.next();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
