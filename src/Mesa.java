public class Mesa {
    private int numeroMesa;
    private boolean ocupada;

    public Mesa(int numeroMesa) {
        this.numeroMesa = numeroMesa;
        this.ocupada = false; // Começa sempre livre
    }

    public int getNumeroMesa() { return numeroMesa; }
    public boolean isOcupada() { return ocupada; }
    
    public void ocupar() { this.ocupada = true; }
    public void liberar() { this.ocupada = false; }
}