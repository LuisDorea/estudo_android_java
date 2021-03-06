package br.com.estudo.listas;

public class Produto {

    private String titulo;
    private String descricao;
    private int img;

    public Produto(String titulo, String descricao, int img) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.img = img;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }
}
