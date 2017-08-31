<?php

namespace App\Http\Controllers;

use Request;
use App\Usager;
use App\Repositories\UsagerRepository;
use Illuminate\Support\Facades\DB;

class UsagerController extends Controller
{
    protected $usagerRepository;

    protected $nbrPerPage = 10;

    public function __construct(UsagerRepository $usagerRepository)
    {
      $this->usagerRepository = $usagerRepository;
    }

    /**
     * Display a listing of the resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function index()
    {
        $Usager = $this->usagerRepository->getPaginate($this->nbrPerPage);

        $links = $Usager->render();

        return view ('indexUsager', compact('Usager','links'));
    }

    /**
     * Show the form for creating a new resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function create()
    {
        return view ('createUsager');
    }

    /**
     * Store a newly created resource in storage.
     *
     * @param  \Illuminate\Http\Request  $request
     * @return \Illuminate\Http\Response
     */
    public function store(Request $request)
    {
        $usager = $this->usagerRepository->store($request::all());

        return redirect('usager')->withOk("La fiche a été crée.");
    }

    /**
     * Display the specified resource.
     *
     * @param  int  $IdLecteur
     * @return \Illuminate\Http\Response
     */
    public function show($IdLecteur)
    {
        $usager = $this->usagerRepository->getById($IdLecteur);

        return view ('showUsager', compact('usager'));
    }

    /**
     * Show the form for editing the specified resource.
     *
     * @param  int  $IdLecteur
     * @return \Illuminate\Http\Response
     */
    public function edit($IdLecteur)
    {
        $usager = $this->usagerRepository->getById($IdLecteur);

        return view ('editUsager', compact('usager'));
    }

    /**
     * Update the specified resource in storage.
     *
     * @param  \Illuminate\Http\Request  $request
     * @param  int  $IdLecteur
     * @return \Illuminate\Http\Response
     */
    public function update(Request $request, $IdLecteur)
    {
        $this->usagerRepository->update($IdLecteur, $request::all());

        return redirect ('usager')->withOk("La fiche de l'usager a été modifié.");
    }

    /**
     * Remove the specified resource from storage.
     *
     * @param  int  $IdLecteur
     * @return \Illuminate\Http\Response
     */
    public function destroy($IdLecteur)
    {
        $this->usagerRepository->destroy($IdLecteur);

        return redirect()->back();
    }
}
