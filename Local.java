import java.util.ArrayList;

public class Local {
    private Number id;
    private String descricao;
    private Number vagas;

    static ArrayList<Local> locais = new ArrayList<Local>();

    public Local(Number id, String descricao, Number vagas) {
        this.id = id;
        this.descricao = descricao;
        this.vagas = vagas;

        locais.add(this);
    }

    public Number getId() {
        return id;
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

    // Verificar se o ID já existe
    public static boolean idExiste(Number id) {
        for (Local local : locais) {
            if (local.id.equals(id)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "Id: " + id + " | Descrição: " + descricao + " | Vagas: " + vagas;
    }
}
