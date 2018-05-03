package Infra;

import Dominio.Token;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Arthur
 */
public class TabelaTokens {
    private List<Token> tabelaTokens;

    public TabelaTokens() {
        this.tabelaTokens = new ArrayList<>();
    }
    
    public void addToken(Token token){
        this.tabelaTokens.add(token);
    }

    public List<Token> getTabelaTokens() {
        return tabelaTokens;
    }

    public void setTabelaTokens(List<Token> tabelaTokens) {
        this.tabelaTokens = tabelaTokens;
    }
    
}
