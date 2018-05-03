package Infra;

import Dominio.Simbolo;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Arthur
 */
public class TabelaSimbolos {

    private List<Simbolo> tabelaSimbolos;

    public TabelaSimbolos() {
        this.tabelaSimbolos = new ArrayList();
    }

    public List<Simbolo> getTabelaSimbolos() {
        return tabelaSimbolos;
    }

    public void setTabelaSimbolos(List<Simbolo> tabelaSimbolos) {
        this.tabelaSimbolos = tabelaSimbolos;
    }

    public void AddSimbolo(Simbolo simbolo) {
        this.tabelaSimbolos.add(simbolo);
    }

    public boolean ComparaSimboloList(Simbolo simboloComparado) {
        for (Simbolo simbolo : tabelaSimbolos) {
            return simboloComparado.getNome().equals(simbolo.getNome());
        }

        return false;
    }

    public int GetIndexSimbolo(Simbolo simboloPesquisar) {
        for (int i = 0; i < tabelaSimbolos.size(); i++) {
            if (tabelaSimbolos.get(i).getNome().equalsIgnoreCase(simboloPesquisar.getNome())) {
                return i;
            } else {
                return -1;
            }
        }
        return -1;
    }
}
