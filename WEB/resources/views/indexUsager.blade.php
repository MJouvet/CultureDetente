@extends('template')

@section('contenu')
    <br>
    <div class="col-sm-offset-3 col-sm-7">
    	<!-- @if(session()->has('ok')) -->
			<!-- <div class="alert alert-success alert-dismissible">{!! session('ok') !!}</div> -->
		<!-- @endif -->
		<div class="panel panel-primary">
			<div class="panel-heading">
				<h3 class="panel-title">Liste des usagers</h3>
			</div>
			<table class="table">
				<thead>
					<tr>
						<th>Id usager</th>
						<th>Nom</th>
            <th>Prénom</th>
            <!-- <th>Adresse</th> -->
						<!-- <th>AdresseMail</th> -->
            <th>Date d'Inscription</th>
            <!-- <th>Cotisation</th> -->
            <!-- <th>Nombre Prets</th> -->
            <!-- <th>Admin</th> -->
            <th></th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					@foreach ($Usager as $usager)
						<tr>
							<td>{!! $usager->IdLecteur !!}</td>
						  <td class="text-primary"><strong>{!! $usager->NomUsager !!}</strong></td>
              <td class="text-primary"><strong>{!! $usager->PrenomUsager !!}</strong></td>
              <!-- <td class="text-primary"><strong>{!! $usager->Adresse !!}</strong></td> -->
              <!-- <td class="text-primary"><strong>{!! $usager->AdresseMail !!}</strong></td> -->
              <td class="text-primary"><strong>{!! $usager->DateInscription !!}</strong></td>
              <!-- <td class="text-primary"><strong>{!! $usager->Cotisation !!}</strong></td> -->
              <!-- <td class="text-primary"><strong>{!! $usager->NombrePrets !!}</strong></td> -->
              <!-- <td class="text-primary"><strong>{!! $usager->Admin !!}</strong></td> -->


							<td>{!! link_to_route('usager.show', 'Voir', [$usager->IdLecteur], ['class' => 'btn btn-success btn-block']) !!}</td>
							<td>{!! link_to_route('usager.edit', 'Modifier', [$usager->IdLecteur], ['class' => 'btn btn-warning btn-block']) !!}</td>
							<td>
								{!! Form::open(['method' => 'DELETE', 'route' => ['usager.destroy', $usager->IdLecteur]]) !!}
									{!! Form::submit('Supprimer', ['class' => 'btn btn-danger btn-block', 'onclick' => 'return confirm(\'Vraiment supprimer ce usager ?\')']) !!}
								{!! Form::close() !!}
							</td>
						</tr>
					@endforeach
	  			</tbody>
			</table>

		</div>
		{!! link_to_route('usager.create', 'Ajouter un usager', [], ['class' => 'btn btn-info pull-right']) !!}
		{!! $links !!}
	</div>
@endsection
