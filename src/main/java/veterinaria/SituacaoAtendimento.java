package veterinaria;


public interface SituacaoAtendimento {
    void iniciar(Atendimento atendimento);
    void finalizar(Atendimento atendimento);
    void cancelar(Atendimento atendimento);
    String getNome();
}