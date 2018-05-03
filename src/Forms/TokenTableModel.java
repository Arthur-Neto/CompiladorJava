package Forms;

import Dominio.Token;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Arthur
 */
public class TokenTableModel extends AbstractTableModel {

    private List<Token> tokens;

    public TokenTableModel(List<Token> tokens) {
        this.tokens = tokens;
    }

    @Override
    public int getRowCount() {
        return tokens.size();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Token token = tokens.get(rowIndex);
        Object value = null;
        switch (columnIndex) {
            case 0:
                value = token.getId();
                break;
            case 1:
                value = token.getTipo();
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
