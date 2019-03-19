package com.hotels.peregrine.other;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.hotels.peregrine.model.DistributorDTO;

public class CSVFileUploader {

	public static List<DistributorDTO> csvFileReader(File file) {

		FileReader fr = null;
		BufferedReader br = null;
		try {
			fr = new FileReader(file);
			br = new BufferedReader(fr);
			String msg;
			List<DistributorDTO> msgList = new ArrayList<DistributorDTO>();
			SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
			int result = 0;
			while ((msg = br.readLine()) != null) {
				if(result==2500) {
					break;
				}
				String[] arrayMsg = msg.split(",");
				if(arrayMsg[0].equals("\"번호\"")) {
					continue;
				}
				msgList.add(new DistributorDTO()
						.setDisPhone(arrayMsg[15].replaceAll("\"", ""))
						.setDisName(arrayMsg[21].replaceAll("\"", ""))
						.setDisZipCode(arrayMsg[17].replaceAll("\"", ""))
						.setDisNZipCode(arrayMsg[20].replaceAll("\"", ""))
						.setDisAddr(arrayMsg[18].replaceAll("\"", ""))
						.setDisNAddr(arrayMsg[19].replaceAll("\"", ""))
						.setDisRegDate(format.parse(arrayMsg[5].replaceAll("\"", ""))));
				result++;
			}
			return msgList;
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (fr != null) fr.close();
				if (br != null) br.close();
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}

		}
		return null;
	}
}
