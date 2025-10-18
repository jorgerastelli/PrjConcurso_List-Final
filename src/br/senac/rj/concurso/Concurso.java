package br.senac.rj.concurso;

import br.senac.rj.candidato.Candidato;
import br.senac.rj.materia.Materia;
import java.util.List;

/**
 *
 * @author marcos.silva
 */
public class Concurso {
    private Candidato[] candidatos;
    private double[] medias;

    public Concurso() {
    }

    public Candidato[] getCandidatos() {
        return candidatos;
    }

    public void setCandidatos(Candidato[] candidatos) {
        this.candidatos = candidatos;
    }

    public double[] getMedias() {
        return medias;
    }

    // calcula as medias das provas do concurso
    public void calcularMedias() {
        // calcula as medias das provas do concurso se houver candidatos
        if (candidatos != null && candidatos.length > 0) {
            int qtdMaterias = candidatos[0].getMaterias().size();
            this.medias = new double[qtdMaterias];

            
            for (int indMateria = 0; indMateria<3; indMateria++) {
                double media = 0;
                
                for (Candidato candidato : this.candidatos) {
                    List<Materia> materias = candidato.getMaterias();
                    media = media + materias.get(indMateria).getNota();
                }

                this.medias[indMateria] = media / this.candidatos.length;
                
            }
        }
    }
    
    public float getMediaPorMateria(String nomeMateria) {
    float soma = 0f;

    if (this.candidatos != null && this.candidatos.length > 0) {
        for (Candidato candidato : this.candidatos) {
            List<Materia> materias = candidato.getMaterias();

            for (Materia materia : materias) {
                if (nomeMateria.equalsIgnoreCase(materia.getNome())) {
                    soma += materia.getNota();
                }
            }
        }

        soma = soma / this.candidatos.length;
    }

    return soma;
}

    
    // a) Nome dos candidatos aprovados;
    public String[] getNomeAprovados() {
        int qtdAprovados = 0;
        String[] aprovados = null;
        
        for (Candidato candidato : this.candidatos) {
            qtdAprovados += ("A".equals(candidato.getSituacao().getSigla()) ? 1: 0);
        }
        
        // se existir candidado aprovado
        if (qtdAprovados > 0) {
            aprovados = new String[qtdAprovados];
            
            // recupera os nomes dos aprovados
            qtdAprovados = 0;
            for (Candidato candidato : this.candidatos) {
                if ("A".equals(candidato.getSituacao().getSigla())) {
                    aprovados[qtdAprovados] = candidato.getNome();
                    qtdAprovados++;
                }
            }
        }
        
        return aprovados;            
    }
    
    // c) O número de candidatos que obtiveram média maior que 4.5 e nota na
    // prova de Conhecimentos Geral maior que 6,0
    public int getCandidatosMediaConhecimentosGerais() {
        int qtdCandidatos = 0;
        
        for (Candidato candidato : this.candidatos) {
            List<Materia> materias = candidato.getMaterias();
            float notaCG = materias.get(2).getNota();
            
            if (candidato.getMedia() > 4.5 && notaCG > 6) {
                qtdCandidatos += 1;
            }
        }
        
        return qtdCandidatos;
    }
    
    // d) O número de candidatos aprovados que obtiveram nota em Matemática
    // acima de 5,0
    public int getCandidatosAprovadosMatematicaAcimaDe5() {
        int qtdCandidatos = 0;
        
        for (Candidato candidato : this.candidatos) {
            List<Materia> materias = candidato.getMaterias();
            float notaMatematica = materias.get(1).getNota();
            
            if ("A".equals(candidato.getSituacao().getSigla()) && notaMatematica > 5) {
                qtdCandidatos += 1;
            }
        }
        
        return qtdCandidatos;
    }
}
