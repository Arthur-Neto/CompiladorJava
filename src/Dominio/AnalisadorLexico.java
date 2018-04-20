package Dominio;

import Infra.TabelaSimbolos;
import Infra.TabelaTokens;

/**
 *
 * @author Aluno
 */
public class AnalisadorLexico {

    public static TabelaSimbolos _tabelaSimbolos;
    public static TabelaTokens _tabelaTokens;
                                       //d l ( ) { } [ ] + - * / \ | & ! % , . ; : = > < ^ 
    private int [][] tabelaTransicao = {{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},//q0
                                        {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},//q1
                                        {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},//q2
                                        {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},//q3
                                        {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},//q4
                                        {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},//q5
                                        {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},//q6
                                        {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},//q7
                                        {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},//q8
                                        {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},//q9
                                        {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},//q10
                                        {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},//q11
                                        {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},//q12
                                        {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},//q13
                                        {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},//q14
                                        {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},//q15
                                        {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},//q16
                                        {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},//q17
                                        {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},//q18
                                        {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},//q19
                                        {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},//q20
                                        {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},//q21
                                        {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},//q22
                                        {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},//q23
                                        {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},//q24
                                        {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},//q25
                                        {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},//q26
                                        {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},//q27
                                        {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},//q28
                                        {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},//q29
                                        {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},//q30
                                        {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},//q31
                                        {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},//q32
                                        {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},//q33
                                        {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},//q34
                                        {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},//q35
                                        {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},//q36
                                        {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},//q37
                                        {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},//q38
                                        {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},//q39
                                        {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},//q40
                                        {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},//q41
                                        {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},//q42
                                        {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},//q43
                                        {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},//q44
                                        {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},//q45
                                        {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},//q46
                                        {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},//q47
                                        {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},//q48
                                        {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},//q49
                                        {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},//q50
                                        {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},//q51
                                        {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},//q52
                                        {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},//q53
                                        {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},//q54
                                        {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},//q55
                                        {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},//q56
                                        {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},//q57
                                        {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},//q58
                                        {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},//q59
                                        {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}};//q60

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

    public static void setTabelaTokens(TabelaTokens _tabelaTokens) {
        AnalisadorLexico._tabelaTokens = _tabelaTokens;
    }    
    
    public void criarTabelas(String codigo) {
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
                        if(tabelaSimbolos.ComparaSimboloList(adicionado)){
                            break;
                        }
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
