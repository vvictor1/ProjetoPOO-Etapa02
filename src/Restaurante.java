import java.util.*;

public class Restaurante {

    private List<Cliente> clientes = new ArrayList<>();
    
  
    public void cadastrarCliente(int id, String nome, String telefone) {
        clientes.add(new Cliente(id, nome, telefone));
    }
}
private Map<Integer, Produto> mapaProdutos = new HashMap<>();

public void cadastrarProduto(int id, String nome, double preco) {
    mapaProdutos.put(id, new Produto(id, nome, preco));
}

// Adicione no topo do Restaurante.java
private Set<Integer> mesas = new HashSet<>();

public void adicionarMesa(int numero) {
    mesas.add(numero);
}