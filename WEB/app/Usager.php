<?php

namespace App;

use Illuminate\Database\Eloquent\Model;

class Usager extends Model
{
    protected $primaryKey = 'IdLecteur';

    protected $table = 'Usager';

    protected $fillable = ['NomUsager','PrenomUsager',
  'Adresse','AdresseMail','DateInscription',
  'Cotisation','NombrePrets','Admin'];

  public $timestamps = false;
}
