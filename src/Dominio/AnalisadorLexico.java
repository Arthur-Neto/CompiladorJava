package Dominio;

import Infra.TabelaSimbolos;
import Infra.TabelaTokens;

/**
 *
 * @author Aluno
 */
public class AnalisadorLexico {

    private static TabelaSimbolos _tabelaSimbolos;
    private static TabelaTokens _tabelaTokens;

    public AnalisadorLexico(TabelaSimbolos tabelaSimbolos, TabelaTokens tabelaTokens) {
        AnalisadorLexico._tabelaSimbolos = tabelaSimbolos;
        AnalisadorLexico._tabelaSimbolos.AddSimbolo(new Simbolo("algoritmo"));
        AnalisadorLexico._tabelaSimbolos.AddSimbolo(new Simbolo("var"));
        AnalisadorLexico._tabelaSimbolos.AddSimbolo(new Simbolo("inicio"));
        AnalisadorLexico._tabelaSimbolos.AddSimbolo(new Simbolo("fimalgoritmo"));
        AnalisadorLexico._tabelaSimbolos.AddSimbolo(new Simbolo("inteiro"));
        AnalisadorLexico._tabelaSimbolos.AddSimbolo(new Simbolo("real"));
        AnalisadorLexico._tabelaSimbolos.AddSimbolo(new Simbolo("caractere"));
        AnalisadorLexico._tabelaSimbolos.AddSimbolo(new Simbolo("logico"));
        AnalisadorLexico._tabelaSimbolos.AddSimbolo(new Simbolo("vetor"));
        AnalisadorLexico._tabelaTokens = tabelaTokens;
    }

    public void criarTabelaTokens(String codigo) {
        codigo = codigo.toLowerCase();
        TabelaSimbolos tabelaSimbolos = new TabelaSimbolos();
        TabelaTokens tabelaTokens = new TabelaTokens();

        String palavraOuDigito = "";
        for (int i = 0; i < codigo.length(); i++) {
            switch (codigo.charAt(i)) {
                case ')':
                    tabelaTokens.addToken(new Token(i, ")"));
                    break;
                case '(':
                    tabelaTokens.addToken(new Token(i, "("));
                    break;
                case '{':
                    tabelaTokens.addToken(new Token(i, "{"));
                    break;
                case '}':
                    tabelaTokens.addToken(new Token(i, "}"));
                    break;
                case '[':
                    tabelaTokens.addToken(new Token(i, "["));
                    break;
                case ']':
                    tabelaTokens.addToken(new Token(i, "]"));
                    break;
                case '+':
                    tabelaTokens.addToken(new Token(i, TipoToken.OPERADOR.name()));
                    break;
                case '%':
                    tabelaTokens.addToken(new Token(i, "%"));
                    break;
                case '/':
                    tabelaTokens.addToken(new Token(i, "/"));
                    break;
                case '|':
                    tabelaTokens.addToken(new Token(i, "|"));
                    break;
                case '-':
                    tabelaTokens.addToken(new Token(i, TipoToken.OPERADOR.name()));
                    break;
                case '.':
                    tabelaTokens.addToken(new Token(i, "."));
                    break;
                case '*':
                    tabelaTokens.addToken(new Token(i, TipoToken.OPERADOR.name()));
                    break;
                case '\"':
                    tabelaTokens.addToken(new Token(i, "\""));
                    break;
                case '!':
                    tabelaTokens.addToken(new Token(i, "!"));
                    break;
                case '&':
                    tabelaTokens.addToken(new Token(i, "&"));
                    break;
                case '?':
                    tabelaTokens.addToken(new Token(i, "?"));
                    break;
                case '#':
                    tabelaTokens.addToken(new Token(i, "#"));
                    break;
                case '<':
                    tabelaTokens.addToken(new Token(i, "<"));
                    break;
                case '>':
                    tabelaTokens.addToken(new Token(i, ">"));
                    break;
                case ',':
                    tabelaTokens.addToken(new Token(i, ","));
                    break;
                case ';':
                    tabelaTokens.addToken(new Token(i, ";"));
                    break;
                case ':':
                    tabelaTokens.addToken(new Token(i, ":"));
                    break;
                default:
                    if (Character.isLetter(codigo.charAt(i)) || Character.isDigit(codigo.charAt(i))) {
                        palavraOuDigito = palavraOuDigito + codigo.charAt(i);
                    }

                    if (Character.isWhitespace(codigo.charAt(i))) {
                        Simbolo adicionado = new Simbolo(palavraOuDigito);
                        //int i = tabelaSimbolos.ComparaSimboloList(adicionado);
                        tabelaSimbolos.AddSimbolo(adicionado);
                        tabelaTokens.addToken(new Token(i, palavraOuDigito));
                        palavraOuDigito = "";

                        break;
                    }
                    break;
            }
        }
        _tabelaTokens = tabelaTokens;
        _tabelaSimbolos = tabelaSimbolos;
    }

}
