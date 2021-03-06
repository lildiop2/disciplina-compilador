public class identificador {

    /* Lê o próximo caractere do arquivo */
    private void readch() throws IOException {
        ch = (char) file.read();
    }

    public Token scan() throws IOException {
        // Desconsidera delimitadores na entrada
        for (;; readch()) {
            if (ch == ' ' || ch == '\t' || ch == '\r' || ch == '\b')
                continue;
            else if (ch == '\n')
                line++; // conta linhas
            else
                break;
        }

        // Identificadores
        if (Character.compare(ch, '$') == 0) {
            StringBuffer sb = new StringBuffer();
            sb.append(ch);
            readch();
            if (Character.isLetter(ch)) {
                do {
                    sb.append(ch);
                    readch();
                } while (Character.isLetterOrDigit(ch));
                String s = sb.toString();
                Word w = (Word) words.get(s);
                if (w != null)
                    return w; // palavra já existe na HashTable
                w = new Word(s, Tag.ID);
                words.put(s, w);
                return w;
            }else{
                return new Error("Token não existe")
            }
        }

        // Caracteres não especificados
        Token t = new Token(ch);
        ch = ' ';
        return t;
    }

}
