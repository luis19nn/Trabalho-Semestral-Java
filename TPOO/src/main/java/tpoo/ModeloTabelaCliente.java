package tpoo;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ModeloTabelaCliente extends AbstractTableModel {
    private String[] colunas = new String[]{"Nome", "Sobrenome", "RG", "CPF", "Salário", "Endereço"};
    private List<Cliente> lista = new ArrayList();

    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return this.colunas.length;
    }

    @Override
    public String getColumnName(int index) {
        return this.colunas[index];
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Cliente cliente = lista.get(rowIndex);
        
        switch (columnIndex) {
            case 0: return cliente.getNome();
            case 1: return cliente.getSobrenome();
            case 2: return cliente.getRG();
            case 3: return cliente.getCPF();
            case 4: return cliente.getSalario();
            case 5: return cliente.getEndereco() ;
            default : return null;
        }
    }

    public void adicionaCliente(Cliente cliente) {
        this.lista.add(cliente);
        this.fireTableRowsInserted(lista.size()-1, lista.size()-1);//update JTable
        System.out.println(this.lista.size());
    }
    
    public boolean removeCliente(Cliente cliente) {
        int linha = this.lista.indexOf(cliente);
        boolean result = this.lista.remove(cliente);
        this.fireTableRowsDeleted(linha, linha);//update JTable
        return result;
    }

    public void atualizarTabela(List<Cliente> lista){
        this.lista = new ArrayList();
        this.lista.addAll(lista);
        this.fireTableDataChanged();
    }

    public void limpaTabela() {
        int indice = lista.size()-1;
        
        if(indice < 0)
            indice = 0;
        
        this.lista = new ArrayList();
        this.fireTableRowsDeleted(0, indice);//update JTable
    }

    public Cliente getCliente(int linha){
        return lista.get(linha);
    }
}
