package conectagui;

public class Instituicao {
    private int id;
    private String nomeInstituicao;
    private String telefone;

    public Instituicao(int id, String nomeInstituicao, String telefone) {
        this.id = id;
        this.nomeInstituicao = nomeInstituicao;
        this.telefone = telefone;
    }

    public Instituicao(String nomeInstituicao, String telefone) {
        this.nomeInstituicao = nomeInstituicao;
        this.telefone = telefone;
    }

    public Instituicao(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeInstituicao() {
        return nomeInstituicao;
    }

    public void setNomeInstituicao(String nomeInstituicao) {
        this.nomeInstituicao = nomeInstituicao;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    @Override
    public String toString(){
        return this.nomeInstituicao;
    }
}
