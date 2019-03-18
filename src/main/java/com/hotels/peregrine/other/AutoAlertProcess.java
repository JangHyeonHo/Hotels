package com.hotels.peregrine.other;

import org.springframework.ui.Model;

public class AutoAlertProcess {
	
	/** 
	 * 자동으로 Alert창을 띄워주고 Redirect시켜주는 ClassMethod
	 * model, 타이틀명(head 타이틀명), 경고창 내용(script 경고창내용), 경고창 후 어디로 리다이렉트 시킬것인지(script location.href="주소")
	 * 작성하는 것으로 사용할 수 있다.
	 * 
	 * @param model Spring의 모델객체 불러오기
	 * @param title 홈페이지 Head에 사용되는 타이틀명
	 * @param alert 홈페이지에서 띄울 경고창 내용
	 * @param redirectPath 경고창 뜬 후에 어디로 Redirect시킬 것인지 경로 작성
	 * 
	 * @return AlertProcessJspFile.jsp를 리턴한다
	 */
	public static String alertAfterRedirect(Model model, String title, String alert, String redirectPath) {
		model.addAttribute("headTitle", title);
		model.addAttribute("alertWindow", alert);
		model.addAttribute("redirectPath",redirectPath);
		return "AlertProcessJspFile";
	}
}	
