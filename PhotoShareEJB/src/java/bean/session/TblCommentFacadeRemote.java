/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package bean.session;

import bean.entity.TblComment;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author bkc
 */
@Remote
public interface TblCommentFacadeRemote {

    void create(TblComment tblComment);

    void edit(TblComment tblComment);

    void remove(TblComment tblComment);

    TblComment find(Object id);

    List<TblComment> findAll();

    List<TblComment> findRange(int[] range);

    int count();

    List findByImageID(int id);

    void delCommentByID(int cid);

}
