package com.hm.engine.dao.examniation;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.engine.config.TestConfig;
import com.hm.engine.dao.examniation.domain.RuleDic;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { TestConfig.class })
public class RuleDicDaoTest {
	@Autowired RuleDicDao ruleDicDao;
	@Test
	public void testSave() {
		//fail("Not yet implemented");
//		ruleDicDao
		RuleDic ruleDic =new RuleDic();
		
//		ruleDicDao.save();
//		符号id	符号
		ruleDic.setId(1);ruleDic.setName("小于");
		RuleDic ruleDic1 =new RuleDic();
		ruleDicDao.save(ruleDic);
		ruleDic1.setId(2);ruleDic1.setName("小于等于");
		ruleDicDao.save(ruleDic1);
		RuleDic ruleDic2 =new RuleDic();
		ruleDic2.setId(4);ruleDic2.setName("大于等于");
		ruleDicDao.save(ruleDic2);
		RuleDic ruleDic3 =new RuleDic();
		ruleDic3.setId(8);	ruleDic3.setName("大于");
		ruleDicDao.save(ruleDic3);
		RuleDic ruleDic4 =new RuleDic();
		ruleDic4.setId(9);ruleDic4.setName("区间不包括端点");
		ruleDicDao.save(ruleDic4);
		RuleDic ruleDic5 =new RuleDic();
		ruleDic5.setId(5);	ruleDic5.setName("区间不包括左，包括右端");
		ruleDicDao.save(ruleDic5);
		
		RuleDic ruleDic6 =new RuleDic();
		
		ruleDic6.setId(10);ruleDic6.setName("区间包括左端，不包括右端");
		ruleDicDao.save(ruleDic6);
		RuleDic ruleDic7 =new RuleDic();
		ruleDic7.setId(6);	ruleDic7.setName("区间包括端点");
		ruleDicDao.save(ruleDic7);
		RuleDic ruleDic8 =new RuleDic();
		ruleDic8.setId(0);ruleDic8.setName("等于");
		ruleDicDao.save(ruleDic8);

		RuleDic ruleDic16 =new RuleDic();
		ruleDic16.setId(16);
		ruleDic16.setName("小剂量EA");
		ruleDicDao.save(ruleDic16);


		RuleDic ruleDic17 =new RuleDic();
		ruleDic17.setId(16);
		ruleDic17.setName("小剂量小于EA");
		ruleDicDao.save(ruleDic17);

		RuleDic ruleDic24 =new RuleDic();
		ruleDic24.setId(24);
		ruleDic24.setName("小剂量大于EA");
		ruleDicDao.save(ruleDic24);

		RuleDic ruleDic32 =new RuleDic();
		ruleDic32.setId(32);
		ruleDic32.setName("大剂量EA");
		ruleDicDao.save(ruleDic32);

		RuleDic ruleDic33 =new RuleDic();
		ruleDic33.setId(33);
		ruleDic33.setName("大剂量小于EA");
		ruleDicDao.save(ruleDic33);

		RuleDic ruleDic44 =new RuleDic();
		ruleDic44.setId(44);
		ruleDic44.setName("大剂量大于EA");
		ruleDicDao.save(ruleDic44);

	}
public static void main(String[] args) {

	for(int i=0;i<5;i++)
	{
		try {
			if(i==4) {
				System.out.println("Inside Try Block.Exiting without executing Finally block.");
				System.exit(0);
			}
		}
		finally {
			System.out.println("Inside Finally Block.");
		}
	}
}
}
