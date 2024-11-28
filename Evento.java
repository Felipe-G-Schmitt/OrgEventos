import java.util.ArrayList;

public class Evento {
    private Number id;
    private Number idOrganizador;
    private Number idLocal;
    private Number data;
    private String descricao;
    private String participantes;
    private Number vagas;

    static ArrayList<Evento> eventos = new ArrayList<Evento>();

    public Evento(Number id, Number idOrganizador, Number idLocal, Number data, String descricao, String participantes, Number vagas) {
        this.id = id;
        this.idOrganizador = idOrganizador;
        this.idLocal = idLocal;
        this.data = data;
        this.descricao = descricao;
        this.participantes = participantes;
        this.vagas = vagas;

        eventos.add(this);
    }

    //Verificar se o id ja existe
    public static boolean idExiste(int id) {
        for (Evento evento : eventos) {
            if (evento.id.equals(id)) {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        return "Id: " + id + " | Id Organizador: " + idOrganizador + " | Id Local: " + idLocal + " | Data: " + data + " | Descrição: " + descricao + " | Participantes: " + participantes + " | Vagas: " + vagas;
    }
}
