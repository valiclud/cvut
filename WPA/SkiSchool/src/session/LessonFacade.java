/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.Lesson;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Ludvik
 */
@Stateless
public class LessonFacade extends AbstractFacade<Lesson> {
    @PersistenceContext(unitName = "SkiSchoolPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public LessonFacade() {
        super(Lesson.class);
    }
    
}
