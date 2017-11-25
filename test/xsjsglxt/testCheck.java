package xsjsglxt;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.xsjsglxt.domain.DO.xsjsglxt_check_entrustment_book;
import com.xsjsglxt.domain.VO.InspectionIdentification.CheckEntrustmentBookVO;
import com.xsjsglxt.service.InspectionIdentification.InspectionIdentificationService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext*.xml" })
public class testCheck {
	@Resource
	private InspectionIdentificationService inspectionIdentificationService;

	public void setInspectionIdentificationService(InspectionIdentificationService inspectionIdentificationService) {
		this.inspectionIdentificationService = inspectionIdentificationService;
	}

	// 测试保存
	@Test
	public void testSave() {
		System.out.println("ff");
		xsjsglxt_check_entrustment_book tranceCheckBook = new xsjsglxt_check_entrustment_book();
		tranceCheckBook.setCheck_entrustment_book_type("痕迹检验");
		int k = 0;
		k = inspectionIdentificationService.saveTranceCheckBook(tranceCheckBook);
		System.out.println(k);
	}

	// 测试分页显示
	@Test
	public void listShow() {
		CheckEntrustmentBookVO checkEntrustmentBookVO = new CheckEntrustmentBookVO();
		checkEntrustmentBookVO = inspectionIdentificationService.getListCheckEntrustmentBook(checkEntrustmentBookVO);
		System.out.println(checkEntrustmentBookVO);
	}

	// 测试批量删除
	@Test
	public void deleteTest() {
		List<String> listtt = new ArrayList<>();
		listtt.add("6542b5d9-192e-4e3f-a3a9-5c6d161db939");
		listtt.add("8963e030-541c-416c-90cf-bac688630c25");
		int i = inspectionIdentificationService.deleteListCheckEntrustmentBook(listtt);
		System.out.println(i);
	}

}
