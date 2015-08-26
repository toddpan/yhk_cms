package com.hm.engine.dao.examniation;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.engine.config.TestConfig;
import com.hm.engine.dao.examniation.domain.MedicationPrescriptionSchemeMapping;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { TestConfig.class })
public class MedicationPrescriptionSchemeMappingDaoTest {
	@Autowired
	MedicationPrescriptionSchemeMappingDao medicationPrescriptionSchemeMappingDao;

	@Test
	public void test() {
		MedicationPrescriptionSchemeMapping ma = new MedicationPrescriptionSchemeMapping();
//		medicationPrescriptionSchemeMappingDao.findOne("", "");
		ma.setMedicationPrescriptionId(1000l);
		ma.setMedicationSchemeId(1000l);
		
		medicationPrescriptionSchemeMappingDao.save(ma);
	}

}
