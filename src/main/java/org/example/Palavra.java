package org.example;

public class Palavra implements Comparable<Palavra>
{
    private String texto;

    public Palavra (String texto) throws Exception
    {
        if (texto == null || (texto.length() == 0))
            throw new Exception ("Palavra vazia");
        this.texto = texto;
    }

    public int getQuantidade (char letra)
    {
        int counter = 0;
        for (int i=0; i < getTamanho(); i++)
        {
            if (this.texto.charAt(i) == letra) counter++;
        }
        return counter;
    }

    public int getPosicaoDaIezimaOcorrencia (int i, char letra) throws Exception
    {
        int qtd = getQuantidade(letra);
        int counter = 0, j;

        if(i>this.texto.length()) throw new Exception("Palavra menor que ocorrencia requisitada.");
        if (qtd == 0)  throw new Exception("Letra nao encontrada.");
        if (i + 1 > qtd)  throw new Exception("Numero de ocorrencias menor que o requisitado.");

        for (j = 0; j < this.texto.length(); j++)
        {
            if (this.texto.charAt(j) == letra) {
                if (counter == i) break;
                counter++;
            }
        }
        return j;
    }

    public int getTamanho ()
    {
        return this.texto.length();
    }

    @Override
    public String toString ()
    {
        return this.texto;
    }

    @Override
    public boolean equals (Object obj)
    {
        if(this == obj) return true;
        if(obj == null) return false;
        if(this.getClass() != obj.getClass()) return false;
        if(this.texto != ((Palavra) obj).texto) return false;
        return true;
    }

    @Override
    public int hashCode ()
    {
        int ret = 672;

        if (this.texto !=null)
            ret = 7*ret + this.texto.hashCode();

        if (ret<0) ret=-ret;

        return ret;
    }

    public int compareTo (Palavra palavra)
    {
        return this.texto.compareTo(palavra.texto);
    }
}
