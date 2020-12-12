package com.motaharinia.business.service.adminuser;


import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.motaharinia.msjpautility.search.SearchRowView;
import com.motaharinia.msjpautility.search.annotation.SearchDataColumn;
import com.motaharinia.persistence.orm.adminuser.AdminUser;
import org.springframework.beans.factory.annotation.Value;

import java.util.Date;


@JsonDeserialize(as = AdminUser.class)
public interface AdminUserSearchViewTypeBrief extends SearchRowView {

    @SearchDataColumn(index = 1, name = "id")
    Integer getId();


    @SearchDataColumn(index = 2, name = "firstName")
    String getFirstName();


    @SearchDataColumn(index = 3, name = "lastName")
    String getLastName();

    @SearchDataColumn(index = 4, name = "dateOfBirth")
    Date getDateOfBirth();

    @SearchDataColumn(index = -1, name = "defaultAdminUserContact")
    DefaultAdminUserContact getDefaultAdminUserContact();

    interface DefaultAdminUserContact {
        @SearchDataColumn(index = 5, name = "address")
        String getAddress();
    }

    @SearchDataColumn(index = -1, name = "gender")
    EtcItem getGender();

    interface EtcItem {
        @Value("#{@adminUserBankConverter.convertGenderId(target)}")
        @SearchDataColumn(index = 6, name = "id")
        Integer getId();
    }

    @Override
    default String toOut() {
        return this.getId() + "," + this.getFirstName() + "," + this.getLastName() + "," + getDateOfBirth() + "," + this.getDefaultAdminUserContact().getAddress();
    }
}
