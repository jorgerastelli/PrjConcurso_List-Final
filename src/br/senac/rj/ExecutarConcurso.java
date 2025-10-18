package br.senac.rj;

import br.senac.rj.candidato.Candidato;
import br.senac.rj.concurso.Concurso;
import br.senac.rj.materia.Materia;

/**
 *
 * @author marcos.silva
 */
public class ExecutarConcurso {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Concurso concurso;
        Candidato[] candidatos;
        
        concurso = new Concurso();
        
        candidatos = receberCandidatos_v3();
        if (candidatos == null) {
            System.exit(0);
        }
                
        concurso.setCandidatos(candidatos);
        
        gerarSituacaoCandidatos(concurso);
        apresentarResultados(concurso);
    }
    
    
    // gerar a situacao de cada candidato
    static void gerarSituacaoCandidatos(Concurso concurso) {
        Candidato[] candidatos = concurso.getCandidatos();
        for (Candidato candidato : candidatos) {
            candidato.avaliarSituacao();
            
            System.out.println(candidato.toString());
        }
        
        concurso.calcularMedias();
    }
    
    static void apresentarResultados(Concurso concurso) {
        String[] aprovados = concurso.getNomeAprovados();
        double mediaPortugues = concurso.getMedias()[0];
        int qtdCandidatos = concurso.getCandidatosMediaConhecimentosGerais();
        int qtdAprovadosMatematica = concurso.getCandidatosAprovadosMatematicaAcimaDe5();
        
        System.out.println("---------- Resultados ----------");
        System.out.println("--- Candidatos aprovados ---");
        if (aprovados != null && aprovados.length > 0) {
            for (String aprovado : aprovados) {
                System.out.println(aprovado);
            }
        } else {
            System.out.println("  Nao ha candidatos aprovados");
        }
        System.out.println();
        System.out.printf("Media da prova de portugues: %.2f", mediaPortugues);
        System.out.println();
        System.out.printf("Qtd candidatos que obtiveram media maior que 4.5 e "
            + "nota de Conhecimentos Geral maior que 6: %d", qtdCandidatos);
        
        System.out.println();
        System.out.printf("Qtd candidatos aprovados que obtiveram nota em "
            + "Matematica: acima de 5,0: %d", qtdAprovadosMatematica);

        System.out.println();
    }
 
    
    static Candidato[] receberCandidatos_v3() { 
        Candidato[] candidatos = new Candidato[10];
        for(int i=0; i<10; i++) {
            Candidato candidato = new Candidato();
            candidato.setNome("Candidato " + (i+1));
            for(int j=0; j<3; j++) {
                Materia materia = new Materia();
                switch (j) {
                    case 0 -> materia.setNome("Portugues");
                    case 1 -> materia.setNome("Matematica");
                    default -> materia.setNome("Conhecimentos Gerais");
                }
                
                materia.setNota((int) (Math.random() * 10));
                candidato.getMaterias().set(j, materia);
            }
            
            candidatos[i]=candidato;
        }
        
        return candidatos;
    }
}
