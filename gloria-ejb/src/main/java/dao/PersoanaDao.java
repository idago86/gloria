/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import db.PersoanaDB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Israel Dago
 */
@Stateless
public class PersoanaDao extends AbstractFacade<PersoanaDB> {

    @PersistenceContext(unitName = "com.idago_gloria-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PersoanaDao() {
        super(PersoanaDB.class);
    }
    
}
