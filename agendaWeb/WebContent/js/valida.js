var botao = document.querySelector("#bt-criar");



botao.addEventListener('click', function(){
    
    event.preventDefault();
    
    var formulario = document.querySelector("#usuario")
    var usuario ={
        nome: formulario.querySelector("#txt-nome").value,
        nascimento: formulario.querySelector("#txt-nascimento").value,
        sexo: formulario.querySelector("#txt-sexo").value,
        email: formulario.querySelector("#txt-email").value,
        senha1: formulario.querySelector("#txt-senha1").value,
        senha2: formulario.querySelector("#txt-senha1").value 
    }
    
    var erros = validaUsuarios(usuario);
    
    if(erros.length > 0){
        for(var i = 0; i < erros.length;i++ ){
            console.log(erros[i])
        }
    }
    
    
});




