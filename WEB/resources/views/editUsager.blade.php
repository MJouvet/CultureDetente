@extends('template')

@section('contenu')
    <div class="col-sm-offset-4 col-sm-4">
    	<br>
		<div class="panel panel-primary">
			<div class="panel-heading">Modification d'un Usager</div>
			<div class="panel-body">
				<div class="col-sm-12">
					{!! Form::model($usager, ['route' => ['usager.update', $usager->Id_TCa], 'method' => 'put', 'class' => 'form-horizontal panel']) !!}
					<div class="form-group {!! $errors->has('NomUsager') ? 'has-error' : '' !!}">
					  	{!! Form::text('NomUsager', null, ['class' => 'form-control', 'placeholder' => 'Nom']) !!}
					  	{!! $errors->first('NomUsager', '<small class="help-block">:message</small>') !!}
					</div>

          <div class="form-group {!! $errors->has('PrenomUsager') ? 'has-error' : '' !!}">
					  	{!! Form::text('PrenomUsager', null, ['class' => 'form-control', 'placeholder' => 'Prénom']) !!}
					  	{!! $errors->first('PrenomUsager', '<small class="help-block">:message</small>') !!}
					</div>

          <div class="form-group {!! $errors->has('Adresse') ? 'has-error' : '' !!}">
					  	{!! Form::text('Adresse', null, ['class' => 'form-control', 'placeholder' => 'Adresse']) !!}
					  	{!! $errors->first('Adresse', '<small class="help-block">:message</small>') !!}
					</div>

          <div class="form-group {!! $errors->has('AdresseMail') ? 'has-error' : '' !!}">
					  	{!! Form::text('AdresseMail', null, ['class' => 'form-control', 'placeholder' => 'Email']) !!}
					  	{!! $errors->first('AdresseMail', '<small class="help-block">:message</small>') !!}
					</div>

          <div class="form-group">
					  	{!! Form::date('DateInscription', null, ['class' => 'form-control', 'placeholder' => 'Date d Inscription']) !!}
          </div>

          <div class="form-group">
					  	{!! Form::text('Cotisation', null, ['class' => 'form-control', 'placeholder' => 'Cotisation']) !!}

					</div>

          <div class="form-group">
					  	{!! Form::text('NombrePrets', null, ['class' => 'form-control', 'placeholder' => 'NombrePrets']) !!}

					</div>

					<div class="form-group">
						<div class="checkbox">
              <label>{!! Form::checkbox('Admin', 1, null) !!} Admin </label>
            </div>
					</div>

						{!! Form::submit('Envoyer', ['class' => 'btn btn-primary pull-right']) !!}
					{!! Form::close() !!}
				</div>
			</div>
		</div>
		<a href="javascript:history.back()" class="btn btn-primary">
			<span class="glyphicon glyphicon-circle-arrow-left"></span> Retour
		</a>
	</div>
@endsection
