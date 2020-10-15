<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>Document</title>

   <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB"
        crossorigin="anonymous">
</head>
<body>
  
<?php
$nome = $_REQUEST['nome'];
$sobrenome = $_REQUEST['sobrenome'];
$usuario = $_REQUEST['usuario'];
$senha = $_REQUEST['senha'];




if(!empty($nome) && !empty($sobrenome) && !empty($usuario) && !empty($senha)){
$ds = ldap_connect("10.42.0.1116"); // assuming the LDAP server is on this host

if ($ds) {
// bind with appropriate dn to give update access
ldap_set_option($ds, LDAP_OPT_PROTOCOL_VERSION, 3);
$r = ldap_bind($ds, "cn=admin, dc=bersondev, dc=net", "unitins");

// prepare data
$info["cn"] = "$sobrenome";
$info["sn"] = "$nome";
$info["objectclass"] = "top";
$info["objectclass"] = "person";
$info["objectclass"] = "organizationalPerson";
$info["userPassword"] = "$senha";


// add data to directory
$r = ldap_add($ds, "cn=$sobrenome, dc=bersondev, dc=net", $info);

//fechar conexão
ldap_close($ds);
?>
  <div class="container">
  <div class="alert alert-success" role="alert">
  <h4 class="alert-heading">Sucesso!</h4>
  <p>Usuário Salvo com sucesso</p>
  <hr>
  <p class="mb-0">Success!</p>
  </div>
<?php
}  else { ?>
  <div class="container">
    <div class="alert alert-danger" role="alert">
    <h4 class="alert-heading">Erro!</h4>
    <p>Nāo foi possivel acessar a base de dados ldap</p>
    <hr>
    <p class="mb-0">Consulte seu AD</p>
    </div>
<?php
}
} else{ ?>

<div class="container">
    <div class="alert alert-warning" role="alert">
    <h4 class="alert-heading">Atençāo!</h4>
    <p>Há algum campo em branco.</p>
    <hr>
    <p class="mb-0">Verificar campos do formulario.</p>
    </div>

 <?php 
}
?>

  <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
  crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
  crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js" integrity="sha384-smHYKdLADwkXOn1EmN1qk/HfnUcbVRZyYmZ4qpPea6sjB/pTJ0euyQp0Mk8ck+5T"
  crossorigin="anonymous"></script>
</body>
</html>