package com.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 描述: 密码工具，系统默认采用明文存储,可以自动装配一个加密的
 *
 * @author : xiandafu
 */
@Configuration
@ConditionalOnMissingBean(PasswordConfig.PasswordEncryptService.class)
public class PasswordConfig {

	
	public static interface PasswordEncryptService{
		public String password(String pwd);
	}
	
	
	public static class DefaultEncryptBean implements PasswordEncryptService {

		@Override
		public String password(String pwd) {
			// 采用明文，系统应该提供自己的EncryptBean实现以代替默认
			return pwd;
		}
		
	}
	
	@Bean
	public PasswordEncryptService passwordEncryptBean(){
		return new DefaultEncryptBean();
	}

}
