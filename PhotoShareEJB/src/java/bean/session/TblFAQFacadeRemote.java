/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package bean.session;

import bean.entity.TblFAQ;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Dell
 */
@Remote
public interface TblFAQFacadeRemote {

    void create(TblFAQ tblFAQ);

    void edit(TblFAQ tblFAQ);

    void remove(TblFAQ tblFAQ);

    TblFAQ find(Object id);

    List<TblFAQ> findAll();

    List<TblFAQ> findRange(int[] range);

    int count();

}
