public class Profissional {
    private String nome;
    private String especialidade;
    private String registroProfissional;
    private double valorConsulta;
    private String[] diasDisponiveis;
    private int totalDias;

    public Profissional(String nome, String especialidade) {
        this.nome = nome;
        this.especialidade = especialidade;
        this.diasDisponiveis = new String[7];
    }

    public Profissional(String nome, String especialidade, String registro, double valor) {
        this.nome = nome;
        this.especialidade = especialidade;
        this.registroProfissional = registro;
        this.valorConsulta = valor;
        this.diasDisponiveis = new String[7];
    }

    public Profissional(String nome, String esp, String reg, double valor, String[] dias, int total) {
        this.nome = nome;
        this.especialidade = esp;
        this.registroProfissional = reg;
        this.valorConsulta = valor;
        this.diasDisponiveis = dias;
        this.totalDias = total;
    }

    // --- GETTERS (Pontes para a Main) ---
    public String getNome() { return nome; }
    public String getEspecialidade() { return especialidade; }
    public String getRegistroProfissional() { return registroProfissional; }
    public double getValorConsulta() { return valorConsulta; }

    // --- MÉTODOS DE NEGÓCIO ---
    public void atualizar(String registro, double valor) {
        this.registroProfissional = registro;
        this.valorConsulta = valor;
    }

    public void atualizar(String registro, double valor, String[] dias, int total) {
        this.registroProfissional = registro;
        this.valorConsulta = valor;
        this.diasDisponiveis = dias;
        this.totalDias = total;
    }

    public boolean atendeNoDia(String dia) {
        for (int i = 0; i < totalDias; i++) {
            if (diasDisponiveis[i] != null && diasDisponiveis[i].equals(dia)) return true;
        }
        return false;
    }

    public static boolean especialidadeValida(String esp) {
        return esp.equals("clinica geral") || esp.equals("fisioterapia") || 
               esp.equals("psicologia") || esp.equals("nutricao");
    }

    public String exibirResumo() {
        String dias = "";
        for (int i = 0; i < totalDias; i++) dias += (i > 0 ? ", " : "") + diasDisponiveis[i];
        return "Nome: " + nome + " | Espec: " + especialidade + " | Reg: " + registroProfissional
                + " | Valor: R$" + valorConsulta + " | Dias: " + dias;
    }
}