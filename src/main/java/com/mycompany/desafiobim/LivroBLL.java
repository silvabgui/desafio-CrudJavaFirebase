package com.mycompany.desafiobim;

public class LivroBLL {

public static void validaTitulo(char _op, Livro _umlivro)
{
 Erro.setErro(false);
 if (_umlivro.getTitulo().equals(""))
   {Erro.setErro("O campo TITULO é de preenchimento obrigatório..."); return;}

 LivroDAL.conecta();
 if (Erro.getErro()) return;
 switch (_op)
 {
     case 'c':  LivroDAL.consultaLivro(_umlivro); break;
     case 'd':  LivroDAL.deletaLivro(_umlivro); break;    
 }
 LivroDAL.desconecta();
}

public static void validaDados(char _op, Livro _umlivro)
{
 Erro.setErro(false);
 if (_umlivro.getTitulo().equals(""))
   {Erro.setErro("O campo TITULO é de preenchimento obrigatório..."); return;}
 if (_umlivro.getAutor().equals(""))
   {Erro.setErro("O campo AUTOR é de preenchimento obrigatório..."); return;}
 if (_umlivro.getEditora().equals(""))
   {Erro.setErro("O campo EDITORA é de preenchimento obrigatório..."); return;}
 if (_umlivro.getAnoEdicao().equals(""))
   {Erro.setErro("O campo ANO EDICAO é de preenchimento obrigatório..."); return;}
 else
   try
     {
     Integer.parseInt(_umlivro.getAnoEdicao());
     }
   catch (Exception e)
     {
     Erro.setErro("O campo ANO EDICAO deve ser numerico!"); return;
     }
 
 LivroDAL.conecta();
 if (Erro.getErro()) return;
 switch (_op)
 {
     case 'i':  LivroDAL.inseriLivro(_umlivro); break;
     case 'a':  LivroDAL.alteraLivro(_umlivro); break;    
 }
 LivroDAL.desconecta();
 
}

}
