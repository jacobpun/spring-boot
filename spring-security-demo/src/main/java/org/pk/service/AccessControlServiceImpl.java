package org.pk.service;

import org.springframework.stereotype.Service;

@Service(value = "accessControlService")
public class AccessControlServiceImpl implements AccessControlService {
	
	@Override
	public boolean canAccessUser(long id) {
        //TODO
		return true;
	}
}