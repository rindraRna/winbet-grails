package itu.tpt.pari

import grails.converters.JSON
import grails.converters.XML
import grails.gorm.transactions.Transactional

@Transactional
class ApiService {
    UtilisateurService utilisateurService

    def administrateurs(def methode, def format) {
        switch (methode) {
            case "GET":
                def users = utilisateurService.getAll()
                return serializeData(users, format)
                break
            default:
                return serializeData("Erreur METHOD NOT ALLOWED: La méthode de la requête n'est pas acceptée", format)
                break
        }
        return serializeData("Erreur NOT ACCEPTABLE: Impossible de servir une réponse", format)
    }

    def serializeData(object, format)
    {
        switch (format)
        {
            case 'json':
            case 'application/json':
            case 'text/json':
                return object as JSON
                break
            case 'xml':
            case 'application/xml':
            case 'text/xml':
                return object as XML
                break
        }
    }
}
