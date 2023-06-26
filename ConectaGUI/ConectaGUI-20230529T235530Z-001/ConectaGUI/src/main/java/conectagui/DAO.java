package conectagui;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class DAO {
    public boolean existe(Usuario usuario) throws Exception{
        String sql="SELECT * FROM tb_usuario WHERE nome=? AND senha=?";
        try(Connection conn=ConexaoBD.obterConexao()){
                PreparedStatement ps = conn.prepareStatement(sql);
                    ps.setString(1,usuario.getNome());
                    ps.setString(2,usuario.getSenha());
                    try(ResultSet rs = ps.executeQuery()){
                        return rs.next();
                    }        
        }              
    }
    public Instituicao [] obterInstituicoes () throws Exception{ 
        String sql = "SELECT * FROM tb_instituicao"; 
        try (Connection conn = ConexaoBD.obterConexao(); 
            PreparedStatement ps = 
            conn.prepareStatement(sql, 
                ResultSet.TYPE_SCROLL_INSENSITIVE, 
                ResultSet.CONCUR_READ_ONLY); 
            ResultSet rs = ps.executeQuery()){ 
            int totalDeInstituicoes = rs.last () ? rs.getRow() : 0; 
            Instituicao [] instituicoes = new Instituicao[totalDeInstituicoes]; 
            rs.beforeFirst(); 
            int contador = 0; 
            while (rs.next()){ 
                int id = rs.getInt("id"); 
                String nomeInstituicao = rs.getString("nome_instituicao"); 
                String telefone = rs.getString ("telefone"); 
                instituicoes[contador++] = new Instituicao (id, nomeInstituicao, telefone); 
            } 
            return instituicoes; 
        } 
    }
    
     public Item [] obterItens () throws Exception{ 
        String sql = "SELECT * FROM tb_item"; 
        try (Connection conn = ConexaoBD.obterConexao(); 
            PreparedStatement ps = 
            conn.prepareStatement(sql, 
                ResultSet.TYPE_SCROLL_INSENSITIVE, 
                ResultSet.CONCUR_READ_ONLY); 
            ResultSet rs = ps.executeQuery()){ 
            int totalDeItens = rs.last () ? rs.getRow() : 0; 
            Item [] itens = new Item[totalDeItens]; 
            rs.beforeFirst(); 
            int contador = 0; 
            while (rs.next()){ 
                int id = rs.getInt("id"); 
                String nome = rs.getString("nome"); 
                String descricao = rs.getString ("descricao"); 
                itens[contador++] = new Item (id, nome, descricao); 
            } 
            return itens; 
        } 
    }
    
    public void inserirInstituicao (Instituicao instituicao) throws Exception{ 
        String sql = "INSERT INTO tb_instituicao (nome_instituicao, telefone) VALUES (?, ?);"; 
        try (Connection conexao = ConexaoBD.obterConexao(); 
                PreparedStatement ps = conexao.prepareStatement(sql)){ 
            ps.setString(1, instituicao.getNomeInstituicao()); 
            ps.setString(2, instituicao.getTelefone()); 
            ps.execute(); 
        } 
    } 
    
    public void inserirItem (Item item) throws Exception{
        String sql="INSERT INTO tb_item(nome, descricao) VALUES(?,?);";
        try(Connection conexao=ConexaoBD.obterConexao();
            PreparedStatement ps=conexao.prepareStatement(sql)){
        ps.setString(1, item.getNome());
        ps.setString(2, item.getDescricao());
        ps.execute();
        }
    }
    
    public void atualizaInstituicao (Instituicao instituicao) throws Exception{ 
        String sql = "UPDATE tb_instituicao SET nome_instituicao = ?, telefone = ? WHERE id = ?"; 
        try (Connection conexao = ConexaoBD.obterConexao(); 
                PreparedStatement ps = conexao.prepareStatement(sql)){ 
            ps.setString (1, instituicao.getNomeInstituicao()); 
            ps.setString (2, instituicao.getTelefone()); 
            ps.setInt (3, instituicao.getId()); 
            ps.execute(); 
        } 
    }   
    
    public void atualizarItem(Item item) throws Exception{
        String sql = "UPDATE tb_item SET nome = ?, descricao = ? WHERE id = ?";
        try(Connection conexao = ConexaoBD.obterConexao();
            PreparedStatement ps = conexao.prepareStatement(sql)){
        ps.setString(1, item.getNome());
        ps.setString(2, item.getDescricao());
        ps.setInt(3, item.getId());
        ps.execute();       
        }
    }
    
    public void removerInstituicao (Instituicao instituicao) throws Exception{ 
        String sql = "DELETE FROM tb_instituicao WHERE id = ?"; 
        try (Connection conexao = ConexaoBD.obterConexao(); 
                PreparedStatement ps = conexao.prepareStatement(sql);){ 
            ps.setInt (1, instituicao.getId()); 
            ps.execute(); 
        } 
    }

    public void removerItem (Item item) throws Exception{
        String sql = "DELETE FROM tb_item WHERE id = ?";
        try(Connection conexao = ConexaoBD.obterConexao();
            PreparedStatement ps = conexao.prepareStatement(sql);){
           ps.setInt(1, item.getId());
           ps.execute();
        }
    }

    public List<Item> buscaItemPorInstituicao(Instituicao instituicao) throws Exception{ 
        String sql = "SELECT tb_item.id, tb_item.nome, tb_item.descricao FROM tb_item INNER " 
       + "JOIN tb_instituicao_item ON tb_item.id = tb_instituicao_item.id_item WHERE id_instituicao" 
       + "= ?"; 
        List <Item> itens = new ArrayList<> (); 
        try (Connection conexao = ConexaoBD.obterConexao(); 
                PreparedStatement ps = conexao.prepareStatement(sql)){ 
            ps.setInt (1, instituicao.getId()); 
            try (ResultSet rs = ps.executeQuery()){ 
                while (rs.next()){ 
                    int id = rs.getInt("id"); 
                    String nome = rs.getString ("nome"); 
                    String descricao = rs.getString ("descricao"); 
                    itens.add(new Item (id, nome, descricao)); 
                } 
            } 
        }   
        return itens; 
    }     
    
}