function validaUsuarios (usuario){
    //TEST
    var erros = [];
    
    if(usuario.nome.length < 5 ){
        erros.push("O nome deve ter pelo menos 5 caracteres.");
    }

    if(usuario.nascimento.length == 0){
        erros.push("A data de nascimento é obrigatória.")    
    }
    
    if(usuario.email.length < 7){
        erros.push("O email é obrigatório.")
    }
    
    if(usuario.sexo =="Selcione"){
        erros.push("Selecione um sexo.")
    }
    
    if (usuario.senha1.length < 8){
        erros.push("A senha deve conter pelo menos 8 caracteres.")        
    }
    if (usuario.senha2.length < 8){
        erros.push("A confirmação da senha deve conter pelo menos 8 caracteres.")        
    }
    if(usuario.senha1 != usuario.senha2){
        erros.push("As senhas não correspondem.")
    }
    
    return erros;
    
}


