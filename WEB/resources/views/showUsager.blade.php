@extends('template')

@section('contenu')
    <div class="col-sm-offset-3 col-sm-5">
    	<br>
		<div class="panel panel-primary">
			<div class="panel-heading">Fiche du Contact</div>
			<div class="panel-body">
        <p>N° d'usager : {{ $usager->IdLecteur }}</p>
        <p>Nom : {{ $usager->NomUsager }}</p>
        <p>Prénom : {{ $usager->PrenomUsager }}</p>
        <p>Adresse : {{ $usager->Adresse }}</p>
        <p>Email : {{ $usager->AdresseMail }}</p>
        <p>Date d'inscription : {{ $usager->DateInscription }}</p>
        <p>Cotisation : {{ $usager->Cotisation }}</p>
        <p>Nombre de prets : {{ $usager->NombrePrets }}</p>
        <!-- <p>Administration : {{ $usager->Admin }} </p> -->
        @if($usager->Admin == 1)
					Admin
				@endif

  </div>
		</div>
		<a href="javascript:history.back()" class="btn btn-primary">
			<span class="glyphicon glyphicon-circle-arrow-left"></span> Retour
		</a>
	</div>
@endsection
