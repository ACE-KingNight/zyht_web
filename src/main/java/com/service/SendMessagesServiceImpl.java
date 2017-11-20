package com.service;/********************************************************************
 /**
 * @Project: JavaWorkSpaces
 * @Package mobile_package.service
 * @author wangzhenxin
 * @date 2017-08-20 10:53
 * @Copyright: 2017 www.zyht.com Inc. All rights reserved.
 * @version V1.0
 */



import com.domain.Customer;
import com.domain.Messages;
import com.enumeration.MessagesEnum;
import com.enumeration.MessagesTariffEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author wangzhenxin
 * @ClassName SendMessagesServiceImpl
 * @Description 发送短信service实现
 * @date 2017-08-20
 */
@Service("sendMessagesService")
@Transactional
public class SendMessagesServiceImpl implements SendMessagesService {
    //定义客户信息service
    @Resource
    CustomerService customerService;
    //定义短信发送service
    @Resource
    MessagesService messagesService;
    /**
     * @Title: sendMessages
     * @Description: 用户批量发送短信
     * @author wangzhenxin
     * @date 2017-08-20
     * @param sendCustomer 发送客户信息
     * @param messageContent 短信内容
     * @param customerList 接受客户集合
     */
    @Override
    public String sendMessages(Customer sendCustomer, List<Customer> customerList,String messageContent) {
        //判断接受客户电话号码集合不为空
        if (customerList!=null && customerList.size()>0){
            //定义发送短信集合
            List<Messages> messagesList = new ArrayList<Messages>();
            //定义短信条数
            int messagesNumber = 1;
            //定义用户消费金额
            double consumption = 0d;

            sendCustomer = customerService.selectCustomer(sendCustomer);
            //根据发送客户电话号码集合循环
            for (int i = 0; i < customerList.size(); i++) {
                //定义发送短信对象
                Messages sendMessages = new Messages();
                Messages receiveMessages = new Messages();
                //设置发送短信客户信息
                sendMessages.setSendCustomer(sendCustomer);
                receiveMessages.setSendCustomer(sendCustomer);
                //设置发送短信时间
                sendMessages.setSendMessagesTime(new Date());
                receiveMessages.setSendMessagesTime(new Date());
                //设置接收短信时间
                sendMessages.setReceiveMessagesTime(new Date());
                receiveMessages.setReceiveMessagesTime(new Date());
                //设置短信类型为短信
                sendMessages.setMessagesType(MessagesEnum.MESSAGES.getType());
                receiveMessages.setMessagesType(MessagesEnum.MESSAGES.getType());
                //设置人员类型
                sendMessages.setCustomerType((byte) 1);
                receiveMessages.setCustomerType((byte) 2);
                //设置短信发送成功
                sendMessages.setIsReceive(true);
                receiveMessages.setIsReceive(null);
                //设置短信内容
                sendMessages.setMessageContent(messageContent);
                receiveMessages.setMessageContent(messageContent);
                //定义接收短信客户
                Customer receiveCustomer = new Customer();
                //根据电话号码查找接收短信客户信息
                receiveCustomer = customerService.selectCustomer(customerList.get(i));
                //判断是否存在接收对象
                if (receiveCustomer == null || sendCustomer.getBalance().doubleValue() < consumption) {
                    //设置短信未发送成功
                    sendMessages.setIsReceive(false);
                } else {
                    //设置接受客户信息
                    sendMessages.setReceiveCustomer(receiveCustomer);
                    receiveMessages.setReceiveCustomer(receiveCustomer);
                    /**
                     * 判断客户发送的信息内容字数，
                     * 如果字数大于70字则发送短信的数量乘以2。
                     */
                    if (messageContent !=null && messageContent != "" && messageContent.length()>0){
                        if (messageContent.length()>70){
                            messagesNumber = messageContent.length()/70+1;
                        }
                    }else {
                        System.out.println("短信内容为空是否发送？");
                    }
                    //设置客户消费金额
                    sendMessages.setConsumption(MessagesTariffEnum.MESSAGES_TARIFF.getTariff().doubleValue() * messagesNumber);
                    //累加客户消费金额
                    consumption = consumption+sendMessages.getConsumption().doubleValue();
                    //将记录添加至短信信息集合
                    messagesList.add(sendMessages);
                    messagesService.saveMessage(receiveMessages);
                }
            }
            //扣除用户费用
            sendCustomer.setBalance(sendCustomer.getBalance().doubleValue()-consumption);
            //更新发送客户信息
            customerService.updateCustomer(sendCustomer);

            //根据短信发送集合更新数据库
            messagesService.updateMessagesByMessagesList(messagesList);
        }
        return "发送成功";
    }
}
