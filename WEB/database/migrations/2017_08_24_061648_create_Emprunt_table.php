<?php

use Illuminate\Database\Migrations\Migration;
use Illuminate\Database\Schema\Blueprint;

class CreateEmpruntTable extends Migration {

	/**
	 * Run the migrations.
	 *
	 * @return void
	 */
	public function up()
	{
		Schema::create('Emprunt', function(Blueprint $table)
		{
			$table->integer('IdEmprunt', true);
			$table->string('IdCote', 11)->index('FK_Emprunt_IdCote');
			$table->integer('IdLecteur')->index('FK_Emprunt_IdLecteur');
			$table->date('Date_Emprunt')->nullable();
			$table->date('Date_Rendu')->nullable();
			$table->date('Date_Relance')->nullable();
		});
	}


	/**
	 * Reverse the migrations.
	 *
	 * @return void
	 */
	public function down()
	{
		Schema::drop('Emprunt');
	}

}
