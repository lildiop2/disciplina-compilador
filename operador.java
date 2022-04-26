public class operador{
 
 /*Lê o próximo caractere do arquivo*/
 private void readch() throws IOException{
    ch = (char) file.read();
    } 
 
 /* Lê o próximo caractere do arquivo e verifica se é igual a c*/
 private boolean readch(char c) throws IOException{
 readch();
 if (ch != c) return false;
 ch = ' ';
 return true;
 } 
 
 public Token scan() throws IOException{
	 //Desconsidera delimitadores na entrada
	 for (;; readch()) {
	 if (ch == ' ' || ch == '\t' || ch == '\r' || ch == '\b') continue;
	 else if (ch == '\n') line++; //conta linhas
	 else break;
	 }
	 switch(ch){
	 //Operadores
	 case '!':
	 if (readch('=')) return Word.ne;
	 else return new Token('!');
	 case '>':
	 if (readch('>')) return Word.mgt;
	 else return new Token('>');
        }
    }
}