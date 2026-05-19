package veterinaria;



public class AgendadoState implements SituacaoAtendimento {
    @Override
    public void iniciar(Atendimento atendimento) {
        atendimento.setSituacao(new EmAtendimentoState());
    }

    @Override
    public void finalizar(Atendimento atendimento) {
        throw new IllegalStateException("Não é possível finalizar um atendimento que está apenas Agendado.");
    }

    @Override
    public void cancelar(Atendimento atendimento) {
        atendimento.setSituacao(new CanceladoState());
    }

    @Override
    public String getNome() {
        return "Agendado";
    }
}