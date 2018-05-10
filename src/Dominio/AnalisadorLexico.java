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

    private final int[][] tabelaTransicao = {
        // 0  1  2  3   4  5  6  7  8  9 10 11 12 13 14 15 16 17 18 
        // d  l  (   )  [  ]  +  -  *  /  %  ,  .  :  =  >  <  " #13
        {3, 1, 24, 25, 42, 41, 8, 12, 26, 16, 21, 43, 1, 44, 29, 32, 35, 38, -1},//q0
        {1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, -1},//q1
        {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},//q2
        {3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5, 4, 4, 4, 4, 4, 4},//q3
        {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},//q4
        {6, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},//q5
        {6, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7},//q6
        {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},//q7
        {3, 11, 11, 11, 11, 11, 9, 11, 11, 11, 11, 11, 11, 11, 10, 11, 11, 11, 11},//q8
        {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},//q9
        {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},//q10
        {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},//q11
        {3, 15, 15, 15, 15, 15, 15, 13, 15, 15, 15, 15, 15, 15, 14, 15, 15, 15, 15},//q12
        {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},//q13
        {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},//q14
        {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},//q15
        {19, 19, 19, 19, 19, 19, 19, 19, 19, 17, 19, 19, 19, 19, 20, 19, 19, 19, 19},//q16
        {17, 17, 17, 17, 17, 17, 17, 17, 17, 17, 17, 17, 17, 17, 17, 17, 17, 17, 18},//q17
        {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},//q18
        {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},//q19
        {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},//q20
        {22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 23, 22, 22, 22, 22},//q21
        {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},//q22
        {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},//q23
        {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},//q24
        {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},//q25
        {28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 28, 27, 28, 28, 28, 28},//q26
        {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},//q27
        {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},//q28
        {31, 31, 31, 31, 31, 31, 31, 31, 31, 31, 31, 31, 31, 31, 30, 31, 31, 31, 31},//q29
        {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},//q30
        {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},//q31
        {33, 33, 33, 33, 33, 33, 33, 33, 33, 33, 33, 33, 33, 33, 34, 33, 33, 33, 33},//q32
        {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},//q33
        {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},//q34
        {36, 36, 36, 36, 36, 36, 36, 36, 36, 36, 36, 36, 36, 36, 37, 36, 36, 36, 36},//q35
        {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},//q36
        {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},//q37
        {38, 38, 38, 38, 38, 38, 38, 38, 38, 38, 38, 38, 38, 38, 38, 38, 38, 39, 40},//q38
        {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},//q39
        {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},//q40
        {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},//q41
        {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},//q42
        {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},//q43
        {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1}};//q44

    public AnalisadorLexico() {
        AnalisadorLexico._tabelaSimbolos = new TabelaSimbolos();
        AnalisadorLexico._tabelaSimbolos.AddSimbolo(new Simbolo("algoritmo"));
        AnalisadorLexico._tabelaSimbolos.AddSimbolo(new Simbolo("var"));
        AnalisadorLexico._tabelaSimbolos.AddSimbolo(new Simbolo("inicio"));
        AnalisadorLexico._tabelaSimbolos.AddSimbolo(new Simbolo("fimalgoritmo"));
        AnalisadorLexico._tabelaSimbolos.AddSimbolo(new Simbolo("inteiro"));
        AnalisadorLexico._tabelaSimbolos.AddSimbolo(new Simbolo("real"));
        AnalisadorLexico._tabelaSimbolos.AddSimbolo(new Simbolo("caractere"));
        AnalisadorLexico._tabelaSimbolos.AddSimbolo(new Simbolo("logico"));
        AnalisadorLexico._tabelaSimbolos.AddSimbolo(new Simbolo("vetor"));
        AnalisadorLexico._tabelaTokens = new TabelaTokens();
    }

    public static void setTabelaTokens(TabelaTokens _tabelaTokens) {
        AnalisadorLexico._tabelaTokens = _tabelaTokens;
    }

    public void adicionaTabela(String codigo) {
        codigo = codigo.toLowerCase();

        Simbolo simbolo;

        int estado = 0;
        String lexema = "";

        for (int i = 0; i < codigo.length(); i++) {

            while (estado != -1) {

                if (i >= codigo.length()) {
                    break;
                }
                if (Character.isWhitespace(codigo.charAt(i))) {
                    break;
                } else if (Character.isDigit(codigo.charAt(i))) {
                    estado = tabelaTransicao[estado][pegaColuna('d')];

                } else if (Character.isLetter(codigo.charAt(i))) {
                    estado = tabelaTransicao[estado][pegaColuna('l')];

                } else {
                    estado = tabelaTransicao[estado][pegaColuna(codigo.charAt(i))];
                }
                if (estado == -1) {
                    break;
                }
                lexema += codigo.charAt(i);
                i++;
            }
            if (!lexema.isEmpty()) {
                simbolo = new Simbolo(lexema);
                if (!_tabelaSimbolos.ComparaSimboloList(simbolo)) {
                    _tabelaSimbolos.AddSimbolo(simbolo);
                }
                _tabelaTokens.addToken(new Token(0, lexema));
            }
            lexema = "";
            estado = 0;
        }
    }

    public int pegaColuna(char caracter) {
        switch (caracter) {
            case '(':
                return 2;
            case ')':
                return 3;
            case '[':
                return 4;
            case ']':
                return 5;
            case '+':
                return 6;
            case '-':
                return 7;
            case '*':
                return 8;
            case '/':
                return 9;
            case '%':
                return 10;
            case ',':
                return 11;
            case '.':
                return 12;
            case ':':
                return 13;
            case '=':
                return 14;
            case '>':
                return 15;
            case '<':
                return 16;
            case '"':
                return 17;
            case '\n':
                break;
            case '\0':
                break;
            case 'd':
                return 0;
            case 'l':
                return 1;
            default:
                break;
        }
        return -1;
    }
}
