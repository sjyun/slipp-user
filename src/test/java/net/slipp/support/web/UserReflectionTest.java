package net.slipp.support.web;

import static org.junit.Assert.*;
import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;

public class UserReflectionTest {

	@Test
	public void handlerMappingTest() {
		MockHttpServletRequest request = new MockHttpServletRequest();
		
		request.setRequestURI("/user/LoginForm.do");
		assertEquals(UserLoginForm.class.getName(), getHandlerName(request));
		
		request.setRequestURI("/user/Login.do");
		assertEquals(UserLogin.class.getName(), getHandlerName(request));
		
		request.setRequestURI("/user/JoinForm.do");
		assertEquals(UserJoinForm.class.getName(), getHandlerName(request));
		
		request.setRequestURI("/user/Join.do");
		assertEquals(UserJoin.class.getName(), getHandlerName(request));
	}

	private String getHandlerName(MockHttpServletRequest request) {
		StringBuffer clsName = new StringBuffer("net.slipp.support.web.User");
		clsName.append(
				request.getRequestURI().substring(
						request.getRequestURI().lastIndexOf("/")+1
					  , request.getRequestURI().lastIndexOf("."))).append("Handler");
		return clsName.toString();
	}

}