package produtos;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Produto {
	
	private int idProduto;
	private String nomeProduto;
	private String marcaProduto;	
	private String descricaoProduto;
	private int codigoBarrasProduto;	
	private int unidMedidaProduto;
	private double valorCustoProduto;
	private double valorVendaProduto;
	
	public Produto(int idProduto, String nomeProduto, String marcaProduto, String descricaoProduto, int codigoBarrasProduto, int unidMedidaProduto, double valorCustoProduto, double valorVendaProduto) {
		this.idProduto = idProduto;
		this.nomeProduto = nomeProduto;
		this.marcaProduto = marcaProduto;
		this.descricaoProduto = descricaoProduto;
		this.codigoBarrasProduto = codigoBarrasProduto;
		this.unidMedidaProduto = unidMedidaProduto;
		this.valorCustoProduto = valorCustoProduto;
		this.valorVendaProduto = valorVendaProduto;
	}
	
	public Produto() {
		
	}

	public int getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(int idProduto) {
		this.idProduto = idProduto;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public String getMarcaProduto() {
		return marcaProduto;
	}

	public void setMarcaProduto(String marcaProduto) {
		this.marcaProduto = marcaProduto;
	}

	public String getDescricaoProduto() {
		return descricaoProduto;
	}

	public void setDescricaoProduto(String descricaoProduto) {
		this.descricaoProduto = descricaoProduto;
	}

	public int getCodigoBarrasProduto() {
		return codigoBarrasProduto;
	}

	public void setCodigoBarrasProduto(int codigoBarrasProduto) {
		this.codigoBarrasProduto = codigoBarrasProduto;
	}

	public int getUnidMedidaProduto() {
		return unidMedidaProduto;
	}

	public void setUnidMedidaProduto(int unidMedidaProduto) {
		this.unidMedidaProduto = unidMedidaProduto;
	}

	public double getValorCustoProduto() {
		return valorCustoProduto;
	}

	public void setValorCustoProduto(double valorCustoProduto) {
		this.valorCustoProduto = valorCustoProduto;
	}

	public double getValorVendaProduto() {
		return valorVendaProduto;
	}

	public void setValorVendaProduto(double valorVendaProduto) {
		this.valorVendaProduto = valorVendaProduto;
	}
}
