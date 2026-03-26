package com.mycompany.desafiobim;

import com.google.cloud.firestore.*;
import java.util.HashMap;
import java.util.Map;

public class LivroDAL {

private static Firestore db;

public static void conecta()
{
    db = FirebaseConnection.conecta();
}

public static void desconecta()
{
}

public static void inseriLivro(Livro _umlivro)
{
  try {

    Map<String,Object> dados = new HashMap<>();

    dados.put("titulo", _umlivro.getTitulo());
    dados.put("autor", _umlivro.getAutor());
    dados.put("editora", _umlivro.getEditora());
    dados.put("ano", _umlivro.getAnoEdicao());

    db.collection("livros")
      .document(_umlivro.getTitulo())
      .set(dados);

  } catch(Exception e){
      Erro.setErro(e.getMessage());
  }
}

public static void consultaLivro(Livro _umlivro)
{
  try {

    DocumentSnapshot document =
    db.collection("livros")
      .document(_umlivro.getTitulo())
      .get()
      .get();

    if(document.exists())
    {
        _umlivro.setAutor(document.getString("autor"));
        _umlivro.setEditora(document.getString("editora"));
        _umlivro.setAnoEdicao(document.getString("ano"));
    }
    else
    {
        Erro.setErro("Livro não encontrado");
    }

  } catch(Exception e){
      Erro.setErro(e.getMessage());
  }
}

public static void deletaLivro(Livro _umlivro)
{
  try {

    db.collection("livros")
      .document(_umlivro.getTitulo())
      .delete();

  } catch(Exception e){
      Erro.setErro(e.getMessage());
  }
}

public static void alteraLivro(Livro _umlivro)
{
  try {

    Map<String,Object> dados = new HashMap<>();

    dados.put("autor", _umlivro.getAutor());
    dados.put("editora", _umlivro.getEditora());
    dados.put("ano", _umlivro.getAnoEdicao());

    db.collection("livros")
      .document(_umlivro.getTitulo())
      .update(dados);

  } catch(Exception e){
      Erro.setErro(e.getMessage());
  }
}

}
