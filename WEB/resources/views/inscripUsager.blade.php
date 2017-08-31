<!doctype html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
		<link href="{{ asset('css\bootstrap-theme.css') }}" rel="stylesheet" type="text/css">
		<link href="{{ asset('css\bootstrap.css') }}" rel="stylesheet" type="text/css">
		<link href="{{ asset('/css/CSS-Culture.css') }}" rel="stylesheet" type="text/css">


    <title>MEDIATHEQUE CULTURE&DETENTE </title>

<script type="text/javascript" src="js\jsverif.js"></script>
</head>
<body>
	<div class="col-sm-offset-4 col-sm-4">
		<br>
		<div class="panel panel-primary">
			<div class="panel-heading">Création d'un usager</div>
			<div class="panel-body">
				<div class="col-sm-12">
					<!-- {!! Form::open(['route' => 'usager.store', 'class' => 'form-horizontal panel','onsubmit'=>'return verifForm(this)']) !!} -->
					<form class="form-horizontal panel" action="" method="post" onsubmit="return verifForm(this)">

						<br>
						<input class="form-control" type="text" name="NomUsager" value="" placeholder="Nom" onblur="return verifNom(this)">
						<br><input class="form-control" type="text" name="PrenomUsager" value="" placeholder="Prénom" onblur="return verifPrenom(this)">
						<br><input class="form-control" type="text" name="Adresse" value="" placeholder="Adresse" onblur="return verifAdresse(this)">
						<br><input class="form-control" type="email" name="AdresseMail" value="" placeholder="AdresseMail" onblur="return verifMail(this)">
						<br><input class="form-control" type="date" name="DateInscription" value="" placeholder="Date d'inscription" onblur="return verif_date(this)">
						<br><input class="form-control" type="text" name="Cotisation" value="" placeholder="Cotisation" onblur="return verifCoti(this)">
						<br><input class="form-control" type="text" name="NombrePrets" value="" placeholder="Nombre de Prets" onblur="return verifNP(this)">
						<!-- <div class="form-group">
							<div class="checkbox">
								<label type="checkbox" name="Admin" value="Admin" >Admin</label>
							</div>
						</div> -->
						<div class="form-group">
							<div class="checkbox">
								<label>
									{!! Form::checkbox('Admin', 1, null) !!}Admin
								</label>
							</div>
						</div>
						<input class="btn btn-primary pull-right" type="submit" name="Envoyer" value="Envoyer">

</form>
<script type="text/javascript" src="js\jsverif.js"></script>
					<!-- <div class="form-group {!! $errors->has('NomUsager') ? 'has-error' : '' !!}"> -->
						<!-- {!! Form::text('NomUsager', null, ['class' => 'form-control', 'placeholder' => 'Nom', 'onblur'=>'return verifNom(this)' ]) !!} -->
						<!-- {!! $errors->first('NomUsager', '<small class="help-block">:message</small>') !!} -->
					<!-- </div> -->

					<!-- <div class="form-group {!! $errors->has('PrenomUsager') ? 'has-error' : '' !!}"> -->
						<!-- {!! Form::text('PrenomUsager', null, ['class' => 'form-control', 'placeholder' => 'Prénom', 'onblur'=>'verifPrenom(this)']) !!} -->
						<!-- {!! $errors->first('PrenomUsager', '<small class="help-block">:message</small>') !!} -->
					<!-- </div> -->

					<!-- <div class="form-group {!! $errors->has('Adresse') ? 'has-error' : '' !!}"> -->
						<!-- {!! Form::text('Adresse', null, ['class' => 'form-control', 'placeholder' => 'Adresse', 'onblur'=>'verifAdresse(this)']) !!} -->
						<!-- {!! $errors->first('Adresse', '<small class="help-block">:message</small>') !!} -->
					<!-- </div> -->

					<!-- <div class="form-group {!! $errors->has('AdresseMail') ? 'has-error' : '' !!}"> -->
						<!-- {!! Form::text('AdresseMail', null, ['class' => 'form-control', 'placeholder' => 'Email', 'onblur'=>'verifMail(this)']) !!} -->
						<!-- {!! $errors->first('AdresseMail', '<small class="help-block">:message</small>') !!} -->
					<!-- </div> -->

					<!-- <div class="form-group"> -->
					  	<!-- {!! Form::date('DateInscription', null, ['class' => 'form-control', 'placeholder' => 'Date d Inscription', 'onblur'=>'verif_date(this)']) !!} -->
          <!-- </div> -->

          <!-- <div class="form-group"> -->
					  	<!-- {!! Form::text('Cotisation', null, ['class' => 'form-control', 'placeholder' => 'Cotisation', 'onblur'=>'verifCoti(this)']) !!} -->

					<!-- </div> -->

          <!-- <div class="form-group"> -->
					  	<!-- {!! Form::text('NombrePrets', null, ['class' => 'form-control', 'placeholder' => 'NombrePrets', 'onblur'=>'verifNP(this)']) !!} -->

					<!-- </div> -->


					<!-- <div class="form-group">
						<div class="checkbox">
							<label>
								{!! Form::checkbox('Admin', 1, null) !!}Admin
							</label>
						</div>
					</div> -->
					<!-- {!! Form::submit('Envoyer', ['class' => 'btn btn-primary pull-right', 'type'=>'submit']) !!}
					{!! Form::close() !!} -->
				</div>
			</div>
		</div>
		<a href="javascript:history.back()" class="btn btn-primary">
			<span class="glyphicon glyphicon-circle-arrow-left"></span> Retour
		</a>
	</div>
</body>
</html>
