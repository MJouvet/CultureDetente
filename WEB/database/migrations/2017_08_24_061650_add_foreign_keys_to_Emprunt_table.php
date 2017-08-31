<?php

use Illuminate\Database\Migrations\Migration;
use Illuminate\Database\Schema\Blueprint;

class AddForeignKeysToEmpruntTable extends Migration {

	/**
	 * Run the migrations.
	 *
	 * @return void
	 */
	public function up()
	{
		Schema::table('Emprunt', function(Blueprint $table)
		{
			$table->foreign('IdCote', 'FK_Emprunt_IdCote')->references('IdCote')->on('Documents')->onUpdate('RESTRICT')->onDelete('RESTRICT');
			$table->foreign('IdLecteur', 'FK_Emprunt_IdLecteur')->references('IdLecteur')->on('Usager')->onUpdate('RESTRICT')->onDelete('RESTRICT');
		});
	}


	/**
	 * Reverse the migrations.
	 *
	 * @return void
	 */
	public function down()
	{
		Schema::table('Emprunt', function(Blueprint $table)
		{
			$table->dropForeign('FK_Emprunt_IdCote');
			$table->dropForeign('FK_Emprunt_IdLecteur');
		});
	}

}
