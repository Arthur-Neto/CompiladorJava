package Infra;

import Dominio.Simbolo;
import Dominio.TipoToken;
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
    
    
    
//    public TipoToken tipoToken(Simbolo simbolo){
//        if(simbolo.getNome().equalsIgnoreCase("+") || simbolo.getNome().equalsIgnoreCase("-") || simbolo.getNome().equalsIgnoreCase("/") || simbolo.getNome().equalsIgnoreCase("*")) {
//            return TipoToken.OPERADOR;
//        } else if(simbolo.getNome().equalsIgnoreCase(",") || simbolo.getNome().equalsIgnoreCase(";")){
//            return TipoToken.SEPARADOR;
//        }
//        
//        return TipoToken.
//    }

    public List<Token> getTabelaTokens() {
        return tabelaTokens;
    }

    public void setTabelaTokens(List<Token> tabelaTokens) {
        this.tabelaTokens = tabelaTokens;
    }
    
}
