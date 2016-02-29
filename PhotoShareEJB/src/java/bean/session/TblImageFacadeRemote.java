/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package bean.session;

import bean.entity.TblImage;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Dell
 */
@Remote
public interface TblImageFacadeRemote {

    void create(TblImage tblImage);

    void edit(TblImage tblImage);

    void remove(TblImage tblImage);

    TblImage find(Object id);

    List<TblImage> findAll();

    List<TblImage> findRange(int[] range);

    int count();

    List<TblImage> searchImageByname(String imgName,int[] range);

    int countImageByName(String iname);

    List<TblImage> findImageByUserID(String userid);

    List<TblImage> topDownload();

    List<TblImage> findByUserID_Pagination(String username, int[] range);

    int countByUsername(String username);

    void delImage(int iid);

    List<TblImage> topDownloadPaging(int[] rang);

    List<TblImage> topNewPaging(int[] range);


}
