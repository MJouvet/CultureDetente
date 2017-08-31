<?php

namespace App\Repositories;

use App\Contact;

/**
 *
 */
class ContactRepository
{
  protected $contact;

  public function __construct(Contact $contact)
  {
    $this->contact = $contact;
  }

  private function save(Contact $contact, Array $inputs)
  {
    $contact->Ste_TCl = $inputs['Ste_TCl'];
    $contact->Entite_TCo = $inputs['Entite_TCo'];
    $contact->Adr_Liv_TCl = $inputs['Adr_Liv_TCl'];
    $contact->Contact_TCo = $inputs['Contact_TCo'];
    $contact->EMail_TCo = $inputs['EMail_TCo'];
    $contact->Tel_TCo = $inputs['Tel_TCo'];
    $contact->Indicatif_TCo = $inputs['Indicatif_TCo'];
    $contact->Port_TCo = $inputs['Port_TCo'];
    $contact->N_Poste = $inputs['N_Poste'];

    $contact->save();
  }

  public function getPaginate($n)
  {
    return $this->contact->paginate($n);
  }

  public function store(Array $inputs)
  {
    $contact = new $this->contact;

    $this->save($contact, $inputs);

    return $contact;
  }

  public function getById($Id_TCo)
  {
    return $this->contact->findOrFail($Id_TCo);
  }

  public function update($Id_TCo, Array $inputs)
  {
    $this->save($this->getById($Id_TCo), $inputs);
  }

  public function destroy($Id_TCo)
  {
    $this->getById($Id_TCo)->delete();
  }

}
