package Forms;

import Dominio.Simbolo;
import Dominio.Token;
import Infra.TabelaSimbolos;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author PASA
 */
public class SimboloTableModel extends AbstractTableModel {

    private List<Simbolo> simbolos;
    private TabelaSimbolos tabela;

    public SimboloTableModel(List<Simbolo> Simbolos, TabelaSimbolos tabela) {
        this.simbolos = Simbolos;
        this.tabela = tabela;
    }

    @Override
    public int getRowCount() {
        return simbolos.size();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Simbolo simbolo = simbolos.get(rowIndex);
        Object value = null;
        switch (columnIndex) {
            case 0:
                value = tabela.GetIndexSimbolo(simbolo);
                break;
            case 1:
                value = simbolo.getNome();
                break;
        }
        return value;
    }

    @Override
    public String getColumnName(int column) {
        String name = "??";
        switch (column) {
            case 0:
                name = "id";
                break;
            case 1:
                name = "tipo";
                break;
        }
        return name;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        Class type = String.class;
        switch (columnIndex) {
            case 0:
            case 1:
                type = Integer.class;
                break;
        }
        return type;
    }

}
