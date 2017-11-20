package com.service;/********************************************************************
 /**
 * @Project: zyht_web
 * @Package com.service
 * @author wangzhenxin
 * @date 2017-09-24 13:03
 * @Copyright: 2017 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */

import com.base.BaseServiceImpl;
import com.dao.MybatisPackageInformationDao.MybatisPackPurInformationDao;
import com.dao.PackPurInformationDao;
import com.dao.PackPurInformationDaoImpl;
import com.dao.PackageInformationDao;
import com.dao.PackageInformationDaoImpl;
import com.domain.PackPurInformation;
import com.vo.PackPurInformationVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * @author wangzhenxin
 * @ClassName PackPurInformationServiceImpl
 * @Description PackPurInformationService实现
 * @date 2017-09-24
 */
@Service("packPurInformationService")
@Transactional
public class PackPurInformationServiceImpl extends BaseServiceImpl<Long,PackPurInformation,PackPurInformationVo> implements PackPurInformationService{
//    //定义客户Dao对象
//    @Autowired
//    private PackPurInformationDao packPurInformationDao;

    @Autowired
    private MybatisPackPurInformationDao mybatisPackPurInformationDao;
//    //构造方法
//    public PackPurInformationServiceImpl(){
//        super.setBaseDao(packPurInformationDao);
//    }
    @Override
    public String savePackPurInformation(PackPurInformation packPurInformation) {
        mybatisPackPurInformationDao.insertPackPurInformation(packPurInformation);
        return "添加成功";
    }

    @Override
    public String deletePackPurInformation(PackPurInformation packPurInformation) {
//        deleteById(packPurInformation);
        mybatisPackPurInformationDao.deletePackPurInformation(packPurInformation.getId());
        return "删除成功";
    }

    @Override
    public List<PackPurInformationVo> findPackPurInformation(Long customerId) {

        List<PackPurInformation> packPurInformationList = mybatisPackPurInformationDao.getAllPackPurInformation(customerId);
        List<PackPurInformationVo> packPurInformationVoList = new ArrayList<PackPurInformationVo>();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        for (PackPurInformation purInformation : packPurInformationList) {
            PackPurInformationVo packPurInformationVo = new PackPurInformationVo();
            //设置客户名
            packPurInformationVo.setCustomerName(purInformation.getCustomer().getName());
            //设置套餐名
            packPurInformationVo.setPackageInformationName(purInformation.getPackageInformation().getMealName());
            //设置套餐对象
            packPurInformationVo.setPackageInformation(purInformation.getPackageInformation());
            //设置客户对象
            packPurInformationVo.setCustomer(purInformation.getCustomer());
            //设置购买时间
            packPurInformationVo.setBuyTime(purInformation.getBuyTime());
            String date = null;
            date = simpleDateFormat.format(packPurInformationVo.getBuyTime());
            //设置购买时间字符串
            packPurInformationVo.setBuyTimeStr(date);
            //设置支付金额
            packPurInformationVo.setAmountOfPayment(purInformation.getAmountOfPayment());
            //设置是否购买成功
            packPurInformationVo.setIsSuccess(purInformation.getIsSuccess());
            //设置执行时间
            packPurInformationVo.setEffectTime(purInformation.getEffectTime());
            //设置执行时间字符串
            if (packPurInformationVo.getEffectTime() != null){
                date = simpleDateFormat1.format(packPurInformationVo.getEffectTime());
            }else {
                date = "未执行";
            }
            packPurInformationVo.setEffectTimeStr(date);
            packPurInformationVo.setId(purInformation.getId());
            packPurInformationVoList.add(packPurInformationVo);
        }
        return packPurInformationVoList;
    }
}
