import java.util.ArrayList;

class Pessoa {
    private int id;
    private String nome;

    public Pessoa(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}

class Participante extends Pessoa {
    private String telefone;
    private int idNotificacao;

    public Participante(int id, String nome, String telefone, int idNotificacao) {
        super(id, nome);
        this.telefone = telefone;
        this.idNotificacao = idNotificacao;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public int getIdNotificacao() {
        return idNotificacao;
    }

    public void setIdNotificacao(int idNotificacao) {
        this.idNotificacao = idNotificacao;
    }
}
class Organizador extends Pessoa {
    private String email;
    private Number idNotificacao;

    public Organizador(int id, String nome, String email, Number idNotificacao) {
        super(id, nome);
        this.email = email;
        this.idNotificacao = idNotificacao;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Number getIdNotificacao() {
        return idNotificacao;
    }

    public void setIdNotificacao(Number idNotificacao) {
        this.idNotificacao = idNotificacao;
    }

    @Override
    public String toString() {
        return super.toString() + " | Email: " + email + " | Notificação: " + idNotificacao;
    }
}
