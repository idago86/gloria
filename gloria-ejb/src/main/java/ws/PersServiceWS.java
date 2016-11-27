/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebService;
import service.PersoaneService;
import dto.PersoanaDTO;
import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;


/**
 *
 * @author Israel Dago
 */
@Stateless
@WebService
public class PersServiceWS {

    @EJB private PersoaneService service;
    
    @WebMethod
    public void adaugaPersoane(@WebParam String nume, @WebParam String prenume, @WebParam String cnp){
        PersoanaDTO pers = new PersoanaDTO(nume, prenume, cnp);
        service.adaugaPersoane(pers);
    }
    
    @WebMethod
    public void removePersoane(@WebParam String PersoanaID){
        service.removePersoane(PersoanaID);
    }
    
    
    @WebMethod
    public List<PersoanaDTO> getPersoane(){
        return service.getPersoane();
    }
    
    
}
