package veterinaria;

public class EmAtendimentoState implements SituacaoAtendimento {
    @Override
    public void iniciar(Atendimento atendimento) {
        throw new IllegalStateException("O atendimento já está em andamento.");
    }

    @Override
    public void finalizar(Atendimento atendimento) {
        atendimento.setSituacao(new FinalizadoState());
    }

    @Override
    public void cancelar(Atendimento atendimento) {
        throw new IllegalStateException("Não é possível cancelar um atendimento que já está em andamento. Deve ser finalizado.");
    }

    @Override
    public String getNome() {
        return "Em Atendimento";
    }
}