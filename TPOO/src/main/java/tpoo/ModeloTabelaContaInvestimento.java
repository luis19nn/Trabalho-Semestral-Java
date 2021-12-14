package tpoo;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ModeloTabelaContaInvestimento extends AbstractTableModel {
    private String[] colunas = new String[]{"Saldo", "Dono", "Depósito Mínimo", "Montante Mínimo"};
    private List<ContaInvestimento> lista = new ArrayList();

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
        ContaInvestimento conta = lista.get(rowIndex);
        
        switch (columnIndex) {
            case 0: return conta.getSaldo();
            case 1: return conta.getDono().getNome();
            case 2: return conta.getDepositoMinimo();
            case 3: return conta.getMontanteMinimo();
            default : return null;
        }
    }

    public void adicionaContaInvestimento(ContaInvestimento conta) {
        this.lista.add(conta);
        this.fireTableRowsInserted(lista.size()-1, lista.size()-1);//update JTable
        System.out.println(this.lista.size());
    }
    
    public boolean removeContaInvestimento(ContaInvestimento conta) {
        int linha = this.lista.indexOf(conta);
        boolean result = this.lista.remove(conta);
        this.fireTableRowsDeleted(linha, linha);//update JTable
        return result;
    }

    public void atualizarTabela(List<ContaInvestimento> lista){
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

    public ContaInvestimento getContaInvestimento(int linha){
        return lista.get(linha);
    }    
}
