/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package bean.session;

import bean.entity.TblQuery;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Dell
 */
@Remote
public interface TblQueryFacadeRemote {

    void create(TblQuery tblQuery);

    void edit(TblQuery tblQuery);

    void remove(TblQuery tblQuery);

    TblQuery find(Object id);

    List<TblQuery> findAll();

    List<TblQuery> findRange(int[] range);

    int count();

    List<TblQuery> getQueryUnAnswer(int[] range);

    int countQueryUnAnswer();

}
