/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.PersoanaDao;
import db.PersoanaDB;
import dto.PersoanaDTO;
import java.util.List;
import java.util.stream.Collectors;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import remote.IPersoanaService;


/**
 *
 * @author Israel Dago
 */
@Stateless
public class PersoaneService implements IPersoanaService{

    @EJB private PersoanaDao persoanaDao;

    @Override
    public void adaugaPersoane(PersoanaDTO personaDTO) {
        PersoanaDB pers = new PersoanaDB();
        pers.setCnp(personaDTO.getCnp());
        pers.setNume(personaDTO.getNume());
        pers.setPrenume(personaDTO.getPrenume());
        persoanaDao.create(pers);
    }

    @Override
    public void removePersoane(String personaID) {
        PersoanaDB pers = persoanaDao.find(Integer.parseInt(personaID));
        if(pers!=null){
            persoanaDao.remove(pers);
        }        
    }
    

    @Override
    public List<PersoanaDTO> getPersoane() {
        return persoanaDao.findAll().stream()
                .map(p -> new PersoanaDTO(p.getId(), p.getNume(), p.getPrenume(), p.getCnp()))
                .collect(Collectors.toList());
    }

   
    
    
    
    
}
