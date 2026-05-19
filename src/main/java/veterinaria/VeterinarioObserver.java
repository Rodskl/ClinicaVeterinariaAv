package veterinaria;


public class VeterinarioObserver implements Interessado {
    @Override
    public void atualizar(Atendimento atendimento) {
        if (atendimento.getSituacao() instanceof CanceladoState) {
            System.out.println("[NOTIFICAÇÃO -> VETERINÁRIO] Doutor(a), o atendimento agendado para o animal '" 
                    + atendimento.getNomeAnimal() + "' foi CANCELADO.");
        }
    }
}