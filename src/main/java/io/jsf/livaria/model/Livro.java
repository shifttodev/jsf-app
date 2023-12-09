package io.jsf.livaria.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Livro {
    private Integer id;
    @NonNull
    private String isbn;
    @NonNull
    private String titulo;
    @NonNull
    private String autor;
    @NonNull
    private Integer ano;

    @Override
    public String toString(){
        return String.format(
                "%03d %13s %-30s %-30s %d",
                this.id, this.isbn, this.titulo, this.autor, this.ano
        );
    }

    public String action(){
        boolean success = true;

        FacesContext context = FacesContext.getCurrentInstance();

        if (isbn != null){
            for (int i = 0; i < isbn.length(); i++){
                char c = isbn.charAt(i);
                if (Character.isLetter(c)){
                    String msg = "Digite somente caracteres númericos!";
                    FacesMessage message = new FacesMessage(msg);
                    context.addMessage("form", message);
                    success = false;
                    break;
                }
            }
        } else {
            success = false;
        }

        return (success ? "success" : "fail");
    }
}
