package com.hotels.peregrine.other;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import org.springframework.web.multipart.MultipartFile;

public class AutoFileClassfication {
	
	public static ClassifiedFile OnefileClassficationing(MultipartFile file, String directory) {
		//자동 파일 분류 시스템
		//웹에서 받아온 파일을 자동으로 이름, 저장할 이름, 파일 사이즈를 계산해서 넣어줌

		//단일 파일 분류시스템 1개의 파일 이름과 파일 저장할 이름등을 분류해서 만들어줌
		//ClassifiedFile 변수명 = AutoFileClassfication.OnefileClassficationing(멀티파트파일, 저장할 디렉토리);
		//위 방식으로 사용가능
		ClassifiedFile fileNaming = new ClassifiedFile();
		fileNaming.setFileOriginName(file.getOriginalFilename());
		String extension = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
		fileNaming.setFileStoreName(UUID.randomUUID().toString().replaceAll("-", "") + extension);
		fileNaming.setFileSize(file.getSize());
		try {
			file.transferTo(new File(directory+fileNaming.getFileStoreName()));
		} catch (IllegalStateException | IOException e) {
			// TODO Auto-generated catch block
			System.out.println("파일 전송 실패");
		}
		return fileNaming;
	}
	
	public static File CSVFiling(MultipartFile file, String directory) {
		String extension = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
		SimpleDateFormat formating = new SimpleDateFormat("yyyy-MM-dd[hhmm]");
		String storeFileNaming = formating.format(new Date()) + "backUpFile" + extension;
		File filing = new File(directory + storeFileNaming);
		filing.mkdirs();
		System.out.println(filing.getAbsolutePath());
		try {
			file.transferTo(filing);
			System.out.println("file업로드 성공");
		} catch (IllegalStateException | IOException e) {
			// TODO Auto-generated catch block
			System.out.println("파일 업로드 실패");
			return null;
		}
		return filing;
	}
	
}
