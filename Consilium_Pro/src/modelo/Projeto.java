package modelo;

/**
 * Representa um projeto com nome, descrição, datas, status e gerente responsável.
 */
public class Projeto {
    private String nome;
    private String descricao;
    private String dataInicio;
    private String dataFim;
    private String status;
    private Usuario gerente;

    // Construtor que define os dados do projeto
    public Projeto(String nome, String descricao, String dataInicio, String dataFim, String status, Usuario gerente) {
        this.nome = nome;
        this.descricao = descricao;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.status = status;
        this.gerente = gerente;
    }

    // Retorna o nome do projeto
    public String getNome() { return nome; }

    // Retorna a descrição do projeto
    public String getDescricao() { return descricao; }

    // Retorna a data de início
    public String getDataInicio() { return dataInicio; }

    // Retorna a data de fim
    public String getDataFim() { return dataFim; }

    // Retorna o status atual
    public String getStatus() { return status; }

    // Retorna o gerente responsável
    public Usuario getGerente() { return gerente; }

    // Mostra os dados do projeto em formato de texto
    @Override
    public String toString() {
        return "Projeto: " + nome + "\nDescrição: " + descricao +
               "\nInício: " + dataInicio + " | Fim: " + dataFim +
               "\nStatus: " + status + "\nGerente: " + gerente.getNome();
    }
}