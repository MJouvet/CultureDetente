<?php

namespace App;

use Illuminate\Database\Eloquent\Model;

class Documents extends Model
{
    protected $primaryKey = 'IdCote';

    protected $table = 'Documents';

    protected $fillable = ['Titre','Auteur','typeDoc',
    'Genre','Disponible','Caution'];

    public $timestamps = false;
}
