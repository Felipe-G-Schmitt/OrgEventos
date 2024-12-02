import java.sql.Date;
import java.util.ArrayList;

public class Evento {
    private Number id;
    private Number idOrganizador;
    private Number idLocal;
    private Date data; // java.sql.Date para manipular datas do banco de dados
    private String descricao;
    private Number vagas;

    static ArrayList<Evento> eventos = new ArrayList<>();

    public Evento(Number id, Number idOrganizador, Number idLocal, Date data, String descricao, Number vagas) {
        this.id = id;
        this.idOrganizador = idOrganizador;
        this.idLocal = idLocal;
        this.data = data;
        this.descricao = descricao;
        this.vagas = vagas;

        eventos.add(this);
    }

    public Number getId() {
        return id;
    }

    public Number getIdOrganizador() {
        return idOrganizador;
    }

    public void setIdOrganizador(Number idOrganizador) {
        this.idOrganizador = idOrganizador;
    }

    public Number getIdLocal() {
        return idLocal;
    }

    public void setIdLocal(Number idLocal) {
        this.idLocal = idLocal;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Number getVagas() {
        return vagas;
    }

    public void setVagas(Number vagas) {
        this.vagas = vagas;
    }

    @Override
    public String toString() {
        return "Id: " + id + " | Id Organizador: " + idOrganizador + " | Id Local: " + idLocal +
               " | Data: " + data + " | Descrição: " + descricao + " | Vagas: " + vagas;
    }
}
