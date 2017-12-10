package xsjsglxt;

import java.io.File;
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
		checkEntrustmentBookVO.setEntrustmentRequire("2");
		checkEntrustmentBookVO = inspectionIdentificationService.getListCheckEntrustmentBook(checkEntrustmentBookVO);
		System.out.println(checkEntrustmentBookVO.getListEntrustmentBookManagementDTO());
	}

	// 测试批量删除
	@Test
	public void deleteTest() {
		List<String> listtt = new ArrayList<>();
		listtt.add("35615e16-e38a-4eda-9446-9a9b2f3d0e3d");
		int i = inspectionIdentificationService.deleteListCheckEntrustmentBook(listtt);
		System.out.println(i);
	}

	// 测试填写确认书
	@Test
	public void addConfirmBook() {
		xsjsglxt_identifieder_case_confirm_book identifiederCaseConfirmBook = new xsjsglxt_identifieder_case_confirm_book();
		identifiederCaseConfirmBook
				.setIdentifieder_case_confirm_book_belong_entrustment_book("68f67e71-c652-444d-85e4-64b6970029ae");
		System.out
				.println(inspectionIdentificationService.saveIdentifiederCaseConfirmBook(identifiederCaseConfirmBook));

	}

	// 填写拒绝
	@Test
	public void addNotAcceptance() {
		xsjsglxt_not_acceptance_entrustment_inform notAcceptanceEntrustmentInform = new xsjsglxt_not_acceptance_entrustment_inform();
		notAcceptanceEntrustmentInform
				.setNot_acceptance_entrustment_inform_belong_entrustment_book("5562e23a-dc66-4bed-9522-6210fdfcc60a");
		System.out.println(inspectionIdentificationService.saveNotAcceptanceInform(notAcceptanceEntrustmentInform));
	}

	// 填写检验记录
	@Test
	public void addInspectionRecord() {
		xsjsglxt_inspection_record inspection_record = new xsjsglxt_inspection_record();
		inspection_record.setInspection_belong_entrustment_book("35615e16-e38a-4eda-9446-9a9b2f3d0e3d");
		System.out.println(inspectionIdentificationService.saveInspectionRecord(inspection_record));
	}

	// 填写鉴定书
	@Test
	public void addAppraisalLetter() {
		xsjsglxt_appraisal_letter xsjsglxt_appraisal_letter = new xsjsglxt_appraisal_letter();
		xsjsglxt_appraisal_letter.setAppraisal_letter_belong_entrustment_book("35615e16-e38a-4eda-9446-9a9b2f3d0e3d");
		System.out.println(inspectionIdentificationService.saveAppraisalLetter(xsjsglxt_appraisal_letter));
	}

	// 更改委托书
	@Test
	public void updateTranceCheckBook() {
		xsjsglxt_check_entrustment_book tranceCheckBook = new xsjsglxt_check_entrustment_book();
		tranceCheckBook.setXsjsglxt_check_entrustment_book_id("598b97c2-1cbe-400a-9150-3df76acd8c52");
		System.out.println(inspectionIdentificationService.updateTranceCheckBook(tranceCheckBook));
	}

	// 更改确认书
	@Test
	public void updateIdentifiederCaseConfirmBook() {
		xsjsglxt_identifieder_case_confirm_book identifiederCaseConfirmBook = new xsjsglxt_identifieder_case_confirm_book();
		identifiederCaseConfirmBook.setXsjsglxt_identifieder_case_confirm_book_id("5faa0efc-e0ff-4a9e-b0c8-f6ea482fdfad");
		System.out.println(inspectionIdentificationService.updateIdentifiederCaseConfirmBook(identifiederCaseConfirmBook));
	}

	// 更改不受理委托鉴定告知表
	@Test
	public void updateNotAcceptanceInform() {
		xsjsglxt_not_acceptance_entrustment_inform notAcceptanceEntrustmentInform = new xsjsglxt_not_acceptance_entrustment_inform();
		notAcceptanceEntrustmentInform.setXsjsglxt_not_acceptance_entrustment_inform_id("9036e35a-c9f0-4fa3-90f8-3273fa374d76");
		System.out.println(inspectionIdentificationService.updateNotAcceptanceInform(notAcceptanceEntrustmentInform));
	}

	// 更改检验记录表
	@Test
	public void updateInspectionRecord() {
		xsjsglxt_inspection_record inspection_record = new xsjsglxt_inspection_record();
		inspection_record.setXsjsglxt_inspection_record_id("3d69d4aa-e4e2-4b97-95fa-8d5edb72c112");
		System.out.println(inspectionIdentificationService.updateInspectionRecord(inspection_record));
	}

	// 更改鉴定文书
	@Test
	public void updateAppraisalLetter() {
		xsjsglxt_appraisal_letter xsjsglxt_appraisal_letter = new xsjsglxt_appraisal_letter();
		xsjsglxt_appraisal_letter.setXsjsglxt_appraisal_letter_id("7a09b392-78f0-4bcb-b64e-8531bad27ded");
		System.out.println(inspectionIdentificationService.updateAppraisalLetter(xsjsglxt_appraisal_letter));
	}

	// 测试导出委托书
	@Test
	public void testExport() {
		try {
			inspectionIdentificationService.exportTranceCheckBook("14a289b8-7856-40da-a787-f27277573422");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 导出确认书
	@Test
	public void testEEE() {
		try {
			inspectionIdentificationService.exportIdentifiederCaseConfirmBook("58a6031e-501b-4c7f-8272-1bf609ddaf5a");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
