package veterinaria;

public class TutorObserver implements Interessado {
    @Override
    public void atualizar(Atendimento atendimento) {
        if (atendimento.getSituacao() instanceof EmAtendimentoState) {
            System.out.println("[NOTIFICAÇÃO -> TUTOR] Olá! O atendimento do seu pet '" 
                    + atendimento.getNomeAnimal() + "' foi INICIADO.");
        }
    }
}