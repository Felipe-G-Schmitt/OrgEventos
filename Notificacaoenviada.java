public class Notificacaoenviada {
    private int id;
    private int idEvento;
    private int idParticipante;
    private String mensagem;

    // Construtor
    public Notificacaoenviada(int idEvento, int idParticipante, String mensagem) {
        this.idEvento = idEvento;
        this.idParticipante = idParticipante;
        this.mensagem = mensagem;
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(int idEvento) {
        this.idEvento = idEvento;
    }

    public int getIdParticipante() {
        return idParticipante;
    }

    public void setIdParticipante(int idParticipante) {
        this.idParticipante = idParticipante;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    @Override
    public String toString() {
        return "Notificação{" +
               "id=" + id +
               ", idEvento=" + idEvento +
               ", idParticipante=" + idParticipante +
               ", mensagem='" + mensagem + '\'' +
               '}';
    }
}
