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

private Set<Integer> mesas = new HashSet<>();

public void adicionarMesa(int numero) {
    mesas.add(numero);
}

public boolean reservarMesa(int numero) {
    if (mesas.contains(numero)) {
        System.out.println("Mesa " + numero + " reservada com sucesso.");
        return true;
    }
    return false;
}


private List<Pedido> pedidos = new ArrayList<>();

public void registrarPedido(Pedido p) {
    pedidos.add(p);
}

public double calcularTotalMesa(int numeroMesa) {
    double total = 0;
    for (Pedido p : pedidos) {
        if (p.getNumeroMesa() == numeroMesa) {
            total += p.getValorTotal();
        }
    }
    return total;
}