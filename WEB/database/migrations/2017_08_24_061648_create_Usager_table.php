<?php

use Illuminate\Database\Migrations\Migration;
use Illuminate\Database\Schema\Blueprint;

class CreateUsagerTable extends Migration {

	/**
	 * Run the migrations.
	 *
	 * @return void
	 */
	public function up()
	{
		Schema::create('Usager', function(Blueprint $table)
		{
			$table->integer('IdLecteur', true);
			$table->string('NomUsager')->nullable();
			$table->string('PrenomUsager')->nullable();
			$table->string('Adresse')->nullable();
			$table->string('AdresseMail')->nullable();
			$table->date('DateInscription')->nullable();
			$table->integer('Cotisation')->nullable();
			$table->integer('NombrePrets')->nullable();
			$table->boolean('Admin')->nullable();
		});
	}


	/**
	 * Reverse the migrations.
	 *
	 * @return void
	 */
	public function down()
	{
		Schema::drop('Usager');
	}

}
