<?php

namespace App\Repositories;

use App\Documents;

/**
 *
 */
class DocumentsRepository
{
  protected $Documents;

  public function __construct(Documents $Documents)
  {
    $this->Documents = $Documents;
  }

  private function save(Documents $Documents, Array $inputs)
  {
    $Documents->Titre = $inputs['Titre'];
    $Documents->Auteur = $inputs['Auteur'];
    $Documents->typeDoc = $inputs['typeDoc'];
    $Documents->Genre = $inputs['Genre'];
    $Documents->Disponible = $inputs['Disponible'];
    $Documents->Caution = $inputs['Caution'];
    
    $Documents->save();
  }

  public function getPaginate($n)
  {
    return $this->Documents->paginate($n);
  }

  public function store(Array $inputs)
  {
    $Documents = new $this->Documents;

    $this->save($Documents, $inputs);

    return $Documents;
  }

  public function getById($IdCote)
  {
    return $this->Documents->findOrFail($IdCote);
  }

  public function update($IdCote, Array $inputs)
  {
    $this->save($this->getById($IdCote), $inputs);
  }

  public function destroy($IdCote)
  {
    $this->getById($IdCote)->delete();
  }

}
