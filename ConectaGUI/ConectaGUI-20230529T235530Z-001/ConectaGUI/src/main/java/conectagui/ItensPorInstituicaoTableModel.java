package conectagui;

import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ItensPorInstituicaoTableModel extends AbstractTableModel { 
 
    private final List <Item> itens; 
    private String [] colunas = {"id", "nome", "descricao"}; 
     
    public ItensPorInstituicaoTableModel (Instituicao instituicao) throws Exception{ 
        DAO dao = new DAO (); 
        this.itens = dao.buscaItemPorInstituicao(instituicao); 
    } 
     
    @Override 
    public int getRowCount() { 
        return itens.size(); 
    } 
 
    @Override 
    public int getColumnCount() { 
        return 3; 
    } 
 
    @Override 
    public Object getValueAt(int rowIndex, int columnIndex) { 
        switch (columnIndex){ 
            case 0: 
                return this.itens.get(rowIndex).getId(); 
            case 1: 
                return this.itens.get(rowIndex).getNome(); 
            case 2: 
                return this.itens.get(rowIndex).getDescricao(); 
            default: 
                return null; 
        } 
    } 
 
    @Override 
    public String getColumnName(int column) { 
        return this.colunas[column]; 
    } 
 } 