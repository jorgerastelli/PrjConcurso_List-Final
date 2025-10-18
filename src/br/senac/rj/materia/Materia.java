package br.senac.rj.materia;

/**
 *
 * @author marcos.silva
 */


public class Materia {
    private String nome;
    private float nota;

    public Materia() {
    }

    public Materia(String nome, float nota) {
        this.nome = nome;
        this.nota = nota;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getNota() {
        return nota;
    }

    public void setNota(float nota) {
        this.nota = nota;
    }
    
    @Override 
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.nome);
        sb.append(" = ").append(String.format("%.2f", this.nota));
        return sb.toString();
    }
}
