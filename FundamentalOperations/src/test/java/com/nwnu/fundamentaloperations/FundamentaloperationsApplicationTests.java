package com.nwnu.fundamentaloperations;

import com.nwnu.fundamentaloperations.domain.ExpressionEntity;
import com.nwnu.fundamentaloperations.domain.UserEntity;
import com.nwnu.fundamentaloperations.repository.ExpressionRepository;
import com.nwnu.fundamentaloperations.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.logging.Logger;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FundamentaloperationsApplicationTests {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private ExpressionRepository expressionRepository;
	private org.slf4j.Logger logger = LoggerFactory.getLogger(this.getClass());
	@Test
	@Modifying
	public void contextLoads() {
		UserEntity userEntity = new UserEntity();
		userEntity.setUsername("admin5");
		userEntity.setPassword("111");
		userRepository.save(userEntity);
		//logger.debug(userRepository.findByUsername("admin5").toString());
	}

	@Test
	public void findByType(){
		List<ExpressionEntity> expressionEntities = expressionRepository.findByTypeTwenty("1");
		logger.info(expressionEntities.toString());
	}

}
