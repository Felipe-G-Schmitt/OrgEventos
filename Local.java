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

    //Verificar se o id ja existe
    public static boolean idExiste(Number id) {
        for (Local local : locais) {
            if (local.id.equals(id)) {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        return "Id: " + id + " | Descrição: " + descricao + " | Vagas: " + vagas;
    }
}
