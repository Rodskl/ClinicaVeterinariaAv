package veterinaria;

import java.util.ArrayList;
import java.util.List;

public class Atendimento {
    private final String nomeTutor;
    private final String nomeAnimal;
    private final String servicoSolicitado;
    
    private SituacaoAtendimento situacao;
    private final List<Interessado> interessados;
    private ComponentePreco precoComponente;

    public Atendimento(String nomeTutor, String nomeAnimal, String servicoSolicitado, double valorBase) {
        this.nomeTutor = nomeTutor;
        this.nomeAnimal = nomeAnimal;
        this.servicoSolicitado = servicoSolicitado;
        this.situacao = new AgendadoState(); 
        this.interessados = new ArrayList<>();
        
        this.precoComponente = new ComponentePreco() {
            @Override
            public double getValor() {
                return valorBase;
            }

            @Override
            public String getDescricao() {
                return servicoSolicitado + " (R$ " + valorBase + ")";
            }
        };
    }

    public void iniciar() {
        this.situacao.iniciar(this);
    }

    public void finalizar() {
        this.situacao.finalizar(this);
    }

    public void cancelar() {
        this.situacao.cancelar(this);
    }

    public SituacaoAtendimento getSituacao() {
        return this.situacao;
    }

    public void setSituacao(SituacaoAtendimento novaSituacao) {
        this.situacao = novaSituacao;
        this.notificarInteressados(); 
    }

    public void adicionarInteressado(Interessado interessado) {
        this.interessados.add(interessado);
    }

    public void removerInteressado(Interessado interessado) {
        this.interessados.remove(interessado);
    }

    private void notificarInteressados() {
        for (Interessado interessado : this.interessados) {
            interessado.atualizar(this);
        }
    }

    public void aplicarModificadorPreco(ComponentePreco precoDecorado) {
        this.precoComponente = precoDecorado;
    }

    public ComponentePreco getPrecoComponente() {
        return this.precoComponente;
    }

    public double getValorFinal() {
        return this.precoComponente.getValor();
    }

    public String getExtratoPreco() {
        return this.precoComponente.getDescricao();
    }

    public String getNomeAnimal() {
        return this.nomeAnimal;
    }

    public String getNomeTutor() {
        return this.nomeTutor;
    }

    public String getServicoSolicitado() {
        return this.servicoSolicitado;
    }
}