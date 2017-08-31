<?php

use Illuminate\Database\Migrations\Migration;
use Illuminate\Database\Schema\Blueprint;

class CreateDocumentsTable extends Migration {

	/**
	 * Run the migrations.
	 *
	 * @return void
	 */
	public function up()
	{
		Schema::create('Documents', function(Blueprint $table)
		{
			$table->string('IdCote', 11)->primary();
			$table->string('Titre')->nullable();
			$table->string('Auteur')->nullable();
			$table->char('typeDoc', 1)->nullable();
			$table->string('Genre')->nullable();
			$table->boolean('Disponible')->nullable();
			$table->integer('Caution')->nullable();
		});
	}


	/**
	 * Reverse the migrations.
	 *
	 * @return void
	 */
	public function down()
	{
		Schema::drop('Documents');
	}

}
