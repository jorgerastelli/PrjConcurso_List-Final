package br.senac.rj.materia;

/**
 *
 * @author marcos.silva
 */
public enum Situacao {
    APROVADO("A", "Aprovado"), 
    REPROVADO("R", "Reprovado");

    private final String sigla;
    private final String descricao;
    
    Situacao(String sigla, String descricao) {
        this.sigla = sigla;
        this.descricao = descricao;
    }

    public String getSigla() {
        return sigla;
    }

    public String getDescricao() {
        return descricao;
    }
}
    
