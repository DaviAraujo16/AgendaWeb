var botao = document.querySelector("#bt-criar");



botao.addEventListener('click', function(){

    
    
    var formulario = document.querySelector("#usuario")
    var usuario = {
        nome: formulario.querySelector("#txt-nome").value,
        nascimento: formulario.querySelector("#txt-nascimento").value,
        sexo: formulario.querySelector("#txt-sexo").value,
        email: formulario.querySelector("#txt-email").value,
        senha1: formulario.querySelector("#txt-senha1").value,
        senha2: formulario.querySelector("#txt-senha1").value 
    }
    var erros = validaUsuarios(usuario);

    var ul= document.querySelector("#mensagens-erro")
    ul.textContent="";

    if(erros.length > 0){
        mudarCor();

        //Associa uma classe do css com um elemento html criado no js
        ul.classList.add("pt-2");

         //Cancela a função/evento do elemento(nesse caso cancela a função do botão)
         event.preventDefault();
        for(var i = 0; i < erros.length ;i++){
            //Criar um elemento html pelo js!
            var li = document.createElement("li")
            
            //Coloca um conteúdo de texto 
            li.textContent = erros[i];
          
            //Adiciona um elemento filho a um elemento pai 
            ul.appendChild(li)
        }
    }
});


function mudarCor(){
    botao.style.background = "rgb(252, 215, 3)";
    botao.style.color = "black";
}




