import java.util.ArrayList;

public class Pessoa {
    private int id;
    private String nome;
    static ArrayList<Pessoa> pessoas = new ArrayList<>();

    public Pessoa(int id, String nome) {
        if (idExiste(id)) {
            throw new IllegalArgumentException("ID já existe!");
        }
        this.id = id;
        this.nome = nome;
        pessoas.add(this);
    }

    public static boolean idExiste(int id) {
        for (Pessoa pessoa : pessoas) {
            if (pessoa.id == id) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "ID: " + id + " | Nome: " + nome;
    }
}

class Participante extends Pessoa {
    private String telefone;
    private Number idNotificacao;

    public Participante(int id, String nome, String telefone, Number idNotificacao) {
        super(id, nome);
        this.telefone = telefone;
        this.idNotificacao = idNotificacao;
    }

    public String getTelefone() {
        return telefone;
    }

    public Number getIdNotificacao() {
        return idNotificacao;
    }

    @Override
    public String toString() {
        return super.toString() + " | Telefone: " + telefone + " | Notificação: " + idNotificacao;
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

    public Number getIdNotificacao() {
        return idNotificacao;
    }

    @Override
    public String toString() {
        return super.toString() + " | Email: " + email + " | Notificação: " + idNotificacao;
    }
}