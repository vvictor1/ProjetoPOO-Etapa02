public class Pedido {
    private int numeroMesa;
    private String nomeProduto;
    private int quantidade;
    private double valorTotal;

    public Pedido(int numeroMesa, String nomeProduto, int quantidade, double valorTotal) {
        this.numeroMesa = numeroMesa;
        this.nomeProduto = nomeProduto;
        this.quantidade = quantidade;
        this.valorTotal = valorTotal;
    }

    // Getters para permitir que o Restaurante ou Main processem os dados
    public int getNumeroMesa() { return numeroMesa; }
    public String getNomeProduto() { return nomeProduto; }
    public int getQuantidade() { return quantidade; }
    public double getValorTotal() { return valorTotal; }
}