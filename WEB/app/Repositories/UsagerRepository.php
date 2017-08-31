<?php

namespace App\Repositories;

use App\Usager;

/**
 *
 */
class UsagerRepository
{
  protected $usager;

  public function __construct(Usager $usager)
  {
    $this->usager = $usager;
  }

  private function save(Usager $usager, Array $inputs)
  {
    $usager->NomUsager = $inputs['NomUsager'];
    $usager->PrenomUsager = $inputs['PrenomUsager'];
    $usager->Adresse = $inputs['Adresse'];
    $usager->AdresseMail = $inputs['AdresseMail'];
    $usager->DateInscription = $inputs['DateInscription'];
    $usager->Cotisation = $inputs['Cotisation'];
    $usager->NombrePrets = $inputs['NombrePrets'];
    $usager->Admin = isset($inputs['Admin']);

    $usager->save();
  }

  public function getPaginate($n)
  {
    return $this->usager->paginate($n);
  }

  public function store(Array $inputs)
  {
    $usager = new $this->usager;

    $this->save($usager, $inputs);

    return $usager;
  }

  public function getById($IdLecteur)
  {
    return $this->usager->findOrFail($IdLecteur);
  }

  public function update($IdLecteur, Array $inputs)
  {
    $this->save($this->getById($IdLecteur), $inputs);
  }

  public function destroy($IdLecteur)
  {
    $this->getById($IdLecteur)->delete();
  }

}
