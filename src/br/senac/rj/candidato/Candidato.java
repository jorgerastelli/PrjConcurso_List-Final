package br.senac.rj.candidato;

import br.senac.rj.materia.Materia;
import br.senac.rj.materia.Situacao;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author marcos.silva
 */
public class Candidato {
    private String nome;
    private List<Materia> materias;
    private Situacao situacao;
    private double media;

    public Candidato() {
        this.materias = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Materia> getMaterias() {
        return materias;
    }

    public void setMaterias(Materia[] materias) {
        this.materias = new ArrayList<>(Arrays.asList(materias));
}


    public Situacao getSituacao() {
        return situacao;
    }

    public double getMedia() {
        return media;
    }

    // recupera e define a situacao baseado nas notas das materias
    public void avaliarSituacao() {
        if (materias.isEmpty()) {
            this.situacao = Situacao.REPROVADO;
            this.media = 0;
            return;
        }

        double totalNotas = 0.0;
        boolean hasNotaMenorQue2 = false;

        for (Materia materia : materias) {
            totalNotas += materia.getNota();
            if (materia.getNota() < 2.0) {
                hasNotaMenorQue2 = true;
            }
        }

        // calcula a média
        media = totalNotas / materias.size();

        // avalia o resultado do candidato
        this.situacao = (!hasNotaMenorQue2 && media > 4)
                ? Situacao.APROVADO
                : Situacao.REPROVADO;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Candidato { ");
        sb.append(this.nome);
        sb.append("; Media = ").append(String.format("%.2f", this.media));
        sb.append("; ").append(this.situacao.getDescricao());
        sb.append("; Notas [ ");
        for (int i=0; i<this.materias.size(); i++) {
            Materia materia = materias.get(i);
            sb.append(materia.toString());
            if (i<this.materias.size()-1) {
                sb.append(" / ");
            }
        }
        sb.append(" ] }\n");
        
        return sb.toString();
    }
}