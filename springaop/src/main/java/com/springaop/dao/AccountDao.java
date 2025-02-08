package com.springaop.dao;

import com.springaop.entity.Account;

public interface AccountDao {

	 void addAccount(Account theAccount, boolean vipFlag);

	    boolean doWork();

	    public String getName();

	    public void setName(String name);

	    public String getServiceCode();

	    public void setServiceCode(String serviceCode);
}
