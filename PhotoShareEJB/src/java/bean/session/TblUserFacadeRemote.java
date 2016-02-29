/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package bean.session;

import bean.entity.TblUser;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Dell
 */
@Remote
public interface TblUserFacadeRemote {

    void create(TblUser tblUser);

    void edit(TblUser tblUser);

    void remove(TblUser tblUser);

    TblUser find(Object id);

    List<TblUser> findAll();

    List<TblUser> findRange(int[] range);

    int count();

    int login(String userid, String password);
    public List<TblUser> listNewUser();

    void delUser(String uid);

    List<TblUser> listNewUserPaging(int[] range);

    int countValidatedUser();

    List<TblUser> listUserNotApproved(int[] range);

    int countAccountByEmail(String email);
}
