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
			while ((msg = br.readLine()) != null) {
				String[] arrayMsg = msg.replaceAll("\"", "").split(",");
				if(arrayMsg[0].equals("번호")) {
					continue;
				}
				msgList.add(new DistributorDTO()
						.setDisPhone(arrayMsg[15])
						.setDisName(arrayMsg[21])
						.setDisZipCode(arrayMsg[17])
						.setDisNZipCode(arrayMsg[20])
						.setDisAddr(arrayMsg[18])
						.setDisNAddr(arrayMsg[19])
						.setDisRegDate(format.parse(arrayMsg[5])));
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
