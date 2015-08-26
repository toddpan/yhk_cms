package com.hm.engine.dao.examniation;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.engine.config.TestConfig;
import com.hm.engine.dao.examniation.domain.Disease;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { TestConfig.class })
public class DiseaseDaoTest {
	private @Autowired DiseaseDao diseaseDao;

	@Test
	public void testSave() throws IOException {
		List<String> list = Files.readAllLines(Paths.get("disease.txt"),
				Charset.defaultCharset());
		for (String string : list) {
			Disease content = new Disease();
			String[] strs = string.split("\\t");
			content.setDiseaseCode(strs[0]);
			content.setDiseaseDecribe(strs[1]);
			diseaseDao.save(content);
		}
	}

}
