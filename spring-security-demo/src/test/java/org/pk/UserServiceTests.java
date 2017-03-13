package org.pk;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.pk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SpringSecurityDemoApplication.class)
@WebAppConfiguration
public class UserServiceTests {

	@Autowired
	private UserService userService;
	
	@Test
	@WithMockUser(authorities={"ADMIN"})
	public void admin_user_can_access_all_users() {
		userService.getAllUsers();	
	}

	@Test(expected=AccessDeniedException.class)
	@WithMockUser(authorities={"USER"})
	public void normal_user_cannot_access_all_users() {
		userService.getAllUsers();	
	}

	@Test
	@WithMockUser(authorities={"ADMIN"})
	public void admin_can_access_any_user(){
		userService.getUserById(1L);
	}
}