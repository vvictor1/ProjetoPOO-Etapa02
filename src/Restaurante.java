import java.util.*;

public class Restaurante {

    private List<Cliente> clientes = new ArrayList<>();
    
  
    public void cadastrarCliente(int id, String nome, String telefone) {
        clientes.add(new Cliente(id, nome, telefone));
    }
}