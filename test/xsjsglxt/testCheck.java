package xsjsglxt;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.xsjsglxt.domain.DO.xsjsglxt_appraisal_letter;
import com.xsjsglxt.domain.DO.xsjsglxt_check_entrustment_book;
import com.xsjsglxt.domain.DO.xsjsglxt_identifieder_case_confirm_book;
import com.xsjsglxt.domain.DO.xsjsglxt_inspection_record;
import com.xsjsglxt.domain.DO.xsjsglxt_not_acceptance_entrustment_inform;
import com.xsjsglxt.domain.VO.InspectionIdentification.EntrustmentBookManagementVO;
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
		EntrustmentBookManagementVO checkEntrustmentBookVO = new EntrustmentBookManagementVO();
		checkEntrustmentBookVO.setSearch("20170006");
		checkEntrustmentBookVO = inspectionIdentificationService.getListCheckEntrustmentBook(checkEntrustmentBookVO);
	}

	// 测试批量删除
	@Test
	public void deleteTest() {
		List<String> listtt = new ArrayList<>();
		listtt.add("8fbd9a0c-6aeb-431a-a5ef-dc541535ed26");
		listtt.add("2bc8bcad-5849-474b-9be2-a105c3f7c519");
		int i = inspectionIdentificationService.deleteListCheckEntrustmentBook(listtt);
		System.out.println(i);
	}

	// 测试填写确认书
	@Test
	public void addConfirmBook() {
		xsjsglxt_identifieder_case_confirm_book identifiederCaseConfirmBook = new xsjsglxt_identifieder_case_confirm_book();
		identifiederCaseConfirmBook
				.setIdentifieder_case_confirm_book_belong_entrustment_book("c1edfb16-44b3-4e18-8220-de738469bc87");
		System.out
				.println(inspectionIdentificationService.saveIdentifiederCaseConfirmBook(identifiederCaseConfirmBook));

	}

	// 填写拒绝
	@Test
	public void addNotAcceptance() {
		xsjsglxt_not_acceptance_entrustment_inform notAcceptanceEntrustmentInform = new xsjsglxt_not_acceptance_entrustment_inform();
		notAcceptanceEntrustmentInform
				.setNot_acceptance_entrustment_inform_belong_entrustment_book("c1edfb16-44b3-4e18-8220-de738469bc87");
		System.out.println(inspectionIdentificationService.saveNotAcceptanceInform(notAcceptanceEntrustmentInform));
	}

	// 填写检验记录
	@Test
	public void addInspectionRecord() {
		xsjsglxt_inspection_record inspection_record = new xsjsglxt_inspection_record();
		inspection_record.setInspection_belong_entrustment_book("c7da5063-8209-42b4-a12d-8c490075b41d");
		System.out.println(inspectionIdentificationService.saveInspectionRecord(inspection_record));
	}

	// 填写鉴定书
	@Test
	public void addAppraisalLetter() {
		xsjsglxt_appraisal_letter xsjsglxt_appraisal_letter = new xsjsglxt_appraisal_letter();
		xsjsglxt_appraisal_letter.setAppraisal_letter_belong_entrustment_book("c7da5063-8209-42b4-a12d-8c490075b41d");
		System.out.println(inspectionIdentificationService.saveAppraisalLetter(xsjsglxt_appraisal_letter));
	}

}
