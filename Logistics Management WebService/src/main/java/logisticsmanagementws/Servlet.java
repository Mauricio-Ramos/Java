package logisticsmanagementws;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import produtos.*;

/**
 * Servlet implementation class Servlet
 */
public class Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	ProdutoDAO produtoDAO = new ProdutoDAO();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		response.setContentType("application/json");
		
		ArrayList<Produto> produtos = produtoDAO.getProdutos();
		
		Gson gson = new GsonBuilder().create();
		JsonArray jarray = gson.toJsonTree(produtos).getAsJsonArray();
		JsonObject jsonObject = new JsonObject();
		jsonObject.add("produtos", jarray);

		response.getWriter().append(jsonObject.toString());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		response.setContentType("application/json");
		
		Produto produto = new Produto();
		JSONObject jObj = new JSONObject();
		StringBuilder json = new StringBuilder();
		BufferedReader reader = request.getReader();
		String line;
		
		while((line = reader.readLine()) != null){
			json.append(line);
		}
		try {
			jObj = new JSONObject(json.toString());
			
			produto.setIdProduto(jObj.getInt("idProduto"));
			produto.setNomeProduto(jObj.getString("nomeProduto"));
			produto.setMarcaProduto(jObj.getString("marcaProduto"));
			produto.setDescricaoProduto(jObj.getString("descricaoProduto"));
			produto.setCodigoBarrasProduto(jObj.getInt("codigoBarrasProduto"));
			produto.setUnidMedidaProduto(jObj.getInt("unidMedidaProduto"));
			produto.setValorCustoProduto(jObj.getDouble("valorCustoProduto"));
			produto.setValorVendaProduto(jObj.getDouble("valorVendaProduto"));
			
			
			Produto prod = new Produto(02, "ração gatao", "catfood", "ração para gatos", 111111111, 2, 11.0, 13.0);
			produtoDAO.cadastrarProduto(prod);
			
		} catch (JSONException e) {
			System.out.println(json.toString());
			e.printStackTrace();
		}
		
	}

}
