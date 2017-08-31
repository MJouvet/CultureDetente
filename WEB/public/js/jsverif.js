
function surligne(champ, erreur) {
  if (erreur)
      champ.style.backgroundColor = "#AE58CF";
   else
      champ.style.backgroundColor = "";
}

function verifNom(champ)
{
   if(champ.value.length < 2 || champ.value.length > 25)
   {
      surligne(champ, true);
      return false;
   }
   else
   {
      surligne(champ, false);
      return true;
   }
}
function verifPrenom(champ)
{
   if(champ.value.length < 2 || champ.value.length > 25)
   {
      surligne(champ, true);
      return false;
   }
   else
   {
      surligne(champ, false);
      return true;
   }
}

function verifAdresse(champ)
{
   if(champ.value.length < 2 || champ.value.length > 50)
   {
      surligne(champ, true);
      return false;
   }
   else
   {
      surligne(champ, false);
      return true;
   }
}

function verifMail(champ)
{
   var regex = /^[a-zA-Z0-9._-]+@[a-z0-9._-]{2,}\.[a-z]{2,4}$/;
   if(!regex.test(champ.value))
   {
      surligne(champ, true);
      return false;
   }
   else
   {
      surligne(champ, false);
      return true;
   }
}

function verif_date(champ) {
    reg = new RegExp(/^[0-9]{4}[\/][0-1]{1}[0-2]{1}[\/][0-3]{1}[0-9]{1}$/);
    if(!reg.test(input)) // check format AAAA/MM/JJ/
      {
         surligne(champ, true);
         return false;
      }
      else
      {
         surligne(champ, false);
         return true;
      }
}

function verifCoti(champ)
{
   var coti = parseInt(champ.value);
   if(isNaN(coti) || coti <= 0 || coti > 30)
   {
      surligne(champ, true);
      return false;
   }
   else
   {
      surligne(champ, false);
      return true;
   }
}
function verifNP(champ)
{
   var nP = parseInt(champ.value);
   if(isNaN(nP) || nP <= 0 || nP > 5)
   {
      surligne(champ, true);
      return false;
   }
   else
   {
      surligne(champ, false);
      return true;
   }
}



function verifForm(f)
{
   var nomOk = verifNom(f.nom);
   var prenomOk = verifPrenom(f.prenom);
   var adresseOk = verifAdresse(f.adresse);
   var mailOk = verifMail(f.email);
   var dateOk = verif_date(f.date);
   var cotiOk = verifCoti(f.cotisation);
   var nPOk = verifNP(f.NbrPret);


   if(nomOk && prenomOk && adresseOk && mailOk && dateOk && cotiOk && nPOk)
      return true;
   else
   {
      alert("Veuillez remplir correctement tous les champs");
      return false;
   }
}
