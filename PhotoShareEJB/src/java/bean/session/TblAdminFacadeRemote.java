/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package bean.session;

import bean.entity.TblAdmin;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Dell
 */
@Remote
public interface TblAdminFacadeRemote {

    void create(TblAdmin tblAdmin);

    void edit(TblAdmin tblAdmin);

    void remove(TblAdmin tblAdmin);

    TblAdmin find(Object id);

    List<TblAdmin> findAll();

    List<TblAdmin> findRange(int[] range);

    int count();

    int adminLogin(String name, String pass);

}
