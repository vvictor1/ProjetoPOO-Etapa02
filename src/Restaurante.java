import java.util.*;

public class Restaurante {

    // Coleções (Atributos da classe)
    private List<Cliente> clientes = new ArrayList<>();
    private Map<Integer, Produto> mapaProdutos = new HashMap<>();
    private Set<Integer> mesas = new HashSet<>();
    private List<Pedido> pedidos = new ArrayList<>();

    // Métodos para Clientes
    public void cadastrarCliente(int id, String nome, String telefone) {
        clientes.add(new Cliente(id, nome, telefone));
    }

    // Métodos para Produtos
    public void cadastrarProduto(int id, String nome, double preco) {
        mapaProdutos.put(id, new Produto(id, nome, preco));
    }

    public Produto buscarProduto(int id) {
        return mapaProdutos.get(id);
    }

    // Métodos para Mesas
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

    // Métodos para Pedidos
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
} 