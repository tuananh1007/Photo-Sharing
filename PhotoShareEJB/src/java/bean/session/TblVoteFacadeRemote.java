/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package bean.session;

import bean.entity.TblVote;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Dell
 */
@Remote
public interface TblVoteFacadeRemote {

    void create(TblVote tblVote);

    void edit(TblVote tblVote);

    void remove(TblVote tblVote);

    TblVote find(Object id);

    List<TblVote> findAll();

    List<TblVote> findRange(int[] range);

    int count();

}
