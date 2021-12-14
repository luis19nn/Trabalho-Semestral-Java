package tpoo;

public class Cliente implements Comparable {
    private int id;
    private String nome;
    private String sobrenome;
    private Long RG;
    private Long CPF;
    private float salario;
    private String endereco;
    
    public Cliente(int id, String nome, String sobrenome, Long RG, Long CPF, float salario, String endereco) {
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.RG = RG;
        this.CPF = CPF;
        this.salario = salario;
        this.endereco = endereco;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    
    public String getSobrenome() { return sobrenome; }
    public void setSobrenome(String sobrenome) { this.sobrenome = sobrenome; }
    
    public Long getRG() { return RG; }
    public void setRG(Long RG) { this.RG = RG; }
    
    public Long getCPF() { return CPF; }
    public void setCPF(Long CPF) { this.CPF = CPF; }
    
    public float getSalario() { return salario; }
    public void setSalario(float salario) { this.salario = salario; }
    
    public String getEndereco() { return endereco; }
    public void setEndereco(String endereco) { this.endereco = endereco; }

    @Override
    public int compareTo(Object o) {
        Cliente outroCliente = (Cliente) o;
        
        if (this.getSalario() > outroCliente.getSalario()) {
            return -1;
        } else if (this.getSalario() < outroCliente.getSalario()) {
            return 1;
        } else {
            return 0;
        }
    }
}
