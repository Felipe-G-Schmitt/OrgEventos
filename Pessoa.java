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

    public String toString() {
        return "ID: " + id + " | Nome: " + nome;
    }
}

class Participante extends Pessoa {
    private String telefone;
    private String notifica; 

    public Participante(int id, String nome, String telefone, String notifica) {
        super(id, nome);
        this.telefone = telefone;
        this.notifica = notifica;
    }

    @Override
    public String toString() {
        return super.toString() + " | Telefone: " + telefone + " | Notificação: " + notifica;
    }
}

class Organizador extends Pessoa {
    private String email;
    private String notifica; 

    public Organizador(int id, String nome, String email, String notifica) {
        super(id, nome);
        this.email = email;
        this.notifica = notifica;
    }

    @Override
    public String toString() {
        return super.toString() + " | Email: " + email + " | Notificação: " + notifica;
    }
}
