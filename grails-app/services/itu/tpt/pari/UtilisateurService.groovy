package itu.tpt.pari

import grails.gorm.transactions.Transactional

@Transactional
class UtilisateurService {

    List<Utilisateur> getAll(){
        Utilisateur.list();
    }
}
