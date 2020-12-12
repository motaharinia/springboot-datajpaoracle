package com.motaharinia.business.service.adminuser;

import com.motaharinia.persistence.orm.etcitem.EtcItem;
import org.springframework.stereotype.Component;

/**
 * User: https://github.com/motaharinia<br>
 * Date: 2020-12-12 <br>
 * Time: 23:46:40 <br>
 * Description: <br>
 * این کلاس مبدل تفاوتهای داده های سامانه با سامانه بانک است
 */
@Component
public class AdminUserBankConverter {
    /**
     * این متد به شناسه جنسیت ده عدد اضافه میکند چون شناسه جنسیت در بانک بجای 1 و 2 از اعداد 11 و 12 استفاده میکند
     *
     * @param etcItem جنسیت
     * @return خروجی: شناسه اصلاح شده
     */
    public Integer convertGenderId(EtcItem etcItem) {
        return etcItem.getId() + 10;
    }
}
