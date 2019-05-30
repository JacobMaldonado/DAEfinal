/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


window.addEventListener('load', function(){
    document.getElementById('btnIniciar').addEventListener('click', function(){
        var nombre = document.getElementById('txtUsuario').value;
        var contraseña = document.getElementById('txtPassword').value;
        var bandera=false;
        if(nombre.legth >0){
            bandera=true;            
        }
        if(bandera){
            document.getElementById('forminicio').submit();
        }else{
            alert('Por favor rellene todos los campos');
        }
    });
});